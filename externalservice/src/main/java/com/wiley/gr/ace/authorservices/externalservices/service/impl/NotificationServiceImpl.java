/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */

package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.NotificationResponse;
import com.wiley.gr.ace.authorservices.model.external.NotificationDetailsPayload;
import com.wiley.gr.ace.authorservices.model.external.NotificationRequest;
import com.wiley.gr.ace.authorservices.model.external.NotificationsList;
import com.wiley.gr.ace.authorservices.model.external.UserNotifications;
import org.springframework.beans.factory.annotation.Value;

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
     * This field holds the value of APPLICATION_ID.
     */
    private static final String APPLICATION_ID = "24";

    /**
     *
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
    public final NotificationHistory getNotificationHistory(final String userId) {
        return (NotificationHistory) RestServiceInvokerUtil.getServiceData(
                notificationHistoryUrl, NotificationHistory.class);
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

        return (NotificationDetailsPayload) StubInvokerUtil
                .restGetServiceInvoker(notificationDetailsurl + APPLICATION_ID
                                + "/" + notificationId,
                        NotificationDetailsPayload.class);
    }

    @Override
    public NotificationsList getArticleNotifications(final String articleId) {
        return null;
    }

    @Override
    public boolean sendNotification(final NotificationsList notificationsList) {
        return false;
    }

    /**
     * Resend notification.
     *
     * @param notificationId
     *            the notification id
     * @return the notification response
     */
    @Override
    public NotificationResponse resendNotification(final String notificationId) {
        String notificationFinalUrl = notificationurl.concat("24")
                .concat("/resend/").concat(notificationId);
        return (NotificationResponse) RestServiceInvokerUtil.getServiceData(
                notificationFinalUrl, NotificationResponse.class);
    }
}
