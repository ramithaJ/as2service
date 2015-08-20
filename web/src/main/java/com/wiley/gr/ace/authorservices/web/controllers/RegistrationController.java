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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.InviteRecords;
import com.wiley.gr.ace.authorservices.model.SendNotificationRequest;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
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
    /* public static final Logger LOGGER = Logger
            .getLogger(RegistrationController.class.getName());*/

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
    @Value("${RegistrationController.checkUserExists.code}")
    private String checkUserExistsErrorCode;

    /** value from props file configured. */
    @Value("${RegistrationController.checkUserExists.message}")
    private String checkUserExistsErrorMessage;

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

    /**
     * Check user exists.
     *
     * @param email
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/verify/email", method = RequestMethod.GET)
    public final Service checkUserExists(@RequestHeader final String email) {

        Service service = new Service();
        User user = null;

        if (!StringUtils.isEmpty(email)) {
            // LOGGER.info("checking if user exists with email id " + email);
            user = registrationService.checkEmailIdExists(email);
        }
        if (user != null) {
            //LOGGER.info("user found with email id " + email);
            if ("ALM".equalsIgnoreCase(user.getFoundIn())) {
                service.setStatus("FAILURE");
                service.setPayload(user);
                ErrorPOJO err = new ErrorPOJO();
                err.setCode("USER_EXISTS_NOT_REGISTERED");
                err.setMessage("User exists in the system but not "
                        + "registered with AS2.0. Please enter correct password to register");
                service.setError(err);
            } else {
                //  LOGGER.error("User exists in AS");
                throw new UserException(checkUserExistsErrorCode,
                        checkUserExistsErrorMessage);
            }
        }

        return service;
    }

    /**
     * Gets the invitation records.
     *
     * @param guid
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/invitation/{guid}", method = RequestMethod.GET)
    public final Service getInvitationRecords(
            @PathVariable("guid") final String guid) {
        Service service = new Service();
        InviteRecords inviteRecords = null;
        if (!StringUtils.isEmpty(guid)) {
            try {
                inviteRecords = registrationService
                        .searchInvitationRecord(guid);
                if (!StringUtils.isEmpty(inviteRecords)) {
                    if ("PENDING".equalsIgnoreCase(inviteRecords.getStatus())) {
                        service.setPayload(inviteRecords);
                    } else {
                        service.setStatus("FAILURE");
                        ErrorPOJO err = new ErrorPOJO();
                        err.setCode(noDataFoundCode);
                        err.setMessage("User Already Registered");
                        service.setError(err);
                    }
                } else {
                    service.setStatus("FAILURE");
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode(noDataFoundCode);
                    err.setMessage("Invitation record does not exist");
                    service.setError(err);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new UserException(getInvitationRecordsErrorCode,
                        getInvitationRecordsErrorMessage);
            }
        }
        return service;
    }

    /**
     * Creates the user.
     *
     * @param user
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public final Service createUser(@RequestBody final User user) {
        Service service = new Service();
        String status = null;
        boolean executeCreate = true;
        if (null != user) {

            if (user.isSearchFullName()) {
                ArrayList<User> usersList = null;
                usersList = registrationService.getUserFromFirstNameLastName(
                        user.getFirstName(), user.getLastName());
                if (null != usersList) {
                    service.setStatus("SUCCESS");
                    service.setPayload(usersList);
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode("LIST_OF_USER_FOUND");
                    err.setMessage("List of users found. Please select or continue");
                    service.setPayload(usersList);
                    executeCreate = false;
                }
            }

            if (executeCreate) {
                status = registrationService.createUser(user);
                if ("success".equalsIgnoreCase(status)) {
                    registrationService.assignRoleToNewUser(user
                            .getPrimaryEmailAddr());
                    String verifyGuid = userLoginService.insertGuid(
                            user.getFirstName(), user.getLastName(),
                            user.getPrimaryEmailAddr());
                    if (!StringUtils.isEmpty(verifyGuid)) {
                        SendNotificationRequest notificationRequest = new SendNotificationRequest();
                        List<String> fieldList = new ArrayList<String>();
                        fieldList.add(user.getFirstName() + user.getLastName());
                        fieldList.add(verifyGuid);
                        notificationRequest.setFieldList(fieldList);
                        notificationRequest.setFrom("admin@wiley.com");
                        notificationRequest.setTo(user.getPrimaryEmailAddr());

                        sendNotification.sendEmail("24", "113", "email",
                                notificationRequest);
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

        return service;
    }

    /**
     * Checks if is user found with orcid id.
     *
     * @param orcidId
     *            - The request value
     * @return service
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
}
