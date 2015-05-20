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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

/**
 * @author Virtusa
 */
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    
    @Autowired(required = true)
    RegistrationService rs;
    
    @RequestMapping(value = "/verify/email", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service checkUserExists(@RequestHeader String email) {
        
        Service service = new Service();
        User user = null;
        try {
            if (!StringUtils.isEmpty(email))
                user = rs.checkEmailIdExists(email);
            else {
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(201);
                err.setMessage("Email is null or empty");
                service.setStatus("FAILURE");
                service.setError(err);
            }
            if (user != null) {
                if (user.getUserId() > 0) {
                    service.setStatus("FAILURE");
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode(202);
                    err.setMessage("Email address already registered");
                    service.setError(err);
                    service.setPayload(user);
                } else {
                    service.setStatus("FAILURE");
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode(203);
                    err.setMessage("Email address exists in the system but not registered with AS 2.0");
                    service.setError(err);
                    service.setPayload(user);
                }
            } else {
                service.setStatus("SUCCESS");
            }
        } catch (Exception e) {
            e.printStackTrace();
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(204);
            err.setMessage("searching user encountered exception");
            service.setStatus("ERROR");
            service.setError(err);
        }
        return service;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service createUser(@RequestBody User user) {
        Service service = new Service();
        String status = null;
        if (null != user) {
            try {
                if (user.isSearchFullName()) {
                    List<User> usersList = null;
                    usersList = rs.getUserFromFirstNameLastName(
                            user.getPrimaryEmailAddr(), user.getFirstName(),
                            user.getLastName());
                    if (null != usersList) {
                        service.setStatus("FAILURE");
                        ErrorPOJO err = new ErrorPOJO();
                        err.setCode(205);
                        err.setMessage("First Name and Last Name already exists");
                        service.setError(err);
                        service.setPayload(usersList);
                        return service;
                    }
                }
                status = rs.createUser(user);
                if (status.equalsIgnoreCase("success")) {
                    service.setStatus("SUCCESS");
                } else {
                    service.setStatus("FAILURE");
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode(208);
                    err.setMessage("Creating user failed");
                    service.setError(err);
                }
            } catch (Exception e) {
                
                e.printStackTrace();
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(204);
                err.setMessage("searching user encountered exception");
                service.setStatus("ERROR");
                service.setError(err);
            }
            
        } else {
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(207);
            err.setMessage("User object is empty");
            service.setStatus("FAILURE");
            service.setError(err);
        }
        
        return service;
    }
    
    @RequestMapping(value = "/search/orcid/{orcidId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service isUserFoundWithOrcidId(
            @PathVariable("orcidId") String orcidId) {
        
        Service service = new Service();
        if (!StringUtils.isEmpty(orcidId)) {
            try {
                if (rs.searchUserByOrcidId(orcidId)) {
                    service.setStatus("FAILURE");
                    ErrorPOJO err = new ErrorPOJO();
                    err.setCode(214);
                    err.setMessage("User already exists with the same ORCID Id");
                    service.setError(err);
                } else {
                    service.setStatus("SUCCESS");
                }
            } catch (Exception e) {
                service.setStatus("FAILURE");
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(215);
                err.setMessage("Searching user with ORCID Id encountered exception");
                service.setError(err);
            }
        } else {
            service.setStatus("FAILURE");
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(216);
            err.setMessage("Please enter ORCID Id");
            service.setError(err);
        }
        
        return service;
    }
}
