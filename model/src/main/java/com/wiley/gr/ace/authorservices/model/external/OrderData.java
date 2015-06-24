/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class OrderData.
 *
 * @author virtusa version 1.0
 */
public class OrderData {

	private String ooUniqueId;
	private String orderStatusCode;
	private String orderSource;
	private String orderType;
	private String orderSubType;
	private String orderDate;
	private String referenceOoUniqueId;
	private String enteredBy;
	private String specialNotes;
	private String poNumber;
	@JsonProperty("article")
	private ArticleData articleData;
	private Customer customer;
	private WoaAccountHolder woaAccountHolder;
	@JsonProperty("pricing")
	private PricingData pricingData;
	private Payment payment;
	@JsonProperty("taxDetails")
	private TaxData taxData;
	private ContactAddress contactAddress;
	private ContactAddress billingAddress;

	/**
	 * 
	 * @return The ooUniqueId
	 */
	public String getOoUniqueId() {
		return ooUniqueId;
	}

	/**
	 * 
	 * @param ooUniqueId
	 *            The ooUniqueId
	 */
	public void setOoUniqueId(final String ooUniqueId) {
		this.ooUniqueId = ooUniqueId;
	}

	/**
	 * 
	 * @return The orderStatusCode
	 */
	public String getOrderStatusCode() {
		return orderStatusCode;
	}

	/**
	 * 
	 * @param orderStatusCode
	 *            The orderStatusCode
	 */
	public void setOrderStatusCode(final String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}

	/**
	 * 
	 * @return The orderSource
	 */
	public String getOrderSource() {
		return orderSource;
	}

	/**
	 * 
	 * @param orderSource
	 *            The orderSource
	 */
	public void setOrderSource(final String orderSource) {
		this.orderSource = orderSource;
	}

	/**
	 * 
	 * @return The orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * 
	 * @param orderType
	 *            The orderType
	 */
	public void setOrderType(final String orderType) {
		this.orderType = orderType;
	}

	/**
	 * 
	 * @return The orderSubType
	 */
	public String getOrderSubType() {
		return orderSubType;
	}

	/**
	 * 
	 * @param orderSubType
	 *            The orderSubType
	 */
	public void setOrderSubType(final String orderSubType) {
		this.orderSubType = orderSubType;
	}

	/**
	 * 
	 * @return The orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * 
	 * @param orderDate
	 *            The orderDate
	 */
	public void setOrderDate(final String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * 
	 * @return The referenceOoUniqueId
	 */
	public String getReferenceOoUniqueId() {
		return referenceOoUniqueId;
	}

	/**
	 * 
	 * @param referenceOoUniqueId
	 *            The referenceOoUniqueId
	 */
	public void setReferenceOoUniqueId(final String referenceOoUniqueId) {
		this.referenceOoUniqueId = referenceOoUniqueId;
	}

	/**
	 * 
	 * @return The enteredBy
	 */
	public String getEnteredBy() {
		return enteredBy;
	}

	/**
	 * 
	 * @param enteredBy
	 *            The enteredBy
	 */
	public void setEnteredBy(final String enteredBy) {
		this.enteredBy = enteredBy;
	}

	/**
	 * 
	 * @return The specialNotes
	 */
	public String getSpecialNotes() {
		return specialNotes;
	}

	/**
	 * 
	 * @param specialNotes
	 *            The specialNotes
	 */
	public void setSpecialNotes(final String specialNotes) {
		this.specialNotes = specialNotes;
	}

	/**
	 * 
	 * @return The poNumber
	 */
	public String getPoNumber() {
		return poNumber;
	}

	/**
	 * 
	 * @param poNumber
	 *            The poNumber
	 */
	public void setPoNumber(final String poNumber) {
		this.poNumber = poNumber;
	}

	/**
	 * 
	 * @return The articleData
	 */
	public ArticleData getArticle() {
		return articleData;
	}

	/**
	 * 
	 * @param articleData
	 *            The articleData
	 */
	public void setArticle(final ArticleData articleData) {
		this.articleData = articleData;
	}

	/**
	 * 
	 * @return The customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * 
	 * @param customer
	 *            The customer
	 */
	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}

	/**
	 * 
	 * @return The woaAccountHolder
	 */
	public WoaAccountHolder getWoaAccountHolder() {
		return woaAccountHolder;
	}

	/**
	 * 
	 * @param woaAccountHolder
	 *            The woaAccountHolder
	 */
	public void setWoaAccountHolder(final WoaAccountHolder woaAccountHolder) {
		this.woaAccountHolder = woaAccountHolder;
	}

	/**
	 * 
	 * @return The pricingData
	 */
	public PricingData getPricing() {
		return pricingData;
	}

	/**
	 * 
	 * @param pricingData
	 *            The pricingData
	 */
	public void setPricing(final PricingData pricingData) {
		this.pricingData = pricingData;
	}

	/**
	 * 
	 * @return The payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * 
	 * @param payment
	 *            The payment
	 */
	public void setPayment(final Payment payment) {
		this.payment = payment;
	}

	/**
	 * 
	 * @return The taxData
	 */
	public TaxData getTaxDetails() {
		return taxData;
	}

	/**
	 * 
	 * @param taxData
	 *            The taxData
	 */
	public void setTaxDetails(final TaxData taxData) {
		this.taxData = taxData;
	}

	/**
	 * 
	 * @return The contactAddress
	 */
	public ContactAddress getContactAddress() {
		return contactAddress;
	}

	/**
	 * 
	 * @param contactAddress
	 *            The contactAddress
	 */
	public void setContactAddress(final ContactAddress contactAddress) {
		this.contactAddress = contactAddress;
	}

	/**
	 * 
	 * @return The billingAddress
	 */
	public ContactAddress getBillingAddress() {
		return billingAddress;
	}

	/**
	 * 
	 * @param billingAddress
	 *            The billingAddress
	 */
	public void setBillingAddress(final ContactAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
}
