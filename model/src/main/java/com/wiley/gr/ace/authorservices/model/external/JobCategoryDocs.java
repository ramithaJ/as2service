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
     * Gets the job definition.
     *
     * @return the job definition
     */
    public String getJOB_DEFINITION() {
        return JOB_DEFINITION;
    }

    /**
     * Sets the job definition.
     *
     * @param jOB_DEFINITION
     *            the new job definition
     */
    public void setJOB_DEFINITION(String jOB_DEFINITION) {
        JOB_DEFINITION = jOB_DEFINITION;
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
     * Gets the subjobtitle.
     *
     * @return the subjobtitle
     */
    public String getSUBJOBTITLE() {
        return SUBJOBTITLE;
    }

    /**
     * Sets the subjobtitle.
     *
     * @param sUBJOBTITLE
     *            the new subjobtitle
     */
    public void setSUBJOBTITLE(String sUBJOBTITLE) {
        SUBJOBTITLE = sUBJOBTITLE;
    }

    /**
     * Gets the jobtitle.
     *
     * @return the jobtitle
     */
    public String getJOBTITLE() {
        return JOBTITLE;
    }

    /**
     * Sets the jobtitle.
     *
     * @param jOBTITLE
     *            the new jobtitle
     */
    public void setJOBTITLE(String jOBTITLE) {
        JOBTITLE = jOBTITLE;
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
     * Gets the jobcode.
     *
     * @return the jobcode
     */
    public String getJOBCODE() {
        return JOBCODE;
    }

    /**
     * Sets the jobcode.
     *
     * @param jOBCODE
     *            the new jobcode
     */
    public void setJOBCODE(String jOBCODE) {
        JOBCODE = jOBCODE;
    }

}
