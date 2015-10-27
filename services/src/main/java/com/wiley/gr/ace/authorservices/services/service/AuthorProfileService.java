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

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.AlertsList;
import com.wiley.gr.ace.authorservices.model.AreaOfInterests;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.PreferredJournals;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.PreferenceValue;
import com.wiley.gr.ace.authorservices.model.external.Preferences;

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
    boolean updateSocietyDetails(String userId, Society society);

    /**
     * Update alerts.
     *
     * @param participantId
     *            the participant id
     * @param alertList
     *            the alert list
     * @return true, if successful
     */
    boolean updateAlerts(String participantId, AlertsList alertList);

    /**
     * Adds the interests.
     *
     * @param userId
     *            the user id
     * @param areaOfInterests
     *            the area of interests
     * @return true, if successful
     */
    boolean addInterests(String userId, AreaOfInterests areaOfInterests);

    /**
     * Update email details.
     *
     * @param userId
     *            the user id
     * @param emailDetails
     *            the email details
     * @return true, if successful
     */
    boolean updateEmailDetails(String userId, User emailDetails);

    /**
     * Update user profile info.
     *
     * @param userId
     *            the user id
     * @param user
     *            the user
     * @return true, if successful
     */
    boolean updateUserProfileInfo(String userId, User user);

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
     * Upload profile image.
     *
     * @param participantId
     *            the participant id
     * @param imageFile
     *            the image file
     * @return true, if successful
     * @throws ASException
     *             the AS exception
     */
    boolean uploadProfileImage(String participantId, byte[] imageFile)
            throws ASException;

    /**
     * Gets the research funders list.
     *
     * @param userId
     *            the user id
     * @return the research funders list
     */
    List<ResearchFunder> getResearchFundersList(String userId);

    /**
     * Gets the societylist.
     *
     * @param userId
     *            the user id
     * @return the societylist
     */
    List<Society> getSocietylist(String userId);

    /**
     * Gets the s co authors list.
     *
     * @param userId
     *            the user id
     * @return the s co authors list
     */
    List<CoAuthor> getsCoAuthorsList(String userId);

    /**
     * Gets the area of interests.
     *
     * @param userId
     *            the user id
     * @return the area of interests
     */
    List<Interests> getAreaOfInterests(String userId);

    /**
     * Gets the alerts.
     *
     * @param participantId
     *            the participant id
     * @return the alerts
     * @throws ASException
     *             the exception
     */
    PreferenceValue getAlerts(String participantId) throws ASException;

    /**
     * Gets the preffered journals.
     *
     * @param participantId
     *            the participant id
     * @return the preffered journals
     */
    List<PreferredJournals> getPrefferedJournals(String participantId);

    /**
     * Removes the orcid id.
     *
     * @param userId
     *            the user id
     * @return true, if successful
     */
    boolean removeOrcidId(String userId);

    /**
     * Update orcid id.
     *
     * @param userId
     *            the user id
     * @param orcidId
     *            the orcid id
     * @return true, if successful
     */
    boolean updateOrcidId(String userId, String orcidId);

    /**
     * Gets the profile picture.
     *
     * @param participantId
     *            the participant id
     * @return the profile picture
     * @throws Exception
     */
    File getProfileImage(String participantId) throws Exception;

    /**
     * Delete society.
     *
     * @param id
     *            the id
     * @return true, if successful
     */
    boolean deleteSociety(Long id);

    /**
     * Delete interests.
     *
     * @param userId
     *            the user id
     * @param interestId
     *            the interest id
     * @return true, if successful
     */
    boolean deleteInterests(String userId, String interestId);

    /**
     * Delete preferred journals.
     *
     * @param userId
     *            the user id
     * @param journalId
     *            the journal id
     * @return true, if successful
     */
    boolean deletePreferredJournals(String userId, String journalId);

    /**
     * Gets the affiliation list.
     *
     * @param userId
     *            the user id
     * @return the affiliation list
     */
    List<Affiliation> getAffiliationList(String userId);

    /**
     * Delete affiliations.
     *
     * @param userId
     *            the user id
     * @return true, if successful
     */
    boolean deleteAffiliations(String userId, String affiliationId);

    /**
     * Update affiliation.
     *
     * @param userId
     *            the user id
     * @param affiliation
     *            the affiliation
     * @return true, if successful
     * @throws Exception 
     */
    boolean updateAffiliation(String userId, Affiliation affiliation, String affiliationId) throws Exception;

    /**
     * Adds the preferred journal.
     *
     * @param userId
     *            the user id
     * @param journalDetails
     *            the journal details
     * @return true, if successful
     */
    boolean addPreferredJournal(String userId, JournalDetails journalDetails);

    /**
     * Gets the WO aaccounts.
     *
     * @param participantId
     *            the participant id
     * @return the WO aaccounts
     */
    List<Preferences> getWOAaccounts(String participantId);

    /**
     * Update research funders.
     *
     * @param participantId
     *            the participant id
     * @param researchFunder
     *            the research funder
     * @return true, if successful
     */
    boolean updateResearchFunders(String participantId,
            ResearchFunder researchFunder);

    /**
     * Delete research funder.
     *
     * @param participantSeqId
     *            the participant seq id
     * @return true, if successful
     */
    boolean deleteResearchFunder(Long participantSeqId);

}
