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

import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.Participant;

// TODO: Auto-generated Javadoc
/**
 * The Class ParticipantsInterfaceServiceImpl.
 */
public class ParticipantsInterfaceServiceImpl implements
ParticipantsInterfaceService {

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

	/* (non-Javadoc)
	 * @see com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService#searchParticipantByParticipantId(java.lang.String)
	 */
	@Override
	public Participant searchParticipantByParticipantId(String particpantId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService#searchParticipantByUserId(java.lang.String)
	 */
	@Override
	public Participant searchParticipantByUserId(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Participant> searchParticipantByName(String firstName,
			String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
