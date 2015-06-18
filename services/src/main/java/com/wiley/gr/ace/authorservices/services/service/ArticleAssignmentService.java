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

import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;

/**
 * The Interface ArticleAssignmentService.
 *
 * @author yugandhark
 */
public interface ArticleAssignmentService {

    /**
     * Gets the article info.
     *
     * @param emailId
     *            the email id
     * @return the article info
     */
    ArticleInfoDetails getArticleInfo(String emailId);

    /**
     * Confirm association.
     *
     * @param articleAuthId
     *            the article auth id
     * @param userId
     *            the user id
     * @return true, if successful
     */
    boolean confirmAssociation(String articleAuthId, String userId);
}
