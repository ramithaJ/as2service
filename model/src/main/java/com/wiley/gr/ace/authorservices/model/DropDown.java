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
   private  List<Institution> institutions;

    /** The departments. */
   private  List<Department> departments;

    /** The research funders. */
   private  List<ResearchFunder> researchFunders;

    /** The society. */
   private   List<Society> society;

    /**
     * @return the institutions
     */
    public final List<Institution> getInstitutions() {
        return institutions;
    }

    /**
     * @param institutions
     *            the institutions to set
     */
    public final void setInstitutions(final List<Institution> institutions) {
        this.institutions = institutions;
    }

    /**
     * @return the departments
     */
    public final List<Department> getDepartments() {
        return departments;
    }

    /**
     * @param departments
     *            the departments to set
     */
    public final void setDepartments(final List<Department> departments) {
        this.departments = departments;
    }

    /**
     * @return the researchFunders
     */
    public final List<ResearchFunder> getResearchFunders() {
        return researchFunders;
    }

    /**
     * @param researchFunders
     *            the researchFunders to set
     */
    public final void setResearchFunders(final List<ResearchFunder> researchFunders) {
        this.researchFunders = researchFunders;
    }

    /**
     * @return the society
     */
    public final List<Society> getSociety() {
        return society;
    }

    /**
     * @param society
     *            the society to set
     */
    public final void setSociety(final List<Society> society) {
        this.society = society;
    }

}
