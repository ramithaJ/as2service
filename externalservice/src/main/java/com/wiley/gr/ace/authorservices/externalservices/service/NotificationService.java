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

package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.NotificationResponse;
import com.wiley.gr.ace.authorservices.model.external.NotificationDetailsPayload;
import com.wiley.gr.ace.authorservices.model.external.NotificationRequest;
import com.wiley.gr.ace.authorservices.model.external.NotificationsList;
import com.wiley.gr.ace.authorservices.model.external.UserNotifications;

/**
 * The Interface NotificationService.
 */
public interface NotificationService {

    /**
     * Send notification.
     *
     * @param notificationRequest
     *            the notification request
     * @return the notification response
     */
    NotificationResponse sendNotification(
            NotificationRequest notificationRequest);

    /**
     * Gets the notification history.
     *
     * @param userId
     *            the user id
     * @return the notification history
     * @throws Exception
     *             the exception
     */
    NotificationHistory getNotificationHistory(String userId) throws Exception;

    /**
     * @param userId
     * @return NotificationsList
     */
    UserNotifications getNotifications(String userId);

    /**
     * @param notificationId
     * @return NotificationsList
     */
    NotificationDetailsPayload getNotificationDetails(String notificationId);

    /**
     * @param articleId
     * @return NotificationsList
     */
    NotificationsList getArticleNotifications(String articleId);

    /**
     * @param notificationsList
     * @return boolean
     */
    boolean sendNotification(NotificationsList notificationsList);

}
