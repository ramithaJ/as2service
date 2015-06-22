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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author virtusa
 *
 */
@JsonInclude(Include.NON_NULL)
public class Article {

    private String journalPrintISSN;

    private String articleID;

    private String journalElectronicISSN;

    public String getJournalPrintISSN() {
        return journalPrintISSN;
    }

    public void setJournalPrintISSN(String journalPrintISSN) {
        this.journalPrintISSN = journalPrintISSN;
    }

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public String getJournalElectronicISSN() {
        return journalElectronicISSN;
    }

    public void setJournalElectronicISSN(String journalElectronicISSN) {
        this.journalElectronicISSN = journalElectronicISSN;
    }
}
