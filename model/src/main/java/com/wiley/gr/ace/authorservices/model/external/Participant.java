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

/**
 * The Class Participant.
 */
public class Participant {

    /** The user id. */
    private String userId;

    /** The personid. */
    private String personid;

    /** The user name. */
    private String userName;

    /** The name. */
    private String name;

    /** The given name. */
    private String givenName;

    /** The family name. */
    private String familyName;

    /** The participant country. */
    private String participantCountry;

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the new user id
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * Gets the personid.
     *
     * @return the personid
     */
    public final String getPersonid() {
        return personid;
    }

    /**
     * Sets the personid.
     *
     * @param personid
     *            the new personid
     */
    public final void setPersonid(final String personid) {
        this.personid = personid;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public final String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName
     *            the new user name
     */
    public final void setUserName(final String userName) {
        this.userName = userName;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the new name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the given name.
     *
     * @return the given name
     */
    public final String getGivenName() {
        return givenName;
    }

    /**
     * Sets the given name.
     *
     * @param givenName
     *            the new given name
     */
    public final void setGivenName(final String givenName) {
        this.givenName = givenName;
    }

    /**
     * Gets the family name.
     *
     * @return the family name
     */
    public final String getFamilyName() {
        return familyName;
    }

    /**
     * Sets the family name.
     *
     * @param familyName
     *            the new family name
     */
    public final void setFamilyName(final String familyName) {
        this.familyName = familyName;
    }

    /**
     * Gets the participant country.
     *
     * @return the participant country
     */
    public final String getParticipantCountry() {
        return participantCountry;
    }

    /**
     * Sets the participant country.
     *
     * @param participantCountry
     *            the new participant country
     */
    public final void setParticipantCountry(final String participantCountry) {
        this.participantCountry = participantCountry;
    }
}
