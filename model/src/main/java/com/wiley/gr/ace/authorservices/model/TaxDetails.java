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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class TaxDetails.
 */
/**
 * @author kpshiva
 *
 */
@JsonInclude(Include.NON_NULL)
public class TaxDetails {

    /** The tax exemption number. */
    private String taxExemptionNumber;

    /** The tax code expiry date. */
    private String taxCodeExpiryDate;

    /** The vat id number. */
    private String vatIdNumber;

    /** The vat exemption number. */
    private String vatExemptionNumber;

    /** The tax country code. */
    private String taxCountryCode;

    /**
     * @return the taxExemptionNumber
     */
    public final String getTaxExemptionNumber() {
        return taxExemptionNumber;
    }

    /**
     * @param taxExemptionNumber
     *            the taxExemptionNumber to set
     */
    public final void setTaxExemptionNumber(final String taxExemptionNumber) {
        this.taxExemptionNumber = taxExemptionNumber;
    }

    /**
     * @return the taxCodeExpiryDate
     */
    public final String getTaxCodeExpiryDate() {
        return taxCodeExpiryDate;
    }

    /**
     * @param taxCodeExpiryDate
     *            the taxCodeExpiryDate to set
     */
    public final void setTaxCodeExpiryDate(final String taxCodeExpiryDate) {
        this.taxCodeExpiryDate = taxCodeExpiryDate;
    }

    /**
     * @return the vatIdNumber
     */
    public final String getVatIdNumber() {
        return vatIdNumber;
    }

    /**
     * @param vatIdNumber
     *            the vatIdNumber to set
     */
    public final void setVatIdNumber(final String vatIdNumber) {
        this.vatIdNumber = vatIdNumber;
    }

    /**
     * @return the vatExemptionNumber
     */
    public final String getVatExemptionNumber() {
        return vatExemptionNumber;
    }

    /**
     * @param vatExemptionNumber
     *            the vatExemptionNumber to set
     */
    public final void setVatExemptionNumber(final String vatExemptionNumber) {
        this.vatExemptionNumber = vatExemptionNumber;
    }

    /**
     * @return the taxCountryCode
     */
    public final String getTaxCountryCode() {
        return taxCountryCode;
    }

    /**
     * @param taxCountryCode
     *            the taxCountryCode to set
     */
    public final void setTaxCountryCode(final String taxCountryCode) {
        this.taxCountryCode = taxCountryCode;
    }

}
