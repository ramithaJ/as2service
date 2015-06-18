package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 18, 2015 11:29:00 AM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CoauthorRequestsOoorders generated by hbm2java
 */
@Entity
@Table(name = "COAUTHOR_REQUESTS_OOORDERS")
public class CoauthorRequestsOoorders implements java.io.Serializable {

	private Integer requestId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private ArticleAuthorAssignment articleAuthorAssignment;
	private Date createdDate;
	private Date updatedDate;

	public CoauthorRequestsOoorders() {
	}

	public CoauthorRequestsOoorders(Integer requestId) {
		this.requestId = requestId;
	}

	public CoauthorRequestsOoorders(Integer requestId, Users usersByCreatedBy,
			Users usersByUpdatedBy,
			ArticleAuthorAssignment articleAuthorAssignment, Date createdDate,
			Date updatedDate) {
		this.requestId = requestId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.articleAuthorAssignment = articleAuthorAssignment;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "REQUEST_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
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
	@JoinColumn(name = "ARTICLE_AUTH_ID")
	public ArticleAuthorAssignment getArticleAuthorAssignment() {
		return this.articleAuthorAssignment;
	}

	public void setArticleAuthorAssignment(
			ArticleAuthorAssignment articleAuthorAssignment) {
		this.articleAuthorAssignment = articleAuthorAssignment;
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

}
