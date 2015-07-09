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

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.UserProfileAlerts;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;

/**
 * @author virtusa version 1.0
 */
@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

    /**
     * Logger configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserProfileController.class);

    /**
     * AuthorProfileService bean.
     */
    @Autowired
    private AuthorProfileService authorProfileService;

    /**
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/affiliations/{userId}", method = RequestMethod.GET)
    public final Service getAffiliationsList(
            @PathVariable("userId") final int userId) {
        UserProfileController.LOGGER.info("inside getAffiliationsList method ");
        Service service = new Service();
        service.setPayload(authorProfileService.getuserProfileResponse(userId)
                .getCustomerProfile().getAffiliations());
        return service;
    }

    /**
     * @param userId
     *            - The request value
     * @param affiliation
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/affiliations/{userId}/{affiliationId}", method = RequestMethod.POST)
    public final Service updateAffiliation(
            @PathVariable("userId") final int userId,
            @RequestBody final Affiliation affiliation) {
        UserProfileController.LOGGER.info("inside updateAffiliation method ");
        affiliation.setUserId(userId);
        Service service = new Service();
        authorProfileService.updateAffiliation(userId, affiliation);
        return service;
    }

    /**
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/researchFunders/{userId}", method = RequestMethod.GET)
    public final Service getResearchFundersList(
            @PathVariable("userId") final int userId) {

        UserProfileController.LOGGER
                .info("inside getResearchFundersList method ");
        Service service = new Service();
        service.setPayload(authorProfileService.getuserProfileResponse(userId)
                .getCustomerProfile().getResearchFunders());
        return service;
    }

    /**
     * @param userId
     *            - The request value
     * @param researchFunder
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/researchFunder/{userId}", method = RequestMethod.POST)
    public final Service updateResearchFunder(
            @PathVariable("userId") final int userId,
            @RequestBody final ResearchFunder researchFunder) {

        UserProfileController.LOGGER
                .info("inside updateResearchFunder method ");
        Service service = new Service();
        service.setPayload(authorProfileService.updateResearchFunder(userId,
                researchFunder));
        return service;
    }

    /**
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/societies/{userId}", method = RequestMethod.GET)
    public final Service getSocietiesList(
            @PathVariable("userId") final int userId) {

        UserProfileController.LOGGER.info("inside getSocietiesList method ");
        Service service = new Service();
        service.setPayload(authorProfileService.getuserProfileResponse(userId)
                .getCustomerProfile().getSocieties());
        return service;
    }

    /**
     * @param userId
     *            - The request value
     * @param society
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/societies/{userId}", method = RequestMethod.POST)
    public final Service updateSocietyDetails(
            @PathVariable("userId") final int userId,
            @Valid @RequestBody final Society society) {

        UserProfileController.LOGGER
                .info("inside updateSocietyDetails method ");
        authorProfileService.updateSocietyDetails(userId, society);
        return new Service();
    }

    /**
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/interests/{userId}", method = RequestMethod.GET)
    public final Service getMyInterests(@PathVariable("userId") final int userId) {

        UserProfileController.LOGGER.info("inside getMyInterests method ");
        Service service = new Service();
        service.setPayload(authorProfileService.getuserProfileResponse(userId)
                .getCustomerProfile().getInterests());
        return service;
    }

    /**
     * @param userId
     *            - The request value
     * @param searchString
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/interests/search/{userId}", method = RequestMethod.POST)
    public final Service searchInterests(
            @PathVariable("userId") final String userId,
            @RequestParam(required = false, value = "searchStr") final String searchString) {
        UserProfileController.LOGGER.info("inside searchInterests method ");

        return new Service();
    }

    /**
     * This service will give list of Co-authors that are tagged to the
     * author/user.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/coAuthors/{userId}", method = RequestMethod.GET)
    public final Service getCoAuthorsList(
            @PathVariable("userId") final int userId) {

        UserProfileController.LOGGER.info("inside getCoAuthorsList method ");
        Service service = new Service();
        service.setPayload(authorProfileService.getuserProfileResponse(userId)
                .getCustomerProfile().getCoAuthors());
        return service;
    }

    /**
     * @param userId
     *            - The request value
     * @param coAuthor
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/coAuthors/{userId}", method = RequestMethod.POST)
    public final Service updateCoAuthors(@PathVariable final int userId,
            @RequestBody final CoAuthor coAuthor) {

        UserProfileController.LOGGER.info("inside updateCoAuthors method ");
        Service service = new Service();
        coAuthor.setUserId(userId);
        service.setPayload(authorProfileService
                .updatecoAuthor(userId, coAuthor));
        return new Service();
    }

    /**
     * @param userId
     *            - The request value
     * @return service
     */

    @RequestMapping(value = "/preferredJournals/{userId}", method = RequestMethod.GET)
    public final Service getPreferredJournals(
            @PathVariable("userId") final int userId) {

        UserProfileController.LOGGER
                .info("inside getPreferredJournals method ");
        Service service = new Service();
        service.setPayload(authorProfileService.getuserProfileResponse(userId)
                .getCustomerProfile().getPreferredJournals());
        return service;
    }

    /**
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/preferredJournals/search/{userId}", method = RequestMethod.POST)
    public final Service searchPreferredJournals(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER
                .info("inside searchPreferredJournals method ");
        return new Service();
    }

    /**
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/articlesPublishedForJournals/{userId}", method = RequestMethod.GET)
    public final Service getArticlesPublishedForJournals(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER
                .info("inside getArticlesPublishedForJournals method ");
        return new Service();
    }

    /**
     * @param userId
     *            - The request value
     * @return service
     */

    @RequestMapping(value = "/alerts/{userId}", method = RequestMethod.GET)
    public final Service getListOfAlerts(
            @PathVariable("userId") final int userId) {

        UserProfileController.LOGGER.info("inside getListOfAlerts method ");
        Service service = new Service();

        service.setPayload(authorProfileService.getuserProfileResponse(userId)
                .getCustomerProfile().getAlerts());
        return service;
    }

    /**
     * @param userId
     *            - The request value
     * @param userProfileAlerts
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/alerts/{userId}", method = RequestMethod.POST)
    public final Service updateAlerts(@PathVariable("userId") final int userId,
            @RequestBody final UserProfileAlerts userProfileAlerts) {

        UserProfileController.LOGGER.info("inside updateAlerts method ");
        authorProfileService.updateAlerts(userId, userProfileAlerts);
        return new Service();
    }

    /**
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/jobCategories/{userId}", method = RequestMethod.GET)
    public final Service getJobCategories(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside getJobCategories method ");
        return new Service();
    }

    /**
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/lookUpProfile/{userId}", method = RequestMethod.GET)
    public final Service lookUpProfile(@PathVariable("userId") final int userId) {

        UserProfileController.LOGGER.info("inside lookUpProfile method ");
        Service service = new Service();
        service.setPayload(authorProfileService.getuserProfileResponse(userId));
        return service;

    }

    /**
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/industries/{userId}", method = RequestMethod.GET)
    public final Service getIndustries(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside getIndustries method ");
        return new Service();
    }
}
