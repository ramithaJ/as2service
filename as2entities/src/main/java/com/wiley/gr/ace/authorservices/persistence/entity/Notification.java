package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 8, 2015 3:59:02 PM by Hibernate Tools 4.0.0

import java.sql.Clob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Notification generated by hbm2java
 */
@Entity
@Table(name = "NOTIFICATION")
public class Notification implements java.io.Serializable {

	private Integer id;
	private Template template;
	private String appId;
	private String senderId;
	private String senderEmail;
	private Clob content;
	private String type;
	private Date sentOn;
	private Character unread;
	private NotificationRecipients notificationRecipients;

	public Notification() {
	}

	public Notification(Integer id) {
		this.id = id;
	}

	public Notification(Integer id, Template template, String appId,
			String senderId, String senderEmail, Clob content, String type,
			Date sentOn, Character unread,
			NotificationRecipients notificationRecipients) {
		this.id = id;
		this.template = template;
		this.appId = appId;
		this.senderId = senderId;
		this.senderEmail = senderEmail;
		this.content = content;
		this.type = type;
		this.sentOn = sentOn;
		this.unread = unread;
		this.notificationRecipients = notificationRecipients;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORIG_TMPL_ID")
	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	@Column(name = "APP_ID", length = 25)
	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Column(name = "SENDER_ID")
	public String getSenderId() {
		return this.senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	@Column(name = "SENDER_EMAIL")
	public String getSenderEmail() {
		return this.senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	@Column(name = "CONTENT")
	public Clob getContent() {
		return this.content;
	}

	public void setContent(Clob content) {
		this.content = content;
	}

	@Column(name = "TYPE", length = 25)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "SENT_ON", length = 7)
	public Date getSentOn() {
		return this.sentOn;
	}

	public void setSentOn(Date sentOn) {
		this.sentOn = sentOn;
	}

	@Column(name = "UNREAD", length = 1)
	public Character getUnread() {
		return this.unread;
	}

	public void setUnread(Character unread) {
		this.unread = unread;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "notification")
	public NotificationRecipients getNotificationRecipients() {
		return this.notificationRecipients;
	}

	public void setNotificationRecipients(
			NotificationRecipients notificationRecipients) {
		this.notificationRecipients = notificationRecipients;
	}

}
