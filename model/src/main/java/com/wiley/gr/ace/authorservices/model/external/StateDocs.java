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
 * The Class StateDocs.
 * 
 * @author virtusa version 1.0
 */
public class StateDocs {

    /** The id. */
    private String id;

    /** The _version_. */
    @JsonProperty("_version_")
    private String version;

    /** The IS o_ alph a_3. */
    @JsonProperty("ISO_ALPHA_3")
    private String isoAlpha3;

    /** The IS o_ alph a_2. */
    @JsonProperty("ISO_ALPHA_2")
    private String isoAlpha2;

    /** The doc_type. */
    @JsonProperty("doc_type")
    private String docType;

    /** The subdivision cd. */
    @JsonProperty("SUBDIVISION_CD")
    private String subDivisionCd;

    /** The subdivision name. */
    @JsonProperty("SUBDIVISION_NAME")
    private String subDivisionName;

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
     *            the new id
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
     * Gets the iso alpha3.
     *
     * @return the iso alpha3
     */
    public final String getIsoAlpha3() {
        return isoAlpha3;
    }

    /**
     * Sets the iso alpha3.
     *
     * @param isoAlpha3
     *            the new iso alpha3
     */
    public final void setIsoAlpha3(final String isoAlpha3) {
        this.isoAlpha3 = isoAlpha3;
    }

    /**
     * Gets the iso alpha2.
     *
     * @return the iso alpha2
     */
    public final String getIsoAlpha2() {
        return isoAlpha2;
    }

    /**
     * Sets the iso alpha2.
     *
     * @param isoAlpha2
     *            the new iso alpha2
     */
    public final void setIsoAlpha2(final String isoAlpha2) {
        this.isoAlpha2 = isoAlpha2;
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
     * Gets the sub division cd.
     *
     * @return the sub division cd
     */
    public final String getSubDivisionCd() {
        return subDivisionCd;
    }

    /**
     * Sets the sub division cd.
     *
     * @param subDivisionCd
     *            the new sub division cd
     */
    public final void setSubDivisionCd(final String subDivisionCd) {
        this.subDivisionCd = subDivisionCd;
    }

    /**
     * Gets the sub division name.
     *
     * @return the sub division name
     */
    public final String getSubDivisionName() {
        return subDivisionName;
    }

    /**
     * Sets the sub division name.
     *
     * @param subDivisionName
     *            the new sub division name
     */
    public final void setSubDivisionName(final String subDivisionName) {
        this.subDivisionName = subDivisionName;
    }

}
