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
 * The Class Security.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Security {

    /** The id1. */
    @NotNull
    @NotBlank
    private int id1;

    /** The id2. */
    @NotNull
    @NotBlank
    private int id2;

    /** The security question1. */
    @NotNull
    @NotBlank
    private String securityQuestion1;

    /** The security question2. */
    @NotNull
    @NotBlank
    private String securityQuestion2;

    /** The security answer1. */
    @NotNull
    @NotBlank
    private String securityAnswer1;

    /** The security answer2. */
    @NotNull
    @NotBlank
    private String securityAnswer2;

    /**
     * @return the id1
     */
    public final int getId1() {
        return id1;
    }

    /**
     * @param id1
     *            the id1 to set
     */
    public final void setId1(final int id1) {
        this.id1 = id1;
    }

    /**
     * @return the id2
     */
    public final int getId2() {
        return id2;
    }

    /**
     * @param id2
     *            the id2 to set
     */
    public final void setId2(final int id2) {
        this.id2 = id2;
    }

    /**
     * @return the securityQuestion1
     */
    public final String getSecurityQuestion1() {
        return securityQuestion1;
    }

    /**
     * @param securityQuestion1
     *            the securityQuestion1 to set
     */
    public final void setSecurityQuestion1(final String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    /**
     * @return the securityQuestion2
     */
    public final String getSecurityQuestion2() {
        return securityQuestion2;
    }

    /**
     * @param securityQuestion2
     *            the securityQuestion2 to set
     */
    public final void setSecurityQuestion2(final String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    /**
     * @return the securityAnswer1
     */
    public final String getSecurityAnswer1() {
        return securityAnswer1;
    }

    /**
     * @param securityAnswer1
     *            the securityAnswer1 to set
     */
    public final void setSecurityAnswer1(final String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }

    /**
     * @return the securityAnswer2
     */
    public final String getSecurityAnswer2() {
        return securityAnswer2;
    }

    /**
     * @param securityAnswer2
     *            the securityAnswer2 to set
     */
    public final void setSecurityAnswer2(final String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2;
    }

}
