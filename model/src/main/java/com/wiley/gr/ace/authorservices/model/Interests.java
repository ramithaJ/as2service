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
     * @return the aoeId
     */
    public final String getAoeId() {
        return aoeId;
    }

    /**
     * @param aoeId
     *            the aoeId to set
     */
    public final void setAoeId(final String aoeId) {
        this.aoeId = aoeId;
    }

    /**
     * @return the aoeCategory
     */
    public final String getAoeCategory() {
        return aoeCategory;
    }

    /**
     * @param aoeCategory
     *            the aoeCategory to set
     */
    public final void setAoeCategory(final String aoeCategory) {
        this.aoeCategory = aoeCategory;
    }

    /**
     * @return the aoeName
     */
    public final String getAoeName() {
        return aoeName;
    }

    /**
     * @param aoeName
     *            the aoeName to set
     */
    public final void setAoeName(final String aoeName) {
        this.aoeName = aoeName;
    }

}
