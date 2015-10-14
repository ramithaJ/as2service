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

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.AddressData;
import com.wiley.gr.ace.authorservices.model.external.AddressesData;
import com.wiley.gr.ace.authorservices.model.external.Entity;
import com.wiley.gr.ace.authorservices.model.external.ParticipantAddress;

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
    User getEmailDetails(String userId);

    /**
     * Gets the profile information.
     *
     * @param userId
     *            the user id
     * @return the profile information
     */
    User getProfileInformation(String userId);

    /**
     * Gets the user address.
     *
     * @param userId
     *            the user id
     * @return the user address
     * @throws Exception
     */
    AddressesData getUserAddress(String userId) throws Exception;

    List<ParticipantAddress> getAddress(String participantId) throws Exception;

    Object updatAddress(String participantId, Entity entity) throws Exception;

    List<AddressData> validateAddress(AddressData address) throws Exception;
}
