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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class TaxRequest.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class TaxRequest {

    /** The tax exemption expiry date. */
    private String taxExemptionExpiryDate;

    /** The state prov. */
    private String stateProv;

    /** The tax exemption. */
    private String taxExemption;

    /** The item. */
    private List<Item> item;

    /** The city name. */
    private String cityName;

    /** The request created timestamp. */
    private String requestCreatedTimestamp;

    /** The request type. */
    private String requestType;

    /** The zip postal code. */
    private String zipPostalCode;

    /** The vat id. */
    private String vatId;

    /** The country. */
    private String country;

    /**
     * Gets the tax exemption expiry date.
     *
     * @return the tax exemption expiry date
     */
    public final String getTaxExemptionExpiryDate() {
        return taxExemptionExpiryDate;
    }

    /**
     * Sets the tax exemption expiry date.
     *
     * @param taxExemptionExpiryDate
     *            the new tax exemption expiry date
     */
    public final void setTaxExemptionExpiryDate(
            final String taxExemptionExpiryDate) {
        this.taxExemptionExpiryDate = taxExemptionExpiryDate;
    }

    /**
     * Gets the state prov.
     *
     * @return the state prov
     */
    public final String getStateProv() {
        return stateProv;
    }

    /**
     * Sets the state prov.
     *
     * @param stateProv
     *            the new state prov
     */
    public final void setStateProv(final String stateProv) {
        this.stateProv = stateProv;
    }

    /**
     * Gets the tax exemption.
     *
     * @return the tax exemption
     */
    public final String getTaxExemption() {
        return taxExemption;
    }

    /**
     * Sets the tax exemption.
     *
     * @param taxExemption
     *            the new tax exemption
     */
    public final void setTaxExemption(final String taxExemption) {
        this.taxExemption = taxExemption;
    }

    /**
     * Gets the item.
     *
     * @return the item
     */
    public final List<Item> getItem() {
        return item;
    }

    /**
     * Sets the item.
     *
     * @param item
     *            the new item
     */
    public final void setItem(final List<Item> item) {
        this.item = item;
    }

    /**
     * Gets the city name.
     *
     * @return the city name
     */
    public final String getCityName() {
        return cityName;
    }

    /**
     * Sets the city name.
     *
     * @param cityName
     *            the new city name
     */
    public final void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    /**
     * Gets the request created timestamp.
     *
     * @return the request created timestamp
     */
    public final String getRequestCreatedTimestamp() {
        return requestCreatedTimestamp;
    }

    /**
     * Sets the request created timestamp.
     *
     * @param requestCreatedTimestamp
     *            the new request created timestamp
     */
    public final void setRequestCreatedTimestamp(
            final String requestCreatedTimestamp) {
        this.requestCreatedTimestamp = requestCreatedTimestamp;
    }

    /**
     * Gets the request type.
     *
     * @return the request type
     */
    public final String getRequestType() {
        return requestType;
    }

    /**
     * Sets the request type.
     *
     * @param requestType
     *            the new request type
     */
    public final void setRequestType(final String requestType) {
        this.requestType = requestType;
    }

    /**
     * Gets the zip postal code.
     *
     * @return the zip postal code
     */
    public final String getZipPostalCode() {
        return zipPostalCode;
    }

    /**
     * Sets the zip postal code.
     *
     * @param zipPostalCode
     *            the new zip postal code
     */
    public final void setZipPostalCode(final String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }

    /**
     * Gets the vat id.
     *
     * @return the vat id
     */
    public final String getVatId() {
        return vatId;
    }

    /**
     * Sets the vat id.
     *
     * @param vatId
     *            the new vat id
     */
    public final void setVatId(final String vatId) {
        this.vatId = vatId;
    }

    /**
     * Gets the country.
     *
     * @return the country
     */
    public final String getCountry() {
        return country;
    }

    /**
     * Sets the country.
     *
     * @param country
     *            the new country
     */
    public final void setCountry(final String country) {
        this.country = country;
    }

}
