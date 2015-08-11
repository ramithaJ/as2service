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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ViewLicenseExternalService;
import com.wiley.gr.ace.authorservices.model.external.WALSRequest;

public class ViewLicenseExternalServiceImpl implements ViewLicenseExternalService {

    @Value("${getViewLicenseAgreement.url}")
    private String viewLicenseAgreementUrl;
    @Override
    public byte[] getViewLicenseAgreement(
            WALSRequest viewLicenseAgreementWALSRequest) {
       
        return (byte[]) StubInvokerUtil.getFile(viewLicenseAgreementUrl,
                viewLicenseAgreementWALSRequest, byte[].class);
    }
    
}
