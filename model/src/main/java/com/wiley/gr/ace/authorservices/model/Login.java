package com.wiley.gr.ace.authorservices.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Login.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Login {

    /** The email id. */
    @NotNull
    @NotBlank
    @Email
    private String emailId;

    /** The password. */
    @NotNull
    @NotBlank
    private String password;

    /** The authentication type. */
    private String authenticationType;

    /** The app key. */
    private String appKey;

    /** The user id. */
    private Integer userId;

    /**
     * Gets the email id.
     *
     * @return the email id
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the new user id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Sets the email id.
     *
     * @param emailId
     *            the new email id
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the authentication type.
     *
     * @return the authentication type
     */
    public String getAuthenticationType() {
        return authenticationType;
    }

    /**
     * Sets the authentication type.
     *
     * @param authenticationType
     *            the new authentication type
     */
    public void setAuthenticationType(String authenticationType) {
        this.authenticationType = authenticationType;
    }

    /**
     * Gets the app key.
     *
     * @return the app key
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * Sets the app key.
     *
     * @param appKey
     *            the new app key
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

}
