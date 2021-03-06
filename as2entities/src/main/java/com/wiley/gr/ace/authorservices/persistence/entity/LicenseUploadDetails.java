package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Oct 19, 2015 4:16:00 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.UUID;
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
 * LicenseUploadDetails generated by hbm2java
 */
@Entity
@Table(name = "license_upload_details", catalog = "as2_app_db")
public class LicenseUploadDetails implements java.io.Serializable {

	private Long uploadId;
	private SavedLicenses savedLicenses;
	private byte[] licenseFile;
	private Date createdDate;
	private UUID createdBy;
	private Date updatedDate;
	private UUID updatedBy;

	public LicenseUploadDetails() {
	}

	public LicenseUploadDetails(SavedLicenses savedLicenses,
			byte[] licenseFile, Date createdDate, UUID createdBy,
			Date updatedDate, UUID updatedBy) {
		this.savedLicenses = savedLicenses;
		this.licenseFile = licenseFile;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "UPLOAD_ID", unique = true, nullable = false)
	public Long getUploadId() {
		return this.uploadId;
	}

	public void setUploadId(Long uploadId) {
		this.uploadId = uploadId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LICENSE_ID")
	public SavedLicenses getSavedLicenses() {
		return this.savedLicenses;
	}

	public void setSavedLicenses(SavedLicenses savedLicenses) {
		this.savedLicenses = savedLicenses;
	}

	@Column(name = "LICENSE_FILE")
	public byte[] getLicenseFile() {
		return this.licenseFile;
	}

	public void setLicenseFile(byte[] licenseFile) {
		this.licenseFile = licenseFile;
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
	public UUID getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
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
	public UUID getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(UUID updatedBy) {
		this.updatedBy = updatedBy;
	}

}
