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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class AddressElement.
 * 
 * @author virtusa version 1.0
 */
public class AddressElement {

    @JsonProperty("AddressStartDate")
    private String addressStartDate;

    @JsonProperty("AddressLine2NE")
    private String addressLine2NE;

    @JsonProperty("CountryName")
    private String countryName;

    @JsonProperty("ZipCodeNE")
    private String zipCodeNE;

    @JsonProperty("Addr_Type_CD")
    private String addrTypeCD;

    @JsonProperty("AddressDeliveryConfidenceCode")
    private String addressDeliveryConfidenceCode;

    @JsonProperty("AddressLine1NE")
    private String addressLine1NE;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("CityNE")
    private String cityNE;

    @JsonProperty("CountyNE")
    private String countyNE;

    @JsonProperty("FaxNumber")
    private String faxNumber;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("StateNE")
    private String stateNE;

    @JsonProperty("CountryCode")
    private String countryCode;

    @JsonProperty("DepartmentName")
    private String departmentName;

    @JsonProperty("AddressCleaningFlag")
    private String addressCleaningFlag;

    @JsonProperty("InstitutionCd")
    private String institutionCd;

    @JsonProperty("Addr_Type_ECID")
    private String addrTypeECID;

    @JsonProperty("Suffix")
    private String suffix;

    @JsonProperty("AddressEndDate")
    private String addressEndDate;

    @JsonProperty("PhoneNumber")
    private String phoneNumber;

    @JsonProperty("Province")
    private String province;

    @JsonProperty("ZipCode")
    private String zipCode;

    @JsonProperty("PostBox")
    private String postBox;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("City")
    private String city;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("CountryNameNE")
    private String countryNameNE;

    @JsonProperty("InstitutionName")
    private String institutionName;

    @JsonProperty("AddressCleanseCode")
    private String addressCleanseCode;

    @JsonProperty("County")
    private String county;

    @JsonProperty("State")
    private String state;

    @JsonProperty("AddressLine3NE")
    private String addressLine3NE;

    @JsonProperty("DepartmentCd")
    private String departmentCd;

    @JsonProperty("AddressType")
    private String addressType;

    @JsonProperty("Id")
    private String id;

    @JsonProperty("AddressLine1")
    private String addressLine1;

    @JsonProperty("AddressLine2")
    private String addressLine2;

    @JsonProperty("AddressLine3")
    private String addressLine3;

    public final String getAddressStartDate() {
        return addressStartDate;
    }

    public final void setAddressStartDate(final String addressStartDate) {
        this.addressStartDate = addressStartDate;
    }

    public final String getAddressLine2NE() {
        return addressLine2NE;
    }

    public final void setAddressLine2NE(final String addressLine2NE) {
        this.addressLine2NE = addressLine2NE;
    }

    public final String getCountryName() {
        return countryName;
    }

    public final void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    public final String getZipCodeNE() {
        return zipCodeNE;
    }

    public final void setZipCodeNE(final String zipCodeNE) {
        this.zipCodeNE = zipCodeNE;
    }

    public final String getAddrTypeCD() {
        return addrTypeCD;
    }

    public final void setAddrTypeCD(final String addrTypeCD) {
        this.addrTypeCD = addrTypeCD;
    }

    public final String getAddressDeliveryConfidenceCode() {
        return addressDeliveryConfidenceCode;
    }

    public final void setAddressDeliveryConfidenceCode(
            final String addressDeliveryConfidenceCode) {
        this.addressDeliveryConfidenceCode = addressDeliveryConfidenceCode;
    }

    public final String getAddressLine1NE() {
        return addressLine1NE;
    }

    public final void setAddressLine1NE(final String addressLine1NE) {
        this.addressLine1NE = addressLine1NE;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final String getCityNE() {
        return cityNE;
    }

    public final void setCityNE(final String cityNE) {
        this.cityNE = cityNE;
    }

    public final String getCountyNE() {
        return countyNE;
    }

    public final void setCountyNE(final String countyNE) {
        this.countyNE = countyNE;
    }

    public final String getFaxNumber() {
        return faxNumber;
    }

    public final void setFaxNumber(final String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final String getStateNE() {
        return stateNE;
    }

    public final void setStateNE(final String stateNE) {
        this.stateNE = stateNE;
    }

    public final String getCountryCode() {
        return countryCode;
    }

    public final void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    public final String getDepartmentName() {
        return departmentName;
    }

    public final void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    public final String getAddressCleaningFlag() {
        return addressCleaningFlag;
    }

    public final void setAddressCleaningFlag(final String addressCleaningFlag) {
        this.addressCleaningFlag = addressCleaningFlag;
    }

    public final String getInstitutionCd() {
        return institutionCd;
    }

    public final void setInstitutionCd(final String institutionCd) {
        this.institutionCd = institutionCd;
    }

    public final String getAddrTypeECID() {
        return addrTypeECID;
    }

    public final void setAddrTypeECID(final String addrTypeECID) {
        this.addrTypeECID = addrTypeECID;
    }

    public final String getSuffix() {
        return suffix;
    }

    public final void setSuffix(final String suffix) {
        this.suffix = suffix;
    }

    public final String getAddressEndDate() {
        return addressEndDate;
    }

    public final void setAddressEndDate(final String addressEndDate) {
        this.addressEndDate = addressEndDate;
    }

    public final String getPhoneNumber() {
        return phoneNumber;
    }

    public final void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public final String getProvince() {
        return province;
    }

    public final void setProvince(final String province) {
        this.province = province;
    }

    public final String getZipCode() {
        return zipCode;
    }

    public final void setZipCode(final String zipCode) {
        this.zipCode = zipCode;
    }

    public final String getPostBox() {
        return postBox;
    }

    public final void setPostBox(final String postBox) {
        this.postBox = postBox;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String getCity() {
        return city;
    }

    public final void setCity(final String city) {
        this.city = city;
    }

    public final String getStatus() {
        return status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

    public final String getCountryNameNE() {
        return countryNameNE;
    }

    public final void setCountryNameNE(final String countryNameNE) {
        this.countryNameNE = countryNameNE;
    }

    public final String getInstitutionName() {
        return institutionName;
    }

    public final void setInstitutionName(final String institutionName) {
        this.institutionName = institutionName;
    }

    public final String getAddressCleanseCode() {
        return addressCleanseCode;
    }

    public final void setAddressCleanseCode(final String addressCleanseCode) {
        this.addressCleanseCode = addressCleanseCode;
    }

    public final String getCounty() {
        return county;
    }

    public final void setCounty(final String county) {
        this.county = county;
    }

    public final String getState() {
        return state;
    }

    public final void setState(final String state) {
        this.state = state;
    }

    public final String getAddressLine3NE() {
        return addressLine3NE;
    }

    public final void setAddressLine3NE(final String addressLine3NE) {
        this.addressLine3NE = addressLine3NE;
    }

    public final String getDepartmentCd() {
        return departmentCd;
    }

    public final void setDepartmentCd(final String departmentCd) {
        this.departmentCd = departmentCd;
    }

    public final String getAddressType() {
        return addressType;
    }

    public final void setAddressType(final String addressType) {
        this.addressType = addressType;
    }

    public final String getId() {
        return id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getAddressLine1() {
        return addressLine1;
    }

    public final void setAddressLine1(final String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public final String getAddressLine2() {
        return addressLine2;
    }

    public final void setAddressLine2(final String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public final String getAddressLine3() {
        return addressLine3;
    }

    public final void setAddressLine3(final String addressLine3) {
        this.addressLine3 = addressLine3;
    }

}
