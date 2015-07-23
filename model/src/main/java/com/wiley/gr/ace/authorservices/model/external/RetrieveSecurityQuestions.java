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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class RetrieveSecurityQuestions.
 *
 * @author yugandhark
 */
public class RetrieveSecurityQuestions {

    /** The status. */
    @JsonProperty("Status")
    private String status;

    /** The system security questions. */
    @JsonProperty("SystemSecurityQuestions")
    private SystemSecurityQuestions systemSecurityQuestions;

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Gets the system security questions.
     *
     * @return the system security questions
     */
    public final SystemSecurityQuestions getSystemSecurityQuestions() {
        return systemSecurityQuestions;
    }

    /**
     * Sets the system security questions.
     *
     * @param systemSecurityQuestions the new system security questions
     */
    public final void setSystemSecurityQuestions(
            final SystemSecurityQuestions systemSecurityQuestions) {
        this.systemSecurityQuestions = systemSecurityQuestions;
    }
}
