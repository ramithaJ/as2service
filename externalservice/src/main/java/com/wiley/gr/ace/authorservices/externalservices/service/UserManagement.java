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

import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;

/**
 * @author Virtusa
 */
public interface UserManagement {

    SecurityResponse authenticateUser(SharedServieRequest sharedServieRequest);
                        
    /**
     * This method authenticates the user by calling the ALM LDAP Service
     * 
     * @param emailId
     * @param password
     * @return
     */
    boolean authenticateAdminUser(String emailId);

    /**
     * @param emailId
     * @param password
     * @return
     */
    boolean authenticateUserALM(String emailId, String password);

    /**
     * @param emailId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    boolean updatePassword(PasswordDetails passwordDetails);

    /**
     * @param emailId
     * @param newPassword
     * @return
     */
    boolean resetPassword(SecurityDetailsHolder securityDetailsHolder);

    /**
     * @param oldEmailId
     * @param newEmailId
     * @return
     */
    boolean updateUserId(String oldEmailId, String newEmailId);

    /**
     * @param emailId
     * @param newPassword
     * @return
     */
    boolean forceFulReset(String emailId, String newPassword);

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
     * @return SecurityDetailsHolder
     */
    SecurityDetailsHolder getSecurityDetails(String emailId);

    /**
     * @param emailId
     * @return SecurityDetailsHolder
     */
    SecurityDetailsHolder getSecurityQuestions(String emailId);

    /**
     * @param securityDetails
     * @return
     */
    boolean updateSecurityDetails(SecurityDetailsHolder securityDetails);

    /**
     * @param emailId
     * @return
     */
    SecuirtyQuestionDetails getSecurityQuestionDetails(String emailId);
    
    /**
     * @param emailId
     */
    AdminUser findUser(String emailId);
}
