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

/**
 * @author Virtusa version1.0
 *
 */
public class UserSecurityQuestionsEntry {

    /**
     * This field holds the value of key
     */
    private String key;

    /**
     * This field holds the value of text
     */
    private String text;

    /**
     * @return the key
     */
    public final String getKey() {
        return key;
    }

    /**
     * @param key
     *            the key to set
     */
    public final void setKey(final String key) {
        this.key = key;
    }

    /**
     * @return the text
     */
    public final String getText() {
        return text;
    }

    /**
     * @param text
     *            the text to set
     */
    public final void setText(final String text) {
        this.text = text;
    }

}
