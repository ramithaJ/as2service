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
package com.wiley.gr.ace.authorservices.persistence.services;

import com.wiley.gr.ace.authorservices.persistence.entity.LicenseUploadDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedLicenses;

/**
 * The Interface LicenseDAO.
 * 
 * @author virtusa version 1.0
 */
public interface LicenseDAO {

    /**
     * Save license.
     *
     * @param savedLicenses
     *            the saved licenses
     * @return the integer
     */
    Integer saveLicense(SavedLicenses savedLicenses);

    /**
     * Gets the l license upload details.
     *
     * @param dhId
     *            the dh id
     * @return the l license upload details
     */
    LicenseUploadDetails getlLicenseUploadDetails(String dhId);
}
