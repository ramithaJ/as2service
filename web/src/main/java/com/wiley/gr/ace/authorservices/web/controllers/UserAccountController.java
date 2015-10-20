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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.AddressData;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.UserAccountService;

/**
 * The Class UserAccountController.
 *
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/userAccount")
public class UserAccountController {

    /**
     * Logger for UserAccountController class.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserAccountController.class);

    /**
     * Injecting userAccountService bean.
     */
    @Autowired
    private UserAccountService userAccountService;

    /**
     * Injecting AuthorProfileService.
     */
    @Autowired
    private AuthorProfileService authorProfileService;

    /** The user addresses error code. */
    @Value("${UserAccountController.userAddresses.code}")
    private String userAddressesErrorCode;

    /** The user addresses error message. */
    @Value("${UserAccountController.userAddresses.message}")
    private String userAddressesErrorMessage;

    /**
     * Method to get the user Account information.
     *
     * @param userId
     *            - The request value
     * @return Service - Success/Failure
     */
    @RequestMapping(value = "/profileInfo/{userId}", method = RequestMethod.GET)
    public final Service getProfileInformation(
            @PathVariable("userId") final String userId) {
        UserAccountController.LOGGER
                .info("inside getProfileInformation method");
        final Service service = new Service();
        service.setPayload(userAccountService.getProfileInformation(userId));
        return service;

    }

    /**
     * Method to update user Account information.
     *
     * @param userId
     *            - The request value
     * @param user
     *            - object having user Account information.
     * @return Service - Success/Failure
     */
    @RequestMapping(value = "/profileInfo/{userId}", method = RequestMethod.POST)
    public final Service updateProfileInformation(
            @PathVariable("userId") final String userId,
            @RequestBody final User user) {
        UserAccountController.LOGGER
                .info("inside updateProfileInformation method");
        authorProfileService.updateUserProfileInfo(userId, user);

        return new Service();

    }

    /**
     * Method to get user Email Details.
     *
     * @param userId
     *            - The request value
     * @return Service - Success/Failure
     */
    @RequestMapping(value = "/emailDetails/{userId}", method = RequestMethod.GET)
    public final Service getEmailDetails(
            @PathVariable("userId") final String userId) {
        UserAccountController.LOGGER.info("inside getEmailDetails method");
        final Service service = new Service();
        service.setPayload(userAccountService.getEmailDetails(userId));
        return service;
    }

    /**
     * Method to update user Email Details.
     *
     * @param userId
     *            - The request value
     * @param emailDetails
     *            - object having user Email Details.
     * @return Service - Success/Failure
     */
    @RequestMapping(value = "/emailDetails/{userId}", method = RequestMethod.POST)
    public final Service updateEmail(
            @PathVariable("userId") final String userId,
            @RequestBody final User emailDetails) {
        UserAccountController.LOGGER.info("inside updateEmail method");
        authorProfileService.updateEmailDetails(userId, emailDetails);
        return new Service();
    }

    /**
     * Gets the user addresses.
     *
     * @param userId
     *            the user id
     * @return the user addresses
     */
    @RequestMapping(value = "/userAddresses/{userId}", method = RequestMethod.GET)
    public final Service getUserAddresses(
            @PathVariable("userId") final String userId) {
        UserAccountController.LOGGER.info("inside getUserAddresses method");
        Service service = new Service();
        try {
            service.setPayload(userAccountService.getUserAddress(userId));
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(userAddressesErrorCode,
                    userAddressesErrorMessage);
        }
        return service;
    }

    /**
     * Update user addresses.
     *
     * @param userId
     *            the user id
     * @param address
     *            the address
     * @return the service
     */
    @RequestMapping(value = "/userAddresses/{userId}", method = RequestMethod.POST)
    public final Service updateUserAddresses(
            @PathVariable("userId") final String userId,
            @RequestBody final AddressData address) {
        UserAccountController.LOGGER.info("inside updateUserAddresses method");
        Object result = null;
        boolean isUpdated;
        Service service = new Service();
        try {
            result = userAccountService.updatAddress(userId, address);
            if (result instanceof Boolean) {
                isUpdated = (boolean) result;
                if (isUpdated) {
                    service.setStatus(AuthorServicesConstants.SUCCESS);
                    service.setPayload(isUpdated);
                } else {
                    service.setStatus(AuthorServicesConstants.FAILURE);
                    service.setPayload(isUpdated);
                }
            } else if (result instanceof List) {
                service.setStatus(AuthorServicesConstants.FAILURE);
                service.setPayload(result);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(userAddressesErrorCode,
                    userAddressesErrorMessage);
        }

        return service;
    }

    /**
     * Method to update user Security Details.
     *
     * @param securityDetails
     *            - Object having user Security questions and answers.
     * @return Service - Success/Failure
     */
    @RequestMapping(value = "/secutiryDetails/update", method = RequestMethod.POST)
    public final Service updateSecurityDetails(
            @RequestBody final SecurityDetailsHolder securityDetails) {
        UserAccountController.LOGGER
                .info("inside updateSecurityDetails method");
        authorProfileService.updateSecurityDetails(securityDetails);
        return new Service();

    }

    /**
     * Removes the orcid id.
     *
     * @param userId
     *            - input
     * @return service
     */
    @RequestMapping(value = "/orcid/remove/{userId}", method = RequestMethod.DELETE)
    public final Service removeOrcidId(
            @PathVariable("userId") final String userId) {

        authorProfileService.removeOrcidId(userId);
        return new Service();
    }
}
