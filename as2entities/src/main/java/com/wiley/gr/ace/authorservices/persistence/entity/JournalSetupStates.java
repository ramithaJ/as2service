package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Sep 24, 2015 5:21:06 PM by Hibernate Tools 4.0.0

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * JournalSetupStates generated by hbm2java
 */
@Entity
@Table(name = "journal_setup_states", catalog = "as2_app_db")
public class JournalSetupStates implements java.io.Serializable {

	private String setupStateCd;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String setupStateName;
	private Date createdDate;
	private Date updatedDate;
	private Set<JournalConfiguration> journalConfigurations = new HashSet<JournalConfiguration>(
			0);

	public JournalSetupStates() {
	}

	public JournalSetupStates(String setupStateCd) {
		this.setupStateCd = setupStateCd;
	}

	public JournalSetupStates(String setupStateCd, Users usersByCreatedBy,
			Users usersByUpdatedBy, String setupStateName, Date createdDate,
			Date updatedDate, Set<JournalConfiguration> journalConfigurations) {
		this.setupStateCd = setupStateCd;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.setupStateName = setupStateName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.journalConfigurations = journalConfigurations;
	}

	@Id
	@Column(name = "SETUP_STATE_CD", unique = true, nullable = false, length = 15)
	public String getSetupStateCd() {
		return this.setupStateCd;
	}

	public void setSetupStateCd(String setupStateCd) {
		this.setupStateCd = setupStateCd;
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

	@Column(name = "SETUP_STATE_NAME", length = 250)
	public String getSetupStateName() {
		return this.setupStateName;
	}

	public void setSetupStateName(String setupStateName) {
		this.setupStateName = setupStateName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "journalSetupStates")
	public Set<JournalConfiguration> getJournalConfigurations() {
		return this.journalConfigurations;
	}

	public void setJournalConfigurations(
			Set<JournalConfiguration> journalConfigurations) {
		this.journalConfigurations = journalConfigurations;
	}

}
