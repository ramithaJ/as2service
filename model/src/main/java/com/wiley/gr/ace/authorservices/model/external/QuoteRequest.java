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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class QuoteRequest.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class QuoteRequest {

    /** The article id. */
    private Integer articleId;

    /** The journal print issn. */
    private String journalPrintISSN;

    /** The journal electronic issn. */
    private String journalElectronicISSN;

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
    public final void setArticleId(final Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets the journal print issn.
     *
     * @return the journal print issn
     */
    public final String getJournalPrintISSN() {
        return journalPrintISSN;
    }

    /**
     * Sets the journal print issn.
     *
     * @param journalPrintISSN
     *            the new journal print issn
     */
    public final void setJournalPrintISSN(final String journalPrintISSN) {
        this.journalPrintISSN = journalPrintISSN;
    }

    /**
     * Gets the journal electronic issn.
     *
     * @return the journal electronic issn
     */
    public final String getJournalElectronicISSN() {
        return journalElectronicISSN;
    }

    /**
     * Sets the journal electronic issn.
     *
     * @param journalElectronicISSN
     *            the new journal electronic issn
     */
    public final void setJournalElectronicISSN(
            final String journalElectronicISSN) {
        this.journalElectronicISSN = journalElectronicISSN;
    }

}
