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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class UserManagement.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class UserManagement {

    /** The user id. */
    private String userId;

    /** The primary email address. */
    private String primaryEmailAddress;

    /** The secondary email address. */
    private String secondaryEmailAddress;

    /** The password. */
    private String password;

    /** The security vo. */
    private String securityVO;

    /** The is security setup. */
    private String isSecuritySetup;

    /** The login failure count. */
    private String loginFailureCount;

    /** The is user locked. */
    private String isUserLocked;

    /** The last login time. */
    private String lastLoginTime;

    /** The session id. */
    private String sessionId;

    /** The orcid id. */
    private String orcidID;

    /** The ec id. */
    private String ecId;

    /** The user vo. */
    private String userVO;
    /** The isAccountVerified. */
    private Character isAccountVerified;

    /**
     * Gets the user id.
     *
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId            the userId to set
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * Gets the primary email address.
     *
     * @return the primaryEmailAddress
     */
    public final String getPrimaryEmailAddress() {
        return primaryEmailAddress;
    }

    /**
     * Sets the primary email address.
     *
     * @param primaryEmailAddress            the primaryEmailAddress to set
     */
    public final void setPrimaryEmailAddress(final String primaryEmailAddress) {
        this.primaryEmailAddress = primaryEmailAddress;
    }

    /**
     * Gets the secondary email address.
     *
     * @return the secondaryEmailAddress
     */
    public final String getSecondaryEmailAddress() {
        return secondaryEmailAddress;
    }

    /**
     * Sets the secondary email address.
     *
     * @param secondaryEmailAddress            the secondaryEmailAddress to set
     */
    public final void setSecondaryEmailAddress(
            final String secondaryEmailAddress) {
        this.secondaryEmailAddress = secondaryEmailAddress;
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
     * @param password            the password to set
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets the security vo.
     *
     * @return the securityVO
     */
    public final String getSecurityVO() {
        return securityVO;
    }

    /**
     * Sets the security vo.
     *
     * @param securityVO            the securityVO to set
     */
    public final void setSecurityVO(final String securityVO) {
        this.securityVO = securityVO;
    }

    /**
     * Gets the checks if is security setup.
     *
     * @return the isSecuritySetup
     */
    public final String getIsSecuritySetup() {
        return isSecuritySetup;
    }

    /**
     * Sets the checks if is security setup.
     *
     * @param isSecuritySetup            the isSecuritySetup to set
     */
    public final void setIsSecuritySetup(final String isSecuritySetup) {
        this.isSecuritySetup = isSecuritySetup;
    }

    /**
     * Gets the login failure count.
     *
     * @return the loginFailureCount
     */
    public final String getLoginFailureCount() {
        return loginFailureCount;
    }

    /**
     * Sets the login failure count.
     *
     * @param loginFailureCount            the loginFailureCount to set
     */
    public final void setLoginFailureCount(final String loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    /**
     * Gets the checks if is user locked.
     *
     * @return the isUserLocked
     */
    public final String getIsUserLocked() {
        return isUserLocked;
    }

    /**
     * Sets the checks if is user locked.
     *
     * @param isUserLocked            the isUserLocked to set
     */
    public final void setIsUserLocked(final String isUserLocked) {
        this.isUserLocked = isUserLocked;
    }

    /**
     * Gets the last login time.
     *
     * @return the lastLoginTime
     */
    public final String getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * Sets the last login time.
     *
     * @param lastLoginTime            the lastLoginTime to set
     */
    public final void setLastLoginTime(final String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * Gets the session id.
     *
     * @return the sessionId
     */
    public final String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the session id.
     *
     * @param sessionId            the sessionId to set
     */
    public final void setSessionId(final String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * Gets the orcid id.
     *
     * @return the orcidID
     */
    public final String getOrcidID() {
        return orcidID;
    }

    /**
     * Sets the orcid id.
     *
     * @param orcidID            the orcidID to set
     */
    public final void setOrcidID(final String orcidID) {
        this.orcidID = orcidID;
    }

    /**
     * Gets the ec id.
     *
     * @return the ecId
     */
    public final String getEcId() {
        return ecId;
    }

    /**
     * Sets the ec id.
     *
     * @param ecId            the ecId to set
     */
    public final void setEcId(final String ecId) {
        this.ecId = ecId;
    }

    /**
     * Gets the user vo.
     *
     * @return the userVO
     */
    public final String getUserVO() {
        return userVO;
    }

    /**
     * Sets the user vo.
     *
     * @param userVO            the userVO to set
     */
    public final void setUserVO(final String userVO) {
        this.userVO = userVO;
    }

    /**
     * Gets the checks if is account verified.
     *
     * @return the isAccountVerified
     */
    public final Character getIsAccountVerified() {
        return isAccountVerified;
    }

    /**
     * Sets the checks if is account verified.
     *
     * @param isAccountVerified            the isAccountVerified to set
     */
    public final void setIsAccountVerified(final Character isAccountVerified) {
        this.isAccountVerified = isAccountVerified;
    }

}
