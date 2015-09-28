/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;

/**
 * The Class Funders.
 */
public class Funders {

    /** The funder. */
    ArrayList<Funder> funder;

    /**
     * Gets the funder.
     *
     * @return the funder
     */
    public final ArrayList<Funder> getFunder() {
        return funder;
    }

    /**
     * Sets the funder.
     *
     * @param funder the new funder
     */
    public final void setFunder(final ArrayList<Funder> funder) {
        this.funder = funder;
    }

}
