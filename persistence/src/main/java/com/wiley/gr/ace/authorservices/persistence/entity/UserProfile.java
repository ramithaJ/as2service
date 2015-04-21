package com.wiley.gr.ace.authorservices.persistence.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "USER_PROFILE")
public class UserProfile implements java.io.Serializable {

	private Integer userId;
	private String primaryEmailAddr;
	private String title;
	private String firstName;
	private String lastName;
	private Character optInPromoteFlg;
	private Character optInActivatedFlg;
	private Character termsOfUseFlg;
	private Character securityQuestFlg;
	private String typeOfConsent;
	private Character isAccountActive;
	private String secondaryEmailAddr;
	private Character billingAddrFlg;
	private Character shippingAdrFlg;
	private String alternateName;
	private String ipAddress;
	private Character isAccountVerified;
	private Boolean invalidLoginFlg;
	private Integer mergerAccntId;
	private Blob profilePic;
	private String createdBy;
	private Serializable createdDate;
	private String updatedBy;
	private Serializable updatedDate;
	private Serializable lastLoginDate;
	private Serializable lastActivityDate;
	private Set<UserReferenceData> userReferenceDatas = new HashSet<UserReferenceData>(
			0);
	private Set<Roles> roleses = new HashSet<Roles>(0);
	private Set<UserSecurityDetails> userSecurityDetailses = new HashSet<UserSecurityDetails>(
			0);
	private Set<AdditionalPermissions> additionalPermissionses = new HashSet<AdditionalPermissions>(
			0);

	public UserProfile() {
	}

	public UserProfile(Integer userId, String primaryEmailAddr) {
		this.userId = userId;
		this.primaryEmailAddr = primaryEmailAddr;
	}

	public UserProfile(Integer userId, String primaryEmailAddr,
			String title, String firstName, String lastName,
			Character optInPromoteFlg, Character optInActivatedFlg,
			Character termsOfUseFlg, Character securityQuestFlg,
			String typeOfConsent, Character isAccountActive,
			String secondaryEmailAddr, Character billingAddrFlg,
			Character shippingAdrFlg, String alternateName, String ipAddress,
			Character isAccountVerified, Boolean invalidLoginFlg,
			Integer mergerAccntId, Blob profilePic, String createdBy,
			Serializable createdDate, String updatedBy,
			Serializable updatedDate, Serializable lastLoginDate,
			Serializable lastActivityDate,
			Set<UserReferenceData> userReferenceDatas, Set<Roles> roleses,
			Set<UserSecurityDetails> userSecurityDetailses,
			Set<AdditionalPermissions> additionalPermissionses) {
		this.userId = userId;
		this.primaryEmailAddr = primaryEmailAddr;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.optInPromoteFlg = optInPromoteFlg;
		this.optInActivatedFlg = optInActivatedFlg;
		this.termsOfUseFlg = termsOfUseFlg;
		this.securityQuestFlg = securityQuestFlg;
		this.typeOfConsent = typeOfConsent;
		this.isAccountActive = isAccountActive;
		this.secondaryEmailAddr = secondaryEmailAddr;
		this.billingAddrFlg = billingAddrFlg;
		this.shippingAdrFlg = shippingAdrFlg;
		this.alternateName = alternateName;
		this.ipAddress = ipAddress;
		this.isAccountVerified = isAccountVerified;
		this.invalidLoginFlg = invalidLoginFlg;
		this.mergerAccntId = mergerAccntId;
		this.profilePic = profilePic;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.lastLoginDate = lastLoginDate;
		this.lastActivityDate = lastActivityDate;
		this.userReferenceDatas = userReferenceDatas;
		this.roleses = roleses;
		this.userSecurityDetailses = userSecurityDetailses;
		this.additionalPermissionses = additionalPermissionses;
	}

	@Id
	@Column(name = "USER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "PRIMARY_EMAIL_ADDR", nullable = false, length = 200)
	public String getPrimaryEmailAddr() {
		return this.primaryEmailAddr;
	}

	public void setPrimaryEmailAddr(String primaryEmailAddr) {
		this.primaryEmailAddr = primaryEmailAddr;
	}

	@Column(name = "TITLE", length = 10)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "FIRST_NAME", length = 200)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", length = 200)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "OPT_IN_PROMOTE_FLG", length = 1)
	public Character getOptInPromoteFlg() {
		return this.optInPromoteFlg;
	}

	public void setOptInPromoteFlg(Character optInPromoteFlg) {
		this.optInPromoteFlg = optInPromoteFlg;
	}

	@Column(name = "OPT_IN_ACTIVATED_FLG", length = 1)
	public Character getOptInActivatedFlg() {
		return this.optInActivatedFlg;
	}

	public void setOptInActivatedFlg(Character optInActivatedFlg) {
		this.optInActivatedFlg = optInActivatedFlg;
	}

	@Column(name = "TERMS_OF_USE_FLG", length = 1)
	public Character getTermsOfUseFlg() {
		return this.termsOfUseFlg;
	}

	public void setTermsOfUseFlg(Character termsOfUseFlg) {
		this.termsOfUseFlg = termsOfUseFlg;
	}

	@Column(name = "SECURITY_QUEST_FLG", length = 1)
	public Character getSecurityQuestFlg() {
		return this.securityQuestFlg;
	}

	public void setSecurityQuestFlg(Character securityQuestFlg) {
		this.securityQuestFlg = securityQuestFlg;
	}

	@Column(name = "TYPE_OF_CONSENT", length = 50)
	public String getTypeOfConsent() {
		return this.typeOfConsent;
	}

	public void setTypeOfConsent(String typeOfConsent) {
		this.typeOfConsent = typeOfConsent;
	}

	@Column(name = "IS_ACCOUNT_ACTIVE", length = 1)
	public Character getIsAccountActive() {
		return this.isAccountActive;
	}

	public void setIsAccountActive(Character isAccountActive) {
		this.isAccountActive = isAccountActive;
	}

	@Column(name = "SECONDARY_EMAIL_ADDR", length = 200)
	public String getSecondaryEmailAddr() {
		return this.secondaryEmailAddr;
	}

	public void setSecondaryEmailAddr(String secondaryEmailAddr) {
		this.secondaryEmailAddr = secondaryEmailAddr;
	}

	@Column(name = "BILLING_ADDR_FLG", length = 1)
	public Character getBillingAddrFlg() {
		return this.billingAddrFlg;
	}

	public void setBillingAddrFlg(Character billingAddrFlg) {
		this.billingAddrFlg = billingAddrFlg;
	}

	@Column(name = "SHIPPING_ADR_FLG", length = 1)
	public Character getShippingAdrFlg() {
		return this.shippingAdrFlg;
	}

	public void setShippingAdrFlg(Character shippingAdrFlg) {
		this.shippingAdrFlg = shippingAdrFlg;
	}

	@Column(name = "ALTERNATE_NAME", length = 200)
	public String getAlternateName() {
		return this.alternateName;
	}

	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}

	@Column(name = "IP_ADDRESS", length = 50)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "IS_ACCOUNT_VERIFIED", length = 1)
	public Character getIsAccountVerified() {
		return this.isAccountVerified;
	}

	public void setIsAccountVerified(Character isAccountVerified) {
		this.isAccountVerified = isAccountVerified;
	}

	@Column(name = "INVALID_LOGIN_FLG", precision = 1, scale = 0)
	public Boolean getInvalidLoginFlg() {
		return this.invalidLoginFlg;
	}

	public void setInvalidLoginFlg(Boolean invalidLoginFlg) {
		this.invalidLoginFlg = invalidLoginFlg;
	}

	@Column(name = "MERGER_ACCNT_ID", precision = 22, scale = 0)
	public Integer getMergerAccntId() {
		return this.mergerAccntId;
	}

	public void setMergerAccntId(Integer mergerAccntId) {
		this.mergerAccntId = mergerAccntId;
	}

	@Column(name = "PROFILE_PIC")
	public Blob getProfilePic() {
		return this.profilePic;
	}

	public void setProfilePic(Blob profilePic) {
		this.profilePic = profilePic;
	}

	@Column(name = "CREATED_BY", length = 50)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DATE")
	public Serializable getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Serializable createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_BY", length = 25)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "UPDATED_DATE")
	public Serializable getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Serializable updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "LAST_LOGIN_DATE")
	public Serializable getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Serializable lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Column(name = "LAST_ACTIVITY_DATE")
	public Serializable getLastActivityDate() {
		return this.lastActivityDate;
	}

	public void setLastActivityDate(Serializable lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile")
	public Set<UserReferenceData> getUserReferenceDatas() {
		return this.userReferenceDatas;
	}

	public void setUserReferenceDatas(Set<UserReferenceData> userReferenceDatas) {
		this.userReferenceDatas = userReferenceDatas;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
	public Set<Roles> getRoleses() {
		return this.roleses;
	}

	public void setRoleses(Set<Roles> roleses) {
		this.roleses = roleses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile")
	public Set<UserSecurityDetails> getUserSecurityDetailses() {
		return this.userSecurityDetailses;
	}

	public void setUserSecurityDetailses(
			Set<UserSecurityDetails> userSecurityDetailses) {
		this.userSecurityDetailses = userSecurityDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProfile")
	public Set<AdditionalPermissions> getAdditionalPermissionses() {
		return this.additionalPermissionses;
	}

	public void setAdditionalPermissionses(
			Set<AdditionalPermissions> additionalPermissionses) {
		this.additionalPermissionses = additionalPermissionses;
	}

}
