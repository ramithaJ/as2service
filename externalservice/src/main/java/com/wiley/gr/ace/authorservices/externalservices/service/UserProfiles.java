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

}
