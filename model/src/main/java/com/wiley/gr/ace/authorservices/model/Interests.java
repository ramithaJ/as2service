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
 * The Class Interests.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Interests {

    /** The user Id . */
    private String userId;

    /** The aoe id. */
    private String aoeId;

    /** The aoe category. */
    private String aoeCategory;

    /** The aoe name. */
    private String aoeName;

    /**
     * Gets the user Id.
     *
     * @return the user Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user Id.
     *
     * @param userId
     *            the new user id
     * @return the user Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the aoe id.
     *
     * @return the aoe id
     */
    public String getAoeId() {
        return aoeId;
    }

    /**
     * Sets the aoe id.
     *
     * @param aoeId
     *            the new aoe id
     */
    public void setAoeId(String aoeId) {
        this.aoeId = aoeId;
    }

    /**
     * Gets the aoe category.
     *
     * @return the aoe category
     */
    public String getAoeCategory() {
        return aoeCategory;
    }

    /**
     * Sets the aoe category.
     *
     * @param aoeCategory
     *            the new aoe category
     */
    public void setAoeCategory(String aoeCategory) {
        this.aoeCategory = aoeCategory;
    }

    /**
     * Gets the aoe name.
     *
     * @return the aoe name
     */
    public String getAoeName() {
        return aoeName;
    }

    /**
     * Sets the aoe name.
     *
     * @param aoeName
     *            the new aoe name
     */
    public void setAoeName(String aoeName) {
        this.aoeName = aoeName;
    }

}
