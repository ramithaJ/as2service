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
package com.wiley.gr.ace.authorservices.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class LicenseStatus.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class LicenseStatus {

    /** The info. */
    private String info;

    /** The actions. */
    private ArrayList<String> actions;

    /** The task id. */
    private String taskId;

    /** The license date. */
    private String licenseDate;

    /**
     * Gets the task id.
     *
     * @return the task id
     */
    public final String getTaskId() {
        return taskId;
    }

    /**
     * Sets the task id.
     *
     * @param taskId
     *            the new task id
     */
    public final void setTaskId(final String taskId) {
        this.taskId = taskId;
    }

    /**
     * Gets the license date.
     *
     * @return the license date
     */
    public final String getLicenseDate() {
        return licenseDate;
    }

    /**
     * Sets the license date.
     *
     * @param licenseDate
     *            the new license date
     */
    public final void setLicenseDate(final String licenseDate) {
        this.licenseDate = licenseDate;
    }

    /**
     * Gets the info.
     *
     * @return the info
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets the info.
     *
     * @param info
     *            the info to set
     */
    public void setInfo(final String info) {
        this.info = info;
    }

    /**
     * Gets the actions.
     *
     * @return the actions
     */
    public ArrayList<String> getActions() {
        return actions;
    }

    /**
     * Sets the actions.
     *
     * @param actions
     *            the actions to set
     */
    public void setActions(final ArrayList<String> actions) {
        this.actions = actions;
    }

}
