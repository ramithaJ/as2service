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
 * @author Virtusa
 *
 */
public class JobCategoryDocs {

    private String id;

    private String JOB_DEFINITION;

    private String _version_;

    private String SUBJOBTITLE;

    private String JOBTITLE;

    private String doc_type;

    private String JOBCODE;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJOB_DEFINITION() {
        return JOB_DEFINITION;
    }

    public void setJOB_DEFINITION(String jOB_DEFINITION) {
        JOB_DEFINITION = jOB_DEFINITION;
    }

    public String get_version_() {
        return _version_;
    }

    public void set_version_(String _version_) {
        this._version_ = _version_;
    }

    public String getSUBJOBTITLE() {
        return SUBJOBTITLE;
    }

    public void setSUBJOBTITLE(String sUBJOBTITLE) {
        SUBJOBTITLE = sUBJOBTITLE;
    }

    public String getJOBTITLE() {
        return JOBTITLE;
    }

    public void setJOBTITLE(String jOBTITLE) {
        JOBTITLE = jOBTITLE;
    }

    public String getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getJOBCODE() {
        return JOBCODE;
    }

    public void setJOBCODE(String jOBCODE) {
        JOBCODE = jOBCODE;
    }
    
    
}
