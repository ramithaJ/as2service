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
package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class Journal.
 *
 * @author virtusa version 1.0
 */
public class Journal {

    /** The journal title. */
    private String journalTitle;

    /** The journal description. */
    private String journalDescription;

    /**
     * @return the journalTitle
     */
    public final String getJournalTitle() {
        return journalTitle;
    }

    /**
     * @param journalTitle
     *            the journalTitle to set
     */
    public final void setJournalTitle(final String journalTitle) {
        this.journalTitle = journalTitle;
    }

    /**
     * @return the journalDescription
     */
    public final String getJournalDescription() {
        return journalDescription;
    }

    /**
     * @param journalDescription
     *            the journalDescription to set
     */
    public final void setJournalDescription(final String journalDescription) {
        this.journalDescription = journalDescription;
    }

    /**
     * @return the articleTitile
     */
    public final String getArticleTitile() {
        return articleTitile;
    }

    /**
     * @param articleTitile
     *            the articleTitile to set
     */
    public final void setArticleTitile(final String articleTitile) {
        this.articleTitile = articleTitile;
    }

    /**
     * @return the basePrice
     */
    public final String getBasePrice() {
        return basePrice;
    }

    /**
     * @param basePrice
     *            the basePrice to set
     */
    public final void setBasePrice(final String basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * @return the author
     */
    public final String getAuthor() {
        return author;
    }

    /**
     * @param author
     *            the author to set
     */
    public final void setAuthor(final String author) {
        this.author = author;
    }

    /** The article titile. */
    private String articleTitile;

    /** The base price. */
    private String basePrice;

    /** The author. */
    private String author;

}
