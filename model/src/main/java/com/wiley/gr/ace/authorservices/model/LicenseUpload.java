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
 * The Class LicenseUpload.
 *
 * @author virtusa version 1.0
 */
public class LicenseUpload {

    /** The license created date. */
    private String licenseCreatedDate;

    /** The license updated date. */
    private String licenseUpdatedDate;

    /**
     * Gets the license created date.
     *
     * @return the license created date
     */
    public final String getLicenseCreatedDate() {
        return licenseCreatedDate;
    }

    /**
     * Sets the license created date.
     *
     * @param licenseCreatedDate
     *            the new license created date
     */
    public final void setLicenseCreatedDate(final String licenseCreatedDate) {
        this.licenseCreatedDate = licenseCreatedDate;
    }

    /**
     * Gets the license updated date.
     *
     * @return the license updated date
     */
    public final String getLicenseUpdatedDate() {
        return licenseUpdatedDate;
    }

    /**
     * Sets the license updated date.
     *
     * @param licenseUpdatedDate
     *            the new license updated date
     */
    public final void setLicenseUpdatedDate(final String licenseUpdatedDate) {
        this.licenseUpdatedDate = licenseUpdatedDate;
    }

}
