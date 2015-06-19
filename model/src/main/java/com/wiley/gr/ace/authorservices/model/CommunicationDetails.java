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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CommunicationDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class CommunicationDetails {

    /** The user id. */
    private Integer userId;

    /** The inviation id. */
    private Integer inviationId;

    /** The email id. */
    private String emailId;

    /** The article id. */
    private Integer articleId;

    /** The sent date. */
    private String sentDate;

    /** The sent by. */
    private Integer sentBy;

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public final Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the new user id
     */
    public final void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the inviation id.
     *
     * @return the inviation id
     */
    public final Integer getInviationId() {
        return inviationId;
    }

    /**
     * Sets the inviation id.
     *
     * @param inviationId
     *            the new inviation id
     */
    public final void setInviationId(Integer inviationId) {
        this.inviationId = inviationId;
    }

    /**
     * Gets the email id.
     *
     * @return the email id
     */
    public final String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email id.
     *
     * @param emailId
     *            the new email id
     */
    public final void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets the article id.
     *
     * @return the article id
     */
    public final Integer getArticleId() {
        return articleId;
    }

    /**
     * Sets the article id.
     *
     * @param articleId
     *            the new article id
     */
    public final void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets the sent date.
     *
     * @return the sent date
     */
    public final String getSentDate() {
        return sentDate;
    }

    /**
     * Sets the sent date.
     *
     * @param sentDate
     *            the new sent date
     */
    public final void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    /**
     * Gets the sent by.
     *
     * @return the sent by
     */
    public final Integer getSentBy() {
        return sentBy;
    }

    /**
     * Sets the sent by.
     *
     * @param sentBy
     *            the new sent by
     */
    public final void setSentBy(Integer sentBy) {
        this.sentBy = sentBy;
    }

}
