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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ALMUserAddress.
 */
@JsonInclude(Include.NON_NULL)
public class ALMUserAddress {

    /** The address. */
    @JsonProperty("Address")
    private String address;

    /** The street. */
    @JsonProperty("Street")
    private String street;

    /** The state. */
    @JsonProperty("State")
    private String state;

    /** The country. */
    @JsonProperty("Country")
    private String country;

    /** The zip code. */
    @JsonProperty("ZipCode")
    private String zipCode;

    /**
     * Gets the address.
     *
     * @return the address
     */
    public final String getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address
     *            the new address
     */
    public final void setAddress(final String address) {
        this.address = address;
    }

    /**
     * Gets the street.
     *
     * @return the street
     */
    public final String getStreet() {
        return street;
    }

    /**
     * Sets the street.
     *
     * @param street
     *            the new street
     */
    public final void setStreet(final String street) {
        this.street = street;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public final String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state
     *            the new state
     */
    public final void setState(final String state) {
        this.state = state;
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

    /**
     * Gets the zip code.
     *
     * @return the zip code
     */
    public final String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the zip code.
     *
     * @param zipCode
     *            the new zip code
     */
    public final void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }
}
