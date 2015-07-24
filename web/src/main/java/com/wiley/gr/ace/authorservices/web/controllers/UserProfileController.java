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

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.ProfilePicture;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.UserProfileAlerts;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;

/**
 * The Class UserProfileController.
 *
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

    /** The image size code. */
    @Value("${imageSizeMore.code}")
    private String imageSizeCode;

    /** The image size message. */
    @Value("${imageSizeMore.message}")
    private String imageSizeMessage;

    /** The image not foundcd. */
    @Value("${imageNotFound.Code}")
    private String imageNotFoundcd;

    /** The image not found message. */
    @Value("${imageNotFound.Message}")
    private String imageNotFoundMessage;

    /**
     * Gets the affiliations list.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/affiliations/{userId}", method = RequestMethod.GET)
    public final Service getAffiliationsList(
            @PathVariable("userId") final String userId) {
        UserProfileController.LOGGER.info("inside getAffiliationsList method ");
        Service service = new Service();
        service.setPayload(authorProfileService
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAffiliations());
        return service;
    }

    /**
     * Update affiliation.
     *
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
     * Gets the research funders list.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/researchFunders/{userId}", method = RequestMethod.GET)
    public final Service getResearchFundersList(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER
                .info("inside getResearchFundersList method ");
        Service service = new Service();
        service.setPayload(authorProfileService
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getResearchFunders());
        return service;
    }

    /**
     * Update research funder.
     *
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
     * Gets the societies list.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/societies/{userId}", method = RequestMethod.GET)
    public final Service getSocietiesList(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside getSocietiesList method ");
        Service service = new Service();
        service.setPayload(authorProfileService
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getSocietyList().getSociety());
        return service;
    }

    /**
     * Update society details.
     *
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
     * Gets the my interests.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/interests/{userId}", method = RequestMethod.GET)
    public final Service getMyInterests(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside getMyInterests method ");
        Service service = new Service();
        service.setPayload(authorProfileService
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAreaOfInterest());

        return service;
    }

    /**
     * Search interests.
     *
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
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside getCoAuthorsList method ");
        Service service = new Service();
        service.setPayload(authorProfileService
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getCoAuthors());
        return service;
    }

    /**
     * Update co authors.
     *
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
     * Gets the preferred journals.
     *
     * @param userId
     *            - The request value
     * @return service
     */

    @RequestMapping(value = "/preferredJournals/{userId}", method = RequestMethod.GET)
    public final Service getPreferredJournals(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER
                .info("inside getPreferredJournals method ");
        Service service = new Service();
        service.setPayload(authorProfileService
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getFavoriteJournals());
        return service;
    }

    /**
     * Search preferred journals.
     *
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
     * Gets the articles published for journals.
     *
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
     * Gets the list of alerts.
     *
     * @param userId
     *            - The request value
     * @return service
     */

    @RequestMapping(value = "/alerts/{userId}", method = RequestMethod.GET)
    public final Service getListOfAlerts(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside getListOfAlerts method ");
        Service service = new Service();

        service.setPayload(authorProfileService
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAlerts());
        return service;
    }

    /**
     * Update alerts.
     *
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
     * Gets the job categories.
     *
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
     * Look up profile.
     *
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
     * Gets the industries.
     *
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

    /**
     * This method is for uploading image.
     *
     * @param profilePicture
     *            the profile picture
     * @return the service
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @RequestMapping(value = "/uploadimage/", method = RequestMethod.GET)
    public Service profilePicture(
            @RequestBody final ProfilePicture profilePicture)
            throws IOException {
        Service service = new Service();
        String imageString = FileUtils.readFileToString(profilePicture
                .getImage());
        File file = new File(imageString);
        if (file.exists()) {
            double bytes = file.length();
            double kilobytes = bytes / 1024;
            double megabytes = kilobytes / 1024;
            if (megabytes > 1) {
                throw new ASException(imageSizeCode, imageSizeMessage);
            } else if (megabytes < 1) {
                authorProfileService.uploadImage(profilePicture.getImage(),
                        profilePicture.getUserId());
            }
        } else {
            throw new ASException(imageNotFoundcd, imageNotFoundMessage);
        }
        return service;
    }

    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/lookUpProfileCustomer/{userId}", method = RequestMethod.GET)
    public final Service lookUpProfile(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside lookUpProfile method ");
        Service service = new Service();
        service.setPayload(authorProfileService
                .getLookupCustomerProfile(userId));
        return service;

    }
}
