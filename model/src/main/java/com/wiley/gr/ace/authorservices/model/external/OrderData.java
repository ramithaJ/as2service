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
import com.wiley.gr.ace.authorservices.model.Amount;

/**
 * The Class Order.
 *
 * @author virtusa version 1.0
 */
public class OrderData {

    /** The article id. */
    private String articleId;
    /** The final amount. */
    private Amount finalAmount;

    /** The amount payable. */
    private Amount amountPayable;

    /** The journal id. */
    private String journalId;

    /** The order type. */
    private String orderType;

    /** The pricing. */
    private PricingData pricing;

    /** The discount. */
    private DiscountData discount;

    /** The affiliation. */
    private AffiliationData affiliation;

    /** The payment method. */
    private String paymentMethod;

    /** The tax details. */
    private TaxData taxDetails;

    /** The addresses. */
    private List<Address> addresses;

    /** The customer. */
    private Customer customer;

    /** The funding details. */
    private FundingDetails fundingDetails;

    /**
     * @return the articleId
     */
    public final String getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     *            the articleId to set
     */
    public final void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    /**
     * @return the journalId
     */
    public final String getJournalId() {
        return journalId;
    }

    /**
     * @param journalId
     *            the journalId to set
     */
    public final void setJournalId(final String journalId) {
        this.journalId = journalId;
    }

    /**
     * @return the orderType
     */
    public final String getOrderType() {
        return orderType;
    }

    /**
     * @param orderType
     *            the orderType to set
     */
    public final void setOrderType(final String orderType) {
        this.orderType = orderType;
    }

    /**
     * @return the pricing
     */
    public final PricingData getPricing() {
        return pricing;
    }

    /**
     * @param pricing
     *            the pricing to set
     */
    public final void setPricing(final PricingData pricing) {
        this.pricing = pricing;
    }

    /**
     * @return the discount
     */
    public final DiscountData getDiscount() {
        return discount;
    }

    /**
     * @param discount
     *            the discount to set
     */
    public final void setDiscount(final DiscountData discount) {
        this.discount = discount;
    }

    /**
     * @return the affiliation
     */
    public final AffiliationData getAffiliation() {
        return affiliation;
    }

    /**
     * @param affiliation
     *            the affiliation to set
     */
    public final void setAffiliation(final AffiliationData affiliation) {
        this.affiliation = affiliation;
    }

    /**
     * @return the paymentMethod
     */
    public final String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod
     *            the paymentMethod to set
     */
    public final void setPaymentMethod(final String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return the taxDetails
     */
    public final TaxData getTaxDetails() {
        return taxDetails;
    }

    /**
     * @param taxDetails
     *            the taxDetails to set
     */
    public final void setTaxDetails(final TaxData taxDetails) {
        this.taxDetails = taxDetails;
    }

    /**
     * @return the addresses
     */
    public final List<Address> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses
     *            the addresses to set
     */
    public final void setAddresses(final List<Address> addresses) {
        this.addresses = addresses;
    }

    /**
     * @return the customer
     */
    public final Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer
     *            the customer to set
     */
    public final void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the fundingDetails
     */
    public final FundingDetails getFundingDetails() {
        return fundingDetails;
    }

    /**
     * @param fundingDetails
     *            the fundingDetails to set
     */
    public final void setFundingDetails(final FundingDetails fundingDetails) {
        this.fundingDetails = fundingDetails;
    }

	/**
	 * @return
	 */
	public Amount getFinalAmount() {
		return finalAmount;
	}

	/**
	 * @param finalAmount
	 */
	public void setFinalAmount(Amount finalAmount) {
		this.finalAmount = finalAmount;
	}

	/**
	 * @return
	 */
	public Amount getAmountPayable() {
		return amountPayable;
	}

	/**
	 * @param amountPayable
	 */
	public void setAmountPayable(Amount amountPayable) {
		this.amountPayable = amountPayable;
	}

}
