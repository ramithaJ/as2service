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
import com.wiley.gr.ace.authorservices.model.ProfilePicture;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.external.AlertElement;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

// TODO: Auto-generated Javadoc
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

    /** The user profile service. */
    @Autowired
    private UserProfileService userProfileService;

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
        final Service service = new Service();
        service.setPayload(authorProfileService.getAffiliationsList(userId));

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

        authorProfileService.updateAffiliation(userId, affiliationsUpdate,
                affiliationId);

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
        service.setPayload(authorProfileService.deleteAffiliations(userId,
                affiliationId));
        return service;
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
        final Service service = new Service();
        service.setPayload(authorProfileService.getResearchFundersList(userId));

        return service;
    }

    /**
     * Gets the societies list.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    /*
     * @RequestMapping(value = "/researchFunder/{userId}", method =
     * RequestMethod.POST) public final Service updateResearchFunder(
     * 
     * @PathVariable("userId") final int userId,
     * 
     * @RequestBody final ResearchFunder researchFunder) {
     * 
     * UserProfileController.LOGGER
     * .info("inside updateResearchFunder method "); Service service = new
     * Service();
     * service.setPayload(authorProfileService.updateResearchFunder(userId,
     * researchFunder)); return service; }
     */
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
        service.setPayload(authorProfileService.updateSocietyDetails(userId,
                society));
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
    @RequestMapping(value = "/societies/{userId}/{societyId}/{id}", method = RequestMethod.DELETE)
    public final Service deleteSocietyDetails(
            @PathVariable("userId") final String userId,
            @PathVariable("societyId") final String societyId,
            @PathVariable("id") final String id) {

        UserProfileController.LOGGER
                .info("inside deleteSocietyDetails method ");

        final Service service = new Service();

        service.setPayload(authorProfileService.deleteSociety(userId,
                societyId, id));
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
    /*
     * @RequestMapping(value = "/coAuthors/{userId}", method =
     * RequestMethod.POST) public final Service updateCoAuthors(@PathVariable
     * final int userId,
     * 
     * @RequestBody final CoAuthor coAuthor) {
     * 
     * UserProfileController.LOGGER.info("inside updateCoAuthors method ");
     * Service service = new Service(); coAuthor.setUserId(userId);
     * service.setPayload(authorProfileService .updatecoAuthor(userId,
     * coAuthor)); return new Service(); }
     */

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
     *            - The request value
     * @return service
     */

    @RequestMapping(value = "/alerts/{userId}", method = RequestMethod.GET)
    public final Service getListOfAlerts(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside getListOfAlerts method ");
        final Service service = new Service();
        try {
            service.setPayload(userProfileService.getAlerts(userId));
        } catch (final Exception e) {
            throw new UserException("5005", "Unable to fetch");
        }
        return service;
    }

    /**
     * Update alerts.
     *
     * @param userId
     *            - The request value
     * @param listOfalert
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/alerts/{userId}", method = RequestMethod.POST)
    public final Service updateAlerts(
            @PathVariable("userId") final String userId,
            @RequestBody final AlertsList listOfalert) {
        UserProfileController.LOGGER.info("inside updateAlerts method ");
        final Service service = new Service();
        service.setPayload(authorProfileService.updateAlerts(userId,
                listOfalert));
        return service;
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
    /*
     * @RequestMapping(value = "/lookUpProfile/{userId}", method =
     * RequestMethod.GET) public final Service
     * lookUpProfile(@PathVariable("userId") final int userId) {
     * 
     * UserProfileController.LOGGER.info("inside lookUpProfile method ");
     * Service service = new Service();
     * service.setPayload(authorProfileService.getuserProfileResponse(userId));
     * return service;
     * 
     * }
     */
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
     * Profile picture.
     *
     * @param profilePicture
     *            - The request value
     * @return - service
     * @throws IOException
     *             - exception
     */
    @RequestMapping(value = "/uploadImage/", method = RequestMethod.POST)
    public final Service profilePicture(
            @RequestBody final ProfilePicture profilePicture)
            throws IOException {
        final Service service = new Service();
        final String imageString = FileUtils.readFileToString(profilePicture
                .getImage());
        final File file = new File(imageString);
        if (file.exists()) {
            final int value = 1024;
            final double bytes = file.length();
            final double kilobytes = bytes / value;
            final double megabytes = kilobytes / value;
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
     * Look up profile.
     *
     * @param userId
     *            - The request value
     * @return service
     */
    @RequestMapping(value = "/lookUpProfileCustomer/{userId}", method = RequestMethod.GET)
    public final Service lookUpProfile(
            @PathVariable("userId") final String userId) {

        UserProfileController.LOGGER.info("inside lookUpProfile method ");
        final Service service = new Service();
        service.setPayload(authorProfileService
                .getLookupCustomerProfile(userId));
        return service;

    }

    /**
     * Gets the profile.
     *
     * @param userId
     *            the user id
     * @return the profile
     */
    @RequestMapping(value = "/getImage/{userId}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public final Service getProfile(@PathVariable("userId") final String userId) {

        final Service service = new Service();
        try {
            service.setPayload(userProfileService.getProfileImage(userId));
        } catch (final Exception e) {
            throw new UserException("5000", "Unable to fetch");
        }
        return service;

    }

    /**
     * Profile picture.
     *
     * @param image
     *            the image
     * @return the service
     */
    @RequestMapping(value = "/uploadImage/{userId}/", method = RequestMethod.POST)
    public final Service profilePicture(
            @PathVariable("userId") final String userId,
            @RequestBody final byte[] image) throws IOException {
        Service service = new Service();
        String res = null;
        char[] charTemp = new char[image.length];
        for (int i = 0; i < image.length; i++) {
            charTemp[i] = (char) image[i];

        }
        res = new String(charTemp);
        boolean isUpdated = false;
        try {
            File file = new File("c:/Images/Image");
            FileUtils.writeByteArrayToFile(file, image);
            if (file.exists()) {
                final int value = 1024;
                double bytes = file.length();
                double kilobytes = bytes / value;
                double megabytes = kilobytes / value;
                if (megabytes > 1) {
                    throw new ASException(imageSizeCode, imageSizeMessage);
                } else if (megabytes < 1) {
                    Byte[] byteWrapper = new Byte[image.length];
                    int i = 0;
                    for (byte b : image) {
                        byteWrapper[i++] = b;
                    }
                    isUpdated = userProfileService.uploadProfileImage(userId,
                            byteWrapper);
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
     * Update service.
     *
     * @param participantId
     *            the participant id
     * @param imageFile
     *            the image file
     * @return the service
     */
    @RequestMapping(value = "/{participantId}/profileImage/", method = RequestMethod.POST)
    public Service updateService(
            @PathVariable("ParticipantId") final String participantId,
            @RequestBody final Byte[] imageFile) {
        boolean isUpdated = false;
        final Service service = new Service();
        try {
            isUpdated = userProfileService.uploadProfileImage(participantId,
                    imageFile);
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
            service.setPayload(userProfileService.getAlerts(participantId));
        } catch (final Exception e) {
            throw new UserException("5005", "Unable to fetch");
        }
        return service;

    }

    /**
     * Update alerts.
     *
     * @param participantId
     *            the participant id
     * @param alert
     *            the alert
     * @return the service
     */
    @RequestMapping(value = "/{participantId}/alerts/", method = RequestMethod.POST)
    public Service updateAlerts(
            @PathVariable("ParticipantId") final String participantId,
            @RequestBody final AlertElement alert) {
        boolean isUpdated = false;
        final Service service = new Service();
        try {
            isUpdated = userProfileService.updateAlerts(participantId, alert);
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
     * get WOA accounts.
     * 
     * @param participantId
     *            the request value.
     * @return service
     */
    @RequestMapping(value = "/woaaccounts/{participantId}/", method = RequestMethod.GET)
    public Service getWOAAccounts(
            @PathVariable("ParticipantId") final String participantId) {
        Service service = new Service();
        service.setPayload(userProfileService.getWOAaccounts(participantId));
        return service;
    }
}
