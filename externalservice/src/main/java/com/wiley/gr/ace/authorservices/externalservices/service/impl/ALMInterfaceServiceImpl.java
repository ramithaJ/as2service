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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.ALMCreateUserRespnse;
import com.wiley.gr.ace.authorservices.model.external.ALMResponse;
import com.wiley.gr.ace.authorservices.model.external.ALMSearchUserResponse;
import com.wiley.gr.ace.authorservices.model.external.ALMUser;

/**
 * The Class ALMInterfaceServiceImpl.
 */
public class ALMInterfaceServiceImpl implements ALMInterfaceService {

    /**
     * Creates the user.
     *
     * @param almUser
     *            the alm user
     * @return the ALM create user respnse
     */
    @Override
    public ALMCreateUserRespnse createUser(final ALMUser almUser) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Search user.
     *
     * @param email
     *            the email
     * @return the ALM search user response
     */
    @Override
    public ALMSearchUserResponse searchUser(final String email) {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * Update user.
     *
     * @param almUser the alm user
     * @return the ALM response
     */
    @Override
    public ALMResponse updateUser(ALMUser almUser) {
        // TODO Auto-generated method stub
        return null;
    }

}
