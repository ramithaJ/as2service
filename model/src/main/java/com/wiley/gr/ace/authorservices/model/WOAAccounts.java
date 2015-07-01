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
public class WOAAccounts {

    /**
     * This field holds the value of woaAccountId
     */
    private String woaAccountId;

    /**
     * This field holds the value of woaAccountName
     */
    private String woaAccountName;

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
     * @return the woaAccountId
     */
    public final String getWoaAccountId() {
        return woaAccountId;
    }

    /**
     * @param woaAccountId
     *            the woaAccountId to set
     */
    public final void setWoaAccountId(final String woaAccountId) {
        this.woaAccountId = woaAccountId;
    }

    /**
     * @return the woaAccountName
     */
    public final String getWoaAccountName() {
        return woaAccountName;
    }

    /**
     * @param woaAccountName
     *            the woaAccountName to set
     */
    public final void setWoaAccountName(final String woaAccountName) {
        this.woaAccountName = woaAccountName;
    }

}
