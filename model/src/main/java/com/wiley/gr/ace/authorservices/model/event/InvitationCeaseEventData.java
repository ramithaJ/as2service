package com.wiley.gr.ace.authorservices.model.event;

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
 * The Class InvitationCeaseEventData.
 * 
 * @author virtusa version 1.0
 */
public class InvitationCeaseEventData {

    /** The article id. */
    private String articleID;

    /** The email. */
    private String email;

    /** The user role. */
    private String userRole;

    /** The user id. */
    private String userID;

    /** The persistent invitation ind. */
    private boolean persistentInvitationInd;

    /**
     * Gets the article id.
     *
     * @return the article id
     */
    public final String getArticleID() {
        return articleID;
    }

    /**
     * Sets the article id.
     *
     * @param articleID
     *            the new article id
     */
    public final void setArticleID(final String articleID) {
        this.articleID = articleID;
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
     * Gets the user role.
     *
     * @return the user role
     */
    public final String getUserRole() {
        return userRole;
    }

    /**
     * Sets the user role.
     *
     * @param userRole
     *            the new user role
     */
    public final void setUserRole(final String userRole) {
        this.userRole = userRole;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public final String getUserID() {
        return userID;
    }

    /**
     * Sets the user id.
     *
     * @param userID
     *            the new user id
     */
    public final void setUserID(final String userID) {
        this.userID = userID;
    }

    /**
     * Gets the persistent invitation ind.
     *
     * @return the persistent invitation ind
     */
    public final boolean getPersistentInvitationInd() {
        return persistentInvitationInd;
    }

    /**
     * Sets the persistent invitation ind.
     *
     * @param persistentInvitationInd
     *            the new persistent invitation ind
     */
    public final void setPersistentInvitationInd(
            final boolean persistentInvitationInd) {
        this.persistentInvitationInd = persistentInvitationInd;
    }
}
