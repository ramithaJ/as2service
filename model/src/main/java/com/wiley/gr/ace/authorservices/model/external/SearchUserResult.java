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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class SearchUserResult.
 * 
 * @author virtusa version 1.0
 */
public class SearchUserResult extends ErrorResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("SearchCustomerResponse")
    private List<ESBUser> searchCustomerResponse;

    public final String getStatus() {
        return status;
    }

    public final void setStatus(String status) {
        this.status = status;
    }

    public final List<ESBUser> getSearchCustomerResponse() {
        return searchCustomerResponse;
    }

    public final void setSearchCustomerResponse(List<ESBUser> searchCustomerResponse) {
        this.searchCustomerResponse = searchCustomerResponse;
    }


}
