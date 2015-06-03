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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.AccessReasons;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.ASDataService;

/**
 * This controller is used to get common data in dropdown across application
 * 
 * @author SarmaKumarap
 */
@RestController
@RequestMapping("/asdata")
public class ASDataController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ASDataController.class);

	@Autowired(required = true)
	ASDataService aSDataService;
	@Value("${noDataFound.code}")
	private String nodataFound;
	@Value("${noDataFound.message}")
	private String nodataFoundmsg;

	@RequestMapping(value = "/titles/", method = RequestMethod.GET)
	public Service getTitles() {
		LOGGER.info("inside getTitles Method");
		Service service = new Service();
		service.setPayload(aSDataService.getTitles());
		return service;
	}

	@RequestMapping(value = "/suffixes/", method = RequestMethod.GET)
	public Service getSuffixes() {
		LOGGER.info("inside getSuffixes Method");
		Service service = new Service();
		service.setPayload(aSDataService.getSuffixes());
		return service;
	}

	@RequestMapping(value = "/industries/", method = RequestMethod.GET)
	public Service getIndustries(
			@RequestParam(value = "count", required = false, defaultValue = "10") Integer count) {
		LOGGER.info("inside getIndustries Method");
		Service service = new Service();
		service.setPayload(aSDataService.getIndustries(count));
		return service;
	}

	@RequestMapping(value = "/jobCategories/", method = RequestMethod.GET)
	public Service getJobCategories(
			@RequestParam(value = "count", required = false, defaultValue = "10") Integer count) {
		LOGGER.info("inside getJobCategories Method");
		Service service = new Service();
		service.setPayload(aSDataService.getJobCategories(count));
		return service;
	}

	@RequestMapping(value = "/countries/", method = RequestMethod.GET)
	public Service getCountries(
			@RequestParam(value = "count", required = false, defaultValue = "10") Integer count) {
		LOGGER.info("inside getCountries Method");
		Service service = new Service();
		service.setPayload(aSDataService.getCountries(count));
		return service;
	}

	@RequestMapping(value = "/states/{countrycode}", method = RequestMethod.GET)
	public Service getStates(
			@PathVariable("countrycode") String countrycode,
			@RequestParam(value = "count", required = false, defaultValue = "10") Integer count) {
		LOGGER.info("inside getStates Method");
		Service service = new Service();
		service.setPayload(aSDataService.getStates(countrycode, count));

		return service;
	}

	@RequestMapping(value = "/institutions/", method = RequestMethod.GET)
	public Service getInstitutions() {
		LOGGER.info("inside getInstitutions Method");
		Service service = new Service();
		service.setPayload(aSDataService.getInstitutions());

		return service;
	}

	@RequestMapping(value = "/departments/", method = RequestMethod.GET)
	public Service getDepartments() {
		LOGGER.info("inside getDepartments Method");
		Service service = new Service();
		service.setPayload(aSDataService.getDepartments());

		return service;
	}

	@RequestMapping(value = "/researchFunders/", method = RequestMethod.GET)
	public Service getResearchFunders() {
		LOGGER.info("inside getResearchFunders Method");
		Service service = new Service();
		service.setPayload(aSDataService.getResearchFunders());
		return service;
	}

	@RequestMapping(value = "/articles/", method = RequestMethod.GET)
	public Service getArticles() {
		LOGGER.info("inside getArticles Method");
		return null;
	}

	@RequestMapping(value = "/societies/", method = RequestMethod.GET)
	public Service getSocieties() {
		LOGGER.info("inside getSocieties Method");
		Service service = new Service();
		service.setPayload(aSDataService.getSocieties());

		return service;
	}

	@RequestMapping(value = "/areasOfInterests/", method = RequestMethod.GET)
	public Service getAreasOfInterests(
			@RequestParam(value = "count", required = false, defaultValue = "10") Integer count) {
		LOGGER.info("inside getAreasOfInterests Method");
		Service service = new Service();
		service.setPayload(aSDataService.getAreasOfInterests(count));
		return service;
	}

	@RequestMapping(value = "/securityQuestions/", method = RequestMethod.GET)
	public Service getSecurityQuestions() {
		LOGGER.info("inside getSecurityQuestions Method");
		Service service = new Service();
		service.setPayload(aSDataService.getSecurityQuestions());

		return service;
	}

	@RequestMapping(value = "/roles/", method = RequestMethod.GET)
	public Service getUserRoles() {
		LOGGER.info("inside getUserRoles Method");
		Service service = new Service();
		service.setPayload(aSDataService.getAdminRoles(null));

		return service;
	}

	@RequestMapping(value = "/roles/{roleType}", method = RequestMethod.GET)
	public Service getAdminRoles(@PathVariable("roleType") String roleType) {
		LOGGER.info("inside getAdminRoles Method");
		Service service = new Service();
		service.setPayload(aSDataService.getAdminRoles(roleType));

		return service;
	}

	@RequestMapping(value = "/accessReasons/", method = RequestMethod.GET)
	public Service getAdminAccessReasons() {
		LOGGER.info("inside getAdminAccessReasons Method");
		Service service = new Service();
		List<AccessReasons> accessList = aSDataService.getAccessReasons();
		if (null == accessList) {
			throw new ASException(nodataFound, nodataFoundmsg);
		}
		service.setPayload(accessList);
		return service;
	}
}
