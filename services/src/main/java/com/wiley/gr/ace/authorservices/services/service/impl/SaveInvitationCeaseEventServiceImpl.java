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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.model.event.InvitationCeaseEventData;
import com.wiley.gr.ace.authorservices.persistence.services.InvitationCeaseDAO;
import com.wiley.gr.ace.authorservices.services.service.SaveInvitationCeaseEventService;

/**
 * The Class SaveInvitationCeaseEventServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class SaveInvitationCeaseEventServiceImpl implements
        SaveInvitationCeaseEventService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SaveInvitationCeaseEventServiceImpl.class);

    /** The invitation cease dao. */
    @Autowired(required = true)
    private InvitationCeaseDAO invitationCeaseDAO;

    /**
     * Parses the invitation cease event.
     *
     * @param invitationCeaseEvent
     *            the invitation cease event data
     * @throws Exception
     *             the exception
     */
    @Override
    public final void parseInvitationCeaseEvent(
            final String invitationCeaseEvent) throws Exception {
        LOGGER.info("inside parseInvitationCeaseEvent of SaveInvitationCeaseEventServiceImpl");
        if (null != invitationCeaseEvent
                && invitationCeaseEvent.trim().length() > 0) {

            StringReader reader = new StringReader(invitationCeaseEvent);
            JAXBContext invitationCeaseEventDataContext = JAXBContext
                    .newInstance(InvitationCeaseEventData.class);
            InvitationCeaseEventData ceaseEventData = (InvitationCeaseEventData) invitationCeaseEventDataContext
                    .createUnmarshaller().unmarshal(reader);
            if (!StringUtils.isEmpty(ceaseEventData)) {
                String email = ceaseEventData.getEmail();
                invitationCeaseDAO.updateInviteResetPWDLog(email);
            }

        }

    }

}
