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
 * @author virtusa
 *	version 1.0
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
     * Gets the isAccountVerified.
     *
     * @return the isAccountVerified
     */
    public Character getIsAccountVerified() {
        return isAccountVerified;
    }
    
    /**
     * Sets the isAccountVerified.
     *
     * @param isAccountVerifed
     */
    public void setIsAccountVerified(Character isAccountVerified) {
        this.isAccountVerified = isAccountVerified;
    }
    
    /**
     * Gets the orcid id.
     *
     * @return the orcid id
     */
    public String getOrcidID() {
        return orcidID;
    }
    
    /**
     * Sets the orcid id.
     *
     * @param orcidID
     *            the new orcid id
     */
    public void setOrcidID(String orcidID) {
        this.orcidID = orcidID;
    }
    
    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * Sets the user id.
     *
     * @param userId
     *            the new user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * Gets the primary email address.
     *
     * @return the primary email address
     */
    public String getPrimaryEmailAddress() {
        return primaryEmailAddress;
    }
    
    /**
     * Sets the primary email address.
     *
     * @param primaryEmailAddress
     *            the new primary email address
     */
    public void setPrimaryEmailAddress(String primaryEmailAddress) {
        this.primaryEmailAddress = primaryEmailAddress;
    }
    
    /**
     * Gets the secondary email address.
     *
     * @return the secondary email address
     */
    public String getSecondaryEmailAddress() {
        return secondaryEmailAddress;
    }
    
    /**
     * Sets the secondary email address.
     *
     * @param secondaryEmailAddress
     *            the new secondary email address
     */
    public void setSecondaryEmailAddress(String secondaryEmailAddress) {
        this.secondaryEmailAddress = secondaryEmailAddress;
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
     * Gets the security vo.
     *
     * @return the security vo
     */
    public String getSecurityVO() {
        return securityVO;
    }
    
    /**
     * Sets the security vo.
     *
     * @param securityVO
     *            the new security vo
     */
    public void setSecurityVO(String securityVO) {
        this.securityVO = securityVO;
    }
    
    /**
     * Gets the checks if is security setup.
     *
     * @return the checks if is security setup
     */
    public String getIsSecuritySetup() {
        return isSecuritySetup;
    }
    
    /**
     * Sets the checks if is security setup.
     *
     * @param isSecuritySetup
     *            the new checks if is security setup
     */
    public void setIsSecuritySetup(String isSecuritySetup) {
        this.isSecuritySetup = isSecuritySetup;
    }
    
    /**
     * Gets the login failure count.
     *
     * @return the login failure count
     */
    public String getLoginFailureCount() {
        return loginFailureCount;
    }
    
    /**
     * Sets the login failure count.
     *
     * @param loginFailureCount
     *            the new login failure count
     */
    public void setLoginFailureCount(String loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }
    
    /**
     * Gets the checks if is user locked.
     *
     * @return the checks if is user locked
     */
    public String getIsUserLocked() {
        return isUserLocked;
    }
    
    /**
     * Sets the checks if is user locked.
     *
     * @param isUserLocked
     *            the new checks if is user locked
     */
    public void setIsUserLocked(String isUserLocked) {
        this.isUserLocked = isUserLocked;
    }
    
    /**
     * Gets the last login time.
     *
     * @return the last login time
     */
    public String getLastLoginTime() {
        return lastLoginTime;
    }
    
    /**
     * Sets the last login time.
     *
     * @param lastLoginTime
     *            the new last login time
     */
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    /**
     * Gets the session id.
     *
     * @return the session id
     */
    public String getSessionId() {
        return sessionId;
    }
    
    /**
     * Sets the session id.
     *
     * @param sessionId
     *            the new session id
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    
    /**
     * Gets the ec id.
     *
     * @return the ec id
     */
    public String getEcId() {
        return ecId;
    }
    
    /**
     * Sets the ec id.
     *
     * @param ecId
     *            the new ec id
     */
    public void setEcId(String ecId) {
        this.ecId = ecId;
    }
    
    /**
     * Gets the user vo.
     *
     * @return the user vo
     */
    public String getUserVO() {
        return userVO;
    }
    
    /**
     * Sets the user vo.
     *
     * @param userVO
     *            the new user vo
     */
    public void setUserVO(String userVO) {
        this.userVO = userVO;
    }
    
}
