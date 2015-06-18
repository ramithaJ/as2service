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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class DashboardInfo.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class DashboardInfo {

    /** The id. */
    private String id;

    /** The dashBoardInfoMessage. */
    private String dashBoardInfoMessage;

    /**
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * @return the dashBoardInfoMessage
     */
    public final String getDashBoardInfoMessage() {
        return dashBoardInfoMessage;
    }

    /**
     * @param dashBoardInfoMessage
     *            the dashBoardInfoMessage to set
     */
    public final void setDashBoardInfoMessage(final String dashBoardInfoMessage) {
        this.dashBoardInfoMessage = dashBoardInfoMessage;
    }

}
