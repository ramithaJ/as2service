package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 18, 2015 11:29:00 AM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserPreferredJournals generated by hbm2java
 */
@Entity
@Table(name = "USER_PREFERRED_JOURNALS")
public class UserPreferredJournals implements java.io.Serializable {

	private UserPreferredJournalsId id;
	private Journals journals;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private UserProfile userProfile;
	private Integer favoriteJournalCnt;
	private Date createdDate;
	private Date updatedDate;

	public UserPreferredJournals() {
	}

	public UserPreferredJournals(UserPreferredJournalsId id, Journals journals,
			UserProfile userProfile) {
		this.id = id;
		this.journals = journals;
		this.userProfile = userProfile;
	}

	public UserPreferredJournals(UserPreferredJournalsId id, Journals journals,
			Users usersByCreatedBy, Users usersByUpdatedBy,
			UserProfile userProfile, Integer favoriteJournalCnt,
			Date createdDate, Date updatedDate) {
		this.id = id;
		this.journals = journals;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.userProfile = userProfile;
		this.favoriteJournalCnt = favoriteJournalCnt;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "journalId", column = @Column(name = "JOURNAL_ID", nullable = false, precision = 22, scale = 0)) })
	public UserPreferredJournalsId getId() {
		return this.id;
	}

	public void setId(UserPreferredJournalsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JOURNAL_ID", nullable = false, insertable = false, updatable = false)
	public Journals getJournals() {
		return this.journals;
	}

	public void setJournals(Journals journals) {
		this.journals = journals;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY")
	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATED_BY")
	public Users getUsersByUpdatedBy() {
		return this.usersByUpdatedBy;
	}

	public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
		this.usersByUpdatedBy = usersByUpdatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Column(name = "FAVORITE_JOURNAL_CNT", precision = 22, scale = 0)
	public Integer getFavoriteJournalCnt() {
		return this.favoriteJournalCnt;
	}

	public void setFavoriteJournalCnt(Integer favoriteJournalCnt) {
		this.favoriteJournalCnt = favoriteJournalCnt;
	}

	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
