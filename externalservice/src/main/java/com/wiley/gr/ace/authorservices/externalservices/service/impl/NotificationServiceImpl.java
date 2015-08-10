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

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.NotificationResponse;
import com.wiley.gr.ace.authorservices.model.external.NotificationDetailsPayload;
import com.wiley.gr.ace.authorservices.model.external.NotificationRequest;
import com.wiley.gr.ace.authorservices.model.external.NotificationsList;
import com.wiley.gr.ace.authorservices.model.external.UserNotifications;

/**
 * The Class NotificationServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class NotificationServiceImpl implements NotificationService {

    /**
     * This field holds the value of notificationurl.
     */
    @Value("${notification.url}")
    private String notificationurl;

    /**
     * This field holds the value of notificationHistoryUrl.
     */
    @Value("${notificationHistory.url}")
    private String notificationHistoryUrl;

    /**
     * This field holds the value of userNotificationsurl.
     */
    @Value("${userNotifications.url}")
    private String userNotificationsurl;

    /**
     * This field holds the value of userNotificationsurlextension.
     */
    @Value("${userNotifications.url.extension}")
    private String userNotificationsurlextension;

    /**
     * This field holds the value of notificationDetailsurl.
     */
    @Value("${notificationDetails.url}")
    private String notificationDetailsurl;

    /**
     * This field holds the value of applicationId.
     */
    private final String applicationId = "24";

    /**
     * 
     * @param notificationRequest
     *            This method will call external notification service.
     * @return sendNotification.
     */
    @Override
    public final NotificationResponse sendNotification(
            final NotificationRequest notificationRequest) {

        return (NotificationResponse) StubInvokerUtil.restServiceInvoker(
                notificationurl, notificationRequest,
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
        return (NotificationHistory) StubInvokerUtil.invokeStub(
                notificationHistoryUrl, HttpMethod.GET,
                NotificationHistory.class);
    }

    @Override
    public UserNotifications getNotifications(final String userId) {

        return (UserNotifications) StubInvokerUtil.restGetServiceInvoker(
                userNotificationsurl + userId + userNotificationsurlextension,
                UserNotifications.class);
    }

    @Override
    public NotificationDetailsPayload getNotificationDetails(
            final String notificationId) {

        // TODO: here application Id constant for total application.
        return (NotificationDetailsPayload) StubInvokerUtil
                .restGetServiceInvoker(notificationDetailsurl + applicationId
                        + "/" + notificationId,
                        NotificationDetailsPayload.class);
    }

    @Override
    public NotificationsList getArticleNotifications(final String articleId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean sendNotification(final NotificationsList notificationsList) {
        // TODO Auto-generated method stub
        return false;
    }
}
