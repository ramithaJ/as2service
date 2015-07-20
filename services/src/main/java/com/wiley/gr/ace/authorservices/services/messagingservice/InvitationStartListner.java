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
package com.wiley.gr.ace.authorservices.services.messagingservice;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiley.gr.ace.authorservices.services.service.SaveInvitationStartEventService;
import com.wiley.gr.ace.authorservices.services.service.impl.SaveInvitationStartServiceImpl;

/**
 * The Class InvitationStartListner.
 * 
 * @author virtusa version 1.0
 */
public class InvitationStartListner implements MessageListener {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(InvitationStartListner.class);

    /**
     * on message.
     *
     * @param message
     *            the message
     * 
     */
    public final void onMessage(final Message message) {
        LOGGER.info("Inside onMessage of InvitationStartListner");
        try {

            String invitationStartEvent = "<?xml version = '1.0' encoding='UTF-8'?>"
                    + "<InvitationStartEventDataType xmlns:='http://www.wiley.com/bpm/event'>"
                    + "<articleID>12</articleID>"
                    + "<email>abcd@gmail.com</email>"
                    + "<userRole>102</userRole>"
                    + "<userId>23</userId>"
                    + "<notificationId>111</notificationId>"
                    + "</InvitationStartEventDataType>";

            SaveInvitationStartEventService saveInvitationStartEventService = new SaveInvitationStartServiceImpl();
            saveInvitationStartEventService
                    .parseInvitationStartEvent(invitationStartEvent);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
