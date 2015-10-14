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
 * The Class ParticipantGenericResponse.
 */
public class ParticipantGenericResponse {

    /** The participant links. */
    @JsonProperty("_links")
    private ArrayList<ParticipantLinks> participantLinks;

    /**
     * Gets the participant links.
     *
     * @return the participant links
     */
    public final ArrayList<ParticipantLinks> getParticipantLinks() {
        return participantLinks;
    }

    /**
     * Sets the participant links.
     *
     * @param participantLinks
     *            the new participant links
     */
    public final void setParticipantLinks(
            final ArrayList<ParticipantLinks> participantLinks) {
        this.participantLinks = participantLinks;
    }
}
