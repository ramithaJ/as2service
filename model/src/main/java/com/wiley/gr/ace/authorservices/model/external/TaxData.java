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
public class TaxData {

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
     * 
     * @return The taxNumber
     */
    public String getTaxNumber() {
        return taxNumber;
    }

    /**
     * 
     * @param taxNumber
     *            The taxNumber
     */
    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    /**
     * 
     * @return The taxExpiration
     */
    public String getTaxExpiration() {
        return taxExpiration;
    }

    /**
     * 
     * @param taxExpiration
     *            The taxExpiration
     */
    public void setTaxExpiration(String taxExpiration) {
        this.taxExpiration = taxExpiration;
    }

    /**
     * 
     * @return The vatIdNumber
     */
    public String getVatIdNumber() {
        return vatIdNumber;
    }

    /**
     * 
     * @param vatIdNumber
     *            The vatIdNumber
     */
    public void setVatIdNumber(String vatIdNumber) {
        this.vatIdNumber = vatIdNumber;
    }

    /**
     * 
     * @return The vatExemptionNumber
     */
    public String getVatExemptionNumber() {
        return vatExemptionNumber;
    }

    /**
     * 
     * @param vatExemptionNumber
     *            The vatExemptionNumber
     */
    public void setVatExemptionNumber(String vatExemptionNumber) {
        this.vatExemptionNumber = vatExemptionNumber;
    }

    /**
     * 
     * @return The countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @param countryCode
     *            The countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
