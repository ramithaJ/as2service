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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.external.ALMCreateUser;
import com.wiley.gr.ace.authorservices.model.external.ALMCreateUserRespnse;
import com.wiley.gr.ace.authorservices.model.external.ALMSearchUserResponse;
import com.wiley.gr.ace.authorservices.model.external.ALMUpdateUser;

// TODO: Auto-generated Javadoc
/**
 * The Interface ALMInterfaceService.
 */
public interface ALMInterfaceService {

    /**
     * Creates the user.
     *
     * @param almCreateUser
     *            the alm create user
     * @return the ALM create user respnse
     */
    ALMCreateUserRespnse createUser(ALMCreateUser almCreateUser);

    /**
     * Search user.
     *
     * @param email
     *            the email
     * @return the ALM search user response
     */
    ALMSearchUserResponse searchUser(String email);

    /**
     * Update user.
     *
     * @param almUpdateUser
     *            the alm update user
     * @return the ALM response
     */
    void updateUser(ALMUpdateUser almUpdateUser);
}
