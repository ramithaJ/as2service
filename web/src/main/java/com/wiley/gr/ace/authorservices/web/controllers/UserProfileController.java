package com.wiley.gr.ace.authorservices.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.context.ServiceBeanConfig;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;
import com.wiley.gr.ace.authorservices.services.service.impl.UserProfileServiceImpl;

/**
 * @author SarmaKumarap
 *
 */
@RestController
@RequestMapping("/userprofile")
public class UserProfileController {
	public static ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceBeanConfig.class);

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getAffiliations/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getAffiliationsList(@PathVariable("userId") String userId) {

		return null;
	}

	/**
	 * The affiliation data will be input as json through POST. This will get
	 * called when user clicks on Edit button
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/editAffiliation/{userId}/{affiliationId}", method = RequestMethod.GET, produces = "application/json")
	public Service editAffiliation(@PathVariable("userId") String userId) {

		return null;
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/updateAffiliation/{userId}/{affiliationId}", method = RequestMethod.POST, produces = "application/json")
	public Service updateAffiliation(@PathVariable("userId") String userId,
			@RequestBody String affiliationJson) {

		return null;
	}

	/**
	 * The affiliation data will be input as json through POST
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/deleteAffiliation/{userId}/{affiliationId}", method = RequestMethod.POST, produces = "application/json")
	public Service deleteAffiliation(@PathVariable("userId") String userId,
			@RequestBody String affiliationId) {

		return null;
	}

	/**
	 * This method takes affiliations in POST of request
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/addAffiliation/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service addAffiliation(@PathVariable("userId") String userId,
			@RequestBody String affiliationJson) {

		return null;
	}

	/**
	 * Returns the list of all research funders added by the user.
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getResearchFunders/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getResearchFundersList(@PathVariable("userId") String userId) {

		return null;
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
	@RequestMapping(value = "/updateResearchFunder/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service updateResearchFunder(@PathVariable("userId") String userId,
			@RequestBody String funderJson) {

		return null;
	}

	/**
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getSocietiesList/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getSocietiesList(@PathVariable("userId") String userId) {

		return null;
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

		return null;
	}

	/**
	 * @param userId
	 * @param interestsJson
	 * @return
	 */
	@RequestMapping(value = "/addInterests/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service addInterests(@PathVariable("userId") String userId,
			@RequestBody String interestsJson) {

		return null;
	}

	/**
	 * @param userId
	 * @param interestId
	 * @return
	 */
	@RequestMapping(value = "/removeInterest/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service removeInterest(@PathVariable("userId") String userId,
			@RequestBody String interestId) {

		return null;
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
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/getCoAuthorsList/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getCoAuthorsList(@PathVariable("userId") String userId) {

		return null;
	}

	/**
	 * @param userId
	 * @param coAuthorId
	 * @return
	 */
	@RequestMapping(value = "/editCoAuthor/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service editCoAuthor(@PathVariable("userId") String userId,
			@PathVariable("coAuthorId") String coAuthorId,
			@RequestBody String coAuthorJson) {

		return null;
	}

	/**
	 * @param userId
	 * @param coAuthorId
	 * @return
	 */
	@RequestMapping(value = "/deleteCoAuthor/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service deleteCoAuthor(@PathVariable("userId") String userId,
			@PathVariable("coAuthorId") String coAuthorId) {

		return null;
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

		return null;
	}

	/**
	 * @param userId
	 * @param journalId
	 * @return
	 */
	@RequestMapping(value = "/deletePreferredJournals/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service deletePreferredJournals(
			@PathVariable("userId") String userId, @RequestBody String journalId) {

		return null;
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

		UserProfileService userProfileService = (UserProfileServiceImpl) context
				.getBean("UserProfileService");
		Service service = new Service();
		service.setStatus("success");
		service.setServiceObject(userProfileService.getListOfAlerts(userId));

		return service;
	}

	/**
	 * @param userId
	 * @param alertsJson
	 * @return
	 */
	@RequestMapping(value = "/updateAlerts/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service updateAlerts(@PathVariable("userId") String userId,
			@RequestBody String alertsJson) {
		UserProfileService userProfileService = (UserProfileServiceImpl) context
				.getBean("UserProfileService");
		Alert alert = new Alert();
		Alert alert2=new Alert();
		Service service = new Service();
	
		 System.err.println("in controller" +userId);
		// Get Json - convert to Lis
		              
		List<Alert> alerts = new ArrayList<Alert>();
         
		
		alert.setOnScreen(false);
		alert.setEmail(false);
		alert.setAlertId("19");
		alert2.setOnScreen(true);
		alert2.setEmail(true);
		alert2.setAlertId("20");
		
		
		alerts.add(alert);
		alerts.add(alert2);

		userProfileService.updateAlerts(userId,alerts);
	//	service.setServiceObject(userProfileService.updateAlerts(userId,alerts));
		

		return service;
	}

}
