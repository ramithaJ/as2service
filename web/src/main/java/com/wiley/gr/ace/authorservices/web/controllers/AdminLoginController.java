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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.AdminUser;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;

/**
 * This method takes email in encrypted format like -- kondavinay%40gmail.com/
 * Hit the link as
 * http://localhost:8080/author-services/admin/login/kondavinay%40gmail.com/
 * 
 * @author ravisinha
 *
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

	@RequestMapping(value = "/login/", method = RequestMethod.POST, produces = "application/json")
	public Service login(@RequestBody Login login) {
		boolean status = false;
		Service serviceVO = new Service();

		status = adminLoginService.validateEmail(login.getEmailId());

		if (status) {

			adminLoginService.doLogin(login.getEmailId());
			serviceVO.setStatus("success");
			
		} else {
			throw new ASException("1001",
					"Invalid email address. Please Re-Enter");
		}

		return serviceVO;

	}

	/**
	 * @param emailId
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/requestAccess/{emailId}", method = RequestMethod.POST, produces = "application/json")
	public Service requestAccess(@PathVariable("emailId") String emailId,
			@RequestBody String password) {
		
		return null;

	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public Service createAdmin(@RequestBody AdminUser admin) {

		return null;

	}
}
