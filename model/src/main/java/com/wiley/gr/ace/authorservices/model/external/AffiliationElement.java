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

package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class AffiliationElement.
 * 
 * @author virtusa version 1.0
 */
public class AffiliationElement {

    /** The institution. */
    private String institution;

    /** The department. */
    private String department;

    /** The city. */
    private String city;

    /** The enddate. */
    private String enddate;

    /** The startdate. */
    private String startdate;

    /** The state. */
    private String state;

    /**
     * Gets the institution.
     *
     * @return the institution
     */
    public final String getInstitution() {
        return institution;
    }

    /**
     * Sets the institution.
     *
     * @param institution
     *            the institution to set
     */
    public final void setInstitution(final String institution) {
        this.institution = institution;
    }

    /**
     * Gets the department.
     *
     * @return the department
     */
    public final String getDepartment() {
        return department;
    }

    /**
     * Sets the department.
     *
     * @param department
     *            the department to set
     */
    public final void setDepartment(final String department) {
        this.department = department;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public final String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city
     *            the city to set
     */
    public final void setCity(final String city) {
        this.city = city;
    }

    /**
     * Gets the enddate.
     *
     * @return the enddate
     */
    public final String getEnddate() {
        return enddate;
    }

    /**
     * Sets the enddate.
     *
     * @param enddate
     *            the enddate to set
     */
    public final void setEnddate(final String enddate) {
        this.enddate = enddate;
    }

    /**
     * Gets the startdate.
     *
     * @return the startdate
     */
    public final String getStartdate() {
        return startdate;
    }

    /**
     * Sets the startdate.
     *
     * @param startdate
     *            the startdate to set
     */
    public final void setStartdate(final String startdate) {
        this.startdate = startdate;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public final String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state
     *            the state to set
     */
    public final void setState(final String state) {
        this.state = state;
    }

}
