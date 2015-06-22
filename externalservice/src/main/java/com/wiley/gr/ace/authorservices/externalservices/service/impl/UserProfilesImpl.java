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
 * The Class UserProfilesImpl.
 * 
 * @author virtusa 
 * version 1.0
 */
public class UserProfilesImpl implements UserProfiles {

	/** The user profileurl. */
	@Value("${lookupProfile.url}")
	private String userProfileurl;

	/** The update profileurl. */
	@Value("${updateProfile.url}")
	private String updateProfileurl;

	/** The institutionsurl. */
	@Value("${institutions.url}")
	private String institutionsurl;

	/** The departmentsurl. */
	@Value("${departments.url}")
	private String departmentsurl;

	/** The research fundersurl. */
	@Value("${reasearchFunders.url}")
	private String researchFundersurl;

	/** The societiesurl. */
	@Value("${societies.url}")
	private String societiesurl;

	/** The areaof interestsurl. */
	@Value("${areaofInterests.url}")
	private String areaofInterestsurl;

	/** The job categoriesurl. */
	@Value("${jobCategories.url}")
	private String jobCategoriesurl;

	/** The industriesurl. */
	@Value("${industries.url}")
	private String industriesurl;

	/** The countriesurl. */
	@Value("${countries.url}")
	private String countriesurl;

	/** The statesurl. */
	@Value("${states.url}")
	private String statesurl;

	/** The status. */
	@Value("${STATUS}")
	private String STATUS;

	/**
	 * This method is used for getting userProfile response.
	 * 
	 * @param userId
	 * @return UserProfileResponse
	 * 
	 */
	@Override
	public UserProfileResponse getUserProfileResponse(final String userId) {

		return (UserProfileResponse) StubInvokerUtil.invokeStub(userProfileurl,
				HttpMethod.GET, UserProfileResponse.class);
	}

	/**
	 * This method is used for getting userProfile response.
	 * 
	 * @param userId
	 * @return UserProfileResponse
	 * 
	 */
	@Override
	public boolean updateProfile(final UserProfileResponse userProfileResponse) {

		Service service = (Service) StubInvokerUtil.invokeStub(
				updateProfileurl, HttpMethod.POST, Service.class);
		String status = service.getStatus();
		if (status != null && STATUS.equalsIgnoreCase(status)) {
			return true;
		}
		return false;
	}

	/**
	 * This method is used for getting area of interest.
	 * 
	 * @return ESBResponse
	 * 
	 */
	@Override
	public ESBResponse getAreaOfInterests() {

		return (ESBResponse) StubInvokerUtil.invokeStub(areaofInterestsurl,
				HttpMethod.GET, ESBResponse.class);
	}

	/**
	 * This method is used for getting job categories.
	 * 
	 * @return JobCategories
	 * 
	 */
	@Override
	public JobCategories getJobCategories() {

		return (JobCategories) StubInvokerUtil.invokeStub(jobCategoriesurl,
				HttpMethod.GET, JobCategories.class);
	}

	/**
	 * This method is used for getting industries.
	 * 
	 * @return Industries
	 * 
	 */
	@Override
	public Industries getIndustries() {

		return (Industries) StubInvokerUtil.invokeStub(industriesurl,
				HttpMethod.GET, Industries.class);
	}

	/**
	 * This method is used for getting countries.
	 * 
	 * @return ESBResponse
	 * 
	 */
	@Override
	public ESBResponse getCountries() {

		return (ESBResponse) StubInvokerUtil.invokeStub(countriesurl,
				HttpMethod.GET, ESBResponse.class);
	}

	/**
	 * This method is used for getting states.
	 * 
	 * @return ESBResponse
	 * 
	 */
	@Override
	public ESBResponse getStates() {

		return (ESBResponse) StubInvokerUtil.invokeStub(statesurl,
				HttpMethod.GET, ESBResponse.class);
	}

	/**
	 * This method is used for getting institution list.
	 * 
	 * @return DropDown
	 * 
	 */
	@Override
	public DropDown getInstitutionsList() {

		return (DropDown) StubInvokerUtil.invokeStub(institutionsurl,
				HttpMethod.GET, DropDown.class);
	}

	/**
	 * This method is used for getting department list.
	 * 
	 * @return DropDown
	 * 
	 */
	@Override
	public DropDown getDepartmentsList() {

		return (DropDown) StubInvokerUtil.invokeStub(departmentsurl,
				HttpMethod.GET, DropDown.class);
	}

	/**
	 * This method is used for getting research funders.
	 * 
	 * @return DropDown
	 * 
	 */
	@Override
	public DropDown getReasearchFunder() {

		return (DropDown) StubInvokerUtil.invokeStub(researchFundersurl,
				HttpMethod.GET, DropDown.class);
	}

	/**
	 * This method is used for getting society list.
	 * 
	 * @return DropDown
	 * 
	 */
	@Override
	public DropDown getSocietyList() {

		return (DropDown) StubInvokerUtil.invokeStub(societiesurl,
				HttpMethod.GET, DropDown.class);
	}
}
