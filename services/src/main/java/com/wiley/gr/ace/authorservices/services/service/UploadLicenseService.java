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
package com.wiley.gr.ace.authorservices.services.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * The Interface UploadLicenseService.
 * 
 * @author virtusa version 1.0
 */
public interface UploadLicenseService {

    /**
     * View license.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @return the string
     */
    String viewLicense(String dhId, String userId);

    /**
     * Upload license.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @param file
     *            the file
     * @return true, if successful
     */
    boolean uploadLicense(String dhId, String userId, MultipartFile file);
}
