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
     * Gets the security question.
     *
     * @return the security question
     */
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    /**
     * Sets the security question.
     *
     * @param securityQuestion
     *            the new security question
     */
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    /**
     * Gets the security answer.
     *
     * @return the security answer
     */
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    /**
     * Sets the security answer.
     *
     * @param securityAnswer
     *            the new security answer
     */
    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    /**
     * Gets the security question id.
     *
     * @return the security question id
     */
    public String getSecurityQuestionId() {
        return securityQuestionId;
    }

    /**
     * Sets the security question id.
     *
     * @param securityQuestionId
     *            the new security question id
     */
    public void setSecurityQuestionId(String securityQuestionId) {
        this.securityQuestionId = securityQuestionId;
    }

}
