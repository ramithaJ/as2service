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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.model.NotificationFormat;
import com.wiley.gr.ace.authorservices.model.external.NotificationDetails;
import com.wiley.gr.ace.authorservices.model.external.NotificationDetailsPayload;
import com.wiley.gr.ace.authorservices.model.external.NotificationsList;
import com.wiley.gr.ace.authorservices.model.external.UserNotification;
import com.wiley.gr.ace.authorservices.model.external.UserNotifications;
import com.wiley.gr.ace.authorservices.services.service.NotificationHistoryService;

/**
 * @author Virtusa version1.0
 *
 */
public class NotificationHistoryServiceImpl implements
        NotificationHistoryService {

    /**
     * This field holds the value of notificationService.
     */
    @Autowired(required = true)
    private NotificationService notificationService;

    /**
     * Method to get List of Notifications for particular User.
     * 
     * @param userId
     */
    @Override
    public NotificationsList getNotifications(final String userId) {

        UserNotifications userNotifications = notificationService
                .getNotifications(userId);
        List<UserNotification> userNotificationsList = userNotifications
                .getPayload();

        NotificationsList notificationsList = new NotificationsList();
        List<NotificationDetails> notificationDetailsList = new ArrayList<NotificationDetails>();
        NotificationDetails notificationDetails = null;

        for (UserNotification userNotification : userNotificationsList) {
            notificationDetails = new NotificationDetails();
            notificationDetails.setArticleId("");
            notificationDetails.setNotificationId(userNotification
                    .getNotificationRecipients().getNotificationId());
            notificationDetails.setType(userNotification.getType());
            notificationDetails.setUserEmailId(userNotification
                    .getSenderEmail());
            notificationDetails.setSubType("");
            notificationDetails.setRecievedDate(userNotification.getTemplate()
                    .getCreatedOn());
            notificationDetailsList.add(notificationDetails);
        }
        notificationsList.setNotifications(notificationDetailsList);
        return notificationsList;
    }

    @Override
    public NotificationFormat getNotificationDetails(final String notificationId) {

        NotificationDetailsPayload notificationDetailsPayload = notificationService
                .getNotificationDetails(notificationId);
        UserNotification userNotification = notificationDetailsPayload
                .getPayload();
        NotificationFormat notificationFormat = new NotificationFormat();
        notificationFormat.setArticleId("");
        notificationFormat.setAttachment("");
        notificationFormat.setEmailBody(userNotification.getTemplate()
                .getBody());// check
        notificationFormat.setEmailSubject(userNotification.getTemplate()
                .getDescription());// check
        notificationFormat.setFromEmail(userNotification.getSenderEmail());// check
        notificationFormat.setType(userNotification.getType());// check
        notificationFormat.setSubType("");
        notificationFormat.setRecipients(new ArrayList<String>());
        notificationFormat.setCc(new ArrayList<String>());
        notificationFormat.setBcc(new ArrayList<String>());

        return notificationFormat;
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
