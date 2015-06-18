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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ArticleData.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ArticleData {

    /** The article details. */
    private ArticleDetails articleDetails;

    /** The journal details. */
    private JournalDetails journalDetails;

    /** The article user role. */
    private String articleUserRole;

    /** The license status. */
    private String licenseStatus;

    /** The order payment status. */
    private OrderPaymentStatus orderPaymentStatus;

    /** The production status. */
    private String productionStatus;

    /** The quote. */
    private List<PriceObject> quote;

    /** The society discount. */
    private String societyDiscount;

    /** The tax. */
    private String tax;

    /** The final price. */
    private List<PriceObject> finalPrice;

    /**
     * Gets the article details.
     *
     * @return the articleDetails
     */
    public final ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    /**
     * Sets the article details.
     *
     * @param articleDetails
     *            the articleDetails to set
     */
    public final void setArticleDetails(final ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * Gets the journal details.
     *
     * @return the journalDetails
     */
    public final JournalDetails getJournalDetails() {
        return journalDetails;
    }

    /**
     * Sets the journal details.
     *
     * @param journalDetails
     *            the journalDetails to set
     */
    public final void setJournalDetails(final JournalDetails journalDetails) {
        this.journalDetails = journalDetails;
    }

    /**
     * Gets the article user role.
     *
     * @return the articleUserRole
     */
    public final String getArticleUserRole() {
        return articleUserRole;
    }

    /**
     * Sets the article user role.
     *
     * @param articleUserRole
     *            the articleUserRole to set
     */
    public final void setArticleUserRole(final String articleUserRole) {
        this.articleUserRole = articleUserRole;
    }

    /**
     * Gets the license status.
     *
     * @return the licenseStatus
     */
    public final String getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * Sets the license status.
     *
     * @param licenseStatus
     *            the licenseStatus to set
     */
    public final void setLicenseStatus(final String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    /**
     * Gets the order payment status.
     *
     * @return the orderPaymentStatus
     */
    public final OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    /**
     * Sets the order payment status.
     *
     * @param orderPaymentStatus
     *            the orderPaymentStatus to set
     */
    public final void setOrderPaymentStatus(
            final OrderPaymentStatus orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    /**
     * Gets the production status.
     *
     * @return the productionStatus
     */
    public final String getProductionStatus() {
        return productionStatus;
    }

    /**
     * Sets the production status.
     *
     * @param productionStatus
     *            the productionStatus to set
     */
    public final void setProductionStatus(final String productionStatus) {
        this.productionStatus = productionStatus;
    }

    /**
     * Gets the quote.
     *
     * @return the quote
     */
    public final List<PriceObject> getQuote() {
        return quote;
    }

    /**
     * Sets the quote.
     *
     * @param quote
     *            the new quote
     */
    public final void setQuote(final List<PriceObject> quote) {
        this.quote = quote;
    }

    /**
     * Gets the society discount.
     *
     * @return the society discount
     */
    public final String getSocietyDiscount() {
        return societyDiscount;
    }

    /**
     * Sets the society discount.
     *
     * @param societyDiscount
     *            the new society discount
     */
    public final void setSocietyDiscount(final String societyDiscount) {
        this.societyDiscount = societyDiscount;
    }

    /**
     * Gets the tax.
     *
     * @return the tax
     */
    public final String getTax() {
        return tax;
    }

    /**
     * Sets the tax.
     *
     * @param tax
     *            the new tax
     */
    public final void setTax(final String tax) {
        this.tax = tax;
    }

    /**
     * Gets the final price.
     *
     * @return the final price
     */
    public final List<PriceObject> getFinalPrice() {
        return finalPrice;
    }

    /**
     * Sets the final price.
     *
     * @param finalPrice
     *            the new final price
     */
    public final void setFinalPrice(final List<PriceObject> finalPrice) {
        this.finalPrice = finalPrice;
    }
}
