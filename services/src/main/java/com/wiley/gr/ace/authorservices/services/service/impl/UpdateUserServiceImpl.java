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
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * @author virtusa version 1.0
 */
public class UpdateUserServiceImpl implements UpdateUserService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrcidServiceImpl.class);

    @Autowired(required = true)
    ESBInterfaceService esbInterfaceService;
    @Autowired
    UserProfiles userProfileService;
    @Autowired(required = true)
    UpdateUserDAO userDao;

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.services.service.UpdateUserService#
     * updateOrcidProfile(java.lang.String)
     */
    @Override
    public User updateOrcidProfile(String orcidId, String userId)
            throws Exception {

        /**
         * Fetch Account details and Profile details from external service
         * (ESB->ORCID)
         */
        User user = esbInterfaceService.fetchOrcidDetails(orcidId);
        User updatedUser = null;
        if (user != null) {
            /**
             * Code to update ALM user attributes through ESB
             */
            String status = esbInterfaceService.updateALMUser(user);
            LOGGER.debug("ALM user update status :: " + status);

            if (null != status && "success".equalsIgnoreCase(status)) {
                /**
                 * Update the user account details with ORCID account details
                 */
                user.setUserId(Integer.parseInt(userId));
                updatedUser = userDao.updateUserWithOrcid(user);
            }
        }
        return updatedUser;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.services.service.UpdateUserService#
     * updateOrcidId(java.lang.String,java.lang.String, java.lang.String)
     */
    @Override
    public boolean updateOrcidId(String emailId, String orcidId, String userId)
            throws Exception {
        boolean result = false;
        UserProfileResponse userProfileResponse = userProfileService
                .userProfileResponse(userId);
        if (!StringUtils.isEmpty(userProfileResponse)) {
            UserProfile userProfile = userProfileResponse.getCustomerProfile();
            User user = userProfile.getCustomerDetails();
            if (StringUtils.isEmpty(user.getOrcidID())) {
                user.setOrcidID(orcidId);
                userProfile.setCustomerDetails(user);
                userProfileResponse.setCustomerProfile(userProfile);
                result = userProfileService.updateProfile(userProfileResponse);
            }
        }
        return result;
    }

}
