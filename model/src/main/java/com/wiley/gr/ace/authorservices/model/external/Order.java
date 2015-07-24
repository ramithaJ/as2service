/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
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

    /**
     * Gets the article id.
     *
     * @return the articleId
     */
    public final String getArticleId() {
        return articleId;
    }

    /**
     * Sets the article id.
     *
     * @param articleId
     *            the articleId to set
     */
    public final void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets the journal id.
     *
     * @return the journalId
     */
    public final String getJournalId() {
        return journalId;
    }

    /**
     * Sets the journal id.
     *
     * @param journalId
     *            the journalId to set
     */
    public final void setJournalId(final String journalId) {
        this.journalId = journalId;
    }

    /**
     * Gets the order type.
     *
     * @return the orderType
     */
    public final String getOrderType() {
        return orderType;
    }

    /**
     * Sets the order type.
     *
     * @param orderType
     *            the orderType to set
     */
    public final void setOrderType(final String orderType) {
        this.orderType = orderType;
    }

    /**
     * Gets the pricing.
     *
     * @return the pricing
     */
    public final Pricing getPricing() {
        return pricing;
    }

    /**
     * Sets the pricing.
     *
     * @param pricing
     *            the pricing to set
     */
    public final void setPricing(final Pricing pricing) {
        this.pricing = pricing;
    }

    /**
     * Gets the discount.
     *
     * @return the discount
     */
    public final Discount getDiscount() {
        return discount;
    }

    /**
     * Sets the discount.
     *
     * @param discount
     *            the discount to set
     */
    public final void setDiscount(final Discount discount) {
        this.discount = discount;
    }

    /**
     * Gets the affiliation.
     *
     * @return the affiliation
     */
    public final AffiliationData getAffiliation() {
        return affiliation;
    }

    /**
     * Sets the affiliation.
     *
     * @param affiliation
     *            the affiliation to set
     */
    public final void setAffiliation(final AffiliationData affiliation) {
        this.affiliation = affiliation;
    }

    /**
     * Gets the payment method.
     *
     * @return the paymentMethod
     */
    public final String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method.
     *
     * @param paymentMethod
     *            the paymentMethod to set
     */
    public final void setPaymentMethod(final String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the credit card.
     *
     * @return the creditCard
     */
    public final CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the credit card.
     *
     * @param creditCard
     *            the creditCard to set
     */
    public final void setCreditCard(final CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * Gets the tax details.
     *
     * @return the taxDetails
     */
    public final TaxDetails getTaxDetails() {
        return taxDetails;
    }

    /**
     * Sets the tax details.
     *
     * @param taxDetails
     *            the taxDetails to set
     */
    public final void setTaxDetails(final TaxDetails taxDetails) {
        this.taxDetails = taxDetails;
    }

    /**
     * Gets the addresses.
     *
     * @return the addresses
     */
    public final List<Address> getAddresses() {
        return addresses;
    }

    /**
     * Sets the addresses.
     *
     * @param addresses
     *            the addresses to set
     */
    public final void setAddresses(final List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * Gets the customer.
     *
     * @return the customer
     */
    public final Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer.
     *
     * @param customer
     *            the customer to set
     */
    public final void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets the funding details.
     *
     * @return the fundingDetails
     */
    public final FundingDetails getFundingDetails() {
        return fundingDetails;
    }

    /**
     * Sets the funding details.
     *
     * @param fundingDetails
     *            the fundingDetails to set
     */
    public final void setFundingDetails(final FundingDetails fundingDetails) {
        this.fundingDetails = fundingDetails;
    }

    /** The discount. */
    private Discount discount;

    /** The affiliation. */
    private AffiliationData affiliation;

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

}
