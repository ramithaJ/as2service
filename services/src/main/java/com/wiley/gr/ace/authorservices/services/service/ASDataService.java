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
 * @author virtusa version 1.0
 */
public interface ASDataService {

    /**
     * @return
     */
    List<Title> getTitles();

    /**
     * @return
     */
    List<Suffix> getSuffixes();

    /**
     * @return
     */
    List<Industry> getIndustries(Integer count);

    /**
     * @return
     */
    List<JobCategory> getJobCategories(Integer count);

    /**
     * @return
     */
    List<Country> getCountries(Integer count);

    /**
     * @return
     */
    List<State> getStates(String countrycode, Integer count);

    /**
     * @return
     */
    List<Institution> getInstitutions();

    /**
     * @return
     */
    List<Department> getDepartments();

    /**
     * @return
     */
    List<ResearchFunder> getResearchFunders();

    /**
     * @return
     */

    /**
     * @return
     */
    List<Society> getSocieties();

    /**
     * @return
     */
    List<Interests> getAreasOfInterests(Integer count);

    /**
     * @return
     */
    List<SecurityDetails> getSecurityQuestions();

    /**
     * @return
     */
    List<Role> getAdminRoles(String roleType);

    /**
     * @return
     */
    List<AccessReasons> getAccessReasons();

}
