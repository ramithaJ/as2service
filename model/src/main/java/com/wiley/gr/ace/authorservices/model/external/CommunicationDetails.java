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

/**
 * The Class CommunicationDetails.
 *
 * @author virtusa version 1.0
 */
public class CommunicationDetails {

    /** The from. */
    private String from;

    /** The subject. */
    private String subject;

    /** The body. */
    private String body;

    /**
     * Gets the from.
     *
     * @return the from
     */
    public final String getFrom() {
        return from;
    }

    /**
     * Sets the from.
     *
     * @param from
     *            the from to set
     */
    public final void setFrom(final String from) {
        this.from = from;
    }

    /**
     * Gets the subject.
     *
     * @return the subject
     */
    public final String getSubject() {
        return subject;
    }

    /**
     * Sets the subject.
     *
     * @param subject
     *            the subject to set
     */
    public final void setSubject(final String subject) {
        this.subject = subject;
    }

    /**
     * Gets the body.
     *
     * @return the body
     */
    public final String getBody() {
        return body;
    }

    /**
     * Sets the body.
     *
     * @param body
     *            the body to set
     */
    public final void setBody(final String body) {
        this.body = body;
    }

}
