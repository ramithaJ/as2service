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

import com.wiley.gr.ace.authorservices.services.service.SaveArticleData;
import com.wiley.gr.ace.authorservices.services.service.impl.SaveArticleDataImpl;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving queue events. The class that is
 * interested in processing a queue event implements this interface, and the
 * object created with that class is registered with a component using the
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

	/*
	 * @Autowired(required = true) private SaveArticleData saveArticleData;
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	public void onMessage(Message message) {
		try {

			/*
			 * LOGGER.info("Received Article Acceptance Event .."); TextMessage
			 * textMessage = (TextMessage) message; String articleEvent =
			 * textMessage.getText(); LOGGER.debug("Following data received :: "
			 * + articleEvent);
			 */

			String articleEvent = "<even:eventData xsi:type=\"even:ArticleAcceptanceEventDataType\">"
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

			SaveArticleData saveArticleData = new SaveArticleDataImpl();
			saveArticleData.parseArticleEvent(articleEvent);

		} /*
		 * catch (JMSException jmsExp) { LOGGER.error("JMS exception :: " +
		 * jmsExp.getMessage()); jmsExp.printStackTrace(); }
		 */catch (Exception e) {
			LOGGER.error("Exception :: " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		QueueListener ql = new QueueListener();
		ql.onMessage(null);
	}

}
