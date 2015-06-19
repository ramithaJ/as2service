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
	private ArticleData articleData;
	private Customer customer;
	private WoaAccountHolder woaAccountHolder;
	private PricingData pricingData;
	private Payment payment;
	private TaxData taxData;
	private ContactAddress contactAddress;
	private BillingAddress billingAddress;

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
	public void setOoUniqueId(String ooUniqueId) {
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
	public void setOrderStatusCode(String orderStatusCode) {
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
	public void setOrderSource(String orderSource) {
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
	public void setOrderType(String orderType) {
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
	public void setOrderSubType(String orderSubType) {
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
	public void setOrderDate(String orderDate) {
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
	public void setReferenceOoUniqueId(String referenceOoUniqueId) {
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
	public void setEnteredBy(String enteredBy) {
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
	public void setSpecialNotes(String specialNotes) {
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
	public void setPoNumber(String poNumber) {
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
	public void setArticle(ArticleData articleData) {
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
	public void setCustomer(Customer customer) {
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
	public void setWoaAccountHolder(WoaAccountHolder woaAccountHolder) {
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
	public void setPricing(PricingData pricingData) {
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
	public void setPayment(Payment payment) {
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
	public void setTaxDetails(TaxData taxData) {
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
	public void setContactAddress(ContactAddress contactAddress) {
		this.contactAddress = contactAddress;
	}

	/**
	 * 
	 * @return The billingAddress
	 */
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	/**
	 * 
	 * @param billingAddress
	 *            The billingAddress
	 */
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
}
