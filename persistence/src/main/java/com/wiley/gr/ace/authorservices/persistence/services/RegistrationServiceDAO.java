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
package com.wiley.gr.ace.authorservices.persistence.services;

import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;

/**
 * The Interface RegistrationServiceDAO.
 *
 * @author virtusa version 1.0
 */
public interface RegistrationServiceDAO {

    /**
     * This method search the User by using orcidId.
     * 
     * @param orcidId
     *            to Retrieve.
     * @return the boolean value.
     * @throws Exception
     *             if unable to search.
     */
    boolean searchUserByOrcidId(String orcidId) throws Exception;

    /**
     * This method gets the Invitation Records.
     * 
     * @param guid
     *            to Retrieve.
     * @return the InviteResetpwdLog.
     */
    InviteResetpwdLog getInvitationRecords(String guid);

    /**
     * This method Assigns the Role to New Registration.
     * 
     * @param emaildId
     *            to assign.
     */
    void assignRoleToNewRegistration(String emaildId);

}
