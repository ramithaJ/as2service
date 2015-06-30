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

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
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
            NotificationRequest notificationRequest) {

        return (NotificationResponse) StubInvokerUtil.restServiceInvoker(
                notificationurl, NotificationRequest.class,
                NotificationResponse.class);
    }
}
