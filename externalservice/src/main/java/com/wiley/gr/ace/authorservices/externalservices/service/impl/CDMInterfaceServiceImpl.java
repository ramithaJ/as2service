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
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.CDMAffiliation;

public class CDMInterfaceServiceImpl implements CDMInterfaceService {
	
	@Override
	public CDMAffiliation[] getAffiliationsForUser(String userId) {

		final String url = "http://demo6003007.mockable.io/user/getAffiliations";


		URI uri = null;
		try {
			uri = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpEntity<CDMAffiliation[]> requestEntity = new HttpEntity<CDMAffiliation[]>(requestHeaders);

			ResponseEntity<CDMAffiliation[]> response = restTemplate.exchange(uri,
					HttpMethod.GET, requestEntity, CDMAffiliation[].class);
			return response.getBody();
			

		} catch (URISyntaxException e) {

			throw new ASException();

		}
	}

	@Override
	public boolean updateAffiliationForUser(CDMAffiliation cdmAffiliation) {
		final String url = "http://demo6003007.mockable.io/user/updateAffiliation";
		Service service = (Service) StubInvokerUtil.invokeStub(url, HttpMethod.POST, "Service");
		String status = service.getStatus();

		if (status != null && status.equalsIgnoreCase("success")) {
			return true;
		} 
		return false;
			

		

	}

	@Override
	public boolean addAffiliationsForUser(CDMAffiliation cdmAffiliation) {
		final String url = "http://demo6003007.mockable.io/user/updateAffiliation";
		Service service = (Service) StubInvokerUtil.invokeStub(url, HttpMethod.POST, "Service");
		String status = service.getStatus();

		if (status != null && status.equalsIgnoreCase("success")) {
			return true;
		} 
		return false;
			
	}

	@Override
	public boolean deleteAffiliationForUser(String userId,String affiliationId) {
		final String url = "http://demo6003007.mockable.io/user/updateAffiliation";
		Service service = (Service) StubInvokerUtil.invokeStub(url, HttpMethod.POST, "Service");
		String status = service.getStatus();

		if (status != null && status.equalsIgnoreCase("success")) {
			return true;
		} 
		return false;
			
	}

	@Override
	public CDMAffiliation[] editAffialiationsForUser(String userId,
			String affiliationId) {
		
		final String url = "http://demo6003007.mockable.io/user/editAffiliation/{affiliaitionId}";


		URI uri = null;
		try {
			uri = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpEntity<CDMAffiliation[]> requestEntity = new HttpEntity<CDMAffiliation[]>(requestHeaders);

			ResponseEntity<CDMAffiliation[]> response = restTemplate.exchange(uri,
					HttpMethod.GET, requestEntity, CDMAffiliation[].class);
			return response.getBody();
			

		} catch (URISyntaxException e) {

			throw new ASException();

		}
	}
	
	@Override
	public Interests[] getInterests(String userId) {

		final String url="http://demo6003007.mockable.io/user/getMyInterests/ecId";
		URI uri = null;
		try{
			
			uri = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpEntity<Interests[]> requestEntity = new HttpEntity<Interests[]>(requestHeaders);
			ResponseEntity<Interests[]> response = restTemplate.exchange(uri,
					HttpMethod.GET, requestEntity, Interests[].class);
			return response.getBody();
			
		} catch (URISyntaxException e) {
				
			throw new ASException();
		}
		
	}
	
	@Override
	public boolean addInterest(String userId,Interests interest) {

		final String url="http://demo6003007.mockable.io/user/addAreasOfInterest/ecId";
		URI uri = null;
		try{
			
			uri = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpEntity<Interests> requestEntity = new HttpEntity<Interests>(requestHeaders);
			ResponseEntity<Interests> response = restTemplate.exchange(uri,
					HttpMethod.POST, requestEntity, Interests.class);
			response.getBody();
			return true;
			
		} catch (URISyntaxException e) {
				
			throw new ASException();
		}
	}
	
	@Override
	public boolean removeInterest(String userId, String interestId) {

		final String url="http://demo6374909.mockable.io/user/removeInterest/ecId";
		URI uri = null;
		try{
			
			uri = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpEntity<Interests> requestEntity = new HttpEntity<Interests>(requestHeaders);
			ResponseEntity<Interests> response = restTemplate.exchange(uri,
					HttpMethod.POST, requestEntity, Interests.class);
			response.getBody();
			return true;
			
		} catch (URISyntaxException e) {
				
			throw new ASException();
		}		
	}
}

