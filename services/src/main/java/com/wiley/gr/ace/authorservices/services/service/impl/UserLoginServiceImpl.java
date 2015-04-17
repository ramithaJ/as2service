package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.SecurityVO;
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

	@Override
	public boolean doLogin(String emailId, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkSecuritySetUp(String emailId) {
		UserServiceDAO userDAO = (UserServiceDAOImpl) context
				.getBean("UserServiceDAO");
		return userDAO.checkSecuritySetup(emailId);
	}

	@Override
	public SecurityVO getSecurityQuestions(String userId) {
		SecurityVO securityVO = null;
		UserServiceDAO userDAO = (UserServiceDAOImpl) context
				.getBean("UserServiceDAO");

		securityVO = new SecurityVO();
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
	public boolean resetPassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateSecurityQuestions(String userId,
			SecurityVO securityVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockUser(String emailId) {
		UserServiceDAO userDAO = (UserServiceDAOImpl) context
				.getBean("UserServiceDAO");
		int records = userDAO.lockUser(emailId);
		if (records == 1)
			return true;
		return false;
	}

	@Override
	public boolean validateEmailAddress(String emailId) {
		UserServiceDAO userDAO = (UserServiceDAOImpl) context
				.getBean("UserServiceDAO");
		return userDAO.validateEmailAddress(emailId);
	}

	@Override
	public boolean isUserLocked(String emailId) {
		UserServiceDAO userDAO = (UserServiceDAOImpl) context
				.getBean("UserServiceDAO");
		return userDAO.isUserLocked(emailId);
	}

	@Override
	public void sendEmail(String userId, String template_id) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean validateSecurityQuestions(UISecurityDetails uiSecurityDetails) {

		SecurityVO securityVO = this.getSecurityQuestions("1234");
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
