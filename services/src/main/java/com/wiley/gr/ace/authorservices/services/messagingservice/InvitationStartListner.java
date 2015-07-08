package com.wiley.gr.ace.authorservices.services.messagingservice;

import javax.jms.Message;
import javax.jms.MessageListener;

import com.wiley.gr.ace.authorservices.services.service.SaveInvitationStartEventService;
import com.wiley.gr.ace.authorservices.services.service.impl.SaveInvitationStartServiceImpl;

public class InvitationStartListner implements MessageListener {

	public void onMessage(Message message) {
		try {
			
			String invitationStartEvent = "<even:eventData xsi:type=\"even:ArticleAcceptanceEventDataType\">"
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

			SaveInvitationStartEventService saveInvitationStartEventService = new SaveInvitationStartServiceImpl();
			saveInvitationStartEventService.parseInvitationStartEvent(invitationStartEvent);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		QueueListener ql = new QueueListener();
		ql.onMessage(null);
	}

}
