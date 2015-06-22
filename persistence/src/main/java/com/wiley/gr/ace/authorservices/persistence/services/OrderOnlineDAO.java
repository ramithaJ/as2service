/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.ArticleAuthorAssignment;
import com.wiley.gr.ace.authorservices.persistence.entity.Articles;
import com.wiley.gr.ace.authorservices.persistence.entity.Journals;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;

/**
 * @author virtusa version1.0
 *
 */
public interface OrderOnlineDAO {

    /**
     * @param userId
     * @param articleId
     * @return
     */
    ArticleAuthorAssignment getAritcleAssignmentDetails(String userId,
            String articleId);

    /**
     * @param articleId
     * @return
     */
    Articles getArticleDetails(String articleId);

    /**
     * @param journalId
     * @return
     */
    Journals getJournalDetails(String journalId);

    /**
     * @param articleId
     * @param userId
     * @return
     */
    SavedOrders getSavedOrders(String articleId, String userId);

    /**
     * @param aritcleAuthId
     * @return
     */
    Orders getOrder(Integer aritcleAuthId);

    /**
     * @param userId
     * @return
     */
    List<ArticleAuthorAssignment> getArticleAuthId(Integer userId,String type);
    
    /**
     * @param order
     * @return
     */
    String saveLaterOrder(String order);
}
