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
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * The Class Preferences.
 */
public class Preferences {

    /** The preference key. */
    private String preferenceKey;

    /** The preference value. */
    private List<String> preferenceValue;

    /**
     * Gets the preference key.
     *
     * @return the preference key
     */
    public final String getPreferenceKey() {
        return preferenceKey;
    }

    /**
     * Sets the preference key.
     *
     * @param preferenceKey
     *            the new preference key
     */
    public final void setPreferenceKey(final String preferenceKey) {
        this.preferenceKey = preferenceKey;
    }

    /**
     * Gets the preference value.
     *
     * @return the preference value
     */
    public final List<String> getPreferenceValue() {
        return preferenceValue;
    }

    /**
     * Sets the preference value.
     *
     * @param preferenceValue
     *            the new preference value
     */
    public final void setPreferenceValue(final List<String> preferenceValue) {
        this.preferenceValue = preferenceValue;
    }

}
