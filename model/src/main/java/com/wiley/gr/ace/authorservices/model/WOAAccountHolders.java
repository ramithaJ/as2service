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

import java.util.List;

/**
 * @author virtusa version1.0
 *
 */
public class WOAAccountHolders {

    /**
     * This field holds the value of woaFunders
     */
    private List<WOAAccountFunders> woaFunders;

    /**
     * @return the woaFunders
     */
    public final List<WOAAccountFunders> getWoaFunders() {
        return woaFunders;
    }

    /**
     * @param woaFunders
     *            the woaFunders to set
     */
    public final void setWoaFunders(final List<WOAAccountFunders> woaFunders) {
        this.woaFunders = woaFunders;
    }

}
