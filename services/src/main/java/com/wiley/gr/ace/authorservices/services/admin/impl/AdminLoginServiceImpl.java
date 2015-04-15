package com.wiley.gr.ace.authorservices.services.admin.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.services.usermanagement.impl.UserLoginDaoImpl;
import com.wiley.gr.ace.authorservices.persistence.services.usermanagement.UserLoginDao;
import com.wiley.gr.ace.authorservices.services.admin.AdminLoginService;
import com.wiley.gr.ace.authorservices.services.admin.external.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.services.admin.external.impl.ALMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;

/**
 * @author RAVISINHA
 *
 */
public class AdminLoginServiceImpl  implements AdminLoginService{
	
	private static ApplicationContext daoContext = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	private static ApplicationContext serviceContext = new AnnotationConfigApplicationContext(ServiceBeanConfig.class);
	

	/* (non-Javadoc)
	 * @see com.wiley.gr.ace.authorservices.services.admin.AdminLoginService#validateEmail(java.lang.String)
	 */
	@Override
	public boolean validateEmail(String emailId) {
		boolean status = false;
		
		
		UserLoginDao userlogindao=(UserLoginDaoImpl) daoContext.getBean("AdminLoginDao");
		
		status=  userlogindao.validateEmail(emailId);
		
		
		if(status) {
      		return true;
      		
      	} else {
      		return false;
      	}
	}

	@Override
	public boolean doLogin(String emailId, String password)
	{
		boolean status = false;
		// Call external service for password validation
		
		ALMInterfaceService almService= (ALMInterfaceServiceImpl)serviceContext.getBean("ALMExternalService");
		
		if(almService.authenticateUser(emailId, password))
		{
			// Calling dao for updating timestamp
			
			UserLoginDao userlogindao=(UserLoginDaoImpl) daoContext.getBean("AdminLoginDao");
	        status   =  userlogindao.doLogin(emailId);
		  }
		return status;
}

	@Override
	public boolean requestAdminAccess(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
	



