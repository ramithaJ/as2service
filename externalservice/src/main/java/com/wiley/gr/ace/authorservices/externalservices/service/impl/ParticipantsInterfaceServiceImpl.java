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

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.Participant;

/**
 * The Class ParticipantsInterfaceServiceImpl.
 */
public class ParticipantsInterfaceServiceImpl implements
		ParticipantsInterfaceService {
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

	@Override
	public List<Participant> searchParticipantByName(final String firstName,
			final String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
