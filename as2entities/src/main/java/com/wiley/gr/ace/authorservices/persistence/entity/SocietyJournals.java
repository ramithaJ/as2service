package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 29, 2015 12:48:43 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SocietyJournals generated by hbm2java
 */
@Entity
@Table(name = "society_journals", catalog = "as2_app_db")
public class SocietyJournals implements java.io.Serializable {

	private Long societyJournalId;
	private String societyCd;
	private Long dhId;
	private Date createdDate;
	private Long createdBy;
	private Date updatedDate;
	private Long updatedBy;

	public SocietyJournals() {
	}

	public SocietyJournals(String societyCd, Long dhId, Date createdDate,
			Long createdBy, Date updatedDate, Long updatedBy) {
		this.societyCd = societyCd;
		this.dhId = dhId;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SOCIETY_JOURNAL_ID", unique = true, nullable = false)
	public Long getSocietyJournalId() {
		return this.societyJournalId;
	}

	public void setSocietyJournalId(Long societyJournalId) {
		this.societyJournalId = societyJournalId;
	}

	@Column(name = "SOCIETY_CD", length = 15)
	public String getSocietyCd() {
		return this.societyCd;
	}

	public void setSocietyCd(String societyCd) {
		this.societyCd = societyCd;
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
