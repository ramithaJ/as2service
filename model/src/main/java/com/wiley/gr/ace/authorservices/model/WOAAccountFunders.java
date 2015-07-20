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
package com.wiley.gr.ace.authorservices.model;

/**
 * @author virtusa version1.0
 *
 */
public class WOAAccountFunders {

    /**
     * This field holds the value of woaFunderId
     */
    private String woaFunderId;

    /**
     * This field holds the value of woaFunderName
     */
    private String woaFunderName;

    /**
     * This field holds the value of allRestricted
     */
    private boolean allRestricted;

    /**
     * @return the allRestricted
     */
    public final boolean isAllRestricted() {
        return allRestricted;
    }

    /**
     * @param allRestricted
     *            the allRestricted to set
     */
    public final void setAllRestricted(final boolean allRestricted) {
        this.allRestricted = allRestricted;
    }

    /**
     * @return the woaFunderId
     */
    public final String getWoaFunderId() {
        return woaFunderId;
    }

    /**
     * @param woaFunderId
     *            the woaFunderId to set
     */
    public final void setWoaFunderId(final String woaFunderId) {
        this.woaFunderId = woaFunderId;
    }

    /**
     * @return the woaFunderName
     */
    public final String getWoaFunderName() {
        return woaFunderName;
    }

    /**
     * @param woaFunderName
     *            the woaFunderName to set
     */
    public final void setWoaFunderName(final String woaFunderName) {
        this.woaFunderName = woaFunderName;
    }

}
