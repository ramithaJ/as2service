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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Institution.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Institution {

    /** The institution id. */
    private String institutionId;

    /** The institution name. */
    private String institutionName;

    /**
     * @return the institutionId
     */
    public final String getInstitutionId() {
        return institutionId;
    }

    /**
     * @param institutionId
     *            the institutionId to set
     */
    public final void setInstitutionId(final String institutionId) {
        this.institutionId = institutionId;
    }

    /**
     * @return the institutionName
     */
    public final String getInstitutionName() {
        return institutionName;
    }

    /**
     * @param institutionName
     *            the institutionName to set
     */
    public final void setInstitutionName(final String institutionName) {
        this.institutionName = institutionName;
    }

}
