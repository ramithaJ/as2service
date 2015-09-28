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
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class IndustryDocs.
 *
 * @author virtusa version 1.0
 */
public class IndustryDocs {

    /** The id. */
    private String id;

    /** The version. */
    @JsonProperty("_version_")
    private String version;

    /** The naics code. */
    @JsonProperty("NAICS_CODE")
    private String naicsCode;

    /** The doc_type. */
    @JsonProperty("doc_type")
    private String docType;

    /** The naics title. */
    @JsonProperty("NAICS_TITLE")
    private String naicsTitle;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the id to set
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public final String getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the new version
     */
    public final void setVersion(final String version) {
        this.version = version;
    }

    /**
     * Gets the naics code.
     *
     * @return the naics code
     */
    public final String getNaicsCode() {
        return naicsCode;
    }

    /**
     * Sets the naics code.
     *
     * @param naicsCode
     *            the new naics code
     */
    public final void setNaicsCode(final String naicsCode) {
        this.naicsCode = naicsCode;
    }

    /**
     * Gets the doc type.
     *
     * @return the doc type
     */
    public final String getDocType() {
        return docType;
    }

    /**
     * Sets the doc type.
     *
     * @param docType
     *            the new doc type
     */
    public final void setDocType(final String docType) {
        this.docType = docType;
    }

    /**
     * Gets the naics title.
     *
     * @return the naics title
     */
    public final String getNaicsTitle() {
        return naicsTitle;
    }

    /**
     * Sets the naics title.
     *
     * @param naicsTitle
     *            the new naics title
     */
    public final void setNaicsTitle(final String naicsTitle) {
        this.naicsTitle = naicsTitle;
    }

}
