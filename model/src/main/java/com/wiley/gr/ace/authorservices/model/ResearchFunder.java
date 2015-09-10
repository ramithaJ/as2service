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
package com.wiley.gr.ace.authorservices.model;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ResearchFunder.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ResearchFunder implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The research funder id. */
    @NotNull
    @NotBlank
    private String researchFunderId;

    /** The research funder name. */
    @NotNull
    @NotBlank
    private String researchFunderName;

    @NotBlank
    @NotNull
    /** The article aid. */
    private String articleAID;

    @NotBlank
    @NotNull
    /** The article name. */
    private String articleName;

    @NotBlank
    @NotNull
    /** The grant number. */
    private Set<String> grantNumber;

    /**
     * Gets the research funder id.
     *
     * @return the researchFunderId
     */
    public final String getResearchFunderId() {
        return researchFunderId;
    }

    /**
     * Sets the research funder id.
     *
     * @param researchFunderId
     *            the researchFunderId to set
     */
    public final void setResearchFunderId(final String researchFunderId) {
        this.researchFunderId = researchFunderId;
    }

    /**
     * Gets the research funder name.
     *
     * @return the researchFunderName
     */
    public final String getResearchFunderName() {
        return researchFunderName;
    }

    /**
     * Sets the research funder name.
     *
     * @param researchFunderName
     *            the researchFunderName to set
     */
    public final void setResearchFunderName(final String researchFunderName) {
        this.researchFunderName = researchFunderName;
    }

    /**
     * Gets the article aid.
     *
     * @return the articleAID
     */
    public final String getArticleAID() {
        return articleAID;
    }

    /**
     * Sets the article aid.
     *
     * @param articleAID
     *            the articleAID to set
     */
    public final void setArticleAID(final String articleAID) {
        this.articleAID = articleAID;
    }

    /**
     * Gets the article name.
     *
     * @return the articleName
     */
    public final String getArticleName() {
        return articleName;
    }

    /**
     * Sets the article name.
     *
     * @param articleName
     *            the articleName to set
     */
    public final void setArticleName(final String articleName) {
        this.articleName = articleName;
    }

    /**
     * Gets the grant number.
     *
     * @return the grantNumber
     */
    public final Set<String> getGrantNumber() {
        return grantNumber;
    }

    /**
     * Sets the grant number.
     *
     * @param grantNumber
     *            the grantNumber to set
     */
    public final void setGrantNumber(final Set<String> grantNumber) {
        this.grantNumber = grantNumber;
    }

}
