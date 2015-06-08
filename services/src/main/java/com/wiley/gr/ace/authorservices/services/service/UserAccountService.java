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

import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.User;

/**
 * @author virtusa
 *	version 1.0
 */
public interface UserAccountService {
    
    User getEmailDetails(String userId);
    
    boolean updateSecurityDetails(String userId,
            List<SecurityDetails> securityDetails);
    
    User getProfileInformation(String userId);
    
    List<Addresses> getUserAddress(String userId);
}
