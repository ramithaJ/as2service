package com.wiley.gr.ace.authorservices.model.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "businessEvent", namespace="http://www.wiley.com/bpm/event")
public class InvitationStartModel {
	
	@XmlElement(name = "eventData")
	InvitationStartEventData startEvent;

	
	public InvitationStartEventData getStartEvent() {
		return startEvent;
	}

	public void setStartEvent(InvitationStartEventData startEvent) {
		this.startEvent = startEvent;
	}
}
