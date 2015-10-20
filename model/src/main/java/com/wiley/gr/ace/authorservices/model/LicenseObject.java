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
package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class LicenseObject.
 * 
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class LicenseObject {

    /** The licence id. */
    private String licenceId;

    /** The funder details. */
    private List<FunderDetails> funderDetailsList;

    /** The copyright ownership. */
    private CopyrightOwnership copyrightOwnership;

    /** The online open. */
    private String onlineOpen;

    /** The license type. */
    private String licenseType;

    /** The author signature. */
    private String authorSignature;

    /** The signed electronically. */
    private String signedElectronically;

    /** The license type presented. */
    private List<String> licenseTypePresented;

    /** The signed date. */
    private String signedDate;

    /** The prices. */
    private List<Prices> prices;

    /** The license_ o o_ oa. */
    @JsonProperty("license_OO_OA")
    private String licenseOoOa;

    /** The license format. */
    private String licenseFormat;

    /**
     * @return the licenceId
     */
    public String getLicenceId() {
        return licenceId;
    }

    /**
     * @param licenceId
     *            the licenceId to set
     */
    public void setLicenceId(String licenceId) {
        this.licenceId = licenceId;
    }

    /**
     * @return the funderDetailsList
     */
    public List<FunderDetails> getFunderDetailsList() {
        return funderDetailsList;
    }

    /**
     * @param funderDetailsList
     *            the funderDetailsList to set
     */
    public void setFunderDetailsList(List<FunderDetails> funderDetailsList) {
        this.funderDetailsList = funderDetailsList;
    }

    /**
     * @return the copyrightOwnership
     */
    public CopyrightOwnership getCopyrightOwnership() {
        return copyrightOwnership;
    }

    /**
     * @param copyrightOwnership
     *            the copyrightOwnership to set
     */
    public void setCopyrightOwnership(CopyrightOwnership copyrightOwnership) {
        this.copyrightOwnership = copyrightOwnership;
    }

    /**
     * @return the onlineOpen
     */
    public String getOnlineOpen() {
        return onlineOpen;
    }

    /**
     * @param onlineOpen
     *            the onlineOpen to set
     */
    public void setOnlineOpen(String onlineOpen) {
        this.onlineOpen = onlineOpen;
    }

    /**
     * @return the licenseType
     */
    public String getLicenseType() {
        return licenseType;
    }

    /**
     * @param licenseType
     *            the licenseType to set
     */
    public void setLicenseType(String licenseType) {
        this.licenseType = licenseType;
    }

    /**
     * @return the authorSignature
     */
    public String getAuthorSignature() {
        return authorSignature;
    }

    /**
     * @param authorSignature
     *            the authorSignature to set
     */
    public void setAuthorSignature(String authorSignature) {
        this.authorSignature = authorSignature;
    }

    /**
     * @return the signedElectronically
     */
    public String getSignedElectronically() {
        return signedElectronically;
    }

    /**
     * @param signedElectronically
     *            the signedElectronically to set
     */
    public void setSignedElectronically(String signedElectronically) {
        this.signedElectronically = signedElectronically;
    }

    /**
     * @return the licenseTypePresented
     */
    public List<String> getLicenseTypePresented() {
        return licenseTypePresented;
    }

    /**
     * @param licenseTypePresented
     *            the licenseTypePresented to set
     */
    public void setLicenseTypePresented(List<String> licenseTypePresented) {
        this.licenseTypePresented = licenseTypePresented;
    }

    /**
     * @return the signedDate
     */
    public String getSignedDate() {
        return signedDate;
    }

    /**
     * @param signedDate
     *            the signedDate to set
     */
    public void setSignedDate(String signedDate) {
        this.signedDate = signedDate;
    }

    /**
     * @return the prices
     */
    public List<Prices> getPrices() {
        return prices;
    }

    /**
     * @param prices
     *            the prices to set
     */
    public void setPrices(List<Prices> prices) {
        this.prices = prices;
    }

    /**
     * @return the licenseOoOa
     */
    public String getLicenseOoOa() {
        return licenseOoOa;
    }

    /**
     * @param licenseOoOa
     *            the licenseOoOa to set
     */
    public void setLicenseOoOa(String licenseOoOa) {
        this.licenseOoOa = licenseOoOa;
    }

    /**
     * @return the licenseFormat
     */
    public String getLicenseFormat() {
        return licenseFormat;
    }

    /**
     * @param licenseFormat
     *            the licenseFormat to set
     */
    public void setLicenseFormat(String licenseFormat) {
        this.licenseFormat = licenseFormat;
    }

}
