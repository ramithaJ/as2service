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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.external.LookUpProfile;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;

public class AuthorProfileServiceImpl implements AuthorProfileService {
    
    @Autowired
    CDMInterfaceService cdmservices;
    
    @Autowired
    ALMInterfaceService almService;
    
    @Override
    public boolean updateSocietyDetails(Society society) {
        UserProfile userProfile = new UserProfile();
        LookUpProfile lookUpProfile = new LookUpProfile();
        List<Society> list = new ArrayList<Society>();
        list.add(society);
        userProfile.setSocieties(list);
        lookUpProfile.setUserProfile(userProfile);
        cdmservices.updateProfile(lookUpProfile);
        
        return true;
    }
    
    @Override
    public boolean updateAffiliation(Affiliation affiliation) {
        UserProfile userProfile = new UserProfile();
        LookUpProfile lookUpProfile = new LookUpProfile();
        List<Affiliation> list = new ArrayList<Affiliation>();
        list.add(affiliation);
        
        userProfile.setAffiliations(list);
        lookUpProfile.setUserProfile(userProfile);
        cdmservices.updateProfile(lookUpProfile);
        
        return true;
    }
    
    @Override
    public boolean updateResearchFunder(String userId,
            ResearchFunder researchFunder) {
        UserProfile userProfile = new UserProfile();
        LookUpProfile lookUpProfile = new LookUpProfile();
        List<ResearchFunder> list = new ArrayList<ResearchFunder>();
        list.add(researchFunder);
        userProfile.setResearchFunders(list);
        lookUpProfile.setUserProfile(userProfile);
        cdmservices.updateProfile(lookUpProfile);
        
        return true;
    }
    
    @Override
    public boolean updateAlerts(String userId, List<Alert> alertsList) {
        UserProfile userProfile = new UserProfile();
        LookUpProfile lookUpProfile = new LookUpProfile();
        userProfile.setAlerts(alertsList);
        lookUpProfile.setUserProfile(userProfile);
        cdmservices.updateProfile(lookUpProfile);
        return true;
    }
    
    @Override
    public boolean UpdatecoAuthor(CoAuthor coAuthor) {
        UserProfile userProfile = new UserProfile();
        LookUpProfile lookUpProfile = new LookUpProfile();
        List<CoAuthor> list = new ArrayList<CoAuthor>();
        list.add(coAuthor);
        userProfile.setCoAuthors(list);
        lookUpProfile.setUserProfile(userProfile);
        cdmservices.updateProfile(lookUpProfile);
        return true;
    }
    
    @Override
    public boolean updateEmailDetails(User emailDetails) {
        
        UserProfile userProfile = new UserProfile();
        LookUpProfile lookUpProfile = new LookUpProfile();
        userProfile.setProfileInformation(emailDetails);
        lookUpProfile.setUserProfile(userProfile);
        return cdmservices.updateProfile(lookUpProfile);
    }
    
    @Override
    public boolean updateUserAddress(Addresses addresses) {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean updateUserProfileInfo(User user) {
        
        UserProfile userProfile = new UserProfile();
        LookUpProfile lookUpProfile = new LookUpProfile();
        userProfile.setProfileInformation(user);
        lookUpProfile.setUserProfile(userProfile);
        return cdmservices.updateProfile(lookUpProfile);
    }

    @Override
    public boolean updateUserId(String oldEmailId, String newEmailId) {

        return almService.updateUserId(oldEmailId, newEmailId);
    }
    
}
