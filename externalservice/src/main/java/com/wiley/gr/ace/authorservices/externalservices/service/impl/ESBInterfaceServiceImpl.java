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
import com.wiley.gr.ace.authorservices.model.external.ESBUser;

public class ESBInterfaceServiceImpl implements ESBInterfaceService {

	@Override
	public ESBUser createCustomer(ESBUser esbUser) {
		ESBUser esbUserAfterCreate = new ESBUser();
		return esbUserAfterCreate;
	}

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

/*	public static void main(String[] args) {
		ESBInterfaceServiceImpl em = new ESBInterfaceServiceImpl();
		try {
			User user = em.fetchOrcidDetails("1111");
		} catch (Exception e) {
			e.printStackTrace();
		}

	} */

	@Override
	public ESBUser checkEmailIdExists(String emailId) {
		ESBUser esbUser = new ESBUser();
		// TODO: Check primary if not exists check secondary and return the user
		// from external ESB services
		return esbUser;
	}

	@Override
	public List<ESBUser> checkFirstNameLastNameExists(String firstName,
			String lastName) {
		List<ESBUser> esbUserList = new ArrayList<ESBUser>();
		// TODO: Check first name + last name and return the list of users from
		// external ESB services
		return esbUserList;
	}
}
