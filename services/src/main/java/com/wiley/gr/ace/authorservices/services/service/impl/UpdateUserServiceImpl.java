/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.external.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.services.external.impl.ESBInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * @author vkumark
 *
 */
public class UpdateUserServiceImpl implements UpdateUserService {
	
	private ApplicationContext contextDao = new AnnotationConfigApplicationContext(PersistenceBeanConfig.class);
	//private ApplicationContext context = new AnnotationConfigApplicationContext(ServiceBeanConfig.class);
	//private ESBInterfaceService esbInterfaceService = (ESBInterfaceServiceImpl) context.getBean("ESBInterfaceService");

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UpdateUserService#
	 * updateOrcidProfile(java.lang.String)
	 */
	@Override
	public User updateOrcidProfile(String orcidId) throws Exception {

		/**
		 * Fetch Account details and Profile details from external service
		 * (ESB->ORCID)
		 */
		User user = null;
		//User user = esbInterfaceService.fetchOrcidDetails(orcidId);
		if(user!=null){
			/**
			 * Update the user account details with ORCID account details
			 */
		}

		return null;
	}

}
