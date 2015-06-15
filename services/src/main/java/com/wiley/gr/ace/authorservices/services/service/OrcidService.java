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
 * @author virtusa version 1.0
 */
public interface OrcidService {
    /**
     * @param authorizationCode
     * @return
     * @throws Exception
     */
    OrcidAccessToken getAccessToken(String authorizationCode) throws Exception;

    /**
     * @param accessToken
     * @return
     * @throws Exception
     */
    User getBio(OrcidAccessToken accessToken) throws Exception;

    /**
     * @param token
     * @param user
     * @return
     * @throws Exception
     */
    User getWork(OrcidAccessToken token, User user) throws Exception;
}
