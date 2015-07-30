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
package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;

/**
 * The Interface UserAccountService.
 *
 * @author virtusa version 1.0
 */
public interface UserAccountService {

    /**
     * Gets the email details.
     *
     * @param userId
     *            the user id
     * @return the email details
     */
    User getEmailDetails(int userId);

    /**
     * Gets the profile information.
     *
     * @param userId
     *            the user id
     * @return the profile information
     */
    CustomerDetails getProfileInformation(String userId);

    /**
     * Gets the user address.
     *
     * @param userId
     *            the user id
     * @return the user address
     */
    List<Addresses> getUserAddress(String userId);
}
