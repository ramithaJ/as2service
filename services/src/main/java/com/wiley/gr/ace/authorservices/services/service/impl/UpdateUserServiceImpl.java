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
package com.wiley.gr.ace.authorservices.services.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * The Class UpdateUserServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class UpdateUserServiceImpl implements UpdateUserService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UpdateUserServiceImpl.class);

    /** Getting bean of userProfileService. */
    @Autowired
    private AuthorProfileService authorProfileService;

    /**
     * this method is for updating updateOrcidId by taking
     * emailId,orcidId,userId as input.
     *
     * @param emailId
     *            the email id
     * @param orcidId
     *            the orcid id
     * @param userId
     *            the user id
     * @return true, if successful
     */
    @Override
    public final boolean updateOrcidId(final String emailId,
            final String orcidId, final String userId) {
        LOGGER.info("inside updateOrcidId method of UpdateUserServiceImpl");
        return authorProfileService.updateOrcidId(userId, orcidId);
    }

}
