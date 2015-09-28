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

import com.fasterxml.jackson.annotation.JsonProperty;

public class WileyOpenAccessFunders {

    /**
     * This field holds the value of WOAFunders
     */
    @JsonProperty("WOAFunders")
    private WOAFunders woaFunders;

    /**
     * @return the woaFunders
     */
    public final WOAFunders getWoaFunders() {
        return woaFunders;
    }

    /**
     * @param woaFunders
     *            the woaFunders to set
     */
    public final void setWoaFunders(final WOAFunders woaFunders) {
        this.woaFunders = woaFunders;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "WileyOpenAccessFunders [woaFunders=" + woaFunders + "]";
    }

}
