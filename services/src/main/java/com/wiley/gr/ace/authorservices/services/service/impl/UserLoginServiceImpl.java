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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * @author kpshiva
 */
public class UserLoginServiceImpl implements UserLoginService {
    
    @Autowired(required = true)
    UserLoginServiceDAO userLoginServiceDAO;
    @Autowired(required = true)
    ALMInterfaceService almService;
    
    /**
     * @param emailId
     * @param password
     * @return
     */
    @Override
    public UserMgmt doLogin(String emailId, String password) {
        
        UserMgmt userMgmt = null;
        if (userLoginServiceDAO.validateEmailAddress(emailId)) {
            
            int userId = userLoginServiceDAO.getUserId(emailId);
            
            if (userLoginServiceDAO.isUserLocked(userId)) {
                
                Date currentDate = new Date();
                Date date = userLoginServiceDAO.getLockedTime(userId);
                Date lockedDate = new Date(date.getTime());
                if ((currentDate.getTime() - lockedDate.getTime()) > 1800000) {
                    
                    if (authenticateUser(userId, emailId, password)) {
                        
                        userMgmt = new UserMgmt();
                        userMgmt.setUserId(userLoginServiceDAO
                                .getUserId(emailId) + "");
                    } else {
                        throw new ASException("1005",
                                "Your account is locked. Please try after sometime .");
                    }
                } else {
                    
                    throw new ASException("1007",
                            "Your account is locked. Please try after sometime.");
                }
            } else {
                if (authenticateUser(userId, emailId, password)) {
                    userMgmt = new UserMgmt();
                    userMgmt.setUserId(userId + "");
                }
            }
        } else {
            
            throw new ASException("1001",
                    "Invalid email address. Please Re-Enter");
        }
        return userMgmt;
    }
    
    /**
     * this method will check whether user has security setup or not.
     * 
     * @param userId
     * @return
     */
    @Override
    public boolean checkSecuritySetUp(int userId) {
        
        return userLoginServiceDAO.checkSecuritySetup(userId);
    }
    
    /**
     * this method will give list of security questions and answers based on
     * email id.
     * 
     * @param emailId
     * @return
     */
    @Override
    public SecurityDetailsHolder getSecurityQuestions(String emailId) {
        
        // it checks whether user is exit or not in the user table
        // if exist it will return userId
        int userId = userLoginServiceDAO.getUserId(emailId);
        if (userId != 0) {
            
            AuthorProfile authorProfile = userLoginServiceDAO
                    .authorProfile(userId);
            // it will check whether the user is exist in author profile table
            // or not
            // it means whether user is normal user or Admin user.
            if (null != authorProfile) {
                
                SecurityDetailsHolder securityDetailsHolder = new SecurityDetailsHolder();
                // check whether user has security set up or not.
                if (authorProfile.getSecurityQuestFlg().equals('Y')) {
                    
                    List<UserSecurityDetails> securityQuestions = userLoginServiceDAO
                            .getSecurityQuestions(userId);
                    List<SecurityDetails> securityQuestionsList = new ArrayList<SecurityDetails>();
                    for (int i = 0; i < securityQuestions.size(); i++) {
                        
                        SecurityDetails security = new SecurityDetails();
                        security.setSecurityQuestionId("SecurityQuestion"
                                + (i + 1));
                        security.setSecurityQuestion(securityQuestions.get(i)
                                .getSecurityQuestion());
                        securityQuestionsList.add(security);
                    }
                    securityDetailsHolder
                            .setSecurityDetails(securityQuestionsList);
                    return securityDetailsHolder;
                } else {
                    
                    throw new ASException("1015",
                            "User doen't have security setup");
                }
            } else {
                
                throw new ASException("1017", "Invalid user, please try again");
            }
        } else {
            
            throw new ASException("1016",
                    "Invalid email Details, please try again");
        }
        
    }
    
    /**
     * this method will update the password at user profile level.
     * 
     * @param emailId
     * @param passwordDetails
     * @return
     */
    @Override
    public boolean updatePassword(PasswordDetails passwordDetails) {
        
        return almService.updatePassword(passwordDetails.getUserId(),
                passwordDetails.getOldPassword(),
                passwordDetails.getNewPassword());
    }
    
    /**
     * @param emailId
     * @param securityDetails
     * @return
     */
    @Override
    public boolean validateSecurityQuestions(String emailId,
            List<SecurityDetails> securityDetails) {
        
        boolean status = false;
        Integer userId = userLoginServiceDAO.getUserId(emailId);
        List<UserSecurityDetails> securityQuestionslist = userLoginServiceDAO
                .getSecurityQuestions(userId);
        
        for (int i = 0; i < securityDetails.size(); i++) {
            
            if (securityDetails
                    .get(i)
                    .getSecurityQuestion()
                    .equalsIgnoreCase(
                            securityQuestionslist.get(i).getSecurityQuestion())
                    && securityDetails
                            .get(i)
                            .getSecurityAnswer()
                            .equalsIgnoreCase(
                                    securityQuestionslist.get(i)
                                            .getSecurityAnswer())) {
                status = true;
            } else {
                throw new ASException("1011",
                        "Please enter valid security details.");
            }
        }
        return status;
    }
    
    /**
     * @param userId
     * @return
     */
    @Override
    public boolean lockUser(int userId) {
        
        return userLoginServiceDAO.lockUser(userId);
        
    }
    
    /**
     * @param emailId
     * @return
     */
    @Override
    public boolean validateEmailAddress(String emailId) {
        
        return userLoginServiceDAO.validateEmailAddress(emailId);
    }
    
    /**
     * @param userId
     * @return
     */
    @Override
    public boolean isUserLocked(int userId) {
        
        return userLoginServiceDAO.isUserLocked(userId);
    }
    
    /**
     * @param userId
     * @param template_id
     */
    @Override
    public void sendEmail(String userId, String templateId) {
    }
    
    /**
     * @param userId
     * @param emailId
     * @param password
     * @return
     */
    private boolean authenticateUser(int userId, String emailId, String password) {
        
        boolean loginStatus = false;
        
        if (almService.authenticateUserALM(emailId, password)) {
            
            userLoginServiceDAO.doLogin(userId, password);
            userLoginServiceDAO.unLockUser(userId);
            userLoginServiceDAO.updateCount(0, userId);
            loginStatus = true;
            
        } else {
            
            int count = userLoginServiceDAO.getCount(userId);
            if (count >= 2) {
                
                if (userLoginServiceDAO.lockUser(userId)) {
                    throw new ASException("1002",
                            "Your account is locked. Please try after sometime   .");
                    
                }
            } else {
                
                count++;
                userLoginServiceDAO.updateCount(count, userId);
                throw new ASException("1003",
                        "Please enter valid EmailId and Password.");
            }
        }
        
        return loginStatus;
    }
    
    /**
     * this method will reset the password at the time of login.
     * 
     * @param emailId
     * @param newPassword
     * @return
     */
    @Override
    public boolean resetPassword(String emailId, String newPassword) {
        
        return true;
    }
    
    @Override
    public SecurityDetailsHolder securityDetails(String userId) {
        
        return almService.getSecurityDetails(userId);
    }
}
