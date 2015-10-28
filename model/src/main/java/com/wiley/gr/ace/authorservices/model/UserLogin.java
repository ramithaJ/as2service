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
package com.wiley.gr.ace.authorservices.model;

/**
 * The Class UserLogin.
 *
 * @author virtusa version1.0
 */
public class UserLogin {

    /** This field holds the value of userId. */
    private String userId;

    /** This field holds the value of firstName. */
    private String firstName;

    /** This field holds the value of lastName. */
    private String lastName;

    /** The alm user id. */
    private String almUserId;

    /** The orcid id. */
    private String orcidId;

    private String participantId;

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
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * Gets the first name.
     *
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the firstName to set
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the lastName
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the lastName to set
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
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
     * @param almUserId
     *            the new alm user id
     */
    public void setAlmUserId(final String almUserId) {
        this.almUserId = almUserId;
    }

    /**
     * Gets the orcid id.
     *
     * @return the orcid id
     */
    public String getOrcidId() {
        return orcidId;
    }

    /**
     * Sets the orcid id.
     *
     * @param orcidId
     *            the new orcid id
     */
    public void setOrcidId(final String orcidId) {
        this.orcidId = orcidId;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(final String participantId) {
        this.participantId = participantId;
    }

}
