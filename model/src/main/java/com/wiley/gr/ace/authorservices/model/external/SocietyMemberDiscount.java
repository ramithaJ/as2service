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

/**
 * @author virtusa version1.0
 */
public class SocietyMemberDiscount {

    /**
     * This field holds the value of status
     */
    private String status;

    /**
     * This field holds the value of payload
     */
    private PayLoad payload;

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
     * @return the payload
     */
    public final PayLoad getPayload() {
        return payload;
    }

    /**
     * @param payload
     *            the payload to set
     */
    public final void setPayload(final PayLoad payload) {
        this.payload = payload;
    }

}
