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
     * @throws Exception
     *             the exception
     */
    User getBio(OrcidAccessToken accessToken) throws Exception;

    /**
     * Gets the work.
     *
     * @param token
     *            the token
     * @param user
     *            the user
     * @return the work
     * @throws Exception
     *             the exception
     */
    User getWork(OrcidAccessToken token, User user) throws Exception;

    /**
     * Gets the orcid id.
     *
     * @param participantId
     *            the participant id
     * @return the orcid id
     * @throws Exception
     *             the exception
     */
    String getOrcidId(String participantId) throws Exception;
    User putOrcidData(User user,String authorizationCode);
    User getCachedOrcidData(User user,String authorizationCode);
}
