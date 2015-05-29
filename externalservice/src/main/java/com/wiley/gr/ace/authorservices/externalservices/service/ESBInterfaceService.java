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
package com.wiley.gr.ace.authorservices.externalservices.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;
import com.wiley.gr.ace.authorservices.model.external.Status;

/**
 * @author Virtusa
 */
public interface ESBInterfaceService {
    
    User fetchOrcidDetails(String orcid) throws Exception;
    
    String updateALMUser(User user) throws Exception;
    
    ESBUser checkEmailIdExists(String emailId) throws Exception;
    
    List<User> getUsersFromFirstNameLastName(String email, String firstName,
            String lastName) throws Exception;
    
    Status creatUser(ProfileInformation profileForCreation) throws Exception;
    
}
