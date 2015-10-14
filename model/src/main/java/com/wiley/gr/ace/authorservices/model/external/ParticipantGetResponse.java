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
package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ParticipantGetResponse.
 */
public class ParticipantGetResponse extends ParticipantGenericResponse {

    /** The participant list. */
    @JsonProperty("content")
    private ArrayList<Participant> participantList;

    /**
     * Gets the participant list.
     *
     * @return the participant list
     */
    public final ArrayList<Participant> getParticipantList() {
        return participantList;
    }

    /**
     * Sets the participant list.
     *
     * @param participantList
     *            the new participant list
     */
    public final void setParticipantList(
            final ArrayList<Participant> participantList) {
        this.participantList = participantList;
    }
}
