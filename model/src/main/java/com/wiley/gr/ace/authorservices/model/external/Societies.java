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
package com.wiley.gr.ace.authorservices.model.external;

public class Societies {

    /**
     * This field holds the value of societyId
     */
    private String societyId;

    /**
     * This field holds the value of value
     */
    private String value;

    /**
     * This field holds the value of valueType
     */
    private String valueType;

    /**
     * This field holds the value of societyName
     */
    private String societyName;

    /**
     * @return the societyId
     */
    public final String getSocietyId() {
        return societyId;
    }

    /**
     * @param societyId
     *            the societyId to set
     */
    public final void setSocietyId(final String societyId) {
        this.societyId = societyId;
    }

    /**
     * @return the value
     */
    public final String getValue() {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public final void setValue(final String value) {
        this.value = value;
    }

    /**
     * @return the valueType
     */
    public final String getValueType() {
        return valueType;
    }

    /**
     * @param valueType
     *            the valueType to set
     */
    public final void setValueType(final String valueType) {
        this.valueType = valueType;
    }

    /**
     * @return the societyName
     */
    public final String getSocietyName() {
        return societyName;
    }

    /**
     * @param societyName
     *            the societyName to set
     */
    public final void setSocietyName(final String societyName) {
        this.societyName = societyName;
    }

}
