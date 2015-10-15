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

import java.util.List;

/**
 * The Class AddressMapper.
 * 
 * @author virtusa version 1.0
 */
public class AddressMapper {

    /** The content. */
    private List<ParticipantAddress> content;

    /**
     * Gets the content.
     *
     * @return the content
     */
    public final List<ParticipantAddress> getContent() {
        return content;
    }

    /**
     * Sets the content.
     *
     * @param content
     *            the new content
     */
    public final void setContent(final List<ParticipantAddress> content) {
        this.content = content;
    }

}
