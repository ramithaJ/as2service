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
 * The Class AuthorsData.
 */
public class AuthorsData {
    
    /** The author id. */
    private List<String> authorId;

    /**
     * Gets the author id.
     *
     * @return the author id
     */
    public final List<String> getAuthorId() {
        return authorId;
    }

    /**
     * Sets the author id.
     *
     * @param authorId the new author id
     */
    public final void setAuthorId(final List<String> authorId) {
        this.authorId = authorId;
    }
    
}
