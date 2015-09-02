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
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class JournalData.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class JournalData {

    /** The dh id. */
    @JsonProperty("DH_ID")
    private String dhId;

    /** The journal title. */
    private String journalTitle;

    public final String getDhId() {
        return dhId;
    }

    public final void setDhId(final String dhId) {
        this.dhId = dhId;
    }

    public final String getJournalTitle() {
        return journalTitle;
    }

    public final void setJournalTitle(final String journalTitle) {
        this.journalTitle = journalTitle;
    }

}
