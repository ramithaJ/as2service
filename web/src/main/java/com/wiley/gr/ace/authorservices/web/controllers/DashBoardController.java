/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;
import com.wiley.gr.ace.authorservices.services.service.impl.DashBoardServiceImpl;

/**
 * @author yugandhark
 *
 */
@RestController
@RequestMapping("/dashboard")
public class DashBoardController {
	public static ApplicationContext context = new AnnotationConfigApplicationContext(ServiceBeanConfig.class);
	
	@RequestMapping(value = "/viewAllAuthorArticles", method = RequestMethod.GET, produces = "application/json")
	public List getAllAuthorArticles(){
		DashBoardService dashBoardService=(DashBoardServiceImpl)context.getBean("DashBoardService");
		return dashBoardService.getAllAuthorArticles();
	}
	@RequestMapping(value="/getProfileMeter/{userId}",method=RequestMethod.GET,produces="application/json")
	public Service getProfileMeter(@PathVariable("userId") String userId) {
		DashBoardService dashBoardService=(DashBoardServiceImpl)context.getBean("DashBoardService");
         Service service=	(Service) dashBoardService.getProfileMeter(Integer.parseInt(userId));
  		return service;
	}
	
}
