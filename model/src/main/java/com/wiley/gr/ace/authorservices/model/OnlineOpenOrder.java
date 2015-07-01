/*
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 */
package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class OnlineOpenOrder.
 */
@JsonInclude(Include.NON_NULL)
public class OnlineOpenOrder {

    /** The final amount. */
    private Amount finalAmount;

    /** The amount payable. */
    private Amount amountPayable;

    /** The address details. */
    private AddressDetails addressDetails;

    /** The journal details. */
    private List<JournalDetails> journalDetails;

    /** The discount details. */
    private List<Discounts> discountDetails;

    /** The tax percentage. */
    private String taxPercentage = "0.00";

    /** The funder details. */
    private List<FunderDetails> funderDetails;

    /** The tax details. */
    private TaxDetails taxDetails;

    /** The payment method. */
    private String paymentMethod;

    /** The article id. */
    private List<ArticleDetails> articleDetails;

    /** The author name. */
    private String authorName;

    /** The quote detail. */
    private QuoteDetail quoteDetail;

    /** The discounts applicable. */
    private String discountsApplicable;

    /** The billing same as correspondence address. */
    private boolean billingSameAsCorrespondenceAddress;

    /** The is licence signed. */
    private boolean isLicenceSigned;

    /** The tax amount. */
    private Amount taxAmount;
    
    /** The order Id */
    private String orderId;

    /**
     * Gets the final amount.
     *
     * @return the final amount
     */
    public final Amount getFinalAmount() {
        return finalAmount;
    }

    /**
     * Sets the final amount.
     *
     * @param finalAmount
     *            the new final amount
     */
    public final void setFinalAmount(final Amount finalAmount) {
        this.finalAmount = finalAmount;
    }

    /**
     * Gets the amount payable.
     *
     * @return the amount payable
     */
    public final Amount getAmountPayable() {
        return amountPayable;
    }

    /**
     * Sets the amount payable.
     *
     * @param amountPayable
     *            the new amount payable
     */
    public final void setAmountPayable(final Amount amountPayable) {
        this.amountPayable = amountPayable;
    }

    /**
     * Gets the address details.
     *
     * @return the address details
     */
    public final AddressDetails getAddressDetails() {
        return addressDetails;
    }

    /**
     * Sets the address details.
     *
     * @param addressDetails
     *            the new address details
     */
    public final void setAddressDetails(final AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    /**
     * Gets the tax percentage.
     *
     * @return the tax percentage
     */
    public final String getTaxPercentage() {
        return taxPercentage;
    }

    /**
     * Sets the tax percentage.
     *
     * @param taxPercentage
     *            the new tax percentage
     */
    public final void setTaxPercentage(final String taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    /**
     * Gets the funder details.
     *
     * @return the funder details
     */
    public final List<FunderDetails> getFunderDetails() {
        return funderDetails;
    }

    /**
     * Sets the funder details.
     *
     * @param funderDetails
     *            the new funder details
     */
    public final void setFunderDetails(final List<FunderDetails> funderDetails) {
        this.funderDetails = funderDetails;
    }

    /**
     * Gets the tax details.
     *
     * @return the tax details
     */
    public final TaxDetails getTaxDetails() {
        return taxDetails;
    }

    /**
     * Sets the tax details.
     *
     * @param taxDetails
     *            the new tax details
     */
    public final void setTaxDetails(final TaxDetails taxDetails) {
        this.taxDetails = taxDetails;
    }

    /**
     * Gets the payment method.
     *
     * @return the payment method
     */
    public final String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method.
     *
     * @param paymentMethod
     *            the new payment method
     */
    public final void setPaymentMethod(final String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the article details.
     *
     * @return the article details
     */
    public final List<ArticleDetails> getArticleDetails() {
        return articleDetails;
    }

    /**
     * Sets the article details.
     *
     * @param articleDetails
     *            the new article details
     */
    public final void setArticleDetails(
            final List<ArticleDetails> articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * Gets the journal details.
     *
     * @return the journal details
     */
    public final List<JournalDetails> getJournalDetails() {
        return journalDetails;
    }

    /**
     * Sets the journal details.
     *
     * @param journalDetails
     *            the new journal details
     */
    public final void setJournalDetails(
            final List<JournalDetails> journalDetails) {
        this.journalDetails = journalDetails;
    }

    /**
     * Gets the discount details.
     *
     * @return the discount details
     */
    public final List<Discounts> getDiscountDetails() {
        return discountDetails;
    }

    /**
     * Gets the author name.
     *
     * @return the author name
     */
    public final String getAuthorName() {
        return authorName;
    }

    /**
     * Gets the quote detail.
     *
     * @return the quote detail
     */
    public final QuoteDetail getQuoteDetail() {
        return quoteDetail;
    }

    /**
     * Gets the discounts applicable.
     *
     * @return the discounts applicable
     */
    public final String getDiscountsApplicable() {
        return discountsApplicable;
    }

    /**
     * Checks if is billing same as correspondence address.
     *
     * @return true, if is billing same as correspondence address
     */
    public final boolean isBillingSameAsCorrespondenceAddress() {
        return billingSameAsCorrespondenceAddress;
    }

    /**
     * Sets the discount details.
     *
     * @param discountDetails
     *            the new discount details
     */
    public final void setDiscountDetails(final List<Discounts> discountDetails) {
        this.discountDetails = discountDetails;
    }

    /**
     * Sets the author name.
     *
     * @param authorName
     *            the new author name
     */
    public final void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }

    /**
     * Sets the quote detail.
     *
     * @param quoteDetail
     *            the new quote detail
     */
    public final void setQuoteDetail(final QuoteDetail quoteDetail) {
        this.quoteDetail = quoteDetail;
    }

    /**
     * Sets the discounts applicable.
     *
     * @param discountsApplicable
     *            the new discounts applicable
     */
    public final void setDiscountsApplicable(final String discountsApplicable) {
        this.discountsApplicable = discountsApplicable;
    }

    /**
     * Sets the billing same as correspondence address.
     *
     * @param billingSameAsCorrespondenceAddress
     *            the new billing same as correspondence address
     */
    public final void setBillingSameAsCorrespondenceAddress(
            final boolean billingSameAsCorrespondenceAddress) {
        this.billingSameAsCorrespondenceAddress = billingSameAsCorrespondenceAddress;
    }

    /**
     * Checks if is licence signed.
     *
     * @return true, if is licence signed
     */
    public final boolean isLicenceSigned() {
        return isLicenceSigned;
    }

    /**
     * Gets the tax amount.
     *
     * @return the tax amount
     */
    public final Amount getTaxAmount() {
        return taxAmount;
    }

    /**
     * Sets the licence signed.
     *
     * @param isLicenceSigned
     *            the new licence signed
     */
    public final void setLicenceSigned(final boolean isLicenceSigned) {
        this.isLicenceSigned = isLicenceSigned;
    }

    /**
     * Sets the tax amount.
     *
     * @param taxAmount
     *            the new tax amount
     */
    public final void setTaxAmount(final Amount taxAmount) {
        this.taxAmount = taxAmount;
    }

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
    
    

}
