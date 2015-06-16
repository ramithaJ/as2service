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
     * @return the emailId
     */
    public final String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId
     *            the emailId to set
     */
    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the authenticationType
     */
    public final String getAuthenticationType() {
        return authenticationType;
    }

    /**
     * @param authenticationType
     *            the authenticationType to set
     */
    public final void setAuthenticationType(final String authenticationType) {
        this.authenticationType = authenticationType;
    }

    /**
     * @return the appKey
     */
    public final String getAppKey() {
        return appKey;
    }

    /**
     * @param appKey
     *            the appKey to set
     */
    public final void setAppKey(final String appKey) {
        this.appKey = appKey;
    }

    /**
     * @return the userId
     */
    public final Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final Integer userId) {
        this.userId = userId;
    }

}
