/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version 1.0
 *
 */
public class ProfileEntity {

    /**
     * This field holds the value of entityType.
     */
    private String entityType;

    /**
     * This field holds the value of entityValue.
     */
    private EntityValue entityValue;

    /**
     * This field holds the value of sourceSystem.
     */
    private String sourceSystem;

    /**
     * This field holds the value of entityId.
     */
    private String entityId;

    /**
     * @return the entityType
     */
    public final String getEntityType() {
        return entityType;
    }

    /**
     * @param entityType
     *            the entityType to set
     */
    public final void setEntityType(final String entityType) {
        this.entityType = entityType;
    }

    /**
     * @return the entityValue
     */
    public final EntityValue getEntityValue() {
        return entityValue;
    }

    /**
     * @param entityValue
     *            the entityValue to set
     */
    public final void setEntityValue(final EntityValue entityValue) {
        this.entityValue = entityValue;
    }

    /**
     * @return the sourceSystem
     */
    public final String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * @param sourceSystem
     *            the sourceSystem to set
     */
    public final void setSourceSystem(final String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    /**
     * @return the entityId
     */
    public final String getEntityId() {
        return entityId;
    }

    /**
     * @param entityId
     *            the entityId to set
     */
    public final void setEntityId(final String entityId) {
        this.entityId = entityId;
    }

}
