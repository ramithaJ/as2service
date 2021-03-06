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
public class ValidateUserSecurityQA {

    /**
     * This field holds the value of login
     */
    @JsonProperty("Login")
    private String login;

    /**
     * This field holds the value of userSecurityQuestions
     */
    @JsonProperty("UserSecurityQuestions")
    private UserSecurityQuestions userSecurityQuestions;

    /**
     * @return the login
     */
    public final String getLogin() {
        return login;
    }

    /**
     * @param login
     *            the login to set
     */
    public final void setLogin(final String login) {
        this.login = login;
    }

    /**
     * @return the userSecurityQuestions
     */
    public final UserSecurityQuestions getUserSecurityQuestions() {
        return userSecurityQuestions;
    }

    /**
     * @param userSecurityQuestions
     *            the userSecurityQuestions to set
     */
    public final void setUserSecurityQuestions(
            final UserSecurityQuestions userSecurityQuestions) {
        this.userSecurityQuestions = userSecurityQuestions;
    }

}
