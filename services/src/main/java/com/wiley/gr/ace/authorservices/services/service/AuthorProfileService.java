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
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;

/**
 * The Interface AuthorProfileService.
 */
public interface AuthorProfileService {

    /**
     * Update society details.
     *
     * @param society
     *            the society
     * @return true, if successful
     */
    boolean updateSocietyDetails(Society society);

    /**
     * Update affiliation.
     *
     * @param affiliation
     *            the affiliation
     * @return true, if successful
     */
    boolean updateAffiliation(Affiliation affiliation);

    /**
     * Update research funder.
     *
     * @param userId
     *            the user id
     * @param researchFunder
     *            the research funder
     * @return true, if successful
     */
    boolean updateResearchFunder(String userId, ResearchFunder researchFunder);

    /**
     * Update alerts.
     *
     * @param userId
     *            the user id
     * @param userProfileAlerts
     *            the user profile alerts
     * @return true, if successful
     */
    boolean updateAlerts(String userId, UserProfileAlerts userProfileAlerts);

    /**
     * Updateco author.
     *
     * @param coAuthor
     *            the co author
     * @return true, if successful
     */
    boolean updatecoAuthor(CoAuthor coAuthor);

    /**
     * Update email details.
     *
     * @param emailDetails
     *            the email details
     * @return true, if successful
     */
    boolean updateEmailDetails(User emailDetails);

    /**
     * Update user address.
     *
     * @param addresses
     *            the addresses
     * @return true, if successful
     */
    boolean updateUserAddress(UserProfile addresses);

    /**
     * Update user profile info.
     *
     * @param user
     *            the user
     * @return true, if successful
     */
    boolean updateUserProfileInfo(User user);

    /**
     * Update user id.
     *
     * @param email
     *            the email
     * @return true, if successful
     */
    boolean updateUserId(Email email);

    /**
     * Update password.
     *
     * @param passwordDetails
     *            the password details
     * @return true, if successful
     */
    boolean updatePassword(PasswordDetails passwordDetails);

    /**
     * Update security details.
     *
     * @param securityDetails
     *            the security details
     * @return true, if successful
     */
    boolean updateSecurityDetails(SecurityDetailsHolder securityDetails);

    /**
     * Gets the user profile response.
     *
     * @param userId
     *            the user id
     * @return the user profile response
     */
    UserProfileResponse getuserProfileResponse(String userId);
}
