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

import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;

/**
 * @author kpshiva
 */
public interface UserLoginService {
    
    SecurityResponse login(SharedServieRequest sharedServieRequest);
    
    /**
     * @param emailId
     * @param newPassword
     * @return
     */
    boolean resetPassword(SecurityDetailsHolder securityDetailsHolder);
    
    /**
     * @param emailId
     * @return
     */
    boolean lockUser(String emailId);
    
    /**
     * @param emailId
     * @return
     */
    boolean unLockUser(String emailId);
    
    /**
     * @param emailId
     * @return
     */
    boolean validateEmailAddress(String emailId);
    
    /**
     * @param userId
     * @return
     */
    boolean isUserLocked(int userId);
    
    /**
     * @param userId
     * @param template_id
     */
    void sendEmail(String userId, String templateId);
    
    SecurityDetailsHolder securityQuestions(String emailId);
    
    boolean validateSecurityQuestions(String emailId,
            List<SecurityDetails> securityDetails);
}
