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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.InviteRecords;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ALMAuthRequest;
import com.wiley.gr.ace.authorservices.model.external.ALMCreateUserRespnse;
import com.wiley.gr.ace.authorservices.model.external.ALMSearchUserResponse;
import com.wiley.gr.ace.authorservices.model.external.ALMUser;
import com.wiley.gr.ace.authorservices.model.external.ALMUserAddress;
import com.wiley.gr.ace.authorservices.model.external.AddressDetails;
import com.wiley.gr.ace.authorservices.model.external.AddressElement;
import com.wiley.gr.ace.authorservices.model.external.CDMResponse;
import com.wiley.gr.ace.authorservices.model.external.CDMUser;
import com.wiley.gr.ace.authorservices.model.external.ContactEBM;
import com.wiley.gr.ace.authorservices.model.external.ContactIdentification;
import com.wiley.gr.ace.authorservices.model.external.ContactProfile;
import com.wiley.gr.ace.authorservices.model.external.CreateContactRequestCDM;
import com.wiley.gr.ace.authorservices.model.external.CreateContactRequestEBM;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.CustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;
import com.wiley.gr.ace.authorservices.model.external.SourceContactXREF;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

/**
 * The Class RegistrationServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class RegistrationServiceImpl implements RegistrationService {

    /** The esb inter face service. */
    @Autowired(required = true)
    private ESBInterfaceService esbInterFaceService;

    /** The registration service dao. */
    @Autowired(required = true)
    private RegistrationServiceDAO registrationServiceDAO;

    /**
     * This field holds the value of autoCompleteService.
     */
    @Autowired(required = true)
    private AutocompleteService autoCompleteService;

    @Autowired(required = true)
    private ALMInterfaceService almInterfaceService;

    @Autowired(required = true)
    private ParticipantsInterfaceService participantInterfaceService;

    @Autowired(required = true)
    private CDMInterfaceService cdmInterfaceService;

    @Autowired(required = true)
    private SharedService sharedService;

    @Value("${RegistrationController.verifyAccount.activated.code}")
    private String accountActivatedErrorCode;

    @Value("${RegistrationController.verifyAccount.activated.message}")
    private String accountActivatedErrorMessage;

    @Value("${RegistrationController.verifyAccount.suspended.code}")
    private String accountSuspendedErrorCode;

    @Value("${RegistrationController.verifyAccount.suspended.message}")
    private String accountSuspendedErrorMessage;

    @Value("${RegistrationController.verifyAccount.noUserFound.code}")
    private String noUserFoundErrorCode;

    @Value("${RegistrationController.verifyAccount.noUserFound.message}")
    private String noUserFoundErrorMessage;

    /** value from props file configured. */
    @Value("${RegistrationController.checkUserExists.code}")
    private String checkUserExistsErrorCode;

    /** value from props file configured. */
    @Value("${RegistrationController.checkUserExists.message}")
    private String checkUserExistsErrorMessage;

    /** value from props file configured. */
    @Value("${RegistrationController.createUser.code}")
    private String createUserErrorCode;

    /** value from props file configured. */
    @Value("${RegistrationController.createUser.message}")
    private String createUserErrorMessage;

    /**
     * This method is for creating user.
     *
     * @param user
     *            the user
     * @return the string
     */
    @Override
    public final String createUser(final User user) {

        String status = null;
        try {
            if (null != user) {
                ProfileInformation profileInformation = new ProfileInformation();
                CustomerProfile customerProfile = new CustomerProfile();
                CustomerDetails customerDetails = new CustomerDetails();
                AddressDetails cuAddressDetails = new AddressDetails();
                List<AddressElement> addressElements = new ArrayList<AddressElement>();
                AddressElement addressElement = new AddressElement();

                if ("ALM".equalsIgnoreCase(user.getFoundIn())) {
                    ALMAuthRequest almAuthRequest = new ALMAuthRequest();
                    almAuthRequest.setAppKey("DAAS"); // remove hardcode
                    almAuthRequest.setAuthenticationType("LDAP"); // remove
                    // hardcode
                    almAuthRequest.setPassword(user.getPassword());
                    almAuthRequest.setUserId(user.getPrimaryEmailAddr());

                    if (esbInterFaceService.isALMAuthenticated(almAuthRequest)) {
                        customerDetails.setSkipTargetSystem(user.getFoundIn());
                    }
                }
                customerDetails.setfName(user.getFirstName());
                customerDetails.setlName(user.getLastName());
                customerDetails.setPswd(user.getPassword());
                if (!StringUtils.isEmpty(user.getParticipantId())) {
                    final InviteResetpwdLog inviteResetpwdLog = registrationServiceDAO
                            .getInvitationRecords(user.getParticipantId());
                    if (inviteResetpwdLog.getEmailAddress().equalsIgnoreCase(
                            user.getPrimaryEmailAddr())) {
                        customerDetails.setSecondaryEmail(inviteResetpwdLog
                                .getEmailAddress());
                    }

                }
                customerDetails.setPrimaryEmail(user.getPrimaryEmailAddr());
                customerDetails.setTcFlag(user.getTermsOfUseFlg());
                customerDetails.setSourceSystem("AS"); // remove hardcode
                final String countryCode = user.getCountryCode();
                addressElement.setCountryCode(countryCode);
                String tempCountryName = autoCompleteService.getNameByCode(
                        "countries", countryCode, null);
                addressElement.setCountryName(tempCountryName);
                addressElement.setAddressType("Primary"); // remove hardcode
                addressElement.setAddrTypeCD("Physical"); // remove hardcode
                addressElements.add(addressElement);
                cuAddressDetails.setAddress(addressElements);

                customerProfile.setCustomerDetails(customerDetails);
                customerProfile.setAddressDetails(cuAddressDetails);

                profileInformation.setCustomerprofile(customerProfile);

                status = esbInterFaceService.creatUser(profileInformation);
            }
        } catch (HttpClientErrorException httpEx) {
            if (httpEx.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                throw new UserException(
                        "REGISTRATION_ALM_AUTH_FAILURE_ERR_TEXT",
                        "Registration for ALM Authentication Failed. Please enter correct password.");
            } else if (httpEx.getStatusCode() == HttpStatus.LOCKED) {
                throw new UserException(
                        "REGISTRATION_ALM_ACCT_LOCKED_ERR_TEXT",
                        "Your account is locked out please try after sometime.");
            } else {
                throw new UserException("UNEXPECTED",
                        "Some Unexpected Error occured");
            }
        } catch (Exception e) {
            throw new UserException();
        }

        return status;
    }

    /**
     * This is for getting details by UserFromFirstNameLastName.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the user from first name last name
     */
    @Override
    public final ArrayList<User> getUserFromFirstNameLastName(
            final String firstName, final String lastName) {

        ArrayList<User> userList = new ArrayList<User>();
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            try {
                ArrayList<Participant> participantList = participantInterfaceService
                        .searchParticipantByName(firstName, lastName);

                if (!StringUtils.isEmpty(participantList)) {
                    for (Participant participant : participantList) {
                        if ("ACTIVE".equalsIgnoreCase(participant.getState())) {

                            User tempUser = new User();
                            Country tempCountry = new Country();
                            tempCountry.setCountryCode(participant
                                    .getParticipantCountry());
                            tempUser.setCountry(tempCountry);

                            tempUser.setFirstName(participant.getGivenName());
                            tempUser.setLastName(participant.getFamilyName());
                            tempUser.setPrimaryEmailAddr(participant.getEmail());
                            // tempUser.setInstituition(participant.geti);
                            tempUser.setOrcidId(participant.getOrcidId());
                            userList.add(tempUser);
                        }

                    }
                } else {
                    ArrayList<CDMUser> cdmUserList = cdmInterfaceService
                            .searchCDM(firstName, lastName);
                    if (!StringUtils.isEmpty(cdmUserList)) {
                        for (CDMUser cdmUser : cdmUserList) {
                            User tempUser = new User();
                            tempUser.setFirstName(cdmUser.getFirstName());
                            tempUser.setLastName(cdmUser.getLastName());
                            tempUser.setPrimaryEmailAddr(cdmUser
                                    .getPrimaryEmail());
                            userList.add(tempUser);
                        }
                    }
                }
            } catch (Exception e) {
                throw new UserException("Some Error", e.getMessage());
            }
        }

        return userList;
    }

    /**
     * This is for checking user exists or not by taking emailId as input.
     *
     * @param emailId
     *            the email id
     * @return the user
     */
    @Override
    public final User checkEmailIdExists(final String emailId) {
        User user = null;
        if (!StringUtils.isEmpty(emailId)) {
            try {
                ALMSearchUserResponse almSearchUserResponse = almInterfaceService
                        .searchUser(emailId);
                if (StringUtils.isEmpty(almSearchUserResponse)) {
                    if (sharedService.searchInvitationRecord(emailId)) {
                        Participant participant = participantInterfaceService
                                .searchParticipantByEmail(emailId);
                        user = new User();
                        user.setFirstName(participant.getGivenName());
                        user.setLastName(participant.getFamilyName());
                        user.setCountryCode(participant.getParticipantCountry());
                    }
                } else {
                    throw new UserException(checkUserExistsErrorCode,
                            checkUserExistsErrorMessage);
                }

            } catch (Exception e) {
                throw new UserException();
            }
        }
        return user;
    }

    /**
     * This is for checking user exists or not by taking orcidId as input.
     *
     * @param orcidId
     *            the orcid id
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean searchUserByOrcidId(final String orcidId)
            throws Exception {

        boolean isUserFound = false;
        if (!StringUtils.isEmpty(orcidId)
                && registrationServiceDAO.searchUserByOrcidId(orcidId)) {
            isUserFound = true;
        }

        return isUserFound;
    }

    /**
     * This is for searchInvitationRecord or not by taking guid as input.
     *
     * @param guid
     *            the guid
     * @return the invite records
     * @throws Exception
     *             the exception
     */
    @Override
    public final InviteRecords searchInvitationRecord(final String guid)
            throws Exception {
        final InviteRecords inviteRecord = new InviteRecords();
        InviteResetpwdLog inviteRecordFromDB = null;
        inviteRecordFromDB = registrationServiceDAO.getInvitationRecords(guid);
        inviteRecord.setEmailAddress(inviteRecordFromDB.getEmailAddress());
        inviteRecord.setFirstName(inviteRecordFromDB.getFirstName());
        inviteRecord.setGuid(inviteRecordFromDB.getGuid());
        inviteRecord.setLastName(inviteRecordFromDB.getLastName());
        inviteRecord.setStatus(inviteRecordFromDB.getStatus());
        inviteRecord.setUserType(inviteRecordFromDB.getUserType());
        return inviteRecord;
    }

    /**
     * This is for assignRoleToNewUser.
     *
     * @param emailId
     *            the email id
     */
    @Override
    public final void assignRoleToNewUser(final String emailId) {

        registrationServiceDAO.assignRoleToNewRegistration(emailId);
    }

    /**
     * Creates the alm user.
     *
     * @param user
     *            the user
     * @return the string
     */
    @Override
    public String createALMUser(final User user) {

        String almUserId = null;
        ALMUser almUser = new ALMUser();
        ALMUserAddress almUserAddress = new ALMUserAddress();
        almUser.setEmail(user.getPrimaryEmailAddr());
        almUser.setFirstName(user.getFirstName());
        almUser.setLastName(user.getLastName());
        almUser.setPassword(user.getPassword());
        almUser.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        almUser.setTcFlag(AuthorServicesConstants.AS_ALM_TNC_FLAG);
        almUser.setCustomerType(AuthorServicesConstants.AS_ALM_USER_TYPE);
        almUserAddress.setCountry(user.getCountryCode());
        almUser.setUserAddress(almUserAddress);
        almUser.setUserStatus(AuthorServicesConstants.VERIFY_ACCOUNT_AWAITING_ACTIVATION);
        try {
            ALMCreateUserRespnse almCreateUserRespnse = almInterfaceService
                    .createUser(almUser);

            if (!StringUtils.isEmpty(almCreateUserRespnse)
                    && "Success".equalsIgnoreCase(almCreateUserRespnse
                            .getStatus())) {
                almUserId = almCreateUserRespnse.getUserId();
            }
        } catch (Exception e) {
            throw new UserException(createUserErrorCode, createUserErrorMessage);
        }

        return almUserId;
    }

    /**
     * Creates the participant.
     *
     * @param user
     *            the user
     * @return the string
     */
    @Override
    public String createParticipant(final User user) {

        Participant participant = new Participant();

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        participant.setCreatedDate(dt.format(new Date()));
        participant.setFamilyName(user.getLastName());
        participant.setGivenName(user.getFirstName());
        participant.setModifiedDate(dt.format(new Date()));
        participant.setParticipantCountry(user.getCountryCode());
        participant.setUserId(user.getUserId());

        return participantInterfaceService.createParticipant(participant);
    }

    /**
     * Creates the contact.
     *
     * @param user
     *            the user
     * @return the string
     */
    @Override
    public String createContact(final User user) {
        CDMUser cdmUser = new CDMUser();
        CreateContactRequestCDM createContactRequestCDM = new CreateContactRequestCDM();
        CreateContactRequestEBM createContactRequestEBM = new CreateContactRequestEBM();
        ContactEBM contactEBM = new ContactEBM();
        ContactProfile contactProfile = new ContactProfile();
        ContactIdentification contactIdentification = new ContactIdentification();
        SourceContactXREF sourceContactXREF = new SourceContactXREF();

        cdmUser.setAsId(user.getParticipantId());
        cdmUser.setAuthorFlag(AuthorServicesConstants.CDM_AUTHOR_FLAG);
        cdmUser.setFirstName(user.getFirstName());
        cdmUser.setLastName(user.getLastName());
        cdmUser.setPrimaryEmail(user.getPrimaryEmailAddr());
        cdmUser.setRegistrantFlag(AuthorServicesConstants.CDM_REG_FLAG);
        cdmUser.setSendEmail(AuthorServicesConstants.CDM_SEND_EMAIL_FLAG);
        cdmUser.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        cdmUser.setUserRole(AuthorServicesConstants.CDM_USER_ROLE);

        sourceContactXREF.setSourceCustomerID(user.getParticipantId());
        sourceContactXREF.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        contactIdentification.setSourceContactXREF(sourceContactXREF);
        contactProfile.setContactIdentification(contactIdentification);
        contactEBM.setContactProfile(contactProfile);
        contactEBM.setCustomerDetails(cdmUser);
        createContactRequestEBM.setContactEBM(contactEBM);
        createContactRequestCDM
                .setCreateContactRequestEBM(createContactRequestEBM);

        CDMResponse cdmResponse = cdmInterfaceService
                .createContact(createContactRequestCDM);

        return cdmResponse.getStatus();
    }

    /**
     * Verify account.
     *
     * @param emailId
     *            the email id
     */
    @Override
    public final void verifyAccount(final String emailId) {
        List<ALMUser> almUserList = almInterfaceService.searchUser(emailId)
                .getUserPayload();
        if (!StringUtils.isEmpty(almUserList)) {
            for (ALMUser almUser : almUserList) {
                if (almUser.getEmail().equals(emailId)) {
                    String userStatus = almUser.getUserStatus();
                    if (AuthorServicesConstants.VERIFY_ACCOUNT_ACTIVE
                            .equalsIgnoreCase(userStatus)) {
                        throw new ASException(accountActivatedErrorCode,
                                accountActivatedErrorMessage);
                    } else if (AuthorServicesConstants.VERIFY_ACCOUNT_SUSPENDED
                            .equalsIgnoreCase(userStatus)) {
                        throw new ASException(accountSuspendedErrorCode,
                                accountSuspendedErrorMessage);
                    } else if (AuthorServicesConstants.VERIFY_ACCOUNT_AWAITING_ACTIVATION
                            .equalsIgnoreCase(userStatus)) {
                        userStatus = AuthorServicesConstants.VERIFY_ACCOUNT_ACTIVE;
                        almUser.setUserStatus(userStatus);
                        almInterfaceService.updateUser(almUser);
                    }
                } else {
                    throw new ASException(noUserFoundErrorCode,
                            noUserFoundErrorMessage);
                }
            }
        }

    }
}
