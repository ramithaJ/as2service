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

import java.util.List;

/**
 * @author virtusa version 1.0
 *
 */
public class AutocompleteResponse {

    /**
     * This field holds the value of total.
     */
    private String total;

    /**
     * This field holds the value of suggestions.
     */
    private List<String> suggestions;

    /**
     * @return the total
     */
    public final String getTotal() {
        return total;
    }

    /**
     * @param total
     *            the total to set
     */
    public final void setTotal(final String total) {
        this.total = total;
    }

    /**
     * @return the suggestions
     */
    public final List<String> getSuggestions() {
        return suggestions;
    }

    /**
     * @param suggestions
     *            the suggestions to set
     */
    public final void setSuggestions(final List<String> suggestions) {
        this.suggestions = suggestions;
    }

}
