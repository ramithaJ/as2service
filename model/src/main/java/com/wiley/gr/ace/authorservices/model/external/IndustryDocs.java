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
     * @return the nAICS_CODE
     */
    public final String getNAICS_CODE() {
        return NAICS_CODE;
    }

    /**
     * @param nAICS_CODE
     *            the nAICS_CODE to set
     */
    public final void setNAICS_CODE(final String nAICS_CODE) {
        NAICS_CODE = nAICS_CODE;
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
     * @return the nAICS_TITLE
     */
    public final String getNAICS_TITLE() {
        return NAICS_TITLE;
    }

    /**
     * @param nAICS_TITLE
     *            the nAICS_TITLE to set
     */
    public final void setNAICS_TITLE(final String nAICS_TITLE) {
        NAICS_TITLE = nAICS_TITLE;
    }

    /** The doc_type. */
    private String doc_type;

    /** The naics title. */
    private String NAICS_TITLE;

}
