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

import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.model.NotificationResponse;
import com.wiley.gr.ace.authorservices.model.SendNotificationRequest;
import com.wiley.gr.ace.authorservices.model.external.NotificationFieldList;
import com.wiley.gr.ace.authorservices.model.external.NotificationRequest;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.SendNotificationDao;
import com.wiley.gr.ace.authorservices.services.service.SendNotification;

/**
 * The Class SendNotificationImpl.
 */
public class SendNotificationImpl implements SendNotification {

    /** The notification service. */
    @Autowired(required = true)
    private NotificationService notificationService;

    /** The send notification dao. */
    @Autowired(required = true)
    private SendNotificationDao sendNotificationDao;

    @Override
    public String sendEmail(String appId, String templateId, String type,
            SendNotificationRequest sendNotificationRequest) {
        NotificationFieldList fieldList = new NotificationFieldList();
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setTo(sendNotificationRequest.getTo());
        notificationRequest.setFrom(sendNotificationRequest.getFrom());
        fieldList.setFieldList(sendNotificationRequest.getFieldList());
        notificationRequest.setTemplateDetails(fieldList);
        return notificationService.sendNotification(appId, type, templateId,
                notificationRequest).getStatus();

    }
    
    @Override
    public NotificationResponse notifyByEmail(String emailId) {

        String appId = "23";
        String templateId = "112";
        String type = "email";
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setFrom("rasinha@wiley.com");
        notificationRequest.setTo(emailId);
        NotificationFieldList notificationFieldList = new NotificationFieldList();
        List<String> listofFields = new ArrayList<String>();
        Users users=sendNotificationDao.getUserProfileByEmail(emailId);
        listofFields.add(users.getFirstName());
        listofFields.add("Test");
        listofFields.add("www.google.com");
        notificationFieldList.setFieldList(listofFields);
        notificationRequest.setTemplateDetails(notificationFieldList);
        return notificationService.sendNotification(appId, type, templateId,
                notificationRequest);

    }


}
