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
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;

/**
 * The Interface UserProfiles.
 */
public interface UserProfiles {

    /**
     * Gets the user profile response.
     *
     * @param userId
     *            the user id
     * @return the user profile response
     */
    UserProfileResponse getUserProfileResponse(String userId);

    /**
     * Update profile.
     *
     * @param userProfileResponse
     *            the user profile response
     * @return true, if successful
     */
    boolean updateProfile(UserProfileResponse userProfileResponse);

    /**
     * Gets the area of interests.
     *
     * @return the area of interests
     */
    ESBResponse getAreaOfInterests();

    /**
     * Gets the job categories.
     *
     * @return the job categories
     */
    JobCategories getJobCategories();

    /**
     * Gets the industries.
     *
     * @return the industries
     */
    Industries getIndustries();

    /**
     * Gets the countries.
     *
     * @return the countries
     */
    ESBResponse getCountries();

    /**
     * Gets the states.
     *
     * @return the states
     */
    ESBResponse getStates();

    /**
     * Gets the institutions list.
     *
     * @return the institutions list
     */
    DropDown getInstitutionsList();

    /**
     * Gets the departments list.
     *
     * @return the departments list
     */
    DropDown getDepartmentsList();

    /**
     * Gets the reasearch funder.
     *
     * @return the reasearch funder
     */
    DropDown getReasearchFunder();

    /**
     * Gets the society list.
     *
     * @return the society list
     */
    DropDown getSocietyList();
}
