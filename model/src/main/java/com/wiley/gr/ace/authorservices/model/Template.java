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
package com.wiley.gr.ace.authorservices.model;

/**
 * The Class Template.
 *
 * @author virtusa version 1.0
 */
public class Template {

    /** The id. */
    private String id;

    /** The body. */
    private String body;

    /** The tagl2. */
    private String tagl2;

    /** The app id. */
    private String appId;

    /** The description. */
    private String description;

    /** The tagl1. */
    private String tagl1;

    /**
     * This field holds the value of createdBy
     */
    private String createdBy;

    /**
     * This field holds the value of modifiedBy
     */
    private String modifiedBy;

    /**
     * This field holds the value of createdOn
     */
    private String createdOn;

    /**
     * This field holds the value of lastModifiedOn
     */
    private String lastModifiedOn;

    /**
     * @return the createdBy
     */
    public final String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     *            the createdBy to set
     */
    public final void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the modifiedBy
     */
    public final String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy
     *            the modifiedBy to set
     */
    public final void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the createdOn
     */
    public final String getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn
     *            the createdOn to set
     */
    public final void setCreatedOn(final String createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the lastModifiedOn
     */
    public final String getLastModifiedOn() {
        return lastModifiedOn;
    }

    /**
     * @param lastModifiedOn
     *            the lastModifiedOn to set
     */
    public final void setLastModifiedOn(final String lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the body.
     *
     * @return the body
     */
    public final String getBody() {
        return body;
    }

    /**
     * Sets the body.
     *
     * @param body
     *            the new body
     */
    public final void setBody(final String body) {
        this.body = body;
    }

    /**
     * Gets the tagl2.
     *
     * @return the tagl2
     */
    public final String getTagl2() {
        return tagl2;
    }

    /**
     * Sets the tagl2.
     *
     * @param tagl2
     *            the new tagl2
     */
    public final void setTagl2(final String tagl2) {
        this.tagl2 = tagl2;
    }

    /**
     * Gets the app id.
     *
     * @return the app id
     */
    public final String getAppId() {
        return appId;
    }

    /**
     * Sets the app id.
     *
     * @param appId
     *            the new app id
     */
    public final void setAppId(final String appId) {
        this.appId = appId;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description
     *            the new description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Gets the tagl1.
     *
     * @return the tagl1
     */
    public String getTagl1() {
        return tagl1;
    }

    /**
     * Sets the tagl1.
     *
     * @param tagl1
     *            the new tagl1
     */
    public void setTagl1(final String tagl1) {
        this.tagl1 = tagl1;
    }
}
