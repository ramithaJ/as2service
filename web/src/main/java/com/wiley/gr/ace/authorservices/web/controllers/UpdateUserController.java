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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/user/update")
public class UpdateUserController {

    @Autowired(required = true)
    UpdateUserService updateUserService;

    /**
     * @param orcidId
     * @return
     */
    @RequestMapping(value = "/orcid/{orcidId}/{userId}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Service updateOrcidId(@PathVariable String orcidId,
            @PathVariable String userId, @RequestBody String emailId) {

        Service service = new Service();

        try {
            service.setPayload(updateUserService.updateOrcidId(emailId,
                    orcidId, userId));
        } catch (Exception e) {
            ErrorPOJO error = new ErrorPOJO();
            error.setCode(-101); // Need to set proper error code this one is
                                 // dummy
            error.setMessage("Error updating user ORCID ID");

            service.setStatus("error");
            service.setPayload(service);
            service.setError(error);
            throw new ASException("-2", "Error updating user user ORCID ID", e);
        }
        return service;
    }
}
