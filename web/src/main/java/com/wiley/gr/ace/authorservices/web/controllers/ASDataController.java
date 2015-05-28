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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @Autowired(required = true)
    ASDataService aSDataService;
    
    /**
     * @return
     */
    @RequestMapping(value = "/titles/", method = RequestMethod.GET)
    public Service getTitles() {
        
        Service service = new Service();
        service.setPayload(aSDataService.getTitles());
        return service;
    }
    
    /**
     * @return
     */
    @RequestMapping(value = "/suffixes/", method = RequestMethod.GET)
    public Service getSuffixes() {
        
        Service service = new Service();
        service.setPayload(aSDataService.getSuffixes());
        return service;
    }
    
    /**
     * @return
     */
    @RequestMapping(value = "/industries/", method = RequestMethod.GET)
    public Service getIndustries() {
        
        Service service = new Service();
        service.setPayload(aSDataService.getIndustries());
        return service;    
    }
    
    /**
     * @return
     */
    @RequestMapping(value = "/jobCategories/", method = RequestMethod.GET)
    public Service getJobCategories() {
        
        Service service = new Service();
        service.setPayload(aSDataService.getJobCategories());
        return service;
    }
    
    /**
     * @return
     */


    @RequestMapping(value = "/countries/", method = RequestMethod.GET )
    public Service getCountries( ) {
    	
    	Service service= new Service();
    	
    	service.setPayload(aSDataService.getCountries());
        
        return service;
    }
    
    /**
     * @return
     */
    @RequestMapping(value = "/states/{countrycode}", method = RequestMethod.GET )
    public Service getStates(@PathVariable ("countrycode") String countrycode ) {
        
        return null;
    }
    
    /**
     * @return
     */
    @RequestMapping(value = "/institutions/", method = RequestMethod.GET )
    public Service getInstitutions() {
        
        return null;
    }
    
    /**
     * @return
     */
    @RequestMapping(value = "/departments/", method = RequestMethod.GET )
    public Service getDepartments() {
        
        return null;
    }
    
    /**
     * @return
     */
    @RequestMapping(value = "/researchFunders/", method = RequestMethod.GET )
    public Service getResearchFunders() {
        
        return null;
    }
    
    /**
     * @return
     */
    @RequestMapping(value = "/articles/", method = RequestMethod.GET )
    public Service getArticles() {
        
        return null;
    }
    
    @RequestMapping(value = "/societies/", method = RequestMethod.GET )
    public Service getSocieties() {
        
        return null;
    }
    
    @RequestMapping(value = "/areasOfInterests/", method = RequestMethod.GET )
    public Service getAreasOfInterests() {
    	 Service service = new Service();
         service.setPayload(aSDataService.getAreasOfInterests());
         
         return service;
    }
    
    @RequestMapping(value = "/securityQuestions/", method = RequestMethod.GET )
    public Service getSecurityQuestions() {
        
        Service service = new Service();
        service.setPayload(aSDataService.getSecurityQuestions());
        
        return service;
    }
    
    @RequestMapping(value = "/roles/", method = RequestMethod.GET )
    public Service getUserRoles() {
        
        Service service = new Service();
        service.setPayload(aSDataService.getAdminRoles(null));
        
        return service;
    }
    
    @RequestMapping(value = "/roles/{roleType}", method = RequestMethod.GET )
    public Service getAdminRoles(@PathVariable("roleType") String roleType) {
        
        Service service = new Service();
        service.setPayload(aSDataService.getAdminRoles(roleType));
        
        return service;
    }
    
    @RequestMapping(value = "/accessReasons/", method = RequestMethod.GET )
    public Service getAdminAccessReasons() {
        
        Service service = new Service();
        List<AccessReasons> accessList = aSDataService.getAccessReasons();
        
        if (accessList != null && accessList.size() > 0) {
            service.setPayload(accessList);
            
        } else {
            
            throw new ASException("1005", "No data found");
        }
        
        return service;
    }
}
