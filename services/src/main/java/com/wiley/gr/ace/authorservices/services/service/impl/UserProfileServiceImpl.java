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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.external.LookUpProfile;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

/**
 * @author SarmaKumarap
 */
public class UserProfileServiceImpl implements UserProfileService {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserProfileServiceImpl.class);
    
    @Autowired(required = true)
    UserProfiles cdmservices;
    
    @Override
    public LookUpProfile lookUpProfile(String userId) {
        
    	LOGGER.info("in lookUpProfile Method");
        return cdmservices.lookUpProfile(userId);
    }
}
