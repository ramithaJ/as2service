package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UISecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.UserServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserServiceDAOImpl;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * @author kpshiva
 */
public class UserLoginServiceImpl implements UserLoginService {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	UserServiceDAO userDAO = (UserServiceDAOImpl) context
			.getBean("UserServiceDAO");

	@Override
	public Service doLogin(String emailId, String password) {

		Service service = new Service();
		if (userDAO.doLogin(emailId, password)) {
			service.setStatus("success");
		} else {
			service.setStatus("failure");
		}
		return service;
	}

	@Override
	public boolean checkSecuritySetUp(String emailId) {

		return userDAO.checkSecuritySetup(emailId);
	}

	@Override
	public Security getSecurityQuestions(String userId) {

		Security securityVO = null;
		securityVO = new Security();
		List<UserSecurityDetails> securityQuestionslist = userDAO
				.getSecurityQuestions(userId);
		securityVO.setId1(securityQuestionslist.get(0).getUserSecurityId());
		securityVO.setSecurityQuestion1(securityQuestionslist.get(0)
				.getSecurityQuestion());
		securityVO.setSecurityAnswer1(securityQuestionslist.get(0)
				.getSecurityAnswer());
		securityVO.setId2(securityQuestionslist.get(1).getUserSecurityId());
		securityVO.setSecurityQuestion2(securityQuestionslist.get(1)
				.getSecurityQuestion());
		securityVO.setSecurityAnswer2(securityQuestionslist.get(1)
				.getSecurityAnswer());

		return securityVO;
	}

	@Override
	public boolean resetPassword(String emailId, String password) {

		return userDAO.resetPassword(emailId, password);
	}

	@Override
	public boolean validateSecurityQuestions(String userId, Security securityVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockUser(String emailId) {

		int records = userDAO.lockUser(emailId);
		if (records == 1)
			return true;
		return false;
	}

	@Override
	public boolean validateEmailAddress(String emailId) {

		return userDAO.validateEmailAddress(emailId);
	}

	@Override
	public boolean isUserLocked(String emailId) {

		return userDAO.isUserLocked(emailId);
	}

	@Override
	public void sendEmail(String userId, String template_id) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean validateSecurityQuestions(UISecurityDetails uiSecurityDetails) {

		Security securityVO = this.getSecurityQuestions("1234");
		if (securityVO.getId1() == uiSecurityDetails.getId1()
				&& securityVO.getSecurityAnswer1().equalsIgnoreCase(
						uiSecurityDetails.getAnswer1())
				&& securityVO.getId2() == uiSecurityDetails.getId2()
				&& securityVO.getSecurityAnswer2().equalsIgnoreCase(
						uiSecurityDetails.getAnswer2()))
			return true;

		return false;
	}

}
