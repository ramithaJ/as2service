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
 * The Class GetArticleDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class GetArticleDetails {

    /** The last downloaded license. */
    private LastDownloadedLicense lastDownloadedLicense;

    /** The last signed license. */
    private LastSignedLicense lastSignedLicense;

    /** The art. */
    private Art art;

    /**
     * Gets the last downloaded license.
     *
     * @return the last downloaded license
     */
    public final LastDownloadedLicense getLastDownloadedLicense() {
        return lastDownloadedLicense;
    }

    /**
     * Sets the last downloaded license.
     *
     * @param lastDownloadedLicense
     *            the new last downloaded license
     */
    public final void setLastDownloadedLicense(
            final LastDownloadedLicense lastDownloadedLicense) {
        this.lastDownloadedLicense = lastDownloadedLicense;
    }

    /**
     * Gets the last signed license.
     *
     * @return the last signed license
     */
    public final LastSignedLicense getLastSignedLicense() {
        return lastSignedLicense;
    }

    /**
     * Sets the last signed license.
     *
     * @param lastSignedLicense
     *            the new last signed license
     */
    public final void setLastSignedLicense(
            final LastSignedLicense lastSignedLicense) {
        this.lastSignedLicense = lastSignedLicense;
    }

    /**
     * Gets the art.
     *
     * @return the art
     */
    public final Art getArt() {
        return art;
    }

    /**
     * Sets the art.
     *
     * @param art
     *            the new art
     */
    public final void setArt(final Art art) {
        this.art = art;
    }
}
