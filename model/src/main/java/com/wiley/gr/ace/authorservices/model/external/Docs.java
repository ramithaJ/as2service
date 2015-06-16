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
 * The Class Docs.
 */
public class Docs {

    /** The id. */
    private String id;

    /** The _version_. */
    private String _version_;

    /** The doc_type. */
    private String doc_type;

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
     * @return the sUBJECT_CODE
     */
    public final String getSUBJECT_CODE() {
        return SUBJECT_CODE;
    }

    /**
     * @param sUBJECT_CODE
     *            the sUBJECT_CODE to set
     */
    public final void setSUBJECT_CODE(final String sUBJECT_CODE) {
        SUBJECT_CODE = sUBJECT_CODE;
    }

    /**
     * @return the sUBJECT_SHORT_NAME
     */
    public final String getSUBJECT_SHORT_NAME() {
        return SUBJECT_SHORT_NAME;
    }

    /**
     * @param sUBJECT_SHORT_NAME
     *            the sUBJECT_SHORT_NAME to set
     */
    public final void setSUBJECT_SHORT_NAME(final String sUBJECT_SHORT_NAME) {
        SUBJECT_SHORT_NAME = sUBJECT_SHORT_NAME;
    }

    /**
     * @return the sUBJECT_NAME
     */
    public final String getSUBJECT_NAME() {
        return SUBJECT_NAME;
    }

    /**
     * @param sUBJECT_NAME
     *            the sUBJECT_NAME to set
     */
    public final void setSUBJECT_NAME(final String sUBJECT_NAME) {
        SUBJECT_NAME = sUBJECT_NAME;
    }

    /** The subject code. */
    private String SUBJECT_CODE;

    /** The subject short name. */
    private String SUBJECT_SHORT_NAME;

    /** The subject name. */
    private String SUBJECT_NAME;
}
