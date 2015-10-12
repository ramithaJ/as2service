/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
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
 * @author virtusa version 1.0
 *
 */
public class ProfileResponse {

    /**
     * This field holds the value of status.
     */
    private String status;

    /**
     * This field holds the value of uuid.
     */
    private String uuid;

    /**
     * This field holds the value of ptpid.
     */
    private String ptpid;

    /**
     * This field holds the value of error.
     */
    @JsonProperty("Error")
    private ErrorPayLoad error;

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
     * @return the uuid
     */
    public final String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     *            the uuid to set
     */
    public final void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the ptpid
     */
    public final String getPtpid() {
        return ptpid;
    }

    /**
     * @param ptpid
     *            the ptpid to set
     */
    public final void setPtpid(final String ptpid) {
        this.ptpid = ptpid;
    }

    /**
     * @return the error
     */
    public final ErrorPayLoad getError() {
        return error;
    }

    /**
     * @param error
     *            the error to set
     */
    public final void setError(final ErrorPayLoad error) {
        this.error = error;
    }

}
