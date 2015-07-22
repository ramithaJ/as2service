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
import com.wiley.gr.ace.authorservices.model.external.UserEmailDetails;
import com.wiley.gr.ace.authorservices.model.external.lookup.SecurityQuestions;

/**
 * The Interface UserManagement.
 *
 * @author virtusa version 1.0
 */
public interface UserManagement {

    /**
     * Authenticate user.
     *
     * @param sharedServieRequest
     *            the shared servie request
     * @return the security response
     */
    SecurityResponse authenticateUser(SharedServieRequest sharedServieRequest);

    /**
     * This method authenticates the user by calling the ALM LDAP Service.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    boolean authenticateAdminUser(String emailId);

    /**
     * Authenticate user alm.
     *
     * @param emailId
     *            the email id
     * @param password
     *            the password
     * @return true, if successful
     */
    boolean authenticateUserALM(String emailId, String password);

    /**
     * Update password.
     *
     * @param passwordDetails
     *            the password details
     * @return true, if successful
     */
    boolean updatePassword(PasswordDetails passwordDetails);

    /**
     * Reset password.
     *
     * @param securityDetailsHolder
     *            the security details holder
     * @return true, if successful
     */
    boolean resetPassword(SecurityDetailsHolder securityDetailsHolder);

    /**
     * Update user id.
     *
     * @param oldEmailId
     *            the old email id
     * @param newEmailId
     *            the new email id
     * @return true, if successful
     */
    boolean updateUserId(UserEmailDetails userEmailDetails);

    /**
     * Force ful reset.
     *
     * @param emailId
     *            the email id
     * @param newPassword
     *            the new password
     * @return true, if successful
     */
    boolean forceFulReset(String emailId, String newPassword);

    /**
     * Lock user.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    boolean lockUser(String emailId);

    /**
     * Un lock user.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    boolean unLockUser(String emailId);

    /**
     * Gets the security details.
     *
     * @param emailId
     *            the email id
     * @return SecurityDetailsHolder
     */
    SecurityDetailsHolder getSecurityDetails(String emailId);

    /**
     * Gets the security questions.
     *
     * @param emailId
     *            the email id
     * @return SecurityDetailsHolder
     */
    SecurityDetailsHolder getSecurityQuestions(String emailId);

    /**
     * Update security details.
     *
     * @param securityDetails
     *            the security details
     * @return true, if successful
     */
    boolean updateSecurityDetails(SecurityDetailsHolder securityDetails);

    /**
     * Gets the security question details.
     *
     * @param emailId
     *            the email id
     * @return the security question details
     */
    SecuirtyQuestionDetails getSecurityQuestionDetails(String emailId);

    /**
     * Find user.
     *
     * @param emailId
     *            the email id
     * @return the admin user
     */
    AdminUser findUser(String emailId);

    /**
     * Gets the security questions list.
     *
     * @param emailId
     *            the email id
     * @return the security questions list
     */
    SecurityQuestions getSecurityQuestionsList(String emailId);
}
