package com.wiley.gr.ace.authorservices.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "EMAIL_TYPE")
public class EmailType implements java.io.Serializable {

	private BigDecimal emailTypeId;
	private String description;
	private Serializable createdDate;
	private String craetedBy;
	private Serializable updatedDate;
	private String updatedBy;

	public EmailType() {
	}

	public EmailType(BigDecimal emailTypeId) {
		this.emailTypeId = emailTypeId;
	}

	public EmailType(BigDecimal emailTypeId, String description,
			Serializable createdDate, String craetedBy,
			Serializable updatedDate, String updatedBy) {
		this.emailTypeId = emailTypeId;
		this.description = description;
		this.createdDate = createdDate;
		this.craetedBy = craetedBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@Column(name = "EMAIL_TYPE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getEmailTypeId() {
		return this.emailTypeId;
	}

	public void setEmailTypeId(BigDecimal emailTypeId) {
		this.emailTypeId = emailTypeId;
	}

	@Column(name = "DESCRIPTION", length = 50)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CREATED_DATE")
	public Serializable getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Serializable createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CRAETED_BY", length = 50)
	public String getCraetedBy() {
		return this.craetedBy;
	}

	public void setCraetedBy(String craetedBy) {
		this.craetedBy = craetedBy;
	}

	@Column(name = "UPDATED_DATE")
	public Serializable getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Serializable updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY", length = 50)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
