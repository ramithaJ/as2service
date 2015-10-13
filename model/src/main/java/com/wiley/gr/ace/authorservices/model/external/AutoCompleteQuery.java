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
public class AutoCompleteQuery {

    /**
     * This field holds the value of field.
     */
    private String field;

    /**
     * This field holds the value of value.
     */
    private String value;

    /**
     * @return the field
     */
    public final String getField() {
        return field;
    }

    /**
     * @param field
     *            the field to set
     */
    public final void setField(final String field) {
        this.field = field;
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

}
