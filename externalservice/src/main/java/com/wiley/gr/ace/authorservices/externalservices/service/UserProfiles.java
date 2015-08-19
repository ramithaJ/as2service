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

package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.DropDown;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;

/**
 * The Interface UserProfiles.
 */
public interface UserProfiles {

    /**
     * Gets the countries.
     *
     * @return the countries
     */
    ESBResponse getCountries();

    /**
     * Gets the departments list.
     *
     * @param institutionId
     *            the institution id
     * @return the departments list
     */
    ESBResponse getDepartmentsList(String institutionId);

    /**
     * Gets the industries.
     *
     * @return the industries
     */
    ESBResponse getIndustries();

    /**
     * Gets the institutions list.
     *
     * @return the institutions list
     */
    ESBResponse getInstitutionsList();

    /**
     * Gets the job categories.
     *
     * @return the job categories
     */
    ESBResponse getJobCategories();

    /**
     * Gets the reasearch funder.
     *
     * @return the reasearch funder
     */
    DropDown getReasearchFunder();

    /**
     * Gets the states.
     *
     * @param countrycode
     *            the countrycode
     * @return the states
     */
    ESBResponse getStates(String countrycode);

    /**
     * Gets the user profile response.
     *
     * @param userId
     *            the user id
     * @return the user profile response
     */
    LookupCustomerProfile getUserProfileResponse(int userId);

    /**
     * Update profile.
     *
     * @param userId
     *            the user id
     * @param userProfileResponse
     *            the user profile response
     * @return the user profile response
     */
    LookupCustomerProfile updateProfile(int userId,
            UserProfileResponse userProfileResponse);

    /**
     * Gets the lookup customer profile.
     *
     * @param userId
     *            the user id
     * @return the lookup customer profile
     */
    LookupCustomerProfile getLookupCustomerProfile(String userId);

    /**
     * Update lookup customer profile.
     *
     * @param lookupCustomerProfileResponse
     *            the lookup customer profile response
     * @return the lookup customer profile response
     * @throws Exception
     *             the exception
     */
    LookupCustomerProfileResponse updateLookupCustomerProfile(
            LookupCustomerProfileResponse lookupCustomerProfileResponse)
            throws Exception;

    /**
     * Customer profile update.
     *
     * @param lookupCustomerProfileResponse
     *            the lookup customer profile response
     * @return customer profile response
     */
    boolean customerProfileUpdate(
            LookupCustomerProfileResponse lookupCustomerProfileResponse);
}
