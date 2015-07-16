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
import com.wiley.gr.ace.authorservices.model.external.TaskServiceRequest;

/**
 * The Interface BPMInterfaceService.
 *
 * @author virtusa version 1.0
 */
public interface TaskService {

    /**
     * Creates the task.
     *
     * @return true, if successful
     */
    boolean createTask();

    /**
     * Finish task.
     *
     * @param associationConfirmation
     *            the association confirmation
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    boolean finishTask(AssociationConfirmation associationConfirmation)
            throws Exception;

    /**
     * Invoke task service.
     *
     * @param taskServiceRequest the task service request
     * @param userId the user id
     * @return status
     */
    String invokeTaskService(TaskServiceRequest taskServiceRequest,
            String userId);

}
