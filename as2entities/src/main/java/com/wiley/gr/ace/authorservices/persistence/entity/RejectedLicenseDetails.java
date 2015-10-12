package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Oct 12, 2015 11:27:32 AM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * RejectedLicenseDetails generated by hbm2java
 */
@Entity
@Table(name = "rejected_license_details", catalog = "as2_app_db")
public class RejectedLicenseDetails implements java.io.Serializable {

	private Long rejectedId;
	private LicenseRejectionReasons licenseRejectionReasons;
	private Long dhId;
	private Date createdDate;
	private byte[] createdBy;
	private Date updatedDate;
	private byte[] updatedBy;

	public RejectedLicenseDetails() {
	}

	public RejectedLicenseDetails(
			LicenseRejectionReasons licenseRejectionReasons, Long dhId,
			Date createdDate, byte[] createdBy, Date updatedDate,
			byte[] updatedBy) {
		this.licenseRejectionReasons = licenseRejectionReasons;
		this.dhId = dhId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "REJECTED_ID", unique = true, nullable = false)
	public Long getRejectedId() {
		return this.rejectedId;
	}

	public void setRejectedId(Long rejectedId) {
		this.rejectedId = rejectedId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REJECTION_REASON_CD")
	public LicenseRejectionReasons getLicenseRejectionReasons() {
		return this.licenseRejectionReasons;
	}

	public void setLicenseRejectionReasons(
			LicenseRejectionReasons licenseRejectionReasons) {
		this.licenseRejectionReasons = licenseRejectionReasons;
	}

	@Column(name = "DH_ID")
	public Long getDhId() {
		return this.dhId;
	}

	public void setDhId(Long dhId) {
		this.dhId = dhId;
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
