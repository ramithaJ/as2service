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

/**
 * The Class LastSignedLicense.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class LastSignedLicense {

    /** The wiley oa account holder. */
    private String wileyOAAccountHolder;

    /** The license types presented. */
    private LicenseTypesPresented licenseTypesPresented;

    /** The license sub type signed. */
    private String licenseSubTypeSigned;

    /** The us govt work ownership. */
    private String usGovtWorkOwnership;

    /** The copyright ownership type. */
    private String copyrightOwnershipType;

    /** The signed electronically. */
    private String signedElectronically;

    /** The license class signed. */
    private String licenseClassSigned;

    /** The license type signed. */
    private String licenseTypeSigned;

    /** The author selected online open. */
    private String authorSelectedOnlineOpen;

    /** The license sign date. */
    private String licenseSignDate;

    /** The template name. */
    private String templateName;

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
     * Gets the license types presented.
     *
     * @return the license types presented
     */
    public final LicenseTypesPresented getLicenseTypesPresented() {
        return licenseTypesPresented;
    }

    /**
     * Sets the license types presented.
     *
     * @param licenseTypesPresented
     *            the new license types presented
     */
    public final void setLicenseTypesPresented(
            final LicenseTypesPresented licenseTypesPresented) {
        this.licenseTypesPresented = licenseTypesPresented;
    }

    /**
     * Gets the license sub type signed.
     *
     * @return the license sub type signed
     */
    public final String getLicenseSubTypeSigned() {
        return licenseSubTypeSigned;
    }

    /**
     * Sets the license sub type signed.
     *
     * @param licenseSubTypeSigned
     *            the new license sub type signed
     */
    public final void setLicenseSubTypeSigned(final String licenseSubTypeSigned) {
        this.licenseSubTypeSigned = licenseSubTypeSigned;
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
     * Gets the license class signed.
     *
     * @return the license class signed
     */
    public final String getLicenseClassSigned() {
        return licenseClassSigned;
    }

    /**
     * Sets the license class signed.
     *
     * @param licenseClassSigned
     *            the new license class signed
     */
    public final void setLicenseClassSigned(final String licenseClassSigned) {
        this.licenseClassSigned = licenseClassSigned;
    }

    /**
     * Gets the license type signed.
     *
     * @return the license type signed
     */
    public final String getLicenseTypeSigned() {
        return licenseTypeSigned;
    }

    /**
     * Sets the license type signed.
     *
     * @param licenseTypeSigned
     *            the new license type signed
     */
    public final void setLicenseTypeSigned(final String licenseTypeSigned) {
        this.licenseTypeSigned = licenseTypeSigned;
    }

    /**
     * Gets the author selected online open.
     *
     * @return the author selected online open
     */
    public final String getAuthorSelectedOnlineOpen() {
        return authorSelectedOnlineOpen;
    }

    /**
     * Sets the author selected online open.
     *
     * @param authorSelectedOnlineOpen
     *            the new author selected online open
     */
    public final void setAuthorSelectedOnlineOpen(
            final String authorSelectedOnlineOpen) {
        this.authorSelectedOnlineOpen = authorSelectedOnlineOpen;
    }

    /**
     * Gets the license sign date.
     *
     * @return the license sign date
     */
    public final String getLicenseSignDate() {
        return licenseSignDate;
    }

    /**
     * Sets the license sign date.
     *
     * @param licenseSignDate
     *            the new license sign date
     */
    public final void setLicenseSignDate(final String licenseSignDate) {
        this.licenseSignDate = licenseSignDate;
    }

    /**
     * Gets the template name.
     *
     * @return the template name
     */
    public final String getTemplateName() {
        return templateName;
    }

    /**
     * Sets the template name.
     *
     * @param templateName
     *            the new template name
     */
    public final void setTemplateName(final String templateName) {
        this.templateName = templateName;
    }
}
