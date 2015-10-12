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
     * @param appId
     *            the app id
     * @param type
     *            the type
     * @param templateId
     *            the template id
     * @param notificationRequest
     *            the notification request
     * @return it will return notification request.
     */
    NotificationResponse sendNotification(String appId, String type,
            String templateId, NotificationRequest notificationRequest);

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
     * Gets the notifications.
     *
     * @param userId
     *            the user id
     * @return NotificationsList
     */
    UserNotifications getNotifications(String userId);

    /**
     * Gets the notification details.
     *
     * @param notificationId
     *            the notification id
     * @return NotificationsList
     */
    NotificationDetailsPayload getNotificationDetails(String notificationId);

    /**
     * Gets the article notifications.
     *
     * @param articleId
     *            the article id
     * @return NotificationsList
     */
    NotificationsList getArticleNotifications(String articleId);

    /**
     * Send notification.
     *
     * @param notificationsList
     *            the notifications list
     * @return boolean
     */
    boolean sendNotification(NotificationsList notificationsList);

    /**
     * Resend notification.
     *
     * @param notificationId
     *            the notification id
     * @return the notification response
     */
    NotificationResponse resendNotification(String notificationId);

}
