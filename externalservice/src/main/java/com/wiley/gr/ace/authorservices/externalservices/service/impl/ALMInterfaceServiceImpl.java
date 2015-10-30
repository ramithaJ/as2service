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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.ALMCreateUser;
import com.wiley.gr.ace.authorservices.model.external.ALMCreateUserRespnse;
import com.wiley.gr.ace.authorservices.model.external.ALMResponse;
import com.wiley.gr.ace.authorservices.model.external.ALMSearchUserResponse;
import com.wiley.gr.ace.authorservices.model.external.ALMUpdateUser;

/**
 * The Class ALMInterfaceServiceImpl.
 */
public class ALMInterfaceServiceImpl implements ALMInterfaceService {

    @Value("${alm-create.url}")
    private String almCreateUrl;

    @Value("${alm-search.url}")
    private String almSearchUrl;

    @Value("${alm-update.url}")
    private String almUpdateUrl;

    /**
     * Creates the user.
     *
     * @param almCreateUser
     *            the alm user
     * @return the ALM create user respnse
     */
    @Override
    public ALMCreateUserRespnse createUser(final ALMCreateUser almCreateUser) {
        return (ALMCreateUserRespnse) StubInvokerUtil
                .restServiceResponseInvoker(almCreateUrl, HttpMethod.PUT,
                        almCreateUser, ALMCreateUserRespnse.class, null);
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
        String serachURL = almSearchUrl.concat("?Email=").concat(email);
        return (ALMSearchUserResponse) RestServiceInvokerUtil.getServiceData(
                serachURL, ALMSearchUserResponse.class);
    }

    /**
     * Update user.
     *
     * @param almUser
     *            the alm user
     * @return the ALM response
     */
    @Override
    public void updateUser(final ALMUpdateUser almUpdateUser) {

        RestServiceInvokerUtil.restServiceInvoker(almUpdateUrl, almUpdateUser,
                ALMResponse.class);
    }
}
