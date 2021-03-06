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
package com.wiley.gr.ace.authorservices.model.event;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class EventData.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "even:eventData")
public class EventData {

    /** The journal info. */
    @XmlElement(name = "even:journalInfo")
    private JournalInfo journalInfo;

    /** The co author list. */
    @XmlElement(name = "even:coAuthorList")
    private List<CoAuthorList> coAuthorList;

    /** The corresponding author. */
    @XmlElement(name = "even:correspondingAuthor")
    private CorrespondingAuthor correspondingAuthor;

    /** The article info. */
    @XmlElement(name = "even:articleInfo")
    private ArticleInfo articleInfo;

    /**
     * Gets the journal info.
     *
     * @return the journalInfo
     */
    public JournalInfo getJournalInfo() {
        return journalInfo;
    }

    /**
     * Sets the journal info.
     *
     * @param journalInfo
     *            the journalInfo to set
     */
    public void setJournalInfo(final JournalInfo journalInfo) {
        this.journalInfo = journalInfo;
    }

    /**
     * @return the coAuthorList
     */
    public final List<CoAuthorList> getCoAuthorList() {
        return coAuthorList;
    }

    /**
     * @param coAuthorList
     *            the coAuthorList to set
     */
    public final void setCoAuthorList(final List<CoAuthorList> coAuthorList) {
        this.coAuthorList = coAuthorList;
    }

    /**
     * Sets the co author list.
     *
     * @param coAuthorList
     *            the coAuthorList to set
     */
    public void setCoAuthorList(final ArrayList<CoAuthorList> coAuthorList) {
        this.coAuthorList = coAuthorList;
    }

    /**
     * Gets the corresponding author.
     *
     * @return the correspondingAuthor
     */
    public CorrespondingAuthor getCorrespondingAuthor() {
        return correspondingAuthor;
    }

    /**
     * Sets the corresponding author.
     *
     * @param correspondingAuthor
     *            the correspondingAuthor to set
     */
    public void setCorrespondingAuthor(
            final CorrespondingAuthor correspondingAuthor) {
        this.correspondingAuthor = correspondingAuthor;
    }

    /**
     * Gets the article info.
     *
     * @return the articleInfo
     */
    public ArticleInfo getArticleInfo() {
        return articleInfo;
    }

    /**
     * Sets the article info.
     *
     * @param articleInfo
     *            the articleInfo to set
     */
    public void setArticleInfo(final ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }

}
