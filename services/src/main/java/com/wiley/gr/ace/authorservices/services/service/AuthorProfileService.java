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

import java.io.File;
import java.util.List;

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Email;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.PreferredJournals;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.UserProfileAlerts;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;

/**
 * The Interface AuthorProfileService.
 */
public interface AuthorProfileService {

    /**
     * Update society details.
     *
     * @param userId
     *            the user id
     * @param society
     *            the society
     * @return true, if successful
     */
    boolean updateSocietyDetails(int userId, Society society);

    /**
     * Update affiliation.
     *
     * @param userId
     *            the user id
     * @param affiliation
     *            the affiliation
     * @return true, if successful
     */
    boolean updateAffiliation(int userId, Affiliation affiliation);

    /**
     * Update research funder.
     *
     * @param userId
     *            the user id
     * @param researchFunder
     *            the research funder
     * @return true, if successful
     */
    boolean updateResearchFunder(int userId, ResearchFunder researchFunder);

    /**
     * Update alerts.
     *
     * @param userId
     *            the user id
     * @param userProfileAlerts
     *            the user profile alerts
     * @return true, if successful
     */
    boolean updateAlerts(int userId, UserProfileAlerts userProfileAlerts);

    /**
     * Update Coauthor.
     *
     * @param userId
     *            the user id
     * @param coAuthor
     *            the co author
     * @return true, if successful
     */
    boolean updatecoAuthor(int userId, CoAuthor coAuthor);

    /**
     * Update email details.
     *
     * @param userId
     *            the user id
     * @param emailDetails
     *            the email details
     * @return true, if successful
     */
    boolean updateEmailDetails(int userId, User emailDetails);

    /**
     * Update user address.
     *
     * @param userId
     *            the user id
     * @param addresses
     *            the addresses
     * @return true, if successful
     */
    boolean updateUserAddress(int userId, UserProfile addresses);

    /**
     * Update user profile info.
     *
     * @param userId
     *            the user id
     * @param user
     *            the user
     * @return true, if successful
     */
    boolean updateUserProfileInfo(int userId, User user);

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
     * @param securityDetailsHolder
     *            the security details holder
     * @return true, if successful
     */
    boolean updateSecurityDetails(SecurityDetailsHolder securityDetailsHolder);

    /**
     * Gets the user profile response.
     *
     * @param userId
     *            the user id
     * @return the user profile response
     */
    UserProfileResponse getuserProfileResponse(int userId);

    /**
     * Upload image.
     *
     * @param image
     *            the image
     * @param userId
     *            the user id
     */
    void uploadImage(File image, String userId);

    /**
     * Gets the lookup customer profile.
     *
     * @param userId
     *            the user id
     * @return the lookup customer profile
     */
    LookupCustomerProfile getLookupCustomerProfile(String userId);

    /**
     * Gets the affiliations list.
     *
     * @param userId
     *            the user id
     * @return the affiliations list
     */
    List<Affiliation> getAffiliationsList(String userId);

    /**
     * Gets the research funders list.
     *
     * @param userId
     *            the user id
     * @return the research funders list
     */
    List<ResearchFunder> getResearchFundersList(String userId);

   /** Gets the societylist.
     *
     * @param userId
     *            the user id
     * @return the societylist
     */
    List<Society> getSocietylist(String userId);

     /** Gets the s co authors list.
     *
     * @param userId
     *            the user id
     * @return the s co authors list
     */
    List<CoAuthor> getsCoAuthorsList(String userId);

     /** Gets the area of interests.
     *
     * @param userId
     *            the user id
     * @return the area of interests
     */
    List<Interests> getAreaOfInterests(String userId);

     /** Gets the list of alerts.
     *
     * @param userId
     *            the user id
     * @return the list of alerts
     */
    List<Alert> getListOfAlerts(String userId);

     /** Gets the preffered journals.
     *
     * @param userId
     *            the user id
     * @return the preffered journals
     */
    List<PreferredJournals> getPrefferedJournals(String userId);
    
    CustomerDetails getCustomeProfile(String userId);
}