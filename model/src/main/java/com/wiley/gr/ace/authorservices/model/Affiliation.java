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

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author SarmaKumarap
 */
@JsonInclude(Include.NON_NULL)
public class Affiliation {
    
    /** The user Id . */
	private String affiliationId;
    private String userId;
    
    private String institutionId;
    
    private String departmentId;
    
    public String getAffiliationId() {
		return affiliationId;
	}

	public void setAffiliationId(String affiliationId) {
		this.affiliationId = affiliationId;
	}

	private String departmentName;
    
    private String visibility;
    
    private String type;
    
    private String roleTitle;
    
    private String city;
    
    private String stateCode;
    
    private String countryCode;
    
    private Date startDate;
    
    private Date endDate;
    
    private Organization organization;
    
    private DisambiguatedOrganization disambiguatedOrganization;
    public DisambiguatedOrganization getDisambiguatedOrganization() {
        return disambiguatedOrganization;
    }

    public void setDisambiguatedOrganization(
            DisambiguatedOrganization disambiguatedOrganization) {
        this.disambiguatedOrganization = disambiguatedOrganization;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    /**
     * Gets the user Id.
     *
     * @return the user Id
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * Sets the user Id.
     *
     * @return the user Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * @return
     */
    public String getInstitutionId() {
        return institutionId;
    }
    
    /**
     * @param institutionId
     */
    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }
    
    /**
     * @return
     */
    public String getDepartmentId() {
        return departmentId;
    }
    
    /**
     * @param departmentId
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    
    /**
     * @return
     */
    public String getCity() {
        return city;
    }
    
    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    /**
     * @return
     */
    public String getStateCode() {
        return stateCode;
    }
    
    /**
     * @param stateCode
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    
    /**
     * @return
     */
    public String getCountryCode() {
        return countryCode;
    }
    
    /**
     * @param countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    /**
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }
    
    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    /**
     * @return
     */
    public Date getEndDate() {
        return endDate;
    }
    
    /**
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}
