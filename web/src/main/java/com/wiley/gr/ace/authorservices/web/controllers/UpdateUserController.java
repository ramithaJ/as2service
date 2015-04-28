/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.UpdateUserService;

/**
 * @author vkumark
 *
 */
@RestController
@RequestMapping("/updateUser")
public class UpdateUserController {
	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
	UpdateUserService updateUserService = (UpdateUserService) context
			.getBean("UpdateUserService");

	@RequestMapping(value = "/orcid/{orcidId}/{userId}", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Service updateUserOrcidDetails(
			@PathVariable String orcidId, @PathVariable String userId) {
//System.out.println("Path variable ORCID ID " + orcidId);
//System.out.println("Path variable User ID " + userId);

		User user = null;
		Service service = null;
		try {
			user = updateUserService.updateOrcidProfile(orcidId,userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(user!=null){
//System.out.println("User details updated " + user.getFirstName());
			service = new Service();
			service.setStatus("SUCCESS");
			service.setServiceObject(user);
		}else {
			service = new Service();
			service.setStatus("FAILURE");
		}
		return service;
	}

}
