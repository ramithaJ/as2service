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
 * The Class TaxDetails.
 *
 * @author virtusa version 1.0
 */
public class TaxDetails {

    /** The tax number. */
    private String taxNumber;

    /** The tax expiration. */
    private String taxExpiration;

    /** The vat id number. */
    private String vatIdNumber;

    /** The vat exemption number. */
    private String vatExemptionNumber;

    /**
     * @return the taxNumber
     */
    public final String getTaxNumber() {
        return taxNumber;
    }

    /**
     * @param taxNumber
     *            the taxNumber to set
     */
    public final void setTaxNumber(final String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * @return the taxExpiration
     */
    public final String getTaxExpiration() {
        return taxExpiration;
    }

    /**
     * @param taxExpiration
     *            the taxExpiration to set
     */
    public final void setTaxExpiration(final String taxExpiration) {
        this.taxExpiration = taxExpiration;
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
     * @return the countryCode
     */
    public final String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode
     *            the countryCode to set
     */
    public final void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    /** The country code. */
    private String countryCode;

}
