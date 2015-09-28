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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CancelOrderRequest.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class CancelOrderRequest {

    /** The correlation id. */
    @JsonProperty("CorrelationID")
    private Integer correlationID;

    /** The application key. */
    @JsonProperty("ApplicationKey")
    private String applicationKey;

    /** The user id. */
    @JsonProperty("UserID")
    private Integer userId;

    /** The as id. */
    @JsonProperty("ASID")
    private Integer asID;

    /** The oo unique id. */
    @JsonProperty("ooUniqueId")
    private Integer ooUniqueId;

    /** The cancel reason code. */
    @JsonProperty("cancelReasonCode")
    private String cancelReasonCode;

    /**
     * Gets the correlation id.
     *
     * @return the correlation id
     */
    public final Integer getCorrelationID() {
        return correlationID;
    }

    /**
     * Sets the correlation id.
     *
     * @param correlationID
     *            the new correlation id
     */
    public final void setCorrelationID(final Integer correlationID) {
        this.correlationID = correlationID;
    }

    /**
     * Gets the application key.
     *
     * @return the application key
     */
    public final String getApplicationKey() {
        return applicationKey;
    }

    /**
     * Sets the application key.
     *
     * @param applicationKey
     *            the new application key
     */
    public final void setApplicationKey(final String applicationKey) {
        this.applicationKey = applicationKey;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public final Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the new user id
     */
    public final void setUserId(final Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets the as id.
     *
     * @return the as id
     */
    public final Integer getAsID() {
        return asID;
    }

    /**
     * Sets the as id.
     *
     * @param asID
     *            the new as id
     */
    public final void setAsID(final Integer asID) {
        this.asID = asID;
    }

    /**
     * Gets the oo unique id.
     *
     * @return the oo unique id
     */
    public final Integer getOoUniqueId() {
        return ooUniqueId;
    }

    /**
     * Sets the oo unique id.
     *
     * @param ooUniqueId
     *            the new oo unique id
     */
    public final void setOoUniqueId(final Integer ooUniqueId) {
        this.ooUniqueId = ooUniqueId;
    }

    /**
     * Gets the cancel reason code.
     *
     * @return the cancel reason code
     */
    public final String getCancelReasonCode() {
        return cancelReasonCode;
    }

    /**
     * Sets the cancel reason code.
     *
     * @param cancelReasonCode
     *            the new cancel reason code
     */
    public final void setCancelReasonCode(final String cancelReasonCode) {
        this.cancelReasonCode = cancelReasonCode;
    }

}
