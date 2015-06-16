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
 * The Class IndustryDocs.
 *
 * @author virtusa version 1.0
 */
public class IndustryDocs {

    /** The id. */
    private String id;

    /** The _version_. */
    private String _version_;

    /** The naics code. */
    private String NAICS_CODE;

    /** The doc_type. */
    private String doc_type;

    /** The naics title. */
    private String NAICS_TITLE;

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
     * Gets the naics code.
     *
     * @return the naics code
     */
    public String getNAICS_CODE() {
        return NAICS_CODE;
    }

    /**
     * Sets the naics code.
     *
     * @param NAICS_CODE
     *            the new naics code
     */
    public void setNAICS_CODE(String NAICS_CODE) {
        this.NAICS_CODE = NAICS_CODE;
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
     * Gets the naics title.
     *
     * @return the naics title
     */
    public String getNAICS_TITLE() {
        return NAICS_TITLE;
    }

    /**
     * Sets the naics title.
     *
     * @param NAICS_TITLE
     *            the new naics title
     */
    public void setNAICS_TITLE(String NAICS_TITLE) {
        this.NAICS_TITLE = NAICS_TITLE;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", _version_ = " + _version_
                + ", NAICS_CODE = " + NAICS_CODE + ", doc_type = " + doc_type
                + ", NAICS_TITLE = " + NAICS_TITLE + "]";
    }

}
