/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */

package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.DropDown;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.lookup.LookupCustomerProfile;

/**
 * The Class UserProfilesImpl.
 *
 * @author virtusa
 * @version 1.0
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

    /** The lookupCustomerProfileResponse. */
    @Value("${lookupCustomerProfileResponse.url}")
    private String lookupCustomerProfileResponse;

    /** The updateLookupCustomerProfile. */
    @Value("${updateLookupCustomerProfile.url}")
    private String updateLookupCustomerProfile;

    /**
     * This method is used for getting area of interest.
     *
     * @return ESBResponse
     *
     */
    @Override
    public final ESBResponse getAreaOfInterests() {

        return (ESBResponse) StubInvokerUtil.invokeStub(areaofInterestsurl,
                HttpMethod.GET, ESBResponse.class);
    }

    /**
     * This method is used for getting countries.
     *
     * @return ESBResponse
     *
     */
    @Override
    public final ESBResponse getCountries() {

        return (ESBResponse) StubInvokerUtil.invokeStub(countriesurl,
                HttpMethod.GET, ESBResponse.class);
    }

    /**
     * This method is used for getting department list.
     *
     * @return DropDown
     *
     */
    @Override
    public final DropDown getDepartmentsList() {

        return (DropDown) StubInvokerUtil.invokeStub(departmentsurl,
                HttpMethod.GET, DropDown.class);
    }

    /**
     * This method is used for getting industries.
     *
     * @return Industries
     *
     */
    @Override
    public final Industries getIndustries() {

        return (Industries) StubInvokerUtil.invokeStub(industriesurl,
                HttpMethod.GET, Industries.class);
    }

    /**
     * This method is used for getting institution list.
     *
     * @return DropDown
     *
     */
    @Override
    public final DropDown getInstitutionsList() {

        return (DropDown) StubInvokerUtil.invokeStub(institutionsurl,
                HttpMethod.GET, DropDown.class);
    }

    /**
     * This method is used for getting job categories.
     *
     * @return JobCategories
     *
     */
    @Override
    public final JobCategories getJobCategories() {

        return (JobCategories) StubInvokerUtil.invokeStub(jobCategoriesurl,
                HttpMethod.GET, JobCategories.class);
    }

    /**
     * This method is used for getting research funders.
     *
     * @return DropDown
     *
     */
    @Override
    public final DropDown getReasearchFunder() {

        return (DropDown) StubInvokerUtil.invokeStub(researchFundersurl,
                HttpMethod.GET, DropDown.class);
    }

    /**
     * This method is used for getting states.
     *
     * @return ESBResponse
     *
     */
    @Override
    public final ESBResponse getStates() {

        return (ESBResponse) StubInvokerUtil.invokeStub(statesurl,
                HttpMethod.GET, ESBResponse.class);
    }

    /**
     * This method is used for getting userProfile response.
     *
     * @param userId
     *            the user id
     * @return UserProfileResponse
     */
    @Override
    @Cacheable(value = "userProfile", key = "#userId")
    public final UserProfileResponse getUserProfileResponse(final int userId) {

        return (UserProfileResponse) StubInvokerUtil.invokeStub(userProfileurl,
                HttpMethod.GET, UserProfileResponse.class);
    }

    /**
     * This method is used for getting userProfile response and put the updated
     * userProfile object into Redis cache.
     *
     * @param userId
     *            the user id
     * @param userProfileResponse
     *            the user profile response
     * @return UserProfileResponse
     */
    @Override
    @CachePut(value = "userProfile", key = "#userId")
    public final UserProfileResponse updateProfile(final int userId,
            final UserProfileResponse userProfileResponse) {
        final Service service = (Service) StubInvokerUtil.invokeStub(
                updateProfileurl, HttpMethod.POST, Service.class);
        final String status = service.getStatus();
        if (status != null && "success".equalsIgnoreCase(status)) {
            return getUserProfile();
        }

        return null;
    }

    /**
     * This method is used for getting userProfile response.
     * 
     * @return UserProfileResponse
     */
    private UserProfileResponse getUserProfile() {
        return (UserProfileResponse) StubInvokerUtil.invokeStub(userProfileurl,
                HttpMethod.GET, UserProfileResponse.class);
    }

    /**
     * Gets the lookup customer profile.
     *
     * @param userId
     *            the user id
     * @return the lookup customer profile
     */
    @Override
    public LookupCustomerProfile getLookupCustomerProfile(final String userId) {
        return (LookupCustomerProfile) StubInvokerUtil.invokeStub(
                lookupCustomerProfileResponse + userId + "&ECID=",
                HttpMethod.GET, LookupCustomerProfile.class);
    }

    @Override
    public LookupCustomerProfile updateLookupCustomerProfile(
            final LookupCustomerProfile lookupCustomerProfile) throws Exception {
        final Service service = (Service) StubInvokerUtil.invokeStub(
                updateLookupCustomerProfile, HttpMethod.POST, Service.class);
        final String status = service.getStatus();
        if (status != null && "success".equalsIgnoreCase(status)) {
            return lookupCustomerProfile;
        } else {
            return null;
        }
    }

}
