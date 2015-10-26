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

/**
 * @author virtusa version1.0
 *
 */
public class ALMCreateUser {

    @JsonProperty("CreateUserAttributes")
    private ALMUser almUser;

    public final ALMUser getAlmUser() {
        return almUser;
    }

    public final void setAlmUser(final ALMUser almUser) {
        this.almUser = almUser;
    }

}
