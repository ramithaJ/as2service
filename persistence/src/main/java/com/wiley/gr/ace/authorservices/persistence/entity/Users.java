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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = "PRIMARY_EMAIL_ADDR"))
public class Users implements java.io.Serializable {

	private Integer userId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String firstName;
	private String lastName;
	private String primaryEmailAddr;
	private Integer as1UserId;
	private Integer invalidLoginCnt;
	private Date accountLockedTime;
	private Date lastLoginDate;
	private Date createdDate;
	private Date updatedDate;
	private Set auditDetailsesForUserId = new HashSet(0);
	private Set userSecondaryEmailAddrsForUpdatedBy = new HashSet(0);
	private Set additionalPermissionsesForUpdatedBy = new HashSet(0);
	private Set userRolesesForCreatedBy = new HashSet(0);
	private Set auditDetailsesForCreatedBy = new HashSet(0);
	private Set userSecondaryEmailAddrsForCreatedBy = new HashSet(0);
	private Set userAffiliationsesForUpdatedBy = new HashSet(0);
	private Set userAlertsesForUpdatedBy = new HashSet(0);
	private Set userSocietyDetailsesForUpdatedBy = new HashSet(0);
	private Set additionalPermissionsesForCreatedBy = new HashSet(0);
	private Set rolePermissionsesForUpdatedBy = new HashSet(0);
	private Set rolePermissionsesForCreatedBy = new HashSet(0);
	private Set userRolesesForUpdatedBy = new HashSet(0);
	private Set authorProfilesForMergerAccntId = new HashSet(0);
	private Set userReferenceDatasForCreatedBy = new HashSet(0);
	private Set adminDetailsesForUpdatedBy = new HashSet(0);
	private Set userAffiliationsesForCreatedBy = new HashSet(0);
	private Set userAlertsesForCreatedBy = new HashSet(0);
	private Set userSocietyDetailsesForCreatedBy = new HashSet(0);
	private Set alertsesForUpdatedBy = new HashSet(0);
	private Set alertsesForCreatedBy = new HashSet(0);
	private Set authCoauthDetailsesForUpdatedBy = new HashSet(0);
	private Set authCoauthDetailsesForCreatedBy = new HashSet(0);
	private Set userReferenceDatasForUpdatedBy = new HashSet(0);
	private Set userAreaOfInterestsForCreatedBy = new HashSet(0);
	private Set userAddressesesForUserId = new HashSet(0);
	private Set userPreferredJournalsesForUpdatedBy = new HashSet(0);
	private Set userReferenceDatasForUserId = new HashSet(0);
	private Set userPreferredJournalsesForCreatedBy = new HashSet(0);
	private Set journalsesForCreatedBy = new HashSet(0);
	private Set userProfileAttribVisiblesForUpdatedBy = new HashSet(0);
	private Set userProfileAttribVisiblesForCreatedBy = new HashSet(0);
	private Set rolesesForUpdatedBy = new HashSet(0);
	private Set userAddressesesForUpdatedBy = new HashSet(0);
	private Set rolesesForCreatedBy = new HashSet(0);
	private Set userAddressesesForCreatedBy = new HashSet(0);
	private Set addressesForUpdatedBy = new HashSet(0);
	private Set addressesForCreatedBy = new HashSet(0);
	private Set journalsesForUpdatedBy = new HashSet(0);
	private Set usersesForCreatedBy = new HashSet(0);
	private Set authorProfilesForUpdatedBy = new HashSet(0);
	private Set authorProfilesForCreatedBy = new HashSet(0);
	private Set usersesForUpdatedBy = new HashSet(0);
	private Set userAreaOfInterestsForUpdatedBy = new HashSet(0);
	private Set authColleagueDetailsesForCreatedBy = new HashSet(0);
	private Set areaOfInterestsForUpdatedBy = new HashSet(0);
	private Set areaOfInterestsForCreatedBy = new HashSet(0);
	private AdminDetails adminDetailsByUserId;
	private AuthorProfile authorProfileByUserId;
	private Set permissionsesForCreatedBy = new HashSet(0);
	private Set researchFundersesForCreatedBy = new HashSet(0);
	private Set adminDetailsesForCreatedBy = new HashSet(0);
	private Set userWoaAccountsesForUpdatedBy = new HashSet(0);
	private Set userWoaAccountsesForCreatedBy = new HashSet(0);
	private Set authColleagueDetailsesForUpdatedBy = new HashSet(0);
	private Set userFunderGrantsesForUpdatedBy = new HashSet(0);
	private Set userFunderGrantsesForCreatedBy = new HashSet(0);
	private Set permissionsesForUpdatedBy = new HashSet(0);
	private Set researchFundersesForUpdatedBy = new HashSet(0);
	private Set userSecondaryEmailAddrsForUserId = new HashSet(0);
	private Set profileAttributeListsForUpdatedBy = new HashSet(0);
	private Set userRolesesForUserId = new HashSet(0);
	private Set profileAttributeListsForCreatedBy = new HashSet(0);

	public Users() {
	}

	public Users(Integer userId, String primaryEmailAddr) {
		this.userId = userId;
		this.primaryEmailAddr = primaryEmailAddr;
	}

	public Users(Integer userId, Users usersByCreatedBy,
			Users usersByUpdatedBy, String firstName, String lastName,
			String primaryEmailAddr, Integer as1UserId,
			Integer invalidLoginCnt, Date accountLockedTime,
			Date lastLoginDate, Date createdDate, Date updatedDate,
			Set auditDetailsesForUserId,
			Set userSecondaryEmailAddrsForUpdatedBy,
			Set additionalPermissionsesForUpdatedBy,
			Set userRolesesForCreatedBy, Set auditDetailsesForCreatedBy,
			Set userSecondaryEmailAddrsForCreatedBy,
			Set userAffiliationsesForUpdatedBy, Set userAlertsesForUpdatedBy,
			Set userSocietyDetailsesForUpdatedBy,
			Set additionalPermissionsesForCreatedBy,
			Set rolePermissionsesForUpdatedBy,
			Set rolePermissionsesForCreatedBy, Set userRolesesForUpdatedBy,
			Set authorProfilesForMergerAccntId,
			Set userReferenceDatasForCreatedBy, Set adminDetailsesForUpdatedBy,
			Set userAffiliationsesForCreatedBy, Set userAlertsesForCreatedBy,
			Set userSocietyDetailsesForCreatedBy, Set alertsesForUpdatedBy,
			Set alertsesForCreatedBy, Set authCoauthDetailsesForUpdatedBy,
			Set authCoauthDetailsesForCreatedBy,
			Set userReferenceDatasForUpdatedBy,
			Set userAreaOfInterestsForCreatedBy, Set userAddressesesForUserId,
			Set userPreferredJournalsesForUpdatedBy,
			Set userReferenceDatasForUserId,
			Set userPreferredJournalsesForCreatedBy,
			Set journalsesForCreatedBy,
			Set userProfileAttribVisiblesForUpdatedBy,
			Set userProfileAttribVisiblesForCreatedBy, Set rolesesForUpdatedBy,
			Set userAddressesesForUpdatedBy, Set rolesesForCreatedBy,
			Set userAddressesesForCreatedBy, Set addressesForUpdatedBy,
			Set addressesForCreatedBy, Set journalsesForUpdatedBy,
			Set usersesForCreatedBy, Set authorProfilesForUpdatedBy,
			Set authorProfilesForCreatedBy, Set usersesForUpdatedBy,
			Set userAreaOfInterestsForUpdatedBy,
			Set authColleagueDetailsesForCreatedBy,
			Set areaOfInterestsForUpdatedBy, Set areaOfInterestsForCreatedBy,
			AdminDetails adminDetailsByUserId,
			AuthorProfile authorProfileByUserId, Set permissionsesForCreatedBy,
			Set researchFundersesForCreatedBy, Set adminDetailsesForCreatedBy,
			Set userWoaAccountsesForUpdatedBy,
			Set userWoaAccountsesForCreatedBy,
			Set authColleagueDetailsesForUpdatedBy,
			Set userFunderGrantsesForUpdatedBy,
			Set userFunderGrantsesForCreatedBy, Set permissionsesForUpdatedBy,
			Set researchFundersesForUpdatedBy,
			Set userSecondaryEmailAddrsForUserId,
			Set profileAttributeListsForUpdatedBy, Set userRolesesForUserId,
			Set profileAttributeListsForCreatedBy) {
		this.userId = userId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.firstName = firstName;
		this.lastName = lastName;
		this.primaryEmailAddr = primaryEmailAddr;
		this.as1UserId = as1UserId;
		this.invalidLoginCnt = invalidLoginCnt;
		this.accountLockedTime = accountLockedTime;
		this.lastLoginDate = lastLoginDate;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.auditDetailsesForUserId = auditDetailsesForUserId;
		this.userSecondaryEmailAddrsForUpdatedBy = userSecondaryEmailAddrsForUpdatedBy;
		this.additionalPermissionsesForUpdatedBy = additionalPermissionsesForUpdatedBy;
		this.userRolesesForCreatedBy = userRolesesForCreatedBy;
		this.auditDetailsesForCreatedBy = auditDetailsesForCreatedBy;
		this.userSecondaryEmailAddrsForCreatedBy = userSecondaryEmailAddrsForCreatedBy;
		this.userAffiliationsesForUpdatedBy = userAffiliationsesForUpdatedBy;
		this.userAlertsesForUpdatedBy = userAlertsesForUpdatedBy;
		this.userSocietyDetailsesForUpdatedBy = userSocietyDetailsesForUpdatedBy;
		this.additionalPermissionsesForCreatedBy = additionalPermissionsesForCreatedBy;
		this.rolePermissionsesForUpdatedBy = rolePermissionsesForUpdatedBy;
		this.rolePermissionsesForCreatedBy = rolePermissionsesForCreatedBy;
		this.userRolesesForUpdatedBy = userRolesesForUpdatedBy;
		this.authorProfilesForMergerAccntId = authorProfilesForMergerAccntId;
		this.userReferenceDatasForCreatedBy = userReferenceDatasForCreatedBy;
		this.adminDetailsesForUpdatedBy = adminDetailsesForUpdatedBy;
		this.userAffiliationsesForCreatedBy = userAffiliationsesForCreatedBy;
		this.userAlertsesForCreatedBy = userAlertsesForCreatedBy;
		this.userSocietyDetailsesForCreatedBy = userSocietyDetailsesForCreatedBy;
		this.alertsesForUpdatedBy = alertsesForUpdatedBy;
		this.alertsesForCreatedBy = alertsesForCreatedBy;
		this.authCoauthDetailsesForUpdatedBy = authCoauthDetailsesForUpdatedBy;
		this.authCoauthDetailsesForCreatedBy = authCoauthDetailsesForCreatedBy;
		this.userReferenceDatasForUpdatedBy = userReferenceDatasForUpdatedBy;
		this.userAreaOfInterestsForCreatedBy = userAreaOfInterestsForCreatedBy;
		this.userAddressesesForUserId = userAddressesesForUserId;
		this.userPreferredJournalsesForUpdatedBy = userPreferredJournalsesForUpdatedBy;
		this.userReferenceDatasForUserId = userReferenceDatasForUserId;
		this.userPreferredJournalsesForCreatedBy = userPreferredJournalsesForCreatedBy;
		this.journalsesForCreatedBy = journalsesForCreatedBy;
		this.userProfileAttribVisiblesForUpdatedBy = userProfileAttribVisiblesForUpdatedBy;
		this.userProfileAttribVisiblesForCreatedBy = userProfileAttribVisiblesForCreatedBy;
		this.rolesesForUpdatedBy = rolesesForUpdatedBy;
		this.userAddressesesForUpdatedBy = userAddressesesForUpdatedBy;
		this.rolesesForCreatedBy = rolesesForCreatedBy;
		this.userAddressesesForCreatedBy = userAddressesesForCreatedBy;
		this.addressesForUpdatedBy = addressesForUpdatedBy;
		this.addressesForCreatedBy = addressesForCreatedBy;
		this.journalsesForUpdatedBy = journalsesForUpdatedBy;
		this.usersesForCreatedBy = usersesForCreatedBy;
		this.authorProfilesForUpdatedBy = authorProfilesForUpdatedBy;
		this.authorProfilesForCreatedBy = authorProfilesForCreatedBy;
		this.usersesForUpdatedBy = usersesForUpdatedBy;
		this.userAreaOfInterestsForUpdatedBy = userAreaOfInterestsForUpdatedBy;
		this.authColleagueDetailsesForCreatedBy = authColleagueDetailsesForCreatedBy;
		this.areaOfInterestsForUpdatedBy = areaOfInterestsForUpdatedBy;
		this.areaOfInterestsForCreatedBy = areaOfInterestsForCreatedBy;
		this.adminDetailsByUserId = adminDetailsByUserId;
		this.authorProfileByUserId = authorProfileByUserId;
		this.permissionsesForCreatedBy = permissionsesForCreatedBy;
		this.researchFundersesForCreatedBy = researchFundersesForCreatedBy;
		this.adminDetailsesForCreatedBy = adminDetailsesForCreatedBy;
		this.userWoaAccountsesForUpdatedBy = userWoaAccountsesForUpdatedBy;
		this.userWoaAccountsesForCreatedBy = userWoaAccountsesForCreatedBy;
		this.authColleagueDetailsesForUpdatedBy = authColleagueDetailsesForUpdatedBy;
		this.userFunderGrantsesForUpdatedBy = userFunderGrantsesForUpdatedBy;
		this.userFunderGrantsesForCreatedBy = userFunderGrantsesForCreatedBy;
		this.permissionsesForUpdatedBy = permissionsesForUpdatedBy;
		this.researchFundersesForUpdatedBy = researchFundersesForUpdatedBy;
		this.userSecondaryEmailAddrsForUserId = userSecondaryEmailAddrsForUserId;
		this.profileAttributeListsForUpdatedBy = profileAttributeListsForUpdatedBy;
		this.userRolesesForUserId = userRolesesForUserId;
		this.profileAttributeListsForCreatedBy = profileAttributeListsForCreatedBy;
	}

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	@Column(name = "FIRST_NAME", length = 100)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", length = 100)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "PRIMARY_EMAIL_ADDR", unique = true, nullable = false, length = 256)
	public String getPrimaryEmailAddr() {
		return this.primaryEmailAddr;
	}

	public void setPrimaryEmailAddr(String primaryEmailAddr) {
		this.primaryEmailAddr = primaryEmailAddr;
	}

	@Column(name = "AS1_USER_ID", precision = 22, scale = 0)
	public Integer getAs1UserId() {
		return this.as1UserId;
	}

	public void setAs1UserId(Integer as1UserId) {
		this.as1UserId = as1UserId;
	}

	@Column(name = "INVALID_LOGIN_CNT", precision = 2, scale = 0)
	public Integer getInvalidLoginCnt() {
		return this.invalidLoginCnt;
	}

	public void setInvalidLoginCnt(Integer invalidLoginCnt) {
		this.invalidLoginCnt = invalidLoginCnt;
	}

	@Column(name = "ACCOUNT_LOCKED_TIME")
	public Date getAccountLockedTime() {
		return this.accountLockedTime;
	}

	public void setAccountLockedTime(Date accountLockedTime) {
		this.accountLockedTime = accountLockedTime;
	}

	@Column(name = "LAST_LOGIN_DATE")
	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUserId")
	public Set getAuditDetailsesForUserId() {
		return this.auditDetailsesForUserId;
	}

	public void setAuditDetailsesForUserId(Set auditDetailsesForUserId) {
		this.auditDetailsesForUserId = auditDetailsesForUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserSecondaryEmailAddrsForUpdatedBy() {
		return this.userSecondaryEmailAddrsForUpdatedBy;
	}

	public void setUserSecondaryEmailAddrsForUpdatedBy(
			Set userSecondaryEmailAddrsForUpdatedBy) {
		this.userSecondaryEmailAddrsForUpdatedBy = userSecondaryEmailAddrsForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getAdditionalPermissionsesForUpdatedBy() {
		return this.additionalPermissionsesForUpdatedBy;
	}

	public void setAdditionalPermissionsesForUpdatedBy(
			Set additionalPermissionsesForUpdatedBy) {
		this.additionalPermissionsesForUpdatedBy = additionalPermissionsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserRolesesForCreatedBy() {
		return this.userRolesesForCreatedBy;
	}

	public void setUserRolesesForCreatedBy(Set userRolesesForCreatedBy) {
		this.userRolesesForCreatedBy = userRolesesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getAuditDetailsesForCreatedBy() {
		return this.auditDetailsesForCreatedBy;
	}

	public void setAuditDetailsesForCreatedBy(Set auditDetailsesForCreatedBy) {
		this.auditDetailsesForCreatedBy = auditDetailsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserSecondaryEmailAddrsForCreatedBy() {
		return this.userSecondaryEmailAddrsForCreatedBy;
	}

	public void setUserSecondaryEmailAddrsForCreatedBy(
			Set userSecondaryEmailAddrsForCreatedBy) {
		this.userSecondaryEmailAddrsForCreatedBy = userSecondaryEmailAddrsForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserAffiliationsesForUpdatedBy() {
		return this.userAffiliationsesForUpdatedBy;
	}

	public void setUserAffiliationsesForUpdatedBy(
			Set userAffiliationsesForUpdatedBy) {
		this.userAffiliationsesForUpdatedBy = userAffiliationsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserAlertsesForUpdatedBy() {
		return this.userAlertsesForUpdatedBy;
	}

	public void setUserAlertsesForUpdatedBy(Set userAlertsesForUpdatedBy) {
		this.userAlertsesForUpdatedBy = userAlertsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserSocietyDetailsesForUpdatedBy() {
		return this.userSocietyDetailsesForUpdatedBy;
	}

	public void setUserSocietyDetailsesForUpdatedBy(
			Set userSocietyDetailsesForUpdatedBy) {
		this.userSocietyDetailsesForUpdatedBy = userSocietyDetailsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getAdditionalPermissionsesForCreatedBy() {
		return this.additionalPermissionsesForCreatedBy;
	}

	public void setAdditionalPermissionsesForCreatedBy(
			Set additionalPermissionsesForCreatedBy) {
		this.additionalPermissionsesForCreatedBy = additionalPermissionsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getRolePermissionsesForUpdatedBy() {
		return this.rolePermissionsesForUpdatedBy;
	}

	public void setRolePermissionsesForUpdatedBy(
			Set rolePermissionsesForUpdatedBy) {
		this.rolePermissionsesForUpdatedBy = rolePermissionsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getRolePermissionsesForCreatedBy() {
		return this.rolePermissionsesForCreatedBy;
	}

	public void setRolePermissionsesForCreatedBy(
			Set rolePermissionsesForCreatedBy) {
		this.rolePermissionsesForCreatedBy = rolePermissionsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserRolesesForUpdatedBy() {
		return this.userRolesesForUpdatedBy;
	}

	public void setUserRolesesForUpdatedBy(Set userRolesesForUpdatedBy) {
		this.userRolesesForUpdatedBy = userRolesesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByMergerAccntId")
	public Set getAuthorProfilesForMergerAccntId() {
		return this.authorProfilesForMergerAccntId;
	}

	public void setAuthorProfilesForMergerAccntId(
			Set authorProfilesForMergerAccntId) {
		this.authorProfilesForMergerAccntId = authorProfilesForMergerAccntId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserReferenceDatasForCreatedBy() {
		return this.userReferenceDatasForCreatedBy;
	}

	public void setUserReferenceDatasForCreatedBy(
			Set userReferenceDatasForCreatedBy) {
		this.userReferenceDatasForCreatedBy = userReferenceDatasForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getAdminDetailsesForUpdatedBy() {
		return this.adminDetailsesForUpdatedBy;
	}

	public void setAdminDetailsesForUpdatedBy(Set adminDetailsesForUpdatedBy) {
		this.adminDetailsesForUpdatedBy = adminDetailsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserAffiliationsesForCreatedBy() {
		return this.userAffiliationsesForCreatedBy;
	}

	public void setUserAffiliationsesForCreatedBy(
			Set userAffiliationsesForCreatedBy) {
		this.userAffiliationsesForCreatedBy = userAffiliationsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserAlertsesForCreatedBy() {
		return this.userAlertsesForCreatedBy;
	}

	public void setUserAlertsesForCreatedBy(Set userAlertsesForCreatedBy) {
		this.userAlertsesForCreatedBy = userAlertsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserSocietyDetailsesForCreatedBy() {
		return this.userSocietyDetailsesForCreatedBy;
	}

	public void setUserSocietyDetailsesForCreatedBy(
			Set userSocietyDetailsesForCreatedBy) {
		this.userSocietyDetailsesForCreatedBy = userSocietyDetailsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getAlertsesForUpdatedBy() {
		return this.alertsesForUpdatedBy;
	}

	public void setAlertsesForUpdatedBy(Set alertsesForUpdatedBy) {
		this.alertsesForUpdatedBy = alertsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getAlertsesForCreatedBy() {
		return this.alertsesForCreatedBy;
	}

	public void setAlertsesForCreatedBy(Set alertsesForCreatedBy) {
		this.alertsesForCreatedBy = alertsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getAuthCoauthDetailsesForUpdatedBy() {
		return this.authCoauthDetailsesForUpdatedBy;
	}

	public void setAuthCoauthDetailsesForUpdatedBy(
			Set authCoauthDetailsesForUpdatedBy) {
		this.authCoauthDetailsesForUpdatedBy = authCoauthDetailsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getAuthCoauthDetailsesForCreatedBy() {
		return this.authCoauthDetailsesForCreatedBy;
	}

	public void setAuthCoauthDetailsesForCreatedBy(
			Set authCoauthDetailsesForCreatedBy) {
		this.authCoauthDetailsesForCreatedBy = authCoauthDetailsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserReferenceDatasForUpdatedBy() {
		return this.userReferenceDatasForUpdatedBy;
	}

	public void setUserReferenceDatasForUpdatedBy(
			Set userReferenceDatasForUpdatedBy) {
		this.userReferenceDatasForUpdatedBy = userReferenceDatasForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserAreaOfInterestsForCreatedBy() {
		return this.userAreaOfInterestsForCreatedBy;
	}

	public void setUserAreaOfInterestsForCreatedBy(
			Set userAreaOfInterestsForCreatedBy) {
		this.userAreaOfInterestsForCreatedBy = userAreaOfInterestsForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUserId")
	public Set getUserAddressesesForUserId() {
		return this.userAddressesesForUserId;
	}

	public void setUserAddressesesForUserId(Set userAddressesesForUserId) {
		this.userAddressesesForUserId = userAddressesesForUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserPreferredJournalsesForUpdatedBy() {
		return this.userPreferredJournalsesForUpdatedBy;
	}

	public void setUserPreferredJournalsesForUpdatedBy(
			Set userPreferredJournalsesForUpdatedBy) {
		this.userPreferredJournalsesForUpdatedBy = userPreferredJournalsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUserId")
	public Set getUserReferenceDatasForUserId() {
		return this.userReferenceDatasForUserId;
	}

	public void setUserReferenceDatasForUserId(Set userReferenceDatasForUserId) {
		this.userReferenceDatasForUserId = userReferenceDatasForUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserPreferredJournalsesForCreatedBy() {
		return this.userPreferredJournalsesForCreatedBy;
	}

	public void setUserPreferredJournalsesForCreatedBy(
			Set userPreferredJournalsesForCreatedBy) {
		this.userPreferredJournalsesForCreatedBy = userPreferredJournalsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getJournalsesForCreatedBy() {
		return this.journalsesForCreatedBy;
	}

	public void setJournalsesForCreatedBy(Set journalsesForCreatedBy) {
		this.journalsesForCreatedBy = journalsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserProfileAttribVisiblesForUpdatedBy() {
		return this.userProfileAttribVisiblesForUpdatedBy;
	}

	public void setUserProfileAttribVisiblesForUpdatedBy(
			Set userProfileAttribVisiblesForUpdatedBy) {
		this.userProfileAttribVisiblesForUpdatedBy = userProfileAttribVisiblesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserProfileAttribVisiblesForCreatedBy() {
		return this.userProfileAttribVisiblesForCreatedBy;
	}

	public void setUserProfileAttribVisiblesForCreatedBy(
			Set userProfileAttribVisiblesForCreatedBy) {
		this.userProfileAttribVisiblesForCreatedBy = userProfileAttribVisiblesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getRolesesForUpdatedBy() {
		return this.rolesesForUpdatedBy;
	}

	public void setRolesesForUpdatedBy(Set rolesesForUpdatedBy) {
		this.rolesesForUpdatedBy = rolesesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserAddressesesForUpdatedBy() {
		return this.userAddressesesForUpdatedBy;
	}

	public void setUserAddressesesForUpdatedBy(Set userAddressesesForUpdatedBy) {
		this.userAddressesesForUpdatedBy = userAddressesesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getRolesesForCreatedBy() {
		return this.rolesesForCreatedBy;
	}

	public void setRolesesForCreatedBy(Set rolesesForCreatedBy) {
		this.rolesesForCreatedBy = rolesesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserAddressesesForCreatedBy() {
		return this.userAddressesesForCreatedBy;
	}

	public void setUserAddressesesForCreatedBy(Set userAddressesesForCreatedBy) {
		this.userAddressesesForCreatedBy = userAddressesesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getAddressesForUpdatedBy() {
		return this.addressesForUpdatedBy;
	}

	public void setAddressesForUpdatedBy(Set addressesForUpdatedBy) {
		this.addressesForUpdatedBy = addressesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getAddressesForCreatedBy() {
		return this.addressesForCreatedBy;
	}

	public void setAddressesForCreatedBy(Set addressesForCreatedBy) {
		this.addressesForCreatedBy = addressesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getJournalsesForUpdatedBy() {
		return this.journalsesForUpdatedBy;
	}

	public void setJournalsesForUpdatedBy(Set journalsesForUpdatedBy) {
		this.journalsesForUpdatedBy = journalsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUsersesForCreatedBy() {
		return this.usersesForCreatedBy;
	}

	public void setUsersesForCreatedBy(Set usersesForCreatedBy) {
		this.usersesForCreatedBy = usersesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getAuthorProfilesForUpdatedBy() {
		return this.authorProfilesForUpdatedBy;
	}

	public void setAuthorProfilesForUpdatedBy(Set authorProfilesForUpdatedBy) {
		this.authorProfilesForUpdatedBy = authorProfilesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getAuthorProfilesForCreatedBy() {
		return this.authorProfilesForCreatedBy;
	}

	public void setAuthorProfilesForCreatedBy(Set authorProfilesForCreatedBy) {
		this.authorProfilesForCreatedBy = authorProfilesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUsersesForUpdatedBy() {
		return this.usersesForUpdatedBy;
	}

	public void setUsersesForUpdatedBy(Set usersesForUpdatedBy) {
		this.usersesForUpdatedBy = usersesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserAreaOfInterestsForUpdatedBy() {
		return this.userAreaOfInterestsForUpdatedBy;
	}

	public void setUserAreaOfInterestsForUpdatedBy(
			Set userAreaOfInterestsForUpdatedBy) {
		this.userAreaOfInterestsForUpdatedBy = userAreaOfInterestsForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getAuthColleagueDetailsesForCreatedBy() {
		return this.authColleagueDetailsesForCreatedBy;
	}

	public void setAuthColleagueDetailsesForCreatedBy(
			Set authColleagueDetailsesForCreatedBy) {
		this.authColleagueDetailsesForCreatedBy = authColleagueDetailsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getAreaOfInterestsForUpdatedBy() {
		return this.areaOfInterestsForUpdatedBy;
	}

	public void setAreaOfInterestsForUpdatedBy(Set areaOfInterestsForUpdatedBy) {
		this.areaOfInterestsForUpdatedBy = areaOfInterestsForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getAreaOfInterestsForCreatedBy() {
		return this.areaOfInterestsForCreatedBy;
	}

	public void setAreaOfInterestsForCreatedBy(Set areaOfInterestsForCreatedBy) {
		this.areaOfInterestsForCreatedBy = areaOfInterestsForCreatedBy;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "usersByUserId")
	public AdminDetails getAdminDetailsByUserId() {
		return this.adminDetailsByUserId;
	}

	public void setAdminDetailsByUserId(AdminDetails adminDetailsByUserId) {
		this.adminDetailsByUserId = adminDetailsByUserId;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "usersByUserId")
	public AuthorProfile getAuthorProfileByUserId() {
		return this.authorProfileByUserId;
	}

	public void setAuthorProfileByUserId(AuthorProfile authorProfileByUserId) {
		this.authorProfileByUserId = authorProfileByUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getPermissionsesForCreatedBy() {
		return this.permissionsesForCreatedBy;
	}

	public void setPermissionsesForCreatedBy(Set permissionsesForCreatedBy) {
		this.permissionsesForCreatedBy = permissionsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getResearchFundersesForCreatedBy() {
		return this.researchFundersesForCreatedBy;
	}

	public void setResearchFundersesForCreatedBy(
			Set researchFundersesForCreatedBy) {
		this.researchFundersesForCreatedBy = researchFundersesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getAdminDetailsesForCreatedBy() {
		return this.adminDetailsesForCreatedBy;
	}

	public void setAdminDetailsesForCreatedBy(Set adminDetailsesForCreatedBy) {
		this.adminDetailsesForCreatedBy = adminDetailsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserWoaAccountsesForUpdatedBy() {
		return this.userWoaAccountsesForUpdatedBy;
	}

	public void setUserWoaAccountsesForUpdatedBy(
			Set userWoaAccountsesForUpdatedBy) {
		this.userWoaAccountsesForUpdatedBy = userWoaAccountsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserWoaAccountsesForCreatedBy() {
		return this.userWoaAccountsesForCreatedBy;
	}

	public void setUserWoaAccountsesForCreatedBy(
			Set userWoaAccountsesForCreatedBy) {
		this.userWoaAccountsesForCreatedBy = userWoaAccountsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getAuthColleagueDetailsesForUpdatedBy() {
		return this.authColleagueDetailsesForUpdatedBy;
	}

	public void setAuthColleagueDetailsesForUpdatedBy(
			Set authColleagueDetailsesForUpdatedBy) {
		this.authColleagueDetailsesForUpdatedBy = authColleagueDetailsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getUserFunderGrantsesForUpdatedBy() {
		return this.userFunderGrantsesForUpdatedBy;
	}

	public void setUserFunderGrantsesForUpdatedBy(
			Set userFunderGrantsesForUpdatedBy) {
		this.userFunderGrantsesForUpdatedBy = userFunderGrantsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getUserFunderGrantsesForCreatedBy() {
		return this.userFunderGrantsesForCreatedBy;
	}

	public void setUserFunderGrantsesForCreatedBy(
			Set userFunderGrantsesForCreatedBy) {
		this.userFunderGrantsesForCreatedBy = userFunderGrantsesForCreatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getPermissionsesForUpdatedBy() {
		return this.permissionsesForUpdatedBy;
	}

	public void setPermissionsesForUpdatedBy(Set permissionsesForUpdatedBy) {
		this.permissionsesForUpdatedBy = permissionsesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getResearchFundersesForUpdatedBy() {
		return this.researchFundersesForUpdatedBy;
	}

	public void setResearchFundersesForUpdatedBy(
			Set researchFundersesForUpdatedBy) {
		this.researchFundersesForUpdatedBy = researchFundersesForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUserId")
	public Set getUserSecondaryEmailAddrsForUserId() {
		return this.userSecondaryEmailAddrsForUserId;
	}

	public void setUserSecondaryEmailAddrsForUserId(
			Set userSecondaryEmailAddrsForUserId) {
		this.userSecondaryEmailAddrsForUserId = userSecondaryEmailAddrsForUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUpdatedBy")
	public Set getProfileAttributeListsForUpdatedBy() {
		return this.profileAttributeListsForUpdatedBy;
	}

	public void setProfileAttributeListsForUpdatedBy(
			Set profileAttributeListsForUpdatedBy) {
		this.profileAttributeListsForUpdatedBy = profileAttributeListsForUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByUserId")
	public Set getUserRolesesForUserId() {
		return this.userRolesesForUserId;
	}

	public void setUserRolesesForUserId(Set userRolesesForUserId) {
		this.userRolesesForUserId = userRolesesForUserId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usersByCreatedBy")
	public Set getProfileAttributeListsForCreatedBy() {
		return this.profileAttributeListsForCreatedBy;
	}

	public void setProfileAttributeListsForCreatedBy(
			Set profileAttributeListsForCreatedBy) {
		this.profileAttributeListsForCreatedBy = profileAttributeListsForCreatedBy;
	}

}
