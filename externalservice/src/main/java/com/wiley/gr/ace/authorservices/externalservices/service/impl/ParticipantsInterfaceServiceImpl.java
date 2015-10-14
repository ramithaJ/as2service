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
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.AddressMapper;
import com.wiley.gr.ace.authorservices.model.external.AlertElement;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.ParticipantAddress;
import com.wiley.gr.ace.authorservices.model.external.PreferenceAlert;
import com.wiley.gr.ace.authorservices.model.external.PreferenceMapper;
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

    /**
     * Creates the participant.
     *
     * @param participant
     *            the participant
     * @return the string
     */
    @Override
    public String createParticipant(final Participant participant) {
        final Participant createdParticipant = (Participant) RestServiceInvokerUtil
                .restServiceInvoker(participantCrudUrl, participant,
                        Participant.class);
        return createdParticipant.getParticipantId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService
     * #searchParticipantByParticipantId(java.lang.String)
     */
    @Override
    public Participant searchParticipantByParticipantId(
            final String participantId) {
        final Participant participant = (Participant) RestServiceInvokerUtil
                .getServiceData(searchparticipantbyidurl + participantId,
                        Participant.class);
        return participant;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService#searchParticipantByUserId(java.lang.String)
     */
    @Override
    public Participant searchParticipantByUserId(final String userId) {

        final String participantSearchUrl = participantCrudUrl.concat(
                "?userId=").concat(userId);
        return (Participant) RestServiceInvokerUtil.getServiceData(
                participantSearchUrl, Participant.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService#searchParticipantByName(java.lang.String,
     * java.lang.String)
     */
    @Override
    public ArrayList<Participant> searchParticipantByName(
            final String firstName, final String lastName) {
        // TODO Auto-generated method stub
        return null;
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
            final ParticipantAddress participantAddress) throws Exception {
        final String url = "https://schema.org/PostalAddress/participants/"
                + participantId + "/addresses";
        final ResponseEntity resposeEntity = (ResponseEntity) StubInvokerUtil
                .restServiceResponseInvoker(url, HttpMethod.POST,
                        participantAddress, ParticipantError.class, null);
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
            final AlertElement alert) throws Exception {
        final String url = "https://schema.org/PostalAddress/participants/"
                + participantId + "/preferences";
        final ResponseEntity resposeEntity = (ResponseEntity) StubInvokerUtil
                .restServiceResponseInvoker(url, HttpMethod.POST, alert,
                        ParticipantError.class, null);
        return resposeEntity;
    }

    @Override
    public List<PreferenceAlert> getAlerts(final String participantId)
            throws Exception {
        final String url = "http://assearchdev.wiley.com:8080/v1/participants/"
                + participantId + "/preferences";
        final PreferenceMapper preferenceMapper = (PreferenceMapper) StubInvokerUtil
                .restGetServiceInvoker(url, PreferenceMapper.class);
        return preferenceMapper.getContent();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService#searchParticipantByEmail(java.lang.String)
     */
    @Override
    public Participant searchParticipantByEmail(final String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity updateProfile(final ProfileEntity profileEntity) {

        final String url = "http://assearchdev.wiley.com:8080/v1/profile/";
        final ResponseEntity resposeEntity = (ResponseEntity) StubInvokerUtil
                .restServiceResponseInvoker(url, HttpMethod.PUT, profileEntity,
                        ProfileResponse.class, null);
        return resposeEntity;
    }

    @Override
    public Preferences getPreferredJournals(final String participantId) {
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
    public boolean deletePreferredJournal(final ProfileEntity profileEntity) {
        final String url = "/v1/profile/";

        RestServiceInvokerUtil.deleteparticipantServiceData(url, profileEntity);
        return false;
    }

    @Override
    public void addPreferredJournals(final ProfileEntity profileEntity) {

        final String url = "/v1/profile/";
        RestServiceInvokerUtil.restServiceInvoker(url, profileEntity,
                String.class);
    }
}
