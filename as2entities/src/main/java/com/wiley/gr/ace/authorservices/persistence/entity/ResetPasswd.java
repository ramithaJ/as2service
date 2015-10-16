package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Oct 16, 2015 3:47:59 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ResetPasswd generated by hbm2java
 */
@Entity
@Table(name = "reset_passwd", catalog = "as2_app_db")
public class ResetPasswd implements java.io.Serializable {

	private long resetId;
	private long participantId;
	private String guid;
	private String emailAddress;
	private String status;
	private Date createdDate;
	private byte[] createdBy;
	private Date updatedDate;
	private byte[] updatedBy;

	public ResetPasswd() {
	}

	public ResetPasswd(long resetId, long participantId, String emailAddress) {
		this.resetId = resetId;
		this.participantId = participantId;
		this.emailAddress = emailAddress;
	}

	public ResetPasswd(long resetId, long participantId, String guid,
			String emailAddress, String status, Date createdDate,
			byte[] createdBy, Date updatedDate, byte[] updatedBy) {
		this.resetId = resetId;
		this.participantId = participantId;
		this.guid = guid;
		this.emailAddress = emailAddress;
		this.status = status;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@Column(name = "RESET_ID", unique = true, nullable = false)
	public long getResetId() {
		return this.resetId;
	}

	public void setResetId(long resetId) {
		this.resetId = resetId;
	}

	@Column(name = "PARTICIPANT_ID", nullable = false)
	public long getParticipantId() {
		return this.participantId;
	}

	public void setParticipantId(long participantId) {
		this.participantId = participantId;
	}

	@Column(name = "GUID", length = 200)
	public String getGuid() {
		return this.guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Column(name = "EMAIL_ADDRESS", nullable = false, length = 100)
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "STATUS", length = 10)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY")
	public byte[] getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(byte[] createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY")
	public byte[] getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(byte[] updatedBy) {
		this.updatedBy = updatedBy;
	}

}
