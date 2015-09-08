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

package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.NotificationResponse;
import com.wiley.gr.ace.authorservices.model.SendNotificationRequest;

/**
 * The Interface SendNotification.
 */
public interface SendNotification {

    /**
     * Send email.
     *
     * @param appId
     *            the app id
     * @param templateId
     *            the template id
     * @param type
     *            the type
     * @param sendNotificationRequest
     *            the send notification request
     * @return the string
     */
    String sendEmail(String appId, String templateId, String type,
            SendNotificationRequest sendNotificationRequest);

    /**
     * Notify by email.
     *
     * @param emailId
     *            the email id
     * @param templateId
     *            the template id
     * @return the notification response
     */
    NotificationResponse notifyByEmail(String emailId, String templateId);

    /**
     * @param userId
     *            the request
     * @param templateId
     *            the request
     * @return notification response
     */
    NotificationResponse updateSecEmailNotification(String emailId,
            String templateId);

    /**
     * @param emailId
     *            the request.
     * @param templateId
     *            the request.
     * @return notification response.
     */
    NotificationResponse superAdminNotification(String emailId,
            String templateId, List<String> accessList);
}
