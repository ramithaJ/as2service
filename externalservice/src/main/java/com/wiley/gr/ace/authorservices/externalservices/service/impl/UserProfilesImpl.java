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

import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.DropDown;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.ErrorPayLoad;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.ResponseStatus;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;

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

    /** The departmentspreurl. */
    @Value("${departmentspre.url}")
    private String departmentspreurl;

    /** The departmentsurl. */
    @Value("${departmentspost.url}")
    private String departmentsposturl;

    /** The research fundersurl. */
    @Value("${reasearchFunders.url}")
    private String researchFundersurl;

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

    /** The states url append. */
    @Value("${statesurl.append}")
    private String statesUrlAppend;

    /** The lookupCustomerProfileResponse. */
    @Value("${lookupCustomerProfileResponse.url}")
    private String lookupCustomerProfileResponse;

    /** The updateLookupCustomerProfile. */
    @Value("${updateLookupCustomerProfile.url}")
    private String updateLookupCustomerProfile;

    /**
     * This method is used for getting countries.
     *
     * @return ESBResponse
     *
     */
    @Override
    public final ESBResponse getCountries() {

        return (ESBResponse) RestServiceInvokerUtil.pickListInvoker(
                countriesurl, ESBResponse.class);
    }

    /**
     * This method is used for getting department list.
     *
     * @param institutionId
     *            the institution id
     * @return ESBResponse
     */
    @Override
    public final ESBResponse getDepartmentsList(final String institutionId) {
        String departmenturl = departmentspreurl + institutionId
                + departmentsposturl;
        System.out.println(departmenturl);
        return (ESBResponse) RestServiceInvokerUtil.pickListInvoker(
                departmenturl, ESBResponse.class);
    }

    /**
     * This method is used for getting industries.
     *
     * @return ESBResponse
     *
     */
    @Override
    public final ESBResponse getIndustries() {

        return (ESBResponse) RestServiceInvokerUtil.pickListInvoker(
                industriesurl, ESBResponse.class);
    }

    /**
     * This method is used for getting institution list.
     *
     * @return ESBResponse
     *
     */
    @Override
    public final ESBResponse getInstitutionsList() {

        return (ESBResponse) RestServiceInvokerUtil.pickListInvoker(
                institutionsurl, ESBResponse.class);

    }

    /**
     * This method is used for getting job categories.
     *
     * @return ESBResponse
     *
     */
    @Override
    public final ESBResponse getJobCategories() {

        return (ESBResponse) RestServiceInvokerUtil.pickListInvoker(
                jobCategoriesurl, ESBResponse.class);
    }

    /**
     * This method is used for getting research funders.
     *
     * @return DropDown
     *
     */
    @Override
    public final DropDown getReasearchFunder() {

        return (DropDown) RestServiceInvokerUtil.invokeStub(researchFundersurl,
                HttpMethod.GET, DropDown.class);
    }

    /**
     * This method is used for getting states.
     *
     * @param countrycode
     *            the countrycode
     * @return ESBResponse
     */
    @Override
    public final ESBResponse getStates(final String countrycode) {

        String url = statesurl + countrycode + statesUrlAppend;
        System.err.println(url);

        return (ESBResponse) RestServiceInvokerUtil.pickListInvoker(url,
                ESBResponse.class);

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

        return (UserProfileResponse) RestServiceInvokerUtil.invokeStub(
                userProfileurl, HttpMethod.GET, UserProfileResponse.class);
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
        final Service service = (Service) RestServiceInvokerUtil.invokeStub(
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
        return (UserProfileResponse) RestServiceInvokerUtil.invokeStub(
                userProfileurl, HttpMethod.GET, UserProfileResponse.class);
    }

    /**
     * Gets the lookup customer profile.
     *
     * @param userId
     *            the user id
     * @return the lookup customer profile
     */
    @Override
    public final LookupCustomerProfile getLookupCustomerProfile(
            final String userId) {
        return (LookupCustomerProfile) RestServiceInvokerUtil.invokeStub(
                lookupCustomerProfileResponse + userId + "&ECID=",
                HttpMethod.GET, LookupCustomerProfile.class);
    }

    /**
     * Update lookup customer profile.
     *
     * @param lookupCustomerProfileResponse
     *            the lookup customer profile response
     * @return the lookup customer profile response
     * @throws Exception
     *             the exception
     */
    @Override
    public final LookupCustomerProfileResponse updateLookupCustomerProfile(
            final LookupCustomerProfileResponse lookupCustomerProfileResponse)
            throws Exception {
        final Service service = (Service) RestServiceInvokerUtil.invokeStub(
                updateLookupCustomerProfile, HttpMethod.POST, Service.class);
        final String status = service.getStatus();
        if (status != null && "success".equalsIgnoreCase(status)) {
            return lookupCustomerProfileResponse;
        } else {
            return null;
        }
    }

    /**
     * Calling external service to Update look up profile.
     *
     * @param lookupCustomerProfileResponse
     *            the lookup customer profile response
     * @return boolean
     */
    @Override
    public final boolean customerProfileUpdate(
            final LookupCustomerProfileResponse lookupCustomerProfileResponse) {

        final ResponseStatus responseStatus = (ResponseStatus) RestServiceInvokerUtil
                .restServiceInvoker(updateLookupCustomerProfile,
                        lookupCustomerProfileResponse, ResponseStatus.class);
        boolean status = false;
        if ("success".equalsIgnoreCase(responseStatus.getStatus())) {
            status = true;
        }
        if ("failure".equalsIgnoreCase(responseStatus.getStatus())) {
            final ErrorPayLoad errorPayLoad = responseStatus.getError();
            throw new UserException(errorPayLoad.getErrorCode(),
                    errorPayLoad.getErrorMessage());
        }
        return status;

    }

}
