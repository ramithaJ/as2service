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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.Notifications;
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

    /**
     * Save product person relation.
     *
     * @param productPersonRelationObject
     *            the product person relation object
     * @return the service
     */
    Service saveProductPersonRelation(
            ProductPersonRelationObject productPersonRelationObject);

    /**
     * Search invitation record.
     *
     * @param emailId
     *            the email id
     * @return the notification history
     */
    Notifications searchInvitationRecord(String emailId);
}
