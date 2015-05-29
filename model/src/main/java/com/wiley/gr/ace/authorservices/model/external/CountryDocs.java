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

public class CountryDocs {

	    private String id;

	    private String _version_;

	    private String ISO_NUMERIC_3;

	    private String ISO_ALPHA_3;

	    private String ISO_ALPHA_2;

	    private String doc_type;

	    private String COUNTRY_NAME;

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

	    public String getISO_NUMERIC_3 ()
	    {
	        return ISO_NUMERIC_3;
	    }

	    public void setISO_NUMERIC_3 (String ISO_NUMERIC_3)
	    {
	        this.ISO_NUMERIC_3 = ISO_NUMERIC_3;
	    }

	    public String getISO_ALPHA_3 ()
	    {
	        return ISO_ALPHA_3;
	    }

	    public void setISO_ALPHA_3 (String ISO_ALPHA_3)
	    {
	        this.ISO_ALPHA_3 = ISO_ALPHA_3;
	    }

	    public String getISO_ALPHA_2 ()
	    {
	        return ISO_ALPHA_2;
	    }

	    public void setISO_ALPHA_2 (String ISO_ALPHA_2)
	    {
	        this.ISO_ALPHA_2 = ISO_ALPHA_2;
	    }

	    public String getDoc_type ()
	    {
	        return doc_type;
	    }

	    public void setDoc_type (String doc_type)
	    {
	        this.doc_type = doc_type;
	    }

	    public String getCOUNTRY_NAME ()
	    {
	        return COUNTRY_NAME;
	    }

	    public void setCOUNTRY_NAME (String COUNTRY_NAME)
	    {
	        this.COUNTRY_NAME = COUNTRY_NAME;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [id = "+id+", _version_ = "+_version_+", ISO_NUMERIC_3 = "+ISO_NUMERIC_3+", ISO_ALPHA_3 = "+ISO_ALPHA_3+", ISO_ALPHA_2 = "+ISO_ALPHA_2+", doc_type = "+doc_type+", COUNTRY_NAME = "+COUNTRY_NAME+"]";
	    }
	}
				

