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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;

/**
 * The Class UserAccountServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class UserAccountServiceImpl implements UserAccountService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserAccountServiceImpl.class);

    /** getting bean of userAccountDAO. */
    @Autowired(required = true)
    private UserAccountDAO userAccountDAO;

    /** getting bean of userProfile. */
    @Autowired
    private UserProfiles userProfile;

    /**
     * this method is for getting email Details by userId.
     *
     * @param userId
     *            the user id
     * @return the email details
     */
    @Override
    public final User getEmailDetails(final String userId) {

        LOGGER.info("inside getEmailDetails Method");

        UserProfileResponse lookupProfile = userProfile
                .getUserProfileResponse(userId);
        User user = new User();
        user.setPrimaryEmailAddr(lookupProfile.getCustomerProfile()
                .getCustomerDetails().getPrimaryEmailAddr());
        user.setRecoveryEmailAddress(lookupProfile.getCustomerProfile()
                .getCustomerDetails().getRecoveryEmailAddress());
        return user;

    }

    /**
     * this method will call the DAO to update security details which are
     * updated by user at userProfile level.
     *
     * @param userId
     *            the user id
     * @param securityDetails
     *            the security details
     * @return true, if successful
     */
    @Override
    public final boolean updateSecurityDetails(final String userId,
            final List<SecurityDetails> securityDetails) {

        LOGGER.info("inside updateSecurityDetails Method");
        return userAccountDAO.updateSecurityDetails(Integer.valueOf(userId),
                securityDetails);
    }

    /**
     * getting profie info by user id.
     *
     * @param userId
     *            the user id
     * @return the profile information
     */
    @Override
    public final User getProfileInformation(final String userId) {

        LOGGER.info("inside getProfileInformation Method");
        UserProfileResponse lookupProfile = userProfile
                .getUserProfileResponse(userId);
        return lookupProfile.getCustomerProfile().getCustomerDetails();
    }

    /**
     * getting UserAddress info by user id.
     *
     * @param userId
     *            the user id
     * @return the user address
     */
    @Override
    public final List<Addresses> getUserAddress(final String userId) {

        LOGGER.info("inside getUserAddress Method");
        UserProfileResponse lookupProfile = userProfile
                .getUserProfileResponse(userId);
        return lookupProfile.getCustomerProfile().getAddressDetails();
    }

}
