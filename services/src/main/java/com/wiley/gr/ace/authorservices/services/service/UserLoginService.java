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

import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;

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
     * Validate email address.
     *
     * @param emailId
     *            the email id
     * @return true, if successful
     */
    boolean validateEmailAddress(String emailId);

    /**
     * Security questions.
     *
     * @param emailId
     *            the email id
     * @return the security details holder
     */
    SecurityDetailsHolder securityQuestions(String emailId);

    /**
     * Validate security questions.
     *
     * @param securityDetails
     *            the security details
     * @return true, if successful
     */
    boolean validateSecurityQuestions(List<SecurityDetails> securityDetails);

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
}
