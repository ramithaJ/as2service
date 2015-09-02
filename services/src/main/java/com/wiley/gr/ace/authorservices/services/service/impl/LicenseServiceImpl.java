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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.exception.LicenseException;
import com.wiley.gr.ace.authorservices.externalservices.service.LicenseInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.Grants;
import com.wiley.gr.ace.authorservices.model.LicenceOO;
import com.wiley.gr.ace.authorservices.model.LicenseObject;
import com.wiley.gr.ace.authorservices.model.LicenseStatus;
import com.wiley.gr.ace.authorservices.model.LicenseUpload;
import com.wiley.gr.ace.authorservices.model.Recipients;
import com.wiley.gr.ace.authorservices.model.TrackLicense;
import com.wiley.gr.ace.authorservices.model.TrackLicenseDetails;
import com.wiley.gr.ace.authorservices.model.external.Funder;
import com.wiley.gr.ace.authorservices.model.external.Funders;
import com.wiley.gr.ace.authorservices.model.external.GetArticleDetails;
import com.wiley.gr.ace.authorservices.model.external.Id;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceRequest;
import com.wiley.gr.ace.authorservices.model.external.LicenseTypesPresented;
import com.wiley.gr.ace.authorservices.model.external.ProgramData;
import com.wiley.gr.ace.authorservices.model.external.SignLicenseRequest;
import com.wiley.gr.ace.authorservices.persistence.entity.LicenseUploadDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.Products;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedLicenses;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.LicenseDAO;
import com.wiley.gr.ace.authorservices.services.service.LicenseService;

/**
 * The Class LicenseServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class LicenseServiceImpl implements LicenseService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(LicenseServiceImpl.class);

    /** The license interface service. */
    @Autowired(required = true)
    private LicenseInterfaceService licenseInterfaceService;

    /** The task service. */
    @Autowired(required = true)
    private TaskService taskService;

    /** The license dao. */
    @Autowired(required = true)
    private LicenseDAO licenseDAO;

    /** The sign license status. */
    @Value("${SIGN_LICENSE}")
    private String signLicenseStatus;

    /** The license electronic status. */
    @Value("${LICENSE_SIGNED_ELECTRONICALLY}")
    private String licenseElectronicStatus;

    /** The license download status. */
    @Value("${LICENSE_DOWNLOADED}")
    private String licenseDownloadStatus;

    /** The license upload status. */
    @Value("${LICENSE_UPLOADED}")
    private String licenseUploadStatus;

    /** The sign license action. */
    @Value("${SIGN_LICENSE_ACTION}")
    private String signLicenseAction;

    /** The license view action. */
    @Value("${LICENSE_VIEW_ACTION}")
    private String licenseViewAction;

    /** The license upload action. */
    @Value("${LICENSE_UPLOAD_ACTION}")
    private String licenseUploadAction;

    /** The license download again action. */
    @Value("${LICENSE_DOWNLOAD_AGAIN_ACTION}")
    private String licenseDownloadAgainAction;

    /**
     * Gets the license choice.
     *
     * @param dhId
     *            the dh id
     * @param licenseObject
     *            the license object
     * @return the license choice
     */
    @Override
    public ArrayList<String> getLicenseChoice(final String dhId,
            final LicenseObject licenseObject) {

        LicenseChoiceRequest licenseChoiceRequest = new LicenseChoiceRequest();
        Funders funders = new Funders();
        ArrayList<Funder> funderList = new ArrayList<Funder>();

        licenseChoiceRequest.setDhId(dhId);

        for (FunderDetails funderDetails : licenseObject.getFunderDetailsList()) {
            Funder funder = new Funder();
            if (!StringUtils.isEmpty(funderDetails.getAssociateFunderId())) {
                funder.setFundRefId(funderDetails.getAssociateFunderId());
                funder.setName(funderDetails.getAssociateFunderName());
            } else {
                funder.setFundRefId(funderDetails.getResearchFunderId());
                funder.setName(funderDetails.getResearchFunderName());
            }

            funderList.add(funder);
        }

        funders.setFunder(funderList);
        licenseChoiceRequest.setFunders(funders);
        licenseChoiceRequest.setOnlineOpen(licenseObject.getOnlineOpen());
        return licenseInterfaceService.getLicenseChoice(licenseChoiceRequest)
                .getLicenseTypes().getLicenseType();
    }

    /**
     * Gets the license copy.
     *
     * @param dhId
     *            the dh id
     * @return the license copy
     */
    @Override
    public File getLicenseCopy(final String dhId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Save license later.
     *
     * @param licenseObject
     *            the license object
     * @param userId
     *            the user id
     * @param articleId
     *            the article id
     * @return the integer
     */
    @Override
    public Integer saveLicenseLater(final LicenseObject licenseObject,
            final String userId, final String articleId) {
        SavedLicenses savedLicenses = new SavedLicenses();
        Integer licenseId = null;
        try {
            String licenseObjectAsString = new ObjectMapper().writer()
                    .withDefaultPrettyPrinter()
                    .writeValueAsString(licenseObject);

            if (!StringUtils.isEmpty(licenseObjectAsString)) {
                savedLicenses.setLicenseObject(new SerialClob(
                        licenseObjectAsString.toCharArray()));
            }

            Users users = new Users();
            Products products = new Products();
            users.setUserId(Integer.parseInt(userId));
            products.setDhId(Integer.parseInt(articleId));

            savedLicenses.setProducts(products);
            savedLicenses.setUsersByUserId(users);
            savedLicenses.setCreatedDate(new Date());

            licenseId = licenseDAO.saveLicense(savedLicenses);

        } catch (JsonProcessingException | SQLException e) {
            throw new LicenseException("ERROR_SAVING_LICENSE",
                    "error saving the license");
        }
        return licenseId;

    }

    /**
     * Sign license.
     *
     * @param licenseObject
     *            the license object
     * @param dhId
     *            the dh id
     * @return the string
     */
    @Override
    public String signLicense(final LicenseObject licenseObject,
            final String dhId) {
        SignLicenseRequest signLicenseRequest = new SignLicenseRequest();
        LicenseTypesPresented licenseTypesPresented = new LicenseTypesPresented();
        signLicenseRequest.setDhId(dhId);
        signLicenseRequest.setAuthorSignature(licenseObject
                .getAuthorSignature());
        signLicenseRequest.setCopyrightOwnership(licenseObject
                .getCopyrightOwnership().getOwnershipType());
        signLicenseRequest.setLicenseTypeSigned(licenseObject.getLicenseType());
        licenseTypesPresented.setLicenseType(licenseObject
                .getLicenseTypePresented());
        signLicenseRequest.setLicenseTypesPresented(licenseTypesPresented);
        signLicenseRequest.setOnlineOpen(licenseObject.getOnlineOpen());
        signLicenseRequest.setSignedElectronically(licenseObject
                .getSignedElectronically());
        signLicenseRequest.setUsGovtWorkOwnership(licenseObject
                .getCopyrightOwnership().getUsGovtWorkOwnership());

        return licenseInterfaceService.signLicense(signLicenseRequest)
                .getResponseDescription();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.services.service.LicenseService#
     * getLicenseText
     * (com.wiley.gr.ace.authorservices.model.external.LicenseChoiceRequest)
     */
    @Override
    public String getLicenseText(final LicenseChoiceRequest licenseChoiceRequest) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(
                    "/Test.html"));
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                contentBuilder.append(string);
            }
            bufferedReader.close();
        } catch (IOException e) {
        }
        String content = contentBuilder.toString();

        return content;
    }

    /**
     * Track license status.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @return the track license
     * @throws Exception
     *             the exception
     */
    @Override
    public TrackLicense trackLicenseStatus(final String dhId,
            final String userId) throws Exception {
        LOGGER.info(" inside trackLicenseStatus method of LicenseServiceImpl");
        TrackLicenseDetails trackLicenseDetails = new TrackLicenseDetails();
        LicenseStatus licenseStatus = taskService
                .getLicenseStatus(dhId, userId);
        if (!StringUtils.isEmpty(licenseStatus)) {
            LOGGER.info(" licenseStatus is found from the BPM TaskList");
            trackLicenseDetails.setLicenseStatus(licenseStatus);
        }
        GetArticleDetails getArticleDetails = licenseInterfaceService
                .getWalsArticleDetails(dhId);
        if (!StringUtils.isEmpty(getArticleDetails)) {
            LOGGER.info("Electronic And Download license Status is found from the WALS");
            trackLicenseDetails.setLastSignedLicense(getArticleDetails
                    .getLastSignedLicense());
            trackLicenseDetails.setLastDownloadedLicense(getArticleDetails
                    .getLastDownloadedLicense());
        }
        return trackLicenseDetails(dhId, trackLicenseDetails);
    }

    /**
     * Track license details.
     *
     * @param dhId
     *            the dh id
     * @param trackLicenseDetails
     *            the track license details
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense trackLicenseDetails(final String dhId,
            final TrackLicenseDetails trackLicenseDetails) throws Exception {
        LOGGER.info(" inside trackLicenseDetails method of LicenseServiceImpl");
        LicenseUploadDetails licenseUploadDetails = licenseDAO
                .getlLicenseUploadDetails(dhId);
        LicenseUpload licenseUpload = null;
        if (!StringUtils.isEmpty(licenseUploadDetails)) {
            LOGGER.info("Upload license Status is found from the AS2.0");
            licenseUpload = new LicenseUpload();
            if (!StringUtils.isEmpty(licenseUploadDetails.getCreatedDate())) {
                licenseUpload.setLicenseCreatedDate((licenseUploadDetails
                        .getCreatedDate().toString()));
            }
            if (!StringUtils.isEmpty(licenseUploadDetails.getUpdatedDate())) {
                licenseUpload.setLicenseUpdatedDate(licenseUploadDetails
                        .getUpdatedDate().toString());
            }
            trackLicenseDetails.setLicenseUpload(licenseUpload);
        }
        return parseAllLicenseDates(trackLicenseDetails);
    }

    /**
     * Parses the all license dates.
     *
     * @param trackLicenseDetails
     *            the track license details
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense parseAllLicenseDates(
            final TrackLicenseDetails trackLicenseDetails) throws Exception {
        LOGGER.info(" inside parseAllLicenseDates method of LicenseServiceImpl");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        List<Date> licenseDates = new ArrayList<Date>();
        licenseDates.clear();
        licenseDates.add(formatter.parse(trackLicenseDetails.getLicenseStatus()
                .getLicenseDate()));
        licenseDates.add(formatter.parse(trackLicenseDetails
                .getLastSignedLicense().getLicenseSignDate()));
        licenseDates.add(formatter.parse(trackLicenseDetails
                .getLastDownloadedLicense().getLicSignDate()));
        return parseMostRecentDate(trackLicenseDetails, licenseDates, formatter);
    }

    /**
     * Parses the most recent date.
     *
     * @param trackLicenseDetails
     *            the track license details
     * @param licenseDates
     *            the license dates
     * @param formatter
     *            the formatter
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense parseMostRecentDate(
            final TrackLicenseDetails trackLicenseDetails,
            final List<Date> licenseDates, final SimpleDateFormat formatter)
                    throws Exception {
        LicenseUpload licenseUpload = trackLicenseDetails.getLicenseUpload();
        if (!StringUtils.isEmpty(licenseUpload)) {
            licenseDates.add(formatter.parse(licenseUpload
                    .getLicenseCreatedDate()));
            licenseDates.add(formatter.parse(licenseUpload
                    .getLicenseUpdatedDate()));
        }
        Date recentDate = Collections.max(licenseDates);
        SimpleDateFormat formatterRecent = new SimpleDateFormat("yyyy-mm-dd");
        String licenseMostRecentDate = formatterRecent.format(recentDate);
        return trackRecentLicenseStatus(trackLicenseDetails,
                licenseMostRecentDate);
    }

    /**
     * Track recent license status.
     *
     * @param trackLicenseDetails
     *            the track license details
     * @param licenseMostRecentDate
     *            the license most recent date
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense trackRecentLicenseStatus(
            final TrackLicenseDetails trackLicenseDetails,
            final String licenseMostRecentDate) throws Exception {
        LOGGER.info(" inside trackRecentLicenseStatus method of LicenseServiceImpl");
        TrackLicense trackLicense = null;
        if (licenseMostRecentDate.equals(trackLicenseDetails.getLicenseStatus()
                .getLicenseDate())) {
            trackLicense = trackSignLicense(trackLicenseDetails);
        } else if (licenseMostRecentDate.equals(trackLicenseDetails
                .getLastSignedLicense().getLicenseSignDate())) {
            trackLicense = trackElectronicLicense(trackLicenseDetails);
        } else if (licenseMostRecentDate.equals(trackLicenseDetails
                .getLastDownloadedLicense().getLicSignDate())) {
            trackLicense = trackDownloadLicense(trackLicenseDetails);
        } else {
            trackLicense = trackUploadLicense(trackLicenseDetails,
                    licenseMostRecentDate);
        }
        return trackLicense;
    }

    /**
     * Track sign license.
     *
     * @param trackLicenseDetails
     *            the track license details
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense trackSignLicense(
            final TrackLicenseDetails trackLicenseDetails) throws Exception {
        LOGGER.info(" inside trackSignLicense method of LicenseServiceImpl");
        TrackLicense trackLicense = new TrackLicense();
        LicenseStatus licenseStatus = trackLicenseDetails.getLicenseStatus();
        if (!StringUtils.isEmpty(licenseStatus)) {
            trackLicense.setLicenseDate(licenseStatus.getLicenseDate());
            trackLicense.setTaskId(licenseStatus.getTaskId());
            trackLicense.setLicenseStatus(signLicenseStatus);
            List<String> actions = new ArrayList<String>();
            actions.add(signLicenseAction);
            trackLicense.setAction(actions);
        }
        return trackLicense;
    }

    /**
     * Track electronic license.
     *
     * @param trackLicenseDetails
     *            the track license details
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense trackElectronicLicense(
            final TrackLicenseDetails trackLicenseDetails) throws Exception {
        LOGGER.info(" inside trackElectronicLicense method of LicenseServiceImpl");
        TrackLicense trackLicense = new TrackLicense();
        trackLicense.setLicenseDate(trackLicenseDetails.getLastSignedLicense()
                .getLicenseSignDate());
        trackLicense.setLicenseStatus(licenseElectronicStatus);
        List<String> actions = new ArrayList<String>();
        actions.add(licenseViewAction);
        trackLicense.setAction(actions);
        return trackLicense;
    }

    /**
     * Track download license.
     *
     * @param trackLicenseDetails
     *            the track license details
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense trackDownloadLicense(
            final TrackLicenseDetails trackLicenseDetails) throws Exception {
        LOGGER.info(" inside trackDownloadLicense method of LicenseServiceImpl");
        TrackLicense trackLicense = new TrackLicense();
        trackLicense.setLicenseDate(trackLicenseDetails
                .getLastDownloadedLicense().getLicSignDate());
        trackLicense.setLicenseStatus(licenseDownloadStatus);
        List<String> actions = new ArrayList<String>();
        actions.add(licenseUploadAction);
        actions.add(licenseDownloadAgainAction);
        trackLicense.setAction(actions);
        return trackLicense;
    }

    /**
     * Track upload license.
     *
     * @param trackLicenseDetails
     *            the track license details
     * @param licenseMostRecentDate
     *            the license most recent date
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense trackUploadLicense(
            final TrackLicenseDetails trackLicenseDetails,
            final String licenseMostRecentDate) throws Exception {
        LOGGER.info(" inside trackUploadLicense method of LicenseServiceImpl");
        TrackLicense trackLicense = new TrackLicense();
        LicenseUpload licenseUpload = trackLicenseDetails.getLicenseUpload();
        if (licenseMostRecentDate.equals(licenseUpload.getLicenseCreatedDate())) {
            trackLicense.setLicenseDate(licenseUpload.getLicenseCreatedDate());
        } else {
            trackLicense.setLicenseDate(licenseUpload.getLicenseUpdatedDate());
        }
        trackLicense.setLicenseStatus(licenseUploadStatus);
        List<String> actions = new ArrayList<String>();
        actions.add(licenseViewAction);
        trackLicense.setAction(actions);
        return trackLicense;
    }

    /**
     * This will call external service to get data.
     *
     * @param articleId
     *            the article id
     * @return {@link LicenseObject}
     */
    @Override
    public LicenseObject initiateLicence(final String articleId) {

        LicenseObject licenseObject = new LicenseObject();

        List<ProgramData> programList = licenseInterfaceService
                .initiateLicence(articleId).getProgram();
        for (ProgramData programData : programList) {
            FunderDetails funderDetails = new FunderDetails();
            ArrayList<FunderDetails> funderDetailsList = new ArrayList<FunderDetails>();
            Grants grant = new Grants();
            List<Grants> grantList = new ArrayList<Grants>();
            Recipients grantRecipients = new Recipients();
            List<Recipients> listOfGrantRecipients = new ArrayList<Recipients>();
            grantRecipients.setRecipientId(programData.getFunder().getId());

            List<Id> lisOfId = programData.getFunder().getSecondaryIds()
                    .getId();
            for (Id id : lisOfId) {
                if (id.getType().equalsIgnoreCase("DOI")) {
                    grantRecipients.setRecipentsName(programData.getFunder()
                            .getName());
                    break;
                }
            }
            listOfGrantRecipients.add(grantRecipients);
            grant.setRecipientsList(listOfGrantRecipients);
            grantList.add(grant);
            funderDetails.setGrants(grantList);
            funderDetailsList.add(funderDetails);
            licenseObject.setFunderDetailsList(funderDetailsList);

        }
        return licenseObject;

    }

    /**
     * This Method is for saving Online Open licence in As 2 db
     * 
     * @param licenceOO
     * @param userId
     * @param articleId
     * 
     * @return boolean.
     * */
    @Override
    public boolean saveLicenceOO(final LicenceOO licenceOO,
            final String userId, final String articleId) {
        // TODO Auto-generated method stub
        return false;
    }
}
