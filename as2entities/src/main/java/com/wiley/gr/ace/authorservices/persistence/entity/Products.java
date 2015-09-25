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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name = "products", catalog = "as2_app_db")
public class Products implements java.io.Serializable {

	private long dhId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String dhTypeCd;
	private Date createdDate;
	private Date updatedDate;
	private Set<InvitationLog> invitationLogs = new HashSet<InvitationLog>(0);
	private Set<JournalAlertsConfiguration> journalAlertsConfigurations = new HashSet<JournalAlertsConfiguration>(
			0);
	private Set<CoauthorRequestsOoorders> coauthorRequestsOoorderses = new HashSet<CoauthorRequestsOoorders>(
			0);
	private Set<SavedOrders> savedOrderses = new HashSet<SavedOrders>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<SavedLicenses> savedLicenseses = new HashSet<SavedLicenses>(0);
	private Set<SocietyJournals> societyJournalses = new HashSet<SocietyJournals>(
			0);
	private JournalConfiguration journalConfiguration;
	private Set<RejectedLicenseDetails> rejectedLicenseDetailses = new HashSet<RejectedLicenseDetails>(
			0);
	private Set<ProductRelations> productRelationsesForParentDhId = new HashSet<ProductRelations>(
			0);
	private Set<ProductPersonRelations> productPersonRelationses = new HashSet<ProductPersonRelations>(
			0);
	private Set<UserPreferredJournals> userPreferredJournalses = new HashSet<UserPreferredJournals>(
			0);
	private Set<ProductPublicationStatuses> productPublicationStatuseses = new HashSet<ProductPublicationStatuses>(
			0);
	private Set<ProductRelations> productRelationsesForChildDhId = new HashSet<ProductRelations>(
			0);
	private ArticleConfiguration articleConfiguration;

	public Products() {
	}

	public Products(long dhId) {
		this.dhId = dhId;
	}

	public Products(long dhId, Users usersByCreatedBy, Users usersByUpdatedBy,
			String dhTypeCd, Date createdDate, Date updatedDate,
			Set<InvitationLog> invitationLogs,
			Set<JournalAlertsConfiguration> journalAlertsConfigurations,
			Set<CoauthorRequestsOoorders> coauthorRequestsOoorderses,
			Set<SavedOrders> savedOrderses, Set<Orders> orderses,
			Set<SavedLicenses> savedLicenseses,
			Set<SocietyJournals> societyJournalses,
			JournalConfiguration journalConfiguration,
			Set<RejectedLicenseDetails> rejectedLicenseDetailses,
			Set<ProductRelations> productRelationsesForParentDhId,
			Set<ProductPersonRelations> productPersonRelationses,
			Set<UserPreferredJournals> userPreferredJournalses,
			Set<ProductPublicationStatuses> productPublicationStatuseses,
			Set<ProductRelations> productRelationsesForChildDhId,
			ArticleConfiguration articleConfiguration) {
		this.dhId = dhId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.dhTypeCd = dhTypeCd;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.invitationLogs = invitationLogs;
		this.journalAlertsConfigurations = journalAlertsConfigurations;
		this.coauthorRequestsOoorderses = coauthorRequestsOoorderses;
		this.savedOrderses = savedOrderses;
		this.orderses = orderses;
		this.savedLicenseses = savedLicenseses;
		this.societyJournalses = societyJournalses;
		this.journalConfiguration = journalConfiguration;
		this.rejectedLicenseDetailses = rejectedLicenseDetailses;
		this.productRelationsesForParentDhId = productRelationsesForParentDhId;
		this.productPersonRelationses = productPersonRelationses;
		this.userPreferredJournalses = userPreferredJournalses;
		this.productPublicationStatuseses = productPublicationStatuseses;
		this.productRelationsesForChildDhId = productRelationsesForChildDhId;
		this.articleConfiguration = articleConfiguration;
	}

	@Id
	@Column(name = "DH_ID", unique = true, nullable = false)
	public long getDhId() {
		return this.dhId;
	}

	public void setDhId(long dhId) {
		this.dhId = dhId;
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

	@Column(name = "DH_TYPE_CD", length = 15)
	public String getDhTypeCd() {
		return this.dhTypeCd;
	}

	public void setDhTypeCd(String dhTypeCd) {
		this.dhTypeCd = dhTypeCd;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<InvitationLog> getInvitationLogs() {
		return this.invitationLogs;
	}

	public void setInvitationLogs(Set<InvitationLog> invitationLogs) {
		this.invitationLogs = invitationLogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<JournalAlertsConfiguration> getJournalAlertsConfigurations() {
		return this.journalAlertsConfigurations;
	}

	public void setJournalAlertsConfigurations(
			Set<JournalAlertsConfiguration> journalAlertsConfigurations) {
		this.journalAlertsConfigurations = journalAlertsConfigurations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<CoauthorRequestsOoorders> getCoauthorRequestsOoorderses() {
		return this.coauthorRequestsOoorderses;
	}

	public void setCoauthorRequestsOoorderses(
			Set<CoauthorRequestsOoorders> coauthorRequestsOoorderses) {
		this.coauthorRequestsOoorderses = coauthorRequestsOoorderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<SavedOrders> getSavedOrderses() {
		return this.savedOrderses;
	}

	public void setSavedOrderses(Set<SavedOrders> savedOrderses) {
		this.savedOrderses = savedOrderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<SavedLicenses> getSavedLicenseses() {
		return this.savedLicenseses;
	}

	public void setSavedLicenseses(Set<SavedLicenses> savedLicenseses) {
		this.savedLicenseses = savedLicenseses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<SocietyJournals> getSocietyJournalses() {
		return this.societyJournalses;
	}

	public void setSocietyJournalses(Set<SocietyJournals> societyJournalses) {
		this.societyJournalses = societyJournalses;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "products")
	public JournalConfiguration getJournalConfiguration() {
		return this.journalConfiguration;
	}

	public void setJournalConfiguration(
			JournalConfiguration journalConfiguration) {
		this.journalConfiguration = journalConfiguration;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<RejectedLicenseDetails> getRejectedLicenseDetailses() {
		return this.rejectedLicenseDetailses;
	}

	public void setRejectedLicenseDetailses(
			Set<RejectedLicenseDetails> rejectedLicenseDetailses) {
		this.rejectedLicenseDetailses = rejectedLicenseDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productsByParentDhId")
	public Set<ProductRelations> getProductRelationsesForParentDhId() {
		return this.productRelationsesForParentDhId;
	}

	public void setProductRelationsesForParentDhId(
			Set<ProductRelations> productRelationsesForParentDhId) {
		this.productRelationsesForParentDhId = productRelationsesForParentDhId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<ProductPersonRelations> getProductPersonRelationses() {
		return this.productPersonRelationses;
	}

	public void setProductPersonRelationses(
			Set<ProductPersonRelations> productPersonRelationses) {
		this.productPersonRelationses = productPersonRelationses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<UserPreferredJournals> getUserPreferredJournalses() {
		return this.userPreferredJournalses;
	}

	public void setUserPreferredJournalses(
			Set<UserPreferredJournals> userPreferredJournalses) {
		this.userPreferredJournalses = userPreferredJournalses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<ProductPublicationStatuses> getProductPublicationStatuseses() {
		return this.productPublicationStatuseses;
	}

	public void setProductPublicationStatuseses(
			Set<ProductPublicationStatuses> productPublicationStatuseses) {
		this.productPublicationStatuseses = productPublicationStatuseses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productsByChildDhId")
	public Set<ProductRelations> getProductRelationsesForChildDhId() {
		return this.productRelationsesForChildDhId;
	}

	public void setProductRelationsesForChildDhId(
			Set<ProductRelations> productRelationsesForChildDhId) {
		this.productRelationsesForChildDhId = productRelationsesForChildDhId;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "products")
	public ArticleConfiguration getArticleConfiguration() {
		return this.articleConfiguration;
	}

	public void setArticleConfiguration(
			ArticleConfiguration articleConfiguration) {
		this.articleConfiguration = articleConfiguration;
	}

}
