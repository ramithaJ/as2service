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

/**
 * The Class DashboardView.
 *
 * @author yugandhark
 */
public class DashboardView {

    /** The article data. */
    private List<ArticleData> articleData;

    /** The communication details. */
    private List<CommunicationDetails> communicationDetails;

    /** The article citation record. */
    private List<ArticleCitationRecord> articleCitationRecord;

    /** The article read record. */
    private List<ArticleReadRecord> articleReadRecord;

    /**
     * Gets the article data.
     *
     * @return the article data
     */
    public List<ArticleData> getArticleData() {
        return articleData;
    }

    /**
     * Sets the article data.
     *
     * @param articleData
     *            the new article data
     */
    public void setArticleData(List<ArticleData> articleData) {
        this.articleData = articleData;
    }

    /**
     * Gets the communication details.
     *
     * @return the communication details
     */
    public List<CommunicationDetails> getCommunicationDetails() {
        return communicationDetails;
    }

    /**
     * Sets the communication details.
     *
     * @param communicationDetails
     *            the new communication details
     */
    public void setCommunicationDetails(
            List<CommunicationDetails> communicationDetails) {
        this.communicationDetails = communicationDetails;
    }

    /**
     * Gets the article citation record.
     *
     * @return the article citation record
     */
    public List<ArticleCitationRecord> getArticleCitationRecord() {
        return articleCitationRecord;
    }

    /**
     * Sets the article citation record.
     *
     * @param articleCitationRecord
     *            the new article citation record
     */
    public void setArticleCitationRecord(
            List<ArticleCitationRecord> articleCitationRecord) {
        this.articleCitationRecord = articleCitationRecord;
    }

    /**
     * Gets the article read record.
     *
     * @return the article read record
     */
    public List<ArticleReadRecord> getArticleReadRecord() {
        return articleReadRecord;
    }

    /**
     * Sets the article read record.
     *
     * @param articleReadRecord
     *            the new article read record
     */
    public void setArticleReadRecord(List<ArticleReadRecord> articleReadRecord) {
        this.articleReadRecord = articleReadRecord;
    }

}
