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
 * @author virtusa
 *	version 1.0
 *
 */
public class IndustryDocs {
    
    private String id;

    private String _version_;

    private String NAICS_CODE;

    private String doc_type;

    private String NAICS_TITLE;

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

    public String getNAICS_CODE ()
    {
        return NAICS_CODE;
    }

    public void setNAICS_CODE (String NAICS_CODE)
    {
        this.NAICS_CODE = NAICS_CODE;
    }

    public String getDoc_type ()
    {
        return doc_type;
    }

    public void setDoc_type (String doc_type)
    {
        this.doc_type = doc_type;
    }

    public String getNAICS_TITLE ()
    {
        return NAICS_TITLE;
    }

    public void setNAICS_TITLE (String NAICS_TITLE)
    {
        this.NAICS_TITLE = NAICS_TITLE;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", _version_ = "+_version_+", NAICS_CODE = "+NAICS_CODE+", doc_type = "+doc_type+", NAICS_TITLE = "+NAICS_TITLE+"]";
    }

}
