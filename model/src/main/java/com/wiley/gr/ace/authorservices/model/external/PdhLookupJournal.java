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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class PdhLookupJournal.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Lookup-Response")
public class PdhLookupJournal {

    /** The header. */
    @XmlElement(name = "Header")
    private Header header;

    /** The journal product entities. */
    @XmlElement(name = "Product-Entities")
    private JournalProductEntities journalProductEntities;

    /**
     * Gets the header.
     *
     * @return the header
     */
    public final Header getHeader() {
        return header;
    }

    /**
     * Sets the header.
     *
     * @param header
     *            the new header
     */
    public final void setHeader(final Header header) {
        this.header = header;
    }

    /**
     * Gets the journal product entities.
     *
     * @return the journal product entities
     */
    public final JournalProductEntities getJournalProductEntities() {
        return journalProductEntities;
    }

    /**
     * Sets the journal product entities.
     *
     * @param journalProductEntities
     *            the new journal product entities
     */
    public final void setJournalProductEntities(
            final JournalProductEntities journalProductEntities) {
        this.journalProductEntities = journalProductEntities;
    }

}