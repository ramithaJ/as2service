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

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author virtusa
 *	version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class SecurityDetailsHolder {
    
    @NotNull @NotEmpty
    private String emailId;
    
    private List<SecurityDetails> securityDetails = new ArrayList<SecurityDetails>();
    
    private String password;
    @JsonProperty
    private boolean isForceReset;
    
    /**
     * @return
     */
    public List<SecurityDetails> getSecurityDetails() {
        return securityDetails;
    }
    
    /**
     * @param securityDetails
     */
    public void setSecurityDetails(List<SecurityDetails> securityDetails) {
        this.securityDetails = securityDetails;
    }

    /**
     * @return
     */
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isForceReset() {
        return isForceReset;
    }

    public void setForceReset(boolean isForceReset) {
        this.isForceReset = isForceReset;
    }
    
    
}
