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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.NotificationResponse;
import com.wiley.gr.ace.authorservices.model.external.NotificationRequest;

/**
 * The Class NotificationServiceImpl.
 */
public class NotificationServiceImpl implements NotificationService {

    /** The Notification user. */
    @Value("${notification.url}")
    private String notificationurl;

    /**
     * (non-Javadoc)
     * 
     * @param notificationRequest
     *            This method will call external notification service
     */
    @Override
    public NotificationResponse sendNotification(
            final NotificationRequest notificationRequest) {

        return (NotificationResponse) StubInvokerUtil.restServiceInvoker(
                notificationurl, NotificationRequest.class,
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
        NotificationHistory notificationHistory = null;
        final String url = "http://localhost:8080/notification-template/v1/notifications/"
                + "111" + "?from=&to=&type=email&offset=&limit=&unreadFlag=";
        try {
            final URI uri = new URI(url);
            final RestTemplate restTemplate = new RestTemplate();
            final HttpHeaders requestHeaders = new HttpHeaders();

            requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            final HttpEntity<NotificationHistory> requestEntity = new HttpEntity<NotificationHistory>(
                    requestHeaders);

            final ResponseEntity<NotificationHistory> response = restTemplate
                    .exchange(uri, HttpMethod.GET, requestEntity,
                            NotificationHistory.class);
            System.out.println("####  response #### "
                    + response.getStatusCode());
            System.out.println("####  response #### " + response.getBody());
            notificationHistory = response.getBody();
        } catch (final URISyntaxException e) {
            e.printStackTrace();
        }
        return notificationHistory;
    }
}
