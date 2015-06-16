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
     * @return the _version_
     */
    public final String get_version_() {
        return _version_;
    }

    /**
     * @param _version_
     *            the _version_ to set
     */
    public final void set_version_(final String _version_) {
        this._version_ = _version_;
    }

    /**
     * @return the iSO_ALPHA_3
     */
    public final String getISO_ALPHA_3() {
        return ISO_ALPHA_3;
    }

    /**
     * @param iSO_ALPHA_3
     *            the iSO_ALPHA_3 to set
     */
    public final void setISO_ALPHA_3(final String iSO_ALPHA_3) {
        ISO_ALPHA_3 = iSO_ALPHA_3;
    }

    /**
     * @return the iSO_ALPHA_2
     */
    public final String getISO_ALPHA_2() {
        return ISO_ALPHA_2;
    }

    /**
     * @param iSO_ALPHA_2
     *            the iSO_ALPHA_2 to set
     */
    public final void setISO_ALPHA_2(final String iSO_ALPHA_2) {
        ISO_ALPHA_2 = iSO_ALPHA_2;
    }

    /**
     * @return the doc_type
     */
    public final String getDoc_type() {
        return doc_type;
    }

    /**
     * @param doc_type
     *            the doc_type to set
     */
    public final void setDoc_type(final String doc_type) {
        this.doc_type = doc_type;
    }

    /**
     * @return the sUBDIVISION_CD
     */
    public final String getSUBDIVISION_CD() {
        return SUBDIVISION_CD;
    }

    /**
     * @param sUBDIVISION_CD
     *            the sUBDIVISION_CD to set
     */
    public final void setSUBDIVISION_CD(final String sUBDIVISION_CD) {
        SUBDIVISION_CD = sUBDIVISION_CD;
    }

    /**
     * @return the sUBDIVISION_NAME
     */
    public final String getSUBDIVISION_NAME() {
        return SUBDIVISION_NAME;
    }

    /**
     * @param sUBDIVISION_NAME
     *            the sUBDIVISION_NAME to set
     */
    public final void setSUBDIVISION_NAME(final String sUBDIVISION_NAME) {
        SUBDIVISION_NAME = sUBDIVISION_NAME;
    }

    /** The subdivision name. */
    private String SUBDIVISION_NAME;
}
