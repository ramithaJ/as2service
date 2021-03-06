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

import java.util.List;

import com.wiley.gr.ace.authorservices.model.external.CDMResponse;
import com.wiley.gr.ace.authorservices.model.external.CDMUser;
import com.wiley.gr.ace.authorservices.model.external.CreateContactRequestCDM;

/**
 * The Interface CDMInterfaceService.
 */
public interface CDMInterfaceService {

    /**
     * Creates the contact.
     *
     * @param createContactRequestCDM
     *            the create contact request cdm
     * @return the CDM response
     */
    CDMResponse createContact(CreateContactRequestCDM createContactRequestCDM);

    /**
     * Search cdm.
     *
     * @param firstName the first name
     * @param lastName the last name
     * @return the array list
     */
    List<CDMUser> searchCDM(String firstName, String lastName);
}
