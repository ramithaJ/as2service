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

package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.model.NotificationResponse;
import com.wiley.gr.ace.authorservices.model.SendNotificationRequest;
import com.wiley.gr.ace.authorservices.model.external.NotificationFieldList;
import com.wiley.gr.ace.authorservices.model.external.NotificationRequest;
import com.wiley.gr.ace.authorservices.services.service.SendNotification;

/**
 * The Class SendNotificationImpl.
 */
public class SendNotificationImpl implements SendNotification {

    /** The notification service. */
    @Autowired(required = true)
    private NotificationService notificationService;

    /** The notification email. */
    @Value("${notification.email}")
    private String notificationEmail;

    /** The app id. */
    @Value("${appId}")
    private String appId;

    /** The type. */
    @Value("${type}")
    private String type;

    /**
     * calling notification service for sending email.
     *
     * @param appId
     *            - the app id
     * @param templateId
     *            - the template id
     * @param type
     *            - the type
     * @param sendNotificationRequest
     *            - the send notification request
     * @return notification response.
     */
    @Override
    public final String sendEmail(final String appId, final String templateId,
            final String type,
            final SendNotificationRequest sendNotificationRequest) {
        NotificationFieldList fieldList = new NotificationFieldList();
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setTo(sendNotificationRequest.getToList());
        notificationRequest.setFrom(sendNotificationRequest.getFrom());
        fieldList.setFieldList(sendNotificationRequest.getFieldList());
        notificationRequest.setTemplateDetails(fieldList);
        return notificationService.sendNotification(appId, type, templateId,
                notificationRequest).getStatus();

    }

    /**
     * calling notification service for sending email.
     *
     * @param emailId
     *            the email id
     * @param templateId
     *            the template id
     * @return noification response.
     */
    @Override
    public final NotificationResponse notifyByEmail(final String emailId,
            final String templateId) {

        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setFrom(notificationEmail);
        List<String> toList = new ArrayList<String>();
        toList.add(emailId);
        notificationRequest.setTo(toList);
        NotificationFieldList notificationFieldList = new NotificationFieldList();
        List<String> listofFields = new ArrayList<String>();

        listofFields.add(emailId);
        notificationFieldList.setFieldList(listofFields);
        notificationRequest.setTemplateDetails(notificationFieldList);
        return notificationService.sendNotification(appId, type, templateId,
                notificationRequest);

    }

    @Override
    public NotificationResponse updateSecEmailNotification(
            final String emailId, final String templateId) {

        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setFrom(notificationEmail);
        List<String> toList = new ArrayList<String>();
        toList.add(emailId);
        notificationRequest.setTo(toList);
        NotificationFieldList notificationFieldList = new NotificationFieldList();
        List<String> listofFields = new ArrayList<String>();

        notificationFieldList.setFieldList(listofFields);
        notificationRequest.setTemplateDetails(notificationFieldList);
        return notificationService.sendNotification(appId, type, templateId,
                notificationRequest);

    }

    @Override
    public NotificationResponse superAdminNotification(final String emailId,
            final String templateId, final List<String> accessList) {

        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setFrom(notificationEmail);

        List<String> toList = new ArrayList<String>();

        notificationRequest.setTo(toList);
        NotificationFieldList notificationFieldList = new NotificationFieldList();
        List<String> listofFields = new ArrayList<String>();
        listofFields.add(emailId);
        for (String access : accessList) {
            listofFields.add(access);
        }
        notificationFieldList.setFieldList(listofFields);
        notificationRequest.setTemplateDetails(notificationFieldList);
        return notificationService.sendNotification(appId, type, templateId,
                notificationRequest);
    }

}
