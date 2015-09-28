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
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * @return the primaryEmailAddress
     */
    public final String getPrimaryEmailAddress() {
        return primaryEmailAddress;
    }

    /**
     * @param primaryEmailAddress
     *            the primaryEmailAddress to set
     */
    public final void setPrimaryEmailAddress(final String primaryEmailAddress) {
        this.primaryEmailAddress = primaryEmailAddress;
    }

    /**
     * @return the secondaryEmailAddress
     */
    public final String getSecondaryEmailAddress() {
        return secondaryEmailAddress;
    }

    /**
     * @param secondaryEmailAddress
     *            the secondaryEmailAddress to set
     */
    public final void setSecondaryEmailAddress(
            final String secondaryEmailAddress) {
        this.secondaryEmailAddress = secondaryEmailAddress;
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
     * @return the securityVO
     */
    public final String getSecurityVO() {
        return securityVO;
    }

    /**
     * @param securityVO
     *            the securityVO to set
     */
    public final void setSecurityVO(final String securityVO) {
        this.securityVO = securityVO;
    }

    /**
     * @return the isSecuritySetup
     */
    public final String getIsSecuritySetup() {
        return isSecuritySetup;
    }

    /**
     * @param isSecuritySetup
     *            the isSecuritySetup to set
     */
    public final void setIsSecuritySetup(final String isSecuritySetup) {
        this.isSecuritySetup = isSecuritySetup;
    }

    /**
     * @return the loginFailureCount
     */
    public final String getLoginFailureCount() {
        return loginFailureCount;
    }

    /**
     * @param loginFailureCount
     *            the loginFailureCount to set
     */
    public final void setLoginFailureCount(final String loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    /**
     * @return the isUserLocked
     */
    public final String getIsUserLocked() {
        return isUserLocked;
    }

    /**
     * @param isUserLocked
     *            the isUserLocked to set
     */
    public final void setIsUserLocked(final String isUserLocked) {
        this.isUserLocked = isUserLocked;
    }

    /**
     * @return the lastLoginTime
     */
    public final String getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     *            the lastLoginTime to set
     */
    public final void setLastLoginTime(final String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return the sessionId
     */
    public final String getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId
     *            the sessionId to set
     */
    public final void setSessionId(final String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return the orcidID
     */
    public final String getOrcidID() {
        return orcidID;
    }

    /**
     * @param orcidID
     *            the orcidID to set
     */
    public final void setOrcidID(final String orcidID) {
        this.orcidID = orcidID;
    }

    /**
     * @return the ecId
     */
    public final String getEcId() {
        return ecId;
    }

    /**
     * @param ecId
     *            the ecId to set
     */
    public final void setEcId(final String ecId) {
        this.ecId = ecId;
    }

    /**
     * @return the userVO
     */
    public final String getUserVO() {
        return userVO;
    }

    /**
     * @param userVO
     *            the userVO to set
     */
    public final void setUserVO(final String userVO) {
        this.userVO = userVO;
    }

    /**
     * @return the isAccountVerified
     */
    public final Character getIsAccountVerified() {
        return isAccountVerified;
    }

    /**
     * @param isAccountVerified
     *            the isAccountVerified to set
     */
    public final void setIsAccountVerified(final Character isAccountVerified) {
        this.isAccountVerified = isAccountVerified;
    }

}
