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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.model.ASRolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.RequestAdminAccess;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserLogin;
import com.wiley.gr.ace.authorservices.model.external.TaskServiceRequest;
import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.services.LookUpValuesDAO;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.service.SendNotification;

/**
 * The Class that deals with Admin operations.
 * 
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/admin")
public class AdminLoginController extends ASExceptionController {

    /**
     * This field holds the value of LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AdminLoginController.class);

    /**
     * This field holds the value of errorcode.
     */
    @Value("${adminnotexist.code}")
    private String errorcode;

    /**
     * This field holds the value of errormessage.
     */
    @Value("${adminnotexist.message}")
    private String errormessage;

    /**
     * This field holds the value of adminLoginService.
     */
    @Autowired(required = true)
    private AdminLoginService adminLoginService;

    /**
     * This field holds the value of sendNotification.
     */
    @Autowired(required = true)
    private SendNotification sendNotification;

    /**
     * This field holds the value of lookUpValuesDAO.
     */
    @Autowired(required = true)
    private LookUpValuesDAO lookUpValuesDAO;

    /**
     * This field holds the value of taskService.
     */
    @Autowired(required = true)
    private TaskService taskService;

    /**
     * This field holds the value of templateId.
     */
    @Value("${templateId.password.reset}")
    private String templateId;

    /**
     * This field holds the value of requestAccesslookupKey.
     */
    @Value("${requestAccess.lookupKey}")
    private String requestAccesslookupKey;

    /**
     * @param login
     *            the request
     * @return service
     */
    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public final Service login(@RequestBody final Login login) {
        LOGGER.info("Inside Login Method");
        Service service = new Service();
        final String emailId = login.getEmailId();
        if (adminLoginService.validateEmail(emailId)) {
                UserLogin userLogin = new UserLogin();
             service.setPayload(userLogin);
        } else {
            throw new ASException(errorcode, errormessage);
        }
        return service;
    }

    /**
     * Method to Request admin access.
     * 
     * @param userId
     *            - the request value
     * @param emailId
     *            - the request value
     * @param accessId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/requestAccess/{emailId}/", method = RequestMethod.POST)
    public final Service requestAccess(
            @PathVariable("emailId") final String emailId,
            @RequestBody final RequestAdminAccess requestAdminAccess) {
        LOGGER.info("inside requestAccess Method");

        List<LookupValues> lookupValues = lookUpValuesDAO
                .getLookUpData(requestAccesslookupKey);
        String justificationValue = null;
        List<String> accessId = requestAdminAccess.getAccessList();
        if (lookupValues != null && !lookupValues.isEmpty()) {
            for (LookupValues lookupValue : lookupValues) {
                final String lookUpName = lookupValue.getLookupName();
                for (String requestAccessId : accessId) {
                    if (requestAccessId.equals(lookUpName)) {
                        justificationValue = lookUpName;
                        break;
                    }
                }
            }

        }
        TaskServiceRequest taskServiceRequest = new TaskServiceRequest();

        List<String> justifications = new ArrayList<String>();
        final String requestorId = emailId.substring(0, emailId.indexOf('@'));
        justifications.add(justificationValue);
        taskServiceRequest.setJustifications(justifications);
        taskServiceRequest.setRequestorEmail(emailId);
        taskServiceRequest.setRequestorId(requestorId);
        taskService.invokeTaskService(taskServiceRequest, requestorId);

        sendNotification.notifyByEmail(emailId, templateId);
        return new Service();

    }

    /**
     * Method to create Admin User.
     * 
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
     * Method to get List of Permissions.
     * 
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
     * Method to get List of Permissions with roleId.
     * 
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
     * Method to add or update user role.
     * 
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
     * Method to find/search User and get FirstName and lastName of User.
     * 
     * @param emailId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/findUser/{emailId}/", method = RequestMethod.GET)
    public final Service findUser(@PathVariable("emailId") final String emailId) {
        LOGGER.info("Inside Get findUser");
        Service service = new Service();
        service.setPayload(adminLoginService.findUser(emailId));
        return service;

    }
}
