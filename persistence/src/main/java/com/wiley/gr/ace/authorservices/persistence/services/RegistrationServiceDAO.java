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
package com.wiley.gr.ace.authorservices.persistence.services;

import com.wiley.gr.ace.authorservices.persistence.entity.RegistrationDetails;

/**
 * The Interface RegistrationServiceDAO.
 *
 * @author virtusa version 1.0
 */
public interface RegistrationServiceDAO {

    /**
     * This method search the User by using orcidId.
     * 
     * @param orcidId
     *            to Retrieve.
     * @return the boolean value.
     * @throws Exception
     *             if unable to search.
     */
    boolean searchUserByOrcidId(String orcidId);

    /**
     * Creates the registration record.
     *
     * @param registrationDetails
     *            the registration details
     */
    void createRegistrationRecord(RegistrationDetails registrationDetails);

    /**
     * Gets the registration record.
     *
     * @param almUserId
     *            the alm user id
     * @return the registration record
     */
    RegistrationDetails getRegistrationRecord(String almUserId);

    /**
     * Delete registration details.
     *
     * @param almUserId
     *            the alm user id
     */
    void deleteRegistrationDetails(String almUserId);

}
