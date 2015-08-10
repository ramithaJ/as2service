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
package com.wiley.gr.ace.authorservices.model.external;

import com.wiley.gr.ace.authorservices.model.NotificationRecipients;
import com.wiley.gr.ace.authorservices.model.Template;

/**
 * @author Virtusa version1.0
 *
 */
public class UserNotification {

    /**
     * This field holds the value of id
     */
    private String id;

    /**
     * This field holds the value of template
     */
    private Template template;

    /**
     * This field holds the value of appId
     */
    private String appId;

    /**
     * This field holds the value of senderEmail
     */
    private String senderEmail;

    /**
     * This field holds the value of content
     */
    private String content;

    /**
     * This field holds the value of type
     */
    private String type;

    /**
     * This field holds the value of unread
     */
    private String unread;

    /**
     * This field holds the value of notificationRecipients
     */
    private NotificationRecipients notificationRecipients;

    /**
     * This field holds the value of articleId
     */
    private String articleId;

    /**
     * This field holds the value of subType
     */
    private String subType;

    /**
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * @return the template
     */
    public final Template getTemplate() {
        return template;
    }

    /**
     * @param template
     *            the template to set
     */
    public final void setTemplate(final Template template) {
        this.template = template;
    }

    /**
     * @return the appId
     */
    public final String getAppId() {
        return appId;
    }

    /**
     * @param appId
     *            the appId to set
     */
    public final void setAppId(final String appId) {
        this.appId = appId;
    }

    /**
     * @return the senderEmail
     */
    public final String getSenderEmail() {
        return senderEmail;
    }

    /**
     * @param senderEmail
     *            the senderEmail to set
     */
    public final void setSenderEmail(final String senderEmail) {
        this.senderEmail = senderEmail;
    }

    /**
     * @return the content
     */
    public final String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public final void setContent(final String content) {
        this.content = content;
    }

    /**
     * @return the type
     */
    public final String getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public final void setType(final String type) {
        this.type = type;
    }

    /**
     * @return the unread
     */
    public final String getUnread() {
        return unread;
    }

    /**
     * @param unread
     *            the unread to set
     */
    public final void setUnread(final String unread) {
        this.unread = unread;
    }

    /**
     * @return the notificationRecipients
     */
    public final NotificationRecipients getNotificationRecipients() {
        return notificationRecipients;
    }

    /**
     * @param notificationRecipients
     *            the notificationRecipients to set
     */
    public final void setNotificationRecipients(
            final NotificationRecipients notificationRecipients) {
        this.notificationRecipients = notificationRecipients;
    }

    /**
     * @return the articleId
     */
    public final String getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     *            the articleId to set
     */
    public final void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    /**
     * @return the subType
     */
    public final String getSubType() {
        return subType;
    }

    /**
     * @param subType
     *            the subType to set
     */
    public final void setSubType(final String subType) {
        this.subType = subType;
    }

}
