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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.DropDown;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;

/**
 * @author virtusa
 *	version 1.0
 */
public class UserProfilesImpl implements UserProfiles {

	@Value("${lookupProfile.url}")
	private String userProfileurl;

	@Value("${updateProfile.url}")
	private String updateProfileurl;

	@Value("${institutions.url}")
	private String institutionsurl;

	@Value("${departments.url}")
	private String departmentsurl;

	@Value("${reasearchFunders.url}")
	private String researchFundersurl;

	@Value("${societies.url}")
	private String societiesurl;

	@Value("${areaofInterests.url}")
	private String areaofInterestsurl;

	@Value("${jobCategories.url}")
	private String jobCategoriesurl;

	@Value("${industries.url}")
	private String industriesurl;

	@Value("${countries.url}")
	private String countriesurl;

	@Value("${states.url}")
	private String statesurl;
	
	@Value("${STATUS}")
	private String STATUS;

	@Override
	public UserProfileResponse getUserProfileResponse(String userId) {

		return (UserProfileResponse) StubInvokerUtil.invokeStub(userProfileurl,
				HttpMethod.GET, UserProfileResponse.class);
	}

	@Override
	public boolean updateProfile(UserProfileResponse userProfileResponse) {

		Service service = (Service) StubInvokerUtil.invokeStub(updateProfileurl,
				HttpMethod.POST, Service.class);
		String status = service.getStatus();
		if (status != null && STATUS.equalsIgnoreCase(status)) {
			return true;
		}
		return false;
	}

	@Override
	public ESBResponse getAreaOfInterests() {

		return (ESBResponse) StubInvokerUtil.invokeStub(areaofInterestsurl,
				HttpMethod.GET, ESBResponse.class);
	}

	@Override
	public JobCategories getJobCategories() {

		return (JobCategories) StubInvokerUtil.invokeStub(jobCategoriesurl,
				HttpMethod.GET, JobCategories.class);
	}

	@Override
	public Industries getIndustries() {

		return (Industries) StubInvokerUtil.invokeStub(industriesurl,
				HttpMethod.GET, Industries.class);
	}

	@Override
	public ESBResponse getCountries() {

		return (ESBResponse) StubInvokerUtil.invokeStub(countriesurl,
				HttpMethod.GET, ESBResponse.class);
	}

	@Override
	public ESBResponse getStates() {

		return (ESBResponse) StubInvokerUtil.invokeStub(statesurl, HttpMethod.GET,
				ESBResponse.class);
	}

	@Override
	public DropDown getInstitutionsList() {

		return (DropDown) StubInvokerUtil.invokeStub(institutionsurl,
				HttpMethod.GET, DropDown.class);
	}

	@Override
	public DropDown getDepartmentsList() {

		return (DropDown) StubInvokerUtil.invokeStub(departmentsurl,
				HttpMethod.GET, DropDown.class);
	}

	@Override
	public DropDown getReasearchFunder() {

		return (DropDown) StubInvokerUtil.invokeStub(researchFundersurl,
				HttpMethod.GET, DropDown.class);
	}

	@Override
	public DropDown getSocietyList() {

		return (DropDown) StubInvokerUtil.invokeStub(societiesurl, HttpMethod.GET,
				DropDown.class);
	}
}
