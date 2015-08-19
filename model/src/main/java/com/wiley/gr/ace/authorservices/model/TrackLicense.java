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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class TrackLicense.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class TrackLicense {

    /** The license date. */
    private String licenseDate;

    /** The task id. */
    private String taskId;

    /** The license status. */
    private String licenseStatus;

    /** The action. */
    private List<String> action;

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
     * Gets the license status.
     *
     * @return the license status
     */
    public final String getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * Sets the license status.
     *
     * @param licenseStatus
     *            the new license status
     */
    public final void setLicenseStatus(final String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    /**
     * Gets the action.
     *
     * @return the action
     */
    public final List<String> getAction() {
        return action;
    }

    /**
     * Sets the action.
     *
     * @param action
     *            the new action
     */
    public final void setAction(final List<String> action) {
        this.action = action;
    }

}
