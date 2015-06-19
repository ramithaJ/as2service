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

    /** The tax exemption number. */
    private String taxExemptionNumber;

    /** The tax code expiry date. */
    private String taxCodeExpiryDate;

    /** The vat id number. */
    private String vatIdNumber;

    /** The vat exemption number. */
    private String vatExemptionNumber;

    /** The tax country code. */
    private String countryCode;

    public final String getTaxExemptionNumber() {
        return taxExemptionNumber;
    }

    public final void setTaxExemptionNumber(String taxExemptionNumber) {
        this.taxExemptionNumber = taxExemptionNumber;
    }

    public final String getTaxCodeExpiryDate() {
        return taxCodeExpiryDate;
    }

    public final void setTaxCodeExpiryDate(String taxCodeExpiryDate) {
        this.taxCodeExpiryDate = taxCodeExpiryDate;
    }

    public final String getVatIdNumber() {
        return vatIdNumber;
    }

    public final void setVatIdNumber(String vatIdNumber) {
        this.vatIdNumber = vatIdNumber;
    }

    public final String getVatExemptionNumber() {
        return vatExemptionNumber;
    }

    public final void setVatExemptionNumber(String vatExemptionNumber) {
        this.vatExemptionNumber = vatExemptionNumber;
    }

    public final String getCountryCode() {
        return countryCode;
    }

    public final void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
