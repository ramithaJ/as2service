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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanComparator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteCachingService;
import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.CacheData;
import com.wiley.gr.ace.authorservices.model.SubFunder;
import com.wiley.gr.ace.authorservices.model.SubFunderDetails;
import com.wiley.gr.ace.authorservices.model.SubFunders;
import com.wiley.gr.ace.authorservices.persistence.services.UserAutocomplete;

/**
 * AutocompleteService provides auto suggestions.
 *
 * @author virtusa
 * @version 1.0
 */
public class AutocompleteServiceImpl implements AutocompleteService {

    /** The jedis connection factory. */
    @Autowired(required = true)
    private JedisConnectionFactory jedisConnectionFactory;

    /** The user autocomplete. */
    @Autowired(required = true)
    private UserAutocomplete userAutocomplete;

    /** The autocomplete caching service. */
    @Autowired(required = true)
    private AutocompleteCachingService autocompleteCachingService;

    /** The autocompletecount. */
    @Value("${autocomplete.count}")
    private String autocompletecount;

    /** The subFunderskey. */
    @Value("${subFunders.key}")
    private String subFunderskey;

    /**
     * Adds the word.
     *
     * @param word
     *            the word.
     * @param redis
     *            the redis.
     * @param redisKey
     *            the redis key.
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
     * Method to retrieve the drop down data.
     * 
     * @param key
     *            - the input value
     * @param phrase
     *            - the input value
     * @param offset
     *            - the input value
     * @param parentId
     *            - the input value
     * @return dropDownList.
     */
    public final List<CacheData> getDropDownData(String key,
            final String phrase, Integer offset, final String parentId) {
        List<String> dropDownList = null;
        List<CacheData> jsonDropDownList = null;
        SubFunderDetails subFunderDetails = null;
        Map<String, CacheData> dropDownMap = null;
        Integer autoCompCount = Integer.parseInt(autocompletecount);

        if (offset == null) {
            offset = 0;
        }

        if (parentId != null && !"".equals(parentId.trim())) {
            key = key + "_" + parentId;
        }

        if (phrase != null && !"".equals(phrase.trim())) {
            // Auto Complete

            // Key is appended with (_auto/_cached) to avoid conflict between
            // auto complete and caching data.
            dropDownList = getAutoCompleteDataFromRedis(key + "_auto", phrase,
                    offset);

            if (dropDownList == null) {
                // Get the data from cache if not available in Redis and set it
                // in Redis.
                dropDownMap = autocompleteCachingService.getCachedData(key
                        + "_cached", parentId);

                Collection<CacheData> values = dropDownMap.values();
                dropDownList = new ArrayList<String>();
                for (CacheData cacheData : values) {
                    dropDownList.add(cacheData.toString());
                }

                if (dropDownList != null) {
                    final Jedis redis = new Jedis(
                            jedisConnectionFactory.getShardInfo());
                    for (String dropDownData : dropDownList) {
                        addWord(dropDownData, redis, key + "_auto");
                    }
                    redis.close();
                    dropDownList = getAutoCompleteDataFromRedis(key + "_auto",
                            phrase, offset);
                }

                // Convert the json string to json object and sort the list in
                // ascending order
                if (jsonDropDownList == null && dropDownList != null) {
                    jsonDropDownList = getJsonDropDownList(dropDownList, phrase);
                }
            }

        } else {
            // Cacheable

            // Key is appended with (_cached) to avoid conflict between
            // auto complete and caching data

            // For Sub Funders
            if ((subFunderskey + "_" + parentId).equals(key)) {
                subFunderDetails = autocompleteCachingService
                        .getCachedSubFunders(key + "_cached");
                SubFunders subFunders = subFunderDetails.getSubFundersMap()
                        .get(parentId);

                List<SubFunder> subFunderList = subFunders.getSubFunderList();
                if (subFunderList != null && !subFunderList.isEmpty()) {
                    jsonDropDownList = new ArrayList<CacheData>();
                    for (SubFunder subFunder : subFunderList) {
                        CacheData cacheData = new CacheData();
                        cacheData.setCode(subFunder.getDoi());
                        cacheData.setName(subFunder.getName());
                        jsonDropDownList.add(cacheData);
                    }

                    jsonDropDownList = sortCacheData("name", jsonDropDownList);

                }

            } else {

                dropDownMap = autocompleteCachingService.getCachedData(key
                        + "_cached", parentId);

                Collection<CacheData> values = dropDownMap.values();
                jsonDropDownList = new ArrayList<CacheData>();
                for (CacheData cacheData : values) {
                    jsonDropDownList.add(cacheData);
                }

                jsonDropDownList = sortCacheData("name", jsonDropDownList);

            }
        }

        // Return the sublist based on the offset provided
        if (jsonDropDownList != null
                && jsonDropDownList.size() >= autoCompCount
                && (phrase == null || "".equals(phrase.trim()))) {

            jsonDropDownList = jsonDropDownList.subList(offset, offset
                    + autoCompCount);
        }

        return jsonDropDownList;
    }

    /**
     * This method returns the auto complete data for the given key, phrase and
     * offset.
     * 
     * @param key
     *            - the input value
     * @param phrase
     *            - the input value
     * @param offset
     *            - the input value
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
            return new ArrayList<String>();
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
     * This method converts the JsonString to Cached Data object.
     * 
     * @param dropDownList
     *            - the input value
     * @param phrase
     *            - the input value
     * @return jsonDropDownList
     */
    private List<CacheData> getJsonDropDownList(
            final List<String> dropDownList, final String phrase) {

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
                    throw new ASException("500", e.getMessage());
                }

            }

            if (phrase == null) {
                jsonDropDownList = sortCacheData("name", jsonDropDownList);
            }
        }

        return jsonDropDownList;

    }

    /**
     * This method sorts the Cached Object Data according to name.
     * 
     * @param name
     *            - the input value
     * @param jsonDropDownList
     *            - the input value
     * @return jsonDropDownList
     */
    private List<CacheData> sortCacheData(final String name,
            final List<CacheData> jsonDropDownList) {
        Comparator<CacheData> comp = new BeanComparator<CacheData>(name);
        Collections.sort(jsonDropDownList, comp);

        return jsonDropDownList;
    }

}
