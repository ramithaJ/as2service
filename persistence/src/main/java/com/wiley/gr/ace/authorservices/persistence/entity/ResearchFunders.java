package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 2:39:51 PM by Hibernate Tools 3.4.0.CR1

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
 * ResearchFunders generated by hbm2java
 */
@Entity
@Table(name = "RESEARCH_FUNDERS")
public class ResearchFunders implements java.io.Serializable {

	private Integer resfunderid;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Integer fundrefId;
	private String funderName;
	private Date createdDate;
	private Date updatedDate;
	private Set userFunderGrantses = new HashSet(0);

	public ResearchFunders() {
	}

	public ResearchFunders(Integer resfunderid) {
		this.resfunderid = resfunderid;
	}

	public ResearchFunders(Integer resfunderid, Users usersByCreatedBy,
			Users usersByUpdatedBy, Integer fundrefId, String funderName,
			Date createdDate, Date updatedDate, Set userFunderGrantses) {
		this.resfunderid = resfunderid;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.fundrefId = fundrefId;
		this.funderName = funderName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.userFunderGrantses = userFunderGrantses;
	}

	@Id
	@Column(name = "RESFUNDERID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getResfunderid() {
		return this.resfunderid;
	}

	public void setResfunderid(Integer resfunderid) {
		this.resfunderid = resfunderid;
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

	@Column(name = "FUNDREF_ID", precision = 22, scale = 0)
	public Integer getFundrefId() {
		return this.fundrefId;
	}

	public void setFundrefId(Integer fundrefId) {
		this.fundrefId = fundrefId;
	}

	@Column(name = "FUNDER_NAME", length = 250)
	public String getFunderName() {
		return this.funderName;
	}

	public void setFunderName(String funderName) {
		this.funderName = funderName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", length = 7)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "researchFunders")
	public Set getUserFunderGrantses() {
		return this.userFunderGrantses;
	}

	public void setUserFunderGrantses(Set userFunderGrantses) {
		this.userFunderGrantses = userFunderGrantses;
	}

}
