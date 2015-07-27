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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {

    /**
     * Logger Configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RegistrationController.class);

    /**
     * Injected RegistrationService bean.
     */
    @Autowired(required = true)
    private RegistrationService rs;

    @Autowired(required = true)
    private UserLoginService uls;

    @Autowired(required = true)
    private SendNotification sendNotification;
    /**
     * the value of noDataFoundCode.
     */
    @Value("${noDataFound.code}")
    private String noDataFoundCode;

    /**
     * @param email
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/verify/email", method = RequestMethod.GET)
    public final Service checkUserExists(@RequestHeader final String email) {

        Service service = new Service();
        User user = null;

        if (!StringUtils.isEmpty(email)) {
            user = rs.checkEmailIdExists(email);
        }
        if (user != null) {
            if ("ALM".equalsIgnoreCase(user.getFoundIn())) {
                service.setStatus("FAILURE");
                service.setPayload(user);
                ErrorPOJO err = new ErrorPOJO();
                err.setCode("USER_EXISTS_NOT_REGISTERED");
                err.setMessage("User exists in the system but not registered with AS2.0");
                service.setError(err);
            } else {
                throw new UserException(
                        "REGISTRATION_PRIMARY_EMAIL_ADDR_EXISTS_AS_PRIMARY_ERR_TEXT",
                        "User is already registered ");
            }
        }

        return service;
    }

    /**
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
                inviteRecords = rs.searchInvitationRecord(guid);
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
                service.setStatus("ERROR");
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(noDataFoundCode);
                err.setMessage("Accessing invitation records encountered exception");
                service.setError(err);
            }
        }
        return service;
    }

    /**
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
                List<User> usersList = null;
                usersList = rs.getUserFromFirstNameLastName(
                        user.getFirstName(), user.getLastName());
                if (null != usersList) {
                    service.setStatus("FAILURE");
                    service.setPayload(usersList);
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode("LIST_OF_USER_FOUND");
                    err.setMessage("List of users found. Please select or continue");
                    service.setPayload(usersList);
                    executeCreate = false;
                }
            }

            if (executeCreate) {
                status = rs.createUser(user);
                if ("success".equalsIgnoreCase(status)) {
                    rs.assignRoleToNewUser(user.getPrimaryEmailAddr());
                    String verifyGuid = uls.insertGuid(user.getFirstName(),
                            user.getLastName(), user.getPrimaryEmailAddr());
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
                    throw new UserException("221", "Creating User Failed");
                }

            }
        } else {
            throw new UserException(noDataFoundCode, "User object is empty");
        }

        return service;
    }

    /**
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
                if (rs.searchUserByOrcidId(orcidId)) {
                    service.setStatus("FAILURE");
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode(noDataFoundCode);
                    err.setMessage("User already exists with the same ORCID Id");
                    service.setError(err);
                } else {
                    service.setStatus("SUCCESS");
                }
            } catch (Exception e) {
                LOGGER.error("Print Stack Trace- ", e);
                service.setStatus("FAILURE");
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(noDataFoundCode);
                err.setMessage("Searching user with ORCID Id encountered exception");
                service.setError(err);
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
