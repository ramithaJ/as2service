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
package com.wiley.gr.ace.authorservices.persistence.services;

import com.wiley.gr.ace.authorservices.persistence.entity.JournalConfiguration;

/**
 * The Interface JournalInfoDAO.
 *
 * @author virtusa version 1.0
 */
public interface SaveJournalInfoDAO {

    /**
     * Gets the journal id.
     *
     * @param dhId
     *            the dh id
     * @return the journal id
     */
    Integer getJournalId(String dhId);

    /**
     * Save journal info.
     *
     * @param journalConfiguration
     *            the journal configuration
     * @return true, if successful
     */
    boolean saveJournalInfo(JournalConfiguration journalConfiguration);
}
