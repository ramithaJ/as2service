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

// TODO: Auto-generated Javadoc
/**
 * The Class ALMUser.
 */
public class ALMUser {

    /** The last name. */
    @JsonProperty("LastName")
    private String lastName;

    /** The first name. */
    @JsonProperty("FirstName")
    private String firstName;

    /** The email. */
    @JsonProperty("Email")
    private String email;

    /** The password. */
    @JsonProperty("Password")
    private String password;

    /** The user status. */
    @JsonProperty("UserStatus")
    private String userStatus;

    /** The source system. */
    @JsonProperty("SourceSystem")
    private String sourceSystem;

    /** The customer type. */
    @JsonProperty("CustomerType")
    private String customerType;

    /** The tc flag. */
    @JsonProperty("TCFlag")
    private String tcFlag;

    /** The user address. */
    @JsonProperty("UserAddress")
    private ALMUserAddress userAddress;

    /** The ecid. */
    @JsonProperty("ECID")
    private String ecid;

    /** The send email. */
    @JsonProperty("SendEmail")
    private String sendEmail;
    
    /** The alm user id. */
    @JsonProperty("AlmInternalKey")
    private String almUserId;

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the new last name
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the new first name
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email
     *            the new email
     */
    public final void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password
     *            the new password
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets the user status.
     *
     * @return the user status
     */
    public final String getUserStatus() {
        return userStatus;
    }

    /**
     * Sets the user status.
     *
     * @param userStatus
     *            the new user status
     */
    public final void setUserStatus(final String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * Gets the source system.
     *
     * @return the source system
     */
    public final String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * Sets the source system.
     *
     * @param sourceSystem
     *            the new source system
     */
    public final void setSourceSystem(final String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    /**
     * Gets the customer type.
     *
     * @return the customer type
     */
    public final String getCustomerType() {
        return customerType;
    }

    /**
     * Sets the customer type.
     *
     * @param customerType
     *            the new customer type
     */
    public final void setCustomerType(final String customerType) {
        this.customerType = customerType;
    }

    /**
     * Gets the tc flag.
     *
     * @return the tc flag
     */
    public final String getTcFlag() {
        return tcFlag;
    }

    /**
     * Sets the tc flag.
     *
     * @param tcFlag
     *            the new tc flag
     */
    public final void setTcFlag(final String tcFlag) {
        this.tcFlag = tcFlag;
    }

    /**
     * Gets the user address.
     *
     * @return the user address
     */
    public final ALMUserAddress getUserAddress() {
        return userAddress;
    }

    /**
     * Sets the user address.
     *
     * @param userAddress
     *            the new user address
     */
    public final void setUserAddress(final ALMUserAddress userAddress) {
        this.userAddress = userAddress;
    }

    /**
     * Gets the ecid.
     *
     * @return the ecid
     */
    public final String getEcid() {
        return ecid;
    }

    /**
     * Sets the ecid.
     *
     * @param ecid
     *            the new ecid
     */
    public final void setEcid(final String ecid) {
        this.ecid = ecid;
    }

    /**
     * Gets the send email.
     *
     * @return the send email
     */
    public final String getSendEmail() {
        return sendEmail;
    }

    /**
     * Sets the send email.
     *
     * @param sendEmail
     *            the new send email
     */
    public final void setSendEmail(final String sendEmail) {
        this.sendEmail = sendEmail;
    }

	/**
	 * Gets the alm user id.
	 *
	 * @return the alm user id
	 */
	public String getAlmUserId() {
		return almUserId;
	}

	/**
	 * Sets the alm user id.
	 *
	 * @param almUserId the new alm user id
	 */
	public void setAlmUserId(String almUserId) {
		this.almUserId = almUserId;
	}
}
