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

    /** The article titile. */
    private String articleTitile;

    /** The base price. */
    private String basePrice;

    /** The author. */
    private String author;

    /**
     * Gets the journal title.
     *
     * @return the journal title
     */
    public String getJournalTitle() {
        return journalTitle;
    }

    /**
     * Sets the journal title.
     *
     * @param journalTitle
     *            the new journal title
     */
    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    /**
     * Gets the journal description.
     *
     * @return the journal description
     */
    public String getJournalDescription() {
        return journalDescription;
    }

    /**
     * Sets the journal description.
     *
     * @param journalDescription
     *            the new journal description
     */
    public void setJournalDescription(String journalDescription) {
        this.journalDescription = journalDescription;
    }

    /**
     * Gets the article titile.
     *
     * @return the article titile
     */
    public String getArticleTitile() {
        return articleTitile;
    }

    /**
     * Sets the article titile.
     *
     * @param articleTitile
     *            the new article titile
     */
    public void setArticleTitile(String articleTitile) {
        this.articleTitile = articleTitile;
    }

    /**
     * Gets the base price.
     *
     * @return the base price
     */
    public String getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price.
     *
     * @param basePrice
     *            the new base price
     */
    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * Gets the author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author.
     *
     * @param author
     *            the new author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

}
