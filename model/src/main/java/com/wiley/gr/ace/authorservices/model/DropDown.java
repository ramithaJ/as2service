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

package com.wiley.gr.ace.authorservices.model;

import java.util.List;

/**
 * The Class DropDown.
 */
public class DropDown {

    /** The institutions. */
    List<Institution> institutions;

    /** The departments. */
    List<Department> departments;

    /** The research funders. */
    List<ResearchFunder> researchFunders;

    /** The society. */
    List<Society> society;

    /**
     * Gets the institutions.
     *
     * @return the institutions
     */
    public List<Institution> getInstitutions() {
        return institutions;
    }

    /**
     * Sets the institutions.
     *
     * @param institutions
     *            the new institutions
     */
    public void setInstitutions(List<Institution> institutions) {
        this.institutions = institutions;
    }

    /**
     * Gets the departments.
     *
     * @return the departments
     */
    public List<Department> getDepartments() {
        return departments;
    }

    /**
     * Sets the departments.
     *
     * @param departments
     *            the new departments
     */
    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    /**
     * Gets the research funders.
     *
     * @return the research funders
     */
    public List<ResearchFunder> getResearchFunders() {
        return researchFunders;
    }

    /**
     * Sets the research funders.
     *
     * @param researchFunders
     *            the new research funders
     */
    public void setResearchFunders(List<ResearchFunder> researchFunders) {
        this.researchFunders = researchFunders;
    }

    /**
     * Gets the society.
     *
     * @return the society
     */
    public List<Society> getSociety() {
        return society;
    }

    /**
     * Sets the society.
     *
     * @param society
     *            the new society
     */
    public void setSociety(List<Society> society) {
        this.society = society;
    }

}
