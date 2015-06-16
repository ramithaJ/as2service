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
public class ResearchFunder {

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
     * Gets the research funder id.
     *
     * @return the research funder id
     */
    public Integer getResearchFunderId() {
        return researchFunderId;
    }

    /**
     * Sets the research funder id.
     *
     * @param researchFunderId
     *            the new research funder id
     */
    public void setResearchFunderId(Integer researchFunderId) {
        this.researchFunderId = researchFunderId;
    }

    /**
     * Gets the research funder name.
     *
     * @return the research funder name
     */
    public String getResearchFunderName() {
        return researchFunderName;
    }

    /**
     * Sets the research funder name.
     *
     * @param researchFunderName
     *            the new research funder name
     */
    public void setResearchFunderName(String researchFunderName) {
        this.researchFunderName = researchFunderName;
    }

    /**
     * Gets the article aid.
     *
     * @return the article aid
     */
    public String getArticleAID() {
        return articleAID;
    }

    /**
     * Sets the article aid.
     *
     * @param articleAID
     *            the new article aid
     */
    public void setArticleAID(String articleAID) {
        this.articleAID = articleAID;
    }

    /**
     * Gets the article name.
     *
     * @return the article name
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * Sets the article name.
     *
     * @param articleName
     *            the new article name
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    /**
     * Gets the grant number.
     *
     * @return the grant number
     */
    public Set<String> getGrantNumber() {
        return grantNumber;
    }

    /**
     * Sets the grant number.
     *
     * @param grantNumber
     *            the new grant number
     */
    public void setGrantNumber(Set<String> grantNumber) {
        this.grantNumber = grantNumber;
    }

}
