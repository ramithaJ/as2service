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
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
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
     * @param passwordRequest
     *            the password details
     * @return true, if successful
     */
    boolean updatePassword(PasswordRequest passwordRequest);

    /**
     * Reset password.
     *
     * @param passwordResetRequest
     *            the password reset request
     * @return true, if successful
     */
    boolean resetPassword(PasswordResetRequest passwordResetRequest);

    /**
     * Update user id.
     *
     * @param userEmailDetails
     *            the user email details
     * @return true, if successful
     */
    boolean updateUserId(UserEmailDetails userEmailDetails);

    /**
     * Force ful reset.
     *
     * @param forcefulReset
     *            the forceful reset
     * @return true, if successful
     */
    boolean forceFulReset(ForcefulReset forcefulReset);

    /**
     * Update security details.
     *
     * @param securityQuestionsUpdateRequest
     *            the security questions update request
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
     * Lookup secutity questions.
     *
     * @return the retrieve security questions
     */
    RetrieveSecurityQuestions lookupSecutityQuestions();

    /**
     * Validate security questions.
     *
     * @param securityQuestionsValidateRequest
     *            the security questions validate request
     * @return true, if successful
     */
    boolean validateSecurityQuestions(
            SecurityQuestionsValidateRequest securityQuestionsValidateRequest);

    /**
     * @param userId
     *            - the request value
     * @return LookupCustomerProfile
     */
    LookupCustomerProfile updateProfile(String userId);
}
