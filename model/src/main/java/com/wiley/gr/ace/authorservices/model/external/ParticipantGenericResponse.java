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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ParticipantGenericResponse.
 */
public class ParticipantGenericResponse {

    /** The participant links. */
    @JsonProperty("_links")
    private List<ParticipantLinks> participantLinks;

    /**
     * @return the participantLinks
     */
    public final List<ParticipantLinks> getParticipantLinks() {
        return participantLinks;
    }

    /**
     * @param participantLinks
     *            the participantLinks to set
     */
    public final void setParticipantLinks(
            final List<ParticipantLinks> participantLinks) {
        this.participantLinks = participantLinks;
    }

}
