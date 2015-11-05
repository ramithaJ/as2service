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

import java.io.IOException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.AlertsList;
import com.wiley.gr.ace.authorservices.model.AreaOfInterests;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
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

    @Value("${UserProfileController.affiliations.code}")
    private String affiliationsErrorCode;

    @Value("${UserProfileController.affiliations.message}")
    private String affiliationsErrorMessage;

    @Value("${UserProfileController.alerts.code}")
    private String alertsErrorCode;

    @Value("${UserProfileController.alerts.message}")
    private String alertsErrorMessage;

    @Value("${UserProfileController.profilePicture.code}")
    private String profilePictureErrorCode;

    @Value("${UserProfileController.profilePicture.message}")
    private String profilePictureErrorMessage;

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
        LOGGER.info("inside getAffiliationsList method ");
        final Service service = new Service();
        try {
            service.setPayload(authorProfileService.getAffiliationList(userId));
        } catch (final Exception e) {
            LOGGER.info(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(affiliationsErrorCode,
                    affiliationsErrorMessage);
        }

        return service;
    }

    /**
     * Update affiliation.
     *
     * @param userId
     *            - The request value
     * @param affiliationId
     *            the affiliation id
     * @param affiliationsUpdate
     *            the affiliations update
     * @return service
     */
    @RequestMapping(value = "/affiliations/{userId}/{affiliationId}/", method = RequestMethod.POST)
    public final Service updateAffiliation(
            @PathVariable("userId") final String userId,
            @PathVariable("affiliationId") final String affiliationId,
            @RequestBody final Affiliation affiliationsUpdate) {
        LOGGER.info("inside updateAffiliation method ");
        System.err.println(affiliationId);
        final Service service = new Service();
        try {
            authorProfileService.updateAffiliation(userId, affiliationsUpdate,
                    affiliationId);
        } catch (final Exception e) {
            LOGGER.info(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(affiliationsErrorCode,
                    affiliationsErrorMessage);
        }

        return service;
    }

    /**
     * Delete affiliation.
     *
     * @param userId
     *            - The request value
     * @param affiliationId
     *            the affiliation id
     * @return service
     */
    @RequestMapping(value = "/affiliations/{userId}/{affiliationId}/", method = RequestMethod.DELETE)
    public final Service deleteAffiliation(
            @PathVariable("userId") final String userId,
            @PathVariable("affiliationId") final String affiliationId) {
        UserProfileController.LOGGER.info("inside deleteaffiliation method ");
        final Service service = new Service();
        try {
            authorProfileService.deleteAffiliations(userId, affiliationId);
        } catch (final Exception e) {
            LOGGER.info(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(affiliationsErrorCode,
                    affiliationsErrorMessage);
        }

        return service;
    }

    /**
     * Gets the research funders list.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/researchFunders/{participantId}/", method = RequestMethod.GET)
    public final Service getResearchFundersList(
            @PathVariable("participantId") final String participantId) {

        UserProfileController.LOGGER
                .info("inside getResearchFundersList method ");
        final Service service = new Service();
        service.setPayload(authorProfileService
                .getResearchFundersList(participantId));

        return service;
    }

    @RequestMapping(value = "/researchFunder/{participantId}/", method = RequestMethod.POST)
    public final Service updateResearchFunder(
            @PathVariable("participantId") final String participantId,
            @RequestBody final ResearchFunder researchFunder) {
        UserProfileController.LOGGER
                .info("inside updateResearchFundersList method ");
        Service service = new Service();
        authorProfileService.updateResearchFunders(participantId,
                researchFunder);
        return service;
    }

    @RequestMapping(value = "/researchFunder/{participantSeqId}/", method = RequestMethod.DELETE)
    public final Service deleteResearchFunder(
            @PathVariable("participantSeqId") final Long participantSeqId) {

        UserProfileController.LOGGER
                .info("inside deleteResearchFunder method ");
        Service service = new Service();

        authorProfileService.deleteResearchFunder(participantSeqId);
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

        LOGGER.info("inside getSocietiesList method ");
        final Service service = new Service();
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
            @PathVariable("userId") final String userId,
            @Valid @RequestBody final Society society) {

        final Service service = new Service();
        UserProfileController.LOGGER
                .info("inside updateSocietyDetails method ");
        authorProfileService.updateSocietyDetails(userId, society);
        return service;
    }

    /**
     * Delete society details.
     *
     * @param userId
     *            - The request value
     * @param societyId
     *            - The request value
     * @param id
     *            the id
     * @return service
     */
    @RequestMapping(value = "/societies/{id}", method = RequestMethod.DELETE)
    public final Service deleteSocietyDetails(@PathVariable("id") final Long id) {
        UserProfileController.LOGGER
                .info("inside deleteSocietyDetails method ");
        final Service service = new Service();
        authorProfileService.deleteSociety(id);
        return service;
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
        final Service service = new Service();
        service.setPayload(authorProfileService.getAreaOfInterests(userId));

        return service;
    }

    /**
     * Adds the interests.
     *
     * @param userId
     *            - The request value
     * @param areaOfInterests
     *            the area of interests
     * @return service
     */
    @RequestMapping(value = "/interests/{userId}/", method = RequestMethod.POST)
    public final Service addInterests(
            @PathVariable("userId") final String userId,
            @RequestBody final AreaOfInterests areaOfInterests) {
        final Service service = new Service();

        service.setPayload(authorProfileService.addInterests(userId,
                areaOfInterests));
        return service;

    }

    /**
     * Delete interests.
     *
     * @param userId
     *            - The request value
     * @param interestId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/interests/{userId}/{interestId}/", method = RequestMethod.DELETE)
    public final Service deleteInterests(
            @PathVariable("userId") final String userId,
            @PathVariable("interestId") final String interestId) {
        UserProfileController.LOGGER.info("inside searchInterests method ");
        final Service service = new Service();
        service.setPayload(authorProfileService.deleteInterests(userId,
                interestId));
        return service;
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
        final Service service = new Service();
        service.setPayload(authorProfileService.getsCoAuthorsList(userId));

        return service;
    }

    /**
     * Gets the preferred journals.
     *
     * @param userId
     *            - The request value
     * @return service
     */

    @RequestMapping(value = "/preferredJournals/{participantId}/", method = RequestMethod.GET)
    public final Service getPreferredJournals(
            @PathVariable("participantId") final String participantId) {

        UserProfileController.LOGGER
                .info("inside getPreferredJournals method ");
        final Service service = new Service();
        service.setPayload(authorProfileService
                .getPrefferedJournals(participantId));
        return service;
    }

    /**
     * Search preferred journals.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/preferredJournals/{userId}/", method = RequestMethod.POST)
    public final Service searchPreferredJournals(
            @PathVariable("userId") final String userId,
            @RequestBody final JournalDetails journalDetails) {
        final Service service = new Service();
        UserProfileController.LOGGER
                .info("inside searchPreferredJournals method ");
        service.setPayload(authorProfileService.addPreferredJournal(userId,
                journalDetails));
        return service;
    }

    /**
     * delete preferred journals.
     *
     * @param userId
     *            - The request value
     * @param journalId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/preferredJournals/{userId}/{journalId}/", method = RequestMethod.DELETE)
    public final Service deletePreferredJournals(
            @PathVariable("userId") final String userId,
            @PathVariable("journalId") final String journalId) {

        UserProfileController.LOGGER
                .info("inside searchPreferredJournals method ");
        final Service service = new Service();
        service.setPayload(authorProfileService.deletePreferredJournals(userId,
                journalId));
        return service;
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
     *            the user id
     * @return the list of alerts
     */
    @RequestMapping(value = "/alerts/{userId}", method = RequestMethod.GET)
    public final Service getListOfAlerts(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside getListOfAlerts method ");
        final Service service = new Service();
        try {
            service.setPayload(authorProfileService.getAlerts(userId));
        } catch (final Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(alertsErrorCode, alertsErrorMessage);
        }
        return service;
    }

    /**
     * Update alerts.
     *
     * @param userId
     *            the user id
     * @param listOfalert
     *            the list ofalert
     * @return the service
     */
    @RequestMapping(value = "/alerts/{userId}", method = RequestMethod.POST)
    public final Service updateAlerts(
            @PathVariable("userId") final String userId,
            @RequestBody final AlertsList listOfalert) {
        UserProfileController.LOGGER.info("inside updateAlerts method ");

        final Service service = new Service();
        try {
            authorProfileService.updateAlerts(userId, listOfalert);
        } catch (final Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(alertsErrorCode, alertsErrorMessage);
        }
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
     * Gets the profile.
     *
     * @param userId
     *            the user id
     * @return the profile
     * @throws Exception
     */
    @RequestMapping(value = "/getImage/{userId}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public final @ResponseBody FileSystemResource getProfile(
            @PathVariable("userId") final String userId) throws Exception {
        UserProfileController.LOGGER.info("inside getProfile method ");
        FileSystemResource imageFile = new FileSystemResource(
                authorProfileService.getProfileImage(userId));
        return imageFile;

    }

    /**
     * Profile picture.
     *
     * @param userId
     *            the user id
     * @param image
     *            the image
     * @return the service
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @RequestMapping(value = "/uploadImage/{userId}/", method = RequestMethod.POST)
    public final Service profilePicture(
            @PathVariable("userId") final String userId,
            @PathVariable("file") final MultipartFile image) throws IOException {
        UserProfileController.LOGGER.info("inside profilePicture method ");
        final Service service = new Service();
        try {
            if (!image.isEmpty()) {
                byte[] imageValue = image.getBytes();
                final int value = 1024;
                final double bytes = imageValue.length;
                final double kilobytes = bytes / value;
                final double megabytes = kilobytes / value;
                if (megabytes > 1) {
                    throw new ASException(imageSizeCode, imageSizeMessage);
                } else if (megabytes < 1) {
                    authorProfileService.uploadProfileImage(userId, imageValue);
                }
            }
        } catch (final Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(profilePictureErrorCode,
                    profilePictureErrorMessage);
        }

        return service;
    }

    /**
     * Gets the alerts.
     *
     * @param participantId
     *            the participant id
     * @return the alerts
     */
    @RequestMapping(value = "/{participantId}/alerts", method = RequestMethod.GET)
    public Service getAlerts(
            @PathVariable("ParticipantId") final String participantId) {
        final Service service = new Service();
        try {
            service.setPayload(authorProfileService.getAlerts(participantId));
        } catch (final Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(alertsErrorCode, alertsErrorMessage);
        }
        return service;

    }

    /**
     * get WOA accounts.
     * 
     * @param participantId
     *            the request value.
     * @return service
     */
    @RequestMapping(value = "/woaaccounts/{participantId}/", method = RequestMethod.GET)
    public Service getWOAAccounts(
            @PathVariable("ParticipantId") final String participantId) {
        final Service service = new Service();
        service.setPayload(authorProfileService.getWOAaccounts(participantId));
        return service;
    }

    /**
     * Gets the WOA details.
     *
     * @param userId
     *            - the request value .
     * @return service
     */
    @RequestMapping(value = "/getWOADetails/{userId}", method = RequestMethod.GET)
    public final Service getWOADetails(
            @PathVariable("userId") final String userId) {

        Service service = new Service();
        service.setStatus("FAILURE");
        ErrorPOJO error = new ErrorPOJO();
        error.setCode("PROFILE_ACCNT_NO_WOA_ACCNT_ERR_TEXT");
        error.setMessage("You have not used any WOA accounts for ordering to be displayed here");
        service.setError(error);
        return service;

    }
}
