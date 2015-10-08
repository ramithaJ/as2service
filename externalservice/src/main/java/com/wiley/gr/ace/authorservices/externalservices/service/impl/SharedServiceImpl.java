/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ProductPersonRelationObject;

// TODO: Auto-generated Javadoc
/**
 * The Class SharedServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class SharedServiceImpl implements SharedService {

    @Value("${authorLookup.url}")
    private String authorLookupUrl;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.SharedService
     * #authorLookup(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public final Service authorLookup(final String firstName,
            final String lastName, final String email) throws Exception {
        return (Service) RestServiceInvokerUtil.getServiceData(authorLookupUrl,
                Service.class);

    }

    @Override
    public Service saveProductPersonRelation(
            final ProductPersonRelationObject productPersonRelationObject) {

        return (Service) RestServiceInvokerUtil
                .restServiceInvoker(
                        "http://10.201.64.81:8090/as2crossrefservices/v1/article/assign",
                        productPersonRelationObject, Service.class);
    }

    @Override
    public boolean searchInvitationRecord(String emailId) {
        
        return false;
    }
}
