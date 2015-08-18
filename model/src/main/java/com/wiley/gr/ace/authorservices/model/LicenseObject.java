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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class LicenseObject.
 * 
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class LicenseObject {

    /** The licence id. */
    private String licenceId;
    
    /** The journal id. */
    private String journalId;
        
    /** The user id. */
    private String userId;
    
    /** The request id. */
    private String requestId;
    
    /**
     * Gets the request id.
     *
     * @return the request id
     */
    public final String getRequestId() {
        return requestId;
    }

    /**
     * Sets the request id.
     *
     * @param requestId the new request id
     */
    public final void setRequestId(final String requestId) {
        this.requestId = requestId;
    }

    /** The funder details. */
    private LicenseFunderDetails funderDetails;

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

    /**
     * Gets the funder details.
     *
     * @return the funder details
     */
    public final LicenseFunderDetails getFunderDetails() {
        return funderDetails;
    }

    /**
     * Sets the funder details.
     *
     * @param funderDetails
     *            the new funder details
     */
    public final void setFunderDetails(final LicenseFunderDetails funderDetails) {
        this.funderDetails = funderDetails;
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
     * Gets the journal id.
     *
     * @return the journal id
     */
    public final String getJournalId() {
        return journalId;
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
     * Sets the journal id.
     *
     * @param journalId the new journal id
     */
    public final void setJournalId(final String journalId) {
        this.journalId = journalId;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

  
}
