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

import com.wiley.gr.ace.authorservices.model.InviteRecords;
import com.wiley.gr.ace.authorservices.model.User;

/**
 * @author virtusa version 1.0
 */
public interface RegistrationService {

    /**
     * @param user
     * @return
     * @throws Exception
     */
    String createUser(User user) throws Exception;

    /**
     * @param firstName
     * @param lastName
     * @return
     * @throws Exception
     */
    List<User> getUserFromFirstNameLastName(String firstName, String lastName)
            throws Exception;

    /**
     * @param emailId
     * @return
     * @throws Exception
     */
    User checkEmailIdExists(String emailId) throws Exception;

    /**
     * @param orcidId
     * @return
     * @throws Exception
     */
    boolean searchUserByOrcidId(String orcidId) throws Exception;

    /**
     * @param guid
     * @return
     * @throws Exception
     */
    InviteRecords searchInvitationRecord(String guid) throws Exception;

    /**
     * @param emailId
     */
    void assignRoleToNewUser(String emailId);

}
