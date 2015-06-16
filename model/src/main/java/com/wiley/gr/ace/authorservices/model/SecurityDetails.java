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

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class SecurityDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class SecurityDetails {

    /** The security question id. */
    @NotNull
    @NotBlank
    private String securityQuestionId;

    /** The security question. */
    @NotNull
    @NotBlank
    private String securityQuestion;

    /** The security answer. */
    @NotNull
    @NotBlank
    private String securityAnswer;

    /**
     * @return the securityQuestionId
     */
    public final String getSecurityQuestionId() {
        return securityQuestionId;
    }

    /**
     * @param securityQuestionId
     *            the securityQuestionId to set
     */
    public final void setSecurityQuestionId(final String securityQuestionId) {
        this.securityQuestionId = securityQuestionId;
    }

    /**
     * @return the securityQuestion
     */
    public final String getSecurityQuestion() {
        return securityQuestion;
    }

    /**
     * @param securityQuestion
     *            the securityQuestion to set
     */
    public final void setSecurityQuestion(final String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    /**
     * @return the securityAnswer
     */
    public final String getSecurityAnswer() {
        return securityAnswer;
    }

    /**
     * @param securityAnswer
     *            the securityAnswer to set
     */
    public final void setSecurityAnswer(final String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

}
