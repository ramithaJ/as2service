/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.AssociationConfirmation;

/**
 * The Class SharedServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class SharedServiceImpl implements SharedService {

    /**
     * Association confirmation.
     *
     * @param associationConfirmation
     *            the association confirmation
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean associationConfirmation(
            final AssociationConfirmation associationConfirmation)
            throws Exception {
        final String url = "http://demo7930138.mockable.io/article/associationconfirmation";
        Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.PUT, Service.class);
        String status = service.getStatus();
        if (null != status && status.equalsIgnoreCase("SUCCESS")) {
            return true;
        }
        return false;
    }
}
