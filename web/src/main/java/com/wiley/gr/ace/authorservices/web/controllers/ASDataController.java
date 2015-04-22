package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Service;

/**
 * This controller is used to get common data in dropdown across application
 * 
 * @author SarmaKumarap
 *
 */
@RestController
@RequestMapping("/asdata")
public class ASDataController {
	
	
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
	

}
