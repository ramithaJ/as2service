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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class JournalInfo.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "even:journalInfo")
public class JournalInfo {

    /** The journal id. */
    @XmlElement(name = "art:journalID")
    private String journalID;

    /** The journal name. */
    @XmlElement(name = "art:journalName")
    private String journalName;

    /** The journal setup state. */
    @XmlElement(name = "art:journalSetupState")
    private String journalSetupState;

    /**
     * Sets the revenue model.
     *
     * @param revenueModel
     *            the new revenue model
     */
    public final void setRevenueModel(final String revenueModel) {
        this.revenueModel = revenueModel;
    }

    /** The revenue model. */
    @XmlElement(name = "art:revenueModel")
    private String revenueModel;

    /**
     * Gets the journal id.
     *
     * @return the journalID
     */
    public String getJournalID() {
        return journalID;
    }

    /**
     * Sets the journal id.
     *
     * @param journalID
     *            the journalID to set
     */
    public void setJournalID(final String journalID) {
        this.journalID = journalID;
    }

    /**
     * Gets the journal name.
     *
     * @return the journalName
     */
    public String getJournalName() {
        return journalName;
    }

    /**
     * Sets the journal name.
     *
     * @param journalName
     *            the journalName to set
     */
    public void setJournalName(final String journalName) {
        this.journalName = journalName;
    }

    /**
     * Gets the journal setup state.
     *
     * @return the journal setup state
     */
    public final String getJournalSetupState() {
        return journalSetupState;
    }

    /**
     * Sets the journal setup state.
     *
     * @param journalSetupState
     *            the new journal setup state
     */
    public final void setJournalSetupState(final String journalSetupState) {
        this.journalSetupState = journalSetupState;
    }

    /**
     * Gets the revenue model.
     *
     * @return the revenue model
     */
    public final String getRevenueModel() {
        return revenueModel;
    }
}
