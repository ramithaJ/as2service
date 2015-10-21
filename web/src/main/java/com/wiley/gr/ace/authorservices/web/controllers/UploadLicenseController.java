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
package com.wiley.gr.ace.authorservices.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.UploadLicenseService;

/**
 * The Class UploadLicenseController.
 * 
 * @author virtusa version 1.0
 */
@Controller
@RequestMapping("v1/license/")
public class UploadLicenseController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UploadLicenseController.class);

    /** The upload license service. */
    @Autowired(required = true)
    private UploadLicenseService uploadLicenseService;

    /** The max no files. */
    @Value("${MAX_NO_FILES}")
    private Integer maxNoFiles;

    /** The view license input error. */
    @Value("${UploadLicenseController.viewLicenseInputError}")
    private String viewLicenseInputError;

    /** The view license not found. */
    @Value("${UploadLicenseController.viewLicenseNotFound}")
    private String viewLicenseNotFound;

    /** The view license exception code. */
    @Value("${UploadLicenseController.viewLicenseException.code}")
    private String viewLicenseExceptionCode;

    /** The view license exception message. */
    @Value("${UploadLicenseController.viewLicenseException.message}")
    private String viewLicenseExceptionMessage;

    /** The upload license input error. */
    @Value("${UploadLicenseController.uploadLicenseInputError}")
    private String uploadLicenseInputError;

    /** The upload license not found. */
    @Value("${UploadLicenseController.uploadLicenseNotFound}")
    private String uploadLicenseNotFound;

    /** The upload license exception code. */
    @Value("${UploadLicenseController.uploadLicenseException.code}")
    private String uploadLicenseExceptionCode;

    /** The upload license exception message. */
    @Value("${UploadLicenseController.uploadLicenseExceptionr.message}")
    private String uploadLicenseExceptionMessage;

    /** The constant success. */
    private static final String SUCCESS = "SUCCESS";

    /** The constant failure. */
    private static final String FAILURE = "FAILURE";

    /**
     * View license.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @return the service
     */
    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public final Service viewLicense(@RequestParam("dhId") final String dhId,
            @RequestParam("userId") final String userId) {
        LOGGER.info("Inside viewLicense method of UploadLicenseController");
        Service service = new Service();
        if (!StringUtils.isEmpty(dhId) && !StringUtils.isEmpty(userId)) {
            try {
                String license = uploadLicenseService.viewLicense(dhId, userId);
                if (!StringUtils.isEmpty(license)) {
                    service.setPayload(license);
                    service.setStatus(SUCCESS);
                } else {
                    service.setStatus(FAILURE);
                    service.setPayload(viewLicenseNotFound);
                }
            } catch (Exception e) {
                LOGGER.error("Print Stack Trace- ", e);
                throw new ASException(viewLicenseExceptionCode,
                        viewLicenseExceptionMessage);
            }

        } else {
            service.setStatus(FAILURE);
            service.setPayload(viewLicenseInputError);
        }
        return service;

    }

    /**
     * Upload license.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @param files
     *            the files
     * @return the service
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public final Service uploadLicense(@RequestParam("dhId") final String dhId,
            @RequestParam("userId") final String userId,
            @RequestParam("file") final MultipartFile[] files) {
        LOGGER.info("Inside uploadLicense method of UploadLicenseController");
        Service service = new Service();
        if (!StringUtils.isEmpty(dhId) && !StringUtils.isEmpty(userId)
                && !StringUtils.isEmpty(files) && files.length <= maxNoFiles) {
            boolean isUpdated = false;
            try {
                for (int i = 0; i < files.length; i++) {
                    MultipartFile file = files[i];
                    if (!StringUtils.isEmpty(file)) {
                        isUpdated = uploadLicenseService.uploadLicense(dhId,
                                userId, file);
                        if (!isUpdated) {
                            service.setStatus(FAILURE);
                            service.setPayload(uploadLicenseNotFound);
                        }
                    }
                    service.setStatus(SUCCESS);
                }

            } catch (Exception e) {
                LOGGER.error("Print Stack Trace- ", e);
                throw new ASException(uploadLicenseExceptionCode,
                        uploadLicenseExceptionMessage);
            }

        } else {
            service.setStatus(FAILURE);
            service.setPayload(uploadLicenseInputError);
        }
        return service;
    }
}
