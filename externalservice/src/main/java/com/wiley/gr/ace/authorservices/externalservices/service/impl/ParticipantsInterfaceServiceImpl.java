/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
/**
 *
 */
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.AddressData;
import com.wiley.gr.ace.authorservices.model.external.AddressMapper;
import com.wiley.gr.ace.authorservices.model.external.AlertRequest;
import com.wiley.gr.ace.authorservices.model.external.EntityValue;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.ParticipantErrorResponse;
import com.wiley.gr.ace.authorservices.model.external.ParticipantGetResponse;
import com.wiley.gr.ace.authorservices.model.external.ParticipantUpdateSuccessResponse;
import com.wiley.gr.ace.authorservices.model.external.PreferenceMapper;
import com.wiley.gr.ace.authorservices.model.external.PreferenceValue;
import com.wiley.gr.ace.authorservices.model.external.Preferences;
import com.wiley.gr.ace.authorservices.model.external.ProfileEntity;

/**
 * The Class ParticipantsInterfaceServiceImpl.
 */
public class ParticipantsInterfaceServiceImpl implements
        ParticipantsInterfaceService {
    /**
     * The searchparticipantbyidurl.
     */
    @Value("${searchparticipantbyid.url}")
    private String searchparticipantbyidurl;

    /**
     * The participant crud url.
     */
    @Value("${participant-crud.url}")
    private String participantCrudUrl;

    /**
     * The search participantby orcid id.
     */
    @Value("${searchParticipantbyOrcidId.url}")
    private String searchParticipantbyOrcidId;
    
    
    @Value("${participant.url}")
    private String participantUrl;

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
     * @param participantId
     *            the participant id
     * @return the participant
     */
    @Override
    public final Participant searchParticipantByParticipantId(
            final String participantId) {
        return (Participant) RestServiceInvokerUtil.getServiceData(
                searchparticipantbyidurl + participantId, Participant.class);

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
    public final List<Participant> searchParticipantByName(
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
    public final AddressMapper getAddress(final String participantId) {
        final String url = participantCrudUrl + participantId + "/addresses";
        return (AddressMapper) StubInvokerUtil.restGetServiceInvoker(url,
                AddressMapper.class);
    }

    /**
     * Update address.
     *
     * @param participantId
     *            the participant id
     * @param address
     *            the address
     * @return the response entity
     * @throws Exception
     *             the exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public final ResponseEntity updateAddress(final String participantId,
            final AddressData address) {
        final String url = participantUrl;
        EntityValue entityValue = new EntityValue();
        entityValue.setAddressData(address);
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityValue(entityValue);
        return (ResponseEntity) StubInvokerUtil.restServiceResponseInvoker(url,
                HttpMethod.PUT, profileEntity, ParticipantErrorResponse.class,
                null);
    }

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
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public final ResponseEntity uploadProfileImage(final String participantId,
            final byte[] imageFile) {
        final String url = participantCrudUrl + participantId + "/profileImage";
        return (ResponseEntity) StubInvokerUtil.restServiceResponseInvoker(url,
                HttpMethod.PUT, new String(imageFile, StandardCharsets.UTF_8),
                ParticipantErrorResponse.class, null);

    }

    /**
     * Gets the profile image.
     *
     * @param participantId
     *            the participant id
     * @return the profile image
     */
    @Override
    public final byte[] getProfileImage(final String participantId) {
        final String url = participantCrudUrl + participantId + "/profileImage";
        return (byte[]) StubInvokerUtil
                .restGetServiceInvoker(url, Byte[].class);
    }

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
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public final ResponseEntity updateAlerts(final String participantId,
            final AlertRequest alert) {
        final String url = participantUrl;
        EntityValue entityValue = new EntityValue();
        entityValue.setAlertRequest(alert);
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityValue(entityValue);
        return (ResponseEntity) StubInvokerUtil.restServiceResponseInvoker(url,
                HttpMethod.PUT, profileEntity, ParticipantErrorResponse.class,
                null);

    }

    /**
     * Gets the alerts.
     *
     * @param participantId
     *            the participant id
     * @return the alerts
     * @throws Exception
     *             the exception
     */
    @Override
    public final PreferenceValue getAlerts(final String participantId) {
        final String url = participantCrudUrl + participantId + "/preferences/" + "ALERT";
        final PreferenceMapper preferenceMapper = (PreferenceMapper) StubInvokerUtil
                .restGetServiceInvoker(url, PreferenceMapper.class);
        return preferenceMapper.getPreferenceValue();
    }

    /**
     * Update profile.
     *
     * @param profileEntity
     *            the profile entity
     * @return the response entity
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public final boolean updateProfile(final ProfileEntity profileEntity) {

        final String url = "http://10.201.64.81:8090/profileservice/v1/profile";
        boolean status = false;
        ParticipantUpdateSuccessResponse participantUpdateSuccessResponse = (ParticipantUpdateSuccessResponse) StubInvokerUtil
                .restServiceResponseInvoker(url, HttpMethod.PUT, profileEntity,
                        ParticipantUpdateSuccessResponse.class, null);
        if (AuthorServicesConstants.SUCCESS
                .equalsIgnoreCase(participantUpdateSuccessResponse.getStatus())) {
            status = true;
        } else {
            throw new UserException(participantUpdateSuccessResponse.getError()
                    .getErrorCode(), participantUpdateSuccessResponse
                    .getError().getErrorMessage());
        }
        return status;

    }

    /**
     * Gets the preferred journals.
     *
     * @param participantId
     *            the participant id
     * @return the preferred journals
     */
    @Override
    public final Preferences getPreferredJournals(final String participantId) {
        final String url = participantCrudUrl + participantId + "/preferences/JOURNAL";

        return (Preferences) RestServiceInvokerUtil.getServiceData(url,
                Preferences.class);
    }

    /**
     * Delete preferred journal.
     *
     * @param profileEntity
     *            the profile entity
     * @return true, if successful
     */
    @Override
    public final boolean deletePreferredJournal(
            final ProfileEntity profileEntity) {
        final String url = "/v1/profile/";

        RestServiceInvokerUtil.deleteparticipantServiceData(url, profileEntity);
        return false;
    }

    /**
     * Adds the preferred journals.
     *
     * @param profileEntity
     *            the profile entity
     */
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
    public final Participant searchParticipantByOrcidId(final String orcidId) {
        ParticipantGetResponse participantGetResponse = (ParticipantGetResponse) RestServiceInvokerUtil
                .getServiceData(searchParticipantbyOrcidId.concat(orcidId),
                        ParticipantGetResponse.class);
        return participantGetResponse.getParticipantList().get(0);
    }

    @Override
    public Participant searchParticipantByEmailId(final String userId) {
        final String participantSearchUrl = participantCrudUrl
                .concat("?email=").concat(userId);
        ParticipantGetResponse participantGetResponse = (ParticipantGetResponse) RestServiceInvokerUtil
                .getServiceData(participantSearchUrl,
                        ParticipantGetResponse.class);
        return participantGetResponse.getParticipantList().get(0);
    }

}
