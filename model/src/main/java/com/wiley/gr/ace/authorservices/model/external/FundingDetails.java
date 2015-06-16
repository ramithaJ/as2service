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

    /** The research funder. */
    private String researchFunder;

    /** The grant number. */
    private String grantNumber;

    /** The grant recipient. */
    private String grantRecipient;

    /**
     * Gets the woa account holder.
     *
     * @return the woa account holder
     */
    public String getWoaAccountHolder() {
        return woaAccountHolder;
    }

    /**
     * Sets the woa account holder.
     *
     * @param woaAccountHolder
     *            the new woa account holder
     */
    public void setWoaAccountHolder(String woaAccountHolder) {
        this.woaAccountHolder = woaAccountHolder;
    }

    /**
     * Gets the research funder.
     *
     * @return the research funder
     */
    public String getResearchFunder() {
        return researchFunder;
    }

    /**
     * Sets the research funder.
     *
     * @param researchFunder
     *            the new research funder
     */
    public void setResearchFunder(String researchFunder) {
        this.researchFunder = researchFunder;
    }

    /**
     * Gets the grant number.
     *
     * @return the grant number
     */
    public String getGrantNumber() {
        return grantNumber;
    }

    /**
     * Sets the grant number.
     *
     * @param grantNumber
     *            the new grant number
     */
    public void setGrantNumber(String grantNumber) {
        this.grantNumber = grantNumber;
    }

    /**
     * Gets the grant recipient.
     *
     * @return the grant recipient
     */
    public String getGrantRecipient() {
        return grantRecipient;
    }

    /**
     * Sets the grant recipient.
     *
     * @param grantRecipient
     *            the new grant recipient
     */
    public void setGrantRecipient(String grantRecipient) {
        this.grantRecipient = grantRecipient;
    }

}
