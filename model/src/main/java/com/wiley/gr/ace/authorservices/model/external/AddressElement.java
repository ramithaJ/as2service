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
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class AddressElement.
 * 
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class AddressElement {

    /** The id. */
    @JsonProperty("Id")
    private String id;

    /** The addr type cd. */
    @JsonProperty("Addr_Type_CD")
    private String addrTypeCD;

    /** The address line1. */
    @JsonProperty("AddressLine1")
    private String addressLine1;

    /** The address line2. */
    @JsonProperty("AddressLine2")
    private String addressLine2;

    /** The city. */
    @JsonProperty("City")
    private String city;

    /** The country code. */
    @JsonProperty("CountryCode")
    private String countryCode;

    /** The state. */
    @JsonProperty("State")
    private String state;

    /** The zip code. */
    @JsonProperty("ZipCode")
    private String zipCode;

    /** The institution cd. */
    @JsonProperty("InstitutionCd")
    private String institutionCd;

    /** The institution name. */
    @JsonProperty("InstitutionName")
    private String institutionName;

    /** The department cd. */
    @JsonProperty("DepartmentCd")
    private String departmentCd;

    /** The department name. */
    @JsonProperty("DepartmentName")
    private String departmentName;

    /** The status. */
    @JsonProperty("Status")
    private String status;

    /** The title. */
    @JsonProperty("Title")
    private String title;

    /** The first name. */
    @JsonProperty("FirstName")
    private String firstName;

    /** The last name. */
    @JsonProperty("LastName")
    private String lastName;

    /** The suffix. */
    @JsonProperty("Suffix")
    private String suffix;

    /** The phone number. */
    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    /** The fax number. */
    @JsonProperty("FaxNumber")
    private String faxNumber;

    /** The address start date. */
    @JsonProperty("AddressStartDate")
    private String addressStartDate;

    /** The address line2 ne. */
    @JsonProperty("AddressLine2NE")
    private String addressLine2NE;

    /** The country name. */
    @JsonProperty("CountryName")
    private String countryName;

    /** The zip code ne. */
    @JsonProperty("ZipCodeNE")
    private String zipCodeNE;

    /** The address delivery confidence code. */
    @JsonProperty("AddressDeliveryConfidenceCode")
    private String addressDeliveryConfidenceCode;

    /** The address line1 ne. */
    @JsonProperty("AddressLine1NE")
    private String addressLine1NE;

    /** The city ne. */
    @JsonProperty("CityNE")
    private String cityNE;

    /** The county ne. */
    @JsonProperty("CountyNE")
    private String countyNE;

    /** The state ne. */
    @JsonProperty("StateNE")
    private String stateNE;

    /** The address cleaning flag. */
    @JsonProperty("AddressCleaningFlag")
    private String addressCleaningFlag;

    /** The addr type ecid. */
    @JsonProperty("Addr_Type_ECID")
    private String addrTypeECID;

    /** The address end date. */
    @JsonProperty("AddressEndDate")
    private String addressEndDate;

    /** The province. */
    @JsonProperty("Province")
    private String province;

    /** The post box. */
    @JsonProperty("PostBox")
    private String postBox;

    /** The country name ne. */
    @JsonProperty("CountryNameNE")
    private String countryNameNE;

    /** The address cleanse code. */
    @JsonProperty("AddressCleanseCode")
    private String addressCleanseCode;

    /** The county. */
    @JsonProperty("County")
    private String county;

    /** The address line3 ne. */
    @JsonProperty("AddressLine3NE")
    private String addressLine3NE;

    /** The address type. */
    @JsonProperty("AddressType")
    private String addressType;

    /** The address line3. */
    @JsonProperty("AddressLine3")
    private String addressLine3;

    /**
     * Gets the address start date.
     *
     * @return the address start date
     */
    public final String getAddressStartDate() {
        return addressStartDate;
    }

    /**
     * Sets the address start date.
     *
     * @param addressStartDate
     *            the new address start date
     */
    public final void setAddressStartDate(final String addressStartDate) {
        this.addressStartDate = addressStartDate;
    }

    /**
     * Gets the address line2 ne.
     *
     * @return the address line2 ne
     */
    public final String getAddressLine2NE() {
        return addressLine2NE;
    }

    /**
     * Sets the address line2 ne.
     *
     * @param addressLine2NE
     *            the new address line2 ne
     */
    public final void setAddressLine2NE(final String addressLine2NE) {
        this.addressLine2NE = addressLine2NE;
    }

    /**
     * Gets the country name.
     *
     * @return the country name
     */
    public final String getCountryName() {
        return countryName;
    }

    /**
     * Sets the country name.
     *
     * @param countryName
     *            the new country name
     */
    public final void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    /**
     * Gets the zip code ne.
     *
     * @return the zip code ne
     */
    public final String getZipCodeNE() {
        return zipCodeNE;
    }

    /**
     * Sets the zip code ne.
     *
     * @param zipCodeNE
     *            the new zip code ne
     */
    public final void setZipCodeNE(final String zipCodeNE) {
        this.zipCodeNE = zipCodeNE;
    }

    /**
     * Gets the addr type cd.
     *
     * @return the addr type cd
     */
    public final String getAddrTypeCD() {
        return addrTypeCD;
    }

    /**
     * Sets the addr type cd.
     *
     * @param addrTypeCD
     *            the new addr type cd
     */
    public final void setAddrTypeCD(final String addrTypeCD) {
        this.addrTypeCD = addrTypeCD;
    }

    /**
     * Gets the address delivery confidence code.
     *
     * @return the address delivery confidence code
     */
    public final String getAddressDeliveryConfidenceCode() {
        return addressDeliveryConfidenceCode;
    }

    /**
     * Sets the address delivery confidence code.
     *
     * @param addressDeliveryConfidenceCode
     *            the new address delivery confidence code
     */
    public final void setAddressDeliveryConfidenceCode(
            final String addressDeliveryConfidenceCode) {
        this.addressDeliveryConfidenceCode = addressDeliveryConfidenceCode;
    }

    /**
     * Gets the address line1 ne.
     *
     * @return the address line1 ne
     */
    public final String getAddressLine1NE() {
        return addressLine1NE;
    }

    /**
     * Sets the address line1 ne.
     *
     * @param addressLine1NE
     *            the new address line1 ne
     */
    public final void setAddressLine1NE(final String addressLine1NE) {
        this.addressLine1NE = addressLine1NE;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the new last name
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the city ne.
     *
     * @return the city ne
     */
    public final String getCityNE() {
        return cityNE;
    }

    /**
     * Sets the city ne.
     *
     * @param cityNE
     *            the new city ne
     */
    public final void setCityNE(final String cityNE) {
        this.cityNE = cityNE;
    }

    /**
     * Gets the county ne.
     *
     * @return the county ne
     */
    public final String getCountyNE() {
        return countyNE;
    }

    /**
     * Sets the county ne.
     *
     * @param countyNE
     *            the new county ne
     */
    public final void setCountyNE(final String countyNE) {
        this.countyNE = countyNE;
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
     * Gets the first name.
     *
     * @return the first name
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the new first name
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the state ne.
     *
     * @return the state ne
     */
    public final String getStateNE() {
        return stateNE;
    }

    /**
     * Sets the state ne.
     *
     * @param stateNE
     *            the new state ne
     */
    public final void setStateNE(final String stateNE) {
        this.stateNE = stateNE;
    }

    /**
     * Gets the country code.
     *
     * @return the country code
     */
    public final String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code.
     *
     * @param countryCode
     *            the new country code
     */
    public final void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets the department name.
     *
     * @return the department name
     */
    public final String getDepartmentName() {
        return departmentName;
    }

    /**
     * Sets the department name.
     *
     * @param departmentName
     *            the new department name
     */
    public final void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Gets the address cleaning flag.
     *
     * @return the address cleaning flag
     */
    public final String getAddressCleaningFlag() {
        return addressCleaningFlag;
    }

    /**
     * Sets the address cleaning flag.
     *
     * @param addressCleaningFlag
     *            the new address cleaning flag
     */
    public final void setAddressCleaningFlag(final String addressCleaningFlag) {
        this.addressCleaningFlag = addressCleaningFlag;
    }

    /**
     * Gets the institution cd.
     *
     * @return the institution cd
     */
    public final String getInstitutionCd() {
        return institutionCd;
    }

    /**
     * Sets the institution cd.
     *
     * @param institutionCd
     *            the new institution cd
     */
    public final void setInstitutionCd(final String institutionCd) {
        this.institutionCd = institutionCd;
    }

    /**
     * Gets the addr type ecid.
     *
     * @return the addr type ecid
     */
    public final String getAddrTypeECID() {
        return addrTypeECID;
    }

    /**
     * Sets the addr type ecid.
     *
     * @param addrTypeECID
     *            the new addr type ecid
     */
    public final void setAddrTypeECID(final String addrTypeECID) {
        this.addrTypeECID = addrTypeECID;
    }

    /**
     * Gets the suffix.
     *
     * @return the suffix
     */
    public final String getSuffix() {
        return suffix;
    }

    /**
     * Sets the suffix.
     *
     * @param suffix
     *            the new suffix
     */
    public final void setSuffix(final String suffix) {
        this.suffix = suffix;
    }

    /**
     * Gets the address end date.
     *
     * @return the address end date
     */
    public final String getAddressEndDate() {
        return addressEndDate;
    }

    /**
     * Sets the address end date.
     *
     * @param addressEndDate
     *            the new address end date
     */
    public final void setAddressEndDate(final String addressEndDate) {
        this.addressEndDate = addressEndDate;
    }

    /**
     * Gets the phone number.
     *
     * @return the phone number
     */
    public final String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number.
     *
     * @param phoneNumber
     *            the new phone number
     */
    public final void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the province.
     *
     * @return the province
     */
    public final String getProvince() {
        return province;
    }

    /**
     * Sets the province.
     *
     * @param province
     *            the new province
     */
    public final void setProvince(final String province) {
        this.province = province;
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

    /**
     * Gets the post box.
     *
     * @return the post box
     */
    public final String getPostBox() {
        return postBox;
    }

    /**
     * Sets the post box.
     *
     * @param postBox
     *            the new post box
     */
    public final void setPostBox(final String postBox) {
        this.postBox = postBox;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public final String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the new title
     */
    public final void setTitle(final String title) {
        this.title = title;
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

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the new status
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Gets the country name ne.
     *
     * @return the country name ne
     */
    public final String getCountryNameNE() {
        return countryNameNE;
    }

    /**
     * Sets the country name ne.
     *
     * @param countryNameNE
     *            the new country name ne
     */
    public final void setCountryNameNE(final String countryNameNE) {
        this.countryNameNE = countryNameNE;
    }

    /**
     * Gets the institution name.
     *
     * @return the institution name
     */
    public final String getInstitutionName() {
        return institutionName;
    }

    /**
     * Sets the institution name.
     *
     * @param institutionName
     *            the new institution name
     */
    public final void setInstitutionName(final String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * Gets the address cleanse code.
     *
     * @return the address cleanse code
     */
    public final String getAddressCleanseCode() {
        return addressCleanseCode;
    }

    /**
     * Sets the address cleanse code.
     *
     * @param addressCleanseCode
     *            the new address cleanse code
     */
    public final void setAddressCleanseCode(final String addressCleanseCode) {
        this.addressCleanseCode = addressCleanseCode;
    }

    /**
     * Gets the county.
     *
     * @return the county
     */
    public final String getCounty() {
        return county;
    }

    /**
     * Sets the county.
     *
     * @param county
     *            the new county
     */
    public final void setCounty(final String county) {
        this.county = county;
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
     * Gets the address line3 ne.
     *
     * @return the address line3 ne
     */
    public final String getAddressLine3NE() {
        return addressLine3NE;
    }

    /**
     * Sets the address line3 ne.
     *
     * @param addressLine3NE
     *            the new address line3 ne
     */
    public final void setAddressLine3NE(final String addressLine3NE) {
        this.addressLine3NE = addressLine3NE;
    }

    /**
     * Gets the department cd.
     *
     * @return the department cd
     */
    public final String getDepartmentCd() {
        return departmentCd;
    }

    /**
     * Sets the department cd.
     *
     * @param departmentCd
     *            the new department cd
     */
    public final void setDepartmentCd(final String departmentCd) {
        this.departmentCd = departmentCd;
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
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the address line1.
     *
     * @return the address line1
     */
    public final String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the address line1.
     *
     * @param addressLine1
     *            the new address line1
     */
    public final void setAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * Gets the address line2.
     *
     * @return the address line2
     */
    public final String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the address line2.
     *
     * @param addressLine2
     *            the new address line2
     */
    public final void setAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * Gets the address line3.
     *
     * @return the address line3
     */
    public final String getAddressLine3() {
        return addressLine3;
    }

    /**
     * Sets the address line3.
     *
     * @param addressLine3
     *            the new address line3
     */
    public final void setAddressLine3(final String addressLine3) {
        this.addressLine3 = addressLine3;
    }

}
