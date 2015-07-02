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
 * @author virtusa version1.0
 *
 */
public class SubFunders {

    /**
     * This field holds the value of funderId
     */
    private String funderId;

    /**
     * This field holds the value of funderName
     */
    private String funderName;

    /**
     * @return the funderId
     */
    public final String getFunderId() {
        return funderId;
    }

    /**
     * @param funderId
     *            the funderId to set
     */
    public final void setFunderId(final String funderId) {
        this.funderId = funderId;
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
