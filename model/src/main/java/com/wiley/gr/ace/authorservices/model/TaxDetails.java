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

/**
 * The Class TaxDetails.
 */
public class TaxDetails {

    /** The tax exemption number. */
    private String taxExemptionNumber;

    /** The tax code expiry date. */
    private String taxCodeExpiryDate;

    /** The tax country code. */
    private String taxCountryCode;

    /**
     * Gets the tax exemption number.
     *
     * @return the tax exemption number
     */
    public final String getTaxExemptionNumber() {
        return taxExemptionNumber;
    }

    /**
     * Sets the tax exemption number.
     *
     * @param taxExemptionNumber the new tax exemption number
     */
    public final void setTaxExemptionNumber(final String taxExemptionNumber) {
        this.taxExemptionNumber = taxExemptionNumber;
    }

    /**
     * Gets the tax code expiry date.
     *
     * @return the tax code expiry date
     */
    public final String getTaxCodeExpiryDate() {
        return taxCodeExpiryDate;
    }

    /**
     * Sets the tax code expiry date.
     *
     * @param taxCodeExpiryDate the new tax code expiry date
     */
    public final void setTaxCodeExpiryDate(final String taxCodeExpiryDate) {
        this.taxCodeExpiryDate = taxCodeExpiryDate;
    }

    /**
     * Gets the tax country code.
     *
     * @return the tax country code
     */
    public final String getTaxCountryCode() {
        return taxCountryCode;
    }

    /**
     * Sets the tax country code.
     *
     * @param taxCountryCode the new tax country code
     */
    public final void setTaxCountryCode(final String taxCountryCode) {
        this.taxCountryCode = taxCountryCode;
    }

}
