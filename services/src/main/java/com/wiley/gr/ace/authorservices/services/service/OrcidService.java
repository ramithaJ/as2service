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

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken;

/**
 * The Interface OrcidService.
 *
 * @author virtusa version 1.0
 */
public interface OrcidService {

    /**
     * Gets the access token.
     *
     * @param authorizationCode
     *            the authorization code
     * @return the access token
     * @throws Exception
     *             the exception
     */
    OrcidAccessToken getAccessToken(String authorizationCode) throws Exception;

    /**
     * Gets the bio.
     *
     * @param accessToken
     *            the access token
     * @return the bio
     * @throws ASException
     *             the as exception
     */
    User getBio(OrcidAccessToken accessToken) throws ASException;

    /**
     * Gets the work.
     *
     * @param token
     *            the token
     * @param user
     *            the user
     * @return the work
     * @throws ASException
     *             the as exception
     */
    User getWork(OrcidAccessToken token, User user) throws ASException;

    /**
     * Gets the orcid id.
     *
     * @param participantId
     *            the participant id
     * @return the orcid id
     */
    String getOrcidId(String participantId);

    /**
     * Put orcid data.
     *
     * @param user
     *            the user
     * @param authorizationCode
     *            the authorization code
     * @return the user
     */
    User putOrcidData(User user, String authorizationCode);

    /**
     * Gets the cached orcid data.
     *
     * @param user
     *            the user
     * @param authorizationCode
     *            the authorization code
     * @return the cached orcid data
     */
    User getCachedOrcidData(User user, String authorizationCode);
}
