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


/**
 * The Class SignLicenseRequest.
 * 
 * @author virtusa version 1.0
 */
public class SignLicenseRequest extends WALSRequest {

    /** The license type signed. */
    private String licenseTypeSigned;

    /** The signed electronically. */
    private String signedElectronically;

    /** The author signature. */
    private String authorSignature;

    /** The copyright ownership. */
    private String copyrightOwnership;

    /** The us govt work ownership. */
    private String usGovtWorkOwnership;

    /** The online open. */
    private String onlineOpen;

    /** The license types presented. */
    private LicenseTypesPresented licenseTypesPresented;

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
     * @param licenseTypeSigned the new license type signed
     */
    public final void setLicenseTypeSigned(final String licenseTypeSigned) {
        this.licenseTypeSigned = licenseTypeSigned;
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
     * @param signedElectronically the new signed electronically
     */
    public final void setSignedElectronically(final String signedElectronically) {
        this.signedElectronically = signedElectronically;
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
     * @param authorSignature the new author signature
     */
    public final void setAuthorSignature(final String authorSignature) {
        this.authorSignature = authorSignature;
    }

    /**
     * Gets the copyright ownership.
     *
     * @return the copyright ownership
     */
    public final String getCopyrightOwnership() {
        return copyrightOwnership;
    }

    /**
     * Sets the copyright ownership.
     *
     * @param copyrightOwnership the new copyright ownership
     */
    public final void setCopyrightOwnership(final String copyrightOwnership) {
        this.copyrightOwnership = copyrightOwnership;
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
     * @param usGovtWorkOwnership the new us govt work ownership
     */
    public final void setUsGovtWorkOwnership(final String usGovtWorkOwnership) {
        this.usGovtWorkOwnership = usGovtWorkOwnership;
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
     * @param onlineOpen the new online open
     */
    public final void setOnlineOpen(final String onlineOpen) {
        this.onlineOpen = onlineOpen;
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
     * @param licenseTypesPresented the new license types presented
     */
    public final void setLicenseTypesPresented(
            final LicenseTypesPresented licenseTypesPresented) {
        this.licenseTypesPresented = licenseTypesPresented;
    }

}
