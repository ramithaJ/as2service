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
package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.external.License;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceRequest;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceResponse;
import com.wiley.gr.ace.authorservices.model.external.LicenseTextRequest;
import com.wiley.gr.ace.authorservices.model.external.SignLicenseRequest;
import com.wiley.gr.ace.authorservices.model.external.WALSRequest;
import com.wiley.gr.ace.authorservices.model.external.WALSResponse;

/**
 * The Interface LicenseInterfaceService.
 * 
 * @author virtusa version 1.0
 */
public interface LicenseInterfaceService {

    /**
     * Gets the license choice.
     *
     * @param licenseChoiceRequest
     *            the license choice request
     * @return the license choice
     */
    LicenseChoiceResponse getLicenseChoice(
            LicenseChoiceRequest licenseChoiceRequest);

    /**
     * Gets the license text.
     *
     * @param licenseTextRequest
     *            the license text request
     * @return the license text
     */
    WALSResponse getLicenseText(LicenseTextRequest licenseTextRequest);

    /**
     * Sign license.
     *
     * @param signLicenseRequest
     *            the sign license request
     * @return the WALS response
     */
    WALSResponse signLicense(SignLicenseRequest signLicenseRequest);

    /**
     * Gets the license copy.
     *
     * @param walsRequest
     *            the wals request
     * @return the license copy
     */
    WALSResponse getLicenseCopy(WALSRequest walsRequest);
    
    License initiateLicence(String articleId);
    
}
