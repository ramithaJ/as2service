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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class TaxResponse.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class TaxResponse {

    /** The response code. */
    private String responseCode;

    /** The item. */
    private List<Item> item;

    /** The response description. */
    private String responseDescription;

    /** The request type. */
    private String requestType;

    /**
     * Gets the response code.
     *
     * @return the response code
     */
    public final String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the response code.
     *
     * @param responseCode
     *            the new response code
     */
    public final void setResponseCode(final String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * Gets the item.
     *
     * @return the item
     */
    public final List<Item> getItem() {
        return item;
    }

    /**
     * Sets the item.
     *
     * @param item
     *            the new item
     */
    public final void setItem(final List<Item> item) {
        this.item = item;
    }

    /**
     * Gets the response description.
     *
     * @return the response description
     */
    public final String getResponseDescription() {
        return responseDescription;
    }

    /**
     * Sets the response description.
     *
     * @param responseDescription
     *            the new response description
     */
    public final void setResponseDescription(final String responseDescription) {
        this.responseDescription = responseDescription;
    }

    /**
     * Gets the request type.
     *
     * @return the request type
     */
    public final String getRequestType() {
        return requestType;
    }

    /**
     * Sets the request type.
     *
     * @param requestType
     *            the new request type
     */
    public final void setRequestType(final String requestType) {
        this.requestType = requestType;
    }
}
