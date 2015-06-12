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
 * @author virtusa
 * version 1.0
 */
public class TaxDetails {
    
    private String taxNumber;
    
    private String taxExpiration;
    
    private String vatIdNumber;
    
    private String vatExemptionNumber;
    
    private String countryCode;

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getTaxExpiration() {
        return taxExpiration;
    }

    public void setTaxExpiration(String taxExpiration) {
        this.taxExpiration = taxExpiration;
    }

    public String getVatIdNumber() {
        return vatIdNumber;
    }

    public void setVatIdNumber(String vatIdNumber) {
        this.vatIdNumber = vatIdNumber;
    }

    public String getVatExemptionNumber() {
        return vatExemptionNumber;
    }

    public void setVatExemptionNumber(String vatExemptionNumber) {
        this.vatExemptionNumber = vatExemptionNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    
}
