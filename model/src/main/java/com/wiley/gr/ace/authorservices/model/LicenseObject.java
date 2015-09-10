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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
    private ArrayList<FunderDetails> funderDetailsList;

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
    private ArrayList<String> licenseTypePresented;

    /** The signed date. */
    private String signedDate;

    /** The prices. */
    private List<Prices> prices;

    /** The license_ o o_ oa. */
    private String license_OO_OA;
    
    /** The license format. */
    private String licenseFormat;



    /**
     * Gets the funder details list.
     *
     * @return the funder details list
     */
    public final ArrayList<FunderDetails> getFunderDetailsList() {
        return funderDetailsList;
    }

    /**
     * Sets the funder details list.
     *
     * @param funderDetailsList the new funder details list
     */
    public final void setFunderDetailsList(
            final ArrayList<FunderDetails> funderDetailsList) {
        this.funderDetailsList = funderDetailsList;
    }

    /**
     * Gets the copyright ownership.
     *
     * @return the copyright ownership
     */
    public final CopyrightOwnership getCopyrightOwnership() {
        return copyrightOwnership;
    }

    /**
     * Sets the copyright ownership.
     *
     * @param copyrightOwnership
     *            the new copyright ownership
     */
    public final void setCopyrightOwnership(
            final CopyrightOwnership copyrightOwnership) {
        this.copyrightOwnership = copyrightOwnership;
    }

    /**
     * Gets the online open.
     *
     * @return the online open
     */
    public final String getOnlineOpen() {
        return onlineOpen;
    }

    /**
     * Sets the online open.
     *
     * @param onlineOpen
     *            the new online open
     */
    public final void setOnlineOpen(final String onlineOpen) {
        this.onlineOpen = onlineOpen;
    }

    /**
     * Gets the license type.
     *
     * @return the license type
     */
    public final String getLicenseType() {
        return licenseType;
    }

    /**
     * Sets the license type.
     *
     * @param licenseType
     *            the new license type
     */
    public final void setLicenseType(final String licenseType) {
        this.licenseType = licenseType;
    }

    /**
     * Gets the author signature.
     *
     * @return the author signature
     */
    public final String getAuthorSignature() {
        return authorSignature;
    }

    /**
     * Sets the author signature.
     *
     * @param authorSignature
     *            the new author signature
     */
    public final void setAuthorSignature(final String authorSignature) {
        this.authorSignature = authorSignature;
    }

    /**
     * Gets the signed electronically.
     *
     * @return the signed electronically
     */
    public final String getSignedElectronically() {
        return signedElectronically;
    }

    /**
     * Sets the signed electronically.
     *
     * @param signedElectronically
     *            the new signed electronically
     */
    public final void setSignedElectronically(final String signedElectronically) {
        this.signedElectronically = signedElectronically;
    }

    /**
     * Gets the license type presented.
     *
     * @return the license type presented
     */
    public final ArrayList<String> getLicenseTypePresented() {
        return licenseTypePresented;
    }

    /**
     * Sets the license type presented.
     *
     * @param licenseTypePresented
     *            the new license type presented
     */
    public final void setLicenseTypePresented(
            final ArrayList<String> licenseTypePresented) {
        this.licenseTypePresented = licenseTypePresented;
    }

    /**
     * Gets the licence id.
     *
     * @return the licence id
     */
    public final String getLicenceId() {
        return licenceId;
    }


    /**
     * Sets the licence id.
     *
     * @param licenceId the new licence id
     */
    public final void setLicenceId(final String licenceId) {
        this.licenceId = licenceId;
    }


    /**
     * Gets the signed date.
     *
     * @return the signed date
     */
    public final String getSignedDate() {
        return signedDate;
    }

    /**
     * Sets the signed date.
     *
     * @param signedDate the new signed date
     */
    public final void setSignedDate(final String signedDate) {
        this.signedDate = signedDate;
    }

    /**
     * Gets the prices.
     *
     * @return the prices
     */
    public List<Prices> getPrices() {
        return prices;
    }

    /**
     * Sets the prices.
     *
     * @param prices the new prices
     */
    public void setPrices(final List<Prices> prices) {
        this.prices = prices;
    }

    /**
     * Gets the license_ o o_ oa.
     *
     * @return the license_ o o_ oa
     */
    public String getLicense_OO_OA() {
        return license_OO_OA;
    }

    /**
     * Sets the license_ o o_ oa.
     *
     * @param license_OO_OA the new license_ o o_ oa
     */
    public void setLicense_OO_OA(final String license_OO_OA) {
        this.license_OO_OA = license_OO_OA;
    }

	/**
	 * Gets the license format.
	 *
	 * @return the license format
	 */
	public String getLicenseFormat() {
		return licenseFormat;
	}

	/**
	 * Sets the license format.
	 *
	 * @param licenseFormat the new license format
	 */
	public void setLicenseFormat(String licenseFormat) {
		this.licenseFormat = licenseFormat;
	}


}
