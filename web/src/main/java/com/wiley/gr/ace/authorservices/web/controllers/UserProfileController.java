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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.AlertsList;
import com.wiley.gr.ace.authorservices.model.AreaOfInterests;
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
        final Service service = new Service();
        try {
            service.setPayload(authorProfileService.getAffiliationList(userId));
        } catch (final Exception e) {
            throw new UserException("50009", e.getMessage());
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
            @PathVariable("userId") final int userId,
            @PathVariable("affiliationId") final String affiliationId,
            @RequestBody final Affiliation affiliationsUpdate) {
        UserProfileController.LOGGER.info("inside updateAffiliation method ");
        final Service service = new Service();
        boolean isUpdated = false;
        try {
            isUpdated = authorProfileService.updateAffiliation(
                    Integer.toString(userId), affiliationsUpdate);
        } catch (final Exception e) {
            throw new UserException("50006", e.getMessage());
        }
        if (isUpdated) {
            service.setStatus("SUCCESS");
            service.setPayload(isUpdated);
        } else {
            service.setStatus("Failure");
            service.setPayload(isUpdated);
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
        boolean isDeleted = false;
        try {
            isDeleted = authorProfileService.deleteAffiliations(userId);
        } catch (final Exception e) {
            throw new UserException("50006", e.getMessage());
        }
        if (isDeleted) {
            service.setStatus("SUCCESS");
            service.setPayload(isDeleted);
        } else {
            service.setStatus("Failure");
            service.setPayload(isDeleted);
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

    @RequestMapping(value = "/researchFunders/{participantId}/", method = RequestMethod.POST)
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

    @RequestMapping(value = "/researchFunders/{participantSeqId}/", method = RequestMethod.DELETE)
    public final Service updateResearchFunder(
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

        UserProfileController.LOGGER.info("inside getSocietiesList method ");
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

    @RequestMapping(value = "/preferredJournals/{participantId}", method = RequestMethod.GET)
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
            throw new UserException("5005", "Unable to fetch");
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
        boolean isUpdated = false;
        final Service service = new Service();
        try {
            isUpdated = authorProfileService.updateAlerts(userId, listOfalert);
        } catch (final Exception e) {
            throw new UserException("50006", e.getMessage());
        }
        if (isUpdated) {
            service.setStatus("SUCCESS");
            service.setPayload(isUpdated);
        } else {
            service.setStatus("Failure");
            service.setPayload(isUpdated);
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
     */
    @RequestMapping(value = "/getImage/{userId}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public final byte[] getProfile(@PathVariable("userId") final String userId) {
        UserProfileController.LOGGER.info("inside getProfile method ");
        final byte[] bites = null;
//        try {
//            final File file = new File("c:/Images/Image");
//
//            // service.setPayload(authorProfileService.getProfileImage(userId));
//        } catch (final Exception e) {
//            throw new UserException("5000", "Unable to fetch");
//        }
        return bites;

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
            @RequestBody final byte[] image) throws IOException {
        UserProfileController.LOGGER.info("inside profilePicture method ");
        final Service service = new Service();
        String res = null;
        final char[] charTemp = new char[image.length];
        for (int i = 0; i < image.length; i++) {
            charTemp[i] = (char) image[i];

        }
        res = new String(charTemp);
        boolean isUpdated = false;
        try {
            final File file = new File("c:/Images/Image");
            FileUtils.writeByteArrayToFile(file, image);
            if (file.exists()) {
                final int value = 1024;
                final double bytes = file.length();
                final double kilobytes = bytes / value;
                final double megabytes = kilobytes / value;
                if (megabytes > 1) {
                    throw new ASException(imageSizeCode, imageSizeMessage);
                } else if (megabytes < 1) {
                    isUpdated = authorProfileService.uploadProfileImage(userId,
                            image);
                }
            }
        } catch (final Exception e) {
            throw new UserException("50001", e.getMessage());
        }
        if (isUpdated) {
            service.setStatus("SUCCESS");
            service.setPayload(isUpdated);
        } else {
            service.setStatus("Failure");
            service.setPayload(isUpdated);
        }

        service.setPayload(res);
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
            throw new UserException("5005", "Unable to fetch");
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
}
