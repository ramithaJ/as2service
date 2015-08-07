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
import com.wiley.gr.ace.authorservices.model.LicenseStatus;

/**
 * The Interface LicenseService.
 * 
 * @author virtusa version 1.0
 */
public interface LicenseService {

	/**
	 * Gets the license choice.
	 *
	 * @param dhId
	 *            the dh id
	 * @param licenseObject
	 *            the license object
	 * @return the license choice
	 */
	ArrayList<String> getLicenseChoice(String dhId, LicenseObject licenseObject);

	/**
	 * Gets the license text.
	 *
	 * @param licenseObject
	 *            the license object
	 * @return the license text
	 */
	String getLicenseText(LicenseObject licenseObject);

	/**
	 * Gets the license copy.
	 *
	 * @param dhId
	 *            the dh id
	 * @return the license copy
	 */
	File getLicenseCopy(String dhId);

	/**
	 * Save license later.
	 *
	 * @param licenseObject
	 *            the license object
	 * @param userId
	 *            the user id
	 * @param articleId
	 *            the article id
	 */
	void saveLicenseLater(LicenseObject licenseObject, String userId,
			String articleId);

	/**
	 * Sign license.
	 *
	 * @param licenseObject
	 *            the license object
	 * @param dhId
	 *            the dh id
	 * @return the string
	 */
	String signLicense(LicenseObject licenseObject, String dhId);

	/**
	 * Gets the license status.
	 *
	 * @param dhId the dh id
	 * @param userId the user id
	 * @return the license status
	 */
	LicenseStatus getLicenseStatus(String dhId, String userId);

}
