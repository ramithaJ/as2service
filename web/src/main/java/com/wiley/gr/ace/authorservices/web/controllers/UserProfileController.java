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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.CDMAffiliation;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

/**
 * @author SarmaKumarap
 *
 */
@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

	/**
	 * @param userId
	 * @return
	 */
	@Autowired(required = true)
	CDMInterfaceService cdmservices;

	@Autowired(required = true)
	UserProfileService userProfileService;

	@Autowired(required = true)
	LocalValidatorFactoryBean validator;

	@RequestMapping(value = "/getAffiliations/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getAffiliationsList(@PathVariable("userId") String userId) {

		Service service = new Service();

		service.setPayload(cdmservices.getAffiliationsForUser(userId));
		service.setStatus("success");

		return service;
	}

	/**
	 * The affiliation data will be input as json through POST. This will get
	 * called when user clicks on Edit button
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/editAffiliation/{userId}/{affiliationId}", method = RequestMethod.GET, produces = "application/json")
	public Service editAffiliation(@PathVariable("userId") String userId,
			@PathVariable("affiliationId") String affiliationId) {

		Service service = new Service();

		service.setPayload(cdmservices.editAffialiationsForUser(userId,
				affiliationId));
		service.setStatus("success");

		return service;
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/updateAffiliation/{userId}/{affiliationId}", method = RequestMethod.POST, produces = "application/json")
	public Service updateAffiliation(@PathVariable("userId") String userId,
			@RequestBody CDMAffiliation cdmAffiliation) {

		boolean status = false;

		Service service = new Service();
		// service.setPayload(cdmservices.updateAffiliationForUser(cdmAffiliation));
		status = cdmservices.updateAffiliationForUser(cdmAffiliation);
		if (status) {

			service.setStatus("success");
		}

		return service;
	}

	/**
	 * The affiliation data will be input as json through POST
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/deleteAffiliation/{userId}/{affiliationId}", method = RequestMethod.POST, produces = "application/json")
	public Service deleteAffiliation(@PathVariable("userId") String userId,
			@PathVariable("affiliationId") String affiliationId) {

		Service service = new Service();
		boolean status = false;
		// service.setPayload(cdmservices.deleteAffiliationForUser(userId,
		// affiliationId));
		status = cdmservices.deleteAffiliationForUser(userId, affiliationId);
		if (status) {
			service.setStatus("success");
		}
		return service;
	}

	/**
	 * This method takes affiliations in POST of request
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/addAffiliation/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service addAffiliation(@PathVariable("userId") String userId,
			@RequestBody CDMAffiliation cdmAffiliation) {
		boolean status = false;

		Service service = new Service();
		status = cdmservices.addAffiliationsForUser(cdmAffiliation);
		if (status) {

			service.setStatus("success");
		}

		return service;
	}

	/**
	 * Returns the list of all research funders added by the user.
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/researchFunders/{userId}", method = RequestMethod.GET)
	public Service getResearchFundersList(@PathVariable("userId") String userId) {

		Service service = new Service();
		service.setStatus("Success");
		service.setPayload(userProfileService.getResearchFunders(userId));
		return service;
	}

	/**
	 * Gets the research funder info to be edited
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/editResearchFunder/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service editResearchFunder(@PathVariable("userId") String userId,
			@PathVariable("funderId") String funderId) {

		return null;
	}

	/**
	 * @param userId
	 * @param funderJson
	 * @return
	 */
	@RequestMapping(value = "/addResearchFunder/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service addResearchFunder(@PathVariable("userId") String userId,
			@RequestBody String funderJson) {

		return null;
	}

	/**
	 * @param userId
	 * @param funderId
	 * @return
	 */
	@RequestMapping(value = "/deleteResearchFunder/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service deleteResearchFunder(@PathVariable("userId") String userId,
			@RequestBody String funderId) {

		return null;
	}

	/**
	 * @param userId
	 * @param funderJson
	 * @return
	 */
	@RequestMapping(value = "/researchFunder/update/{userId}", method = RequestMethod.POST)
	public Service updateResearchFunder(@PathVariable("userId") String userId,
			@RequestBody ResearchFunder funderJson) {

		Service service = new Service();
		service.setStatus("Success");
		service.setPayload(userProfileService.updateResearchFunder(userId,
				funderJson));
		return service;
	}
	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/societies/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getSocietiesList(@PathVariable("userId") String userId) {

		Service service = new Service();
		service.setPayload(userProfileService.getSocietiesForUser(userId));

		return service;
	}

	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	@RequestMapping(value = "/editSocietyDetails/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service editSocietyDetails(@PathVariable("userId") String userId,
			@PathVariable("societyId") String societyId) {

		return null;
	}

	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	@RequestMapping(value = "/deleteSociety/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service deleteSociety(@PathVariable("userId") String userId,
			@PathVariable("societyId") String societyId) {

		return null;
	}

	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	@RequestMapping(value = "/updateSocietyDetails/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service updateSocietyDetails(@PathVariable("userId") String userId,
			@RequestBody String societyId) {

		return null;
	}

	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	@RequestMapping(value = "/addSociety/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service addSociety(@PathVariable("userId") String userId,
			@RequestBody String societyId) {

		return null;
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getMyInterests/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getMyInterests(@PathVariable("userId") String userId) {

		Service service = new Service();
		service.setStatus("Success");
		service.setPayload(cdmservices.getInterests(userId));

		return service;
	}

	/**
	 * @param userId
	 * @param interestsJson
	 * @return
	 */
	@RequestMapping(value = "/addInterests/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service addInterests(@PathVariable("userId") String userId,
			@RequestBody Interests interestsJson) {

		Service service = new Service();
		cdmservices.addInterest(userId, interestsJson);
		service.setStatus("Success");
		return service;
	}

	/**
	 * @param userId
	 * @param interestId
	 * @return
	 */
	@RequestMapping(value = "/removeInterest/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service removeInterest(@PathVariable("userId") String userId,
			@RequestBody String interestId) {

		Service service = new Service();
		cdmservices.removeInterest(userId, interestId);
		service.setStatus("Success");
		return service;
	}

	/**
	 * @param userId
	 * @param searchString
	 * @return
	 */
	@RequestMapping(value = "/searchInterests/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service searchInterests(
			@PathVariable("userId") String userId,
			@RequestParam(required = false, value = "searchStr") String searchString) {

		return null;
	}

	/**
	 * This service will give list of Co-authors that are tagged to the
	 * author/user.
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/coAuthors/{userId}", method = RequestMethod.GET)
	public Service getCoAuthorsList(@PathVariable("userId") String userId) {

		Service service = new Service();
		service.setStatus("Success");
		service.setPayload(userProfileService.getCoAuthorsList(userId));
		return service;
	}

	/**
	 * This service will update the co-author details which are tagged to the
	 * author/user at user profile level.
	 * 
	 * @param userId
	 * @param coAuthorId
	 * @return
	 */
	@RequestMapping(value = "/coAuthor/update/{userId}", method = RequestMethod.POST)
	public Service editCoAuthor(@PathVariable("userId") String userId,
			@RequestBody CoAuthor coAuthorJson) {

		Service service = new Service();
		service.setStatus("Success");
		userProfileService.editCoAuthor(userId, coAuthorJson);
		return service;
	}

	/**
	 * This service will delete the co-author which are tagged to the
	 * user/author.
	 * 
	 * @param userId
	 * @param coAuthorId
	 * @return
	 */
	@RequestMapping(value = "/coAuthor/delete/{userId}/{coAuthorId}", method = RequestMethod.GET)
	public Service deleteCoAuthor(@PathVariable("userId") String userId,
			@PathVariable("coAuthorId") String coAuthorId) {

		Service service = new Service();
		service.setStatus("Success");
		userProfileService.deleteCoAuthor(userId, coAuthorId);
		return service;
	}

	/**
	 * @param userId
	 * @param coAuthorJson
	 * @return
	 */
	@RequestMapping(value = "/addCoAuthor/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service addCoAuthor(@PathVariable("userId") String userId,
			@RequestBody String coAuthorJson) {

		return null;
	}

	/**
	 * @param userId
	 * @return
	 */

	@RequestMapping(value = "/getPreferredJournals/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getPreferredJournals(@PathVariable("userId") String userId) {

		Service service = new Service();
		service.setStatus("success");

		service.setPayload(userProfileService.getPreferredJournals(userId));

		return service;
	}

	/**
	 * @param userId
	 * @param journalId
	 * @return
	 */
	@RequestMapping(value = "/deletePreferredJournals/{userId}/{journalId}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Service deletePreferredJournals(
			@PathVariable("userId") String userId,
			@PathVariable("journalId") String journalId) {
		Service service = new Service();
		service.setPayload(userProfileService.deletePreferredJournals(userId,
				journalId));

		return new Service();
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/searchPreferredJournals/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service searchPreferredJournals(@PathVariable("userId") String userId) {

		return null;
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getArticlesPublishedForJournals/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getArticlesPublishedForJournals(
			@PathVariable("userId") String userId) {

		return null;
	}

	/**
	 * @param userId
	 * @return
	 */

	@RequestMapping(value = "/getListOfAlerts/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getListOfAlerts(@PathVariable("userId") String userId) {
		Service service = new Service();
		service.setStatus("success");
		service.setPayload(userProfileService.getListOfAlerts(userId));

		return service;
	}

	/**
	 * @param userId
	 * @param alertsJson
	 * @return
	 */
	@RequestMapping(value = "/updateAlerts/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service updateAlerts(@PathVariable("userId") String userId,
			@RequestBody List<Alert> alertsList) {
		userProfileService.updateAlerts(userId, alertsList);

		return new Service();
	}

}
