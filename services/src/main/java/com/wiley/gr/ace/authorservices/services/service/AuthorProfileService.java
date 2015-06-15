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

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Email;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.UserProfileAlerts;

public interface AuthorProfileService {

    /**
     * @param society
     * @return
     */
    boolean updateSocietyDetails(Society society);

    /**
     * @param affiliation
     * @return
     */
    boolean updateAffiliation(Affiliation affiliation);

    /**
     * @param userId
     * @param researchFunder
     * @return
     */
    boolean updateResearchFunder(String userId, ResearchFunder researchFunder);

    /**
     * @param userId
     * @param userProfileAlerts
     * @return
     */
    boolean updateAlerts(String userId, UserProfileAlerts userProfileAlerts);

    /**
     * @param coAuthor
     * @return
     */
    boolean updatecoAuthor(CoAuthor coAuthor);

    /**
     * @param emailDetails
     * @return
     */
    boolean updateEmailDetails(User emailDetails);

    /**
     * @param addresses
     * @return
     */
    boolean updateUserAddress(UserProfile addresses);

    /**
     * @param user
     * @return
     */
    boolean updateUserProfileInfo(User user);

    /**
     * @param email
     * @return
     */
    boolean updateUserId(Email email);

    /**
     * @param passwordDetails
     * @return
     */
    boolean updatePassword(PasswordDetails passwordDetails);

    /**
     * @param securityDetails
     * @return
     */
    boolean updateSecurityDetails(SecurityDetailsHolder securityDetails);

}
