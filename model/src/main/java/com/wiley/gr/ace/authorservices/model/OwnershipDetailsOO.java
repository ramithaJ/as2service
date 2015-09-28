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

/**
 * The Class OwnershipDetailsOO.
 */
public class OwnershipDetailsOO {
    
    /** The ownership type. */
    private String ownershipType;

    /** The employment desc. */
    private String employmentDesc;

    /**
     * Gets the ownership type.
     *
     * @return the ownership type
     */
    public String getOwnershipType ()
    {
        return ownershipType;
    }

    /**
     * Sets the ownership type.
     *
     * @param ownershipType the new ownership type
     */
    public void setOwnershipType (final String ownershipType)
    {
        this.ownershipType = ownershipType;
    }

    /**
     * Gets the employment desc.
     *
     * @return the employment desc
     */
    public String getEmploymentDesc ()
    {
        return employmentDesc;
    }

    /**
     * Sets the employment desc.
     *
     * @param employmentDesc the new employment desc
     */
    public void setEmploymentDesc (final String employmentDesc)
    {
        this.employmentDesc = employmentDesc;
    }

}



