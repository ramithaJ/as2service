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

/**
 * The Class OnlineOpenOrder.
 */
public class OnlineOpenOrder {

    /** The final amount. */
    private Amount finalAmount;

    /** The amount payable. */
    private Amount amountPayable;

    /** The address details. */
    private List<AddressDetails> addressDetails;

    /** The journal id. */
    private String journalId;

    /** The discounts. */
    private Discounts discounts;

    /** The tax percentage. */
    private String taxPercentage;

    /** The funder details. */
    private List<FunderDetails> funderDetails;

    /** The tax details. */
    private TaxDetails taxDetails;

    /** The payment method. */
    private String paymentMethod;

    /** The article id. */
    private String articleId;

   

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
     * @param finalAmount the new final amount
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
     * @param amountPayable the new amount payable
     */
    public final void setAmountPayable(final Amount amountPayable) {
        this.amountPayable = amountPayable;
    }

    /**
     * Gets the address details.
     *
     * @return the address details
     */
    public final List<AddressDetails> getAddressDetails() {
        return addressDetails;
    }

    /**
     * Sets the address details.
     *
     * @param addressDetails the new address details
     */
    public final void setAddressDetails(final List<AddressDetails> addressDetails) {
        this.addressDetails = addressDetails;
    }

    /**
     * Gets the journal id.
     *
     * @return the journal id
     */
    public final String getJournalId() {
        return journalId;
    }

    /**
     * Sets the journal id.
     *
     * @param journalId the new journal id
     */
    public final void setJournalId(final String journalId) {
        this.journalId = journalId;
    }

    /**
     * Gets the discounts.
     *
     * @return the discounts
     */
    public final Discounts getDiscounts() {
        return discounts;
    }

    /**
     * Sets the discounts.
     *
     * @param discounts the new discounts
     */
    public final void setDiscounts(final Discounts discounts) {
        this.discounts = discounts;
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
     * @param taxPercentage the new tax percentage
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
     * @param funderDetails the new funder details
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
     * @param taxDetails the new tax details
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
     * @param paymentMethod the new payment method
     */
    public final void setPaymentMethod(final String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the article id.
     *
     * @return the article id
     */
    public final String getArticleId() {
        return articleId;
    }

    /**
     * Sets the article id.
     *
     * @param articleId the new article id
     */
    public final void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

}
