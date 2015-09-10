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

import java.util.ArrayList;

import com.wiley.gr.ace.authorservices.model.InviteRecords;
import com.wiley.gr.ace.authorservices.model.User;

/**
 * The Interface RegistrationService.
 *
 * @author virtusa version 1.0
 */
public interface RegistrationService {

    /**
     * Creates the user.
     *
     * @param user
     *            the user
     * @return the string
     * 
     */
    String createUser(User user);

    /**
     * Gets the user from first name last name.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the user from first name last name
     * 
     */
    ArrayList<User> getUserFromFirstNameLastName(String firstName,
            String lastName);

    /**
     * Check email id exists.
     *
     * @param emailId
     *            the email id
     * @return the user
     * 
     */
    User checkEmailIdExists(String emailId);

    /**
     * Search user by orcid id.
     *
     * @param orcidId
     *            the orcid id
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    boolean searchUserByOrcidId(String orcidId) throws Exception;

    /**
     * Search invitation record.
     *
     * @param guid
     *            the guid
     * @return the invite records
     * @throws Exception
     *             the exception
     */
    InviteRecords searchInvitationRecord(String guid) throws Exception;

    /**
     * Assign role to new user.
     *
     * @param emailId
     *            the email id
     */
    void assignRoleToNewUser(String emailId);

}
