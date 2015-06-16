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

    /** The subject code. */
    private String SUBJECT_CODE;

    /** The subject short name. */
    private String SUBJECT_SHORT_NAME;

    /** The subject name. */
    private String SUBJECT_NAME;

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
     * Gets the subject code.
     *
     * @return the subject code
     */
    public String getSUBJECT_CODE() {
        return SUBJECT_CODE;
    }

    /**
     * Sets the subject code.
     *
     * @param SUBJECT_CODE
     *            the new subject code
     */
    public void setSUBJECT_CODE(String SUBJECT_CODE) {
        this.SUBJECT_CODE = SUBJECT_CODE;
    }

    /**
     * Gets the subject short name.
     *
     * @return the subject short name
     */
    public String getSUBJECT_SHORT_NAME() {
        return SUBJECT_SHORT_NAME;
    }

    /**
     * Sets the subject short name.
     *
     * @param SUBJECT_SHORT_NAME
     *            the new subject short name
     */
    public void setSUBJECT_SHORT_NAME(String SUBJECT_SHORT_NAME) {
        this.SUBJECT_SHORT_NAME = SUBJECT_SHORT_NAME;
    }

    /**
     * Gets the subject name.
     *
     * @return the subject name
     */
    public String getSUBJECT_NAME() {
        return SUBJECT_NAME;
    }

    /**
     * Sets the subject name.
     *
     * @param SUBJECT_NAME
     *            the new subject name
     */
    public void setSUBJECT_NAME(String SUBJECT_NAME) {
        this.SUBJECT_NAME = SUBJECT_NAME;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", _version_ = " + _version_
                + ", doc_type = " + doc_type + ", SUBJECT_CODE = "
                + SUBJECT_CODE + ", SUBJECT_SHORT_NAME = " + SUBJECT_SHORT_NAME
                + ", SUBJECT_NAME = " + SUBJECT_NAME + "]";
    }
}
