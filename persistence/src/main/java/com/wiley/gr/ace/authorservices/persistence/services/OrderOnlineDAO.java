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

import com.wiley.gr.ace.authorservices.model.PaymentDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductRelations;
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
    ProductPersonRelations getProductPersonRelations(String userId,
            String articleId);

    /**
     * @param articleId
     * @param userId
     * @return
     */
    SavedOrders getSavedOrders(String articleId, String userId);

    /**
     * @param orderId
     * @return SavedOrders
     */
    SavedOrders getSavedOrdersForTheOrderId(String orderId);

    /**
     * @param aritcleAuthId
     * @return
     */
    Orders getOrder(String articleId, String userId);

    /**
     * @param userId
     * @return
     */
    List<ProductPersonRelations> getArticleAuthId(Integer userId, String type);

    /**
     * @param order
     * @return
     */
    Integer saveLaterOrder(SavedOrders savedOrders);

    /**
     * @param ArticleId
     * @return
     */
    List<ProductPersonRelations> getGrantRecipients(String articleId);

    /**
     * @param articleDhId
     * @return
     */
    ProductRelations getProductRelations(String articleDhId);

    /**
     * @param paymentDetails
     */
    void savePaymentDetails(PaymentDetails paymentDetails);

    /**
     * @param orderId
     */
    void deleteSavedOrderPostOrderSubmission(Integer orderId);

    /**
     * This method submits the saved order
     * 
     * @param orders
     */
    void saveOrder(Orders orders);

    /**
     * @param orderId
     * @return
     */
    String retrieveOrderType(Integer orderId);

    /**
     * @param articleId
     * @param userId
     * @return
     */
    SavedOrders verifySavedOrders(String articleId, String userId);
}
