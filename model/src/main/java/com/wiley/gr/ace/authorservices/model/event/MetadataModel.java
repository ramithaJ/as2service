package com.wiley.gr.ace.authorservices.model.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "businessEvent", namespace = "http://www.wiley.com/bpm/event")
public class MetadataModel {

    @XmlElement(name = "eventMetadata")
    private EventMetadata eventMetadata;

    public EventMetadata getEventMetaData() {
        return eventMetadata;
    }

    public void setEventMetaData(final EventMetadata eventMetaData) {
        this.eventMetadata = eventMetadata;
    }
}
