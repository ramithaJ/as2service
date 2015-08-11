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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.externalservices.service.ViewLicenseExternalService;
import com.wiley.gr.ace.authorservices.model.external.ViewLicenseAgreementWALSRequest;
import com.wiley.gr.ace.authorservices.services.service.ViewLicenseAgreementService;

public class ViewLicenseAgreementServiceImpl implements ViewLicenseAgreementService{

  

    @Autowired(required = true)
    private ViewLicenseExternalService viewLicenseExternalService;
    
    @Override
    public ResponseEntity<byte[]> getViewLicenseAgreementService(Integer dhId)
            throws Exception {
        ViewLicenseAgreementWALSRequest viewLicenseAgreementWALSRequest = null;

        ResponseEntity<byte[]> response = null;
        viewLicenseAgreementWALSRequest = new ViewLicenseAgreementWALSRequest();

        HttpHeaders headers = new HttpHeaders();
        byte[] contents = null;

        viewLicenseAgreementWALSRequest = new ViewLicenseAgreementWALSRequest();
        viewLicenseAgreementWALSRequest.setRequestType("GET_VIEW_LICENSE_AGREEMENT");
        viewLicenseAgreementWALSRequest.setRequestCreatedTimestamp("2014-12-12 10:12:12");

        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setContentDispositionFormData(
                AuthorServicesConstants.LICENSE_PDF_NAME,
                AuthorServicesConstants.LICENSE_PDF_NAME);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        contents = viewLicenseExternalService
                .getViewLicenseAgreement(viewLicenseAgreementWALSRequest);
        response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);

        return response;
    }


}
