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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class SocietyList.
 *
 * @author yugandhark
 */
public class SocietyList {

    /** The Society. */
    @JsonProperty("Society")
    private List<Society> Society;

    /**
     * Gets the society.
     *
     * @return the society
     */
    public final List<Society> getSociety() {
        return Society;
    }

    /**
     * Sets the society.
     *
     * @param society the new society
     */
    public final void setSociety(final List<Society> society) {
        Society = society;
    }

}
