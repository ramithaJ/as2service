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

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wiley.gr.ace.authorservices.model.external.AlertElement;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.ParticipantAddress;

// TODO: Auto-generated Javadoc
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
	List<Participant> searchParticipantByName(String firstName, String lastName);

	List<ParticipantAddress> getAddress(String participantId) throws Exception;

	ResponseEntity<?> updateAddress(String participantId,
			ParticipantAddress participantAddress) throws Exception;

	ResponseEntity<?> uploadProfileImage(String participantId, Byte[] imageFile)
			throws Exception;

	Byte[] getProfileImage(String participantId) throws Exception;

	ResponseEntity<?> updateAlerts(String participantId, AlertElement alert)
			throws Exception;

	List<AlertElement> getAlerts(String participantId) throws Exception;
}
