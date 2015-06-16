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
 * The Class CountryDocs.
 * 
 * @author virtusa version 1.0
 */
public class CountryDocs {

    /** The id. */
    private String id;

    /** The version. */
    @JsonProperty("_version_")
    private String version;

    /** The isoNumeric3. */
    @JsonProperty("ISO_NUMERIC_3")
    private String isoNumeric3;

    /** The isoAlpha3. */
    @JsonProperty("ISO_ALPHA_3")
    private String isoAlpha3;

    /** The IS isoAlpha2. */
    @JsonProperty("ISO_ALPHA_2")
    private String isoAlpha2;

    /** The docType. */
    @JsonProperty("doc_type")
    private String docType;

    /** The country name. */
    @JsonProperty("COUNTRY_NAME")
    private String countryName;

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
     * Gets the iso numeric3.
     *
     * @return the iso numeric3
     */
    public final String getIsoNumeric3() {
        return isoNumeric3;
    }

    /**
     * Sets the iso numeric3.
     *
     * @param isoNumeric3
     *            the new iso numeric3
     */
    public final void setIsoNumeric3(final String isoNumeric3) {
        this.isoNumeric3 = isoNumeric3;
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
     * Gets the country name.
     *
     * @return the country name
     */
    public final String getCountryName() {
        return countryName;
    }

    /**
     * Sets the country name.
     *
     * @param countryName
     *            the new country name
     */
    public final void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

}
