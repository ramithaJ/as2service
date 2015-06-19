/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model;


public class QuoteDetails {

    private ArticleDetails articleDetails;

    private QuoteDetail quoteDetail;

    private JournalDetails journalDetails;

    private String authorName;

    /**
     * @return the articleDetails
     */
    public final ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    /**
     * @param articleDetails the articleDetails to set
     */
    public final void setArticleDetails(ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * @return the quoteDetail
     */
    public final QuoteDetail getQuoteDetail() {
        return quoteDetail;
    }

    /**
     * @param quoteDetail the quoteDetail to set
     */
    public final void setQuoteDetail(QuoteDetail quoteDetail) {
        this.quoteDetail = quoteDetail;
    }

    /**
     * @return the journalDetails
     */
    public final JournalDetails getJournalDetails() {
        return journalDetails;
    }

    /**
     * @param journalDetails the journalDetails to set
     */
    public final void setJournalDetails(JournalDetails journalDetails) {
        this.journalDetails = journalDetails;
    }

    /**
     * @return the authorName
     */
    public final String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public final void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    
}
