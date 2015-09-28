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
public class FundingOrganizations {

    /**
     * This field holds the value of funderRefId
     */
    private String funderRefId;

    /**
     * This field holds the value of funderName
     */
    private String funderName;

    /**
     * @return the funderRefId
     */
    public final String getFunderRefId() {
        return funderRefId;
    }

    /**
     * @param funderRefId
     *            the funderRefId to set
     */
    public final void setFunderRefId(final String funderRefId) {
        this.funderRefId = funderRefId;
    }

    /**
     * @return the funderName
     */
    public final String getFunderName() {
        return funderName;
    }

    /**
     * @param funderName
     *            the funderName to set
     */
    public final void setFunderName(final String funderName) {
        this.funderName = funderName;
    }

}
