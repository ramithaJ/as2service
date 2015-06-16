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
 * The Class JobCategoryDocs.
 *
 * @author virtusa version 1.0
 */
public class JobCategoryDocs {

    /** The id. */
    private String id;

    /** The job definition. */
    private String JOB_DEFINITION;

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
     * @return the jOB_DEFINITION
     */
    public final String getJOB_DEFINITION() {
        return JOB_DEFINITION;
    }

    /**
     * @param jOB_DEFINITION
     *            the jOB_DEFINITION to set
     */
    public final void setJOB_DEFINITION(final String jOB_DEFINITION) {
        JOB_DEFINITION = jOB_DEFINITION;
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
     * @return the sUBJOBTITLE
     */
    public final String getSUBJOBTITLE() {
        return SUBJOBTITLE;
    }

    /**
     * @param sUBJOBTITLE
     *            the sUBJOBTITLE to set
     */
    public final void setSUBJOBTITLE(final String sUBJOBTITLE) {
        SUBJOBTITLE = sUBJOBTITLE;
    }

    /**
     * @return the jOBTITLE
     */
    public final String getJOBTITLE() {
        return JOBTITLE;
    }

    /**
     * @param jOBTITLE
     *            the jOBTITLE to set
     */
    public final void setJOBTITLE(final String jOBTITLE) {
        JOBTITLE = jOBTITLE;
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
     * @return the jOBCODE
     */
    public final String getJOBCODE() {
        return JOBCODE;
    }

    /**
     * @param jOBCODE
     *            the jOBCODE to set
     */
    public final void setJOBCODE(final String jOBCODE) {
        JOBCODE = jOBCODE;
    }

    /** The _version_. */
    private String _version_;

    /** The subjobtitle. */
    private String SUBJOBTITLE;

    /** The jobtitle. */
    private String JOBTITLE;

    /** The doc_type. */
    private String doc_type;

    /** The jobcode. */
    private String JOBCODE;

}
