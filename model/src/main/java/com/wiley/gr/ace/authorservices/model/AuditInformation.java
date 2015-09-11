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
 * @author Virtusa version1.0
 *
 */
public class AuditInformation {

    /**
     * This field holds the value of userId
     */
    private int userId;
    /**
     * This field holds the value of tableName
     */
    private String tableName;

    /**
     * This field holds the value of columnName
     */
    private String columnName;

    /**
     * This field holds the value of oldValue
     */
    private String oldValue;

    /**
     * This field holds the value of newValue
     */
    private String newValue;

    /**
     * This field holds the value of sctionID
     */
    private String actionID;

    /**
     * @return the userId
     */
    public final int getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final int userId) {
        this.userId = userId;
    }

    /**
     * @return the tableName
     */
    public final String getTableName() {
        return tableName;
    }

    /**
     * @param tableName
     *            the tableName to set
     */
    public final void setTableName(final String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the columnName
     */
    public final String getColumnName() {
        return columnName;
    }

    /**
     * @param columnName
     *            the columnName to set
     */
    public final void setColumnName(final String columnName) {
        this.columnName = columnName;
    }

    /**
     * @return the oldValue
     */
    public final String getOldValue() {
        return oldValue;
    }

    /**
     * @param oldValue
     *            the oldValue to set
     */
    public final void setOldValue(final String oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * @return the newValue
     */
    public final String getNewValue() {
        return newValue;
    }

    /**
     * @param newValue
     *            the newValue to set
     */
    public final void setNewValue(final String newValue) {
        this.newValue = newValue;
    }

    /**
     * @return the actionID
     */
    public final String getActionID() {
        return actionID;
    }

    /**
     * @param actionID
     *            the actionID to set
     */
    public final void setActionID(final String actionID) {
        this.actionID = actionID;
    }
}
