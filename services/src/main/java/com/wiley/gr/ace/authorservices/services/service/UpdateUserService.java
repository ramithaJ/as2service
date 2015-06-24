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
package com.wiley.gr.ace.authorservices.services.service;

/**
 * The Interface UpdateUserService.
 *
 * @author virtusa version 1.0
 */
public interface UpdateUserService {

    /**
     * Update orcid id.
     *
     * @param emailId
     *            the email id
     * @param orcidId
     *            the orcid id
     * @param userId
     *            the user id
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    boolean updateOrcidId(String emailId, String orcidId, int userId)
            throws Exception;

}
