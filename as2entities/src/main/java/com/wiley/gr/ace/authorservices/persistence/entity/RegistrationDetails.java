package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Oct 19, 2015 4:16:00 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * RegistrationDetails generated by hbm2java
 */
@Entity
@Table(name = "registration_details", catalog = "as2_app_db", uniqueConstraints = @UniqueConstraint(columnNames = "ALM_USER_ID"))
public class RegistrationDetails implements java.io.Serializable {

	private long registrastionDetailId;
	private String almUserId;
	private byte[] registrastionObject;
	private UUID createdBy;
	private Date createdDate;
	private UUID updatedBy;
	private Date updatedDate;

	public RegistrationDetails() {
	}

	public RegistrationDetails(long registrastionDetailId) {
		this.registrastionDetailId = registrastionDetailId;
	}

	public RegistrationDetails(long registrastionDetailId, String almUserId,
			byte[] registrastionObject, UUID createdBy, Date createdDate,
			UUID updatedBy, Date updatedDate) {
		this.registrastionDetailId = registrastionDetailId;
		this.almUserId = almUserId;
		this.registrastionObject = registrastionObject;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "REGISTRASTION_DETAIL_ID", unique = true, nullable = false)
	public long getRegistrastionDetailId() {
		return this.registrastionDetailId;
	}

	public void setRegistrastionDetailId(long registrastionDetailId) {
		this.registrastionDetailId = registrastionDetailId;
	}

	@Column(name = "ALM_USER_ID", unique = true)
	public String getAlmUserId() {
		return this.almUserId;
	}

	public void setAlmUserId(String almUserId) {
		this.almUserId = almUserId;
	}

	@Column(name = "REGISTRASTION_OBJECT")
	public byte[] getRegistrastionObject() {
		return this.registrastionObject;
	}

	public void setRegistrastionObject(byte[] registrastionObject) {
		this.registrastionObject = registrastionObject;
	}

	@Column(name = "CREATED_BY")
	public UUID getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_BY")
	public UUID getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(UUID updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
