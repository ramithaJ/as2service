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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteCachingService;
import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.CacheData;
import com.wiley.gr.ace.authorservices.model.SubFunder;
import com.wiley.gr.ace.authorservices.model.SubFunderDetails;
import com.wiley.gr.ace.authorservices.model.SubFunders;

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
     * This field holds the value of AUTO
     */
    private static final String AUTO = "_auto";

    /**
     * This field holds the value of CACHED
     */
    private static final String CACHED = "_cached";

    /**
     * Enum For valid drop down keys.
     */
    public enum DropDownKeys {
        /**
         * Dropdown key list.
         */
        INDUSTRIES, JOBCATEGORIES, COUNTRIES, STATES, INSTITUTIONS, DEPARTMENTS, RESEARCHFUNDERS, SUBFUNDERS, SOCIETIES, AREASOFINTERESTS, WOAFUNDERS
    }

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
        /*
         * Add all the possible prefixes of the given word and also the given
         * word with a * suffix.
         */
        LOGGER.info("getDropDownData::addWord");
        redis.zadd(redisKey, 0, word + AuthorServicesConstants.ASTRISK);
        for (int index = 1, total = word.length(); index < total; index++) {
            redis.zadd(redisKey, 0, word.substring(0, index));
        }
    }

    /**
     * This method checks whether the passed key is valid and returns boolean.
     * 
     * @param dropDownKey
     *            - the input value
     * @return flag
     */
    private boolean isValidKey(final String dropDownKey) {
        boolean flag = false;
        LOGGER.info("getDropDownData::isValidKey method");
        for (DropDownKeys keys : DropDownKeys.values()) {
            if (dropDownKey.equalsIgnoreCase(keys.toString())) {
                flag = true;
                LOGGER.info("getDropDownData::isValidKey::" + flag);
                break;
            }
        }

        return flag;
    }

    /**
     * Method to retrieve the drop down data.
     * 
     * @param redisCacheKey
     *            - the input value
     * @param redisPhrase
     *            - the input value
     * @param offset
     *            - the input value
     * @param parentId
     *            - the input value
     * @return dropDownList.
     */
    @Override
    public final List<CacheData> getDropDownData(String redisCacheKey,
            final String redisPhrase, final Integer offset,
            final String parentId) {
        List<String> dropDownList = null;
        List<CacheData> jsonDropDownList = null;
        SubFunderDetails subFunderDetails = null;
        Map<String, CacheData> dropDownMap = null;
        Integer autoCompCount = null;

        if (isValidKey(redisCacheKey)) {
            autoCompCount = Integer.valueOf(autocompletecount);
            LOGGER.info("getDropDownData::valid Key::" + redisCacheKey);

            if (parentId != null
                    && !AuthorServicesConstants.EMPTY.equals(parentId.trim())) {
                redisCacheKey = redisCacheKey
                        + AuthorServicesConstants.UNDERSCORE + parentId;
            }

            if (redisPhrase != null
                    && !AuthorServicesConstants.EMPTY
                            .equals(redisPhrase.trim())) {
                LOGGER.info("getDropDownData::Autocomplete Request with phrase:"
                        + redisPhrase);
                dropDownList = getAutoCompleteDataFromRedis(redisCacheKey
                        + AUTO, redisPhrase, offset);

                if (dropDownList == null) {

                    LOGGER.info("getDropDownData::No Data found in Redis with the Key : "
                            + redisCacheKey);

                    dropDownMap = autocompleteCachingService.getCachedData(
                            redisCacheKey + CACHED, parentId);
                    if (dropDownMap != null && !dropDownMap.isEmpty()) {

                        Collection<CacheData> values = dropDownMap.values();
                        if (values != null && !values.isEmpty()) {

                            LOGGER.info("getDropDownData::Values retrieved from Cache");

                            dropDownList = new ArrayList<String>();
                            for (CacheData cacheData : values) {
                                dropDownList.add(cacheData.toString());
                            }

                            if (dropDownList != null) {
                                final Jedis redis = new Jedis(
                                        jedisConnectionFactory.getShardInfo());
                                for (String dropDownData : dropDownList) {
                                    addWord(dropDownData, redis, redisCacheKey
                                            + AUTO);
                                }
                                redis.close();
                                dropDownList = getAutoCompleteDataFromRedis(
                                        redisCacheKey + AUTO, redisPhrase,
                                        offset);
                            }

                        } else {
                            LOGGER.info("getDropDownData::Data Not Available in Cache for the Key : "
                                    + redisCacheKey);
                        }

                    } else {
                        LOGGER.info("getDropDownData::Data Not Available in Cache for the Key : "
                                + redisCacheKey);
                    }
                }

                if (dropDownList != null) {
                    jsonDropDownList = getJsonDropDownList(dropDownList,
                            redisPhrase);
                }

            } else {

                LOGGER.info("getDropDownData::Caching Request");
                String subFunderKey = subFunderskey
                        + AuthorServicesConstants.UNDERSCORE + parentId;

                /* For Sub Funders */
                if (subFunderKey.equals(redisCacheKey)) {
                    LOGGER.info("getDropDownData::Caching Request for Key :"
                            + redisCacheKey);
                    subFunderDetails = autocompleteCachingService
                            .getCachedSubFunders(redisCacheKey + CACHED);
                    SubFunders subFunders = subFunderDetails.getSubFundersMap()
                            .get(parentId);

                    List<SubFunder> subFunderList = subFunders
                            .getSubFunderList();
                    if (subFunderList != null && !subFunderList.isEmpty()) {
                        jsonDropDownList = new ArrayList<CacheData>();
                        for (SubFunder subFunder : subFunderList) {
                            CacheData cacheData = new CacheData();
                            cacheData.setCode(subFunder.getDoi());
                            cacheData
                                    .setName(subFunder.getName().toUpperCase());
                            cacheData.setDisplayName(subFunder.getName());
                            jsonDropDownList.add(cacheData);
                        }

                        jsonDropDownList = sortCacheData(
                                AuthorServicesConstants.NAME_FIELD,
                                jsonDropDownList);

                    }

                } else {

                    LOGGER.info("getDropDownData::Caching Request for Key :"
                            + redisCacheKey);

                    dropDownMap = autocompleteCachingService.getCachedData(
                            redisCacheKey + CACHED, parentId);

                    if (dropDownMap != null && !dropDownMap.isEmpty()) {
                        Collection<CacheData> values = dropDownMap.values();
                        if (values != null && !values.isEmpty()) {
                            jsonDropDownList = new ArrayList<CacheData>();
                            jsonDropDownList.addAll(values);

                            jsonDropDownList = sortCacheData(
                                    AuthorServicesConstants.NAME_FIELD,
                                    jsonDropDownList);
                        }
                    }

                }
            }

            /* Return the sublist based on the offset provided. */
            if (jsonDropDownList != null
                    && jsonDropDownList.size() >= autoCompCount
                    && (redisPhrase == null || AuthorServicesConstants.EMPTY
                            .equals(redisPhrase.trim()))) {

                jsonDropDownList = jsonDropDownList.subList(offset, offset
                        + autoCompCount);
            }

        } else {
            LOGGER.info("getDropDownData::Invalid Key::" + redisCacheKey);
        }

        return jsonDropDownList;
    }

    /**
     * This method returns the auto complete data for the given key, phrase and
     * offset.
     * 
     * @param redisCacheKey
     *            - the input value
     * @param redisPhrase
     *            - the input value
     * @param offset
     *            - the input value
     * @return dropDownList
     */
    private List<String> getAutoCompleteDataFromRedis(
            final String redisCacheKey, String redisPhrase, final Integer offset) {
        List<String> dropDownList = null;
        final Integer found = 0;
        final Integer rangeLength = 100;

        final Jedis redis = new Jedis(jedisConnectionFactory.getShardInfo());

        LOGGER.info("getAutoCompleteDataFromRedis::Key :" + redisCacheKey
                + " Phrase : " + redisPhrase);

        StringBuilder phraseBuilder = new StringBuilder();
        phraseBuilder.append("{\"name\":\"").append(redisPhrase);
        redisPhrase = phraseBuilder.toString();

        LOGGER.info("getAutoCompleteDataFromRedis New Phrase : " + redisPhrase);
        final int prefixLength = redisPhrase.length();
        /* Gets the index of the phrase */
        Long start = redis.zrank(redisCacheKey, redisPhrase);
        if (null == start) {
            start = redis.zrank(redisCacheKey, redisPhrase
                    + AuthorServicesConstants.ASTRISK);
            if (null == start) {
                redis.close();
                LOGGER.info("getAutoCompleteDataFromRedis:: In-valid Key or Phrase");
                return dropDownList;
            }
        }

        if (start < 0 || prefixLength == 0) {
            redis.close();
            LOGGER.info("getAutoCompleteDataFromRedis:: In-valid Key or Phrase");
            return new ArrayList<String>();
        }

        dropDownList = new ArrayList<String>();

        int maxNeeded = Integer.parseInt(autocompletecount);
        Integer count = -1;
        while (found < maxNeeded) {
            LOGGER.info("getAutoCompleteDataFromRedis::Fetching Values");
            final Set<String> rangeResults = redis.zrange(redisCacheKey, start,
                    start + rangeLength - 1);
            start += rangeLength;
            if (rangeResults.isEmpty()) {
                break;
            }
            for (final String entry : rangeResults) {
                final int minLength = Math.min(entry.length(), prefixLength);
                if (!entry.substring(0, minLength).equalsIgnoreCase(
                        redisPhrase.substring(0, minLength))) {
                    maxNeeded = dropDownList.size();
                    break;
                }

                /*
                 * The name ending with '*' will only be picked as it is the
                 * complete sentence
                 */
                if (entry.endsWith(AuthorServicesConstants.ASTRISK)
                        && dropDownList.size() < maxNeeded) {
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
                    cacheData.setName(json.get(
                            AuthorServicesConstants.NAME_FIELD).toString());
                    cacheData.setCode(json.get(
                            AuthorServicesConstants.CODE_FIELD).toString());
                    LOGGER.info("Display Name : "
                            + json.get(AuthorServicesConstants.DISPLAY_NAME_FIELD));
                    cacheData.setDisplayName(json.get(
                            AuthorServicesConstants.DISPLAY_NAME_FIELD)
                            .toString());
                    jsonDropDownList.add(cacheData);
                } catch (ParseException e) {
                    throw new ASException(
                            AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                            e.getMessage());
                }

            }

            if (null == phrase) {
                jsonDropDownList = sortCacheData(
                        AuthorServicesConstants.NAME_FIELD, jsonDropDownList);
            }
        }

        return jsonDropDownList;

    }

    /**
     * This method sorts the Cached Data object according to name.
     * 
     * @param name
     *            - the input value
     * @param jsonDropDownList
     *            - the input value
     * @return jsonDropDownList
     */
    private List<CacheData> sortCacheData(final String name,
            final List<CacheData> jsonDropDownList) {
        LOGGER.info("sortCacheData");

        Comparator<CacheData> comp = new BeanComparator<CacheData>(name);
        Collections.sort(jsonDropDownList, comp);

        return jsonDropDownList;
    }

    /**
     * This method will return the name for the corresponding code from the
     * cache.
     * 
     * @param redisCacheKey
     *            - Input parameter
     * @param code
     *            - Input parameter
     * @param parentId
     *            - Input parameter
     * @return name
     */
    @Override
    public final String getNameByCode(String redisCacheKey, final String code,
            final String parentId) {
        String name = null;
        Map<String, CacheData> dropDownMap = null;
        CacheData cacheData = null;

        if (parentId != null
                && !AuthorServicesConstants.EMPTY.equals(parentId.trim())) {
            redisCacheKey = redisCacheKey + AuthorServicesConstants.UNDERSCORE
                    + parentId;
            LOGGER.info("getNameByCode::Key:" + redisCacheKey);
        }

        dropDownMap = autocompleteCachingService.getCachedData(redisCacheKey
                + CACHED, parentId);

        if (dropDownMap != null) {
            LOGGER.info("getNameByCode::dropDownMap is not empty");
            cacheData = dropDownMap.get(code);
            if (cacheData != null) {
                name = cacheData.getDisplayName();
            }
        } else {
            throw new ASException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);
        }

        return name;
    }

}
