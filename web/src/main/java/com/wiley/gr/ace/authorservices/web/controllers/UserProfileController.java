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
import java.util.List;

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
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.ProfilePicture;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.Society;
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
    @RequestMapping(value = "/affiliations/{userId}/", method = RequestMethod.GET)
    public final Service getAffiliationsList(
            @PathVariable("userId") final String userId) {
        UserProfileController.LOGGER.info("inside getAffiliationsList method ");
        Service service = new Service();
        service.setPayload(authorProfileService.getAffiliationsList(userId));

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
        Service service = new Service();
        System.err.println(affiliation.getId());
        authorProfileService.updateAffiliation(userId, affiliation);

        return service;
    }

    /**
     * Delete affiliation.
     *
     * @param userId
     *            - The request value
     * @param affiliation
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/affiliations/{userId}/{affiliationId}/", method = RequestMethod.DELETE)
    public final Service deleteAffiliation(
            @PathVariable("userId") final int userId) {
        UserProfileController.LOGGER.info("inside deleteaffiliation method ");
        return new Service();
    }

    /**
     * Gets the research funders list.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/researchFunders/{userId}/", method = RequestMethod.GET)
    public final Service getResearchFundersList(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER
                .info("inside getResearchFundersList method ");
        Service service = new Service();
        service.setPayload(authorProfileService.getResearchFundersList(userId));

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
        service.setPayload(authorProfileService.getSocietylist(userId));
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

        System.err.println(society.getPromoCode());
        Service service = new Service();

        UserProfileController.LOGGER
                .info("inside updateSocietyDetails method ");
        service.setPayload(authorProfileService.updateSocietyDetails(userId,
                society));
        return service;
    }

    /**
     * delete society details.
     *
     * @param userId
     *            - The request value
     * @param society
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/societies/{userId}/{societyId}/", method = RequestMethod.DELETE)
    public final Service deleteSocietyDetails(
            @PathVariable("userId") final int userId,
            @PathVariable("societyId") final int societyId) {

        UserProfileController.LOGGER
                .info("inside deleteSocietyDetails method ");
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
        service.setPayload(authorProfileService.getAreaOfInterests(userId));

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
     * Delete interests.
     *
     * @param userId
     *            - The request value
     * @param searchString
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/interests/{userId}/{interestId}/", method = RequestMethod.DELETE)
    public final Service deleteInterests(
            @PathVariable("userId") final String userId,
            @PathVariable("interestId") final String interestId) {
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
    @RequestMapping(value = "/coAuthors/{userId}/", method = RequestMethod.GET)
    public final Service getCoAuthorsList(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside getCoAuthorsList method ");
        Service service = new Service();
        service.setPayload(authorProfileService.getsCoAuthorsList(userId));

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
        service.setPayload(authorProfileService.getPrefferedJournals(userId));
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
     * delete preferred journals.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/preferredJournals/{userId}/{journalId}/", method = RequestMethod.DELETE)
    public final Service deletePreferredJournals(
            @PathVariable("userId") final String userId,
            @PathVariable("journalId") final String journalId) {

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

        service.setPayload(authorProfileService.getListOfAlerts(userId));
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
    @RequestMapping(value = "/alerts/{userId}/", method = RequestMethod.POST)
    public final Service updateAlerts(
            @PathVariable("userId") final String userId,
            @RequestBody final List<Alert> listOfalert) {
        UserProfileController.LOGGER.info("inside updateAlerts method ");
        Service service=new Service();
        service.setPayload(authorProfileService.updateAlerts(userId, listOfalert));
        return service ;
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
    @RequestMapping(value = "/uploadimage/", method = RequestMethod.POST)
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
