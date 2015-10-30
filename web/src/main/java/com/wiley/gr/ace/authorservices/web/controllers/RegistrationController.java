/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.external.util.AuthorServicesUtil;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.SendNotificationRequest;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.SharedServieRequest;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserLogin;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;
import com.wiley.gr.ace.authorservices.services.service.SendNotification;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * The Class RegistrationController.
 *
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {

    /**
     * The Constant LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RegistrationController.class);

    /**
     * The registration service.
     */
    @Autowired(required = true)
    private RegistrationService registrationService;

    /**
     * The user login service.
     */
    @Autowired(required = true)
    private UserLoginService userLoginService;

    /**
     * The send notification.
     */
    @Autowired(required = true)
    private SendNotification sendNotification;
    /**
     * the value of noDataFoundCode.
     */
    @Value("${noDataFound.code}")
    private String noDataFoundCode;

    @Value("${noDataFound.message}")
    private String noDataFoundMessage;

    /**
     * value from props file configured.
     */

    @Value("${RegistrationController.getInvitationRecords.code}")
    private String getInvitationRecordsErrorCode;
    /**
     * value from props file configured.
     */

    @Value("${RegistrationController.getInvitationRecords.message}")
    private String getInvitationRecordsErrorMessage;

    /**
     * value from props file configured.
     */
    @Value("${RegistrationController.createUser.code}")
    private String createUserErrorCode;

    /**
     * value from props file configured.
     */
    @Value("${RegistrationController.createUser.message}")
    private String createUserErrorMessage;

    /**
     * value from props file configured.
     */
    @Value("${RegistrationController.createUserDetails.code}")
    private String createUserDetailsErrorCode;

    /**
     * value from props file configured.
     */
    @Value("${RegistrationController.createUserDetails.message}")
    private String createUserDetailsErrorMessage;

    /**
     * value from props file configured.
     */
    @Value("${RegistrationController.isUserFoundWithOrcidId.code}")
    private String isUserFoundWithOrcidIdErrorCode;

    /**
     * value from props file configured.
     */
    @Value("${RegistrationController.isUserFoundWithOrcidId.message}")
    private String isUserFoundWithOrcidIdErrorMessage;

    /**
     * The success.
     */
    @Value("${SUCCESS}")
    private String success;

    /**
     * This field holds the value of LOCKED.
     */
    @Value("${LOCKED}")
    private String locked;

    /**
     * This field holds the value of FAILURE.
     */
    @Value("${FAILURE}")
    private String failure;

    /**
     * This field holds the value of AuthorServices.
     */
    @Value("${AuthorServices}")
    private String authorServices;

    /**
     * This field holds the value of AuthenticationType.
     */
    @Value("${AuthenticationType}")
    private String authenticationType;

    @Value("${verify.account-url}")
    private String verifyAccountUrl;

    /**
     * Check user exists.
     *
     * @param user
     *            the user
     * @return the service
     */
    @RequestMapping(value = "/verify/email", method = RequestMethod.POST)
    public final Service checkUserExists(@RequestBody final User user) {

        Service service = new Service();
        User retrievedUser = null;
        User foundUserToReturn = null;

        if (!StringUtils.isEmpty(user.getPrimaryEmailAddr())) {
            LOGGER.debug("checking if user with email id "
                    + user.getPrimaryEmailAddr()
                    + " is existing in ALM or invitee records");
            retrievedUser = registrationService.checkEmailIdExists(user
                    .getPrimaryEmailAddr());
        }
        if (!StringUtils.isEmpty(retrievedUser)) {
            System.err.println(retrievedUser);
            foundUserToReturn = new User();
            if (retrievedUser.getFirstName().equalsIgnoreCase(
                    user.getFirstName())
                    && retrievedUser.getLastName().equalsIgnoreCase(
                            user.getLastName())) {
                foundUserToReturn.setInvited(true);
                foundUserToReturn.setParticipantId(retrievedUser
                        .getParticipantId());
                service.setStatus(AuthorServicesConstants.SUCCESS);
                service.setPayload(foundUserToReturn);
            } else {
                LOGGER.info("Pre-populating user data");
                foundUserToReturn.setFirstName(retrievedUser.getFirstName());
                foundUserToReturn.setLastName(retrievedUser.getLastName());
                foundUserToReturn.setInvited(true);
                foundUserToReturn.setParticipantId(retrievedUser
                        .getParticipantId());
                foundUserToReturn
                        .setCountryCode(retrievedUser.getCountryCode());
                ErrorPOJO err = new ErrorPOJO();
                err.setCode("PREPOP_INVITE_DETAILS");
                err.setMessage("PREPOP_INVITE_DETAILS");
                service.setStatus(AuthorServicesConstants.SUCCESS);
                service.setPayload(user);
                service.setError(err);
            }
        }
        return service;
    }

    /**
     * Gets the invitation records.
     *
     * @param encryptedId
     *            the encrypted id
     * @return the invitation records
     */
    @RequestMapping(value = "/invitation/{encryptedId}", method = RequestMethod.GET)
    public final Service getInvitationRecords(
            @PathVariable("guid") final String encryptedId) {
        Service service = new Service();
        String participantId = null;
        User user = null;
        try {
            participantId = AuthorServicesUtil.decrypt(encryptedId);
            LOGGER.info("Searching invitation records");
            user = registrationService.searchInvitationRecord(participantId);
            if (!StringUtils.isEmpty(user)) {
                service.setStatus(AuthorServicesConstants.SUCCESS);
                service.setPayload(user);
            } else {
                throw new UserException(getInvitationRecordsErrorCode,
                        getInvitationRecordsErrorMessage);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(getInvitationRecordsErrorCode,
                    getInvitationRecordsErrorMessage);
        }
        return service;
    }

    /**
     * @param service
     * @param user
     */
    private boolean isSearchFullName(Service service, final User user) {
        boolean executeCreate = true;
        LOGGER.info("Searching if any user exist with the same firstname and lastname");
        service = new Service();
        List<User> usersList = null;
        if (!StringUtils.isEmpty(user.getFirstName())
                && !StringUtils.isEmpty(user.getLastName())) {
            usersList = registrationService.getUserFromFirstNameLastName(
                    user.getFirstName(), user.getLastName());
        }

        if (!usersList.isEmpty()) {
            LOGGER.info("List of users found with the same firstname and lastname");
            service.setStatus(AuthorServicesConstants.FAILURE);
            service.setPayload(usersList);
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(AuthorServicesConstants.LIST_OF_USER_FOUND);
            err.setMessage("List of users found. Please select or continue");
            service.setPayload(usersList);
            service.setError(err);
            executeCreate = false;
        }

        return executeCreate;
    }

    /**
     * @param user
     * @param userId
     */
    private void isUserNotInvited(final User user, final String userId) {
        LOGGER.info("Sending verification email to user as user is not invited");
        SendNotificationRequest notificationRequest = new SendNotificationRequest();
        List<String> fieldList = new ArrayList<String>();
        fieldList.add(user.getFirstName() + " " + user.getLastName());
        fieldList.add(verifyAccountUrl);
        // Uncomment the below line for implementing encryption
        // fieldList.add(AuthorServicesUtil.encrypt(userId));
        fieldList.add(userId);
        notificationRequest.setFieldList(fieldList);
        notificationRequest.setFrom("admin@wiley.com");
        List<String> toList = new ArrayList<String>();
        toList.add(user.getPrimaryEmailAddr());
        notificationRequest.setToList(toList);

        sendNotification.sendEmail("24", "113", "email", notificationRequest);
    }

    /**
     * @param service
     * @param user
     * @param userId
     */
    private void isUserInvited(final Service service, final User user,
            final String userId) {
        LOGGER.info("User is invited, authenticating the user");
        user.setUserId(userId);
        registrationService.updateParticipant(user);
        SharedServieRequest loginSharedServieRequest = new SharedServieRequest();
        Login invitedLogin = new Login();
        invitedLogin.setEmailId(user.getPrimaryEmailAddr());
        invitedLogin.setPassword(user.getPassword());
        loginSharedServieRequest.setUserId(invitedLogin.getEmailId());
        loginSharedServieRequest.setPassword(invitedLogin.getPassword());
        loginSharedServieRequest.setAuthenticationType(authenticationType);
        loginSharedServieRequest.setAppKey(authorServices);

        SecurityResponse loginSecurityResponse = userLoginService.login(
                invitedLogin, loginSharedServieRequest);
        String status = loginSecurityResponse.getStatus();
        if (locked.equalsIgnoreCase(status) || failure.equalsIgnoreCase(status)) {
            service.setStatus(failure);
            ErrorPOJO errorPOJO = new ErrorPOJO();
            errorPOJO.setCode(loginSecurityResponse.getCode());
            errorPOJO.setMessage(loginSecurityResponse.getMessage());
            service.setError(errorPOJO);
        } else if (success.equals(loginSecurityResponse.getStatus())) {
            UserLogin userLogin = new UserLogin();
            service.setPayload(userLogin);
        }
    }

    /**
     * Creates the user.
     *
     * @param user
     *            the user
     * @return the service
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public final Service createUser(@RequestBody final User user) {
        Service service = null;
        String userId = null;
        if (!StringUtils.isEmpty(user)) {
            boolean executeCreate = true;
            if (user.isSearchFullName()) {
                executeCreate = isSearchFullName(service, user);
            }

            if (executeCreate) {
                LOGGER.info("Creating user in ALM");
                userId = registrationService.createALMUser(user);

                if (!StringUtils.isEmpty(userId)) {
                    if (!user.isInvited()) {
                        isUserNotInvited(user, userId);
                    } else {
                        isUserInvited(service, user, userId);
                    }

                } else {

                    throw new UserException(createUserErrorCode,
                            createUserErrorMessage);
                }

            }
        } else {
            throw new UserException(createUserDetailsErrorCode,
                    createUserDetailsErrorMessage);
        }

        return new Service();
    }

    /**
     * Checks if is user found with orcid id.
     *
     * @param orcidId
     *            the orcid id
     * @return the service
     */
    @RequestMapping(value = "/search/orcid/{orcidId}", method = RequestMethod.GET)
    public final Service isUserFoundWithOrcidId(
            @PathVariable("orcidId") final String orcidId) {
        LOGGER.info("inside isUserFoundWithOrcidId() method of RegistrationController");
        Service service = new Service();
        if (!StringUtils.isEmpty(orcidId)) {
            try {
                User user = registrationService.searchUserByOrcidId(orcidId);
                if (!StringUtils.isEmpty(user)) {
                    LOGGER.info("User has already orcid Id");
                    service.setStatus(AuthorServicesConstants.FAILURE);
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode(isUserFoundWithOrcidIdErrorCode);
                    err.setMessage(isUserFoundWithOrcidIdErrorMessage);
                    service.setError(err);
                    service.setPayload(user);
                } else {
                    LOGGER.info("User has No orcid Id");
                    service.setStatus(AuthorServicesConstants.SUCCESS);
                }
            } catch (Exception e) {
                LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
                throw new UserException(isUserFoundWithOrcidIdErrorCode,
                        isUserFoundWithOrcidIdErrorMessage);
            }
        } else {
            LOGGER.info("Send valid ORCID Id");
            service.setStatus(AuthorServicesConstants.FAILURE);
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(noDataFoundCode);
            err.setMessage(noDataFoundMessage);
            service.setError(err);
        }
        return service;
    }

    /**
     * Verify account.
     *
     * @param almUserIdEncrypted
     *            the alm user id encrypted
     * @return the service
     */
    @RequestMapping(value = "verifyAccount/{almUserIdEncrypted}", method = RequestMethod.GET)
    public final Service verifyAccount(
            @PathVariable("almUserIdEncrypted") final String almUserIdEncrypted) {
        LOGGER.info("Verifying user in AS");
        registrationService.verifyAccount(almUserIdEncrypted);
        return new Service();
    }

    /**
     * Creates the participant and contact.
     *
     * @param user
     *            the user
     * @return the service
     */
    @RequestMapping(value = "/createFinal", method = RequestMethod.POST)
    public final Service createParticipantAndContact(
            @RequestBody final User user) {

        LOGGER.info("Creating participant and contact");
        registrationService.doFinalCreate(user.getUserId(),
                user.getSendEmailFlag());

        return new Service();
    }

    /**
     * Resend verification mail.
     *
     * @param user
     *            the user
     * @return the service
     */
    @RequestMapping(value = "/verify/resend", method = RequestMethod.POST)
    public final Service resendVerificationMail(@RequestBody final User user) {
        try {
            String status = registrationService.resendVerification(user
                    .getPrimaryEmailAddr());
            if ("failure".equalsIgnoreCase(status)) {
                throw new UserException(
                        "REGISTRATION_RESEND_VER_FAIL_ERR_TEXT",
                        "Resend verification email failed");
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException("REGISTRATION_RESEND_VER_FAIL_ERR_TEXT",
                    "Resend verification email failed");
        }

        return new Service();
    }
}
