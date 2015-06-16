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

    /** The due amount. */
    private String dueAmount;

    /**
     * Gets the article publication charge.
     *
     * @return the article publication charge
     */
    public String getArticlePublicationCharge() {
        return articlePublicationCharge;
    }

    /**
     * Sets the article publication charge.
     *
     * @param articlePublicationCharge
     *            the new article publication charge
     */
    public void setArticlePublicationCharge(String articlePublicationCharge) {
        this.articlePublicationCharge = articlePublicationCharge;
    }

    /**
     * Gets the society discount.
     *
     * @return the society discount
     */
    public String getSocietyDiscount() {
        return societyDiscount;
    }

    /**
     * Sets the society discount.
     *
     * @param societyDiscount
     *            the new society discount
     */
    public void setSocietyDiscount(String societyDiscount) {
        this.societyDiscount = societyDiscount;
    }

    /**
     * Gets the society discount value.
     *
     * @return the society discount value
     */
    public String getSocietyDiscountValue() {
        return societyDiscountValue;
    }

    /**
     * Sets the society discount value.
     *
     * @param societyDiscountValue
     *            the new society discount value
     */
    public void setSocietyDiscountValue(String societyDiscountValue) {
        this.societyDiscountValue = societyDiscountValue;
    }

    /**
     * Gets the tax.
     *
     * @return the tax
     */
    public String getTax() {
        return tax;
    }

    /**
     * Sets the tax.
     *
     * @param tax
     *            the new tax
     */
    public void setTax(String tax) {
        this.tax = tax;
    }

    /**
     * Gets the due amount.
     *
     * @return the due amount
     */
    public String getDueAmount() {
        return dueAmount;
    }

    /**
     * Sets the due amount.
     *
     * @param dueAmount
     *            the new due amount
     */
    public void setDueAmount(String dueAmount) {
        this.dueAmount = dueAmount;
    }

}
