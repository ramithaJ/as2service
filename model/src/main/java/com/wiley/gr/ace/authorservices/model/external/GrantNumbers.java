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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Virtusa version1.0
 *
 */
public class GrantNumbers {

    @JsonProperty("GrantNo")
    private List<String> grantNo;

    /**
     * @return the grantNo
     */
    public final List<String> getGrantNo() {
        return grantNo;
    }

    /**
     * @param grantNo
     *            the grantNo to set
     */
    public final void setGrantNo(final List<String> grantNo) {
        this.grantNo = grantNo;
    }

}
