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

import java.util.List;

/**
 * @author Virtusa version1.0
 *
 */
public class RequestAdminAccess {

    /**
     * This field holds the value of accessList.
     */
    private List<String> accessList;

    /**
     * @return the accessList
     */
    public final List<String> getAccessList() {
        return accessList;
    }

    /**
     * @param accessList
     *            the accessList to set
     */
    public final void setAccessList(final List<String> accessList) {
        this.accessList = accessList;
    }

}
