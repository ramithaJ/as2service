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
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.ViewLicenseAgreementService;

/**
 * The Class ViewLicenseAgreementController.
 * 
 * * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/v1")
public class ViewLicenseAgreementController {

    /** The view license agreement service. */
    @Autowired(required = true)
    private ViewLicenseAgreementService viewLicenseAgreementService;
    /** logger configured. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ViewLicenseAgreementController.class);

    /** The get view license agreement of article in pdf code. */
    @Value("${ViewLicenseAgreementController.getViewLicenseAgreementOfArticleInPDF.code}")
    private String getViewLicenseAgreementOfArticleInPDFCode;

    /** The get view license agreement of article in pdf message. */
    @Value("${ViewLicenseAgreementController.getViewLicenseAgreementOfArticleInPDF.message}")
    private String getViewLicenseAgreementOfArticleInPDFMessage;

    /** The get view license agreement of article in pdf error code. */
    @Value("${ViewLicenseAgreementController.getViewLicenseAgreementOfArticleInPDFError.code}")
    private String getViewLicenseAgreementOfArticleInPDFErrorCode;

    /** The get view license agreement of article in pdf error message. */
    @Value("${ViewLicenseAgreementController.getViewLicenseAgreementOfArticleInPDFError.message}")
    private String getViewLicenseAgreementOfArticleInPDFErrorMessage;

    /**
     * Gets the view license agreement of article in pdf.
     *
     * @param dhId
     *            the dh id
     * @return the view license agreement of article in pdf
     * @throws Exception
     *             the exception
     */
    @RequestMapping(value = "/license/view/{dhId}", method = RequestMethod.GET)
    public final ResponseEntity<byte[]> getViewLicenseAgreementOfArticleInPDF(
            @PathVariable("dhId") final Integer dhId) throws Exception {
        LOGGER.info("inside getArticleDHIDInPDF method of ViewLicenseAgreementController");
        Service service = new Service();
        ResponseEntity<byte[]> viewLicenseAgreement = null;
        try {

            viewLicenseAgreement = viewLicenseAgreementService
                    .getViewLicenseAgreementService(dhId);
            if (!StringUtils.isEmpty(viewLicenseAgreement)) {
                service.setStatus("SUCCESS");
                service.setPayload(viewLicenseAgreement);
            } else {
                final ErrorPOJO error = new ErrorPOJO();
                error.setCode(getViewLicenseAgreementOfArticleInPDFCode);
                error.setMessage(getViewLicenseAgreementOfArticleInPDFMessage);
                service.setStatus("FAILURE");
                service.setError(error);

            }
        } catch (final Exception e) {
            LOGGER.error("Print Stack Trace- ", e);
            final ErrorPOJO error = new ErrorPOJO();
            error.setCode(getViewLicenseAgreementOfArticleInPDFErrorCode);
            error.setMessage(getViewLicenseAgreementOfArticleInPDFErrorMessage);
            service.setStatus("ERROR");
            service.setError(error);
        }

        return viewLicenseAgreementService.getViewLicenseAgreementService(dhId);
    }

}
