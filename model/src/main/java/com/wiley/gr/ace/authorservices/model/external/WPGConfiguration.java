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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class WPGConfiguration {

    /**
     * This field holds the value of acquirerId.
     */
    @JsonProperty("ACQUIRER_ID")
    private String acquirerId;

    /**
     * . This field holds the value of wpgTimeStmap.
     */
    @JsonProperty("WPG_timestamp")
    private String wpgTimeStmap;

    /**
     * This field holds the value of wpgVendorId.
     */
    @JsonProperty("WPG_vendorID")
    private String wpgVendorId;

    /**
     * This field holds the value of wpgTransId.
     */
    @JsonProperty("WPG_transID")
    private String wpgTransId;

    /**
     * This field holds the value of wpgMethod.
     */
    @JsonProperty("WPG_method")
    private String wpgMethod;

    /**
     * This field holds the value of wpgDescription.
     */
    @JsonProperty("WPG_description")
    private String wpgDescription;

    /**
     * This field holds the value of wpgValue.
     */
    @JsonProperty("WPG_value")
    private String wpgValue;

    /**
     * This field holds the value of wpgCurrency.
     */
    @JsonProperty("WPG_currency")
    private String wpgCurrency;

    /**
     * This field holds the value of wpgRegion.
     */
    @JsonProperty("WPG_region")
    private String wpgRegion;

    /**
     * This field holds the value of wpgAddress.
     */
    @JsonProperty("WPG_address")
    private String wpgAddress;

    /**
     * This field holds the value of wpgPostCode.
     */
    @JsonProperty("WPG_postcode")
    private String wpgPostCode;

    /**
     * This field holds the value of wpgCountryCode.
     */
    @JsonProperty("WPG_countryCode")
    private String wpgCountryCode;

    /**
     * This field holds the value of wpgAllowAVSFail.
     */
    @JsonProperty("WPG_allowAVSFail")
    private String wpgAllowAVSFail;

    /**
     * This field holds the value of wpgSecurity.
     */
    @JsonProperty("WPG_security")
    private String wpgSecurity;

    /**
     * This field holds the value of articleName.
     */
    private String articleName;

    /**
     * This field holds the value of journalName.
     */
    private String journalName;

    /**
     * This field holds the value of currency.
     */
    private String currency;

    /**
     * This field holds the value of price.
     */
    private String price;

    /**
     * This field holds the value of tax.
     */
    private String tax;

    /**
     * This field holds the value of totalAmount.
     */
    private String totalAmount;

    /**
     * @return the acquirerId
     */
    public final String getAcquirerId() {
        return acquirerId;
    }

    /**
     * @param acquirerId
     *            the acquirerId to set
     */
    public final void setAcquirerId(final String acquirerId) {
        this.acquirerId = acquirerId;
    }

    /**
     * @return the wpgTimeStmap
     */
    public final String getWpgTimeStmap() {
        return wpgTimeStmap;
    }

    /**
     * @param wpgTimeStmap
     *            the wpgTimeStmap to set
     */
    public final void setWpgTimeStmap(final String wpgTimeStmap) {
        this.wpgTimeStmap = wpgTimeStmap;
    }

    /**
     * @return the wpgVendorId
     */
    public final String getWpgVendorId() {
        return wpgVendorId;
    }

    /**
     * @param wpgVendorId
     *            the wpgVendorId to set
     */
    public final void setWpgVendorId(final String wpgVendorId) {
        this.wpgVendorId = wpgVendorId;
    }

    /**
     * @return the wpgTransId
     */
    public final String getWpgTransId() {
        return wpgTransId;
    }

    /**
     * @param wpgTransId
     *            the wpgTransId to set
     */
    public final void setWpgTransId(final String wpgTransId) {
        this.wpgTransId = wpgTransId;
    }

    /**
     * @return the wpgMethod
     */
    public final String getWpgMethod() {
        return wpgMethod;
    }

    /**
     * @param wpgMethod
     *            the wpgMethod to set
     */
    public final void setWpgMethod(final String wpgMethod) {
        this.wpgMethod = wpgMethod;
    }

    /**
     * @return the wpgDescription
     */
    public final String getWpgDescription() {
        return wpgDescription;
    }

    /**
     * @param wpgDescription
     *            the wpgDescription to set
     */
    public final void setWpgDescription(final String wpgDescription) {
        this.wpgDescription = wpgDescription;
    }

    /**
     * @return the wpgValue
     */
    public final String getWpgValue() {
        return wpgValue;
    }

    /**
     * @param wpgValue
     *            the wpgValue to set
     */
    public final void setWpgValue(final String wpgValue) {
        this.wpgValue = wpgValue;
    }

    /**
     * @return the wpgCurrency
     */
    public final String getWpgCurrency() {
        return wpgCurrency;
    }

    /**
     * @param wpgCurrency
     *            the wpgCurrency to set
     */
    public final void setWpgCurrency(final String wpgCurrency) {
        this.wpgCurrency = wpgCurrency;
    }

    /**
     * @return the wpgRegion
     */
    public final String getWpgRegion() {
        return wpgRegion;
    }

    /**
     * @param wpgRegion
     *            the wpgRegion to set
     */
    public final void setWpgRegion(final String wpgRegion) {
        this.wpgRegion = wpgRegion;
    }

    /**
     * @return the wpgAddress
     */
    public final String getWpgAddress() {
        return wpgAddress;
    }

    /**
     * @param wpgAddress
     *            the wpgAddress to set
     */
    public final void setWpgAddress(final String wpgAddress) {
        this.wpgAddress = wpgAddress;
    }

    /**
     * @return the wpgPostCode
     */
    public final String getWpgPostCode() {
        return wpgPostCode;
    }

    /**
     * @param wpgPostCode
     *            the wpgPostCode to set
     */
    public final void setWpgPostCode(final String wpgPostCode) {
        this.wpgPostCode = wpgPostCode;
    }

    /**
     * @return the wpgCountryCode
     */
    public final String getWpgCountryCode() {
        return wpgCountryCode;
    }

    /**
     * @param wpgCountryCode
     *            the wpgCountryCode to set
     */
    public final void setWpgCountryCode(final String wpgCountryCode) {
        this.wpgCountryCode = wpgCountryCode;
    }

    /**
     * @return the wpgAllowAVSFail
     */
    public final String getWpgAllowAVSFail() {
        return wpgAllowAVSFail;
    }

    /**
     * @param wpgAllowAVSFail
     *            the wpgAllowAVSFail to set
     */
    public final void setWpgAllowAVSFail(final String wpgAllowAVSFail) {
        this.wpgAllowAVSFail = wpgAllowAVSFail;
    }

    /**
     * @return the wpgSecurity
     */
    public final String getWpgSecurity() {
        return wpgSecurity;
    }

    /**
     * @param wpgSecurity
     *            the wpgSecurity to set
     */
    public final void setWpgSecurity(final String wpgSecurity) {
        this.wpgSecurity = wpgSecurity;
    }

    /**
     * @return the articleName
     */
    public String getArticleName() {
        return articleName;
    }

    /**
     * @param articleName
     *            the articleName to set
     */
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    /**
     * @return the journalName
     */
    public String getJournalName() {
        return journalName;
    }

    /**
     * @param journalName
     *            the journalName to set
     */
    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency
     *            the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the tax
     */
    public String getTax() {
        return tax;
    }

    /**
     * @param tax
     *            the tax to set
     */
    public void setTax(String tax) {
        this.tax = tax;
    }

    /**
     * @return the totalAmount
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount
     *            the totalAmount to set
     */
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

}
