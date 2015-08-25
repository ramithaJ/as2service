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

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class SocietyList.
 *
 * @author yugandhark
 */
public class SocietyList implements Serializable {

    /**
     * This field holds the value of serialVersionUID.
     */
    private static final long serialVersionUID = 1L;
    /** The Society. */
    @JsonProperty("Society")
    private List<SocietyData> society;

    /**
     * @return the society
     */
    public final List<SocietyData> getSociety() {
        return society;
    }

    /**
     * @param society
     *            the society to set
     */
    public final void setSociety(final List<SocietyData> society) {
        this.society = society;
    }

}
