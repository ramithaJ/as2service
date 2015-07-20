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

// TODO: Auto-generated Javadoc
/**
 * The Class ArticleAcceptanceReceiver.
 */
public class ArticleAcceptanceReceiver {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ArticleAcceptanceReceiver.class);

	/**
	 * Queue receiver.
	 */
	public void queueReceiver() {
		try {

			LOGGER.info("Start queue receiver ...");
			// 1) Create and start connection
			InitialContext initCtx = new InitialContext();
			QueueConnectionFactory queueConnFactory = (QueueConnectionFactory) initCtx
					.lookup("myQueueConnectionFactory");
			QueueConnection queueConn = queueConnFactory
					.createQueueConnection();
			queueConn.start();

			// 2) create Queue session
			QueueSession queueSession = queueConn.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			// 3) get the Queue object
			Queue queue = (Queue) initCtx.lookup("myQueue");
			// 4)create QueueReceiver
			QueueReceiver receiver = queueSession.createReceiver(queue);

			// 5) create listener object
			LOGGER.info("Registered queue listener ...");
			QueueListener listener = new QueueListener();
			receiver.setMessageListener(listener);  
			
			
		} catch (Exception e) {
			LOGGER.error("Exceprion while receiving Article Event :: "
					+ e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

	}
}
