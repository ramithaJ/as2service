package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	 * The affiliation data will be input as json through POST. This will get called when user clicks on Edit button
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
	public Service updateAffiliation(@PathVariable("userId") String userId, @RequestBody String affiliationJson) {
		
		return null;
	}
	
	/**
	 * The affiliation data will be input as json through POST
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/deleteAffiliation/{userId}/{affiliationId}", method = RequestMethod.POST, produces = "application/json")
	public Service deleteAffiliation(@PathVariable("userId") String userId, @PathVariable("affiliationId") String affiliationId) {
		
		return null;
	}
	
	
	/**
	 * This method takes affiliations in POST of request
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/addAffiliation/{userId}", method = RequestMethod.POST, produces = "application/json")
	public Service addAffiliation(@PathVariable("userId") String userId, @RequestBody String affiliationJson) {
		
		return null;
	}
	
	
	@RequestMapping(value = "/getResearchFunders/{userId}", method = RequestMethod.GET, produces = "application/json")
	public Service getResearchFundersList(@PathVariable("userId") String userId) {
		
		return null;
	}

}
