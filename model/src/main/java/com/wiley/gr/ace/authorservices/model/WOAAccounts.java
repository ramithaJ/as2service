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
     * This field holds the value of code
     */
    private String code;

    /**
     * This field holds the value of name
     */
    private String name;

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
     * @return the code
     */
    public final String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public final void setCode(final String code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

}
