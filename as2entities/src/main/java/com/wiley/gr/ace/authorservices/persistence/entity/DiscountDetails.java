package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 8, 2015 3:59:02 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DiscountDetails generated by hbm2java
 */
@Entity
@Table(name = "DISCOUNT_DETAILS")
public class DiscountDetails implements java.io.Serializable {

	private Integer discountId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String promoCode;
	private String discountTypeCode;
	private Character discountValueType;
	private String discountType;
	private Integer discountValue;
	private Date startDate;
	private Date endDate;
	private Date articlePublishedDate;
	private String countryCd;
	private String societyCd;
	private String journalAcronym;
	private String journalType;
	private String institutionCode;
	private String institutionName;
	private Date createdDate;
	private Date updatedDate;

	public DiscountDetails() {
	}

	public DiscountDetails(Integer discountId) {
		this.discountId = discountId;
	}

	public DiscountDetails(Integer discountId, Users usersByCreatedBy,
			Users usersByUpdatedBy, String promoCode, String discountTypeCode,
			Character discountValueType, String discountType,
			Integer discountValue, Date startDate, Date endDate,
			Date articlePublishedDate, String countryCd, String societyCd,
			String journalAcronym, String journalType, String institutionCode,
			String institutionName, Date createdDate, Date updatedDate) {
		this.discountId = discountId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.promoCode = promoCode;
		this.discountTypeCode = discountTypeCode;
		this.discountValueType = discountValueType;
		this.discountType = discountType;
		this.discountValue = discountValue;
		this.startDate = startDate;
		this.endDate = endDate;
		this.articlePublishedDate = articlePublishedDate;
		this.countryCd = countryCd;
		this.societyCd = societyCd;
		this.journalAcronym = journalAcronym;
		this.journalType = journalType;
		this.institutionCode = institutionCode;
		this.institutionName = institutionName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "DISCOUNT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getDiscountId() {
		return this.discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
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

	@Column(name = "PROMO_CODE", length = 15)
	public String getPromoCode() {
		return this.promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	@Column(name = "DISCOUNT_TYPE_CODE", length = 25)
	public String getDiscountTypeCode() {
		return this.discountTypeCode;
	}

	public void setDiscountTypeCode(String discountTypeCode) {
		this.discountTypeCode = discountTypeCode;
	}

	@Column(name = "DISCOUNT_VALUE_TYPE", length = 1)
	public Character getDiscountValueType() {
		return this.discountValueType;
	}

	public void setDiscountValueType(Character discountValueType) {
		this.discountValueType = discountValueType;
	}

	@Column(name = "DISCOUNT_TYPE", length = 50)
	public String getDiscountType() {
		return this.discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	@Column(name = "DISCOUNT_VALUE", precision = 7)
	public Integer getDiscountValue() {
		return this.discountValue;
	}

	public void setDiscountValue(Integer discountValue) {
		this.discountValue = discountValue;
	}

	@Column(name = "START_DATE")
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "END_DATE")
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "ARTICLE_PUBLISHED_DATE")
	public Date getArticlePublishedDate() {
		return this.articlePublishedDate;
	}

	public void setArticlePublishedDate(Date articlePublishedDate) {
		this.articlePublishedDate = articlePublishedDate;
	}

	@Column(name = "COUNTRY_CD", length = 15)
	public String getCountryCd() {
		return this.countryCd;
	}

	public void setCountryCd(String countryCd) {
		this.countryCd = countryCd;
	}

	@Column(name = "SOCIETY_CD", length = 15)
	public String getSocietyCd() {
		return this.societyCd;
	}

	public void setSocietyCd(String societyCd) {
		this.societyCd = societyCd;
	}

	@Column(name = "JOURNAL_ACRONYM", length = 25)
	public String getJournalAcronym() {
		return this.journalAcronym;
	}

	public void setJournalAcronym(String journalAcronym) {
		this.journalAcronym = journalAcronym;
	}

	@Column(name = "JOURNAL_TYPE", length = 15)
	public String getJournalType() {
		return this.journalType;
	}

	public void setJournalType(String journalType) {
		this.journalType = journalType;
	}

	@Column(name = "INSTITUTION_CODE", length = 15)
	public String getInstitutionCode() {
		return this.institutionCode;
	}

	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}

	@Column(name = "INSTITUTION_NAME", length = 100)
	public String getInstitutionName() {
		return this.institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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
