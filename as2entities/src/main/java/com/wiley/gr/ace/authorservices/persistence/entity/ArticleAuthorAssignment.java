package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 18, 2015 11:29:00 AM by Hibernate Tools 4.0.0

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
 * ArticleAuthorAssignment generated by hbm2java
 */
@Entity
@Table(name = "ARTICLE_AUTHOR_ASSIGNMENT")
public class ArticleAuthorAssignment implements java.io.Serializable {

	private Integer articleAuthId;
	private ArticleRoles articleRoles;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private UserProfile userProfile;
	private Articles articles;
	private String emailAddr;
	private Date dateActivated;
	private Date updatedDate;
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<CoauthorRequestsOoorders> coauthorRequestsOoorderses = new HashSet<CoauthorRequestsOoorders>(
			0);

	public ArticleAuthorAssignment() {
	}

	public ArticleAuthorAssignment(Integer articleAuthId) {
		this.articleAuthId = articleAuthId;
	}

	public ArticleAuthorAssignment(Integer articleAuthId,
			ArticleRoles articleRoles, Users usersByCreatedBy,
			Users usersByUpdatedBy, UserProfile userProfile, Articles articles,
			String emailAddr, Date dateActivated, Date updatedDate,
			Set<Orders> orderses,
			Set<CoauthorRequestsOoorders> coauthorRequestsOoorderses) {
		this.articleAuthId = articleAuthId;
		this.articleRoles = articleRoles;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.userProfile = userProfile;
		this.articles = articles;
		this.emailAddr = emailAddr;
		this.dateActivated = dateActivated;
		this.updatedDate = updatedDate;
		this.orderses = orderses;
		this.coauthorRequestsOoorderses = coauthorRequestsOoorderses;
	}

	@Id
	@Column(name = "ARTICLE_AUTH_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getArticleAuthId() {
		return this.articleAuthId;
	}

	public void setArticleAuthId(Integer articleAuthId) {
		this.articleAuthId = articleAuthId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTICLE_ROLE_CD")
	public ArticleRoles getArticleRoles() {
		return this.articleRoles;
	}

	public void setArticleRoles(ArticleRoles articleRoles) {
		this.articleRoles = articleRoles;
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
	@JoinColumn(name = "USER_ID")
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ARTICLE_ID")
	public Articles getArticles() {
		return this.articles;
	}

	public void setArticles(Articles articles) {
		this.articles = articles;
	}

	@Column(name = "EMAIL_ADDR", length = 250)
	public String getEmailAddr() {
		return this.emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_ACTIVATED", length = 7)
	public Date getDateActivated() {
		return this.dateActivated;
	}

	public void setDateActivated(Date dateActivated) {
		this.dateActivated = dateActivated;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articleAuthorAssignment")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articleAuthorAssignment")
	public Set<CoauthorRequestsOoorders> getCoauthorRequestsOoorderses() {
		return this.coauthorRequestsOoorderses;
	}

	public void setCoauthorRequestsOoorderses(
			Set<CoauthorRequestsOoorders> coauthorRequestsOoorderses) {
		this.coauthorRequestsOoorderses = coauthorRequestsOoorderses;
	}

}
