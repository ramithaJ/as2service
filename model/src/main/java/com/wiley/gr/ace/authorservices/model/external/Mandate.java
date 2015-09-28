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

package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class Mandate.
 */
public class Mandate {
    
    /** The start. */
    private String start;

    /** The name. */
    private String name;

    /** The embargo days. */
    private String embargoDays;

    /** The end. */
    private String end;

    /**
     * Gets the start.
     *
     * @return the start
     */
    public final String getStart() {
        return start;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Gets the embargo days.
     *
     * @return the embargo days
     */
    public final String getEmbargoDays() {
        return embargoDays;
    }

    /**
     * Gets the end.
     *
     * @return the end
     */
    public final String getEnd() {
        return end;
    }

    /**
     * Sets the start.
     *
     * @param start the new start
     */
    public final void setStart(final String start) {
        this.start = start;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Sets the embargo days.
     *
     * @param embargoDays the new embargo days
     */
    public final void setEmbargoDays(final String embargoDays) {
        this.embargoDays = embargoDays;
    }

    /**
     * Sets the end.
     *
     * @param end the new end
     */
    public final void setEnd(final String end) {
        this.end = end;
    }

}



