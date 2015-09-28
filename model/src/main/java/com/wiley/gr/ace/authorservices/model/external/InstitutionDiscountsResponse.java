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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class InstitutionDiscountsResponse.
 *
 * @author virtusa version 1.0
 */
public class InstitutionDiscountsResponse {

    /**
     * This field holds the value of status
     */
	@JsonProperty("status")
    private String status;

    @JsonProperty("payload")
    private InstitutionDetails institutionDetails;
    
    /**
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

	/**
	 * @return the institutionDetails
	 */
	public InstitutionDetails getInstitutionDetails() {
		return institutionDetails;
	}

	/**
	 * @param institutionDetails the institutionDetails to set
	 */
	public void setInstitutionDetails(InstitutionDetails institutionDetails) {
		this.institutionDetails = institutionDetails;
	}
    

}
