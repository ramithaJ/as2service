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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class UserSecurityQuestionsMap.
 *
 * @author Virtusa version1.0
 */
public class UserSecurityQuestionsMap {

    /** This field holds the value of entry. */
    private List<UserSecurityQuestionsEntry> entry = new ArrayList<UserSecurityQuestionsEntry>();

    /**
     * Gets the entry.
     *
     * @return the entry
     */
    public final List<UserSecurityQuestionsEntry> getEntry() {
        return entry;
    }

    /**
     * Sets the entry.
     *
     * @param entry            the entry to set
     */
    public final void setEntry(final List<UserSecurityQuestionsEntry> entry) {
        this.entry = entry;
    }

}
