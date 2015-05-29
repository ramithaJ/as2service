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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.ASRolesAndPermissions;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;

/**
 * This method takes email in encrypted format like -- kondavinay%40gmail.com/
 * Hit the link as
 * http://localhost:8080/author-services/admin/login/kondavinay%40gmail.com/
 * 
 * @author ravisinha
 */
@RestController
@RequestMapping("/admin")
public class AdminLoginController extends ASExceptionController {

	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	@Autowired(required = true)
	AdminLoginService adminLoginService;

	@Autowired(required = true)
	LocalValidatorFactoryBean validator;

	@RequestMapping(value = "/login/", method = RequestMethod.POST, produces = "application/json")
	public Service login(@Valid @RequestBody Login login) {
		boolean status = false;
		Service service = new Service();
		status = adminLoginService.validateEmail(login.getEmailId());
		if (status) {
			String userId = adminLoginService.doLogin(login.getEmailId());
			UserMgmt userObj = new UserMgmt();
			userObj.setUserId(userId);
			service.setPayload(userObj);
		} else {
			throw new ASException("1010",
					"You don't have access to Wiley Admin.");
		}
		return service;
	}

	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/requestAccess/{emailId}/{accessId}/", method = RequestMethod.POST, produces = "application/json")
	public Service requestAccess(@PathVariable("emailId") String emailId,
	        @PathVariable("accessId") String accessId) {

		return new Service();

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public Service createAdmin(@RequestBody AdminUser admin) {

		return new Service();

	}

	@RequestMapping(value = "/permissions/", method = RequestMethod.GET, produces = "application/json")
	public Service getPermissions() {

		Service service = new Service();
		service.setPayload(adminLoginService.getRolesAndPermissions(null));
		return service;
	}

	/**
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/permissions/{roleId}", method = RequestMethod.GET, produces = "application/json")
	public Service getPermissionsForRole(@PathVariable("roleId") String roleId) {

		Service service = new Service();
		service.setPayload(adminLoginService.getRolesAndPermissions(roleId));
		return service;
	}

	/**
	 * @param rolesAndPermissions
	 * @return
	 */
	@RequestMapping(value = "/permissions/", method = RequestMethod.POST, produces = "application/json")
	public Service addOrUpdateUserRole(
			@RequestBody ASRolesAndPermissions rolesAndPermissions) {

		adminLoginService.addOrUpdateUserRole(rolesAndPermissions);
		return new Service();

	}
	
	@RequestMapping(value = "/findUser/{emailId}/", method = RequestMethod.POST, produces = "application/json")
    public Service findUser(@PathVariable("emailId") String emailId) {

        Service service = new Service();
        service.setPayload(adminLoginService.findUser(emailId));
        return service;

    }
}
