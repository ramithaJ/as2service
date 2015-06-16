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

import java.util.List;

import com.wiley.gr.ace.authorservices.model.Address;

/**
 * The Class Order.
 *
 * @author virtusa version 1.0
 */
public class Order {

    /** The article id. */
    private String articleId;

    /** The journal id. */
    private String journalId;

    /** The order type. */
    private String orderType;

    /** The pricing. */
    private Pricing pricing;

    /** The discount. */
    private Discount discount;

    /** The affiliation. */
    private Affiliation affiliation;

    /** The payment method. */
    private String paymentMethod;

    /** The credit card. */
    private CreditCard creditCard;

    /** The tax details. */
    private TaxDetails taxDetails;

    /** The addresses. */
    private List<Address> addresses;

    /** The customer. */
    private Customer customer;

    /** The funding details. */
    private FundingDetails fundingDetails;

    /**
     * Gets the article id.
     *
     * @return the article id
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * Sets the article id.
     *
     * @param articleId
     *            the new article id
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets the journal id.
     *
     * @return the journal id
     */
    public String getJournalId() {
        return journalId;
    }

    /**
     * Sets the journal id.
     *
     * @param journalId
     *            the new journal id
     */
    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    /**
     * Gets the order type.
     *
     * @return the order type
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Sets the order type.
     *
     * @param orderType
     *            the new order type
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * Gets the pricing.
     *
     * @return the pricing
     */
    public Pricing getPricing() {
        return pricing;
    }

    /**
     * Sets the pricing.
     *
     * @param pricing
     *            the new pricing
     */
    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    /**
     * Gets the discount.
     *
     * @return the discount
     */
    public Discount getDiscount() {
        return discount;
    }

    /**
     * Sets the discount.
     *
     * @param discount
     *            the new discount
     */
    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    /**
     * Gets the affiliation.
     *
     * @return the affiliation
     */
    public Affiliation getAffiliation() {
        return affiliation;
    }

    /**
     * Sets the affiliation.
     *
     * @param affiliation
     *            the new affiliation
     */
    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    /**
     * Gets the payment method.
     *
     * @return the payment method
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method.
     *
     * @param paymentMethod
     *            the new payment method
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the credit card.
     *
     * @return the credit card
     */
    public CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the credit card.
     *
     * @param creditCard
     *            the new credit card
     */
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * Gets the tax details.
     *
     * @return the tax details
     */
    public TaxDetails getTaxDetails() {
        return taxDetails;
    }

    /**
     * Sets the tax details.
     *
     * @param taxDetails
     *            the new tax details
     */
    public void setTaxDetails(TaxDetails taxDetails) {
        this.taxDetails = taxDetails;
    }

    /**
     * Gets the addresses.
     *
     * @return the addresses
     */
    public List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Sets the addresses.
     *
     * @param addresses
     *            the new addresses
     */
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets the customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer.
     *
     * @param customer
     *            the new customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the funding details.
     *
     * @return the funding details
     */
    public FundingDetails getFundingDetails() {
        return fundingDetails;
    }

    /**
     * Sets the funding details.
     *
     * @param fundingDetails
     *            the new funding details
     */
    public void setFundingDetails(FundingDetails fundingDetails) {
        this.fundingDetails = fundingDetails;
    }

}
