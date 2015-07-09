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

/**
 * The Class DashboardView.
 *
 * @author virtusa version 1.0
 */
public class DashboardView {

    /** The article data. */
    private List<ArticleData> articleData;

    /** The communication details. */
    private List<CommunicationDetails> communicationDetails;

    /** The article citation record. */
    private List<ArticleCitationRecord> articleCitationRecord;

    /**
     * Gets the article data.
     *
     * @return the articleData
     */
    public final List<ArticleData> getArticleData() {
        return articleData;
    }

    /**
     * Sets the article data.
     *
     * @param articleData
     *            the articleData to set
     */
    public final void setArticleData(final List<ArticleData> articleData) {
        this.articleData = articleData;
    }

    /**
     * Gets the communication details.
     *
     * @return the communicationDetails
     */
    public final List<CommunicationDetails> getCommunicationDetails() {
        return communicationDetails;
    }

    /**
     * Sets the communication details.
     *
     * @param communicationDetails
     *            the communicationDetails to set
     */
    public final void setCommunicationDetails(
            final List<CommunicationDetails> communicationDetails) {
        this.communicationDetails = communicationDetails;
    }

    /**
     * Gets the article citation record.
     *
     * @return the articleCitationRecord
     */
    public final List<ArticleCitationRecord> getArticleCitationRecord() {
        return articleCitationRecord;
    }

    /**
     * Sets the article citation record.
     *
     * @param articleCitationRecord
     *            the articleCitationRecord to set
     */
    public final void setArticleCitationRecord(
            final List<ArticleCitationRecord> articleCitationRecord) {
        this.articleCitationRecord = articleCitationRecord;
    }

    /**
     * Gets the article read record.
     *
     * @return the articleReadRecord
     */
    public final List<ArticleReadRecord> getArticleReadRecord() {
        return articleReadRecord;
    }

    /**
     * Sets the article read record.
     *
     * @param articleReadRecord
     *            the articleReadRecord to set
     */
    public final void setArticleReadRecord(
            final List<ArticleReadRecord> articleReadRecord) {
        this.articleReadRecord = articleReadRecord;
    }

    /** The article read record. */
    private List<ArticleReadRecord> articleReadRecord;

}
