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
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Virtusa version1.0
 *
 */
public class SecurityQuestionsValidateRequest {

    /**
     * This field holds the value of validateUserSecurityQA
     */
    @JsonProperty("ValidateUserSecurityQA")
    private ValidateUserSecurityQA validateUserSecurityQA;

    /**
     * @return the validateUserSecurityQA
     */
    public final ValidateUserSecurityQA getValidateUserSecurityQA() {
        return validateUserSecurityQA;
    }

    /**
     * @param validateUserSecurityQA
     *            the validateUserSecurityQA to set
     */
    public final void setValidateUserSecurityQA(
            final ValidateUserSecurityQA validateUserSecurityQA) {
        this.validateUserSecurityQA = validateUserSecurityQA;
    }

}
