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
 * @author Virtusa version1.0
 *
 */
public class Title {

    /** The title id. */
    private String titleId;

    /** The title name. */
    private String titleName;

    /**
     * @return the titleId
     */
    public final String getTitleId() {
        return titleId;
    }

    /**
     * @param titleId
     *            the titleId to set
     */
    public final void setTitleId(final String titleId) {
        this.titleId = titleId;
    }

    /**
     * @return the titleName
     */
    public final String getTitleName() {
        return titleName;
    }

    /**
     * @param titleName
     *            the titleName to set
     */
    public final void setTitleName(final String titleName) {
        this.titleName = titleName;
    }

}
