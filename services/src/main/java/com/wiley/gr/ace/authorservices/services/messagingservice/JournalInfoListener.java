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
package com.wiley.gr.ace.authorservices.services.messagingservice;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.services.service.SaveJournalInfoService;
import com.wiley.gr.ace.authorservices.services.service.impl.SaveJournalInfoServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving journalInfo events. The class that is
 * interested in processing a journalInfo event implements this interface, and
 * the object created with that class is registered with a component using the
 * component's <code>addJournalInfoListener<code> method. When
 * the journalInfo event occurs, that object's appropriate
 * method is invoked.
 *
 * @author virtusa version 1.0
 */
public class JournalInfoListener implements MessageListener {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(JournalInfoListener.class);

    /**
     * on message.
     *
     * @param message
     *            the message
     * 
     */
    @Override
    public void onMessage(final Message message) {
        try {
            final String journalInfoTypeEvent = "<even:journalInfo xsi:type=\"even:JournalInfoType\">"
                    + "<art:journalID>4321</art:journalID>"
                    + "<art:journalName>TestJournal</art:journalName>"
                    + "<art:journalSetupState>Test State</art:journalSetupState>"
                    + "<art:revenueModel>TestModel</art:revenueModel>"
                    + "</even:journalInfo>";

            final SaveJournalInfoService journalInfoTypeService = new SaveJournalInfoServiceImpl();
            journalInfoTypeService
                    .parseJournalInfoTypeEvent(journalInfoTypeEvent);
        } catch (final Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException();
        }
    }
}
