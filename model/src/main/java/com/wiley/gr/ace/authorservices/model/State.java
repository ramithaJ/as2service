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
public class State {

    /** The state code. */
    private String stateCode;

    /** The state name. */
    private String stateName;

    /**
     * @return the stateCode
     */
    public final String getStateCode() {
        return stateCode;
    }

    /**
     * @param stateCode
     *            the stateCode to set
     */
    public final void setStateCode(final String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * @return the stateName
     */
    public final String getStateName() {
        return stateName;
    }

    /**
     * @param stateName
     *            the stateName to set
     */
    public final void setStateName(final String stateName) {
        this.stateName = stateName;
    }

}
