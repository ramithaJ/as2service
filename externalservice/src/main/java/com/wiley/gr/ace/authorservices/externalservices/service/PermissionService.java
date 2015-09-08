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
package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.external.AdditionalPermissions;

/**
 * The Class BPMInterfaceServiceImpl.
 *
 * @author virtusa version 1.0
 * @author virtusa version1.0
 *
 */
public interface PermissionService {

    /**
     * This method used to createTask.
     *
     * @return true, if successful
     */
    @Override
    public final boolean createTask() {
        // TODO Auto-generated method stub
        return true;
    }

	/**
	 * @param userId
	 * @return AdditionalPermissions
	 */
	AdditionalPermissions getAdditionalPermissions(String userId);
}
