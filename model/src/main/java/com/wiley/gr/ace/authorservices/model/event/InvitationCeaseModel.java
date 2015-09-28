package com.wiley.gr.ace.authorservices.model.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "businessEvent", namespace="http://www.wiley.com/bpm/event")
public class InvitationCeaseModel {
	
	@XmlElement(name = "eventData")
	InvitationCeaseEventData ceaseEvent;

	
	public InvitationCeaseEventData getCeaseEvent() {
		return ceaseEvent;
	}

	public void setCeaseEvent(InvitationCeaseEventData ceaseEvent) {
		this.ceaseEvent = ceaseEvent;
	}
}
