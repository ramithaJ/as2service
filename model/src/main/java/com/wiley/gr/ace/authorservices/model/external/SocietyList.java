/*** ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * ******************************************************************************/

package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class SocietyList.
 * 
 * @author virtusa version 1.0
 */
public class SocietyList {

    /** The society. */
    private SocietyElement[] society;

    /**
     * Gets the society.
     *
     * @return the society
     */
    public final SocietyElement[] getSociety() {
        return society;
    }

    /**
     * Sets the society.
     *
     * @param society
     *            the society to set
     */
    public final void setSociety(final SocietyElement[] society) {
        this.society = society;
    }
}
