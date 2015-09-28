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

package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class NotificationRequest.
 */
public class NotificationRequest {

    /** The from. */
    private String from;

    /** The to. */
    private List<String> to;

    /** The template details. */
    @JsonProperty("templateDetails")
    private NotificationFieldList templateDetails;

    /**
     * Gets the from.
     *
     * @return the from
     */
    public final String getFrom() {
        return from;
    }

    /**
     * Gets the template details.
     *
     * @return the template details
     */
    public final NotificationFieldList getTemplateDetails() {
        return templateDetails;
    }

    /**
     * Sets the from.
     *
     * @param from
     *            the new from
     */
    public final void setFrom(final String from) {
        this.from = from;
    }

    /**
     * Sets the template details.
     *
     * @param templateDetails
     *            the new template details
     */
    public final void setTemplateDetails(
            final NotificationFieldList templateDetails) {
        this.templateDetails = templateDetails;
    }

    /**
     * @return the to
     */
    public final List<String> getTo() {
        return to;
    }

    /**
     * @param to
     *            the to to set
     */
    public final void setTo(final List<String> to) {
        this.to = to;
    }

}
