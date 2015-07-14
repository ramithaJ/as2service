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

import com.wiley.gr.ace.authorservices.services.service.SaveInvitationCeaseEventService;
import com.wiley.gr.ace.authorservices.services.service.impl.SaveInvitationCeaseEventServiceImpl;

/**
 * The Class InvitationCeaseListner.
 * 
 * @author virtusa version 1.0
 */
public class InvitationCeaseListner implements MessageListener {
    /** logger configured. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(InvitationCeaseListner.class);

    /**
     * on message.
     *
     * @param message
     *            the message
     * 
     */
    public final void onMessage(final Message message) {
        LOGGER.info("Inside onMessage of InvitationCeaseListner");
        try {

            String invitationCeaseEvent = "<even:eventData xsi:type=\"even:ArticleAcceptanceEventDataType\">"
                    + "<even:articleInfo>"
                    + "<art:articleID>1234</art:articleID>"
                    + "<art:articleName>TestArticle</art:articleName>"
                    + "</even:articleInfo>"
                    + "<even:journalInfo>"
                    + "<art:journalID>4321</art:journalID>"
                    + "<art:journalName>TestJournal</art:journalName>"
                    + "</even:journalInfo>"
                    + "<even:correspondingAuthor>"
                    + "<art:fullName>Matt Hejnas</art:fullName>"
                    + "<art:userID>GUID123</art:userID>"
                    + "<art:email>matt@cedrusco.com</art:email>"
                    + "<art:registeredInd>false</art:registeredInd>"
                    + "</even:correspondingAuthor>"
                    + "<even:coAuthorList>"
                    + "<art:fullName>Matt Hejnas</art:fullName>"
                    + "<art:userID>GUID456</art:userID>"
                    + "<art:email>matt2@cedrusco.com</art:email>"
                    + "<art:registeredInd>false</art:registeredInd>"
                    + "</even:coAuthorList>"
                    + "<even:coAuthorList>"
                    + "<art:fullName>Matt Hejnas</art:fullName>"
                    + "<art:userID>GUID789</art:userID>"
                    + "<art:email>matt3@cedrusco.com</art:email>"
                    + "<art:registeredInd>false</art:registeredInd>"
                    + "</even:coAuthorList>"
                    + "<even:coAuthorList>"
                    + "<art:fullName>Matt Hejnas</art:fullName>"
                    + "<art:userID>GUID987</art:userID>"
                    + "<art:email>matt4@cedrusco.com</art:email>"
                    + "<art:registeredInd>false</art:registeredInd>"
                    + "</even:coAuthorList>" + "</even:eventData>";

            SaveInvitationCeaseEventService saveInvitationCeaseEventService = new SaveInvitationCeaseEventServiceImpl();
            saveInvitationCeaseEventService
                    .parseInvitationCeaseEvent(invitationCeaseEvent);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
