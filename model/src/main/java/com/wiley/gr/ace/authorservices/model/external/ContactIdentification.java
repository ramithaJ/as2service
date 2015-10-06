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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ContactIdentification.
 */
public class ContactIdentification {

    /** The source contact xref. */
    @JsonProperty("SourceContactXREF")
    private SourceContactXREF sourceContactXREF;

    /**
     * Gets the source contact xref.
     *
     * @return the source contact xref
     */
    public final SourceContactXREF getSourceContactXREF() {
        return sourceContactXREF;
    }

    /**
     * Sets the source contact xref.
     *
     * @param sourceContactXREF
     *            the new source contact xref
     */
    public final void setSourceContactXREF(
            final SourceContactXREF sourceContactXREF) {
        this.sourceContactXREF = sourceContactXREF;
    }
}
