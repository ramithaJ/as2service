package com.wiley.gr.ace.authorservices.services.usermanagement.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.services.UserServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserServiceDAOImpl;
import com.wiley.gr.ace.authorservices.services.usermanagement.UserLoginService;
import com.wiley.gr.ace.authorservices.usermanagement.model.SecurityVO;
import com.wiley.gr.ace.authorservices.usermanagement.model.UISecurityDetails;

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

		List<Object[]> securityQuestionsList = userDAO
				.getSecurityQuestions(userId);

		securityVO = new SecurityVO();

		securityVO.setId1(Integer.parseInt(securityQuestionsList.get(0)[0]
				.toString()));
		securityVO.setSecurityQuestion1(securityQuestionsList.get(0)[2]
				.toString());
		securityVO.setSecurityAnswer1(securityQuestionsList.get(0)[3]
				.toString());
		securityVO.setId2(Integer.parseInt(securityQuestionsList.get(1)[0]
				.toString()));
		securityVO.setSecurityQuestion2(securityQuestionsList.get(1)[2]
				.toString());
		securityVO.setSecurityAnswer2(securityQuestionsList.get(1)[3]
				.toString());
		System.out.println(securityVO);

		/*
		 * List<UserSecurityDetails> securityQuestionslist = userDAO
		 * .getSecurityQuestions(userId);
		 * securityVO.setSecurityQuestion1(securityQuestionslist.get(0)
		 * .getSecurityQuestion());
		 * securityVO.setSecurityAnswer1(securityQuestionslist.get(0)
		 * .getSecurityAnswer());
		 * securityVO.setSecurityQuestion2(securityQuestionslist.get(1)
		 * .getSecurityQuestion());
		 * securityVO.setSecurityAnswer2(securityQuestionslist.get(1)
		 * .getSecurityAnswer());
		 */

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
