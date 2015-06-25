/*
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 */

package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class FunderDetails.
 */
@JsonInclude(Include.NON_NULL)
public class FunderDetails {

    /** The woa account id. */
    private String woaAccountId;

    /** The funder id. */
    private String funderId = "";

    /** The research funder id. */
    private String researchFunderId = "";

    /** The grants. */
    private List<Grants> grants;

    /**
     * Gets the woa account id.
     *
     * @return the woa account id
     */
    public final String getWoaAccountId() {
        return woaAccountId;
    }

    /**
     * Sets the woa account id.
     *
     * @param woaAccountId
     *            the new woa account id
     */
    public final void setWoaAccountId(final String woaAccountId) {
        this.woaAccountId = woaAccountId;
    }

    /**
     * Gets the funder id.
     *
     * @return the funder id
     */
    public final String getFunderId() {
        return funderId;
    }

    /**
     * Sets the funder id.
     *
     * @param funderId
     *            the new funder id
     */
    public final void setFunderId(final String funderId) {
        this.funderId = funderId;
    }

    /**
     * Gets the research funder id.
     *
     * @return the research funder id
     */
    public final String getResearchFunderId() {
        return researchFunderId;
    }

    /**
     * Sets the research funder id.
     *
     * @param researchFunderId
     *            the new research funder id
     */
    public final void setResearchFunderId(final String researchFunderId) {
        this.researchFunderId = researchFunderId;
    }

    /**
     * Gets the grants.
     *
     * @return the grants
     */
    public final List<Grants> getGrants() {
        return grants;
    }

    /**
     * Sets the grants.
     *
     * @param grants
     *            the new grants
     */
    public final void setGrants(final List<Grants> grants) {
        this.grants = grants;
    }

}
