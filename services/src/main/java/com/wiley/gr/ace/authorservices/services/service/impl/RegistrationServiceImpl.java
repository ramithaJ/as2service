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
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserReferenceData;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

/**
 * @author Virtusa
 */
public class RegistrationServiceImpl implements RegistrationService {
    
    @Autowired(required = true)
    ESBInterfaceService esbInterFaceService;
    
    @Autowired(required = true)
    RegistrationServiceDAO registrationServiceDAO;
    
    @Override
    public String createUser(User user) throws Exception {
        
        String status = null;
        if (null != user) {
            status = esbInterFaceService.creatUser(user);
        }
        return status;
    }
    
    @Override
    public List<User> getUserFromFirstNameLastName(String email,
            String firstName, String lastName) throws Exception {
        
        List<User> userList = null;
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            userList = esbInterFaceService.getUsersFromFirstNameLastName(email,
                    firstName, lastName);
        }
        
        return userList;
    }
    
    @Override
    public User checkEmailIdExists(String emailId) throws Exception {
        User user = new User();
        ESBUser esbUser = null;
        if (!StringUtils.isEmpty(emailId)) {
            esbUser = esbInterFaceService.checkEmailIdExists(emailId);
            if (null != esbUser) {
                UserReferenceData userRefData = new UserReferenceData();
                userRefData.setEcid(esbUser.getEcid());
                userRefData.setStatus(esbUser.getStatus());
                user.setUserId(esbUser.getUserId());
                user.setFirstName(esbUser.getFirstName());
                user.setLastName(esbUser.getLastName());
                user.setPrimaryEmailAddr(esbUser.getEmailId());
                user.setCountry(esbUser.getCountry());
                user.setUserReferenceData(userRefData);
            } else {
                user = null;
            }
        } else {
            user = null;
        }
        
        return user;
    }
    
    @Override
    public boolean searchUserByOrcidId(String orcidId) throws Exception {
        
        boolean isUserFound = false;
        if (!StringUtils.isEmpty(orcidId)
                && registrationServiceDAO.searchUserByOrcidId(orcidId)) {
            isUserFound = true;
        }
        
        return isUserFound;
    }
}
