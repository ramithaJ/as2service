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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.ValidationService;
import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.AddressData;
import com.wiley.gr.ace.authorservices.model.external.AddressMapper;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiReq;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiRes;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;
import com.wiley.gr.ace.authorservices.model.external.AddressesData;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.ParticipantAddress;
import com.wiley.gr.ace.authorservices.model.external.ParticipantError;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
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

    /** The as data dao. */
    @Autowired(required = true)
    private ASDataDAO asDataDao;

    /**
     * This field holds the value of autoCompleteService.
     */
    @Autowired(required = true)
    private AutocompleteService autoCompleteService;

    /** The participants interface service. */
    @Autowired(required = true)
    ParticipantsInterfaceService participantsInterfaceService;

    /** The validation service. */
    @Autowired(required = true)
    private ValidationService validationService;
    /**
     * This field holds the value of industries.
     */
    @Value("${industries}")
    private String industries;

    /**
     * This field holds the value of jobCategories.
     */
    @Value("${jobCategories}")
    private String jobCategories;

    /**
     * This field holds the value of participantService.
     */
    @Autowired(required = true)
    private ParticipantsInterfaceService participantService;

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

        final Participant participantResponse = participantService
                .searchParticipantByParticipantId(userId);

        final User user = new User();
        user.setPrimaryEmailAddr(participantResponse.getEmail());
        user.setRecoveryEmailAddress(participantResponse.getRecoveryEmail());
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

        final Participant participantResponse = participantService
                .searchParticipantByParticipantId(userId);
        final User user = new User();
        final String titleId = participantResponse.getHonorificPrefix();
        if (!StringUtils.isEmpty(titleId)) {
            user.setTitle(titleId);
            user.setTitleName(asDataDao.getData(titleId));
        }
        user.setFirstName(participantResponse.getGivenName());
        user.setLastName(participantResponse.getFamilyName());
        user.setMiddleName(participantResponse.getAdditionalName());
        final String suffixId = participantResponse.getHonorificSuffix();
        if (!StringUtils.isEmpty(suffixId)) {
            user.setSuffix(suffixId);
            user.setSuffixName(asDataDao.getData(suffixId));
        }
        user.setAlternateName(AuthorServicesConstants.EMPTY);
        user.setPrimaryEmailAddr(participantResponse.getEmail());
        user.setRecoveryEmailAddress(participantResponse.getRecoveryEmail());
        final String industryCode = participantResponse.getIndustryId();
        if (!StringUtils.isEmpty(industryCode)) {
            user.setIndustry(industryCode);
            user.setIndustryName(autoCompleteService.getNameByCode(industries,
                    industryCode, null));
        }
        final String jobCategoriesCode = participantResponse.getJobCategoryId();
        if (!StringUtils.isEmpty(jobCategoriesCode)) {
            user.setJobCategory(jobCategoriesCode);
            user.setJobCategoryName(autoCompleteService.getNameByCode(
                    jobCategories, jobCategoriesCode, null));
        }

        user.setOrcidId(participantResponse.getOrcidId());

        return user;
    }

    /**
     * getting UserAddress info by user id.
     *
     * @param userId
     *            the user id
     * @return the user address
     * @throws UserException
     *             the user exception
     */
    @Override
    public final AddressesData getUserAddress(final String userId)
            throws UserException {

        UserAccountServiceImpl.LOGGER.info("inside getUserAddress Method");
        AddressesData address = new AddressesData();
        try {
            AddressMapper mapper = (AddressMapper) participantsInterfaceService
                    .getAddress(userId);

            List<ParticipantAddress> participantAddresses = mapper.getContent();

            for (ParticipantAddress participantAddr : participantAddresses) {
                partipcipantAddrToAddr(participantAddr, address);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE);
            throw new UserException();
        }
        return address;
    }

    /**
     * Updat address.
     *
     * @param participantId
     *            the participant id
     * @param address
     *            the address
     * @return the object
     * @throws UserException
     *             the user exception
     */
    @Override
    public Object updatAddress(final String participantId,
            final AddressData address) throws UserException {
        try {
            final List<AddressData> varifiedAddress = validateAddress(address);
            if (StringUtils.isEmpty(varifiedAddress)) {
                boolean isUpdated = false;
                final ResponseEntity resposeEntity = participantsInterfaceService
                        .updateAddress(participantId, address);
                final Integer code = resposeEntity.getStatusCode().value();
                if (code.equals(200)) {
                    isUpdated = true;
                } else {
                    isUpdated = false;
                    final ParticipantError participantError = (ParticipantError) resposeEntity
                            .getBody();
                    LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE,
                            participantError);
                    throw new UserException();
                }
                return isUpdated;
            } else {
                return varifiedAddress;
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE);
            throw new UserException();
        }
    }

    /**
     * Validate address.
     *
     * @param address
     *            the address
     * @return the list
     * @throws Exception
     *             the exception
     */
    @Override
    public List<AddressData> validateAddress(final AddressData address)
            throws Exception {
        List<AddressData> validAddressList = new ArrayList<>();
        final AddressValidationRequest addressValidationRequest = new AddressValidationRequest();
        final AddressValidationMultiReq addressValidationMultiReq = new AddressValidationMultiReq();
        addressValidationMultiReq.setStreet1(address.getAddressLine1());
        addressValidationMultiReq.setStreet2(address.getAddressLine2());
        addressValidationMultiReq.setLocality1(address.getCity());
        addressValidationMultiReq.setPostCode(address.getZipCode());
        addressValidationMultiReq.setProvince1(address.getStateName());
        addressValidationMultiReq.setCountryName(address.getCountryName());
        addressValidationRequest
                .setAddressValidationMultiReq(addressValidationMultiReq);
        final List<AddressValidationMultiRes> validAddressListFromAddressDoctor = validationService
                .validateAddress(addressValidationRequest);

        if (!StringUtils.isEmpty(validAddressListFromAddressDoctor)) {
            for (final AddressValidationMultiRes addressValidationMultiRes : validAddressListFromAddressDoctor) {
                final AddressData tempAddr = new AddressData();
                tempAddr.setAddressLine1(addressValidationMultiRes
                        .getDeliveryAddress1());
                tempAddr.setAddressLine2(addressValidationMultiRes
                        .getDeliveryAddress2());
                tempAddr.setCity(addressValidationMultiRes.getLocality1());
                tempAddr.setStateName(addressValidationMultiRes
                        .getProvinceExtended1());
                tempAddr.setZipCode(addressValidationMultiRes.getPostCode());
                tempAddr.setCountryName(addressValidationMultiRes
                        .getCountryName1());
                tempAddr.setCountryCode(addressValidationMultiRes
                        .getCountryISO2Char());
                validAddressList.add(tempAddr);
            }
        } else {
            validAddressList = null;
        }

        return validAddressList;
    }

    /**
     * Partipcipant addr to addr.
     *
     * @param participantAddr
     *            the participant addr
     * @param address
     *            the address
     * @return the addresses
     */
    private Addresses partipcipantAddrToAddr(
            ParticipantAddress participantAddr, AddressesData address) {
        if (!StringUtils.isEmpty(participantAddr)) {
            String type = participantAddr.getAddressType();
            AddressData addressData = new AddressData();
            addressData.setAddressEndDate(participantAddr.getValidTo());
            addressData.setAddressId(participantAddr.getAddressId());
            List<String> streetAddr = participantAddr.getStreetAddress();
            if (!StringUtils.isEmpty(streetAddr)) {
                addressData.setAddressLine1(streetAddr.get(0));
                addressData.setAddressLine2(streetAddr.get(1));
            }
            addressData.setAddressStartDate(participantAddr.getValidFrom());
            addressData.setAddressType(participantAddr.getAddressFunctiom());
            addressData.setAddressTypeCode(type);
            addressData.setCity(participantAddr.getAddressLocality());
            addressData.setCountryCode(participantAddr.getAddressCountry());
            addressData.setDepartmentCode(participantAddr.getDepartmentID());
            addressData.setDepartmentName(participantAddr.getDepartment());
            addressData.setInstitutionCode(participantAddr.getOrganizationId());
            addressData.setInstitutionName(participantAddr.getOrganization());
            addressData.setPhoneNumber(participantAddr.getTelephone());
            addressData.setStateCode(participantAddr.getAddressRegion());
            addressData.setZipCode(participantAddr.getPostalCode());
            if ("correspondance".equalsIgnoreCase(type)) {
                address.setCorrespondenceAddress(addressData);
            }
            if ("billing".equalsIgnoreCase(type)) {
                address.setBillingAddress(addressData);
            }
            if ("shipping".equalsIgnoreCase(type)) {
                address.setShippingAddress(addressData);
            }
        }
        return null;

    }
}
