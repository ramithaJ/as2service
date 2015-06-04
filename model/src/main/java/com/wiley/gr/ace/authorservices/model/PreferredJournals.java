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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author virtusa
 *	version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class PreferredJournals {
    
    private String journalId;
    
    private String journalTitle;
    
    /**
     * @return
     */
    public String getJournalId() {
        return journalId;
    }
    
    /**
     * @param journalId
     */
    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }
    
    /**
     * @return
     */
    public String getJournalTitle() {
        return journalTitle;
    }
    
    /**
     * @param journalTitle
     */
    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }
    
}
