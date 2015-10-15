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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.AddressData;
import com.wiley.gr.ace.authorservices.model.external.AddressMapper;
import com.wiley.gr.ace.authorservices.model.external.AlertRequest;
import com.wiley.gr.ace.authorservices.model.external.EntityValue;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.ParticipantGetResponse;
import com.wiley.gr.ace.authorservices.model.external.PreferenceMapper;
import com.wiley.gr.ace.authorservices.model.external.PreferenceValue;
import com.wiley.gr.ace.authorservices.model.external.Preferences;
import com.wiley.gr.ace.authorservices.model.external.ProfileEntity;
import com.wiley.gr.ace.authorservices.model.external.ProfileResponse;

/**
 * The Class ParticipantsInterfaceServiceImpl.
 */
public class ParticipantsInterfaceServiceImpl implements
        ParticipantsInterfaceService {

    /** The searchparticipantbyidurl. */
    @Value("${searchparticipantbyid.url}")
    private String searchparticipantbyidurl;

    @Value("${participant-crud.url}")
    private String participantCrudUrl;

    @Value("${searchParticipantbyOrcidId.url}")
    private String searchParticipantbyOrcidId;

    /**
     * Creates the participant.
     *
     * @param participant
     *            the participant
     * @return the string
     */
    @Override
    public final String createParticipant(final Participant participant) {
        final Participant createdParticipant = (Participant) RestServiceInvokerUtil
                .restServiceInvoker(participantCrudUrl, participant,
                        Participant.class);
        return createdParticipant.getParticipantId();
    }

    /**
     * Search participant by participant id.
     *
     * @param particpantId
     *            the particpant id
     * @return the participant
     */
    @Override
    public final Participant searchParticipantByParticipantId(
            final String participantId) {
        final Participant participant = (Participant) RestServiceInvokerUtil
                .getServiceData(searchparticipantbyidurl + participantId,
                        Participant.class);
        return participant;
    }

    /**
     * Search participant by user id.
     *
     * @param userId
     *            the user id
     * @return the participant
     */
    @Override
    public final Participant searchParticipantByUserId(final String userId) {

        final String participantSearchUrl = participantCrudUrl.concat(
                "?userId=").concat(userId);
        ParticipantGetResponse participantGetResponse = (ParticipantGetResponse) RestServiceInvokerUtil
                .getServiceData(participantSearchUrl,
                        ParticipantGetResponse.class);
        return participantGetResponse.getParticipantList().get(0);
    }

    /**
     * Search participant by name.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the list
     */
    @Override
    public final ArrayList<Participant> searchParticipantByName(
            final String firstName, final String lastName) {
        final String participantSearchUrl = participantCrudUrl
                .concat("?firstName=").concat(firstName).concat("?familyName=")
                .concat(lastName);
        ParticipantGetResponse participantGetResponse = (ParticipantGetResponse) RestServiceInvokerUtil
                .getServiceData(participantSearchUrl,
                        ParticipantGetResponse.class);
        return participantGetResponse.getParticipantList();
    }

    /**
     * Gets the address.
     *
     * @param participantId
     *            the participant id
     * @return the address
     * @throws Exception
     *             the exception
     */

    @Override
    public final AddressMapper getAddress(final String participantId)
            throws Exception {
        final String url = "http://assearchdev.wiley.com:8080/v1/participants/"
                + participantId + "/addresses";
        return (AddressMapper) StubInvokerUtil.restGetServiceInvoker(url,
                AddressMapper.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService#updateAddress(java.lang.String,
     * com.wiley.gr.ace.authorservices.model.external.ParticipantAddress)
     */
    @Override
    public ResponseEntity updateAddress(final String participantId,
            final AddressData address) throws Exception {
        final String url = "http://demo7580012.mockable.io/address";
        EntityValue entityValue = new EntityValue();
        entityValue.setAddressData(address);
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityValue(entityValue);
        final ResponseEntity resposeEntity = (ResponseEntity) StubInvokerUtil
                .restServiceResponseInvoker(url, HttpMethod.POST,
                        profileEntity, ParticipantError.class, null);
        return resposeEntity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService#uploadProfileImage(java.lang.String,
     * java.lang.Byte[])
     */
    @Override
    public ResponseEntity uploadProfileImage(final String participantId,
            final Byte[] imageFile) throws Exception {
        final String url = "http://assearchdev.wiley.com:8080/v1/participants/"
                + participantId + "/profileImage";
        final ResponseEntity resposeEntity = (ResponseEntity) StubInvokerUtil
                .restServiceResponseInvoker(url, HttpMethod.PUT, imageFile,
                        ParticipantError.class, null);
        return resposeEntity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService#getProfileImage(java.lang.String)
     */
    @Override
    public Byte[] getProfileImage(final String participantId) throws Exception {
        final String url = "http://assearchdev.wiley.com:8080/v1/participants/"
                + participantId + "/profileImage";
        final Byte[] profileImage = (Byte[]) StubInvokerUtil
                .restGetServiceInvoker(url, Byte[].class);
        return profileImage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService#updateAlerts(java.lang.String,
     * com.wiley.gr.ace.authorservices.model.external.AlertElement)
     */
    @Override
    public ResponseEntity updateAlerts(final String participantId,
            final AlertRequest alert) throws Exception {
        final String url = "http://demo7580012.mockable.io/alert";
        EntityValue entityValue = new EntityValue();
        entityValue.setAlertRequest(alert);
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityValue(entityValue);
        final ResponseEntity resposeEntity = (ResponseEntity) StubInvokerUtil
                .restServiceResponseInvoker(url, HttpMethod.POST,
                        profileEntity, ParticipantError.class, null);
        return resposeEntity;
    }

    @Override
    public PreferenceValue getAlerts(final String participantId)
            throws Exception {
        final String url = "http://assearchdev.wiley.com:8080/v1/participants/"
                + participantId + "/preferences/" + "ALERT";
        final PreferenceMapper preferenceMapper = (PreferenceMapper) StubInvokerUtil
                .restGetServiceInvoker(url, PreferenceMapper.class);
        return preferenceMapper.getPreferenceValue();
    }

    /**
     * Search participant by email.
     *
     * @param email
     *            the email
     * @return the participant
     */
    @Override
    public final Participant searchParticipantByEmail(final String email) {

        final String participantSearchUrl = participantCrudUrl
                .concat("?email=").concat(email);
        ParticipantGetResponse participantGetResponse = (ParticipantGetResponse) RestServiceInvokerUtil
                .getServiceData(participantSearchUrl,
                        ParticipantGetResponse.class);
        return participantGetResponse.getParticipantList().get(0);
    }

    @Override
    public final ResponseEntity updateProfile(final ProfileEntity profileEntity) {

        final String url = "http://assearchdev.wiley.com:8080/v1/profile/";
        final ResponseEntity resposeEntity = (ResponseEntity) StubInvokerUtil
                .restServiceResponseInvoker(url, HttpMethod.PUT, profileEntity,
                        ProfileResponse.class, null);
        return resposeEntity;
    }

    @Override
    public final Preferences getPreferredJournals(final String participantId) {
        final String url = "http://assearchdev.wiley.com:8080/v1/participants/1478cd2b-1671-443c-a0ea-09cbdc4169e9/preferences/FAVJOURNAL";
        final Preferences preferred = (Preferences) RestServiceInvokerUtil
                .getServiceData(url, Preferences.class);

        return preferred;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService
     * #deletePreferredJournal(com.wiley.gr.ace.authorservices
     * .model.external.ProfileEntity)
     */
    @Override
    public final boolean deletePreferredJournal(
            final ProfileEntity profileEntity) {
        final String url = "/v1/profile/";

        RestServiceInvokerUtil.deleteparticipantServiceData(url, profileEntity);
        return false;
    }

    @Override
    public final void addPreferredJournals(final ProfileEntity profileEntity) {

        final String url = "/v1/profile/";
        RestServiceInvokerUtil.restServiceInvoker(url, profileEntity,
                String.class);
    }

    /**
     * Update participant.
     *
     * @param participant
     *            the participant
     */
    @Override
    public final void updateParticipant(final Participant participant) {
        String participantUpdateUrl = participantCrudUrl.concat("/").concat(
                participant.getParticipantId());

        RestServiceInvokerUtil
                .putServiceData(participantUpdateUrl, participant);

    }

    /**
     * Search participant by orcid id.
     *
     * @param orcidId
     *            the orcid id
     * @return the participant
     */
    @Override
    public Participant searchParticipantByOrcidId(String orcidId) {
        ParticipantGetResponse participantGetResponse = (ParticipantGetResponse) RestServiceInvokerUtil
                .getServiceData(searchParticipantbyOrcidId.concat(orcidId),
                        ParticipantGetResponse.class);
        return participantGetResponse.getParticipantList().get(0);
    }
}
