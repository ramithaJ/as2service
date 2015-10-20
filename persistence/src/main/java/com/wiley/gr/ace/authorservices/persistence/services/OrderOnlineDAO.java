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

import com.wiley.gr.ace.authorservices.persistence.entity.CoauthorRequestsOoorders;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;

/**
 * @author virtusa version1.0
 *
 */
public interface OrderOnlineDAO {

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
     * @param order
     * @return
     */
    Integer saveLaterOrder(SavedOrders savedOrders);

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
     * @param articleId
     * @param userId
     * @return
     */
    SavedOrders verifySavedOrders(String articleId, String userId);

    /**
     * @param coauthorRequestsOoorders
     * @return
     */
    void requestOnlineOpen(CoauthorRequestsOoorders coauthorRequestsOoorders);

    /**
     * @param userId
     * @param articleId
     * @return
     */
    CoauthorRequestsOoorders viewOnlineOpenRequest(String userId,
            String articleId);

    /**
     * @param articleId
     * @param coAuthorUserId
     * @return
     */
    List<CoauthorRequestsOoorders> getcoAuthorReqOO(String userId);

    /**
     * @param userId
     * @return
     */
    List<SavedOrders> getUserSavedOrders(String userId);
}
