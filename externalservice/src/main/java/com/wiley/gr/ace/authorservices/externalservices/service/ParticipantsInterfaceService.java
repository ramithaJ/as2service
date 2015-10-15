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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import com.wiley.gr.ace.authorservices.model.external.AddressData;
import com.wiley.gr.ace.authorservices.model.external.AddressMapper;
import com.wiley.gr.ace.authorservices.model.external.AlertRequest;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.PreferenceValue;
import com.wiley.gr.ace.authorservices.model.external.Preferences;
import com.wiley.gr.ace.authorservices.model.external.ProfileEntity;

/**
 * The Interface ParticipantsInterfaceService.
 */
public interface ParticipantsInterfaceService {

    /**
     * Creates the participant.
     *
     * @param participant
     *            the participant
     * @return the string
     */
    String createParticipant(Participant participant);

    /**
     * Search participant by participant id.
     *
     * @param particpantId
     *            the particpant id
     * @return the participant
     */
    Participant searchParticipantByParticipantId(String particpantId);

    /**
     * Search participant by user id.
     *
     * @param userId
     *            the user id
     * @return the participant
     */
    Participant searchParticipantByUserId(String userId);

    /**
     * Search participant by name.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the list
     */
    ArrayList<Participant> searchParticipantByName(String firstName,
            String lastName);

    /**
     * Gets the address.
     *
     * @param participantId
     *            the participant id
     * @return the address
     * @throws Exception
     *             the exception
     */
    AddressMapper getAddress(String participantId) throws Exception;

    /**
     * Update address.
     *
     * @param participantId
     *            the participant id
     * @param participantAddress
     *            the participant address
     * @return the response entity
     * @throws Exception
     *             the exception
     */
    ResponseEntity<?> updateAddress(String participantId, AddressData address)
            throws Exception;

    /**
     * Upload profile image.
     *
     * @param participantId
     *            the participant id
     * @param imageFile
     *            the image file
     * @return the response entity
     * @throws Exception
     *             the exception
     */
    ResponseEntity<?> uploadProfileImage(String participantId, byte[] imageFile)
            throws Exception;

    /**
     * Gets the profile image.
     *
     * @param participantId
     *            the participant id
     * @return the profile image
     * @throws Exception
     *             the exception
     */
    byte[] getProfileImage(String participantId) throws Exception;

    /**
     * Update alerts.
     *
     * @param participantId
     *            the participant id
     * @param alert
     *            the alert
     * @return the response entity
     * @throws Exception
     *             the exception
     */
    ResponseEntity<?> updateAlerts(String participantId, AlertRequest alert)
            throws Exception;

    /**
     * Gets the alerts.
     *
     * @param participantId
     *            the participant id
     * @return the alerts
     * @throws Exception
     *             the exception
     */
    PreferenceValue getAlerts(String participantId) throws Exception;

    /**
     * Search participant by email.
     *
     * @param email
     *            the email
     * @return the participant
     */
    Participant searchParticipantByEmail(String email);

    /**
     * Update profile.
     *
     * @param profileEntity
     *            the profile entity
     * @return the response entity
     */
    ResponseEntity updateProfile(ProfileEntity profileEntity);

    /**
     * Gets the preferred journals.
     *
     * @param participantId
     *            the participant id
     * @return the preferred journals
     */
    Preferences getPreferredJournals(String participantId);

    /**
     * Delete preferred journal.
     *
     * @param profileEntity
     *            the profile entity
     * @return true, if successful
     */
    boolean deletePreferredJournal(ProfileEntity profileEntity);

    /**
     * Adds the preferred journals.
     *
     * @param profileEntity
     *            the profile entity
     */
    void addPreferredJournals(ProfileEntity profileEntity);

    /**
     * Update participant.
     *
     * @param participant
     *            the participant
     */
    void updateParticipant(Participant participant);

    /**
     * Search participant by orcid id.
     *
     * @param orcidId
     *            the orcid id
     * @return the participant
     */
    Participant searchParticipantByOrcidId(String orcidId);

}
