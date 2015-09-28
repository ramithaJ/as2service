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
package com.wiley.gr.ace.authorservices.model;

import java.util.List;

/**
 * @author Virtusa version1.0
 *
 */
public class NotificationFormat {

    /**
     * This field holds the value of articleId.
     */
    private String articleId;

    /**
     * This field holds the value of fromEmail.
     */
    private String fromEmail;

    /**
     * This field holds the value of recipients.
     */
    private List<String> recipients;

    /**
     * This field holds the value of cc.
     */
    private List<String> cc;

    /**
     * This field holds the value of bcc.
     */
    private List<String> bcc;

    /**
     * This field holds the value of type.
     */
    private String type;

    /**
     * This field holds the value of subType.
     */
    private String subType;

    /**
     * This field holds the value of emailSubject.
     */
    private String emailSubject;

    /**
     * This field holds the value of emailBody.
     */
    private String emailBody;

    /**
     * This field holds the value of attachment.
     */
    private String attachment;

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
     * @return the fromEmail
     */
    public final String getFromEmail() {
        return fromEmail;
    }

    /**
     * @param fromEmail
     *            the fromEmail to set
     */
    public final void setFromEmail(final String fromEmail) {
        this.fromEmail = fromEmail;
    }

    /**
     * @return the recipients
     */
    public final List<String> getRecipients() {
        return recipients;
    }

    /**
     * @param recipients
     *            the recipients to set
     */
    public final void setRecipients(final List<String> recipients) {
        this.recipients = recipients;
    }

    /**
     * @return the cc
     */
    public final List<String> getCc() {
        return cc;
    }

    /**
     * @param cc
     *            the cc to set
     */
    public final void setCc(final List<String> cc) {
        this.cc = cc;
    }

    /**
     * @return the bcc
     */
    public final List<String> getBcc() {
        return bcc;
    }

    /**
     * @param bcc
     *            the bcc to set
     */
    public final void setBcc(final List<String> bcc) {
        this.bcc = bcc;
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

    /**
     * @return the emailSubject
     */
    public final String getEmailSubject() {
        return emailSubject;
    }

    /**
     * @param emailSubject
     *            the emailSubject to set
     */
    public final void setEmailSubject(final String emailSubject) {
        this.emailSubject = emailSubject;
    }

    /**
     * @return the emailBody
     */
    public final String getEmailBody() {
        return emailBody;
    }

    /**
     * @param emailBody
     *            the emailBody to set
     */
    public final void setEmailBody(final String emailBody) {
        this.emailBody = emailBody;
    }

    /**
     * @return the attachment
     */
    public final String getAttachment() {
        return attachment;
    }

    /**
     * @param attachment
     *            the attachment to set
     */
    public final void setAttachment(final String attachment) {
        this.attachment = attachment;
    }

}
