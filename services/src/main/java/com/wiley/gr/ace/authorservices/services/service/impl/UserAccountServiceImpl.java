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

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.LookUpProfile;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;

/**
 * @author kpshiva
 */
public class UserAccountServiceImpl implements UserAccountService {
    
    @Autowired(required = true)
    UserAccountDAO userAccountDAO;
    @Autowired(required = true)
    UserLoginServiceDAO userLoginServiceDAO;
    @Autowired
    CDMInterfaceService cdmservices;
    
    @Override
    public User getEmailDetails(String userId) {
        
        LookUpProfile lookupProfile = cdmservices.lookUpProfile(userId);
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
     */
    @Override
    public boolean updateSecurityDetails(String userId,
            List<SecurityDetails> securityDetails) {
        
        return userAccountDAO.updateSecurityDetails(Integer.parseInt(userId),
                securityDetails);
    }
    
    @Override
    public User getProfileInformation(String userId) {
        
        LookUpProfile lookupProfile = cdmservices.lookUpProfile(userId);
        return lookupProfile.getCustomerProfile().getCustomerDetails();
    }
    
    @Override
    public List<Address> getUserAddress(String userId) {
        
        LookUpProfile lookupProfile = cdmservices.lookUpProfile(userId);
        return lookupProfile.getCustomerProfile().getAddressDetails()
                .getAddress();
    }
    
}
