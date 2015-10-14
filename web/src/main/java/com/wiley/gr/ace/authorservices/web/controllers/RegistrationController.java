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
package com.wiley.gr.ace.authorservices.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    /** The Constant LOGGER. */
    /*
     * public static final Logger LOGGER = Logger
     * .getLogger(RegistrationController.class.getName());
     */

    /** The registration service. */
    @Autowired(required = true)
    private RegistrationService registrationService;

    /** The user login service. */
    @Autowired(required = true)
    private UserLoginService userLoginService;

    /** The send notification. */
    @Autowired(required = true)
    private SendNotification sendNotification;
    /**
     * the value of noDataFoundCode.
     */
    @Value("${noDataFound.code}")
    private String noDataFoundCode;

    /** value from props file configured. */

    @Value("${RegistrationController.getInvitationRecords.code}")
    private String getInvitationRecordsErrorCode;
    /** value from props file configured. */

    @Value("${RegistrationController.getInvitationRecords.message}")
    private String getInvitationRecordsErrorMessage;

    /** value from props file configured. */
    @Value("${RegistrationController.createUser.code}")
    private String createUserErrorCode;

    /** value from props file configured. */
    @Value("${RegistrationController.createUser.message}")
    private String createUserErrorMessage;

    /** value from props file configured. */
    @Value("${RegistrationController.createUserDetails.code}")
    private String createUserDetailsErrorCode;

    /** value from props file configured. */
    @Value("${RegistrationController.createUserDetails.message}")
    private String createUserDetailsErrorMessage;

    /** value from props file configured. */
    @Value("${RegistrationController.isUserFoundWithOrcidId.code}")
    private String isUserFoundWithOrcidIdErrorCode;

    /** value from props file configured. */
    @Value("${RegistrationController.isUserFoundWithOrcidId.message}")
    private String isUserFoundWithOrcidIdErrorMessage;

    /** The success. */
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
            retrievedUser = registrationService.checkEmailIdExists(user
                    .getPrimaryEmailAddr());
        }
        if (!StringUtils.isEmpty(retrievedUser)) {
            foundUserToReturn = new User();
            if (retrievedUser.getFirstName().equalsIgnoreCase(
                    user.getFirstName())
                    && retrievedUser.getLastName().equalsIgnoreCase(
                            user.getLastName())) {
                foundUserToReturn.setInvited(true);
                foundUserToReturn.setParticipantId(retrievedUser
                        .getParticipantId());
                service.setStatus("SUCCESS");
                service.setPayload(foundUserToReturn);
            } else {
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
                service.setStatus("SUCCESS");
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
            user = registrationService.searchInvitationRecord(participantId);
            if (!StringUtils.isEmpty(user)) {
                service.setStatus("SUCCESS");
                service.setPayload(user);
            } else {
                throw new UserException(getInvitationRecordsErrorCode,
                        getInvitationRecordsErrorMessage);
            }
        } catch (Exception e) {
            throw new UserException(getInvitationRecordsErrorCode,
                    getInvitationRecordsErrorMessage);
        }
        return service;
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
        if (null != user) {
            boolean executeCreate = true;
            if (user.isSearchFullName()) {
                service = new Service();
                ArrayList<User> usersList = null;
                usersList = registrationService.getUserFromFirstNameLastName(
                        user.getFirstName(), user.getLastName());
                if (!StringUtils.isEmpty(usersList) && usersList.size() > 0) {
                    service.setStatus("FAILURE");
                    service.setPayload(usersList);
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode("LIST_OF_USER_FOUND");
                    err.setMessage("List of users found. Please select or continue");
                    service.setPayload(usersList);
                    service.setError(err);
                    executeCreate = false;
                }
            }

            if (executeCreate) {
                userId = registrationService.createALMUser(user);

                if (!StringUtils.isEmpty(userId)) {
                    if (!user.isInvited()) {
                        SendNotificationRequest notificationRequest = new SendNotificationRequest();
                        List<String> fieldList = new ArrayList<String>();
                        fieldList.add(user.getFirstName() + " "
                                + user.getLastName());
                        fieldList.add(AuthorServicesUtil.encrypt(userId));
                        notificationRequest.setFieldList(fieldList);
                        notificationRequest.setFrom("admin@wiley.com");
                        ArrayList<String> toList = new ArrayList<String>();
                        toList.add(user.getPrimaryEmailAddr());
                        notificationRequest.setToList(toList);

                        sendNotification.sendEmail("24", "113", "email",
                                notificationRequest);
                    } else {
                        user.setUserId(userId);
                        registrationService.updateParticipant(user);
                        SharedServieRequest loginSharedServieRequest = new SharedServieRequest();
                        Login invitedLogin = new Login();
                        invitedLogin.setEmailId(user.getPrimaryEmailAddr());
                        invitedLogin.setPassword(user.getPassword());
                        loginSharedServieRequest.setUserId(invitedLogin
                                .getEmailId());
                        loginSharedServieRequest.setPassword(invitedLogin
                                .getPassword());
                        loginSharedServieRequest
                                .setAuthenticationType(authenticationType);
                        loginSharedServieRequest.setAppKey(authorServices);

                        SecurityResponse loginSecurityResponse = userLoginService
                                .login(invitedLogin, loginSharedServieRequest);
                        String status = loginSecurityResponse.getStatus();
                        if (locked.equalsIgnoreCase(status)
                                || failure.equalsIgnoreCase(status)) {
                            service.setStatus(failure);
                            ErrorPOJO errorPOJO = new ErrorPOJO();
                            errorPOJO.setCode(loginSecurityResponse.getCode());
                            errorPOJO.setMessage(loginSecurityResponse
                                    .getMessage());
                            service.setError(errorPOJO);
                        } else if (success.equals(loginSecurityResponse
                                .getStatus())) {

                            // Users users =
                            // userLoginServiceDAO.getUserId(login.getEmailId());
                            UserLogin userLogin = new UserLogin();
                            // userLogin.setUserId(users.getUserId().intValue());
                            // userLogin.setFirstName(users.getFirstName());
                            // userLogin.setLastName(users.getLastName());
                            service.setPayload(userLogin);
                        }
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

        Service service = new Service();
        if (!StringUtils.isEmpty(orcidId)) {
            try {
                if (registrationService.searchUserByOrcidId(orcidId)) {
                    service.setStatus("FAILURE");
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode(noDataFoundCode);
                    err.setMessage("User already exists with the same ORCID Id");
                    service.setError(err);
                } else {
                    service.setStatus("SUCCESS");
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new UserException(isUserFoundWithOrcidIdErrorCode,
                        isUserFoundWithOrcidIdErrorMessage);
            }
        } else {
            service.setStatus("FAILURE");
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(noDataFoundCode);
            err.setMessage("Please enter ORCID Id");
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
            throw new UserException("REGISTRATION_RESEND_VER_FAIL_ERR_TEXT",
                    "Resend verification email failed");
        }

        return new Service();
    }
}
