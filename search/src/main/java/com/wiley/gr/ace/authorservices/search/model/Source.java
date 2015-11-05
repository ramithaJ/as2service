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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Source.
 */
@JsonInclude(Include.NON_NULL)
public class Source {

    /** The journal production editor. */
    @JsonProperty("journal_production_editor")
    private String journalProductionEditor;

    /** The journal publication manager. */
    @JsonProperty("journal_publication_manager")
    private String journalPublicationManager;

    /** The journal ownership status. */
    @JsonProperty("journal_ownership_status")
    private String journalOwnershipStatus;

    /** The journal type. */
    @JsonProperty("journal_type")
    private String journalType;

    /** The journal business unit. */
    @JsonProperty("journal_business_unit")
    private String journalBusinessUnit;

    /** The journal ownership type. */
    @JsonProperty("journal_ownership_type")
    private String journalOwnershipType;

    /** The journal status. */
    @JsonProperty("journal_status")
    private String journalStatus;

    /** The journal title. */
    @JsonProperty("journal_title")
    private String journalTitle;

    /** The journal acronym. */
    @JsonProperty("journal_acronym")
    private String journalAcronym;

    /** The journal setup state. */
    @JsonProperty("journal_setup_state")
    private String journalSetupState;
    
    @JsonProperty("article_journal_title")
    private String articleJournalTitle;
    
    @JsonProperty("article_title")
    private String articleTitle;
    
    @JsonProperty("article_corres_auth_name")
    private String articleCorresAuthName;
    
    @JsonProperty("article_coauth_name")
    private String articleCoauthName;
    
    @JsonProperty("article_journal_elec_issn")
    private String articleJournalElecIssn;
    
    @JsonProperty("article_doi")
    private String articleDoi;

    /**
     * Gets the journal type.
     *
     * @return the journalType
     */
    public String getJournalType() {
        return journalType;
    }

    /**
     * Sets the journal type.
     *
     * @param journalType
     *            the journalType to set
     */
    public void setJournalType(final String journalType) {
        this.journalType = journalType;
    }

    /**
     * Gets the journal ownership type.
     *
     * @return the journalOwnershipType
     */
    public String getJournalOwnershipType() {
        return journalOwnershipType;
    }

    /**
     * Sets the journal ownership type.
     *
     * @param journalOwnershipType
     *            the journalOwnershipType to set
     */
    public void setJournalOwnershipType(final String journalOwnershipType) {
        this.journalOwnershipType = journalOwnershipType;
    }

    /**
     * Gets the journal status.
     *
     * @return the journalStatus
     */
    public String getJournalStatus() {
        return journalStatus;
    }

    /**
     * Sets the journal status.
     *
     * @param journalStatus
     *            the journalStatus to set
     */
    public void setJournalStatus(final String journalStatus) {
        this.journalStatus = journalStatus;
    }

    /**
     * Gets the journal title.
     *
     * @return the journalTitle
     */
    public String getJournalTitle() {
        return journalTitle;
    }

    /**
     * Sets the journal title.
     *
     * @param journalTitle
     *            the journalTitle to set
     */
    public void setJournalTitle(final String journalTitle) {
        this.journalTitle = journalTitle;
    }

    /**
     * Gets the journal acronym.
     *
     * @return the journalAcronym
     */
    public String getJournalAcronym() {
        return journalAcronym;
    }

    /**
     * Sets the journal acronym.
     *
     * @param journalAcronym
     *            the journalAcronym to set
     */
    public void setJournalAcronym(final String journalAcronym) {
        this.journalAcronym = journalAcronym;
    }

    /**
     * Gets the journal setup state.
     *
     * @return the journalSetupState
     */
    public String getJournalSetupState() {
        return journalSetupState;
    }

    /**
     * Sets the journal setup state.
     *
     * @param journalSetupState
     *            the journalSetupState to set
     */
    public void setJournalSetupState(final String journalSetupState) {
        this.journalSetupState = journalSetupState;
    }

    /**
     * Gets the journal production editor.
     *
     * @return the journal production editor
     */
    public final String getJournalProductionEditor() {
        return journalProductionEditor;
    }

    /**
     * Sets the journal production editor.
     *
     * @param journalProductionEditor
     *            the new journal production editor
     */
    public final void setJournalProductionEditor(
            final String journalProductionEditor) {
        this.journalProductionEditor = journalProductionEditor;
    }

    /**
     * Gets the journal publication manager.
     *
     * @return the journal publication manager
     */
    public final String getJournalPublicationManager() {
        return journalPublicationManager;
    }

    /**
     * Sets the journal publication manager.
     *
     * @param journalPublicationManager
     *            the new journal publication manager
     */
    public final void setJournalPublicationManager(
            final String journalPublicationManager) {
        this.journalPublicationManager = journalPublicationManager;
    }

    /**
     * Gets the journal ownership status.
     *
     * @return the journal ownership status
     */
    public final String getJournalOwnershipStatus() {
        return journalOwnershipStatus;
    }

    /**
     * Sets the journal ownership status.
     *
     * @param journalOwnershipStatus
     *            the new journal ownership status
     */
    public final void setJournalOwnershipStatus(
            final String journalOwnershipStatus) {
        this.journalOwnershipStatus = journalOwnershipStatus;
    }

    /**
     * Gets the journal business unit.
     *
     * @return the journal business unit
     */
    public final String getJournalBusinessUnit() {
        return journalBusinessUnit;
    }

    /**
     * Sets the journal business unit.
     *
     * @param journalBusinessUnit
     *            the new journal business unit
     */
    public final void setJournalBusinessUnit(final String journalBusinessUnit) {
        this.journalBusinessUnit = journalBusinessUnit;
    }

	public String getArticleJournalTitle() {
		return articleJournalTitle;
	}

	public void setArticleJournalTitle(String articleJournalTitle) {
		this.articleJournalTitle = articleJournalTitle;
	}

	public String getArticleCorresAuthName() {
		return articleCorresAuthName;
	}

	public void setArticleCorresAuthName(String articleCorresAuthName) {
		this.articleCorresAuthName = articleCorresAuthName;
	}

	public String getArticleCoauthName() {
		return articleCoauthName;
	}

	public void setArticleCoauthName(String articleCoauthName) {
		this.articleCoauthName = articleCoauthName;
	}

	public String getArticleJournalElecIssn() {
		return articleJournalElecIssn;
	}

	public void setArticleJournalElecIssn(String articleJournalElecIssn) {
		this.articleJournalElecIssn = articleJournalElecIssn;
	}

	public String getArticleDoi() {
		return articleDoi;
	}

	public void setArticleDoi(String articleDoi) {
		this.articleDoi = articleDoi;
	}

}
