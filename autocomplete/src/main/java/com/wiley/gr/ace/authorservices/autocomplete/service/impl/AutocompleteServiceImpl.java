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
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Jedis;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;

/**
 * @author virtusa version 1.0
 */
public class AutocompleteServiceImpl implements AutocompleteService {

	@Autowired
	private JedisConnectionFactory jedisConnectionFactory;

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

	@Override
	public boolean setAutocompleteData(String key, URL dataPath, Boolean clear)
	        throws IOException {
		final Jedis redis = new Jedis(jedisConnectionFactory.getShardInfo());

		final List<String> wordsList = new ArrayList<String>();
		wordsList.add("a");
		wordsList.add("an");
		wordsList.add("ant");
		wordsList.add("ante");
		wordsList.add("antel");
		wordsList.add("antelo");
		wordsList.add("antelop");
		wordsList.add("antelope");
		wordsList.add("bat");
		wordsList.add("bet");
		wordsList.add("best");
		wordsList.add("cat");
		wordsList.add("cot");

		for (final String word : wordsList) {
			addWord(word, redis, key);
		}

		/*
		 * final InputStreamReader inputStreamReader = new InputStreamReader(
		 * dataPath.openStream()); final BufferedReader reader = new
		 * BufferedReader(inputStreamReader); String word; while ((word =
		 * reader.readLine()) != null) { word = word.trim(); // Add the word if
		 * the word does not start with # if (!word.isEmpty() &&
		 * !word.startsWith("#")) { addWord(word, redis, key); } }
		 * reader.close();
		 */
		redis.close();
		return true;
	}

	private void addWord(final String word, final Jedis redis,
	        final String redisKey) {
		// Add all the possible prefixes of the given word and also the given
		// word with a * suffix.
		redis.zadd(redisKey, 0, word + "*");
		for (int index = 1, total = word.length(); index < total; index++) {
			redis.zadd(redisKey, 0, word.substring(0, index));
		}
	}

	@Override
	public boolean flush(String key) {
		final Jedis redis = new Jedis(jedisConnectionFactory.getShardInfo());
		redis.del(key);
		redis.close();
		return true;
	}

}
