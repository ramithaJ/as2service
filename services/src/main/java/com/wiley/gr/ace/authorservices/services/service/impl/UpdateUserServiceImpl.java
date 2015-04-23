/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.externalservices.context.ExternalServiceBeanConfig;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * @author vkumark
 *
 */
public class UpdateUserServiceImpl implements UpdateUserService {
	
	private ApplicationContext contextDao = new AnnotationConfigApplicationContext(PersistenceBeanConfig.class);
	private ApplicationContext context = new AnnotationConfigApplicationContext(ExternalServiceBeanConfig.class);
	private ESBInterfaceService esbInterfaceService = (ESBInterfaceService) context.getBean("ESBInterfaceService");
	private UpdateUserDAO userDao = (UpdateUserDAO)contextDao.getBean("UpdateUserDAO");
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UpdateUserService#
	 * updateOrcidProfile(java.lang.String)
	 */
	@Override
	public User updateOrcidProfile(String orcidId, String userId) throws Exception {

		/**
		 * Fetch Account details and Profile details from external service
		 * (ESB->ORCID)
		 */
		User user = esbInterfaceService.fetchOrcidDetails(orcidId);
		User updatedUser = null;
		if(user!=null){
			/**
			 * Update the user account details with ORCID account details
			 */
			user.setUserId(Integer.parseInt(userId));
			updatedUser = userDao.updateUserWithOrcid(user);
		}

		return updatedUser;
	}

}
