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
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class LastDownloadedLicense.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class LastDownloadedLicense {

    /** The wiley oa account holder. */
    @JsonProperty("wileyOAAccountHolder")
    private String wileyOAAccountHolder;

    /** The license types presented. */
    @JsonProperty("licenseTypesPresented")
    private LicenseTypesPresented licTypesPresented;

    /** The license sub type signed. */
    @JsonProperty("licenseSubTypeSigned")
    private String licSubTypeSigned;

    /** The us govt work ownership. */
    @JsonProperty("usGovtWorkOwnership")
    private String usGovtWorkOwnership;

    /** The copyright ownership type. */
    @JsonProperty("copyrightOwnershipType")
    private String copyrightOwnershipType;

    /** The signed electronically. */
    @JsonProperty("signedElectronically")
    private String signedElectronic;

    /** The license class signed. */
    @JsonProperty("licenseClassSigned")
    private String licClassSigned;

    /** The license type signed. */
    @JsonProperty("licenseTypeSigned")
    private String licTypeSigned;

    /** The author selected online open. */
    @JsonProperty("authorSelectedOnlineOpen")
    private String authorSelectedOO;

    /** The license sign date. */
    @JsonProperty("licenseSignDate")
    private String licSignDate;

    /** The template name. */
    @JsonProperty("templateName")
    private String tName;

    /**
     * Gets the wiley oa account holder.
     *
     * @return the wiley oa account holder
     */
    public final String getWileyOAAccountHolder() {
        return wileyOAAccountHolder;
    }

    /**
     * Sets the wiley oa account holder.
     *
     * @param wileyOAAccountHolder
     *            the new wiley oa account holder
     */
    public final void setWileyOAAccountHolder(final String wileyOAAccountHolder) {
        this.wileyOAAccountHolder = wileyOAAccountHolder;
    }

    /**
     * Gets the lic types presented.
     *
     * @return the lic types presented
     */
    public final LicenseTypesPresented getLicTypesPresented() {
        return licTypesPresented;
    }

    /**
     * Sets the lic types presented.
     *
     * @param licTypesPresented
     *            the new lic types presented
     */
    public final void setLicTypesPresented(
            final LicenseTypesPresented licTypesPresented) {
        this.licTypesPresented = licTypesPresented;
    }

    /**
     * Gets the lic sub type signed.
     *
     * @return the lic sub type signed
     */
    public final String getLicSubTypeSigned() {
        return licSubTypeSigned;
    }

    /**
     * Sets the lic sub type signed.
     *
     * @param licSubTypeSigned
     *            the new lic sub type signed
     */
    public final void setLicSubTypeSigned(final String licSubTypeSigned) {
        this.licSubTypeSigned = licSubTypeSigned;
    }

    /**
     * Gets the us govt work ownership.
     *
     * @return the us govt work ownership
     */
    public final String getUsGovtWorkOwnership() {
        return usGovtWorkOwnership;
    }

    /**
     * Sets the us govt work ownership.
     *
     * @param usGovtWorkOwnership
     *            the new us govt work ownership
     */
    public final void setUsGovtWorkOwnership(final String usGovtWorkOwnership) {
        this.usGovtWorkOwnership = usGovtWorkOwnership;
    }

    /**
     * Gets the copyright ownership type.
     *
     * @return the copyright ownership type
     */
    public final String getCopyrightOwnershipType() {
        return copyrightOwnershipType;
    }

    /**
     * Sets the copyright ownership type.
     *
     * @param copyrightOwnershipType
     *            the new copyright ownership type
     */
    public final void setCopyrightOwnershipType(
            final String copyrightOwnershipType) {
        this.copyrightOwnershipType = copyrightOwnershipType;
    }

    /**
     * Gets the signed electronic.
     *
     * @return the signed electronic
     */
    public final String getSignedElectronic() {
        return signedElectronic;
    }

    /**
     * Sets the signed electronic.
     *
     * @param signedElectronic
     *            the new signed electronic
     */
    public final void setSignedElectronic(final String signedElectronic) {
        this.signedElectronic = signedElectronic;
    }

    /**
     * Gets the lic class signed.
     *
     * @return the lic class signed
     */
    public final String getLicClassSigned() {
        return licClassSigned;
    }

    /**
     * Sets the lic class signed.
     *
     * @param licClassSigned
     *            the new lic class signed
     */
    public final void setLicClassSigned(final String licClassSigned) {
        this.licClassSigned = licClassSigned;
    }

    /**
     * Gets the lic type signed.
     *
     * @return the lic type signed
     */
    public final String getLicTypeSigned() {
        return licTypeSigned;
    }

    /**
     * Sets the lic type signed.
     *
     * @param licTypeSigned
     *            the new lic type signed
     */
    public final void setLicTypeSigned(final String licTypeSigned) {
        this.licTypeSigned = licTypeSigned;
    }

    /**
     * Gets the author selected oo.
     *
     * @return the author selected oo
     */
    public final String getAuthorSelectedOO() {
        return authorSelectedOO;
    }

    /**
     * Sets the author selected oo.
     *
     * @param authorSelectedOO
     *            the new author selected oo
     */
    public final void setAuthorSelectedOO(final String authorSelectedOO) {
        this.authorSelectedOO = authorSelectedOO;
    }

    /**
     * Gets the lic sign date.
     *
     * @return the lic sign date
     */
    public final String getLicSignDate() {
        return licSignDate;
    }

    /**
     * Sets the lic sign date.
     *
     * @param licSignDate
     *            the new lic sign date
     */
    public final void setLicSignDate(final String licSignDate) {
        this.licSignDate = licSignDate;
    }

    /**
     * Gets the t name.
     *
     * @return the t name
     */
    public final String gettName() {
        return tName;
    }

    /**
     * Sets the t name.
     *
     * @param tName
     *            the new t name
     */
    public final void settName(final String tName) {
        this.tName = tName;
    }

}
