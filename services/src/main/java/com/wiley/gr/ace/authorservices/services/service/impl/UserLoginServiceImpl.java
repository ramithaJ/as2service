package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.context.ExternalServiceBeanConfig;
import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ALMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginServiceDAOImpl;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * @author kpshiva
 */
public class UserLoginServiceImpl implements UserLoginService {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	UserLoginServiceDAO userLoginServiceDAO = (UserLoginServiceDAOImpl) context
			.getBean("UserLoginServiceDAO");
	private static ApplicationContext serviceContext = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
<<<<<<< HEAD
=======
	private static ApplicationContext externalServiceContext = new AnnotationConfigApplicationContext(
			ExternalServiceBeanConfig.class);

	
>>>>>>> a48491a378975cb64e67e93d2e4c429187f4fc20

	@Override
	public Service doLogin(String emailId, String password) {

		Service service = new Service();
		if (this.validateEmailAddress(emailId)) {
			if (this.isUserLocked(emailId)) {
				Date currentDate = new Date();
				Date date = userLoginServiceDAO.getLockedTime(emailId);
				Date lockedDate = new Date(date.getTime());
				return service;
			} else {
				this.authentication(emailId, password);
				return service;
			}
		} else {
			this.authentication(emailId, password);
			service.setStatus("Invalid email address. Please Re-Enter");
			throw new ASException("1001", "Invalid email address. Please Re-Enter");
		}
		return service;
	}

	@Override
	public boolean checkSecuritySetUp(String emailId) {

		return userLoginServiceDAO.checkSecuritySetup(emailId);
	}

	@Override
	public Security getSecurityQuestions(String emailId) {

		Security security = new Security();
		Integer userId = userLoginServiceDAO.getUserId(emailId);
		List<UserSecurityDetails> securityQuestionslist = userLoginServiceDAO
				.getSecurityQuestions(userId);
		security.setId1(securityQuestionslist.get(0).getUserSecurityId());
		security.setSecurityQuestion1(securityQuestionslist.get(0)
				.getSecurityQuestion());
		security.setId2(securityQuestionslist.get(1).getUserSecurityId());
		security.setSecurityQuestion2(securityQuestionslist.get(1)
				.getSecurityQuestion());
		return security;
	}

	@Override
	public boolean resetPassword(String emailId, String oldPassword,
			String newPassword) {

		return userLoginServiceDAO.resetPassword(emailId, newPassword);
	}

	@Override
	public boolean validateSecurityQuestions(String emailId,
			Security securityDetails) {

		Integer userId = userLoginServiceDAO.getUserId(emailId);
		List<UserSecurityDetails> securityQuestionslist = userLoginServiceDAO
				.getSecurityQuestions(userId);
		if (securityDetails.getSecurityAnswer1().equalsIgnoreCase(
				securityQuestionslist.get(0).getSecurityQuestion())
				&& securityDetails.getSecurityAnswer1().equalsIgnoreCase(
						securityQuestionslist.get(0).getSecurityAnswer())
				&& securityDetails.getSecurityQuestion2().equalsIgnoreCase(
						securityQuestionslist.get(1).getSecurityQuestion())
				&& securityDetails.getSecurityAnswer2().equalsIgnoreCase(
						securityQuestionslist.get(1).getSecurityAnswer()))
			return true;
		return false;
	}

	@Override
	public boolean lockUser(String emailId) {

		int records = userLoginServiceDAO.lockUser(emailId);
		if (records == 1)
			return true;
		return false;
	}

	@Override
	public boolean validateEmailAddress(String emailId) {

		return userLoginServiceDAO.validateEmailAddress(emailId);
	}

	@Override
	public boolean isUserLocked(String emailId) {

		return userLoginServiceDAO.isUserLocked(emailId);
	}

	@Override
	public void sendEmail(String userId, String template_id) {
		// TODO Auto-generated method stub
	}

	@Override
	public Service authentication(String emailId, String password) {

		ALMInterfaceService almService = (ALMInterfaceServiceImpl) externalServiceContext
				.getBean("ALMExternalService");
		Service service = new Service();

		if (almService.authenticateUser(emailId)) {
			userLoginServiceDAO.doLogin(emailId, password);
			service.setStatus("successfull login");
			return service;
		} else {
			// get count
			int count = userLoginServiceDAO.getCount(emailId);
			// increment the count
			if (count == 3) {
				if (this.lockUser(emailId))
					service.setStatus("your account is locked. Please try after some time");
				return service;
			} else {
				count++;
				if (userLoginServiceDAO.updateCount(count, emailId))
					service.setStatus("please enter valid emailID and password");
				return service;
			}
		}
	}
}
