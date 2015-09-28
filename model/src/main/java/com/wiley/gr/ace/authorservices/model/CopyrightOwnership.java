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
package com.wiley.gr.ace.authorservices.model;

/**
 * The Class CopyrightOwnership.
 * 
 * @author virtusa version 1.0
 */
public class CopyrightOwnership {

    /** The ownership type. */
    private String ownershipType;

    /** The us govt work ownership. */
    private String usGovtWorkOwnership;
    private String employmentDesc;

    public final String getEmploymentDesc() {
        return employmentDesc;
    }

    public final void setEmploymentDesc(final String employmentDesc) {
        this.employmentDesc = employmentDesc;
    }

    /**
     * Gets the ownership type.
     *
     * @return the ownership type
     */
    public final String getOwnershipType() {
        return ownershipType;
    }

    /**
     * Sets the ownership type.
     *
     * @param ownershipType
     *            the new ownership type
     */
    public final void setOwnershipType(final String ownershipType) {
        this.ownershipType = ownershipType;
    }

    /**
     * Gets the us govt work ownership.
     *
     * @return the us govt work ownership
     */
    public final String getUsGovtWorkOwnership() {
        return usGovtWorkOwnership;
    }

    /**
     * Sets the us govt work ownership.
     *
     * @param usGovtWorkOwnership
     *            the new us govt work ownership
     */
    public final void setUsGovtWorkOwnership(final String usGovtWorkOwnership) {
        this.usGovtWorkOwnership = usGovtWorkOwnership;
    }

}
