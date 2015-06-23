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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class InvoiceRequestOrder.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class InvoiceRequestOrder {

    /** The request created timestamp. */
    private String requestCreatedTimestamp;

    /** The request type. */
    private String requestType;

    /** The oo unique id. */
    private String ooUniqueId;

    /**
     * Gets the request created timestamp.
     *
     * @return the request created timestamp
     */
    public final String getRequestCreatedTimestamp() {
        return requestCreatedTimestamp;
    }

    /**
     * Sets the request created timestamp.
     *
     * @param requestCreatedTimestamp
     *            the new request created timestamp
     */
    public final void setRequestCreatedTimestamp(
            final String requestCreatedTimestamp) {
        this.requestCreatedTimestamp = requestCreatedTimestamp;
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

    /**
     * Gets the oo unique id.
     *
     * @return the oo unique id
     */
    public final String getOoUniqueId() {
        return ooUniqueId;
    }

    /**
     * Sets the oo unique id.
     *
     * @param ooUniqueId
     *            the new oo unique id
     */
    public final void setOoUniqueId(final String ooUniqueId) {
        this.ooUniqueId = ooUniqueId;
    }

}
