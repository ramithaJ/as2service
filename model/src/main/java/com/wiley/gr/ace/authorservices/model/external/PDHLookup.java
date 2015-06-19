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
 * @author virtusa version 1.0
 *
 */
public class PDHLookup {

    private String journalId;
    
    private String title;
    
    private String pdmSalesModel;

    public final String getJournalId() {
        return journalId;
    }

    public final void setJournalId(final String journalId) {
        this.journalId = journalId;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String getPdmSalesModel() {
        return pdmSalesModel;
    }

    public final void setPdmSalesModel(final String pdmSalesModel) {
        this.pdmSalesModel = pdmSalesModel;
    }
    
    
}
