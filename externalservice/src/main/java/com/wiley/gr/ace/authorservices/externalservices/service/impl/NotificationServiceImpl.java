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

package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.NotificationResponse;
import com.wiley.gr.ace.authorservices.model.external.NotificationRequest;

/**
 * The Class NotificationServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class NotificationServiceImpl implements NotificationService {

    /** The Notification user. */
    @Value("${notification.url}")
    private String notificationurl;

    /** The Notification History. */
    @Value("${notificationHistory.url}")
    private String notificationHistoryUrl;

    /**
     * Calling Notification of shared services...
     *
     * @param appId
     *            the app id
     * @param type
     *            the type
     * @param templateId
     *            the template id
     * @param notificationRequest
     *            the notification request
     * @return NotificationHistory response
     */
    @Override
    public final NotificationResponse sendNotification(final String appId,
            final String type, final String templateId,
            final NotificationRequest notificationRequest) {

        String notificationFinalUrl = notificationurl + appId + "/send?tmpl="
                + templateId + "&type=" + type;
        return (NotificationResponse) RestServiceInvokerUtil
                .restServiceInvoker(notificationFinalUrl, notificationRequest,
                        NotificationResponse.class);
    }

    /**
     * Gets the notification history.
     *
     * @param userId
     *            the user id
     * @return the notification history
     * @throws Exception
     *             the exception
     */
    @Override
    public final NotificationHistory getNotificationHistory(final String userId)
            throws Exception {
        return (NotificationHistory) RestServiceInvokerUtil.invokeStub(
                notificationHistoryUrl, HttpMethod.GET,
                NotificationHistory.class);
    }
}
