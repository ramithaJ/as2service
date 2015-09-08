/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatesResponse {

    @JsonProperty("SUBDIVISION_NAME")
    private String sUBDIVISION_NAME;

    @JsonProperty("ISO_ALPHA_2")
    private String iSOALPHA2;

    @JsonProperty("ISO_ALPHA_3")
    private String iSOALPHA3;

    @JsonProperty("doc_type")
    private String docType;

    @JsonProperty("SUBDIVISION_CD")
    private String sUBDIVISIONCD;

    private String id;

    @JsonProperty("_version_")
    private String version;

    /**
     * @return the sUBDIVISION_NAME
     */
    public final String getsUBDIVISION_NAME() {
        return sUBDIVISION_NAME;
    }

    /**
     * @param sUBDIVISION_NAME
     *            the sUBDIVISION_NAME to set
     */
    public final void setsUBDIVISION_NAME(final String sUBDIVISION_NAME) {
        this.sUBDIVISION_NAME = sUBDIVISION_NAME;
    }

    /**
     * @return the iSOALPHA2
     */
    public final String getiSOALPHA2() {
        return iSOALPHA2;
    }

    /**
     * @param iSOALPHA2
     *            the iSOALPHA2 to set
     */
    public final void setiSOALPHA2(final String iSOALPHA2) {
        this.iSOALPHA2 = iSOALPHA2;
    }

    /**
     * @return the iSOALPHA3
     */
    public final String getiSOALPHA3() {
        return iSOALPHA3;
    }

    /**
     * @param iSOALPHA3
     *            the iSOALPHA3 to set
     */
    public final void setiSOALPHA3(final String iSOALPHA3) {
        this.iSOALPHA3 = iSOALPHA3;
    }

    /**
     * @return the docType
     */
    public final String getDocType() {
        return docType;
    }

    /**
     * @param docType
     *            the docType to set
     */
    public final void setDocType(final String docType) {
        this.docType = docType;
    }

    /**
     * @return the sUBDIVISIONCD
     */
    public final String getsUBDIVISIONCD() {
        return sUBDIVISIONCD;
    }

    /**
     * @param sUBDIVISIONCD
     *            the sUBDIVISIONCD to set
     */
    public final void setsUBDIVISIONCD(final String sUBDIVISIONCD) {
        this.sUBDIVISIONCD = sUBDIVISIONCD;
    }

    /**
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * @return the version
     */
    public final String getVersion() {
        return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public final void setVersion(final String version) {
        this.version = version;
    }

}
