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
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.CustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfileResponse;
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
    private UserProfiles userProfileService;

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
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean updateOrcidId(final String emailId,
            final String orcidId, final String userId) throws Exception {
        LOGGER.info("inside updateOrcidId method of UpdateUserServiceImpl");
        boolean result = false;
        LookupCustomerProfile lookupCustomerProfile = userProfileService
                .getLookupCustomerProfile(userId);
        if (!StringUtils.isEmpty(lookupCustomerProfile)) {
            LOGGER.info("LookupCustomerProfile data is found");
            LookupCustomerProfileResponse lookupCustomerProfileResponse = lookupCustomerProfile
                    .getLookupCustomerProfileResponse();
            if (!StringUtils.isEmpty(lookupCustomerProfileResponse)) {
                LOGGER.info("LookupCustomerProfileResponse  data is found");
                lookupCustomerProfile
                        .setLookupCustomerProfileResponse(updateOrcidDetails(
                                lookupCustomerProfileResponse, orcidId));
                result = null != userProfileService
                        .updateLookupCustomerProfile(lookupCustomerProfile);
            }
        }
        return result;
    }

    /**
     * Update orcid details.
     *
     * @param lookupCustomerProfileResponse
     *            the lookup customer profile response
     * @param orcidId
     *            the orcid id
     * @return the lookup customer profile response
     */
    private LookupCustomerProfileResponse updateOrcidDetails(
            final LookupCustomerProfileResponse lookupCustomerProfileResponse,
            final String orcidId) {
        LOGGER.info(" inside updateOrcidDetails method UpdateUserServiceImpl");
        CustomerProfile customerProfile = lookupCustomerProfileResponse
                .getCustomerProfile();
        if (!StringUtils.isEmpty(customerProfile)) {
            LOGGER.info(" CustomeProfile Data is Found");
            CustomerDetails customerDetails = customerProfile
                    .getCustomerDetails();
            if (StringUtils.isEmpty(customerDetails.getOrcId())) {
                LOGGER.info(" Orcid is Not Found then Update");
                customerDetails.setOrcId(orcidId);
                customerProfile.setCustomerDetails(customerDetails);
                lookupCustomerProfileResponse
                        .setCustomerProfile(customerProfile);
            }
        }
        return lookupCustomerProfileResponse;
    }
}
