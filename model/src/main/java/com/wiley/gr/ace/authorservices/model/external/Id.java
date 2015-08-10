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

import com.fasterxml.jackson.annotation.JsonProperty;

public class Id {
    @JsonProperty("_content_")
    private String  content;

    private String type;

    public final String getContent() {
        return content;
    }

    public final String getType() {
        return type;
    }

    public final void setContent(final String content) {
        this.content = content;
    }

    public final void setType(final String type) {
        this.type = type;
    }
    
}



