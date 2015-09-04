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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.State;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.AddressElement;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
import com.wiley.gr.ace.authorservices.services.service.ASDataService;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;

/**
 * The Class UserAccountServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class UserAccountServiceImpl implements UserAccountService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserAccountServiceImpl.class);

    /** getting bean of userProfile. */
    @Autowired
    private UserProfiles userProfile;

    /** The as data dao. */
    @Autowired(required = true)
    private ASDataDAO asDataDao;

    /**
     * This field holds the value of autoCompleteService.
     */
    @Autowired(required = true)
    private AutocompleteService autoCompleteService;

    /**
     * This field holds the value of asdataService.
     */
    @Autowired(required = true)
    private ASDataService asdataService;

    /**
     * this method is for getting email Details by userId.
     *
     * @param userId
     *            the user id
     * @return the email details
     */
    @Override
    public final User getEmailDetails(final String userId) {

        UserAccountServiceImpl.LOGGER.info("inside getEmailDetails Method");

        CustomerDetails customerDetails = userProfile
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getCustomerDetails();
        User user = new User();
        user.setPrimaryEmailAddr(customerDetails.getPrimaryEmail());
        user.setRecoveryEmailAddress(customerDetails.getSecondaryEmail());
        return user;

    }

    /**
     * getting profie info by user id.
     *
     * @param userId
     *            the user id
     * @return the profile information
     */
    @Override
    public final User getProfileInformation(final String userId) {

        UserAccountServiceImpl.LOGGER
                .info("inside getProfileInformation Method");
        CustomerDetails customerDetails = userProfile
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getCustomerDetails();
        User user = new User();
        final String titleId = customerDetails.getTitle();
        user.setTitle(titleId);
        user.setTitleName(asDataDao.getData(titleId));
        user.setFirstName(customerDetails.getfName());
        user.setLastName(customerDetails.getlName());
        user.setMiddleName(customerDetails.getmName());
        final String suffixId = customerDetails.getUserSuffix();
        user.setSuffix(suffixId);
        user.setSuffixName(asDataDao.getData(suffixId));
        user.setAlternateName(customerDetails.getAlternativeName());
        user.setPrimaryEmailAddr(customerDetails.getPrimaryEmail());
        user.setRecoveryEmailAddress(customerDetails.getSecondaryEmail());
        final String industryCode = customerDetails.getIndustryCode();
        user.setIndustry(industryCode);
        user.setIndustryName(autoCompleteService.getNameByCode("industries",
                industryCode, null));
        final String jobCategoriesCode = customerDetails.getJobCategoryCode();
        user.setJobCategory(jobCategoriesCode);
        user.setJobCategoryName(autoCompleteService.getNameByCode(
                "jobCategories", jobCategoriesCode, null));
        user.setOrcidId(customerDetails.getOrcId());
        user.setTermsOfUseFlg(customerDetails.getOptInFlag());

        return user;
    }

    /**
     * getting UserAddress info by user id.
     *
     * @param userId
     *            the user id
     * @return the user address
     */
    @Override
    public final List<Addresses> getUserAddress(final String userId) {

        UserAccountServiceImpl.LOGGER.info("inside getUserAddress Method");
        final LookupCustomerProfile lookupProfile = userProfile
                .getLookupCustomerProfile(userId);
        List<AddressElement> addressElementsList = lookupProfile
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAddressDetails().getAddress();
        List<Addresses> addressesList = new ArrayList<Addresses>();
        Addresses corresAddress = new Addresses();
        Addresses billAddress = new Addresses();
        Addresses shipAddress = new Addresses();
        for (AddressElement addressElement : addressElementsList) {

            if ("Physical".equalsIgnoreCase(addressElement.getAddrTypeCD())) {
                Address correspondenceAddress = this
                        .setAddressValues(addressElement);
                corresAddress.setCorrespondenceAddress(correspondenceAddress);
            }
            if ("Billing".equalsIgnoreCase(addressElement.getAddrTypeCD())) {
                Address billingAddress = this.setAddressValues(addressElement);
                billAddress.setBillingAddress(billingAddress);
            }
            if ("Shipping".equalsIgnoreCase(addressElement.getAddrTypeCD())) {
                Address shippingAddress = this.setAddressValues(addressElement);
                shipAddress.setShippingAddress(shippingAddress);
            }

        }
        addressesList.add(corresAddress);
        addressesList.add(billAddress);
        addressesList.add(shipAddress);

        return addressesList;
    }

    /**
     * Sets the address values.
     *
     * @param addressElement
     *            the address element
     * @return the address
     */
    private Address setAddressValues(final AddressElement addressElement) {

        Address address = null;
        address = new Address();
        address.setAddressId(addressElement.getId());
        if (!StringUtils.isEmpty(addressElement.getTitle())) {
            address.setTitle(addressElement.getTitle());
        }
        if (!StringUtils.isEmpty(addressElement.getSuffix())) {
            address.setSuffix(addressElement.getSuffix());
        }
        if (!StringUtils.isEmpty(addressElement.getFirstName())) {
            address.setFirstName(addressElement.getFirstName());
        }
        if (!StringUtils.isEmpty(addressElement.getLastName())) {
            address.setLastName(addressElement.getLastName());
        }
        final String institutionCode = addressElement.getInstitutionCd();
        if (!StringUtils.isEmpty(institutionCode)) {
            address.setInstitutionId(institutionCode);
            address.setInstitutionName(autoCompleteService.getNameByCode(
                    "institutions", institutionCode, null));
        }

        final String departmentCode = addressElement.getDepartmentCd();
        if (!StringUtils.isEmpty(departmentCode)) {
            address.setDepartmentId(departmentCode);
            address.setDepartmentName(autoCompleteService.getNameByCode(
                    "departments", departmentCode, institutionCode));
        }
        if (!StringUtils.isEmpty(addressElement.getAddressLine1())) {
            address.setAddressLine1(addressElement.getAddressLine1());
        }
        if (!StringUtils.isEmpty(addressElement.getAddressLine2())) {
            address.setAddressLine2(addressElement.getAddressLine2());
        }
        if (!StringUtils.isEmpty(addressElement.getCity())) {
            address.setCity(addressElement.getCity());
        }
        if (!StringUtils.isEmpty(addressElement.getZipCode())) {
            address.setPostCode(addressElement.getZipCode());
        }
        Country country = new Country();
        final String countryCode = addressElement.getCountryCode();
        country.setCountryCode(countryCode);
        country.setCountryName(autoCompleteService.getNameByCode("countries",
                countryCode, null));
        address.setCountry(country);
        State state = new State();
        final String stateCode = addressElement.getState();
        if (!StringUtils.isEmpty(stateCode)) {
            state.setStateCode(stateCode);
        }
        state.setStateName(asdataService.getStateByCode(stateCode, countryCode));
        address.setState(state);
        if (!StringUtils.isEmpty(addressElement.getPhoneNumber())) {
            address.setPhoneNumber(addressElement.getPhoneNumber());
        }
        if (!StringUtils.isEmpty(addressElement.getFaxNumber())) {
            address.setFaxNumber(addressElement.getFaxNumber());
        }

        return address;
    }

}
