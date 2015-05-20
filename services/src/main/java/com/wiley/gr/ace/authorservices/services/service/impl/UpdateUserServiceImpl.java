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

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * @author vkumark
 */
public class UpdateUserServiceImpl implements UpdateUserService {
    
    @Autowired(required = true)
    ESBInterfaceService esbInterfaceService;
    @Autowired(required = true)
    UpdateUserDAO userDao;
    
    /*
     * (non-Javadoc)
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
            System.out.println("ALM user update status :: " + status);
            
            if (null != status && status.equalsIgnoreCase("success")) {
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
     * @see com.wiley.gr.ace.authorservices.services.service.UpdateUserService#
     * updateOrcidId(java.lang.String, java.lang.String)
     */
    @Override
    public String updateOrcidId(String orcidId, String userId) throws Exception {
        
        String status = "";
        if (null != orcidId && null != userId) {
            /**
             * Update ORCID ID for the given user ID
             */
            status = userDao.updateUserOrcidId(orcidId, userId);
        } else {
            /**
             * TODO: Log the null message
             */
            status = "failure"; // Added this just to avoid PMD.
        }
        return status;
    }
    
}
