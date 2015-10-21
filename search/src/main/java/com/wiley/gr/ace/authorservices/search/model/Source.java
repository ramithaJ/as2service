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
package com.wiley.gr.ace.authorservices.search.model;

/**
 * The Class Source.
 */
public class Source {

    /** The journal type. */
    private String journalType;

    /** The journal ownership type. */
    private String journalOwnershipType;

    /** The journal status. */
    private String journalStatus;

    /** The journal title. */
    private String journalTitle;

    /** The journal acronym. */
    private String journalAcronym;

    /** The journal setup state. */
    private String journalSetupState;

    /**
     * @return the journalType
     */
    public String getJournalType() {
        return journalType;
    }

    /**
     * @param journalType
     *            the journalType to set
     */
    public void setJournalType(String journalType) {
        this.journalType = journalType;
    }

    /**
     * @return the journalOwnershipType
     */
    public String getJournalOwnershipType() {
        return journalOwnershipType;
    }

    /**
     * @param journalOwnershipType
     *            the journalOwnershipType to set
     */
    public void setJournalOwnershipType(String journalOwnershipType) {
        this.journalOwnershipType = journalOwnershipType;
    }

    /**
     * @return the journalStatus
     */
    public String getJournalStatus() {
        return journalStatus;
    }

    /**
     * @param journalStatus
     *            the journalStatus to set
     */
    public void setJournalStatus(String journalStatus) {
        this.journalStatus = journalStatus;
    }

    /**
     * @return the journalTitle
     */
    public String getJournalTitle() {
        return journalTitle;
    }

    /**
     * @param journalTitle
     *            the journalTitle to set
     */
    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    /**
     * @return the journalAcronym
     */
    public String getJournalAcronym() {
        return journalAcronym;
    }

    /**
     * @param journalAcronym
     *            the journalAcronym to set
     */
    public void setJournalAcronym(String journalAcronym) {
        this.journalAcronym = journalAcronym;
    }

    /**
     * @return the journalSetupState
     */
    public String getJournalSetupState() {
        return journalSetupState;
    }

    /**
     * @param journalSetupState
     *            the journalSetupState to set
     */
    public void setJournalSetupState(String journalSetupState) {
        this.journalSetupState = journalSetupState;
    }

}
