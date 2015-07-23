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

/**
 * The Class Quote.
 *
 * @author virtusa version 1.0
 */
public class Quote {

    /** The article publication charge. */
    private String articlePublicationCharge;

    /** The society discount. */
    private String societyDiscount;

    /** The society discount value. */
    private String societyDiscountValue;

    /** The tax. */
    private String tax;

    /**
     * Gets the article publication charge.
     *
     * @return the articlePublicationCharge
     */
    public final String getArticlePublicationCharge() {
        return articlePublicationCharge;
    }

    /**
     * Sets the article publication charge.
     *
     * @param articlePublicationCharge
     *            the articlePublicationCharge to set
     */
    public final void setArticlePublicationCharge(
            final String articlePublicationCharge) {
        this.articlePublicationCharge = articlePublicationCharge;
    }

    /**
     * Gets the society discount.
     *
     * @return the societyDiscount
     */
    public final String getSocietyDiscount() {
        return societyDiscount;
    }

    /**
     * Sets the society discount.
     *
     * @param societyDiscount
     *            the societyDiscount to set
     */
    public final void setSocietyDiscount(final String societyDiscount) {
        this.societyDiscount = societyDiscount;
    }

    /**
     * Gets the society discount value.
     *
     * @return the societyDiscountValue
     */
    public final String getSocietyDiscountValue() {
        return societyDiscountValue;
    }

    /**
     * Sets the society discount value.
     *
     * @param societyDiscountValue
     *            the societyDiscountValue to set
     */
    public final void setSocietyDiscountValue(final String societyDiscountValue) {
        this.societyDiscountValue = societyDiscountValue;
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
     *            the tax to set
     */
    public final void setTax(final String tax) {
        this.tax = tax;
    }

    /**
     * Gets the due amount.
     *
     * @return the dueAmount
     */
    public final String getDueAmount() {
        return dueAmount;
    }

    /**
     * Sets the due amount.
     *
     * @param dueAmount
     *            the dueAmount to set
     */
    public final void setDueAmount(final String dueAmount) {
        this.dueAmount = dueAmount;
    }

    /** The due amount. */
    private String dueAmount;

}
