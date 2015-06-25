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

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** The research funder id. */
    @NotNull
    @NotBlank
    private Integer researchFunderId;

    /** The research funder name. */
    @NotNull
    @NotBlank
    private String researchFunderName;

    /** The article aid. */
    private String articleAID;

    /** The article name. */
    private String articleName;

    /** The grant number. */
    private Set<String> grantNumber;

    /**
     * @return the researchFunderId
     */
    public final Integer getResearchFunderId() {
        return researchFunderId;
    }

    /**
     * @param researchFunderId
     *            the researchFunderId to set
     */
    public final void setResearchFunderId(final Integer researchFunderId) {
        this.researchFunderId = researchFunderId;
    }

    /**
     * @return the researchFunderName
     */
    public final String getResearchFunderName() {
        return researchFunderName;
    }

    /**
     * @param researchFunderName
     *            the researchFunderName to set
     */
    public final void setResearchFunderName(final String researchFunderName) {
        this.researchFunderName = researchFunderName;
    }

    /**
     * @return the articleAID
     */
    public final String getArticleAID() {
        return articleAID;
    }

    /**
     * @param articleAID
     *            the articleAID to set
     */
    public final void setArticleAID(final String articleAID) {
        this.articleAID = articleAID;
    }

    /**
     * @return the articleName
     */
    public final String getArticleName() {
        return articleName;
    }

    /**
     * @param articleName
     *            the articleName to set
     */
    public final void setArticleName(final String articleName) {
        this.articleName = articleName;
    }

    /**
     * @return the grantNumber
     */
    public final Set<String> getGrantNumber() {
        return grantNumber;
    }

    /**
     * @param grantNumber
     *            the grantNumber to set
     */
    public final void setGrantNumber(final Set<String> grantNumber) {
        this.grantNumber = grantNumber;
    }

}
