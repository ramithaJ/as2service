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
package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.autocomplete.cache.model.CacheData;
import com.wiley.gr.ace.authorservices.model.AccessReasons;
import com.wiley.gr.ace.authorservices.model.Role;
import com.wiley.gr.ace.authorservices.model.external.RetrieveSecurityQuestions;

/**
 * The Interface ASDataService.
 *
 * @author virtusa version 1.0
 */
public interface ASDataService {

    /**
     * Gets the titles.
     *
     * @return the titles
     */
    List<CacheData> getTitles();

    /**
     * Gets the suffixes.
     *
     * @return the suffixes
     */
    List<CacheData> getSuffixes();

    /**
     * Gets the industries.
     *
     * @param count
     *            the count
     * @return the industries
     */
    List<CacheData> getIndustries();

    /**
     * Gets the job categories.
     *
     * @param count
     *            the count
     * @return the job categories
     */
    List<CacheData> getJobCategories();

    /**
     * Gets the countries.
     *
     * @param count
     *            the count
     * @return the countries
     */
    List<CacheData> getCountries();

    /**
     * Gets the states.
     *
     * @param countrycode
     *            the countrycode
     * @param count
     *            the count
     * @return the states
     */
    List<CacheData> getStates(String countrycode);

    /**
     * Gets the institutions.
     *
     * @return the institutions
     */
    List<CacheData> getInstitutions();

    /**
     * Gets the departments.
     *
     * @return the departments
     */
    List<CacheData> getDepartments();

    /**
     * Gets the research funders.
     *
     * @return the research funders
     */
    List<CacheData> getResearchFunders();

    /**
     * Gets the societies.
     *
     * @return the societies
     */

    List<CacheData> getSocieties();

    /**
     * Gets the areas of interests.
     *
     * @param count
     *            the count
     * @return the areas of interests
     */
    List<CacheData> getAreasOfInterests();

    /**
     * Gets the security questions.
     *
     * @return the security questions
     */
    RetrieveSecurityQuestions getSecurityQuestions();

    /**
     * Gets the admin roles.
     *
     * @param roleType
     *            the role type
     * @return the admin roles
     */
    List<Role> getAdminRoles(String roleType);

    /**
     * Gets the access reasons.
     *
     * @return the access reasons
     */
    List<AccessReasons> getAccessReasons();

}
