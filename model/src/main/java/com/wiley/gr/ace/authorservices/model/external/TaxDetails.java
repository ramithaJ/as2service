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

    /** The country code. */
    private String countryCode;

    /**
     * Gets the tax number.
     *
     * @return the tax number
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * Sets the tax number.
     *
     * @param taxNumber
     *            the new tax number
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * Gets the tax expiration.
     *
     * @return the tax expiration
     */
    public String getTaxExpiration() {
        return taxExpiration;
    }

    /**
     * Sets the tax expiration.
     *
     * @param taxExpiration
     *            the new tax expiration
     */
    public void setTaxExpiration(String taxExpiration) {
        this.taxExpiration = taxExpiration;
    }

    /**
     * Gets the vat id number.
     *
     * @return the vat id number
     */
    public String getVatIdNumber() {
        return vatIdNumber;
    }

    /**
     * Sets the vat id number.
     *
     * @param vatIdNumber
     *            the new vat id number
     */
    public void setVatIdNumber(String vatIdNumber) {
        this.vatIdNumber = vatIdNumber;
    }

    /**
     * Gets the vat exemption number.
     *
     * @return the vat exemption number
     */
    public String getVatExemptionNumber() {
        return vatExemptionNumber;
    }

    /**
     * Sets the vat exemption number.
     *
     * @param vatExemptionNumber
     *            the new vat exemption number
     */
    public void setVatExemptionNumber(String vatExemptionNumber) {
        this.vatExemptionNumber = vatExemptionNumber;
    }

    /**
     * Gets the country code.
     *
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code.
     *
     * @param countryCode
     *            the new country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
