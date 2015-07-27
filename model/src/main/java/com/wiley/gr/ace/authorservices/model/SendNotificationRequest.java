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

import java.util.List;

/**
 * The Class SendNotificationRequest.
 */
public class SendNotificationRequest {

    /** The from. */
    private String from;

    /** The to. */
    private String to;

    /** The field list. */
    private List<String> fieldList;

    /**
     * Gets the from.
     *
     * @return the from
     */
    public final String getFrom() {
        return from;
    }

    /**
     * Sets the from.
     *
     * @param from the new from
     */
    public final void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets the to.
     *
     * @return the to
     */
    public final String getTo() {
        return to;
    }

    /**
     * Sets the to.
     *
     * @param to the new to
     */
    public final void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets the field list.
     *
     * @return the field list
     */
    public final List<String> getFieldList() {
        return fieldList;
    }

    /**
     * Sets the field list.
     *
     * @param fieldList the new field list
     */
    public final void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

}
