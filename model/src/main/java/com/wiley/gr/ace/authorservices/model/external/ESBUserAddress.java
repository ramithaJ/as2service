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

/**
 * The Class ESBUserAddress.
 */
public class ESBUserAddress {

    /** The state. */
    private String state;

    /** The country cd. */
    private String countryCd;

    /** The type. */
    private String type;

    /** The address type cd. */
    private String addressTypeCd;

    /** The city. */
    private String city;

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
     * Gets the country cd.
     *
     * @return the country cd
     */
    public final String getCountryCd() {
        return countryCd;
    }

    /**
     * Sets the country cd.
     *
     * @param countryCd
     *            the new country cd
     */
    public final void setCountryCd(final String countryCd) {
        this.countryCd = countryCd;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public final String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type
     *            the new type
     */
    public final void setType(final String type) {
        this.type = type;
    }

    /**
     * Gets the address type cd.
     *
     * @return the address type cd
     */
    public final String getAddressTypeCd() {
        return addressTypeCd;
    }

    /**
     * Sets the address type cd.
     *
     * @param addressTypeCd
     *            the new address type cd
     */
    public final void setAddressTypeCd(final String addressTypeCd) {
        this.addressTypeCd = addressTypeCd;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public final String getCity() {
        return city;
    }

    /**
     * Sets the city.
     *
     * @param city
     *            the new city
     */
    public final void setCity(final String city) {
        this.city = city;
    }
}
