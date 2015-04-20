package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginServiceDAOImpl;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * @author kpshiva
 */
public class UserLoginServiceImpl implements UserLoginService {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	UserLoginServiceDAO userLoginServiceDAO = (UserLoginServiceDAOImpl) context
			.getBean("UserLoginServiceDAO");

	@Override
	public Service doLogin(String emailId, String password) {

		Service service = new Service();
		if (userLoginServiceDAO.doLogin(emailId, password)) {
			service.setStatus("success");
		} else {
			service.setStatus("failure");
		}
		return service;
	}

	@Override
	public boolean checkSecuritySetUp(String emailId) {

		return userLoginServiceDAO.checkSecuritySetup(emailId);
	}

	@Override
	public Security getSecurityQuestions(String emailId) {

		Security security = null;
		security = new Security();
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
	public boolean validateSecurityQuestions(String emailId, Security security) {
		// TODO Auto-generated method stub
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
}
