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
package com.wiley.gr.ace.authorservices.services.service;

import java.io.File;
import java.util.ArrayList;

import com.wiley.gr.ace.authorservices.model.LicenseObject;

/**
 * The Interface LicenseService.
 * 
 * @author virtusa version 1.0
 */
public interface LicenseService {

    ArrayList<String> getLicenseChoice(LicenseObject licenseObject);

    File getLicenseCopy(String dhId);

    void saveLicenseLater(LicenseObject licenseObject, String userId,
            String articleId);

    String signLicense(LicenseObject licenseObject, String dhId);

}
