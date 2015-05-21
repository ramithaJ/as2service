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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kpshiva
 */
public class SecurityDetailsHolder implements Serializable {
    
    private String emailId;
    
    private List<SecurityDetails> securityDetails = new ArrayList<SecurityDetails>();
    
    private String password;
    
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
    
    
}
