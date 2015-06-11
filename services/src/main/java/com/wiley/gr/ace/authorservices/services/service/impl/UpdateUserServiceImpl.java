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
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * @author virtusa version 1.0
 */
public class UpdateUserServiceImpl implements UpdateUserService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(UpdateUserServiceImpl.class);

    @Autowired
    UserProfiles userProfileService;

    @Override
    public boolean updateOrcidId(String emailId, String orcidId, String userId)
            throws Exception {
        LOGGER.info("inside updateOrcidId method of UpdateUserServiceImpl");
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
