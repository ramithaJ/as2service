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
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.persistence.services.UserAutocomplete;

/**
 * AutocompleteService provides auto suggestions.
 *
 * @author virtusa
 * @version 1.0
 */
public class AutocompleteServiceImpl implements AutocompleteService {

    /** The jedis connection factory. */
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    /** The user autocomplete. */
    @Autowired
    private UserAutocomplete userAutocomplete;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService
     * #getAutocompleteData(java.lang.String, java.lang.String,
     * java.lang.Integer)
     */
    @Override
    public List<String> getAutocompleteData(String key, String phrase,
            Integer count) {
        final Jedis redis = new Jedis(jedisConnectionFactory.getShardInfo());
        if (null == phrase) {
            redis.close();
            return Collections.emptyList();
        }

        final int prefixLength = phrase.length();
        Long start = redis.zrank(key, phrase);
        if (start == null) {
            phrase = phrase + "*";
            start = redis.zrank(key, phrase);
            if (start == null) {
                redis.close();
                return null;
            }
        }

        if (start < 0 || prefixLength == 0) {
            redis.close();
            return Collections.emptyList();
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService
     * #setAutocompleteData(java.lang.String, java.lang.Boolean)
     */
    @Override
    public boolean setAutocompleteData(String key, Boolean clear)
            throws IOException {
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService
     * #flush(java.lang.String)
     */
    @Override
    public boolean flush(String key) {
        final Jedis redis = new Jedis(jedisConnectionFactory.getShardInfo());
        redis.del(key);
        redis.close();
        return true;
    }

}
