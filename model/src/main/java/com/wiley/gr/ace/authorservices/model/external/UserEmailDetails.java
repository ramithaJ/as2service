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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Virtusa version1.0
 *
 */
public class UserEmailDetails {

    /**
     * This field holds the value of updateUserSecurityAttributes
     */
    @JsonProperty("UpdateUserSecurityAttributes")
    private UserSecurityAttributes updateUserSecurityAttributes;

    /**
     * @return the updateUserSecurityAttributes
     */
    public final UserSecurityAttributes getUpdateUserSecurityAttributes() {
        return updateUserSecurityAttributes;
    }

    /**
     * @param updateUserSecurityAttributes
     *            the updateUserSecurityAttributes to set
     */
    public final void setUpdateUserSecurityAttributes(
            final UserSecurityAttributes updateUserSecurityAttributes) {
        this.updateUserSecurityAttributes = updateUserSecurityAttributes;
    }

}
