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

import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.LicenseStatus;
import com.wiley.gr.ace.authorservices.model.external.TaskServiceRequest;

/**
 * The Interface BPMInterfaceService.
 *
 * @author virtusa version 1.0
 */
public interface TaskService {

    /**
     * Finish task.
     *
     * @param associationConfirmation
     *            the association confirmation
     * @return true, if successful
     */
    boolean finishTask(AssociationConfirmation associationConfirmation);

    /**
     * Invoke task service.
     *
     * @param taskServiceRequest
     *            the task service request
     * @param userId
     *            the user id
     * @return status
     */
    String invokeTaskService(TaskServiceRequest taskServiceRequest,
            String userId);

    /**
     * Gets the license status.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @return the license status
     */
    LicenseStatus getLicenseStatus(String dhId, String userId);

}
