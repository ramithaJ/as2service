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

public class Docs
{
    private String id;

    private String _version_;

    private String doc_type;

    private String SUBJECT_CODE;

    private String SUBJECT_SHORT_NAME;

    private String SUBJECT_NAME;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String get_version_ ()
    {
        return _version_;
    }

    public void set_version_ (String _version_)
    {
        this._version_ = _version_;
    }

    public String getDoc_type ()
    {
        return doc_type;
    }

    public void setDoc_type (String doc_type)
    {
        this.doc_type = doc_type;
    }

    public String getSUBJECT_CODE ()
    {
        return SUBJECT_CODE;
    }

    public void setSUBJECT_CODE (String SUBJECT_CODE)
    {
        this.SUBJECT_CODE = SUBJECT_CODE;
    }

    public String getSUBJECT_SHORT_NAME ()
    {
        return SUBJECT_SHORT_NAME;
    }

    public void setSUBJECT_SHORT_NAME (String SUBJECT_SHORT_NAME)
    {
        this.SUBJECT_SHORT_NAME = SUBJECT_SHORT_NAME;
    }

    public String getSUBJECT_NAME ()
    {
        return SUBJECT_NAME;
    }

    public void setSUBJECT_NAME (String SUBJECT_NAME)
    {
        this.SUBJECT_NAME = SUBJECT_NAME;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", _version_ = "+_version_+", doc_type = "+doc_type+", SUBJECT_CODE = "+SUBJECT_CODE+", SUBJECT_SHORT_NAME = "+SUBJECT_SHORT_NAME+", SUBJECT_NAME = "+SUBJECT_NAME+"]";
    }
}
		