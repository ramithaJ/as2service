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

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.external.util.ASDateFormatUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.AlertsList;
import com.wiley.gr.ace.authorservices.model.AreaOfInterests;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.PreferredJournals;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.AddressDetails;
import com.wiley.gr.ace.authorservices.model.external.AddressElement;
import com.wiley.gr.ace.authorservices.model.external.AffiliationData;
import com.wiley.gr.ace.authorservices.model.external.AffiliationsData;
import com.wiley.gr.ace.authorservices.model.external.AlertData;
import com.wiley.gr.ace.authorservices.model.external.AlertType;
import com.wiley.gr.ace.authorservices.model.external.AlertsData;
import com.wiley.gr.ace.authorservices.model.external.AreaOfInterest;
import com.wiley.gr.ace.authorservices.model.external.CoAuthorData;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.CustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.EntityValue;
import com.wiley.gr.ace.authorservices.model.external.FavoriteJournals;
import com.wiley.gr.ace.authorservices.model.external.InterestData;
import com.wiley.gr.ace.authorservices.model.external.InterestList;
import com.wiley.gr.ace.authorservices.model.external.Journal;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.PasswordRequest;
import com.wiley.gr.ace.authorservices.model.external.PasswordUpdate;
import com.wiley.gr.ace.authorservices.model.external.Preferences;
import com.wiley.gr.ace.authorservices.model.external.ProfileEntity;
import com.wiley.gr.ace.authorservices.model.external.ProfileRequest;
import com.wiley.gr.ace.authorservices.model.external.ResearchFunderData;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestionsUpdateRequest;
import com.wiley.gr.ace.authorservices.model.external.SocietyData;
import com.wiley.gr.ace.authorservices.model.external.SocietyList;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsEntry;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsMap;
import com.wiley.gr.ace.authorservices.persistence.entity.Alerts;
import com.wiley.gr.ace.authorservices.persistence.services.AlertsDao;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorProfileDao;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.SendNotification;

/**
 * The Class AuthorProfileServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class AuthorProfileServiceImpl implements AuthorProfileService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AuthorProfileServiceImpl.class);

    /** The user profiles. */
    @Autowired
    private UserProfiles userProfiles;

    /** The user management. */
    @Autowired
    private UserManagement userManagement;

    /** The author profile dao. */
    @Autowired
    private AuthorProfileDao authorProfileDao;

    /**
     * Injecting SendNotification bean.
     */
    @Autowired(required = true)
    private SendNotification sendNotification;

    /** The alerts Dao. */
    @Autowired(required = true)
    private AlertsDao alertsDao;

    @Autowired(required = true)
    private AutocompleteService autocomplete;

    /** The template id. */
    @Value("${templateId.sec.email.update}")
    private String secEmailUpdateTemplateId;

    /**
     * This field holds the value of passwordUpdatetemplateId.
     */
    @Value("${templateId.password.update}")
    private String passwordUpdatetemplateId;

    /**
     * This field holds the value of participantsInterfaceService.
     */
    @Autowired(required = true)
    private ParticipantsInterfaceService participantsInterfaceService;

    

    /**
     * Update society details.
     *
     * @param userId
     *            the user id
     * @param society
     *            the society
     * @return true, if successful
     */
    @Override
    public final boolean updateSocietyDetails(final int userId,
            final Society society) {
        AuthorProfileServiceImpl.LOGGER
                .info("ins ide updateSocietyDetails Method ");
        final CustomerDetails customerDetails = getCustomeProfile(String
                .valueOf(userId));
        final LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        final CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        final SocietyList societyList = new SocietyList();
        final SocietyData societyData = new SocietyData();
        societyData.setSocietyName(society.getSocietyName());
        societyData.setStartDate(ASDateFormatUtil.convertDate(Long
                .parseLong(society.getStartDate())));
        societyData.setEndDate(ASDateFormatUtil.convertDate(Long
                .parseLong(society.getEndDate())));
        societyData.setPromoCode(society.getPromoCode());
        societyData.setMembershipNo(society.getMembershipNumber());
        societyData.setSocietyId(society.getSocietyId());
        if ("0".equals(society.getId())) {
            societyData.setStatus("add");
        } else {
            societyData.setId(society.getId());
            societyData.setStatus("edit");
        }
        societyList.setSociety(new ArrayList<SocietyData>());
        societyList.getSociety().add(societyData);
        customerProfile.setCustomerDetails(customerDetails);
        customerProfile.setSocietyList(societyList);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);

    }

    /**
     * Update affiliation.
     *
     * @param userId
     *            the user id
     * @param affiliation
     *            the affiliation
     * @return true, if successful
     */
    @Override
    public final boolean updateAffiliation(final int userId,
            final Affiliation affiliation, final String affiliationId) {
        AuthorProfileServiceImpl.LOGGER
                .info("inside updateAffiliation Method ");
        final CustomerDetails customerDetails = getCustomeProfile(String
                .valueOf(userId));
        final LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        final CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        final AffiliationsData affiliationsData = new AffiliationsData();
        final List<AffiliationData> affDataList = new ArrayList<AffiliationData>();
        final AffiliationData affData = new AffiliationData();
        affData.setStartDate(ASDateFormatUtil.convertDate(Long
                .parseLong(affiliation.getStartDate())));
        affData.setEndDate(ASDateFormatUtil.convertDate(Long
                .parseLong(affiliation.getEndDate())));
        affData.setCity(affiliation.getCity());
        affData.setState(affiliation.getState());
        affData.setCountryCd(affiliation.getCountryCode());
        final String institutionId = affiliation.getInstitutionId();
        affData.setInstitutionCd(institutionId);
        final String name = autocomplete.getNameByCode("institutions",
                institutionId, null);
        affData.setInstitutionName(name);
        affData.setDepartmentCd(affiliation.getDepartmentId());
        affData.setDepartmentName(affiliation.getDepartmentName());
        affDataList.add(affData);
        affiliationsData.setAffiliation(affDataList);
        customerProfile.setAffiliations(affiliationsData);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        if ("0".equals(affiliationId)) {
            affData.setStatus("add");
        } else {
            affData.setId(affiliationId);
            affData.setStatus("edit");
        }
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);

    }

    /**
     * Update research funder.
     *
     * @param userId
     *            the user id
     * @param researchFunder
     *            the research funder
     * @return true, if successful
     */
    /*
     * @Override public final boolean updateResearchFunder(final int userId,
     * final ResearchFunder researchFunder) {
     * 
     * AuthorProfileServiceImpl.LOGGER
     * .info("inside updateResearchFunder Method ");
     * 
     * final List<ResearchFunder> list = new ArrayList<ResearchFunder>();
     * list.add(researchFunder); userProfile.setResearchFunders(list);
     * lookUpProfile.setCustomerProfile(userProfile); return null !=
     * userProfiles.updateProfile(userId, lookUpProfile); }
     */

    /**
     * Update alerts.
     *
     * @param userId
     *            the user id
     * @param listOfalert
     *            the user profile alerts
     * @return true, if successful
     */
    @Override
    public final boolean updateAlerts(final String userId,
            final AlertsList listOfalert) {
        AuthorProfileServiceImpl.LOGGER.info("inside updateAlerts Method ");
        final CustomerDetails customerDetails = getCustomeProfile(userId);
        final LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        final CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        final AlertsData alertsData = new AlertsData();
        final List<AlertData> alertList = new ArrayList<AlertData>();
        final List<Alert> alertLIst = listOfalert.getAlertsList();
        final List<AlertData> externalAlertsList = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAlerts().getAlert();
        for (final Alert alert : alertLIst) {
            final AlertData alertData = new AlertData();
            final AlertType alertType = new AlertType();
            alertData.setId(alert.getAlertId());
            alertData.setAlertID(alert.getAlertId());
            alertData.setStatus(alert.getStatus());
            if (alert.isEmail()) {
                alertType.setEmail("1");
            } else {
                alertType.setEmail("0");
            }
            if (alert.isOnScreen()) {
                alertType.setOnscreen("1");
            } else {
                alertType.setOnscreen("0");
            }
            alertData.setType(alertType);
            alertData.setStatus("add");

            if (externalAlertsList != null && !externalAlertsList.isEmpty()) {
                for (final AlertData getAlertsData : externalAlertsList) {

                    if (alert.getAlertId().equalsIgnoreCase(
                            getAlertsData.getAlertID())) {
                        alertData.setStatus("edit");
                    }
                }
            }

            alertList.add(alertData);
        }
        alertsData.setAlert(alertList);
        customerProfile.setAlerts(alertsData);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);
    }

    /**
     * Update Coauthor.
     *
     * @param userId
     *            the user id
     * @param coAuthor
     *            the co author
     * @return true, if successful
     */
    /*
     * @Override public final boolean updatecoAuthor(final int userId, final
     * CoAuthor coAuthor) {
     * 
     * AuthorProfileServiceImpl.LOGGER.info("inside updatecoAuthor Method ");
     * 
     * final List<CoAuthor> list = new ArrayList<CoAuthor>();
     * list.add(coAuthor); userProfile.setCoAuthors(list);
     * lookUpProfile.setCustomerProfile(userProfile); return null !=
     * userProfiles.updateProfile(userId, lookUpProfile);
     * 
     * }
     */

    /**
     * Update email details.
     *
     * @param userId
     *            the user id
     * @param emailDetails
     *            the email details
     * @return true, if successful
     */
    @Override
    public final boolean updateEmailDetails(final String userId,
            final User emailDetails) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateEmailDetails Method ");

        final ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityType("EMAIL");

        final EntityValue entityValue = new EntityValue();

        final ProfileRequest profileRequest = new ProfileRequest();
        final Participant participantResponse = participantsInterfaceService
                .searchParticipantByParticipantId(userId);
        profileRequest.setAlternativeName(""); // TODO
        profileRequest.setFirstName(participantResponse.getGivenName());
        profileRequest.setMiddleName(participantResponse.getAdditionalName()); // TODO
        profileRequest.setLastName(participantResponse.getFamilyName());
        profileRequest.setPrimaryEmail(participantResponse.getEmail());
        profileRequest.setRecoveryEmail(participantResponse.getRecoveryEmail());
        profileRequest.setOldEmail(""); // TODO
        profileRequest.setIndustryCode(participantResponse.getIndustryId());
        profileRequest.setJobCategoryCode(participantResponse
                .getJobCategoryId());
        profileRequest.setTitleCode(participantResponse.getHonorificPrefix());
        profileRequest.setSuffixCode(participantResponse.getHonorificSuffix());

        final List<InterestList> interestList = new ArrayList<InterestList>();
        final InterestList interest = new InterestList();
        interest.setInterestCode(""); // interest code TODO
        profileRequest.setInterestList(interestList);

        profileRequest.setOrcid(participantResponse.getOrcidId()); // orcid id

        entityValue.setProfile(profileRequest);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem("AS2.0");
        profileEntity.setEntityId(userId);

        participantsInterfaceService.updateProfile(profileEntity);

        final boolean status = false;
        if (status) {
            sendNotification.updateSecEmailNotification(
                    emailDetails.getPrimaryEmailAddr(),
                    secEmailUpdateTemplateId);
        }

        return status;
    }

    /**
     * Update user address.
     *
     * @param userId
     *            the user id
     * @param addressesRequest
     *            the addresses request
     * @return true, if successful
     */
    @Override
    public final boolean updateUserAddress(final String userId,
            final Address addressesRequest) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateUserAddress Method ");

        final CustomerDetails customerDetails = getCustomeProfile(userId);
        final LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        final CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);

        final AddressDetails addressDetails = new AddressDetails();
        final List<AddressElement> addressElementsList = new ArrayList<AddressElement>();

        final List<AddressElement> addressList = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAddressDetails().getAddress();

        if ("Physical".equalsIgnoreCase(addressesRequest.getAddressType())) {
            final AddressElement physical = this.updateAddressFields(
                    addressesRequest, addressesRequest.getAddressType(),
                    addressesRequest.getAddressId());
            addressElementsList.add(physical);
            if ('Y' == addressesRequest.getAddressFlag()) {
                String id = "0";
                if (!StringUtils.isEmpty(addressList)) {
                    for (final AddressElement addressElement : addressList) {
                        if ("Billing".equalsIgnoreCase(addressElement
                                .getAddrTypeCD())) {
                            id = addressElement.getId();
                        }
                    }
                }
                final AddressElement billing = this.updateAddressFields(
                        addressesRequest, "Billing", id);
                addressElementsList.add(billing);
            }
        }

        if ("Billing".equalsIgnoreCase(addressesRequest.getAddressType())) {
            final AddressElement physical = this.updateAddressFields(
                    addressesRequest, addressesRequest.getAddressType(),
                    addressesRequest.getAddressId());
            addressElementsList.add(physical);
            if ('Y' == addressesRequest.getAddressFlag()) {
                String shippingId = "0";
                if (!StringUtils.isEmpty(addressList)) {
                    for (final AddressElement addressElement : addressList) {
                        if ("Shipping".equalsIgnoreCase(addressElement
                                .getAddrTypeCD())) {
                            shippingId = addressElement.getId();
                        }
                    }
                }
                final AddressElement shipping = this.updateAddressFields(
                        addressesRequest, "Shipping", shippingId);
                addressElementsList.add(shipping);
            }
        }

        if ("Shipping".equalsIgnoreCase(addressesRequest.getAddressType())) {
            final AddressElement shipping = this.updateAddressFields(
                    addressesRequest, addressesRequest.getAddressType(),
                    addressesRequest.getAddressId());
            addressElementsList.add(shipping);
        }

        addressDetails.setAddress(addressElementsList);
        customerProfile.setAddressDetails(addressDetails);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);
    }

    /**
     * Update address fields.
     *
     * @param addressesRequest
     *            the addresses request
     * @param addressType
     *            the address type
     * @param id
     *            the id
     * @return the address element
     */
    private AddressElement updateAddressFields(final Address addressesRequest,
            final String addressType, final String id) {

        final AddressElement addressElement = new AddressElement();
        addressElement.setAddrTypeCD(addressType);
        addressElement.setTitle(addressesRequest.getTitle());
        addressElement.setFirstName(addressesRequest.getFirstName());
        addressElement.setLastName(addressesRequest.getLastName());
        addressElement.setSuffix(addressesRequest.getSuffix());
        if (!StringUtils.isEmpty(addressesRequest.getInstitutionId())) {
            addressElement
                    .setInstitutionCd(addressesRequest.getInstitutionId());
            addressElement.setInstitutionName(addressesRequest
                    .getInstitutionName());
        }
        if ("0".equalsIgnoreCase(id)) {
            addressElement.setStatus("Add");
        } else {
            addressElement.setId(id);
            addressElement.setStatus("Edit");
        }
        if ("".equalsIgnoreCase(addressesRequest.getDepartmentId())) {
            addressElement.setDepartmentCd(addressesRequest.getDepartmentId());
            addressElement.setDepartmentName(addressesRequest
                    .getDepartmentName());
        }
        addressElement.setAddressLine1(addressesRequest.getAddressLine1());
        addressElement.setAddressLine2(addressesRequest.getAddressLine2());
        addressElement.setCity(addressesRequest.getCity());
        addressElement.setState(addressesRequest.getStateCode());
        addressElement.setZipCode(addressesRequest.getPostCode());
        addressElement.setCountryCode(addressesRequest.getCountryCode());
        addressElement.setPhoneNumber(addressesRequest.getPhoneNumber());
        addressElement.setFaxNumber(addressesRequest.getFaxNumber());
        return addressElement;
    }

    /**
     * Update user profile info.
     *
     * @param userId
     *            the user id
     * @param user
     *            the user
     * @return true, if successful
     */
    @Override
    public final boolean updateUserProfileInfo(final String userId,
            final User user) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateUserProfileInfo Method ");
        final ProfileEntity profileEntity = new ProfileEntity();

        profileEntity.setEntityType("PROFILE");
        final EntityValue entityValue = new EntityValue();

        final ProfileRequest profileRequest = new ProfileRequest();
        profileRequest.setTitleCode(user.getTitle());
        profileRequest.setSuffixCode(user.getSuffix());
        profileRequest.setMiddleName(user.getMiddleName());
        profileRequest.setLastName(user.getLastName());
        profileRequest.setFirstName(user.getFirstName());
        profileRequest.setAlternativeName(user.getAlternateName());
        profileRequest.setIndustryCode(user.getIndustry());
        profileRequest.setJobCategoryCode(user.getJobCategory());
        profileRequest.setSendEmail(user.getSendEmailFlag());
        profileRequest.setPrimaryEmail(""); // primary email Address

        final List<InterestList> interestList = new ArrayList<InterestList>();
        final InterestList interest = new InterestList();
        interest.setInterestCode(""); // interest code
        profileRequest.setInterestList(interestList);

        profileRequest.setOrcid(""); // orcid id

        entityValue.setProfile(profileRequest);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem("AS2.0");
        profileEntity.setEntityId(userId);

        participantsInterfaceService.updateProfile(profileEntity);

        return false;
    }

    /**
     * Update password.
     *
     * @param passwordDetails
     *            the password details
     * @return true, if successful
     */
    @Override
    public final boolean updatePassword(final PasswordDetails passwordDetails) {

        AuthorProfileServiceImpl.LOGGER.info("inside updatePassword Method ");
        final PasswordUpdate passwordUpdate = new PasswordUpdate();
        final PasswordRequest passwordRequest = new PasswordRequest();
        passwordRequest.setExistingEmail(passwordDetails.getEmailId());
        passwordRequest.setExistingPassword(passwordDetails.getOldPassword());
        passwordRequest.setNewPassword(passwordDetails.getNewPassword());
        passwordRequest.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        passwordUpdate.setUpdateUserSecurityAttributes(passwordRequest);
        final boolean status = userManagement.updatePassword(passwordRequest);
        if (status) {
            sendNotification.notifyByEmail(passwordDetails.getEmailId(),
                    passwordUpdatetemplateId);
        }

        return status;
    }

    /**
     * Update security details.
     *
     * @param securityDetailsHolder
     *            the security details holder
     * @return true, if successful
     */
    @Override
    public final boolean updateSecurityDetails(
            final SecurityDetailsHolder securityDetailsHolder) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateSecurityDetails Method ");
        final SecurityQuestionsUpdateRequest securityQuestionsUpdateRequest = new SecurityQuestionsUpdateRequest();
        final UserSecurityQuestions userSecurityQuestions = new UserSecurityQuestions();
        final UserSecurityQuestionsMap userSecurityQuestionsMap = new UserSecurityQuestionsMap();
        final List<UserSecurityQuestionsEntry> userSecurityQuestionsEntryList = new ArrayList<UserSecurityQuestionsEntry>();
        UserSecurityQuestionsEntry userSecurityQuestionsEntry = null;
        final List<SecurityDetails> securityDetailsList = securityDetailsHolder
                .getSecurityDetails();
        for (final SecurityDetails securityDetails : securityDetailsList) {

            userSecurityQuestionsEntry = new UserSecurityQuestionsEntry();
            userSecurityQuestionsEntry.setKey(securityDetails
                    .getSecurityQuestion());
            userSecurityQuestionsEntry.setText(securityDetails
                    .getSecurityAnswer());
            userSecurityQuestionsEntryList.add(userSecurityQuestionsEntry);
        }
        userSecurityQuestionsMap.setEntry(userSecurityQuestionsEntryList);
        userSecurityQuestions
                .setUserSecurityQuestionsMap(userSecurityQuestionsMap);
        securityQuestionsUpdateRequest.setEmail(securityDetailsHolder
                .getEmailId());
        securityQuestionsUpdateRequest.setPassword(securityDetailsHolder
                .getOldPassword());
        securityQuestionsUpdateRequest
                .setsSystem(AuthorServicesConstants.SOURCESYSTEM);
        securityQuestionsUpdateRequest
                .setUserSecurityQuestions(userSecurityQuestions);

        return userManagement
                .updateSecurityDetails(securityQuestionsUpdateRequest);
    }

    /**
     * Gets the user profile response.
     *
     * @param userId
     *            the user id
     * @return the user profile response
     */
    /*
     * @Override public final LookupCustomerProfile getuserProfileResponse(final
     * int userId) {
     * AuthorProfileServiceImpl.LOGGER.info("in UserProfileResponse Method");
     * return userProfiles.getUserProfileResponse(userId); }
     */
    /**
     * This method is for uploading image.
     *
     * @param image
     *            the image
     * @param userId
     *            the user id
     */
    @Override
    public final void uploadImage(final File image, final String userId) {

        final byte[] imageData = new byte[(int) image.length()];
        try {
            // final FileInputStream fileInputStream = new
            // FileInputStream(image);
            // fileInputStream.read(imageData);
            // fileInputStream.close();
            authorProfileDao.saveProfilePicture(imageData, userId);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting LookUp Profile by calling external service.
     *
     * @param userId
     *            the user id
     * @return the lookup customer profile
     */
    @Override
    public final LookupCustomerProfile getLookupCustomerProfile(
            final String userId) {

        return userProfiles.getLookupCustomerProfile(userId);
    }

    /**
     * This method will call externnal service look up profile to get
     * affiliation.
     *
     * @param userId
     *            the user id
     * @return the affiliations list
     */
    @Override
    public final List<Affiliation> getAffiliationsList(final String userId) {

        final List<AffiliationData> listofAffiliations = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAffiliations().getAffiliation();
        final List<Affiliation> listAffiliations = new ArrayList<Affiliation>();
        if (!StringUtils.isEmpty(listofAffiliations)) {

            for (final AffiliationData affiliationData : listofAffiliations) {
                if (affiliationData.getStartDate() == null) {
                    break;
                }
                final Affiliation affiliation = new Affiliation();
                affiliation.setAffiliationId(affiliationData.getId());
                affiliation.setCity(affiliationData.getCity());
                final Country country = new Country();
                country.setCountryCode(affiliationData.getCountryCd());
                affiliation.setCountry(country);
                affiliation
                        .setInstitutionId(affiliationData.getInstitutionCd());
                affiliation.setDepartmentId(affiliationData.getDepartmentCd());
                affiliation.setInstitutionName(affiliationData
                        .getInstitutionName());
                affiliation.setDepartmentName(affiliationData
                        .getDepartmentName());
                affiliation.setStartDate(ASDateFormatUtil
                        .convertDateToLong(affiliationData.getStartDate()));
                affiliation.setEndDate(ASDateFormatUtil
                        .convertDateToLong(affiliationData.getEndDate()));
                affiliation.setStateCode(affiliationData.getState());
                affiliation.setId(affiliationData.getId());
                listAffiliations.add(affiliation);
            }
        }
        return listAffiliations;
    }

    /**
     * This method will call externnal service look up profile to get research
     * funder.
     *
     * @param userId
     *            the user id
     * @return the research funders list
     */
    @Override
    public final List<ResearchFunder> getResearchFundersList(final String userId) {
        final List<ResearchFunderData> listOfResearchFunder = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getResearchFunders().getResearchFunder();
        final List<ResearchFunder> researchFunderList = new ArrayList<ResearchFunder>();

        for (final ResearchFunderData researchFunderData1 : listOfResearchFunder) {
            final ResearchFunder researchFunder = new ResearchFunder();
            researchFunder.setResearchFunderId(researchFunderData1
                    .getFunderID());
            researchFunder.setResearchFunderName(researchFunderData1
                    .getFunderName());
            final Set<String> grantNumber = new HashSet<String>();
            final List<String> grantList = researchFunderData1
                    .getGrantNumbers().getGrantNo();
            for (final String grant : grantList) {
                grantNumber.add(grant);
            }
            researchFunder.setGrantNumber(grantNumber);
            researchFunderList.add(researchFunder);
        }

        return researchFunderList;
    }

    /**
     * This method will call externnal service look up profile to get Societies.
     *
     * @param userId
     *            the user id
     * @return the societylist
     */

    @Override
    public final List<Society> getSocietylist(final String userId) {
        final List<SocietyData> listSocietyData = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getSocietyList().getSociety();
        final List<Society> societyList = new ArrayList<Society>();

        for (final SocietyData societyData : listSocietyData) {
            if (societyData.getSocietyId() == null) {
                break;
            }
            final Society society = new Society();
            society.setSocietyId(societyData.getSocietyId());
            society.setSocietyName(societyData.getSocietyName());
            society.setMembershipNumber(societyData.getMembershipNo());
            society.setStartDate(ASDateFormatUtil.convertDateToLong(societyData
                    .getStartDate()));
            society.setEndDate(ASDateFormatUtil.convertDateToLong(societyData
                    .getEndDate()));
            society.setPromoCode(societyData.getPromoCode());
            society.setId(societyData.getId());
            societyList.add(society);

        }
        return societyList;
    }

    /**
     * This method will call external service look up profile to get co authors.
     *
     * @param userId
     *            the user id
     * @return the s co authors list
     */
    @Override
    public final List<CoAuthor> getsCoAuthorsList(final String userId) {

        final List<CoAuthorData> listOfCoauthors = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getCoAuthors().getCoAuthor();
        final List<CoAuthor> coAuthorList = new ArrayList<CoAuthor>();
        for (final CoAuthorData coAuthorData : listOfCoauthors) {
            final CoAuthor coAuthor = new CoAuthor();
            coAuthor.setCoAuthorId(coAuthorData.getId());
            coAuthor.setEmailId(coAuthorData.getEmailId());
            coAuthor.setFirstName(coAuthorData.getFirstName());
            coAuthor.setLastName(coAuthorData.getLastName());
            coAuthor.setPhone(coAuthorData.getPhoneNo());
            coAuthor.setInstitutionName(coAuthorData.getInstName());
            coAuthor.setDepartmentName(coAuthorData.getDeptName());
            coAuthorList.add(coAuthor);

        }
        return coAuthorList;
    }

    /**
     * This method will call external service look up profile to get interests.
     *
     * @param userId
     *            the user id
     * @return the area of interests
     */
    @Override
    public final List<Interests> getAreaOfInterests(final String userId) {
        List<Interests> areaList = null;
        final List<InterestData> listOfArea = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAreaOfInterest().getInterest();
        String aoeName = null;
        if (listOfArea != null) {
            areaList = new ArrayList<Interests>();
            for (final InterestData interestData : listOfArea) {
                final Interests interests = new Interests();
                if (interestData != null) {
                    interests.setAoeId(interestData.getInterestcode());
                    aoeName = autocomplete.getNameByCode("areasOfInterests",
                            interestData.getInterestcode(), null);
                    interests.setAoeName(aoeName);
                    areaList.add(interests);
                }

            }
        }

        return areaList;
    }

    /**
     * This method will call external service look up profile to get alerts.
     *
     * @param userId
     *            the user id
     * @return the list of alerts
     */
    @Override
    public final AlertsList getListOfAlerts(final String userId) {

        final CustomerProfile customerProfile = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile();

        final AlertsData alertExtData = customerProfile.getAlerts();
        final AlertsList alertsResponse = new AlertsList();
        List<AlertData> listOfAlert = new ArrayList<AlertData>();
        final List<Alerts> daoAlertList = alertsDao.getAlerts();
        final List<String> emailList = new ArrayList<String>();
        final List<Alert> alertList = new ArrayList<Alert>();
        emailList.add(customerProfile.getCustomerDetails().getPrimaryEmail());
        emailList.add(customerProfile.getCustomerDetails().getSecondaryEmail());
        if (alertExtData != null) {
            listOfAlert = alertExtData.getAlert();
        }

        for (final Alerts daoAlert : daoAlertList) {
            final Alert alert = new Alert();
            alert.setAlertId(daoAlert.getAlertCd());
            alert.setAlertName(daoAlert.getAlertName());

            for (final AlertData alertData : listOfAlert) {
                if (alertData != null) {
                    final String alertId = alertData.getAlertID();
                    if (daoAlert.getAlertCd().equals(alertId)) {
                        final AlertType alertType = alertData.getType();
                        if ("1".equalsIgnoreCase(alertType.getEmail())) {
                            alert.setEmail(true);
                        }
                        if ("1".equalsIgnoreCase(alertType.getOnscreen())) {
                            alert.setOnScreen(true);
                        }

                        break;
                    }

                }
            }
            alertList.add(alert);

        }

        if (alertList != null && !alertList.isEmpty()) {
            alertsResponse.setAlertsList(alertList);
        }

        if (emailList != null && !emailList.isEmpty()) {
            alertsResponse.setEmailsList(emailList);
        }

        return alertsResponse;
    }

    /**
     * This method will call external service look up profile to get preferred
     * journals.
     *
     * @param userId
     *            the user id
     * @return the preffered journals
     */
    @Override
    public final List<PreferredJournals> getPrefferedJournals(
            final String participantId) {

        final List<Preferences> preference = participantsInterfaceService
                .getPreferredJournals(participantId).getContent();

        final List<PreferredJournals> prefferedList = new ArrayList<PreferredJournals>();
        for (final Preferences preferences : preference) {
            /*
             * final PdhJournalData pdhJournalData = (PdhJournalData)
             * eSBInterfaceService
             * .getPdhLookupResponse(preferences.getPreferenceKey());
             */
            final PreferredJournals preferredJournals = new PreferredJournals();
            preferredJournals.setJournalId(preferences.getPreferenceKey());
            preferredJournals.setJournalTitle(preferences.getPreferenceValue());
            // preferredJournals.setPdhimage(pdhJournalData.getBannerImageLink());
            prefferedList.add(preferredJournals);
        }

        return prefferedList;
    }

    /**
     * This Method will get the customer details by calling external system ESB.
     *
     * @param userId
     *            the user id
     * @return the custome profile
     */
    @Override
    public final CustomerDetails getCustomeProfile(final String userId) {

        final CustomerDetails customerDetails = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getCustomerDetails();
        customerDetails.setPswd("");
        customerDetails.setAsid(userId);
        customerDetails.setUserRole("");
        customerDetails.setNickName(customerDetails.getAlternativeName());
        customerDetails.setCustomerType("User");
        customerDetails.setUserStatus("Active");
        customerDetails.setTcFlag("Y");
        customerDetails.setSendEmail("Yes");
        customerDetails.setSourceSystem("AS");
        customerDetails.setProfileVisibility("0");

        return customerDetails;
    }

    /**
     * This Method will Remove Orcid Id.
     *
     * @param userId
     *            the user id
     * @return true, if successful
     */
    @Override
    public final boolean removeOrcidId(final String userId) {

        return this.orcidIdDetails(userId, null);

    }

    /**
     * This Method will Update Orcid Id.
     *
     * @param userId
     *            the user id
     * @param orcidId
     *            the orcid id
     * @return true, if successful
     */

    @Override
    public final boolean updateOrcidId(final String userId, final String orcidId) {

        return this.orcidIdDetails(userId, orcidId);

    }

    /**
     * This Method will Update Orcid Id.
     *
     * @param userId
     *            the user id
     * @param orcidId
     *            the orcid id
     * @return true, if successful
     */
    private boolean orcidIdDetails(final String userId, final String orcidId) {

        final CustomerDetails customerDetails = getCustomeProfile(userId);
        customerDetails.setOrcId(orcidId);
        final LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        final CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);

    }

    /**
     * This method is for getting profile picture .....
     *
     * @param userId
     *            the user id
     * @return image in terms of Byte array
     */
    @Override
    public final byte[] getProfilePicture(final String userId) {

        final byte[] imageAsBytes = null;

        // UserProfile userProfile = authorProfileDao.getProfilePicture(userId);

        /*
         * try { // Blob image = userProfile.getProfilePic(); // int blobLength
         * = (int) image.length(); // imageAsBytes = image.getBytes(1,
         * blobLength); // FileOutputStream fos = new FileOutputStream( //
         * "C:\\Users\\ravisinha\\Desktop\\Retrive4.jpg"); //
         * fos.write(imageAsBytes); // fos.close();; // image.free(); } catch
         * (Exception e) { e.printStackTrace(); }
         */
        return imageAsBytes;

    }

    /**
     * this will call external service to delete society
     * 
     * @param userId
     * @param societyId
     *
     * */
    @Override
    public boolean deleteSociety(final String userId, final String societyId,
            final String id) {

        final CustomerDetails customerDetails = getCustomeProfile(String
                .valueOf(userId));
        final LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        final CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        final SocietyList societyList = new SocietyList();
        final SocietyData societyData = new SocietyData();
        societyData.setId(id);
        societyData.setStartDate("1999-05-31T13:20:00-05:00");
        societyData.setStatus("delete");
        societyData.setSocietyId(societyId);
        societyList.setSociety(new ArrayList<SocietyData>());
        societyList.getSociety().add(societyData);
        customerProfile.setCustomerDetails(customerDetails);
        customerProfile.setSocietyList(societyList);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);

        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);
    }

    /**
     * this will call external service to delete affiliations
     * 
     * @param userId
     * @param affiliationId
     *
     * */
    @Override
    public boolean deleteAffiliations(final String userId,
            final String affiliationId) {
        final CustomerDetails customerDetails = getCustomeProfile(String
                .valueOf(userId));
        final LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        final CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        final AffiliationsData affsData = new AffiliationsData();
        final List<AffiliationData> affDataList = new ArrayList<AffiliationData>();
        final AffiliationData affData = new AffiliationData();
        affData.setId(affiliationId);
        affData.setStartDate("1999-05-31T13:20:00-05:00");
        affDataList.add(affData);
        affsData.setAffiliation(affDataList);
        customerProfile.setAffiliations(affsData);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        affData.setStatus("delete");
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);

    }

    /**
     * this will call external service to delete interests
     * 
     * @param userId
     * @param interestId
     *
     * */

    @Override
    public boolean deleteInterests(final String userId, final String interestId) {
        final CustomerDetails customerDetails = getCustomeProfile(String
                .valueOf(userId));
        final LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        final CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        final InterestData interestData = new InterestData();
        interestData.setId(interestId);
        interestData.setStatus("delete");
        final List<InterestData> interestDataList = new ArrayList<InterestData>();
        interestDataList.add(interestData);
        final AreaOfInterest areaOfInterest = new AreaOfInterest();
        areaOfInterest.setInterest(interestDataList);
        customerProfile.setAreaOfInterest(areaOfInterest);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);

        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);
    }

    /**
     * this will call external service to delete interests
     * 
     * @param userId
     * @param journalId
     *
     * */
    @Override
    public boolean deletePreferredJournals(final String userId,
            final String journalId) {
        final CustomerDetails customerDetails = getCustomeProfile(String
                .valueOf(userId));
        final LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        final CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);

        final Journal journal = new Journal();
        journal.setId(journalId);
        journal.setStatus("delete");
        final List<Journal> journalsList = new ArrayList<Journal>();
        journalsList.add(journal);
        final FavoriteJournals favoriteJournals = new FavoriteJournals();
        favoriteJournals.setJournal(journalsList);
        customerProfile.setFavoriteJournals(favoriteJournals);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);

        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);
    }

    @Override
    public boolean addInterests(final String userId,
            final AreaOfInterests areaOfInterests) {
        final CustomerDetails customerDetails = getCustomeProfile(String
                .valueOf(userId));
        final LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        final CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        final List<Interests> listOfIntersts = areaOfInterests.getInterests();
        final List<InterestData> interestDataList = new ArrayList<InterestData>();
        final AreaOfInterest areaOfInterest = new AreaOfInterest();
        for (final Interests interests : listOfIntersts) {
            final InterestData interestData = new InterestData();
            interestData.setId(interests.getId());
            interestData.setInterestcode(interests.getId());
            interestData.setStatus("add");
            interestDataList.add(interestData);
        }
        areaOfInterest.setInterest(interestDataList);
        customerProfile.setCustomerDetails(customerDetails);
        customerProfile.setAreaOfInterest(areaOfInterest);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);

    }
}
