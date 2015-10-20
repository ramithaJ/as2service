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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.external.util.AuthorServicesUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.Notifications;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ALMCreateUserRespnse;
import com.wiley.gr.ace.authorservices.model.external.ALMSearchUserResponse;
import com.wiley.gr.ace.authorservices.model.external.ALMUser;
import com.wiley.gr.ace.authorservices.model.external.ALMUserAddress;
import com.wiley.gr.ace.authorservices.model.external.CDMResponse;
import com.wiley.gr.ace.authorservices.model.external.CDMUser;
import com.wiley.gr.ace.authorservices.model.external.ContactEBM;
import com.wiley.gr.ace.authorservices.model.external.ContactIdentification;
import com.wiley.gr.ace.authorservices.model.external.ContactProfile;
import com.wiley.gr.ace.authorservices.model.external.CreateContactRequestCDM;
import com.wiley.gr.ace.authorservices.model.external.CreateContactRequestEBM;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.SourceContactXREF;
import com.wiley.gr.ace.authorservices.persistence.entity.RegistrationDetails;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

/**
 * The Class RegistrationServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class RegistrationServiceImpl implements RegistrationService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RegistrationServiceImpl.class);

    /** The registration service dao. */
    @Autowired(required = true)
    private RegistrationServiceDAO registrationServiceDAO;

    /** The alm interface service. */
    @Autowired(required = true)
    private ALMInterfaceService almInterfaceService;

    /** The participant interface service. */
    @Autowired(required = true)
    private ParticipantsInterfaceService participantInterfaceService;

    /** The cdm interface service. */
    @Autowired(required = true)
    private CDMInterfaceService cdmInterfaceService;

    /** The shared service. */
    @Autowired(required = true)
    private SharedService sharedService;

    /** The notification service. */
    @Autowired(required = true)
    private NotificationService notificationService;

    /** The auto complete service. */
    @Autowired(required = true)
    private AutocompleteService autoCompleteService;

    /** The account activated error code. */
    @Value("${RegistrationController.verifyAccount.activated.code}")
    private String accountActivatedErrorCode;

    /** The account activated error message. */
    @Value("${RegistrationController.verifyAccount.activated.message}")
    private String accountActivatedErrorMessage;

    /** The account suspended error code. */
    @Value("${RegistrationController.verifyAccount.suspended.code}")
    private String accountSuspendedErrorCode;

    /** The account suspended error message. */
    @Value("${RegistrationController.verifyAccount.suspended.message}")
    private String accountSuspendedErrorMessage;

    /** The no user found error code. */
    @Value("${RegistrationController.verifyAccount.noUserFound.code}")
    private String noUserFoundErrorCode;

    /** The no user found error message. */
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
     * This is for getting details by UserFromFirstNameLastName.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the user from first name last name
     */
    @Override
    public final List<User> getUserFromFirstNameLastName(
            final String firstName, final String lastName) {

        List<User> userList = new ArrayList<User>();
        try {
            List<Participant> participantList = participantInterfaceService
                    .searchParticipantByName(firstName, lastName);

            if (!StringUtils.isEmpty(participantList)) {
                for (Participant participant : participantList) {
                    if (AuthorServicesConstants.PARTICIPANT_STATUS_ACTIVE
                            .equalsIgnoreCase(participant.getState())) {

                        User tempUser = new User();
                        tempUser.setCountryCode(participant
                                .getParticipantCountry());

                        tempUser.setFirstName(participant.getGivenName());
                        tempUser.setLastName(participant.getFamilyName());
                        tempUser.setPrimaryEmailAddr(participant.getEmail());

                        tempUser.setOrcidId(participant.getOrcidId());
                        userList.add(tempUser);
                    }

                }
            } else {
                List<CDMUser> cdmUserList = cdmInterfaceService.searchCDM(
                        firstName, lastName);
                if (!StringUtils.isEmpty(cdmUserList)) {
                    for (CDMUser cdmUser : cdmUserList) {
                        User tempUser = new User();
                        tempUser.setFirstName(cdmUser.getFirstName());
                        tempUser.setLastName(cdmUser.getLastName());
                        tempUser.setPrimaryEmailAddr(cdmUser.getPrimaryEmail());
                        userList.add(tempUser);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException();
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
        try {
            LOGGER.info("checking if user exists in ALM");
            ALMSearchUserResponse almSearchUserResponse = almInterfaceService
                    .searchUser(emailId);
            if (StringUtils.isEmpty(almSearchUserResponse)) {
                LOGGER.info("User is not found in ALM, Searching the invitation records");
                if (!StringUtils.isEmpty(sharedService
                        .searchInvitationRecord(emailId))) {
                    LOGGER.info("User is an invited user");
                    Participant participant = participantInterfaceService
                            .searchParticipantByEmailId(emailId);
                    user = new User();
                    user.setFirstName(participant.getGivenName());
                    user.setLastName(participant.getFamilyName());

                    Country userCountry = new Country();
                    userCountry.setCountryCode(participant
                            .getParticipantCountry());
                    userCountry.setCountryName(autoCompleteService
                            .getNameByCode("countries",
                                    participant.getParticipantCountry(), null));
                    user.setCountry(userCountry);
                    user.setParticipantId(participant.getParticipantId());
                }
            } else {
                throw new UserException(checkUserExistsErrorCode,
                        checkUserExistsErrorMessage);
            }

        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException();
        }

        return user;
    }

    /**
     * This is for checking user exists or not by taking orcidId as input.
     *
     * @param orcidId
     *            the orcid id
     * @return true, if successful
     */
    @Override
    public final User searchUserByOrcidId(final String orcidId) {
        LOGGER.info("inside isUserFoundWithOrcidId() method of RegistrationServiceImpl");
        User user = null;
        if (!StringUtils.isEmpty(orcidId)) {
            Participant participant = participantInterfaceService
                    .searchParticipantByOrcidId(orcidId);
            if (!StringUtils.isEmpty(participant)) {
                LOGGER.info("if user with orcid found in participant then return the User");
                user = new User();
                user.setOrcidId(orcidId);
                user.setParticipantId(participant.getParticipantId());
                user.setPrimaryEmailAddr(participant.getUserName());
                user.setUserId(participant.getUserId());
            }
        }
        return user;
    }

    /**
     * This is for searchInvitationRecord or not by taking guid as input.
     *
     * @param participantId
     *            the participant id
     * @return the invite records
     */
    @Override
    public final User searchInvitationRecord(final String participantId) {

        Participant participant = participantInterfaceService
                .searchParticipantByParticipantId(participantId);
        User user = null;
        if (!StringUtils.isEmpty(participant)) {
            user = new User();
            user.setFirstName(participant.getGivenName());
            user.setLastName(participant.getFamilyName());
            Country userCountry = new Country();
            userCountry.setCountryCode(participant.getParticipantCountry());
            userCountry.setCountryName(autoCompleteService.getNameByCode(
                    "countries", participant.getParticipantCountry(), null));
            user.setCountry(userCountry);
            user.setInvited(true);
            user.setPrimaryEmailAddr(participant.getEmail());
        }
        return user;
    }

    /**
     * Creates the alm user.
     *
     * @param user
     *            the user
     * @return the string
     */
    @Override
    public final String createALMUser(final User user) {

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
                RegistrationDetails registrationDetails = new RegistrationDetails();
                registrationDetails.setAlmUserId(almUserId);
                ObjectWriter ow = new ObjectMapper().writer()
                        .withDefaultPrettyPrinter();
                String registrationJson = ow.writeValueAsString(user);
                registrationDetails.setRegistrastionObject(registrationJson
                        .getBytes());

                registrationServiceDAO
                        .createRegistrationRecord(registrationDetails);

            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(createUserErrorCode, createUserErrorMessage);
        }

        return almUserId;
    }

    /**
     * Do final create.
     *
     * @param almUserId
     *            the alm user id
     * @param sendEmailFlag
     *            the send email flag
     * @return the string
     */
    @Override
    public String doFinalCreate(final String almUserId,
            final String sendEmailFlag) {

        String status = null;
        try {
            User user = returnUserFromDB(almUserId);
            user.setUserId(almUserId);
            user.setSendEmailFlag(sendEmailFlag);
            String ptpId = createParticipant(user);
            if (!StringUtils.isEmpty(ptpId)) {
                ALMUser almUser = new ALMUser();
                almUser.setEmail(user.getPrimaryEmailAddr());
                almUser.setTcFlag(AuthorServicesConstants.AS_ALM_TNC_FLAG);
                almUser.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
                almInterfaceService.updateUser(almUser);
                user.setParticipantId(ptpId);
                createContact(user);
                status = "SUCCESS";
            } else {
                throw new UserException(createUserErrorCode,
                        createUserErrorMessage);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(createUserErrorCode, createUserErrorMessage);
        }
        return status;
    }

    /**
     * Creates the participant.
     *
     * @param user
     *            the user
     * @return the string
     */
    private String createParticipant(final User user) {

        String ptpId = null;

        Participant participant = new Participant();

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        participant.setCreatedDate(dt.format(new Date()));
        participant.setFamilyName(user.getLastName());
        participant.setGivenName(user.getFirstName());
        participant.setModifiedDate(dt.format(new Date()));
        participant.setParticipantCountry(user.getCountryCode());
        participant.setUserId(user.getUserId());

        ptpId = participantInterfaceService.createParticipant(participant);
        if (!StringUtils.isEmpty(ptpId)) {
            registrationServiceDAO.deleteRegistrationDetails(user.getUserId());
        } else {
            throw new UserException(createUserErrorCode, createUserErrorMessage);
        }

        return ptpId;
    }

    /**
     * Creates the contact.
     *
     * @param user
     *            the user
     * @return the string
     */
    private String createContact(final User user) {
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
        cdmUser.setSendEmail(user.getSendEmailFlag());
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
     * @param almUserIdEncrypted
     *            the alm user id encrypted
     */
    @Override
    public final void verifyAccount(final String almUserIdEncrypted) {
        try {
            User user = returnUserFromDB(AuthorServicesUtil
                    .decrypt(almUserIdEncrypted));

            List<ALMUser> almUserList = almInterfaceService
                    .searchUser(user.getPrimaryEmailAddr()).getUserPayload()
                    .getUserPayload();
            if (!StringUtils.isEmpty(almUserList)) {
                for (ALMUser almUser : almUserList) {
                    if (almUser.getEmail().equals(user.getPrimaryEmailAddr())) {
                        String userStatus = almUser.getUserStatus();
                        verifyAccountChecking(almUser, userStatus);
                    } else {
                        throw new ASException(noUserFoundErrorCode,
                                noUserFoundErrorMessage);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException(noUserFoundErrorCode, noUserFoundErrorMessage);
        }

    }

    /**
     * Verify account checking.
     *
     * @param almUser
     *            the alm user
     * @param userStatus
     *            the user status
     */
    private void verifyAccountChecking(final ALMUser almUser,
            final String userStatus) {
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
            String userStatusString = null;
            userStatusString = AuthorServicesConstants.VERIFY_ACCOUNT_ACTIVE;
            almUser.setUserStatus(userStatusString);
            almInterfaceService.updateUser(almUser);
        }
    }

    /**
     * Resend verification.
     *
     * @param emailId
     *            the email id
     * @return the string
     */
    @Override
    public String resendVerification(final String emailId) {

        Notifications notifications = sharedService
                .searchInvitationRecord(emailId);
        String status = null;
        if (!StringUtils.isEmpty(notifications)) {
            status = notificationService.resendNotification(
                    notifications.getId().toString()).getStatus();
        }

        return status;
    }

    /**
     * Return user from db.
     *
     * @param almUserId
     *            the alm user id
     * @return the user
     * @throws JsonParseException
     *             the json parse exception
     * @throws JsonMappingException
     *             the json mapping exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private User returnUserFromDB(final String almUserId)
            throws JsonParseException, JsonMappingException, IOException {

        RegistrationDetails registrationDetails = registrationServiceDAO
                .getRegistrationRecord(almUserId);

        User user = null;

        if (!StringUtils.isEmpty(registrationDetails)) {
            user = new ObjectMapper().readValue(
                    registrationDetails.getRegistrastionObject(), User.class);
        }

        return user;
    }

    /**
     * Update participant.
     *
     * @param user
     *            the user
     * @return the string
     * @throws UserException
     *             the user exception
     */
    @Override
    public void updateParticipant(final User user) throws UserException {
        Participant participant = new Participant();

        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        participant.setCreatedDate(dt.format(new Date()));
        participant.setFamilyName(user.getLastName());
        participant.setGivenName(user.getFirstName());
        participant.setModifiedDate(dt.format(new Date()));
        participant.setParticipantCountry(user.getCountryCode());
        participant.setUserId(user.getUserId());

        participantInterfaceService.updateParticipant(participant);
    }

}
