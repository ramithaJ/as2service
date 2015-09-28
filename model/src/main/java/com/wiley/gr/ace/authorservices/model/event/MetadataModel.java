package com.wiley.gr.ace.authorservices.model.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "businessEvent", namespace="http://www.wiley.com/bpm/event")
public class MetadataModel {	

	@XmlElement(name = "eventMetadata")
	private EventMetadata eventMetadata;
	
	/*@XmlElement(name = "eventData")
	private Object eventData;*/

	public EventMetadata getEventMetaData() {
		return eventMetadata;
	}

	public void setEventMetaData(EventMetadata eventMetaData) {
		this.eventMetadata = eventMetadata;
	}
/*
	public Object getEventData() {
		return eventData;
	}

	public void setEventData(Object eventData) {
		this.eventData = eventData;
	}
	*/
}
	


