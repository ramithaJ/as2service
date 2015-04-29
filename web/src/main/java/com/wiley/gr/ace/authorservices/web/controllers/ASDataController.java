/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.ASDataService;
import com.wiley.gr.ace.authorservices.services.service.impl.ASDataServiceImpl;

/**
 * This controller is used to get common data in dropdown across application
 * 
 * @author SarmaKumarap
 *
 */
@RestController
@RequestMapping("/asdata")
public class ASDataController {

	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);
	ASDataService aSDataService = (ASDataServiceImpl) context
			.getBean("ASDataService");

	/**
	 * @return
	 */
	@RequestMapping(value = "/getTitles/", method = RequestMethod.GET, produces = "application/json")
	public Service getTitles() {

		return null;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getSuffixes/", method = RequestMethod.GET, produces = "application/json")
	public Service getSuffixes() {

		return null;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getIndustries/", method = RequestMethod.GET, produces = "application/json")
	public Service getIndustries() {

		return null;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getJobCategories/", method = RequestMethod.GET, produces = "application/json")
	public Service getJobCategories() {

		return null;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getCountries/", method = RequestMethod.GET, produces = "application/json")
	public Service getCountries() {

		return null;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getStates/", method = RequestMethod.GET, produces = "application/json")
	public Service getStates() {

		return null;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getInstitutions/", method = RequestMethod.GET, produces = "application/json")
	public Service getInstitutions() {

		return null;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getDepartments/", method = RequestMethod.GET, produces = "application/json")
	public Service getDepartments() {

		return null;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getResearchFunders/", method = RequestMethod.GET, produces = "application/json")
	public Service getResearchFunders() {

		return null;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/getArticles/", method = RequestMethod.GET, produces = "application/json")
	public Service getArticles() {

		return null;
	}

	@RequestMapping(value = "/getSocieties/", method = RequestMethod.GET, produces = "application/json")
	public Service getSocieties() {

		return null;
	}

	@RequestMapping(value = "/getAreasOfInterests/", method = RequestMethod.GET, produces = "application/json")
	public Service getAreasOfInterests() {

		return null;
	}

	@RequestMapping(value = "/getSecurityQuestions/", method = RequestMethod.GET, produces = "application/json")
	public Service getSecurityQuestions() {

		Service service = new Service();
		try {
			service.setStatus("success");
			service.setPayload(aSDataService.getSecurityQuestions());
		} catch (ASException asException) {
			service.setStatus("failed");
			service.setError(new com.wiley.gr.ace.authorservices.model.ErrorPOJO());
			service.getError().setCode(
					Integer.parseInt(asException.getErrorCode()));
			service.getError().setMessage(asException.getDescription());
		} catch (Exception exception) {
			service.setStatus("failed");
			service.setError(new com.wiley.gr.ace.authorservices.model.ErrorPOJO());
			service.getError().setCode(-1);
			service.getError().setMessage(exception.getMessage());
		}
		return service;
	}
}
