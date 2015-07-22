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

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.ASRolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserLogin;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;

/**
 * This method takes email in encrypted format like 
 * 
 */
/**
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/admin")
public class AdminLoginController extends ASExceptionController {

    /**
     * Logger Configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AdminLoginController.class);
    /** Error code From Props File. */
    @Value("${adminnotexist.code}")
    private String errorcode;
    /** Error message From Props File. */
    @Value("${adminnotexist.message}")
    private String errormessage;
    /** getting bean of adminlogin service. */
    @Autowired(required = true)
    private AdminLoginService adminLoginService;

    /**
     * @param request
     *            the request
     * @return service
     */
    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public final Service login(final HttpServletRequest request) {
        LOGGER.info("Inside Login Method");
        String emailId = (String) request.getAttribute("emailId");
        Service service = new Service();
        if (adminLoginService.validateEmail(emailId)) {

            Users users = adminLoginService.doLogin(emailId);
            LOGGER.debug(users.getUserId() + "Geeting User id from dologin");
            UserLogin userLogin = new UserLogin();
            userLogin.setUserId(users.getUserId());
            userLogin.setFirstName(users.getFirstName());
            userLogin.setLastName(users.getLastName());
            service.setPayload(userLogin);
        } else {
            throw new ASException(errorcode, errormessage);
        }
        return service;
    }

    /**
     * @param emailId
     *            - the request value
     * @param accessId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/requestAccess/{emailId}/{accessId}/", method = RequestMethod.POST)
    public final Service requestAccess(
            @PathVariable("emailId") final String emailId,
            @PathVariable("accessId") final String accessId) {
        LOGGER.info("inside requestAccess Method");
        return new Service();

    }

    /**
     * @param admin
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public final Service createAdmin(@RequestBody final AdminUser admin) {
        LOGGER.info("inside create Admin");
        adminLoginService.createAdmin(admin);
        return new Service();

    }

    /**
     * @return service
     */
    @RequestMapping(value = "/permissions/", method = RequestMethod.GET)
    public final Service getPermissions() {
        LOGGER.info("Inside Get Permission");
        Service service = new Service();
        service.setPayload(adminLoginService.getRolesAndPermissions(null));
        return service;
    }

    /**
     * @param roleId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/permissions/{roleId}", method = RequestMethod.GET)
    public final Service getPermissionsForRole(
            @PathVariable("roleId") final String roleId) {
        LOGGER.info("Inside Get getPermissionsForRole");
        Service service = new Service();
        service.setPayload(adminLoginService.getRolesAndPermissions(roleId));
        return service;
    }

    /**
     * @param rolesAndPermissions
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/permissions/", method = RequestMethod.POST)
    public final Service addOrUpdateUserRole(
            @RequestBody final ASRolesAndPermissions rolesAndPermissions) {
        LOGGER.info("Inside Get addOrUpdateUserRole");
        adminLoginService.addOrUpdateUserRole(rolesAndPermissions);
        return new Service();

    }

    /**
     * @param emailId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/findUser/{emailId}/", method = RequestMethod.GET)
    public final Service findUser(@PathVariable("emailId") final String emailId) {
        LOGGER.info("Inside Get findUser");
        Service service = new Service();
        // check if user exists, if yes return that data
        service.setPayload(adminLoginService.findUser(emailId));
        return service;

    }
}
