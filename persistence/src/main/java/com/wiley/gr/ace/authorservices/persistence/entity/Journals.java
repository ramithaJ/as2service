package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 6:09:14 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Journals generated by hbm2java
 */
@Entity
@Table(name = "JOURNALS")
public class Journals implements java.io.Serializable {

	private Integer journalId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Integer dhId;
	private String jouTitle;
	private Character jouInvitedInAs;
	private Date createdDate;
	private Date updatedDate;
	private Set<UserPreferredJournals> userPreferredJournalses = new HashSet<UserPreferredJournals>(
			0);

	public Journals() {
	}

	public Journals(Integer journalId) {
		this.journalId = journalId;
	}

	public Journals(Integer journalId, Users usersByCreatedBy,
			Users usersByUpdatedBy, Integer dhId, String jouTitle,
			Character jouInvitedInAs, Date createdDate, Date updatedDate,
			Set<UserPreferredJournals> userPreferredJournalses) {
		this.journalId = journalId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.dhId = dhId;
		this.jouTitle = jouTitle;
		this.jouInvitedInAs = jouInvitedInAs;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.userPreferredJournalses = userPreferredJournalses;
	}

	@Id
	@Column(name = "JOURNAL_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getJournalId() {
		return this.journalId;
	}

	public void setJournalId(Integer journalId) {
		this.journalId = journalId;
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

	@Column(name = "DH_ID", precision = 22, scale = 0)
	public Integer getDhId() {
		return this.dhId;
	}

	public void setDhId(Integer dhId) {
		this.dhId = dhId;
	}

	@Column(name = "JOU_TITLE", length = 300)
	public String getJouTitle() {
		return this.jouTitle;
	}

	public void setJouTitle(String jouTitle) {
		this.jouTitle = jouTitle;
	}

	@Column(name = "JOU_INVITED_IN_AS", length = 1)
	public Character getJouInvitedInAs() {
		return this.jouInvitedInAs;
	}

	public void setJouInvitedInAs(Character jouInvitedInAs) {
		this.jouInvitedInAs = jouInvitedInAs;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "journals")
	public Set<UserPreferredJournals> getUserPreferredJournalses() {
		return this.userPreferredJournalses;
	}

	public void setUserPreferredJournalses(
			Set<UserPreferredJournals> userPreferredJournalses) {
		this.userPreferredJournalses = userPreferredJournalses;
	}

}
