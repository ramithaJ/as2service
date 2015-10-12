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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import java.util.ArrayList;

import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.CDMResponse;
import com.wiley.gr.ace.authorservices.model.external.CDMUser;
import com.wiley.gr.ace.authorservices.model.external.CreateContactRequestCDM;

/**
 * The Class CDMInterfaceServiceImpl.
 */
public class CDMInterfaceServiceImpl implements CDMInterfaceService {

    /**
     * Creates the contact.
     *
     * @param createContactRequestCDM
     *            the create contact request cdm
     * @return the CDM response
     */
    @Override
    public CDMResponse createContact(
            final CreateContactRequestCDM createContactRequestCDM) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Search cdm.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the array list
     */
    @Override
    public ArrayList<CDMUser> searchCDM(final String firstName, final String lastName) {
        // TODO Auto-generated method stub
        return null;
    }

}
