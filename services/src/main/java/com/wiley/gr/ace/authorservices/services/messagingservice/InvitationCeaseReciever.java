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

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class InvitationCeaseReciever.
 * 
 * @author virtusa version 1.0
 */
public class InvitationCeaseReciever {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(InvitationCeaseReciever.class);

    /**
     * Queue receiver.
     */
    public final void queueReceiver() {
        try {
            LOGGER.info("Inside queuReciever of InvitationCeaseReciever");
            InitialContext initCtx = new InitialContext();
            QueueConnectionFactory ceaseQueueConnFactory = (QueueConnectionFactory) initCtx
                    .lookup("myQueueConnectionFactory");
            QueueConnection ceaseQueueConn = ceaseQueueConnFactory
                    .createQueueConnection();
            ceaseQueueConn.start();

            QueueSession queueSession = ceaseQueueConn.createQueueSession(
                    false, Session.AUTO_ACKNOWLEDGE);

            Queue queue = (Queue) initCtx.lookup("myQueue");

            QueueReceiver receiver = queueSession.createReceiver(queue);

            QueueListener listener = new QueueListener();
            receiver.setMessageListener(listener);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
