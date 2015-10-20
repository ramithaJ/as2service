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
 * * @author virtusa version 1.0
 *
 */
public class JournalInfoReceiver {
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(JournalInfoReceiver.class);

    /**
     * Queue receiver.
     */
    public void queueReceiver() {
        try {

            LOGGER.info("Start queue receiver ...");
            // 1) Create and start connection
            final InitialContext initCtx = new InitialContext();
            final QueueConnectionFactory queueConnFactory = (QueueConnectionFactory) initCtx
                    .lookup("myQueueConnectionFactory");
            final QueueConnection queueConn = queueConnFactory
                    .createQueueConnection();
            queueConn.start();

            // 2) create Queue session
            final QueueSession queueSession = queueConn.createQueueSession(
                    false, Session.AUTO_ACKNOWLEDGE);
            // 3) get the Queue object
            final Queue queue = (Queue) initCtx.lookup("myQueue");
            // 4)create QueueReceiver
            final QueueReceiver receiver = queueSession.createReceiver(queue);

            // 5) create listener object
            LOGGER.info("Registered queue listener ...");
            final JournalInfoListener listener = new JournalInfoListener();
            receiver.setMessageListener(listener);

        } catch (final Exception e) {
            LOGGER.error("Exceprion while receiving Journal Info Event :: "
                    + e.getMessage());
        }
    }
}
