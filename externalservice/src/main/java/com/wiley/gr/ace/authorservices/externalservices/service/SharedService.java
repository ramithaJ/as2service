/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ProductPersonRelationObject;

/**
 * The Interface SharedService.
 *
 * @author virtusa version 1.0
 */
public interface SharedService {

    /**
     * Author lookup.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @param email
     *            the email
     * @return the service
     * @throws Exception
     *             the exception
     */
    Service authorLookup(String firstName, String lastName, String email)
            throws Exception;

    Service saveProductPersonRelation(
            ProductPersonRelationObject productPersonRelationObject);
}
