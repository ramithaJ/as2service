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

public class UltimateParentData {
    private String id;

    private SecondaryIds secondaryIds;

    private String uri;

    public final String getId() {
        return id;
    }

    public final SecondaryIds getSecondaryIds() {
        return secondaryIds;
    }

    public final String getUri() {
        return uri;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final void setSecondaryIds(final SecondaryIds secondaryIds) {
        this.secondaryIds = secondaryIds;
    }

    public final void setUri(final String uri) {
        this.uri = uri;
    }
    
}



