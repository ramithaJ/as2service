/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 *******************************************************************************/
package com.wiley.gr.ace.authorservices.autocomplete.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.BeanComparator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

import com.wiley.gr.ace.authorservices.autocomplete.object.AutocompleteCacheData;
import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.model.CacheData;
import com.wiley.gr.ace.authorservices.persistence.services.UserAutocomplete;
import com.wiley.gr.ace.authorservices.services.service.ASDataService;

/**
 * AutocompleteService provides auto suggestions.
 *
 * @author virtusa
 * @version 1.0
 */
public class AutocompleteServiceImpl implements AutocompleteService {

	/**
	 * Logger Configured.
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AutocompleteServiceImpl.class);

	/** The jedis connection factory. */
	@Autowired(required = true)
	private JedisConnectionFactory jedisConnectionFactory;

	/** The user autocomplete. */
	@Autowired(required = true)
	private UserAutocomplete userAutocomplete;

	@Autowired(required = true)
	private ASDataService asDataService;

	@Value("${autocomplete.count}")
	private String autocompletecount;

	@Value("${titles.key}")
	private String titleskey;

	@Value("${suffixes.key}")
	private String suffixeskey;

	@Value("${industries.key}")
	private String industrieskey;

	@Value("${jobCategories.key}")
	private String jobCategorieskey;

	@Value("${countries.key}")
	private String countrieskey;

	@Value("${states.key}")
	private String stateskey;

	@Value("${institutions.key}")
	private String institutionskey;

	@Value("${departments.key}")
	private String departmentskey;

	@Value("${researchFunders.key}")
	private String researchFunderskey;

	@Value("${societies.key}")
	private String societieskey;

	@Value("${areasOfIntrest.key}")
	private String areasOfIntrestkey;

	/**
	 * Method to get Auto complete data.
	 *
	 * @param key
	 *            - the request value
	 * @param phrase
	 *            - the request value
	 * @param count
	 *            - the request value
	 * @return List
	 *
	 */
	@Override
	public final List<String> getAutocompleteData(final String key,
			String phrase, final Integer count) {
		final Jedis redis = new Jedis(jedisConnectionFactory.getShardInfo());
		if (null == phrase) {
			redis.close();
			return new ArrayList<>();
		}

		final int prefixLength = phrase.length();
		Long start = redis.zrank(key, phrase);
		if (start == null) {
			start = redis.zrank(key, phrase + "*");
			if (start == null) {
				redis.close();
				return null;
			}
		}

		if (start < 0 || prefixLength == 0) {
			redis.close();
			return new ArrayList<>();
		}

		final List<String> results = new ArrayList<String>();
		final int found = 0, rangeLength = 50;
		int maxNeeded = count;
		while (found < maxNeeded) {
			final Set<String> rangeResults = redis.zrange(key, start, start
					+ rangeLength - 1);

			start += rangeLength;
			if (rangeResults.isEmpty()) {
				break;
			}
			for (final String entry : rangeResults) {
				final int minLength = Math.min(entry.length(), prefixLength);
				if (!entry.substring(0, minLength).equalsIgnoreCase(
						phrase.substring(0, minLength))) {
					maxNeeded = results.size();
					break;
				}
				if (entry.endsWith("*") && results.size() < maxNeeded) {
					results.add(entry.substring(0, entry.length() - 1));
				}
			}
		}

		redis.close();
		return results;
	}

	/**
	 * Method to set Auto complete data.
	 *
	 * @param key
	 *            - the request value
	 * @param clear
	 *            - the request value
	 * @return boolean
	 * @throws IOException
	 *             - exception
	 */
	@Override
	public final boolean setAutocompleteData(final String key,
			final Boolean clear) throws IOException {
		final Jedis redis = new Jedis(jedisConnectionFactory.getShardInfo());
		final List<String> societyList = userAutocomplete.getSocietyDetails();
		for (final String word : societyList) {
			if (null != word) {
				addWord(word, redis, key);
			}
		}
		redis.close();
		return true;
	}

	/**
	 * Adds the word.
	 *
	 * @param word
	 *            the word
	 * @param redis
	 *            the redis
	 * @param redisKey
	 *            the redis key
	 *
	 */
	private void addWord(final String word, final Jedis redis,
			final String redisKey) {
		// Add all the possible prefixes of the given word and also the given
		// word with a * suffix.
		redis.zadd(redisKey, 0, word + "*");
		for (int index = 1, total = word.length(); index < total; index++) {
			redis.zadd(redisKey, 0, word.substring(0, index));
		}
	}

	/**
	 * Method to flush.
	 *
	 * @param key
	 *            - the request value
	 * @return boolean
	 */
	@Override
	public final boolean flush(final String key) {
		final Jedis redis = new Jedis(jedisConnectionFactory.getShardInfo());
		redis.del(key);
		redis.close();
		return true;
	}

	/**
	 * Method to retrieve the drop down data
	 * 
	 * @param key
	 * @param phrase
	 * @param offset
	 * @return dropDownList
	 */
	@Override
	public List<CacheData> getDropDownData(final String key, String phrase,
			Integer offset) {
		List<String> dropDownList = null;
		List<CacheData> jsonDropDownList = null;
		AutocompleteCacheData cachedData = null;

		if (offset == null) {
			offset = 0;
		}

		if (phrase != null && !"".equals(phrase.trim())) {
			// Auto Complete
			/*
			 * Key is appended with (auto/cached) to avoid conflict between autocomplete
			 * and caching data. This appended string needs to be removed once a 
			 * solution is found.
			 */
			dropDownList = getAutoCompleteDataFromRedis(key+"auto", phrase, offset);

			if (dropDownList == null) {
				// Get the data from cache if not available in Redis and set it in Redis.
				cachedData = getCachedData(key+"cached");
				dropDownList = cachedData.getCachedDataList();
				if (dropDownList != null) {
					final Jedis redis = new Jedis(
							jedisConnectionFactory.getShardInfo());
					for (String dropDownData : dropDownList) {
						addWord(dropDownData, redis, key+"auto");
					}
					redis.close();
					dropDownList = getAutoCompleteDataFromRedis(key+"auto", phrase,
							offset);
				}
			}

		} else {
			// Cacheable
			/*
			 * Key is appended with (auto/cached) to avoid conflict between autocomplete
			 * and caching data. This appended string needs to be removed once a 
			 * solution is found.
			 */
			cachedData = getCachedData(key+"cached");
			dropDownList = cachedData.getCachedDataList();
		}
		
		jsonDropDownList = getJsonDropDownList(dropDownList);
		if (jsonDropDownList != null) {

			jsonDropDownList = jsonDropDownList.subList(offset,
					offset + Integer.parseInt(autocompletecount));
		}
		
		
		
		return jsonDropDownList;
	}

	/**
	 * This method returns the auto complete data for the given key, phrase and
	 * offset.
	 * 
	 * @param key
	 * @param phrase
	 * @param offset
	 * @return dropDownList
	 */
	private List<String> getAutoCompleteDataFromRedis(final String key,
			String phrase, final Integer offset) {
		List<String> dropDownList = null;
		final Integer found = 0;
		final Integer rangeLength = 100;

		final Jedis redis = new Jedis(jedisConnectionFactory.getShardInfo());

		StringBuilder phraseBuilder = new StringBuilder();
		phraseBuilder.append("{\"name\":\"").append(phrase);
		phrase = phraseBuilder.toString();

		final int prefixLength = phrase.length();
		// Gets the index of the phrase
		Long start = redis.zrank(key, phrase);
		if (start == null) {
			start = redis.zrank(key, phrase + "*");
			if (start == null) {
				redis.close();
				return dropDownList;
			}
		}

		if (start < 0 || prefixLength == 0) {
			redis.close();
			return new ArrayList<>();
		}

		dropDownList = new ArrayList<String>();

		int maxNeeded = Integer.parseInt(autocompletecount);
		Integer count = -1;
		while (found < maxNeeded) {
			final Set<String> rangeResults = redis.zrange(key, start, start
					+ rangeLength - 1);
			start += rangeLength;
			if (rangeResults.isEmpty()) {
				break;
			}
			for (final String entry : rangeResults) {
				final int minLength = Math.min(entry.length(), prefixLength);
				if (!entry.substring(0, minLength).equalsIgnoreCase(
						phrase.substring(0, minLength))) {
					maxNeeded = dropDownList.size();
					break;
				}

				/*
				 * The name ending with '*' will only be picked as it is the
				 * complete sentence
				 */
				if (entry.endsWith("*") && dropDownList.size() < maxNeeded) {
					if (offset != null && offset != 0) {
						count++;
						if (count >= offset && count < maxNeeded + offset) {
							dropDownList.add(entry.substring(0,
									entry.length() - 1));
						}
					} else {
						dropDownList
								.add(entry.substring(0, entry.length() - 1));
					}

				}
			}
		}

		redis.close();
		return dropDownList;
	}

	/**
	 * This method returns the cached drop down data. If there is no cached
	 * data, the corresponding service is invoked and the list is set to the
	 * cache and returns the list.
	 * 
	 * @param dropDownKey
	 * @return dropDownList
	 */
	@Cacheable(value = "autocompleteCacheData", key = "#dropDownKey")
	private AutocompleteCacheData getCachedData(String dropDownKey) {
		List<String> dropDownList = null;
		List<CacheData> cacheDataList = null;

		if ((titleskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::titleskey");
			cacheDataList = asDataService.getTitles();
		} else if ((suffixeskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::titleskey");
			cacheDataList = asDataService.getSuffixes();
		} else if ((industrieskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::industrieskey");
			cacheDataList = asDataService.getInstitutions();
		} else if ((jobCategorieskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::jobCategorieskey");
			cacheDataList = asDataService.getJobCategories();
		} else if ((countrieskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::countrieskey");
			cacheDataList = asDataService.getCountries();
		} else if ((institutionskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::institutionskey");
			cacheDataList = asDataService.getInstitutions();
		} else if ((departmentskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::departmentskey");
			cacheDataList = asDataService.getDepartments();
		} else if ((researchFunderskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::researchFunderskey");
			cacheDataList = asDataService.getResearchFunders();
		} else if ((societieskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::societieskey");
			cacheDataList = asDataService.getSocieties();
		} else if ((areasOfIntrestkey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::areasOfIntrestkey");
			cacheDataList = asDataService.getAreasOfInterests();
		}

		if (cacheDataList != null && !cacheDataList.isEmpty()) {
			dropDownList = new ArrayList<String>();
			for (CacheData cacheData : cacheDataList) {
				dropDownList.add(cacheData.toString());
			}

		}
		
		AutocompleteCacheData cachedData = new AutocompleteCacheData();
		
		if(dropDownList != null && !dropDownList.isEmpty()){
			cachedData.setCachedDataList(dropDownList);
		}

		return cachedData;
	}
	
	/**
	 * This method converts the JsonString to Cached Data object.
	 * @param dropDownList
	 * @return jsonDropDownList
	 */
	private List<CacheData> getJsonDropDownList(List<String> dropDownList){
		
		List<CacheData> jsonDropDownList = null;
		
		if(dropDownList != null && !dropDownList.isEmpty()){
			jsonDropDownList = new ArrayList<CacheData>();
			for (String data : dropDownList) {
				try {
					JSONObject json = (JSONObject)new JSONParser().parse(data);
					CacheData cacheData = new  CacheData();
					cacheData.setName(json.get("name").toString());
					cacheData.setCode(json.get("code").toString());
					jsonDropDownList.add(cacheData);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
			
			jsonDropDownList = sortCacheData("name", jsonDropDownList);
		}
		
		
		return jsonDropDownList;
		
	}
	
	/**
	 * This method sorts the Cached Object Data according to name  
	 * @param name
	 * @param jsonDropDownList
	 * @return jsonDropDownList
	 */
	private List<CacheData> sortCacheData(String name, List<CacheData> jsonDropDownList){
	    Comparator<CacheData> comp = new BeanComparator<CacheData>(name);
	    Collections.sort(jsonDropDownList, comp);
	    
	    return jsonDropDownList;
	  }

}
