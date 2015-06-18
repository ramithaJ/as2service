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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
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
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;

/**
 * The Class AuthorProfileServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class AuthorProfileServiceImpl implements AuthorProfileService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AuthorProfileServiceImpl.class);

    /** The user profiles. */
    @Autowired
    private UserProfiles userProfiles;

    /** The user management. */
    @Autowired
    private UserManagement userManagement;

    /** The user profile. */
    private UserProfile userProfile = new UserProfile();

    /** The look up profile. */
    private UserProfileResponse lookUpProfile = new UserProfileResponse();

    /**
     * Update society details.
     *
     * @param society
     *            the society
     * @return true, if successful
     */
    @Override
    public final boolean updateSocietyDetails(final Society society) {
        LOGGER.info("inside updateSocietyDetails Method ");

        List<Society> list = new ArrayList<Society>();
        list.add(society);
        userProfile.setSocieties(list);
        lookUpProfile.setCustomerProfile(userProfile);
        return userProfiles.updateProfile(lookUpProfile);
    }

    /**
     * Update affiliation.
     *
     * @param affiliation
     *            the affiliation
     * @return true, if successful
     */
    @Override
    public final boolean updateAffiliation(final Affiliation affiliation) {
        LOGGER.info("inside updateAffiliation Method ");

        List<Affiliation> list = new ArrayList<Affiliation>();
        list.add(affiliation);

        userProfile.setAffiliations(list);
        lookUpProfile.setCustomerProfile(userProfile);
        return userProfiles.updateProfile(lookUpProfile);
    }

    /**
     * Update research funder.
     *
     * @param userId
     *            the user id
     * @param researchFunder
     *            the research funder
     * @return true, if successful
     */
    @Override
    public final boolean updateResearchFunder(final String userId,
            final ResearchFunder researchFunder) {

        LOGGER.info("inside updateResearchFunder Method ");

        List<ResearchFunder> list = new ArrayList<ResearchFunder>();
        list.add(researchFunder);
        userProfile.setResearchFunders(list);
        lookUpProfile.setCustomerProfile(userProfile);
        return userProfiles.updateProfile(lookUpProfile);
    }

    /**
     * Update alerts.
     *
     * @param userId
     *            the user id
     * @param userProfileAlerts
     *            the user profile alerts
     * @return true, if successful
     */
    @Override
    public final boolean updateAlerts(final String userId,
            final UserProfileAlerts userProfileAlerts) {

        LOGGER.info("inside updateAlerts Method ");

        userProfile.setAlerts(userProfileAlerts.getAlerts());
        lookUpProfile.setCustomerProfile(userProfile);
        return userProfiles.updateProfile(lookUpProfile);
    }

    /**
     * Update Coauthor.
     *
     * @param coAuthor
     *            the co author
     * @return true, if successful
     */
    @Override
    public final boolean updatecoAuthor(final CoAuthor coAuthor) {

        LOGGER.info("inside updatecoAuthor Method ");

        List<CoAuthor> list = new ArrayList<CoAuthor>();
        list.add(coAuthor);
        userProfile.setCoAuthors(list);
        lookUpProfile.setCustomerProfile(userProfile);
        return userProfiles.updateProfile(lookUpProfile);

    }

    /**
     * Update email details.
     *
     * @param emailDetails
     *            the email details
     * @return true, if successful
     */
    @Override
    public final boolean updateEmailDetails(final User emailDetails) {

        LOGGER.info("inside updateEmailDetails Method ");
        userProfile.setCustomerDetails(emailDetails);
        lookUpProfile.setCustomerProfile(userProfile);
        return userProfiles.updateProfile(lookUpProfile);
    }

    /**
     * Update user address.
     *
     * @param addresses
     *            the addresses
     * @return true, if successful
     */
    @Override
    public final boolean updateUserAddress(final UserProfile addresses) {

        LOGGER.info("inside updateUserAddress Method ");
        userProfile.setAddressDetails(addresses.getAddressDetails());
        lookUpProfile.setCustomerProfile(userProfile);
        return userProfiles.updateProfile(lookUpProfile);
    }

    /**
     * Update user profile info.
     *
     * @param user
     *            the user
     * @return true, if successful
     */
    @Override
    public final boolean updateUserProfileInfo(final User user) {

        LOGGER.info("inside updateUserProfileInfo Method ");
        userProfile.setCustomerDetails(user);
        lookUpProfile.setCustomerProfile(userProfile);
        return userProfiles.updateProfile(lookUpProfile);
    }

    /**
     * Update user id.
     *
     * @param email
     *            the email
     * @return true, if successful
     */
    @Override
    public final boolean updateUserId(final Email email) {

        LOGGER.info("inside updateUserId Method ");
        return userManagement.updateUserId(email.getOldEmailId(),
                email.getNewEmailId());
    }

    /**
     * Update password.
     *
     * @param passwordDetails
     *            the password details
     * @return true, if successful
     */
    @Override
    public final boolean updatePassword(final PasswordDetails passwordDetails) {

        LOGGER.info("inside updatePassword Method ");
        return userManagement.updatePassword(passwordDetails);
    }

    /**
     * Update security details.
     *
     * @param securityDetails
     *            the security details
     * @return true, if successful
     */
    @Override
    public final boolean updateSecurityDetails(
            final SecurityDetailsHolder securityDetails) {

        LOGGER.info("inside updateSecurityDetails Method ");
        return userManagement.updateSecurityDetails(securityDetails);
    }

    /**
     * Gets the user profile response.
     *
     * @param userId
     *            the user id
     * @return the user profile response
     */
    @Override
    public final UserProfileResponse getuserProfileResponse(final String userId) {

        LOGGER.info("in UserProfileResponse Method");
        return userProfiles.getUserProfileResponse(userId);
    }

}
