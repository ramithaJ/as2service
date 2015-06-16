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

/**
 * The Class CountryDocs.
 */
public class CountryDocs {

    /** The id. */
    private String id;

    /** The _version_. */
    private String _version_;

    /** The IS o_ numeri c_3. */
    private String ISO_NUMERIC_3;

    /** The IS o_ alph a_3. */
    private String ISO_ALPHA_3;

    /** The IS o_ alph a_2. */
    private String ISO_ALPHA_2;

    /** The doc_type. */
    private String doc_type;

    /** The country name. */
    private String COUNTRY_NAME;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the _version_.
     *
     * @return the _version_
     */
    public String get_version_() {
        return _version_;
    }

    /**
     * Sets the _version_.
     *
     * @param _version_
     *            the new _version_
     */
    public void set_version_(String _version_) {
        this._version_ = _version_;
    }

    /**
     * Gets the checks if is o_ numeri c_3.
     *
     * @return the checks if is o_ numeri c_3
     */
    public String getISO_NUMERIC_3() {
        return ISO_NUMERIC_3;
    }

    /**
     * Sets the checks if is o_ numeri c_3.
     *
     * @param ISO_NUMERIC_3
     *            the new checks if is o_ numeri c_3
     */
    public void setISO_NUMERIC_3(String ISO_NUMERIC_3) {
        this.ISO_NUMERIC_3 = ISO_NUMERIC_3;
    }

    /**
     * Gets the checks if is o_ alph a_3.
     *
     * @return the checks if is o_ alph a_3
     */
    public String getISO_ALPHA_3() {
        return ISO_ALPHA_3;
    }

    /**
     * Sets the checks if is o_ alph a_3.
     *
     * @param ISO_ALPHA_3
     *            the new checks if is o_ alph a_3
     */
    public void setISO_ALPHA_3(String ISO_ALPHA_3) {
        this.ISO_ALPHA_3 = ISO_ALPHA_3;
    }

    /**
     * Gets the checks if is o_ alph a_2.
     *
     * @return the checks if is o_ alph a_2
     */
    public String getISO_ALPHA_2() {
        return ISO_ALPHA_2;
    }

    /**
     * Sets the checks if is o_ alph a_2.
     *
     * @param ISO_ALPHA_2
     *            the new checks if is o_ alph a_2
     */
    public void setISO_ALPHA_2(String ISO_ALPHA_2) {
        this.ISO_ALPHA_2 = ISO_ALPHA_2;
    }

    /**
     * Gets the doc_type.
     *
     * @return the doc_type
     */
    public String getDoc_type() {
        return doc_type;
    }

    /**
     * Sets the doc_type.
     *
     * @param doc_type
     *            the new doc_type
     */
    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    /**
     * Gets the country name.
     *
     * @return the country name
     */
    public String getCOUNTRY_NAME() {
        return COUNTRY_NAME;
    }

    /**
     * Sets the country name.
     *
     * @param COUNTRY_NAME
     *            the new country name
     */
    public void setCOUNTRY_NAME(String COUNTRY_NAME) {
        this.COUNTRY_NAME = COUNTRY_NAME;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", _version_ = " + _version_
                + ", ISO_NUMERIC_3 = " + ISO_NUMERIC_3 + ", ISO_ALPHA_3 = "
                + ISO_ALPHA_3 + ", ISO_ALPHA_2 = " + ISO_ALPHA_2
                + ", doc_type = " + doc_type + ", COUNTRY_NAME = "
                + COUNTRY_NAME + "]";
    }
}
