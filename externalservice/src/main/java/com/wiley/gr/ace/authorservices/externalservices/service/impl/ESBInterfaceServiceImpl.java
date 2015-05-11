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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;

public class ESBInterfaceServiceImpl implements ESBInterfaceService {

	@Override
	public User fetchOrcidDetails(String orcid) throws Exception {
		User user = null;
		final String url = "http://demo3275860.mockable.io/fetchOrcidDetails/123";
		URI uri = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> requestEntity = new HttpEntity<User>(requestHeaders);

		ResponseEntity<User> response = restTemplate.exchange(uri,
				HttpMethod.GET, requestEntity, User.class);
		System.out.println("####  response #### " + response.getStatusCode());
		System.out.println("####  response #### " + response.getBody());

		user = response.getBody();
		System.out.println("####  " + user.getPrimaryEmailAddr());
		return user;
	}

	@Override
	public String updateALMUser(User updateUser) throws Exception {
		String status = "failure";
		final String url = "http://demo3275860.mockable.io/user/update";
		URI uri = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
		HttpEntity<String> requestEntity = new HttpEntity<String>(
				requestHeaders);
		ResponseEntity<String> response = restTemplate.exchange(uri,
				HttpMethod.GET, requestEntity, String.class);
		status = response.getBody();
		System.out.println("status :: " + status);
		return status;
	}

	/*
	 * public static void main(String[] args) { ESBInterfaceServiceImpl em = new
	 * ESBInterfaceServiceImpl(); try { // User user =
	 * em.fetchOrcidDetails("1111"); User user = new User(); String s =
	 * em.updateALMUser(user); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	@Override
	public User checkEmailIdExists(String emailId) throws Exception {
		User user = new User();
		final String url = "http://demo7614669.mockable.io/checkEmailId/email@email.com";
		URI uri = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> requestEntity = new HttpEntity<User>(requestHeaders);

		ResponseEntity<User> response = restTemplate.exchange(uri,
				HttpMethod.GET, requestEntity, User.class);
		if (null != response)
			user = response.getBody();
		else
			user = null;
		return user;
	}

	@Override
	public List<User> getUsersFromFirstNameLastName(String firstName,
			String lastName) throws Exception {
		List<User> usersList = new ArrayList<User>();
		final String url = "http://demo7614669.mockable.io/getFromFirstNameLastName/Dishari/De";
		URI uri = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
		HttpEntity<List<User>> requestEntity = new HttpEntity<List<User>>(
				requestHeaders);
		ResponseEntity<List> response = restTemplate.exchange(uri,
				HttpMethod.GET, requestEntity, List.class);
		usersList = response.getBody();

		return usersList;
	}

	@Override
	public String creatUser(User user) throws Exception {
		String status = "failure";
		final String url = "http://demo7614669.mockable.io/createUser/userobject";
		URI uri = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
		HttpEntity<String> requestEntity = new HttpEntity<String>(
				requestHeaders);
		ResponseEntity<String> response = restTemplate.exchange(uri,
				HttpMethod.POST, requestEntity, String.class);
		status = response.getBody();
		System.out.println("status :: " + status);
		return status;
	}

}
