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
import java.util.LinkedHashMap;
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
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.CacheData;
import com.wiley.gr.ace.authorservices.model.Department;
import com.wiley.gr.ace.authorservices.model.DropDown;
import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.persistence.services.UserAutocomplete;

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

    /** getting bean of userProfiles. */
    @Autowired
    private UserProfiles userProfiles;

	@Value("${autocomplete.count}")
	private String autocompletecount;

	@Value("${industries.key}")
	private String industrieskey;

	@Value("${jobCategories.key}")
	private String jobCategorieskey;

	@Value("${countries.key}")
	private String countrieskey;

	@Value("${institutions.key}")
	private String institutionskey;

	@Value("${departments.key}")
	private String departmentskey;


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
			 * Key is appended with (auto/cached) to avoid conflict between
			 * autocomplete and caching data. This appended string needs to be
			 * removed once a solution is found.
			 */
			dropDownList = getAutoCompleteDataFromRedis(key + "auto", phrase,
					offset);

			if (dropDownList == null) {
				// Get the data from cache if not available in Redis and set it
				// in Redis.
				cachedData = getCachedData(key + "cached");
				dropDownList = cachedData.getCachedDataList();
				if (dropDownList != null) {
					final Jedis redis = new Jedis(
							jedisConnectionFactory.getShardInfo());
					for (String dropDownData : dropDownList) {
						addWord(dropDownData, redis, key + "auto");
					}
					redis.close();
					dropDownList = getAutoCompleteDataFromRedis(key + "auto",
							phrase, offset);
				}
			}

		} else {
			// Cacheable
			/*
			 * Key is appended with (auto/cached) to avoid conflict between
			 * autocomplete and caching data. This appended string needs to be
			 * removed once a solution is found.
			 */
			cachedData = getCachedData(key + "cached");
			dropDownList = cachedData.getCachedDataList();
		}

		jsonDropDownList = getJsonDropDownList(dropDownList);
		if (jsonDropDownList != null) {

			jsonDropDownList = jsonDropDownList.subList(offset, offset
					+ Integer.parseInt(autocompletecount));
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

		if ((industrieskey + "cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::industrieskey::"+dropDownKey);
			cacheDataList = getIndustries();
		} else if ((jobCategorieskey + "cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::jobCategorieskey::"+dropDownKey);
			cacheDataList = getJobCategories();
		} else if ((countrieskey + "cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::countrieskey::"+dropDownKey);
			cacheDataList = getCountries();
		} else if ((institutionskey + "cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::institutionskey::"+dropDownKey);
			cacheDataList = getInstitutions();
		} else if ((departmentskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::departmentskey::"+dropDownKey);
			cacheDataList = getDepartments();
		} 

		if (cacheDataList != null && !cacheDataList.isEmpty()) {
			dropDownList = new ArrayList<String>();
			for (CacheData cacheData : cacheDataList) {
				dropDownList.add(cacheData.toString());
			}

		}

		AutocompleteCacheData cachedData = new AutocompleteCacheData();

		if (dropDownList != null && !dropDownList.isEmpty()) {
			cachedData.setCachedDataList(dropDownList);
		}

		return cachedData;
	}

	/**
	 * This method converts the JsonString to Cached Data object.
	 * 
	 * @param dropDownList
	 * @return jsonDropDownList
	 */
	private List<CacheData> getJsonDropDownList(List<String> dropDownList) {

		List<CacheData> jsonDropDownList = null;

		if (dropDownList != null && !dropDownList.isEmpty()) {
			jsonDropDownList = new ArrayList<CacheData>();
			for (String data : dropDownList) {
				try {
					JSONObject json = (JSONObject) new JSONParser().parse(data);
					CacheData cacheData = new CacheData();
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
	 * 
	 * @param name
	 * @param jsonDropDownList
	 * @return jsonDropDownList
	 */
	private List<CacheData> sortCacheData(String name,
			List<CacheData> jsonDropDownList) {
		Comparator<CacheData> comp = new BeanComparator<CacheData>(name);
		Collections.sort(jsonDropDownList, comp);

		return jsonDropDownList;
	}

	/**
	 * This will call external service to get Industries data.
	 *
	 * @param count
	 *            the count
	 * @return the industries
	 */
	@SuppressWarnings("unchecked")
	private List<CacheData> getIndustries() {
		LOGGER.info("inside getIndustries method ");

		List<CacheData> industryList = new ArrayList<CacheData>();
		Industries industries = userProfiles.getIndustries();
		if (null == industries) {
			return industryList;
		}

		List<Object> industryDocs = industries.getResponse().getDocs();
		for (Object object : industryDocs) {

			LinkedHashMap<String, String> industryMap = (LinkedHashMap<String, String>) object;
			CacheData industry = new CacheData();
			industry.setCode(industryMap.get("NAICS_CODE"));
			industry.setName(industryMap.get("NAICS_TITLE"));
			industryList.add(industry);
		}

		return industryList;
	}

	/**
	 * This will call external service to get JobCategories data.
	 *
	 * @param count
	 *            the count
	 * @return the job categories
	 */
	@SuppressWarnings("unchecked")
	private List<CacheData> getJobCategories() {

		LOGGER.info("inside getJobCategories method ");
		JobCategories jobCategories = userProfiles.getJobCategories();
		List<CacheData> jobCategoryList = new ArrayList<CacheData>();
		if (null == jobCategories) {
			return jobCategoryList;
		}

		List<Object> jobCategoryDocs = jobCategories.getResponse().getDocs();
		for (Object object : jobCategoryDocs) {

			LinkedHashMap<String, String> jobCategoryMap = (LinkedHashMap<String, String>) object;
			CacheData jobCategory = new CacheData();
			jobCategory.setCode(jobCategoryMap.get("JOBCODE"));
			jobCategory.setName(jobCategoryMap.get("JOBTITLE"));
			jobCategoryList.add(jobCategory);
		}

		return jobCategoryList;
	}

	/**
	 * This will call external service to get Countries data.
	 *
	 * @param count
	 *            the count
	 * @return the countries
	 */
	@SuppressWarnings("unchecked")
	private List<CacheData> getCountries() {

		LOGGER.info("inside getCountries method ");
		ESBResponse countrieslist = userProfiles.getCountries();
		List<CacheData> countrylist = new ArrayList<CacheData>();

		List<Object> externalCountrylist = countrieslist.getResponse()
				.getDocs();
		if (null == externalCountrylist) {
			return countrylist;
		}
		for (Object object : externalCountrylist) {
			LinkedHashMap<String, String> countrymap = (LinkedHashMap<String, String>) object;
			CacheData cacheData = new CacheData();
			cacheData.setName(countrymap.get("COUNTRY_NAME"));
			cacheData.setCode(countrymap.get("ISO_ALPHA_3"));
			countrylist.add(cacheData);
		}

		return countrylist;
	}

	/**
	 * This will call external service to get Institutions data.
	 *
	 * @return the institutions
	 */
	private List<CacheData> getInstitutions() {

		LOGGER.info("inside getInstitutions method ");

		DropDown dropDown = userProfiles.getInstitutionsList();
		List<Institution> listofinstitute = dropDown.getInstitutions();
		List<CacheData> institutionslist = new ArrayList<CacheData>();

		for (Institution institute : listofinstitute) {

			CacheData institution = new CacheData();
			institution.setCode(institute.getInstitutionId());
			institution.setName(institute.getInstitutionName());
			institutionslist.add(institution);

		}

		return institutionslist;
	}

	/**
	 * This will call external service to get Departments data.
	 *
	 * @return the departments
	 */
	private List<CacheData> getDepartments() {

		LOGGER.info("inside getDepartments method ");

		DropDown dropDown = userProfiles.getDepartmentsList();
		List<Department> listofdepartment = dropDown.getDepartments();
		List<CacheData> departmentlist = new ArrayList<CacheData>();
		for (Department department : listofdepartment) {

			CacheData departments = new CacheData();
			departments.setCode(department.getDepartmentId());
			departments.setName(department.getDepartmentName());
			departmentlist.add(departments);

		}
		return departmentlist;
	}

}
