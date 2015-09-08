/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
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
import com.wiley.gr.ace.authorservices.model.external.NotificationRequest;

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

}
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
import com.wiley.gr.ace.authorservices.model.external.NotificationRequest;

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

}
