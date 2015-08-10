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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class LicenseDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class LicenseDetails {

    
    private String name;
    /** The license status. */
    private String licenseStatus;
    private String selectedLicenceType;

    /** The license signed date. */
    private String licenseSignedDate;

    /**
     * Gets the license signed date.
     *
     * @return the license signed date
     */
    public final String getLicenseSignedDate() {
        return licenseSignedDate;
    }

    /**
     * Sets the license signed date.
     *
     * @param licenseSignedDate
     *            the new license signed date
     */
    public final void setLicenseSignedDate(final String licenseSignedDate) {
        this.licenseSignedDate = licenseSignedDate;
    }

    /**
     * Gets the license status.
     *
     * @return the license status
     */
    public final String getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * Sets the license status.
     *
     * @param licenseStatus
     *            the new license status
     */
    public final void setLicenseStatus(final String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getSelectedLicenceType() {
        return selectedLicenceType;
    }

    public final void setSelectedLicenceType(final String selectedLicenceType) {
        this.selectedLicenceType = selectedLicenceType;
    }
}
