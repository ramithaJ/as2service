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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.Service;

/**
 * The Class BPMInterfaceServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class BPMInterfaceServiceImpl implements BPMInterfaceService {

    @Override
    public boolean createTask() {
        // TODO Auto-generated method stub
        return true;
    }

    /**
     * Finish task.
     *
     * @param associationConfirmation
     *            the association confirmation
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean finishTask(
            final AssociationConfirmation associationConfirmation)
            throws Exception {
        final String url = "http://demo7930138.mockable.io/rest/bpm/wle/v1/task/"
                + associationConfirmation.getTaskId()
                + "55?action="
                + associationConfirmation.isAssociationConfirmed()
                + "&parts=all";
        final Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.PUT, Service.class);
        final String status = service.getStatus();
        if (null != status && status.equalsIgnoreCase("SUCCESS")) {
            return true;
        }
        return false;
    }

}
