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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wiley.gr.ace.authorservices.model.external.LastDownloadedLicense;
import com.wiley.gr.ace.authorservices.model.external.LastSignedLicense;

/**
 * The Class TrackLicenseDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class TrackLicenseDetails {

    /** The license status. */
    private LicenseStatus licenseStatus;

    /** The last signed license. */
    private LastSignedLicense lastSignedLicense;

    /** The last downloaded license. */
    private LastDownloadedLicense lastDownloadedLicense;

    /** The license upload. */
    private LicenseUpload licenseUpload;

    /**
     * Gets the license status.
     *
     * @return the license status
     */
    public final LicenseStatus getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * Sets the license status.
     *
     * @param licenseStatus
     *            the new license status
     */
    public final void setLicenseStatus(final LicenseStatus licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    /**
     * Gets the last signed license.
     *
     * @return the last signed license
     */
    public final LastSignedLicense getLastSignedLicense() {
        return lastSignedLicense;
    }

    /**
     * Sets the last signed license.
     *
     * @param lastSignedLicense
     *            the new last signed license
     */
    public final void setLastSignedLicense(
            final LastSignedLicense lastSignedLicense) {
        this.lastSignedLicense = lastSignedLicense;
    }

    /**
     * Gets the last downloaded license.
     *
     * @return the last downloaded license
     */
    public final LastDownloadedLicense getLastDownloadedLicense() {
        return lastDownloadedLicense;
    }

    /**
     * Sets the last downloaded license.
     *
     * @param lastDownloadedLicense
     *            the new last downloaded license
     */
    public final void setLastDownloadedLicense(
            final LastDownloadedLicense lastDownloadedLicense) {
        this.lastDownloadedLicense = lastDownloadedLicense;
    }

    /**
     * Gets the license upload.
     *
     * @return the license upload
     */
    public final LicenseUpload getLicenseUpload() {
        return licenseUpload;
    }

    /**
     * Sets the license upload.
     *
     * @param licenseUpload
     *            the new license upload
     */
    public final void setLicenseUpload(final LicenseUpload licenseUpload) {
        this.licenseUpload = licenseUpload;
    }
}
