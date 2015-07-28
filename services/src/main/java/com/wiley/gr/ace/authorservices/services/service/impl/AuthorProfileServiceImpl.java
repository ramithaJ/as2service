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

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Affiliations;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Email;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.ResearchFunders;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Societies;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.UserProfileAlerts;
import com.wiley.gr.ace.authorservices.model.external.AffiliationData;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.PasswordRequest;
import com.wiley.gr.ace.authorservices.model.external.PasswordUpdate;
import com.wiley.gr.ace.authorservices.model.external.ResearchFunderData;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestionsUpdateRequest;
import com.wiley.gr.ace.authorservices.model.external.SocietyData;
import com.wiley.gr.ace.authorservices.model.external.UserEmailDetails;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityAttributes;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsEntry;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsMap;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorProfileDao;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.SendNotification;

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

    /** The author profile dao. */
    @Autowired
    private AuthorProfileDao authorProfileDao;

    /**
     * Injecting SendNotification bean.
     */
    @Autowired(required = true)
    private SendNotification sendNotification;

    /** The user profile. */
    private final UserProfile userProfile = new UserProfile();

    /** The look up profile. */
    private final UserProfileResponse lookUpProfile = new UserProfileResponse();

    /**
     * Update society details.
     *
     * @param userId
     *            the user id
     * @param society
     *            the society
     * @return true, if successful
     */
    @Override
    public final boolean updateSocietyDetails(final int userId,
            final Society society) {
        AuthorProfileServiceImpl.LOGGER
                .info("inside updateSocietyDetails Method ");

        final List<Society> list = new ArrayList<Society>();
        list.add(society);
        userProfile.setSocieties(list);
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);
    }

    /**
     * Update affiliation.
     *
     * @param userId
     *            the user id
     * @param affiliation
     *            the affiliation
     * @return true, if successful
     */
    @Override
    public final boolean updateAffiliation(final int userId,
            final Affiliation affiliation) {
        AuthorProfileServiceImpl.LOGGER
                .info("inside updateAffiliation Method ");

        final List<Affiliation> list = new ArrayList<Affiliation>();
        list.add(affiliation);

        userProfile.setAffiliations(list);
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);
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
    public final boolean updateResearchFunder(final int userId,
            final ResearchFunder researchFunder) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateResearchFunder Method ");

        final List<ResearchFunder> list = new ArrayList<ResearchFunder>();
        list.add(researchFunder);
        userProfile.setResearchFunders(list);
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);
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
    public final boolean updateAlerts(final int userId,
            final UserProfileAlerts userProfileAlerts) {

        AuthorProfileServiceImpl.LOGGER.info("inside updateAlerts Method ");

        userProfile.setAlerts(userProfileAlerts.getAlerts());
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);
    }

    /**
     * Update Coauthor.
     *
     * @param userId
     *            the user id
     * @param coAuthor
     *            the co author
     * @return true, if successful
     */
    @Override
    public final boolean updatecoAuthor(final int userId,
            final CoAuthor coAuthor) {

        AuthorProfileServiceImpl.LOGGER.info("inside updatecoAuthor Method ");

        final List<CoAuthor> list = new ArrayList<CoAuthor>();
        list.add(coAuthor);
        userProfile.setCoAuthors(list);
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);

    }

    /**
     * Update email details.
     *
     * @param userId
     *            the user id
     * @param emailDetails
     *            the email details
     * @return true, if successful
     */
    @Override
    public final boolean updateEmailDetails(final int userId,
            final User emailDetails) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateEmailDetails Method ");
        userProfile.setCustomerDetails(emailDetails);
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);
    }

    /**
     * Update user address.
     *
     * @param userId
     *            the user id
     * @param addresses
     *            the addresses
     * @return true, if successful
     */
    @Override
    public final boolean updateUserAddress(final int userId,
            final UserProfile addresses) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateUserAddress Method ");
        userProfile.setAddressDetails(addresses.getAddressDetails());
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);
    }

    /**
     * Update user profile info.
     *
     * @param userId
     *            the user id
     * @param user
     *            the user
     * @return true, if successful
     */
    @Override
    public final boolean updateUserProfileInfo(final int userId, final User user) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateUserProfileInfo Method ");
        userProfile.setCustomerDetails(user);
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);
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

        AuthorProfileServiceImpl.LOGGER.info("inside updateUserId Method ");

        final UserEmailDetails userEmailDetails = new UserEmailDetails();
        final UserSecurityAttributes userSecurityAttributes = new UserSecurityAttributes();
        userSecurityAttributes.setExistingEmail(email.getExistingEmail());
        userSecurityAttributes.setNewEmail(email.getNewEmail());
        userSecurityAttributes
                .setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        userEmailDetails
                .setUpdateUserSecurityAttributes(userSecurityAttributes);

        return userManagement.updateUserId(userEmailDetails);
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

        AuthorProfileServiceImpl.LOGGER.info("inside updatePassword Method ");
        final PasswordUpdate passwordUpdate = new PasswordUpdate();
        final PasswordRequest passwordRequest = new PasswordRequest();
        passwordRequest.setExistingEmail(passwordDetails.getEmailId());
        passwordRequest.setExistingPassword(passwordDetails.getOldPassword());
        passwordRequest.setNewPassword(passwordDetails.getNewPassword());
        passwordRequest.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        passwordUpdate.setUpdateUserSecurityAttributes(passwordRequest);
        final boolean status = userManagement.updatePassword(passwordRequest);
        if (status) {

            sendNotification.notifyByEmail(passwordDetails.getEmailId());
        }

        return status;
    }

    /**
     * Update security details.
     *
     * @param securityDetailsHolder
     *            the security details holder
     * @return true, if successful
     */
    @Override
    public final boolean updateSecurityDetails(
            final SecurityDetailsHolder securityDetailsHolder) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateSecurityDetails Method ");
        final SecurityQuestionsUpdateRequest securityQuestionsUpdateRequest = new SecurityQuestionsUpdateRequest();
        final UserSecurityQuestions userSecurityQuestions = new UserSecurityQuestions();
        final UserSecurityQuestionsMap userSecurityQuestionsMap = new UserSecurityQuestionsMap();
        final List<UserSecurityQuestionsEntry> userSecurityQuestionsEntryList = new ArrayList<UserSecurityQuestionsEntry>();
        UserSecurityQuestionsEntry userSecurityQuestionsEntry = null;
        final List<SecurityDetails> securityDetailsList = securityDetailsHolder
                .getSecurityDetails();
        for (final SecurityDetails securityDetails : securityDetailsList) {

            userSecurityQuestionsEntry = new UserSecurityQuestionsEntry();
            userSecurityQuestionsEntry.setKey(securityDetails
                    .getSecurityQuestion());
            userSecurityQuestionsEntry.setText(securityDetails
                    .getSecurityAnswer());
            userSecurityQuestionsEntryList.add(userSecurityQuestionsEntry);
        }
        userSecurityQuestionsMap.setEntry(userSecurityQuestionsEntryList);
        userSecurityQuestions
                .setUserSecurityQuestionsMap(userSecurityQuestionsMap);
        securityQuestionsUpdateRequest.setEmail(securityDetailsHolder
                .getEmailId());
        securityQuestionsUpdateRequest.setPassword(securityDetailsHolder
                .getPassword());
        securityQuestionsUpdateRequest
                .setsSystem(AuthorServicesConstants.SOURCESYSTEM);
        securityQuestionsUpdateRequest
                .setUserSecurityQuestions(userSecurityQuestions);

        return userManagement
                .updateSecurityDetails(securityQuestionsUpdateRequest);
    }

    /**
     * Gets the user profile response.
     *
     * @param userId
     *            the user id
     * @return the user profile response
     */
    @Override
    public final UserProfileResponse getuserProfileResponse(final int userId) {
        AuthorProfileServiceImpl.LOGGER.info("in UserProfileResponse Method");
        return userProfiles.getUserProfileResponse(userId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.services.service.AuthorProfileService
     * #uploadImage(java.io.File, java.lang.String)
     */
    @Override
    public void uploadImage(final File image, final String userId) {

        final byte[] imageData = new byte[(int) image.length()];
        try {
            final FileInputStream fileInputStream = new FileInputStream(image);
            fileInputStream.read(imageData);
            fileInputStream.close();
            authorProfileDao.saveProfilePicture(imageData, userId);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting LookUp Profile by calling external service.
     *
     * @param userId
     *            the user id
     * @return the lookup customer profile
     */
    @Override
    public LookupCustomerProfile getLookupCustomerProfile(final String userId) {

        return userProfiles.getLookupCustomerProfile(userId);
    }

    /**
     * This method will call externnal service look up profile to get
     * affiliation
     * 
     * @param userId
     */
    @Override
    public Affiliations getAffiliationsList(final String userId) {

        List<AffiliationData> listofAffiliations = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAffiliations().getAffiliation();

        Affiliations affiliations = new Affiliations();
        Affiliation affiliation = new Affiliation();
        List<Affiliation> listAffiliations = new ArrayList<Affiliation>();
        for (AffiliationData affiliationData : listofAffiliations) {
            affiliation.setAffiliationId(affiliationData.getId());
            affiliation.setCity(affiliationData.getCity());
            affiliation.setCountryCode(affiliationData.getCountryCd());
            affiliation.setInstitutionId(affiliationData.getInstitutionCd());
            affiliation.setDepartmentId(affiliationData.getDepartmentCd());
            affiliation.setDepartmentName(affiliationData.getDepartmentName());
            affiliation
                    .setInstitutionName(affiliationData.getInstitutionName());
            listAffiliations.add(affiliation);
            affiliations.setAffiliations(listAffiliations);
        }
        return affiliations;
    }

    /**
     * This method will call externnal service look up profile to get research
     * funder
     * 
     * @param userId
     */
    @Override
    public ResearchFunders getResearchFundersList(final String userId) {
        List<ResearchFunderData> listOfResearchFunder = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getResearchFunders().getResearchFunder();
        ResearchFunders researchFunders = new ResearchFunders();
        List<ResearchFunder> list = new ArrayList<ResearchFunder>();
        for (ResearchFunderData researchFunderData1 : listOfResearchFunder) {
            ResearchFunder researchFunder = new ResearchFunder();
            researchFunder.setResearchFunderId(researchFunderData1
                    .getFunderID());
            researchFunder.setResearchFunderName(researchFunderData1
                    .getFunderName());
            list.add(researchFunder);
            researchFunders.setResearchFunders(list);
        }
        return researchFunders;
    }

    /**
     * This method will call externnal service look up profile to get Societies
     * 
     * 
     * @param userId
     */

    @Override
    public Societies getSocietylist(final String userId) {
        List<SocietyData> listSocietyData = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getSocietyList().getSociety();
        Societies societies = new Societies();
        List<Society> listOfSocietie = new ArrayList<Society>();
        for (SocietyData societyData : listSocietyData) {
            Society society = new Society();
            society.setSocietyId(societyData.getSocietyId());
            society.setPromoCode(societyData.getPromoCode());
            society.setSocietyName(societyData.getSocietyName());
            listOfSocietie.add(society);
            societies.setSocieties(listOfSocietie);
        }
        return societies;
    }
}
