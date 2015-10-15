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

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.AlertsList;
import com.wiley.gr.ace.authorservices.model.AreaOfInterests;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
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
     * Update affiliation.
     *
     * @param userId
     *            the user id
     * @param affiliation
     *            the affiliation
     * @return true, if successful
     */
    boolean updateAffiliation(int userId, Affiliation affiliationsUpdate,
            String affiliationId);

    /**
     * Update research funder.
     *
     * @param userId
     *            the user id
     * @param researchFunder
     *            the research funder
     * @return true, if successful
     */
    /* boolean updateResearchFunder(int userId, ResearchFunder researchFunder); */

    /**
     * Update alerts.
     *
     * @param userId
     *            the user id
     * @param alert
     *            the alert
     * @return true, if successful
     */
    boolean updateAlerts(String participantId, AlertsList alertList)
            throws Exception;

    /**
     * @param userId
     * @param areaOfInterests
     * @return
     */
    boolean addInterests(String userId, AreaOfInterests areaOfInterests);

    /**
     * Update Coauthor.
     *
     * @param userId
     *            the user id
     * @param coAuthor
     *            the co author
     * @return true, if successful
     */
    /* boolean updatecoAuthor(int userId, CoAuthor coAuthor); */

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
     * Gets the user profile response.
     *
     * @param userId
     *            the user id
     * @return the user profile response
     */
    /* LookupCustomerProfile getuserProfileResponse(int userId); */

    boolean uploadProfileImage(String participantId, Byte[] imageFile)
            throws Exception;

    List<Affiliation> getAffiliationsList(String userId);

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
    List<String> getAreaOfInterests(String userId);

    PreferenceValue getAlerts(String participantId) throws Exception;

    /**
     * Gets the preffered journals.
     *
     * @param userId
     *            the user id
     * @return the preffered journals
     */
    String getPrefferedJournals(String participantId);

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
     * @param userId
     *            the user id
     * @return the profile picture
     */
    Byte[] getProfileImage(String participantId) throws Exception;

    /**
     * Delete society.
     *
     * @param userId
     *            the user id
     * @param societyId
     *            the society id
     * @return true, if successful
     */
    boolean deleteSociety(Long id);

    /**
     * Delete affiliations.
     *
     * @param userId
     *            the user id
     * @param affiliationId
     *            the affiliation id
     * @return true, if successful
     */
    boolean deleteAffiliations(String userId, String affiliationId);

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

    boolean addPreferredJournal(String userId, JournalDetails journalDetails);

    List<Preferences> getWOAaccounts(String participantId);

}
