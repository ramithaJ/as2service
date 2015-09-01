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

import com.wiley.gr.ace.authorservices.model.AccessReasons;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.Department;
import com.wiley.gr.ace.authorservices.model.Industry;
import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.JobCategory;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Role;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.State;
import com.wiley.gr.ace.authorservices.model.Suffix;
import com.wiley.gr.ace.authorservices.model.Title;

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
    List<Title> getTitles();

    /**
     * Gets the suffixes.
     *
     * @return the suffixes
     */
    List<Suffix> getSuffixes();

    /**
     * Gets the industries.
     *
     * @param count
     *            the count
     * @return the industries
     */
    List<Industry> getIndustries(Integer count);

    /**
     * Gets the job categories.
     *
     * @param count
     *            the count
     * @return the job categories
     */
    List<JobCategory> getJobCategories(Integer count);

    /**
     * Gets the countries.
     *
     * @param count
     *            the count
     * @return the countries
     */
    List<Country> getCountries(Integer count);

    /**
     * Gets the states.
     *
     * @param countrycode
     *            the countrycode
     * @param count
     *            the count
     * @return the states
     */
    List<State> getStates(String countrycode);

    /**
     * Gets the institutions.
     *
     * @return the institutions
     */
    List<Institution> getInstitutions();

    /**
     * Gets the departments.
     *
     * @return the departments
     */
    List<Department> getDepartments();

    /**
     * Gets the research funders.
     *
     * @return the research funders
     */
    List<ResearchFunder> getResearchFunders();

    /**
     * Gets the societies.
     *
     * @return the societies
     */

    List<Society> getSocieties();

    /**
     * Gets the areas of interests.
     *
     * @return the areas of interests
     */
    List<Interests> getAreasOfInterests();

    /**
     * Gets the security questions.
     *
     * @return the security questions
     */
    List<SecurityDetails> getSecurityQuestions();

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
