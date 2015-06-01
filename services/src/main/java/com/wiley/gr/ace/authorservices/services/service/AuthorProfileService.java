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

package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.AddressDetails;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;

public interface AuthorProfileService {
    
    boolean updateSocietyDetails(Society society);
    
    boolean updateAffiliation(Affiliation affiliation);
    
    boolean updateResearchFunder(String userId, ResearchFunder researchFunder);
    
    boolean updateAlerts(String userId, List<Alert> alertsList);
    
    boolean UpdatecoAuthor(CoAuthor coAuthor);
    
    boolean updateEmailDetails(User emailDetails);
    
    boolean updateUserAddress(AddressDetails addresses);
    
    boolean updateUserProfileInfo(User user);
    
    boolean updateUserId(String oldEmailId, String newEmailId);
    
    boolean updatePassword(PasswordDetails passwordDetails);
    
    boolean updateSecurityDetails(SecurityDetailsHolder securityDetails);
    
}
