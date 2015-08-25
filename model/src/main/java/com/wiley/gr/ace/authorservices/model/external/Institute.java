/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class Institute.
 *
 * @author virtusa version 1.0
 */
public class Institute {

    /**
     * This field holds the value of instituteName.
     */
	@JsonProperty("instituteName")
    private String instituteName;

    /**
     * This field holds the value of instituteCode.
     */
	@JsonProperty("instituteCode")
    private String instituteCode;
	
	/**
	 * This field holds the value of discount.
	 */
	@JsonProperty("discount")
	private List<DiscountedSociety> discountList;

    /**
     * @return the instituteName
     */
    public final String getInstituteName() {
        return instituteName;
    }

    /**
     * @param instituteName
     *            the instituteName to set
     */
    public final void setInstituteName(final String instituteName) {
        this.instituteName = instituteName;
    }

    /**
     * @return the instituteCode
     */
    public final String getInstituteCode() {
        return instituteCode;
    }

    /**
     * @param instituteCode
     *            the instituteCode to set
     */
    public final void setInstituteCode(final String instituteCode) {
        this.instituteCode = instituteCode;
    }

}
