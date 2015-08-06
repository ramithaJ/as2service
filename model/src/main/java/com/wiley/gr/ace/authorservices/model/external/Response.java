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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The Class Response.
 * 
 * @author virtusa version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    /** The docs. */
    private List<Object> docs;

    /**
     * Gets the docs.
     *
     * @return the docs
     */
    public final List<Object> getDocs() {
        return docs;
    }

    /**
     * Sets the docs.
     *
     * @param docs
     *            the docs to set
     */
    public final void setDocs(final List<Object> docs) {
        this.docs = docs;
    }
}
