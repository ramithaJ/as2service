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
 * The Class ParticipantAddress.
 * 
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ParticipantAddress {

    /** The address id. */
    private String addressId;

    /** The address type. */
    private String addressType;

    /** The address functiom. */
    private String addressFunctiom;

    /** The street address. */
    private List<String> streetAddress;

    /** The address locality. */
    private String addressLocality;

    /** The address region. */
    private String addressRegion;

    /** The address country. */
    private String addressCountry;

    /** The postal code. */
    private String postalCode;

    /** The telephone. */
    private String telephone;

    /** The email. */
    private String email;

    /** The fax number. */
    private String faxNumber;

    /** The website. */
    private String website;

    /** The department id. */
    private String departmentID;

    /** The organization id. */
    private String organizationId;

    /** The department. */
    private String department;

    /** The organization. */
    private String organization;

    /** The language. */
    private String language;

    /** The valid from. */
    private String validFrom;

    /** The valid to. */
    private String validTo;

    /**
     * Gets the address id.
     *
     * @return the address id
     */
    public final String getAddressId() {
        return addressId;
    }

    /**
     * Sets the address id.
     *
     * @param addressId
     *            the new address id
     */
    public final void setAddressId(final String addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets the language.
     *
     * @return the language
     */
    public final String getLanguage() {
        return language;
    }

    /**
     * Sets the language.
     *
     * @param language
     *            the new language
     */
    public final void setLanguage(final String language) {
        this.language = language;
    }

    /**
     * Gets the valid from.
     *
     * @return the valid from
     */
    public final String getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the valid from.
     *
     * @param validFrom
     *            the new valid from
     */
    public final void setValidFrom(final String validFrom) {
        this.validFrom = validFrom;
    }

    /**
     * Gets the valid to.
     *
     * @return the valid to
     */
    public final String getValidTo() {
        return validTo;
    }

    /**
     * Sets the valid to.
     *
     * @param validTo
     *            the new valid to
     */
    public final void setValidTo(final String validTo) {
        this.validTo = validTo;
    }

    /**
     * Gets the address type.
     *
     * @return the address type
     */
    public final String getAddressType() {
        return addressType;
    }

    /**
     * Sets the address type.
     *
     * @param addressType
     *            the new address type
     */
    public final void setAddressType(final String addressType) {
        this.addressType = addressType;
    }

    /**
     * Gets the address functiom.
     *
     * @return the address functiom
     */
    public final String getAddressFunctiom() {
        return addressFunctiom;
    }

    /**
     * Sets the address functiom.
     *
     * @param addressFunctiom
     *            the new address functiom
     */
    public final void setAddressFunctiom(final String addressFunctiom) {
        this.addressFunctiom = addressFunctiom;
    }

    /**
     * Gets the street address.
     *
     * @return the street address
     */
    public final List<String> getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets the street address.
     *
     * @param streetAddress
     *            the new street address
     */
    public final void setStreetAddress(final List<String> streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Gets the address locality.
     *
     * @return the address locality
     */
    public final String getAddressLocality() {
        return addressLocality;
    }

    /**
     * Sets the address locality.
     *
     * @param addressLocality
     *            the new address locality
     */
    public final void setAddressLocality(final String addressLocality) {
        this.addressLocality = addressLocality;
    }

    /**
     * Gets the address region.
     *
     * @return the address region
     */
    public final String getAddressRegion() {
        return addressRegion;
    }

    /**
     * Sets the address region.
     *
     * @param addressRegion
     *            the new address region
     */
    public final void setAddressRegion(final String addressRegion) {
        this.addressRegion = addressRegion;
    }

    /**
     * Gets the address country.
     *
     * @return the address country
     */
    public final String getAddressCountry() {
        return addressCountry;
    }

    /**
     * Sets the address country.
     *
     * @param addressCountry
     *            the new address country
     */
    public final void setAddressCountry(final String addressCountry) {
        this.addressCountry = addressCountry;
    }

    /**
     * Gets the postal code.
     *
     * @return the postal code
     */
    public final String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the postal code.
     *
     * @param postalCode
     *            the new postal code
     */
    public final void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Gets the telephone.
     *
     * @return the telephone
     */
    public final String getTelephone() {
        return telephone;
    }

    /**
     * Sets the telephone.
     *
     * @param telephone
     *            the new telephone
     */
    public final void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public final String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email
     *            the new email
     */
    public final void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets the fax number.
     *
     * @return the fax number
     */
    public final String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets the fax number.
     *
     * @param faxNumber
     *            the new fax number
     */
    public final void setFaxNumber(final String faxNumber) {
        this.faxNumber = faxNumber;
    }

    /**
     * Gets the website.
     *
     * @return the website
     */
    public final String getWebsite() {
        return website;
    }

    /**
     * Sets the website.
     *
     * @param website
     *            the new website
     */
    public final void setWebsite(final String website) {
        this.website = website;
    }

    /**
     * Gets the department id.
     *
     * @return the department id
     */
    public final String getDepartmentID() {
        return departmentID;
    }

    /**
     * Sets the department id.
     *
     * @param departmentID
     *            the new department id
     */
    public final void setDepartmentID(final String departmentID) {
        this.departmentID = departmentID;
    }

    /**
     * Gets the organization id.
     *
     * @return the organization id
     */
    public final String getOrganizationId() {
        return organizationId;
    }

    /**
     * Sets the organization id.
     *
     * @param organizationId
     *            the new organization id
     */
    public final void setOrganizationId(final String organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * Gets the department.
     *
     * @return the department
     */
    public final String getDepartment() {
        return department;
    }

    /**
     * Sets the department.
     *
     * @param department
     *            the new department
     */
    public final void setDepartment(final String department) {
        this.department = department;
    }

    /**
     * Gets the organization.
     *
     * @return the organization
     */
    public final String getOrganization() {
        return organization;
    }

    /**
     * Sets the organization.
     *
     * @param organization
     *            the new organization
     */
    public final void setOrganization(final String organization) {
        this.organization = organization;
    }
}
