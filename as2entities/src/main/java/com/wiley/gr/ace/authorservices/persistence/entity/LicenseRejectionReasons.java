package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 29, 2015 12:48:43 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LicenseRejectionReasons generated by hbm2java
 */
@Entity
@Table(name = "license_rejection_reasons", catalog = "as2_app_db")
public class LicenseRejectionReasons implements java.io.Serializable {

	private String reasonCd;
	private String reasonText;
	private String reasonDescription;
	private Date createdDate;
	private Long createdBy;
	private Date updatedDate;
	private Long updatedBy;

	public LicenseRejectionReasons() {
	}

	public LicenseRejectionReasons(String reasonCd) {
		this.reasonCd = reasonCd;
	}

	public LicenseRejectionReasons(String reasonCd, String reasonText,
			String reasonDescription, Date createdDate, Long createdBy,
			Date updatedDate, Long updatedBy) {
		this.reasonCd = reasonCd;
		this.reasonText = reasonText;
		this.reasonDescription = reasonDescription;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@Column(name = "REASON_CD", unique = true, nullable = false, length = 15)
	public String getReasonCd() {
		return this.reasonCd;
	}

	public void setReasonCd(String reasonCd) {
		this.reasonCd = reasonCd;
	}

	@Column(name = "REASON_TEXT", length = 100)
	public String getReasonText() {
		return this.reasonText;
	}

	public void setReasonText(String reasonText) {
		this.reasonText = reasonText;
	}

	@Column(name = "REASON_DESCRIPTION", length = 3000)
	public String getReasonDescription() {
		return this.reasonDescription;
	}

	public void setReasonDescription(String reasonDescription) {
		this.reasonDescription = reasonDescription;
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
	public Long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Long createdBy) {
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
	public Long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

}
