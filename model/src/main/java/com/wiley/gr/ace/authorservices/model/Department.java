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
public class Department {
    
    /** The department id. */
    private String departmentId;
    
    /** The department name. */
    private String departmentName;
    
    /**
     * Gets the department id.
     *
     * @return the department id
     */
    public String getDepartmentId() {
        return departmentId;
    }
    
    /**
     * Sets the department id.
     *
     * @param departmentId
     *            the new department id
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
    
    /**
     * Gets the department name.
     *
     * @return the department name
     */
    public String getDepartmentName() {
        return departmentName;
    }
    
    /**
     * Sets the department name.
     *
     * @param departmentName
     *            the new department name
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
}
