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

import com.wiley.gr.ace.authorservices.externalservices.service.LicenseInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceRequest;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceResponse;
import com.wiley.gr.ace.authorservices.model.external.LicenseTextRequest;
import com.wiley.gr.ace.authorservices.model.external.SignLicenseRequest;
import com.wiley.gr.ace.authorservices.model.external.WALSRequest;
import com.wiley.gr.ace.authorservices.model.external.WALSResponse;

/**
 * The Class LicenseInterfaceServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class LicenseInterfaceServiceImpl implements LicenseInterfaceService {

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * LicenseInterfaceService
     * #getLicenseChoice(com.wiley.gr.ace.authorservices.model
     * .external.LicenseChoiceRequest)
     */
    @Override
    public LicenseChoiceResponse getLicenseChoice(
            final LicenseChoiceRequest licenseChoiceRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * LicenseInterfaceService
     * #getLicenseText(com.wiley.gr.ace.authorservices.model
     * .external.LicenseTextRequest)
     */
    @Override
    public WALSResponse getLicenseText(final LicenseTextRequest licenseTextRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * LicenseInterfaceService
     * #signLicense(com.wiley.gr.ace.authorservices.model.
     * external.SignLicenseRequest)
     */
    @Override
    public WALSResponse signLicense(final SignLicenseRequest signLicenseRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * LicenseInterfaceService
     * #getLicenseCopy(com.wiley.gr.ace.authorservices.model
     * .external.WALSRequest)
     */
    @Override
    public WALSResponse getLicenseCopy(final WALSRequest walsRequest) {
        // TODO Auto-generated method stub
        return null;
    }

}
