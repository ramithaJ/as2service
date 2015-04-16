package com.wiley.gr.ace.authorservices.persistence.entity;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PROFILE")
public class UserProfile {
	@Id
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "PRIMARY_EMAIL_ADDR")
	private String primaryEmailAddr;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "OPT_IN_PROMOTE_FLG")
	private String OptInPromoteFlg;
	@Column(name = "OPT_IN_ACTIVATED_FLG")
	private String optInActivatedFlg;
	@Column(name = "TERMS_OF_USE_FLG")
	private String termsOfUseFlg;
	@Column(name = "SECURITY_QUEST_FLG")
	private String securityQuestFlg;
	@Column(name = "TYPE_OF_CONSENT")
	private String typeOfConsent;
	@Column(name = "IS_ACCOUNT_ACTIVE")
	private String isAccountActive;
	@Column(name = "SECONDARY_EMAIL_ADDR")
	private String secondaryEmailAddr;
	@Column(name = "BILLING_ADDR_FLG")
	private String billingAddrFlg;
	@Column(name = "SHIPPING_ADR_FLG")
	private String shippingAdrFlg;
	@Column(name = "ALTERNATE_NAME")
	private String alternateName;
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	@Column(name = "IS_ACCOUNT_VERIFIED")
	private String isAccountVerified;
	@Column(name = "INVALID_LOGIN_FLG")
	private Double invalidLoginFlg;
	@Column(name = "MERGER_ACCNT_ID")
	private Integer mergerAccntId;
	@Column(name = "PROFILE_PIC")
	private Blob profilePic;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;
	@Column(name = "LAST_LOGIN_DATE")
	private Date lastLoginDate;
	@Column(name = "LAST_ACTIVITY_DATE")
	private Date lastActivityDate;
	@OneToMany(mappedBy = "userProfile")
	private List<UserReferenceData> userReferenceDataList;
	@OneToMany(mappedBy = "userProfile")
	private List<UserProfileAttribVisible> userProfileAttribVisibleList;
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	private List<Roles> rolesList;
	@OneToMany(mappedBy = "userProfile")
	private List<UserSecurityDetails> userSecurityDetailsList;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPrimaryEmailAddr() {
		return primaryEmailAddr;
	}

	public void setPrimaryEmailAddr(String primaryEmailAddr) {
		this.primaryEmailAddr = primaryEmailAddr;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOptInPromoteFlg() {
		return OptInPromoteFlg;
	}

	public void setOptInPromoteFlg(String optInPromoteFlg) {
		OptInPromoteFlg = optInPromoteFlg;
	}

	public String getOptInActivatedFlg() {
		return optInActivatedFlg;
	}

	public void setOptInActivatedFlg(String optInActivatedFlg) {
		this.optInActivatedFlg = optInActivatedFlg;
	}

	public String getTermsOfUseFlg() {
		return termsOfUseFlg;
	}

	public void setTermsOfUseFlg(String termsOfUseFlg) {
		this.termsOfUseFlg = termsOfUseFlg;
	}

	public String getSecurityQuestFlg() {
		return securityQuestFlg;
	}

	public void setSecurityQuestFlg(String securityQuestFlg) {
		this.securityQuestFlg = securityQuestFlg;
	}

	public String getTypeOfConsent() {
		return typeOfConsent;
	}

	public void setTypeOfConsent(String typeOfConsent) {
		this.typeOfConsent = typeOfConsent;
	}

	public String getIsAccountActive() {
		return isAccountActive;
	}

	public void setIsAccountActive(String isAccountActive) {
		this.isAccountActive = isAccountActive;
	}

	public String getSecondaryEmailAddr() {
		return secondaryEmailAddr;
	}

	public void setSecondaryEmailAddr(String secondaryEmailAddr) {
		this.secondaryEmailAddr = secondaryEmailAddr;
	}

	public String getBillingAddrFlg() {
		return billingAddrFlg;
	}

	public void setBillingAddrFlg(String billingAddrFlg) {
		this.billingAddrFlg = billingAddrFlg;
	}

	public String getShippingAdrFlg() {
		return shippingAdrFlg;
	}

	public void setShippingAdrFlg(String shippingAdrFlg) {
		this.shippingAdrFlg = shippingAdrFlg;
	}

	public String getAlternateName() {
		return alternateName;
	}

	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getIsAccountVerified() {
		return isAccountVerified;
	}

	public void setIsAccountVerified(String isAccountVerified) {
		this.isAccountVerified = isAccountVerified;
	}

	public Double getInvalidLoginFlg() {
		return invalidLoginFlg;
	}

	public void setInvalidLoginFlg(Double invalidLoginFlg) {
		this.invalidLoginFlg = invalidLoginFlg;
	}

	public Integer getMergerAccntId() {
		return mergerAccntId;
	}

	public void setMergerAccntId(Integer mergerAccntId) {
		this.mergerAccntId = mergerAccntId;
	}

	public Blob getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Blob profilePic) {
		this.profilePic = profilePic;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	public List<UserReferenceData> getUserReferenceDataList() {
		return userReferenceDataList;
	}

	public void setUserReferenceDataList(
			List<UserReferenceData> userReferenceDataList) {
		this.userReferenceDataList = userReferenceDataList;
	}

	public List<UserProfileAttribVisible> getUserProfileAttribVisibleList() {
		return userProfileAttribVisibleList;
	}

	public void setUserProfileAttribVisibleList(
			List<UserProfileAttribVisible> userProfileAttribVisibleList) {
		this.userProfileAttribVisibleList = userProfileAttribVisibleList;
	}

	public List<Roles> getRolesList() {
		return rolesList;
	}

	public void setRolesList(List<Roles> rolesList) {
		this.rolesList = rolesList;
	}

	public List<UserSecurityDetails> getUserSecurityDetailsList() {
		return userSecurityDetailsList;
	}

	public void setUserSecurityDetailsList(
			List<UserSecurityDetails> userSecurityDetailsList) {
		this.userSecurityDetailsList = userSecurityDetailsList;
	}

}
