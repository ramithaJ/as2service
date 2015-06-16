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
 * The Class StateDocs.
 */
public class StateDocs {

    /** The id. */
    private String id;

    /** The _version_. */
    private String _version_;

    /** The IS o_ alph a_3. */
    private String ISO_ALPHA_3;

    /** The IS o_ alph a_2. */
    private String ISO_ALPHA_2;

    /** The doc_type. */
    private String doc_type;

    /** The subdivision cd. */
    private String SUBDIVISION_CD;

    /** The subdivision name. */
    private String SUBDIVISION_NAME;

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
     * Gets the subdivision cd.
     *
     * @return the subdivision cd
     */
    public String getSUBDIVISION_CD() {
        return SUBDIVISION_CD;
    }

    /**
     * Sets the subdivision cd.
     *
     * @param SUBDIVISION_CD
     *            the new subdivision cd
     */
    public void setSUBDIVISION_CD(String SUBDIVISION_CD) {
        this.SUBDIVISION_CD = SUBDIVISION_CD;
    }

    /**
     * Gets the subdivision name.
     *
     * @return the subdivision name
     */
    public String getSUBDIVISION_NAME() {
        return SUBDIVISION_NAME;
    }

    /**
     * Sets the subdivision name.
     *
     * @param SUBDIVISION_NAME
     *            the new subdivision name
     */
    public void setSUBDIVISION_NAME(String SUBDIVISION_NAME) {
        this.SUBDIVISION_NAME = SUBDIVISION_NAME;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", _version_ = " + _version_
                + ", ISO_ALPHA_3 = " + ISO_ALPHA_3 + ", ISO_ALPHA_2 = "
                + ISO_ALPHA_2 + ", doc_type = " + doc_type
                + ", SUBDIVISION_CD = " + SUBDIVISION_CD
                + ", SUBDIVISION_NAME = " + SUBDIVISION_NAME + "]";
    }
}
