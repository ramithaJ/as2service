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
package com.wiley.gr.ace.authorservices.services.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.wiley.gr.ace.authorservices.persistence.services.UploadLicenseDAO;
import com.wiley.gr.ace.authorservices.services.service.UploadLicenseService;

/**
 * The Class UploadLicenseServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class UploadLicenseServiceImpl implements UploadLicenseService {

    /** The upload license dao. */
    @Autowired(required = true)
    private UploadLicenseDAO uploadLicenseDAO;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UploadLicenseServiceImpl.class);

    /**
     * View license.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @return the string
     */
    @Override
    public final String viewLicense(final String dhId, final String userId) {
        LOGGER.info("Inside viewLicense method of UploadLicenseServiceImpl");
        return uploadLicenseDAO.viewLicense(dhId, userId);
    }

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
    @Override
    public final boolean uploadLicense(final String dhId, final String userId,
            final MultipartFile file)  {
        LOGGER.info("Inside uploadLicense method of UploadLicenseServiceImpl");
        return uploadLicenseDAO.uploadLicense(dhId, userId, file);
    }

}
