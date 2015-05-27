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

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileExternalService;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

/**
 * @author SarmaKumarap
 */
@RestController
@RequestMapping("/userprofile")
public class UserProfileController {
    
    /**
     * @param userId
     * @return
     */
    @Autowired(required = true)
    UserProfileService userProfileService;
    @Autowired
    AuthorProfileService authorProfileService;
    
    @Autowired(required = true)
    LocalValidatorFactoryBean validator;
    @Autowired
    AuthorProfileExternalService authorProfileExternalService;
    
    @RequestMapping(value = "/affiliations/{userId}", method = RequestMethod.GET, produces = "application/json")
    public Service getAffiliationsList(@PathVariable("userId") String userId) {
        
        Service service = new Service();
        
        service.setPayload(userProfileService.lookUpProfile(userId)
                .getCustomerProfile().getAffiliations());
        
        return service;
    }
    
    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/affiliations/{userId}/{affiliationId}", method = RequestMethod.POST, produces = "application/json")
    public Service updateAffiliation(@PathVariable("userId") String userId,
            @RequestBody Affiliation affiliation) {
        affiliation.setUserId(userId);
        Service service = new Service();
        service.setPayload(authorProfileService.updateAffiliation(affiliation));
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
        service.setPayload(userProfileService.lookUpProfile(userId)
                .getCustomerProfile().getResearchFunders());
        
        return service;
    }
    
    /**
     * @param userId
     * @param funderJson
     * @return
     */
    @RequestMapping(value = "/researchFunder/{userId}", method = RequestMethod.POST)
    public Service updateResearchFunder(@PathVariable("userId") String userId,
            @RequestBody ResearchFunder researchFunder) {
        
        Service service = new Service();
        service.setPayload(authorProfileService.updateResearchFunder(userId,
                researchFunder));
        return service;
    }
    
    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/societies/{userId}", method = RequestMethod.GET, produces = "application/json")
    public Service getSocietiesList(@PathVariable("userId") String userId) {
        
        Service service = new Service();
        service.setPayload(userProfileService.lookUpProfile(userId)
                .getCustomerProfile().getSocieties());
        
        return service;
    }
    
    /**
     * @param userId
     * @param societyId
     * @return
     */
    @RequestMapping(value = "/societies/{userId}", method = RequestMethod.POST, produces = "application/json")
    public Service updateSocietyDetails(@PathVariable("userId") String userId,
            @Valid @RequestBody Society society) {
        
        authorProfileService.updateSocietyDetails(society);
        
        return new Service();
    }
    
    /**
     * @param userId
     * @return
     */
//    @RequestMapping(value = "/interests/{userId}", method = RequestMethod.GET, produces = "application/json")
//    public Service getMyInterests(@PathVariable("userId") String userId) {
//        
//        Service service = new Service();
//        service.setPayload(userProfileService.lookUpProfile(userId)
//                .getCustomerProfile().getInterests());
//        
//        return service;
//    }
    @RequestMapping(value = "/interests/{userId}", method = RequestMethod.GET, produces = "application/json")
    public Service getMyInterests(@PathVariable("userId") String userId) {
        
        Service service = new Service();
        service.setPayload(authorProfileExternalService.getAreaOfInterest());
        
        return service;
    }
    
    
    /**
     * @param userId
     * @param searchString
     * @return
     */
    @RequestMapping(value = "/interests/search/{userId}", method = RequestMethod.POST, produces = "application/json")
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
        service.setPayload(userProfileService.lookUpProfile(userId)
                .getCustomerProfile().getCoAuthors());
        return service;
    }
    
    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/coAuthors/{userId}", method = RequestMethod.POST)
    public Service updateCoAuthors(@PathVariable String userId,
            @RequestBody CoAuthor coAuthor) {
        
        Service service = new Service();
        coAuthor.setUserId(Integer.parseInt(userId));
        service.setPayload(authorProfileService.UpdatecoAuthor(coAuthor));
        
        return new Service();
    }
    
    /**
     * @param userId
     * @return
     */
    
    @RequestMapping(value = "/preferredJournals/{userId}", method = RequestMethod.GET, produces = "application/json")
    public Service getPreferredJournals(@PathVariable("userId") String userId) {
        
        Service service = new Service();
        service.setPayload(userProfileService.lookUpProfile(userId)
                .getCustomerProfile().getPreferredJournals());
        
        return service;
    }
    
    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/preferredJournals/search/{userId}", method = RequestMethod.POST, produces = "application/json")
    public Service searchPreferredJournals(@PathVariable("userId") String userId) {
        
        return null;
    }
    
    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/articlesPublishedForJournals/{userId}", method = RequestMethod.GET, produces = "application/json")
    public Service getArticlesPublishedForJournals(
            @PathVariable("userId") String userId) {
        
        return null;
    }
    
    /**
     * @param userId
     * @return
     */
    
    @RequestMapping(value = "/alerts/{userId}", method = RequestMethod.GET, produces = "application/json")
    public Service getListOfAlerts(@PathVariable("userId") String userId) {
        Service service = new Service();
        service.setPayload(userProfileService.lookUpProfile(userId)
                .getCustomerProfile().getAlerts());
        
        return service;
    }
    
    /**
     * @param userId
     * @param alertsJson
     * @return
     */
    @RequestMapping(value = "/alerts/{userId}", method = RequestMethod.POST, produces = "application/json")
    public Service updateAlerts(@PathVariable("userId") String userId,
            @RequestBody List<Alert> alertsList) {
        authorProfileService.updateAlerts(userId, alertsList);
        
        return new Service();
    }
    
    @RequestMapping(value = "/lookUpProfile/{userId}", method = RequestMethod.GET)
    public Service lookUpProfile(@PathVariable("userId") String userId) {
        
        Service service = new Service();
        service.setPayload(userProfileService.lookUpProfile(userId));
        return service;
        
    }
}
