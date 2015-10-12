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
import com.wiley.gr.ace.authorservices.model.external.AlertElement;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.ParticipantAddress;

/**
 * The Class ParticipantsInterfaceServiceImpl.
 */
public class ParticipantsInterfaceServiceImpl implements
        ParticipantsInterfaceService {

    /** The searchparticipantbyidurl. */
    @Value("${searchparticipantbyid.url}")
    private String searchparticipantbyidurl;

    /**
     * Creates the participant.
     *
     * @param participant
     *            the participant
     * @return the string
     */
    @Override
    public String createParticipant(final Participant participant) {
        // TODO Auto-generated method stub
        return null;
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
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        return null;
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

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService#getAddress(java.lang.String)
     */
    @Override
    public List<ParticipantAddress> getAddress(final String participantId)
            throws Exception {
        String url = "https://schema.org/PostalAddress/participants/"
                + participantId + "/addresses";
        List<ParticipantAddress> participantAddresses = (List<ParticipantAddress>) StubInvokerUtil
                .restGetServiceInvoker(url, ParticipantAddress.class);
        return participantAddresses;
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
        String url = "https://schema.org/PostalAddress/participants/"
                + participantId + "/addresses";
        ResponseEntity resposeEntity = (ResponseEntity) StubInvokerUtil
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
        String url = "https://schema.org/PostalAddress/participants/"
                + participantId + "/profileImage";
        ResponseEntity resposeEntity = (ResponseEntity) StubInvokerUtil
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
        String url = "https://schema.org/PostalAddress/participants/"
                + participantId + "/profileImage";
        Byte[] profileImage = (Byte[]) StubInvokerUtil.restGetServiceInvoker(
                url, Byte[].class);
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
        String url = "https://schema.org/PostalAddress/participants/"
                + participantId + "/preferences";
        ResponseEntity resposeEntity = (ResponseEntity) StubInvokerUtil
                .restServiceResponseInvoker(url, HttpMethod.POST, alert,
                        ParticipantError.class, null);
        return resposeEntity;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * ParticipantsInterfaceService#getAlerts(java.lang.String)
     */
    @Override
    public List<AlertElement> getAlerts(final String participantId)
            throws Exception {
        String url = "https://schema.org/PostalAddress/participants/"
                + participantId + "/preferences";
        List<AlertElement> alertElements = (List<AlertElement>) StubInvokerUtil
                .restGetServiceInvoker(url, AlertElement.class);
        return alertElements;
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

}
