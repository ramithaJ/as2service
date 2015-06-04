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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;
import com.wiley.gr.ace.authorservices.model.external.SearchUserResult;
import com.wiley.gr.ace.authorservices.model.external.Status;

/**
 * @author virtusa
 *	version 1.0
 */
public class ESBInterfaceServiceImpl implements ESBInterfaceService {

	@Value("${search-user.url}")
	private String searchUserUrl;

	@Value("${createuser.url}")
	private String createUserUrl;

	@Value("${fetchorciddetails.url}")
	private String fetchOrcidDetailsUrl;

	@Value("${updatealmuser.url}")
	private String updateAlmUserUrl;

	@Override
	public User fetchOrcidDetails(String orcid) throws Exception {
		User user = null;
		final String url = fetchOrcidDetailsUrl;
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
		final String url = updateAlmUserUrl;
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
	 * em.updateALMUser(user); } catch (Exception e) { e.printStackTrace(); } }
	 */

	@Override
	public ESBUser checkEmailIdExists(String emailId) throws Exception {
		ESBUser esbUser = new ESBUser();
		List<ESBUser> esbUserList = searchUser(emailId, "", "");
		if(!StringUtils.isEmpty(esbUserList)) {
			esbUser = esbUserList.get(0);
		} else {
			esbUser = null;
		}
		
		return esbUser;
	}

	@Override
	public List<ESBUser> getUsersFromFirstNameLastName(String firstName,
			String lastName) throws Exception {
		List<ESBUser> esbUserList = null;
		
		esbUserList = searchUser("", firstName, lastName);
		
		return esbUserList;
	}
	
	
	private List<ESBUser> searchUser(String email, String firstName,
			String lastName) throws Exception {
		List<ESBUser> esbUsersList = new ArrayList<ESBUser>();
		SearchUserResult searchUserResult = new SearchUserResult();
		final String url = searchUserUrl + "?Email=" + email + "&FirstName="
				+ firstName + "&LastName=" + lastName;
		URI uri = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<SearchUserResult> requestEntity = new HttpEntity<SearchUserResult>(
				requestHeaders);

		ResponseEntity<SearchUserResult> response = restTemplate.exchange(uri,
				HttpMethod.GET, requestEntity, SearchUserResult.class);
		if (null != response) {
			searchUserResult = response.getBody();
			esbUsersList = searchUserResult.getSearchUserResponse().getUserList();
		} else
			esbUsersList = null;
		
		return esbUsersList;
	}

	@Override
	public Status creatUser(ProfileInformation profileForCreation)
			throws Exception {
		Status status = new Status();
		final String url = createUserUrl;
		URI uri = new URI(url);
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
		HttpEntity<ProfileInformation> requestEntity = new HttpEntity<ProfileInformation>(
				profileForCreation, requestHeaders);
		ResponseEntity<Status> response = restTemplate.exchange(uri,
				HttpMethod.POST, requestEntity, Status.class);
		HttpStatus httpStatus = response.getStatusCode();
		if(httpStatus.equals(HttpStatus.OK)) {
			status.setStatus("SUCCESS");
		} else {
			status.setStatus("FAILURE");
		}
		return status;
	}

	

}
