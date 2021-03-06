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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.LicenseInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.GetArticleDetails;
import com.wiley.gr.ace.authorservices.model.external.License;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceRequest;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceResponse;
import com.wiley.gr.ace.authorservices.model.external.LicenseTextRequest;
import com.wiley.gr.ace.authorservices.model.external.SignLicenseRequest;
import com.wiley.gr.ace.authorservices.model.external.ViewLicenseAgreement;
import com.wiley.gr.ace.authorservices.model.external.WALSRequest;
import com.wiley.gr.ace.authorservices.model.external.WALSResponse;

/**
 * The Class LicenseInterfaceServiceImpl.
 * 
 * @author virtusa version 1.0
 */

public class LicenseInterfaceServiceImpl implements LicenseInterfaceService {

    @Value("${initiateLicence.url}")
    private String initiateLicenceUrl;

    @Value("${walsArticleDetails.url}")
    private String walsArticleDetails;

    @Value("${viewLicenseAgreement.url}")
    private String viewLicenseAgreementUrl;

    /**
     * Gets the license choice.
     *
     * @param licenseChoiceRequest
     *            the license choice request
     * @return the license choice
     */
    @Override
    public LicenseChoiceResponse getLicenseChoice(
            final LicenseChoiceRequest licenseChoiceRequest) {
        return (LicenseChoiceResponse) StubInvokerUtil.restServiceInvoker("",
                licenseChoiceRequest, LicenseChoiceResponse.class);
    }

    /**
     * Gets the license text.
     *
     * @param licenseTextRequest
     *            the license text request
     * @return the license text
     */
    @Override
    public WALSResponse getLicenseText(
            final LicenseTextRequest licenseTextRequest) {
        return (WALSResponse) StubInvokerUtil.restServiceInvoker("",
                licenseTextRequest, WALSResponse.class);
    }

    /**
     * Sign license.
     *
     * @param signLicenseRequest
     *            the sign license request
     * @return the WALS response
     */
    @Override
    public WALSResponse signLicense(final SignLicenseRequest signLicenseRequest) {
        return (WALSResponse) StubInvokerUtil.restServiceInvoker("",
                signLicenseRequest, WALSResponse.class);
    }

    /**
     * Gets the license copy.
     *
     * @param walsRequest
     *            the wals request
     * @return the license copy
     */
    @Override
    public WALSResponse getLicenseCopy(final WALSRequest walsRequest) {
        return (WALSResponse) StubInvokerUtil.restServiceInvoker("",
                walsRequest, WALSResponse.class);
    }

    @Override
    public License initiateLicence(final String articleId) {

        String url = initiateLicenceUrl + articleId;

        return (License) StubInvokerUtil.restGetServiceInvoker(url,
                License.class);

    }

    /**
     * Gets the wals article details.
     *
     * @param articleId
     *            the article id
     * @return the wals article details
     */

    @Override
    public GetArticleDetails getWalsArticleDetails(String articleId) {
        return (GetArticleDetails) StubInvokerUtil.invokeStub(
                walsArticleDetails, HttpMethod.GET, GetArticleDetails.class);
    }

    @Override
    public byte[] viewLicenseAgreement(
            ViewLicenseAgreement viewLicenseAgreement) {

        return (byte[]) StubInvokerUtil.getFile(viewLicenseAgreementUrl,
                viewLicenseAgreement, byte[].class);
    }
}
