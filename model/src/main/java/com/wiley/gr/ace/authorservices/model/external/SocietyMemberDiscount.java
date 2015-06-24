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

import java.util.List;

public class SocietyMemberDiscount {

    /**
     * This field holds the value of societies
     */
    private List<Societies> societies;

    /**
     * @return the societies
     */
    public final List<Societies> getSocieties() {
        return societies;
    }

    /**
     * @param societies
     *            the societies to set
     */
    public final void setSocieties(final List<Societies> societies) {
        this.societies = societies;
    }

}
