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
 * @author yugandhark
 *
 */
@JsonInclude(Include.NON_NULL)
public class DashBoardInfo {

    /** The id. */
    private String id;

    /** The dashBoardInfoMessage. */
    private String dashBoardInfoMessage;

    /**
     * Gets the dashBoardInfoMessage.
     *
     * @return the dashBoardInfoMessage
     * 
     */
    public String getDashBoardInfoMessage() {
        return dashBoardInfoMessage;
    }

    /**
     * Sets the dashBoardInfoMessage.
     *
     * @param the
     *            dashBoardInfoMessage
     * 
     */
    public void setDashBoardInfoMessage(String dashBoardInfoMessage) {
        this.dashBoardInfoMessage = dashBoardInfoMessage;
    }

    /**
     * Gets the id.
     *
     * @return the id
     * 
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param Id
     *            the new id
     */
    public void setId(String id) {
        this.id = id;
    }

}
