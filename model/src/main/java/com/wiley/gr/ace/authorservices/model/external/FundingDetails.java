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

import java.util.List;

import com.wiley.gr.ace.authorservices.model.Grants;

/**
 * The Class FundingDetails.
 *
 * @author virtusa version 1.0
 */
public class FundingDetails {

    /** The woa account id. */
    private String woaAccountId;

    /** The funder id. */
    private String funderId;

    /** The research funder id. */
    private String researchFunderId;

    /** The grants. */
    private List<Grants> grants;

    public final String getWoaAccountId() {
        return woaAccountId;
    }

    public final void setWoaAccountId(String woaAccountId) {
        this.woaAccountId = woaAccountId;
    }

    public final String getFunderId() {
        return funderId;
    }

    public final void setFunderId(String funderId) {
        this.funderId = funderId;
    }

    public final String getResearchFunderId() {
        return researchFunderId;
    }

    public final void setResearchFunderId(String researchFunderId) {
        this.researchFunderId = researchFunderId;
    }

    public final List<Grants> getGrants() {
        return grants;
    }

    public final void setGrants(List<Grants> grants) {
        this.grants = grants;
    }

}
