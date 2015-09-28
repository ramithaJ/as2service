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

/**
 * The Class LicenseTextRequest.
 * 
 * @author virtusa version 1.0
 */
public class LicenseTextRequest extends WALSRequest {

    /** The license type. */
    private String licenseType;

    /** The copyright ownership. */
    private String copyrightOwnership;

    /** The us govt work ownership. */
    private String usGovtWorkOwnership;

    /**
     * Gets the license type.
     *
     * @return the license type
     */
    public final String getLicenseType() {
        return licenseType;
    }

    /**
     * Sets the license type.
     *
     * @param licenseType the new license type
     */
    public final void setLicenseType(final String licenseType) {
        this.licenseType = licenseType;
    }

    /**
     * Gets the copyright ownership.
     *
     * @return the copyright ownership
     */
    public final String getCopyrightOwnership() {
        return copyrightOwnership;
    }

    /**
     * Sets the copyright ownership.
     *
     * @param copyrightOwnership the new copyright ownership
     */
    public final void setCopyrightOwnership(final String copyrightOwnership) {
        this.copyrightOwnership = copyrightOwnership;
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
     * @param usGovtWorkOwnership the new us govt work ownership
     */
    public final void setUsGovtWorkOwnership(final String usGovtWorkOwnership) {
        this.usGovtWorkOwnership = usGovtWorkOwnership;
    }
}
