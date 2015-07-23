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
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.external.ForcefulReset;
import com.wiley.gr.ace.authorservices.model.external.PasswordRequest;
import com.wiley.gr.ace.authorservices.model.external.PasswordResetRequest;
import com.wiley.gr.ace.authorservices.model.external.RetrieveSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestionsUpdateRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestionsValidateRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;
import com.wiley.gr.ace.authorservices.model.external.UserEmailDetails;

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
     * Update password.
     *
     * @param passwordDetails
     *            the password details
     * @return true, if successful
     */
    boolean updatePassword(PasswordRequest passwordRequest);

    /**
     * Reset password.
     *
     * @param securityDetailsHolder
     *            the security details holder
     * @return true, if successful
     */
    boolean resetPassword(PasswordResetRequest passwordResetRequest);

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
    boolean forceFulReset(ForcefulReset forcefulReset);

    /**
     * Update security details.
     *
     * @param securityDetails
     *            the security details
     * @return true, if successful
     */
    boolean updateSecurityDetails(
            SecurityQuestionsUpdateRequest securityQuestionsUpdateRequest);

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
    RetrieveSecurityQuestions userSecurityQuestions(String emailId);

    /**
     * @param emailId
     * @return
     */
    RetrieveSecurityQuestions lookupSecutityQuestions();

    /**
     * @param securityQuestionsValidateRequest
     * @return
     */
    boolean validateSecurityQuestions(
            SecurityQuestionsValidateRequest securityQuestionsValidateRequest);

}
