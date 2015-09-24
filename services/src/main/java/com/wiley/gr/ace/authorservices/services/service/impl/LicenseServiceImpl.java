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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.LicenseException;
import com.wiley.gr.ace.authorservices.externalservices.service.LicenseInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.Grants;
import com.wiley.gr.ace.authorservices.model.LicenseObject;
import com.wiley.gr.ace.authorservices.model.LicenseStatus;
import com.wiley.gr.ace.authorservices.model.Recipients;
import com.wiley.gr.ace.authorservices.model.TrackLicense;
import com.wiley.gr.ace.authorservices.model.external.Funder;
import com.wiley.gr.ace.authorservices.model.external.Funders;
import com.wiley.gr.ace.authorservices.model.external.GetArticleDetails;
import com.wiley.gr.ace.authorservices.model.external.Id;
import com.wiley.gr.ace.authorservices.model.external.LastDownloadedLicense;
import com.wiley.gr.ace.authorservices.model.external.LastSignedLicense;
import com.wiley.gr.ace.authorservices.model.external.LicenseChoiceRequest;
import com.wiley.gr.ace.authorservices.model.external.LicenseTypesPresented;
import com.wiley.gr.ace.authorservices.model.external.ProgramData;
import com.wiley.gr.ace.authorservices.model.external.SignLicenseRequest;
import com.wiley.gr.ace.authorservices.model.external.ViewLicenseAgreement;
import com.wiley.gr.ace.authorservices.model.external.WALSRequest;
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
        LicenseStatus licenseStatus = taskService
                .getLicenseStatus(dhId, userId);
        if (!StringUtils.isEmpty(licenseStatus)) {
            LOGGER.info(" licenseStatus is found from the BPM TaskList");
            return trackSignLicense(licenseStatus);
        } else {
            GetArticleDetails getArticleDetails = licenseInterfaceService
                    .getWalsArticleDetails(dhId);
            return getWalsLicenseDetails(getArticleDetails, dhId);
        }

    }

    /**
     * Gets the wals license details.
     *
     * @param getArticleDetails
     *            the get article details
     * @param dhId
     *            the dh id
     * @return the wals license details
     * @throws Exception
     *             the exception
     */
    private TrackLicense getWalsLicenseDetails(
            final GetArticleDetails getArticleDetails, final String dhId)
            throws Exception {
        LastSignedLicense electronicSign = getArticleDetails
                .getLastSignedLicense();
        if (!StringUtils.isEmpty(electronicSign)) {
            return trackElectronicLicense(electronicSign);
        } else {
            LastDownloadedLicense lastDownloadedLicense = getArticleDetails
                    .getLastDownloadedLicense();
            if (!StringUtils.isEmpty(lastDownloadedLicense)) {
                return trackDownloadLicense(lastDownloadedLicense);
            } else {
                LicenseUploadDetails licenseUploadDetails = licenseDAO
                        .getlLicenseUploadDetails(dhId);
                return trackUploadLicense(licenseUploadDetails);
            }
        }
    }

    /**
     * Track sign license.
     *
     * @param licenseStatus
     *            the license status
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense trackSignLicense(final LicenseStatus licenseStatus)
            throws Exception {
        LOGGER.info(" inside trackSignLicense method of LicenseServiceImpl");
        TrackLicense trackLicense = new TrackLicense();
        trackLicense.setLicenseDate(licenseStatus.getLicenseDate());
        trackLicense.setTaskId(licenseStatus.getTaskId());
        trackLicense.setLicenseStatus(signLicenseStatus);
        List<String> actions = new ArrayList<String>();
        actions.add(signLicenseAction);
        trackLicense.setAction(actions);
        return trackLicense;
    }

    /**
     * Track electronic license.
     *
     * @param electronicSignLicense
     *            the electronic sign license
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense trackElectronicLicense(
            final LastSignedLicense electronicSignLicense) throws Exception {
        LOGGER.info(" inside trackElectronicLicense method of LicenseServiceImpl");
        TrackLicense trackLicense = new TrackLicense();
        trackLicense.setLicenseDate(electronicSignLicense.getLicenseSignDate());
        trackLicense.setLicenseStatus(licenseElectronicStatus);
        List<String> actions = new ArrayList<String>();
        actions.add(licenseViewAction);
        trackLicense.setAction(actions);
        return trackLicense;
    }

    /**
     * Track download license.
     *
     * @param lastDownloadedLicense
     *            the last downloaded license
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense trackDownloadLicense(
            final LastDownloadedLicense lastDownloadedLicense) throws Exception {
        LOGGER.info(" inside trackDownloadLicense method of LicenseServiceImpl");
        TrackLicense trackLicense = new TrackLicense();
        trackLicense.setLicenseDate(lastDownloadedLicense.getLicSignDate());
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
     * @param licenseUploadDetails
     *            the license upload details
     * @return the track license
     * @throws Exception
     *             the exception
     */
    private TrackLicense trackUploadLicense(
            final LicenseUploadDetails licenseUploadDetails) throws Exception {
        LOGGER.info(" inside trackUploadLicense method of LicenseServiceImpl");
        TrackLicense trackLicense = new TrackLicense();
        if (!StringUtils.isEmpty(licenseUploadDetails)) {
            trackLicense.setLicenseDate(licenseUploadDetails.getUpdatedDate()
                    .toString());
            trackLicense.setLicenseStatus(licenseUploadStatus);
            List<String> actions = new ArrayList<String>();
            actions.add(licenseViewAction);
            trackLicense.setAction(actions);
        }
        return trackLicense;
    }

    /**
     * This will call external service to get data.
     *
     * @param userId
     *            the user id
     * @param articleId
     *            the article id
     * @param articleType
     *            the article type
     * @return {@link LicenseObject}
     */
    @Override
    public LicenseObject initiateLicence(final String userId,
            final String articleId, final String articleType) {

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

    @Override
    public ResponseEntity<byte[]> viewLicenseAgreement(Integer dhId)
            throws Exception {
        ViewLicenseAgreement viewLicenseAgreement = null;

        ResponseEntity<byte[]> response = null;
        viewLicenseAgreement = new ViewLicenseAgreement();

        HttpHeaders headers = new HttpHeaders();
        byte[] contents = null;

        WALSRequest walsRequest = new WALSRequest();
        walsRequest
                .setDhId(String.valueOf(dhId));
        Date timestamp=new Date();
        walsRequest
                .setRequestCreatedTimestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(timestamp).toString());
        viewLicenseAgreement.setGetLicenseCopyRequest(walsRequest);
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setContentDispositionFormData(
                AuthorServicesConstants.LICENSE_PDF_NAME,
                AuthorServicesConstants.LICENSE_PDF_NAME);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        contents = licenseInterfaceService
                .viewLicenseAgreement(viewLicenseAgreement);
        response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);

        return response;
    }
}
