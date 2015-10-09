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
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.externalservices.service.ValidationService;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ParticipantError;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.State;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.AddressData;
import com.wiley.gr.ace.authorservices.model.external.AddressElement;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiReq;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiRes;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.Entity;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.ParticipantAddress;
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

	@Autowired(required = true)
	ParticipantsInterfaceService participantsInterfaceService;

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
	 * This field holds the value of physicalAddress.
	 */
	@Value("${PhysicalAddress}")
	private String physicalAddress;

	/**
	 * This field holds the value of billingAddress.
	 */
	@Value("${BillingAddress}")
	private String billingAddress;

	/**
	 * This field holds the value of shippingAddress.
	 */
	@Value("${ShippingAddress}")
	private String shippingAddress;

	/**
	 * This field holds the value of institutions.
	 */
	@Value("${institutions}")
	private String institutions;

	/**
	 * This field holds the value of departments.
	 */
	@Value("${departments}")
	private String departments;

	/**
	 * This field holds the value of countries.
	 */
	@Value("${countries}")
	private String countries;

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
		if (!StringUtils.isEmpty(titleId)) {
			user.setTitle(titleId);
			user.setTitleName(asDataDao.getData(titleId));
		}
		user.setFirstName(customerDetails.getfName());
		user.setLastName(customerDetails.getlName());
		user.setMiddleName(customerDetails.getmName());
		final String suffixId = customerDetails.getUserSuffix();
		if (!StringUtils.isEmpty(suffixId)) {
			user.setSuffix(suffixId);
			user.setSuffixName(asDataDao.getData(suffixId));
		}
		user.setAlternateName(customerDetails.getAlternativeName());
		user.setPrimaryEmailAddr(customerDetails.getPrimaryEmail());
		user.setRecoveryEmailAddress(customerDetails.getSecondaryEmail());
		final String industryCode = customerDetails.getIndustryCode();
		if (!StringUtils.isEmpty(industryCode)) {
			user.setIndustry(industryCode);
			user.setIndustryName(autoCompleteService.getNameByCode(industries,
					industryCode, null));
		}
		final String jobCategoriesCode = customerDetails.getJobCategoryCode();
		if (!StringUtils.isEmpty(jobCategoriesCode)) {
			user.setJobCategory(jobCategoriesCode);
			user.setJobCategoryName(autoCompleteService.getNameByCode(
					jobCategories, jobCategoriesCode, null));
		}

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

			if (physicalAddress
					.equalsIgnoreCase(addressElement.getAddrTypeCD())) {
				Address correspondenceAddress = this
						.setAddressValues(addressElement);
				corresAddress.setCorrespondenceAddress(correspondenceAddress);
			}
			if (billingAddress.equalsIgnoreCase(addressElement.getAddrTypeCD())) {
				Address billingAddress = this.setAddressValues(addressElement);
				billAddress.setBillingAddress(billingAddress);
			}
			if (shippingAddress
					.equalsIgnoreCase(addressElement.getAddrTypeCD())) {
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
					institutions, institutionCode, null));
		}

		final String departmentCode = addressElement.getDepartmentCd();
		if (!StringUtils.isEmpty(departmentCode)) {
			address.setDepartmentId(departmentCode);
			address.setDepartmentName(autoCompleteService.getNameByCode(
					departments, departmentCode, institutionCode));
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
		country.setCountryName(autoCompleteService.getNameByCode(countries,
				countryCode, null));
		address.setCountry(country);
		State state = new State();
		final String stateCode = addressElement.getState();
		if (!StringUtils.isEmpty(stateCode)) {
			state.setStateCode(stateCode);
			state.setStateName(asdataService.getStateByCode(stateCode,
					countryCode));
		}

		// commented as part of codemerge
		// address.setState(state);
		if (!StringUtils.isEmpty(addressElement.getPhoneNumber())) {
			address.setPhoneNumber(addressElement.getPhoneNumber());
		}
		if (!StringUtils.isEmpty(addressElement.getFaxNumber())) {
			address.setFaxNumber(addressElement.getFaxNumber());
		}

		return address;
	}

	@Override
	public ParticipantAddress getAddress(String participantId) throws Exception {
		return (ParticipantAddress) participantsInterfaceService
				.getAddress(participantId);
	}

	@Override
	public Object updatAddress(String participantId, Entity entity)
			throws Exception {
		boolean isUpdated = false;
		AddressData address = entity.getAddress();
		List<AddressData> varifiedAddress = validateAddress(address);
		if (StringUtils.isEmpty(varifiedAddress)) {
			ParticipantAddress participantAddress = new ParticipantAddress();
			participantAddress.setAddressCountry(address.getCountryCode());
			participantAddress.setAddressFunctiom(address.getAddressType());
			participantAddress.setAddressLocality(address.getCity());
			participantAddress.setAddressRegion(address.getStateCode());
			participantAddress.setAddressType(address.getAddressTypeCode());
			participantAddress.setDepartment(address.getDepartmentName());
			participantAddress.setDepartmentID(address.getDepartmentCode());
			participantAddress.setOrganizationId(address.getInstitutionCode());
			participantAddress.setOrganization(address.getInstitutionName());
			participantAddress.setPostalCode(address.getZipCode());
			ArrayList<String> streetAddress = new ArrayList<>();
			streetAddress.add(address.getAddressLine1());
			streetAddress.add(address.getAddressLine2());
			participantAddress.setStreetAddress(streetAddress);
			participantAddress.setTelephone(address.getPhoneNumber());
			participantAddress.setValidFrom(address.getAddressStartDate());
			participantAddress.setValidTo(address.getAddressEndDate());
			participantAddress.setAddressId(address.getAddressId());
			ResponseEntity resposeEntity = participantsInterfaceService
					.updateAddress(participantId, participantAddress);
			Integer code = resposeEntity.getStatusCode().value();
			if (code.equals(200)) {
				isUpdated = true;
			} else {
				isUpdated = false;
				ParticipantError participantError = (ParticipantError) resposeEntity
						.getBody();
				throw new Exception(participantError.getMessage());
			}
			return isUpdated;
		} else {
			return varifiedAddress;
		}
	}

	@Override
	public List<AddressData> validateAddress(AddressData address)
			throws Exception {
		ArrayList<AddressData> validAddressList = new ArrayList<>();
		AddressValidationRequest addressValidationRequest = new AddressValidationRequest();
		AddressValidationMultiReq addressValidationMultiReq = new AddressValidationMultiReq();
		System.err.println(address.getAddressLine1());
		addressValidationMultiReq.setStreet1(address.getAddressLine1());
		addressValidationMultiReq.setStreet2(address.getAddressLine2());
		addressValidationMultiReq.setLocality1(address.getCity());
		addressValidationMultiReq.setPostCode(address.getZipCode());
		addressValidationMultiReq.setProvince1(address.getStateName());
		addressValidationMultiReq.setCountryName(address.getCountryName());
		addressValidationRequest
				.setAddressValidationMultiReq(addressValidationMultiReq);
		ArrayList<AddressValidationMultiRes> validAddressListFromAddressDoctor = validationService
				.validateAddress(addressValidationRequest);

		if (!StringUtils.isEmpty(validAddressListFromAddressDoctor)) {
			for (AddressValidationMultiRes addressValidationMultiRes : validAddressListFromAddressDoctor) {
				AddressData tempAddr = new AddressData();
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

}
