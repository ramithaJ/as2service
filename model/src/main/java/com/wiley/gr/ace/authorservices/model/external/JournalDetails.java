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

/**
 * @author yugandhark
 *
 */
public class JournalDetails {
    private Integer journalId;

    private String journalName;

    public Integer getJournalId ()
    {
        return journalId;
    }

    public void setJournalId (Integer journalId)
    {
        this.journalId = journalId;
    }

    public String getJournalName ()
    {
        return journalName;
    }

    public void setJournalName (String journalName)
    {
        this.journalName = journalName;
    }
}
