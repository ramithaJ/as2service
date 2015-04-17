package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginDaoImpl;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.external.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.services.external.BPMInterfaceService;
import com.wiley.gr.ace.authorservices.services.external.impl.ALMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.services.external.impl.BPMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;

/**
 * @author RAVISINHA
 *
 */
public class AdminLoginServiceImpl implements AdminLoginService {

	private static ApplicationContext daoContext = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	private static ApplicationContext serviceContext = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.admin.AdminLoginService#
	 * validateEmail(java.lang.String)
	 */
	@Override
	public boolean validateEmail(String emailId) {
		boolean status = false;

		UserLoginDao userlogindao = (UserLoginDaoImpl) daoContext
				.getBean("AdminLoginDao");

		status = userlogindao.validateEmail(emailId);

		if (status) {
			return true;

		} else {
			return false;
		}
	}

	@Override
	public boolean doLogin(String emailId) {
		boolean status = false;
		// Call external service for password validation

		ALMInterfaceService almService = (ALMInterfaceServiceImpl) serviceContext
				.getBean("ALMExternalService");

		if (almService.authenticateUser(emailId)) {
			// Calling dao for updating timestamp

			UserLoginDao userlogindao = (UserLoginDaoImpl) daoContext
					.getBean("AdminLoginDao");
			status = userlogindao.doLogin(emailId);
		}
		return status;
	}

	@Override
	public boolean requestAdminAccess(String emailId) {

		BPMInterfaceService bpmService = (BPMInterfaceServiceImpl) serviceContext
				.getBean("BPMExternalService");
		// TODO: Integrate with BPM Service
		return bpmService.createTask();
	}

}
