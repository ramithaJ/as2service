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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.rowset.serial.SerialClob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.exception.LicenseException;
import com.wiley.gr.ace.authorservices.externalservices.service.LicenseInterfaceService;
import com.wiley.gr.ace.authorservices.model.LicenseObject;
import com.wiley.gr.ace.authorservices.model.LicenseStatus;
import com.wiley.gr.ace.authorservices.model.external.Funder;
import com.wiley.gr.ace.authorservices.model.external.Funders;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceRequest;
import com.wiley.gr.ace.authorservices.model.external.LicenseTypesPresented;
import com.wiley.gr.ace.authorservices.model.external.SignLicenseRequest;
import com.wiley.gr.ace.authorservices.persistence.entity.Products;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedLicenses;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.LicenseDAO;
import com.wiley.gr.ace.authorservices.services.service.LicenseService;

/**
 * The Class LicenseServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class LicenseServiceImpl implements LicenseService {

    @Autowired(required = true)
    private LicenseInterfaceService licenseInterfaceService;

    @Autowired(required = true)
    private LicenseDAO licenseDAO;

    /**
     * Gets the license choice.
     *
     * @param dhId
     *            the dh id
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

        funderList.add(licenseObject.getFunderDetails().getFunder()); // null
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
     * @return the integer
     */
    @Override
    public Integer saveLicenseLater(LicenseObject licenseObject, String userId,
            String articleId) {
        SavedLicenses savedLicenses = new SavedLicenses();
        Integer licenseId = null;
        try {
            String licenseObjectAsString = new ObjectMapper().writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(licenseObject);

            if (!StringUtils.isEmpty(licenseObjectAsString)) {
                savedLicenses.setLicenseObject(new SerialClob(
                        licenseObjectAsString.toCharArray()));
            }

            Users users = new Users();
            Products products = new Products();
            users.setUserId(Integer.parseInt(userId));
            products.setDhId(Integer.parseInt(articleId));

            savedLicenses.setProducts(products);
            savedLicenses.setUsersByUserId(users);
            savedLicenses.setCreatedDate(new Date());

            licenseId = licenseDAO.saveLicense(savedLicenses);

        } catch (JsonProcessingException | SQLException e) {
            throw new LicenseException("ERROR_SAVING_LICENSE",
                    "error saving the license");
        }
        return licenseId;

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
        SignLicenseRequest signLicenseRequest = new SignLicenseRequest();
        LicenseTypesPresented licenseTypesPresented = new LicenseTypesPresented();
        signLicenseRequest.setDhId(dhId);
        signLicenseRequest.setAuthorSignature(licenseObject
                .getAuthorSignature());
        signLicenseRequest.setCopyrightOwnership(licenseObject
                .getCopyrightOwnership().getOwnershipType());
        signLicenseRequest.setLicenseTypeSigned(licenseObject.getLicenseType());
        licenseTypesPresented.setLicenseType(licenseObject
                .getLicenseTypePresented());
        signLicenseRequest.setLicenseTypesPresented(licenseTypesPresented);
        signLicenseRequest.setOnlineOpen(licenseObject.getOnlineOpen());
        signLicenseRequest.setSignedElectronically(licenseObject
                .getSignedElectronically());
        signLicenseRequest.setUsGovtWorkOwnership(licenseObject
                .getCopyrightOwnership().getUsGovtWorkOwnership());

        return licenseInterfaceService.signLicense(signLicenseRequest)
                .getResponseDescription();
    }

    @Override
    public String getLicenseText(LicenseObject licenseObject) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * License status.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the userId
     * @return the LicenseStatus
     */
    @Override
    public LicenseStatus getLicenseStatus(String dhId, String userId) {
        return null;
    }
}
