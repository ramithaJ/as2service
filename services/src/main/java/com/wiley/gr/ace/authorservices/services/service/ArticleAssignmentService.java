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

import com.wiley.gr.ace.authorservices.model.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.ViewAssignedArticle;

/**
 * The Interface ArticleAssignmentService.
 *
 * @author virtusa version 1.0
 */
public interface ArticleAssignmentService {

    /**
     * Gets the article info.
     *
     * @param emailId
     *            the email id
     * @return the article info details
     */
    ArticleInfoDetails getArticleInfoDetails(String emailId);

    /**
     * Association confirmation.
     *
     * @param associationConfirmation
     *            the association confirmation
     * @return true, if successful
     */
    boolean associationConfirmation(
            AssociationConfirmation associationConfirmation);

    /**
     * View assigned article.
     *
     * @param articleId
     *            the article id
     * @return the view assigned article
     */
    ViewAssignedArticle viewAssignedArticle(String articleId);

    /**
     * Check if article invited.
     *
     * @param dhId
     *            the dh id
     * @return true, if successful
     */
    boolean checkIfArticleInvited(String dhId);

}
