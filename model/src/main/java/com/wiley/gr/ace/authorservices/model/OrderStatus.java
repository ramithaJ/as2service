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
package com.wiley.gr.ace.authorservices.model;


/**
 * @author Virtusa version1.0
 *
 */
public class OrderStatus {

    /**
     * This field holds the value of status.
     */
    private String status;

    /**
     * This field holds the value of ActionsRequired.
     */
    private String ActionsRequired;

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
     * @return the actionsRequired
     */
    public final String getActionsRequired() {
        return ActionsRequired;
    }

    /**
     * @param actionsRequired
     *            the actionsRequired to set
     */
    public final void setActionsRequired(final String actionsRequired) {
        ActionsRequired = actionsRequired;
    }

}
