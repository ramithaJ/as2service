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

import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.AddressElement;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
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
        user.setTitle(customerDetails.getTitle());
        user.setFirstName(customerDetails.getfName());
        user.setLastName(customerDetails.getlName());
        user.setMiddleName(customerDetails.getmName());
        user.setSuffix(customerDetails.getUserSuffix());
        user.setAlternateName(customerDetails.getAlternativeName());
        user.setPrimaryEmailAddr(customerDetails.getPrimaryEmail());
        user.setRecoveryEmailAddress(customerDetails.getSecondaryEmail());
        user.setIndustry(customerDetails.getIndustryCode());
        user.setJobCategory(customerDetails.getJobCategoryCode());
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
        Addresses addresses = new Addresses();
        for (AddressElement addressElement : addressElementsList) {

            if ("Physical".equalsIgnoreCase(addressElement.getAddrTypeCD())) {
                Address correspondenceAddress = this
                        .setAddressValues(addressElement);
                addresses.setCorrespondenceAddress(correspondenceAddress);
            }
            if ("Billing".equalsIgnoreCase(addressElement.getAddrTypeCD())) {
                Address billingAddress = this.setAddressValues(addressElement);
                addresses.setBillingAddress(billingAddress);
            }
            if ("Shipping".equalsIgnoreCase(addressElement.getAddrTypeCD())) {
                Address shippingAddress = this.setAddressValues(addressElement);
                addresses.setShippingAddress(shippingAddress);
            }

        }
        addressesList.add(addresses);
        return addressesList;
    }

    private Address setAddressValues(final AddressElement addressElement) {

        Address address = null;
        address = new Address();
        address.setTitle(addressElement.getTitle());
        address.setSuffix(addressElement.getSuffix());
        address.setFirstName(addressElement.getFirstName());
        address.setLastName(addressElement.getLastName());
        address.setDepartmentId(addressElement.getDepartmentCd());
        address.setInstitutionId(addressElement.getInstitutionCd());
        address.setAddressLine1(addressElement.getAddressLine1());
        address.setAddressLine2(addressElement.getAddressLine2());
        address.setCity(addressElement.getCity());
        address.setState(addressElement.getState());
        address.setPostCode(addressElement.getZipCode());
        Country country = new Country();
        country.setCountryCode(addressElement.getCountryCode());
        address.setCountry(country);
        address.setPhoneNumber(addressElement.getPhoneNumber());
        address.setFaxNumber(addressElement.getFaxNumber());
        return address;
    }

}
