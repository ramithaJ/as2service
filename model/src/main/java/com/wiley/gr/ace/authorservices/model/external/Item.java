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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Item.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Item {

    /** The id. */
    private String id;

    /** The product code. */
    private String productCode;

    /** The journal print issn. */
    private String journalPrintISSN;

    /** The discounted line amount. */
    private String discountedLineAmount;

    /** The journal electronic issn. */
    private String journalElectronicISSN;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the product code.
     *
     * @return the product code
     */
    public final String getProductCode() {
        return productCode;
    }

    /**
     * Sets the product code.
     *
     * @param productCode
     *            the new product code
     */
    public final void setProductCode(final String productCode) {
        this.productCode = productCode;
    }

    /**
     * Gets the journal print issn.
     *
     * @return the journal print issn
     */
    public final String getJournalPrintISSN() {
        return journalPrintISSN;
    }

    /**
     * Sets the journal print issn.
     *
     * @param journalPrintISSN
     *            the new journal print issn
     */
    public final void setJournalPrintISSN(final String journalPrintISSN) {
        this.journalPrintISSN = journalPrintISSN;
    }

    /**
     * Gets the discounted line amount.
     *
     * @return the discounted line amount
     */
    public final String getDiscountedLineAmount() {
        return discountedLineAmount;
    }

    /**
     * Sets the discounted line amount.
     *
     * @param discountedLineAmount
     *            the new discounted line amount
     */
    public final void setDiscountedLineAmount(final String discountedLineAmount) {
        this.discountedLineAmount = discountedLineAmount;
    }

    /**
     * Gets the journal electronic issn.
     *
     * @return the journal electronic issn
     */
    public final String getJournalElectronicISSN() {
        return journalElectronicISSN;
    }

    /**
     * Sets the journal electronic issn.
     *
     * @param journalElectronicISSN
     *            the new journal electronic issn
     */
    public final void setJournalElectronicISSN(
            final String journalElectronicISSN) {
        this.journalElectronicISSN = journalElectronicISSN;
    }
}
