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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class SecurityQuestion.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class SecurityQuestion {

    /** The question. */
    private String question;

    /** The answer. */
    private String answer;

    /**
     * @return the question
     */
    public final String getQuestion() {
        return question;
    }

    /**
     * @param question
     *            the question to set
     */
    public final void setQuestion(final String question) {
        this.question = question;
    }

    /**
     * @return the answer
     */
    public final String getAnswer() {
        return answer;
    }

    /**
     * @param answer
     *            the answer to set
     */
    public final void setAnswer(final String answer) {
        this.answer = answer;
    }

}
