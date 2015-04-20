package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Service;

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
	public Service editSocietyDetails(@PathVariable("userId") String userId, @PathVariable("societyId") String societyId) {

		return null;
	}
	
	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	@RequestMapping(value = "/deleteSociety/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service deleteSociety(@PathVariable("userId") String userId, @PathVariable("societyId") String societyId) {

		return null;
	}
	
	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	@RequestMapping(value = "/updateSocietyDetails/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service updateSocietyDetails(@PathVariable("userId") String userId, @RequestBody String societyId) {

		return null;
	}
	
	
	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	@RequestMapping(value = "/addSociety/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service addSociety(@PathVariable("userId") String userId, @RequestBody String societyId) {

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
	public Service addInterests(@PathVariable("userId") String userId, @RequestBody String interestsJson) {

		return null;
	}
	
	/**
	 * @param userId
	 * @param interestId
	 * @return
	 */
	@RequestMapping(value = "/removeInterest/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service removeInterest(@PathVariable("userId") String userId, @RequestBody String interestId) {

		return null;
	}
	
	/**
	 * @param userId
	 * @param searchString
	 * @return
	 */
	@RequestMapping(value = "/searchInterests/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service searchInterests(@PathVariable("userId") String userId, @RequestParam(required = false, value = "searchStr") String searchString) {

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
}
