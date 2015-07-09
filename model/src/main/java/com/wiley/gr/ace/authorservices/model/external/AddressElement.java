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

    /** The institutionlist. */
    private InstitutionList institutionlist;

    /** The departmentlist. */
    private DepartmentList departmentlist;

    /** The addressenddate. */
    private String addressenddate;

    /** The zipcode. */
    private String zipcode;

    /** The province. */
    private String province;

    /** The city. */
    private String city;

    /** The postbox. */
    private String postbox;

    /** The addresscleaningflag. */
    private String addresscleaningflag;

    /** The addr_type_ecid. */
    @JsonProperty("addr_type_ecid")
    private String addrTypeEcid;

    /** The addresstype. */
    private String addresstype;

    /** The addressline1. */
    private String addressline1;

    /** The addressline3. */
    private String addressline3;

    /** The addressline2. */
    private String addressline2;

    /** The countrynamene. */
    private String countrynamene;

    /** The addresscleansecode. */
    private String addresscleansecode;

    /** The county. */
    private String county;

    /** The state. */
    private String state;

    /** The addressline3ne. */
    private String addressline3ne;

    /** The addressdeliveryconfidencecode. */
    private String addressdeliveryconfidencecode;

    /** The addressline1ne. */
    private String addressline1ne;

    /** The cityne. */
    private String cityne;

    /** The addressline2ne. */
    private String addressline2ne;

    /** The addressstartdate. */
    private String addressstartdate;

    /** The countryName. */
    @JsonProperty("countryname")
    private String countryName;

    /** The addrTypecd. */
    @JsonProperty("addr_type_cd")
    private String addrTypecd;

    /**
     * Gets the addrTypecd.
     *
     * @return the addrTypecd
     */
    public final String getAddrTypecd() {
        return addrTypecd;
    }

    /**
     * Sets the addrTypecd.
     *
     * @param addrTypecd
     *            the new addrTypecd
     */
    public final void setAddrTypecd(final String addrTypecd) {
        this.addrTypecd = addrTypecd;
    }

    /**
     * Gets the addrTypeEcid.
     *
     * @return the addrTypeEcid
     */
    public final String getAddrTypeEcid() {
        return addrTypeEcid;
    }

    /**
     * Sets the addrTypeEcid.
     *
     * @param addrTypeEcid
     *            the new addrTypeEcid
     */
    public final void setAddrTypeEcid(final String addrTypeEcid) {
        this.addrTypeEcid = addrTypeEcid;
    }

    /** The zipcodene. */
    private String zipcodene;

    /** The statene. */
    private String statene;

    /** The countrycode. */
    private String countrycode;

    /** The countyne. */
    private String countyne;

    /**
     * Gets the institutionlist.
     *
     * @return the institutionlist
     */
    public final InstitutionList getInstitutionlist() {
        return institutionlist;
    }

    /**
     * Sets the institutionlist.
     *
     * @param institutionlist
     *            the institutionlist to set
     */
    public final void setInstitutionlist(final InstitutionList institutionlist) {
        this.institutionlist = institutionlist;
    }

    /**
     * Gets the departmentlist.
     *
     * @return the departmentlist
     */
    public final DepartmentList getDepartmentlist() {
        return departmentlist;
    }

    /**
     * Sets the departmentlist.
     *
     * @param departmentlist
     *            the departmentlist to set
     */
    public final void setDepartmentlist(final DepartmentList departmentlist) {
        this.departmentlist = departmentlist;
    }

    /**
     * Gets the addressenddate.
     *
     * @return the addressenddate
     */
    public final String getAddressenddate() {
        return addressenddate;
    }

    /**
     * Sets the addressenddate.
     *
     * @param addressenddate
     *            the addressenddate to set
     */
    public final void setAddressenddate(final String addressenddate) {
        this.addressenddate = addressenddate;
    }

    /**
     * Gets the zipcode.
     *
     * @return the zipcode
     */
    public final String getZipcode() {
        return zipcode;
    }

    /**
     * Sets the zipcode.
     *
     * @param zipcode
     *            the zipcode to set
     */
    public final void setZipcode(final String zipcode) {
        this.zipcode = zipcode;
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
     *            the province to set
     */
    public final void setProvince(final String province) {
        this.province = province;
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
     *            the city to set
     */
    public final void setCity(final String city) {
        this.city = city;
    }

    /**
     * Gets the postbox.
     *
     * @return the postbox
     */
    public final String getPostbox() {
        return postbox;
    }

    /**
     * Sets the postbox.
     *
     * @param postbox
     *            the postbox to set
     */
    public final void setPostbox(final String postbox) {
        this.postbox = postbox;
    }

    /**
     * Gets the addresscleaningflag.
     *
     * @return the addresscleaningflag
     */
    public final String getAddresscleaningflag() {
        return addresscleaningflag;
    }

    /**
     * Sets the addresscleaningflag.
     *
     * @param addresscleaningflag
     *            the addresscleaningflag to set
     */
    public final void setAddresscleaningflag(final String addresscleaningflag) {
        this.addresscleaningflag = addresscleaningflag;
    }

    /**
     * Gets the addresstype.
     *
     * @return the addresstype
     */
    public final String getAddresstype() {
        return addresstype;
    }

    /**
     * Sets the addresstype.
     *
     * @param addresstype
     *            the addresstype to set
     */
    public final void setAddresstype(final String addresstype) {
        this.addresstype = addresstype;
    }

    /**
     * Gets the addressline1.
     *
     * @return the addressline1
     */
    public final String getAddressline1() {
        return addressline1;
    }

    /**
     * Sets the addressline1.
     *
     * @param addressline1
     *            the addressline1 to set
     */
    public final void setAddressline1(final String addressline1) {
        this.addressline1 = addressline1;
    }

    /**
     * Gets the addressline3.
     *
     * @return the addressline3
     */
    public final String getAddressline3() {
        return addressline3;
    }

    /**
     * Sets the addressline3.
     *
     * @param addressline3
     *            the addressline3 to set
     */
    public final void setAddressline3(final String addressline3) {
        this.addressline3 = addressline3;
    }

    /**
     * Gets the addressline2.
     *
     * @return the addressline2
     */
    public final String getAddressline2() {
        return addressline2;
    }

    /**
     * Sets the addressline2.
     *
     * @param addressline2
     *            the addressline2 to set
     */
    public final void setAddressline2(final String addressline2) {
        this.addressline2 = addressline2;
    }

    /**
     * Gets the countrynamene.
     *
     * @return the countrynamene
     */
    public final String getCountrynamene() {
        return countrynamene;
    }

    /**
     * Sets the countrynamene.
     *
     * @param countrynamene
     *            the countrynamene to set
     */
    public final void setCountrynamene(final String countrynamene) {
        this.countrynamene = countrynamene;
    }

    /**
     * Gets the addresscleansecode.
     *
     * @return the addresscleansecode
     */
    public final String getAddresscleansecode() {
        return addresscleansecode;
    }

    /**
     * Sets the addresscleansecode.
     *
     * @param addresscleansecode
     *            the addresscleansecode to set
     */
    public final void setAddresscleansecode(final String addresscleansecode) {
        this.addresscleansecode = addresscleansecode;
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
     *            the county to set
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
     *            the state to set
     */
    public final void setState(final String state) {
        this.state = state;
    }

    /**
     * Gets the addressline3ne.
     *
     * @return the addressline3ne
     */
    public final String getAddressline3ne() {
        return addressline3ne;
    }

    /**
     * Sets the addressline3ne.
     *
     * @param addressline3ne
     *            the addressline3ne to set
     */
    public final void setAddressline3ne(final String addressline3ne) {
        this.addressline3ne = addressline3ne;
    }

    /**
     * Gets the addressdeliveryconfidencecode.
     *
     * @return the addressdeliveryconfidencecode
     */
    public final String getAddressdeliveryconfidencecode() {
        return addressdeliveryconfidencecode;
    }

    /**
     * Sets the addressdeliveryconfidencecode.
     *
     * @param addressdeliveryconfidencecode
     *            the addressdeliveryconfidencecode to set
     */
    public final void setAddressdeliveryconfidencecode(
            final String addressdeliveryconfidencecode) {
        this.addressdeliveryconfidencecode = addressdeliveryconfidencecode;
    }

    /**
     * Gets the addressline1ne.
     *
     * @return the addressline1ne
     */
    public final String getAddressline1ne() {
        return addressline1ne;
    }

    /**
     * Sets the addressline1ne.
     *
     * @param addressline1ne
     *            the addressline1ne to set
     */
    public final void setAddressline1ne(final String addressline1ne) {
        this.addressline1ne = addressline1ne;
    }

    /**
     * Gets the cityne.
     *
     * @return the cityne
     */
    public final String getCityne() {
        return cityne;
    }

    /**
     * Sets the cityne.
     *
     * @param cityne
     *            the cityne to set
     */
    public final void setCityne(final String cityne) {
        this.cityne = cityne;
    }

    /**
     * Gets the addressline2ne.
     *
     * @return the addressline2ne
     */
    public final String getAddressline2ne() {
        return addressline2ne;
    }

    /**
     * Sets the addressline2ne.
     *
     * @param addressline2ne
     *            the addressline2ne to set
     */
    public final void setAddressline2ne(final String addressline2ne) {
        this.addressline2ne = addressline2ne;
    }

    /**
     * Gets the addressstartdate.
     *
     * @return the addressstartdate
     */
    public final String getAddressstartdate() {
        return addressstartdate;
    }

    /**
     * Sets the addressstartdate.
     *
     * @param addressstartdate
     *            the addressstartdate to set
     */
    public final void setAddressstartdate(final String addressstartdate) {
        this.addressstartdate = addressstartdate;
    }

    /**
     * Gets the countryName.
     *
     * @return the countryName
     */
    public final String getCountryName() {
        return countryName;
    }

    /**
     * Sets the countryName.
     *
     * @param countryName
     *            the countryName to set
     */
    public final void setCountryName(final String countryName) {
        this.countryName = countryName;
    }

    /**
     * Gets the zipcodene.
     *
     * @return the zipcodene
     */
    public final String getZipcodene() {
        return zipcodene;
    }

    /**
     * Sets the zipcodene.
     *
     * @param zipcodene
     *            the zipcodene to set
     */
    public final void setZipcodene(final String zipcodene) {
        this.zipcodene = zipcodene;
    }

    /**
     * Gets the statene.
     *
     * @return the statene
     */
    public final String getStatene() {
        return statene;
    }

    /**
     * Sets the statene.
     *
     * @param statene
     *            the statene to set
     */
    public final void setStatene(final String statene) {
        this.statene = statene;
    }

    /**
     * Gets the countrycode.
     *
     * @return the countrycode
     */
    public final String getCountrycode() {
        return countrycode;
    }

    /**
     * Sets the countrycode.
     *
     * @param countrycode
     *            the countrycode to set
     */
    public final void setCountrycode(final String countrycode) {
        this.countrycode = countrycode;
    }

    /**
     * Gets the countyne.
     *
     * @return the countyne
     */
    public final String getCountyne() {
        return countyne;
    }

    /**
     * Sets the countyne.
     *
     * @param countyne
     *            the countyne to set
     */
    public final void setCountyne(final String countyne) {
        this.countyne = countyne;
    }

}
