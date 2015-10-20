/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
/**
 *
 */
package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken;

/**
 * The Interface OrcidInterfaceService.
 *
 * @author virtusa version 1.0
 */
public interface OrcidInterfaceService {

    /**
     * Gets the access token.
     *
     * @param authorizationCode
     *            the authorization code
     * @return the access token
     * @throws Exception
     *             the exception
     */
    OrcidAccessToken getAccessToken(String authorizationCode);

    /**
     * Gets the bio.
     *
     * @param accessToken
     *            the access token
     * @return the bio
     * @throws Exception
     *             the exception
     */
    String getBio(OrcidAccessToken accessToken);

    /**
     * Gets the work.
     *
     * @param token
     *            the token
     * @return the work
     * @throws Exception
     *             the exception
     */
    String getWork(OrcidAccessToken token);
}
