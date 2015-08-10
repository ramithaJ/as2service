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
package com.wiley.gr.ace.authorservices.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.NotificationsList;
import com.wiley.gr.ace.authorservices.services.service.NotificationHistoryService;

@RestController
@RequestMapping("/v1/notifications")
public class NotificationController {

    /**
     * This field holds the value of notificationService
     */
    @Autowired(required = true)
    private NotificationHistoryService notificationHistoryService;

    /**
     * This field holds the value of LOGGER
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(NotificationController.class);

    /**
     * @param userId
     * @return service
     */
    @RequestMapping(value = "/{userId}/", method = RequestMethod.GET)
    public final Service getNotifications(
            @PathVariable("userId") final String userId) {
        LOGGER.info("inside getNotifications method");
        Service service = new Service();
        service.setPayload(notificationHistoryService.getNotifications(userId));
        return service;
    }

    /**
     * @param notificationId
     * @return service
     */
    @RequestMapping(value = "/view/{notificationId}/", method = RequestMethod.GET)
    public final Service getNotificationDetails(
            @PathVariable("notificationId") final String notificationId) {
        LOGGER.info("inside getNotificationDetails method");
        Service service = new Service();
        service.setPayload(notificationHistoryService
                .getNotificationDetails(notificationId));
        return service;
    }

    /**
     * @param articleId
     * @return service
     */
    @RequestMapping(value = "/article/{articleId}/", method = RequestMethod.GET)
    public final Service getArticleNotifications(
            @PathVariable("articleId") final String articleId) {
        LOGGER.info("inside getArticleNotifications method");
        Service service = new Service();
        service.setPayload(notificationHistoryService
                .getArticleNotifications(articleId));
        return service;
    }

    /**
     * @param notificationsList
     * @return service
     */
    @RequestMapping(value = "/send/", method = RequestMethod.POST)
    public final Service sendNotification(
            @RequestBody final NotificationsList notificationsList) {
        LOGGER.info("inside getArticleNotifications method");
        Service service = new Service();
        service.setPayload(notificationHistoryService
                .sendNotification(notificationsList));
        return service;
    }

    // TODO: Re Send
}
