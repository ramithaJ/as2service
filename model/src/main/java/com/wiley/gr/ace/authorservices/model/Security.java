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

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Virtusa
 */
@JsonInclude(Include.NON_NULL)
public class Security {
    
    @NotNull
    @NotBlank
    private int id1;
    
    @NotNull
    @NotBlank
    private int id2;
    
    @NotNull
    @NotBlank
    private String securityQuestion1;
    
    @NotNull
    @NotBlank
    private String securityQuestion2;
    
    @NotNull
    @NotBlank
    private String securityAnswer1;
    
    @NotNull
    @NotBlank
    private String securityAnswer2;
    
    public int getId1() {
        return id1;
    }
    
    public void setId1(int id1) {
        this.id1 = id1;
    }
    
    public int getId2() {
        return id2;
    }
    
    public void setId2(int id2) {
        this.id2 = id2;
    }
    
    /**
     * Gets the security question1.
     *
     * @return the security question1
     */
    public String getSecurityQuestion1() {
        return securityQuestion1;
    }
    
    /**
     * Sets the security question1.
     *
     * @param securityQuestion1
     *            the new security question1
     */
    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }
    
    public String getSecurityAnswer1() {
        return securityAnswer1;
    }
    
    /**
     * Sets the security answer1.
     *
     * @param securityAnswer1
     *            the new security answer1
     */
    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }
    
    /**
     * Gets the security answer2.
     *
     * @return the security answer2
     */
    public String getSecurityAnswer2() {
        return securityAnswer2;
    }
    
    /**
     * Sets the security answer2.
     *
     * @param securityAnswer2
     *            the new security answer2
     */
    public void setSecurityAnswer2(String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2;
    }
    
    public String getSecurityQuestion2() {
        return securityQuestion2;
    }
    
    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }
    
}
