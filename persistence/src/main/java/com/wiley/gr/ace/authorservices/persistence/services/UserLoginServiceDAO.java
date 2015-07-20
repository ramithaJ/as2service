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
import com.wiley.gr.ace.authorservices.persistence.entity.Users;

/**
 * The Interface UserLoginServiceDAO.
 *
 * @author virtusa version 1.0
 */
public interface UserLoginServiceDAO {

    /**
     * This method validates the the email Address .
     *
     * @param emailId
     *            to validate the emailId.
     * @return true, if successful.
     */
    boolean validateEmailAddress(String emailId);

    /**
     * This method gets the userId.
     * 
     * @param emailId
     *            to get the userId.
     * @return the userId.
     */
    Users getUserId(String emailId);

    /**
     * This method gets the reset password log.
     * 
     * @param guid
     *            to get InviteResetpwdLog.
     * @return the InviteResetpwdLog.
     */
    InviteResetpwdLog getinviteResetpwdLog(String guid);

    /**
     * This method verifying the updated emailId.
     * 
     * @param emailId
     *            to verify the updated emailId.
     * 
     */
    void verifyEmailUpdate(String emailId);

}
