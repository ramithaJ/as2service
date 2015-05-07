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
package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;


/**
 * @author RAVISINHA
 *
 */
public class AdminLoginServiceImpl implements AdminLoginService {

//	private static ApplicationContext daoContext = new AnnotationConfigApplicationContext(
//			PersistenceBeanConfig.class);
//	private static ApplicationContext externalServiceContext = new AnnotationConfigApplicationContext(
//			ExternalServiceBeanConfig.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.admin.AdminLoginService#
	 * validateEmail(java.lang.String)
	 */
	@Autowired(required=true)
	UserLoginDao userlogindao;
	@Autowired(required=true)
	ALMInterfaceService almService;
	@Autowired(required=true)
	BPMInterfaceService bpmService;
	@Override
	public boolean validateEmail(String emailId) {
		
		boolean status = false;

		status = userlogindao.validateEmail(emailId);

		if (status) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean doLogin(String emailId) {
		// Call external service for password validation

		
		return almService.authenticateAdminUser(emailId);

	}

	@Override
	public boolean requestAdminAccess(String emailId) {

	
		// TODO: Integrate with BPM Service
		return bpmService.createTask();
	}

}
