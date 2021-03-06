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
package com.wiley.gr.ace.authorservices.model;

import java.util.Set;

/**
 * The Class Ownerships.
 * 
 * * @author virtusa version 1.0
 */
public class Ownerships {

    /** The name. */
    private String name;

    /** The sub ownerships. */
    private Set<SubOwnerships> subOwnerships;

    /** The code. */
    private String code;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the code.
     *
     * @return the code
     */
    public final String getCode() {
        return code;
    }

    /**
     * Sets the code.
     *
     * @param code
     *            the new code
     */
    public final void setCode(final String code) {
        this.code = code;
    }

    /**
     * Gets the sub ownerships.
     *
     * @return the sub ownerships
     */
    public final Set<SubOwnerships> getSubOwnerships() {
        return subOwnerships;
    }

    /**
     * Sets the sub ownerships.
     *
     * @param subOwnerships
     *            the new sub ownerships
     */
    public final void setSubOwnerships(final Set<SubOwnerships> subOwnerships) {
        this.subOwnerships = subOwnerships;
    }

}
