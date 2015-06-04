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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author virtusa
 *	version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class CoAuthor {
    
    private Integer userId;
    
    private String title;
    
    private String firstName;
    
    private String lastName;
    
    private String emailId;
    
    private String phone;
    
    private String institutionId;
    
    private String institutionName;
    
    private String departmentId;
    
    private String departmentName;
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    /**
     * @return
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * @return
     */
    public String getEmailId() {
        return emailId;
    }
    
    /**
     * @param emailId
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    /**
     * @return
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
    public String getInstitutionName() {
        return institutionName;
    }
    
    /**
     * @param institutionName
     */
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
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
    public String getDepartmentName() {
        return departmentName;
    }
    
    /**
     * @param departmentName
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
}
