package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Oct 14, 2015 5:33:21 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AreaOfInterest generated by hbm2java
 */
@Entity
@Table(name = "area_of_interest", catalog = "as2_app_db")
public class AreaOfInterest implements java.io.Serializable {

	private String areaOfInterestCd;
	private String interestName;
	private Date createdDate;
	private byte[] createdBy;
	private Date updatedDate;
	private byte[] updatedBy;

	public AreaOfInterest() {
	}

	public AreaOfInterest(String areaOfInterestCd) {
		this.areaOfInterestCd = areaOfInterestCd;
	}

	public AreaOfInterest(String areaOfInterestCd, String interestName,
			Date createdDate, byte[] createdBy, Date updatedDate,
			byte[] updatedBy) {
		this.areaOfInterestCd = areaOfInterestCd;
		this.interestName = interestName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@Column(name = "AREA_OF_INTEREST_CD", unique = true, nullable = false, length = 15)
	public String getAreaOfInterestCd() {
		return this.areaOfInterestCd;
	}

	public void setAreaOfInterestCd(String areaOfInterestCd) {
		this.areaOfInterestCd = areaOfInterestCd;
	}

	@Column(name = "INTEREST_NAME", length = 250)
	public String getInterestName() {
		return this.interestName;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
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
