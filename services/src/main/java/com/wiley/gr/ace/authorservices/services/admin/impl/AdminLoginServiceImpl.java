package com.wiley.gr.ace.authorservices.services.admin.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.services.usermanagement.impl.UserLoginDaoImpl;
import com.wiley.gr.ace.authorservices.persistence.services.usermanagement.UserLoginDao;
import com.wiley.gr.ace.authorservices.services.admin.AdminLoginService;

public class AdminLoginServiceImpl  implements AdminLoginService{
	
	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	@Override
	public boolean validateEmail(String emailId) {
		boolean status = false;
		
		
		UserLoginDao userlogindao=(UserLoginDaoImpl) context.getBean("AdminLoginDao");
		
		status=  userlogindao.validateEmail(emailId);
		
		
		if(status) {
      		return true;
      		
      	} else {
      		return false;
      	}
	}

	@Override
	public boolean doLogin(String emailId) {
		
		return false;
	}


}
