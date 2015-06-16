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

/**
 * The Class FundingDetails.
 *
 * @author virtusa version 1.0
 */
public class FundingDetails {

    /** The woa account holder. */
    private String woaAccountHolder;

    /**
     * @return the woaAccountHolder
     */
    public final String getWoaAccountHolder() {
        return woaAccountHolder;
    }

    /**
     * @param woaAccountHolder
     *            the woaAccountHolder to set
     */
    public final void setWoaAccountHolder(final String woaAccountHolder) {
        this.woaAccountHolder = woaAccountHolder;
    }

    /**
     * @return the researchFunder
     */
    public final String getResearchFunder() {
        return researchFunder;
    }

    /**
     * @param researchFunder
     *            the researchFunder to set
     */
    public final void setResearchFunder(final String researchFunder) {
        this.researchFunder = researchFunder;
    }

    /**
     * @return the grantNumber
     */
    public final String getGrantNumber() {
        return grantNumber;
    }

    /**
     * @param grantNumber
     *            the grantNumber to set
     */
    public final void setGrantNumber(final String grantNumber) {
        this.grantNumber = grantNumber;
    }

    /**
     * @return the grantRecipient
     */
    public final String getGrantRecipient() {
        return grantRecipient;
    }

    /**
     * @param grantRecipient
     *            the grantRecipient to set
     */
    public final void setGrantRecipient(final String grantRecipient) {
        this.grantRecipient = grantRecipient;
    }

    /** The research funder. */
    private String researchFunder;

    /** The grant number. */
    private String grantNumber;

    /** The grant recipient. */
    private String grantRecipient;

}
