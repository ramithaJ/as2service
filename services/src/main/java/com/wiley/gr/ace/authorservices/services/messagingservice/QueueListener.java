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

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving queue events.
 * The class that is interested in processing a queue
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addQueueListener<code> method. When
 * the queue event occurs, that object's appropriate
 * method is invoked.
 *
 * @see QueueEvent
 */
public class QueueListener implements MessageListener {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(QueueListener.class);

	/* (non-Javadoc)
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	public void onMessage(Message message) {
		try {

			LOGGER.info("Received Article Acceptance Event ..");
			TextMessage textMessage = (TextMessage) message;
			String articleEvent = textMessage.getText();
			LOGGER.debug("Following data received :: " + articleEvent);
			
			

		} catch (JMSException jmsExp) {
			LOGGER.error("JMS exception :: " + jmsExp.getMessage());
			jmsExp.printStackTrace();
		} catch (Exception e) {
			LOGGER.error("Exception :: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
