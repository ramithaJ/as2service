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

import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.SecurityQuestionsList;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserLoginService.
 *
 * @author virtusa version 1.0
 */
public interface UserLoginService {

    /**
     * Login.
     *
     * @param login
     *            the login
     * @param sharedServieRequest
     *            the shared servie request
     * @return the object
     */
    SecurityResponse login(Login login, SharedServieRequest sharedServieRequest);

    /**
     * Reset password.
     *
     * @param securityDetailsHolder
     *            the security details holder
     * @return true, if successful
     */
    boolean resetPassword(SecurityDetailsHolder securityDetailsHolder);

    /**
     * Security questions.
     *
     * @param emailId
     *            the email id
     * @return the security details holder
     */
    SecurityQuestionsList userSecurityQuestions(String emailId);

    /**
     * Validate security questions.
     *
     * @param securityDetailsHolder
     *            the security details holder
     * @return true, if successful
     */
    boolean validateSecurityQuestions(
            SecurityDetailsHolder securityDetailsHolder);

    /**
     * Reset password.
     *
     * @param guid
     *            the guid
     * @return the string
     */
    String resetPassword(String guid);

    /**
     * Verify account update.
     *
     * @param guid
     *            the guid
     */
    void verifyAccountUpdate(String guid);

    /**
     * Insert guid.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @param emailAddress
     *            the email address
     * @return the string
     */
    String insertGuid(String firstName, String lastName, String emailAddress);

    /**
     * Search user in alm.
     *
     * @param emailId
     *            the email id
     * @return the user
     */
    User searchUserInALM(String emailId);

    /**
     * Search user in participant by alm id.
     *
     * @param almUserId
     *            the alm user id
     * @return true, if successful
     */
    boolean searchUserInParticipantByALMId(String almUserId);

    /**
     * Reset by email.
     *
     * @param emailId the email id
     * @return true, if successful
     */
    boolean resetByEmail(String emailId);
    
    /**
     * Gets the user details from participant service.
     *
     * @param emailId the email id
     * @return the user details from participant service
     */
    User getUserDetailsFromParticipantService(String emailId);
}
