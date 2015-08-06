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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.LicenseInterfaceService;
import com.wiley.gr.ace.authorservices.model.LicenseObject;
import com.wiley.gr.ace.authorservices.model.external.Funder;
import com.wiley.gr.ace.authorservices.model.external.Funders;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceRequest;
import com.wiley.gr.ace.authorservices.services.service.LicenseService;

/**
 * The Class LicenseServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class LicenseServiceImpl implements LicenseService {

    @Autowired(required = true)
    private LicenseInterfaceService licenseInterfaceService;

    /**
     * Gets the license choice.
     *
     * @param licenseObject
     *            the license object
     * @return the license choice
     */
    @Override
    public ArrayList<String> getLicenseChoice(String dhId,
            LicenseObject licenseObject) {

        LicenseChoiceRequest licenseChoiceRequest = new LicenseChoiceRequest();
        Funders funders = new Funders();
        ArrayList<Funder> funderList = new ArrayList<Funder>();

        licenseChoiceRequest.setDhId(dhId);
        
        
        funderList.add(licenseObject.getFunderDetails().getFunderInfo()
                .getFunder()); // null
        funderList.add(licenseObject.getFunderDetails().getFunderInfo()
                .getAssociateFunder()); // Null
        funders.setFunder(funderList);
        licenseChoiceRequest.setFunders(funders);
        licenseChoiceRequest.setOnlineOpen(licenseObject.getOnlineOpen());
        return licenseInterfaceService.getLicenseChoice(licenseChoiceRequest)
                .getLicenseTypes().getLicenseType();
    }

    /**
     * Gets the license copy.
     *
     * @param dhId
     *            the dh id
     * @return the license copy
     */
    @Override
    public File getLicenseCopy(String dhId) {
        // TODO Auto-generated method stub
        return null;
    }

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
    @Override
    public void saveLicenseLater(LicenseObject licenseObject, String userId,
            String articleId) {
        // TODO Auto-generated method stub

    }

    /**
     * Sign license.
     *
     * @param licenseObject
     *            the license object
     * @param dhId
     *            the dh id
     * @return the string
     */
    @Override
    public String signLicense(LicenseObject licenseObject, String dhId) {
        // TODO Auto-generated method stub
        return null;
    }

}
