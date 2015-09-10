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

import java.io.StringReader;

import javax.jms.Message;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.wiley.gr.ace.authorservices.model.event.InvitationCeaseEventData;
import com.wiley.gr.ace.authorservices.model.event.InvitationCeaseModel;
import com.wiley.gr.ace.authorservices.model.event.InvitationStartEventData;
import com.wiley.gr.ace.authorservices.model.event.InvitationStartModel;
import com.wiley.gr.ace.authorservices.model.event.MetadataModel;
import com.wiley.gr.ace.authorservices.services.service.SaveInvitationCeaseEventService;
import com.wiley.gr.ace.authorservices.services.service.SaveInvitationStartEventService;

public class MessageReciever {

	
	@Autowired(required=true)
    private JmsTemplate jmsTemplate;
	
	@Autowired(required=true)
	private SaveInvitationStartEventService saveInvitationStartEventService;
	
	@Autowired(required=true)
	private SaveInvitationCeaseEventService saveInvitationCeaseEventService;
	public void receiveMessage() {

		Message message = jmsTemplate
				.receive("wiley.global.as2app.inbound.events.queue");
		if (message instanceof TextMessage) {
			try {
				eventGenerator(message);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void eventGenerator(Message message) throws Exception {
		MetadataModel eventModelData = (MetadataModel) unmarshall(message,
				"com.wiley.gr.ace.authorservices.model.event.MetadataModel");
		String eventType = eventModelData.getEventMetaData().getEventTypeName();
		if (eventType.equalsIgnoreCase("InvitationStartEvent")) {
			InvitationStartModel startModel = (InvitationStartModel) unmarshall(
					message,
					"com.wiley.gr.ace.authorservices.model.event.InvitationStartModel");
			InvitationStartEventData startEventData = startModel
					.getStartEvent();
			saveInvitationStartEventService
					.parseInvitationStartEvent(startEventData);
		}

		if (eventType.equalsIgnoreCase("InvitationCeaseEvent")) {
			InvitationCeaseModel startModel = (InvitationCeaseModel) unmarshall(
					message,
					"com.wiley.gr.ace.authorservices.model.event.InvitationCeaseModel");
			InvitationCeaseEventData ceaseEventData = startModel
					.getCeaseEvent();
			saveInvitationCeaseEventService
					.parseInvitationCeaseEvent(ceaseEventData);
		}
	}

	private Object unmarshall(Message message, String className)
			throws Exception {
		StringReader reader = null;
		if (message instanceof TextMessage)
			reader = new StringReader(((TextMessage) message).getText());
		JAXBContext context = JAXBContext.newInstance(Class.forName(className));
		Object xmlData = context.createUnmarshaller().unmarshal(reader);
		return xmlData;

	}

}