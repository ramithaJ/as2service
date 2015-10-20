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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class LicenseTypesPresented.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class LicenseTypesPresented {

    /** The license type. */
    private List<String> licenseType;

    public List<String> getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(final List<String> licenseType) {
        this.licenseType = licenseType;
    }

    /**
     * Sets the license type.
     *
     * @param licenseType
     *            the new license type
     */
    public final void setLicenseType(final ArrayList<String> licenseType) {
        this.licenseType = licenseType;
    }

}
