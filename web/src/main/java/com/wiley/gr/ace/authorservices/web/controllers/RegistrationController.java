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

import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.InviteRecords;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

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

    /**
     * the value of noDataFoundCode.
     */
    @Value("${noDataFound.code}")
    private int noDataFoundCode;

    /**
     * @param email
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/verify/email", method = RequestMethod.GET)
    public final Service checkUserExists(@RequestHeader final String email) {

        Service service = new Service();
        User user = null;
        try {
            if (!StringUtils.isEmpty(email)) {
                user = rs.checkEmailIdExists(email);
            } else {
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(noDataFoundCode);
                err.setMessage("Email is null or empty");
                service.setStatus("FAILURE");
                service.setError(err);
            }
            if (user != null) {
                service.setStatus("FAILURE");
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(noDataFoundCode);
                err.setMessage("Email address exists in the system but not registered with AS 2.0");
                service.setError(err);
                service.setPayload(user);

            } else {
                service.setStatus("SUCCESS");
            }
        } catch (Exception e) {
            LOGGER.error("Print Stack Trace- ", e);
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(noDataFoundCode);
            err.setMessage("searching user encountered exception");
            service.setStatus("ERROR");
            service.setError(err);
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
        if (null != user) {
            try {

                if (user.isSearchFullName()) {
                    List<User> usersList = null;
                    usersList = rs.getUserFromFirstNameLastName(
                            user.getFirstName(), user.getLastName());
                    if (null != usersList) {
                        service.setStatus("FAILURE");
                        ErrorPOJO err = new ErrorPOJO();
                        err.setCode(noDataFoundCode);
                        err.setMessage("First Name and Last Name already exists");
                        service.setError(err);
                        service.setPayload(usersList);
                        return service;
                    }
                }
                status = rs.createUser(user);
                if ("success".equalsIgnoreCase(status)) {
                    rs.assignRoleToNewUser(user.getPrimaryEmailAddr());
                } else {
                    service.setStatus("FAILURE");
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode(noDataFoundCode);
                    err.setMessage("Creating user failed");
                    service.setError(err);
                }
            } catch (Exception e) {

                LOGGER.error("Stack Trace", e);
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(noDataFoundCode);
                err.setMessage("searching user encountered exception");
                service.setStatus("ERROR");
                service.setError(err);
            }

        } else {
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(noDataFoundCode);
            err.setMessage("User object is empty");
            service.setStatus("FAILURE");
            service.setError(err);
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
