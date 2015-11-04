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

package com.wiley.gr.ace.authorservices.services.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.AlertsList;
import com.wiley.gr.ace.authorservices.model.AlertsResponse;
import com.wiley.gr.ace.authorservices.model.AreaOfInterests;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.PreferredJournals;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.AlertRequest;
import com.wiley.gr.ace.authorservices.model.external.AlertType;
import com.wiley.gr.ace.authorservices.model.external.EntityValue;
import com.wiley.gr.ace.authorservices.model.external.JournalElement;
import com.wiley.gr.ace.authorservices.model.external.Name;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.ParticipantErrorResponse;
import com.wiley.gr.ace.authorservices.model.external.PasswordRequest;
import com.wiley.gr.ace.authorservices.model.external.PasswordUpdate;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.PreferenceAlert;
import com.wiley.gr.ace.authorservices.model.external.PreferenceValue;
import com.wiley.gr.ace.authorservices.model.external.Preferences;
import com.wiley.gr.ace.authorservices.model.external.ProfileEntity;
import com.wiley.gr.ace.authorservices.model.external.ProfileRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestionsUpdateRequest;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsEntry;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsMap;
import com.wiley.gr.ace.authorservices.persistence.entity.Alerts;
import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAffiliations;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunders;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSocietyDetails;
import com.wiley.gr.ace.authorservices.persistence.services.AlertsDao;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorProfileDao;
import com.wiley.gr.ace.authorservices.persistence.services.ResearchFunderDAO;
import com.wiley.gr.ace.authorservices.persistence.services.SocietyDao;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileService;
import com.wiley.gr.ace.authorservices.services.service.SendNotification;

/**
 * The Class AuthorProfileServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class AuthorProfileServiceImpl implements AuthorProfileService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AuthorProfileServiceImpl.class);

    /** The user management. */
    @Autowired
    private UserManagement userManagement;

    /** The author profile dao. */
    @Autowired
    private AuthorProfileDao authorProfileDao;
    @Autowired(required = true)
    private AutocompleteService autocomplete;

    /**
     * Injecting SendNotification bean.
     */
    @Autowired(required = true)
    private SendNotification sendNotification;

    /** The template id. */
    @Value("${templateId.sec.email.update}")
    private String secEmailUpdateTemplateId;

    /**
     * This field holds the value of passwordUpdatetemplateId.
     */
    @Value("${templateId.password.update}")
    private String passwordUpdatetemplateId;

    /**
     * This field holds the value of participantsInterfaceService.
     */
    @Autowired(required = true)
    private ParticipantsInterfaceService participantsInterfaceService;

    /**
     * This field holds the value of societyDao.
     */
    @Autowired(required = true)
    private SocietyDao societyDao;

    /**
     * This field holds the value of eSBInterfaceService.
     */
    @Autowired(required = true)
    private ESBInterfaceService eSBInterfaceService;

    /**
     * This field holds the value of researchFunderDAO.
     */
    @Autowired(required = true)
    private ResearchFunderDAO researchFunderDAO;

    /**
     * This field holds the value of participantService.
     */
    @Autowired(required = true)
    private ParticipantsInterfaceService participantService;

    /** The alerts dao. */
    @Autowired(required = true)
    private AlertsDao alertsDao;

    /**
     * This field holds the value of PROFILE
     */
    private static final String PROFILE = "PROFILE";

    /**
     * This field holds the value of EMAIL
     */
    private static final String EMAIL = "EMAIL";

    /**
     * Update society details.
     *
     * @param userId
     *            the user id
     * @param society
     *            the society
     * @return true, if successful
     */
    @Override
    public final boolean updateSocietyDetails(final String userId,
            final Society society) {
        AuthorProfileServiceImpl.LOGGER
                .info("ins ide updateSocietyDetails Method ");

        UUID participantUUID = UUID.fromString(userId);

        if (0 == society.getSeqId()) {
            UserSocietyDetails userSocietyDetails = new UserSocietyDetails();
            userSocietyDetails.setParticipantId(participantUUID);

            Societies societies = new Societies();
            societies.setSocietyCd(society.getSocietyId());
            userSocietyDetails.setSocieties(societies);

            userSocietyDetails.setSocietyName(society.getSocietyName());
            userSocietyDetails.setMembershipNo(society.getMembershipNumber());
            userSocietyDetails.setPromoCode(society.getPromoCode());
            userSocietyDetails.setStartDt(new Date(new Long(society
                    .getStartDate())));
            userSocietyDetails
                    .setEndDt(new Date(new Long(society.getEndDate())));
            userSocietyDetails.setCreatedBy(participantUUID);
            userSocietyDetails.setCreatedDate(new Date());

            return societyDao.addSociety(userSocietyDetails);
        } else {
            return societyDao.updateSociety(participantUUID, society);

        }

    }

    /**
     * Update affiliation.
     *
     * @param userId
     *            the user id
     * @param affiliation
     *            the affiliation
     * @return true, if successful
     * @throws Exception
     */
    @Override
    public boolean updateAffiliation(final String userId,
            final Affiliation affiliation, final String affiliationId)
            throws Exception {
        AuthorProfileServiceImpl.LOGGER
                .info("inside updateAffiliation Method ");
        if (affiliation.getInstitutionName() != null
                && !affiliation.getInstitutionName().isEmpty()) {
            String instutitionName = autocomplete.getNameByCode("institutions",
                    affiliation.getInstitutionId(), null);
            affiliation.setInstitutionName(instutitionName);
        }

        if (affiliation.getDepartmentName() != null
                && !affiliation.getDepartmentName().isEmpty()) {
            String departmentName = autocomplete.getNameByCode("departments",
                    affiliation.getDepartmentId(),
                    affiliation.getInstitutionId());
            affiliation.setDepartmentName(departmentName);
        }

        return authorProfileDao.updateAffiliation(userId, affiliation,
                affiliationId);
    }

    /**
     * Update alerts.
     *
     * @param userId
     *            the user id
     * @param listOfalert
     *            the user profile alerts
     * @return true, if successful
     */
    @Override
    public boolean updateAlerts(final String participantId,
            final AlertsList alertList) {
        AuthorProfileServiceImpl.LOGGER.info("inside updateAlerts Method ");
        boolean isUpdated = false;
        Integer code = null;
        final AlertRequest alertRequest = new AlertRequest();
        alertRequest.setPreferredEmailId(alertList.getEmailsList().get(0));
        final List<PreferenceAlert> preferList = new ArrayList<>();
        for (final Alert alert : alertList.getAlertsList()) {
            final PreferenceAlert preferenceAlert = new PreferenceAlert();
            preferenceAlert.setPreferenceKey(alert.getAlertId());
            final AlertType alertType = new AlertType();
            if (alert.isEmail()) {
                alertType.setEmail("1");
            } else {
                alertType.setEmail("0");
            }
            if (alert.isOnScreen()) {
                alertType.setOnScreen("1");
            } else {
                alertType.setOnScreen("0");
            }
            preferenceAlert.setAlertType(alertType);
            preferList.add(preferenceAlert);
        }
        alertRequest.setAlert(preferList);
        try {
            final ResponseEntity resposeEntity = participantsInterfaceService
                    .updateAlerts(participantId, alertRequest);
            System.err.println(resposeEntity);
            code = resposeEntity.getStatusCode().value();
            if (!code.equals(200)) {
                isUpdated = false;
                final ParticipantErrorResponse participantError = (ParticipantErrorResponse) resposeEntity
                        .getBody();
                throw new ASException(participantError.getMessage());
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }

        if (code.equals(200)) {
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public final boolean updateEmailDetails(final String userId,
            final User emailDetails) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateEmailDetails Method ");

        final ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityType(EMAIL);

        final EntityValue entityValue = new EntityValue();

        ProfileRequest profileRequest = settingProfileFields(userId);
        profileRequest.setPrimaryEmail(emailDetails.getPrimaryEmailAddr());
        profileRequest.setRecoveryEmail(emailDetails.getRecoveryEmailAddress());

        if (emailDetails.getPrimaryEmailAddr() != profileRequest
                .getPrimaryEmail()) {
            profileRequest.setOldEmail(profileRequest.getPrimaryEmail());
        }

        entityValue.setProfile(profileRequest);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem("AS");
        profileEntity.setEntityId(userId);

        boolean status = participantsInterfaceService
                .updateProfile(profileEntity);
        // check this code
        if (status) {
            sendNotification.updateSecEmailNotification(
                    emailDetails.getPrimaryEmailAddr(),
                    secEmailUpdateTemplateId);
        }

        return status;
    }

    private ProfileRequest settingProfileFields(final String userId) {

        ProfileRequest profileRequest = new ProfileRequest();
        Participant participantResponse = participantsInterfaceService
                .searchParticipantByParticipantId(userId);
        List<Name> alternateNamesList = participantResponse.getAlternateNames();
        if (!alternateNamesList.isEmpty()) {
            for (Name name : alternateNamesList) {
                profileRequest.setAlternativeName(name.getValue());
            }
        }

        profileRequest.setFirstName(participantResponse.getGivenName());
        profileRequest.setMiddleName(AuthorServicesConstants.EMPTY); // check
                                                                     // this
        profileRequest.setLastName(participantResponse.getFamilyName());
        profileRequest.setPrimaryEmail(participantResponse.getEmail());
        profileRequest.setRecoveryEmail(participantResponse.getRecoveryEmail());
        profileRequest.setOldEmail(AuthorServicesConstants.EMPTY);
        profileRequest.setIndustryCode(participantResponse.getIndustryId());
        profileRequest.setJobCategoryCode(participantResponse
                .getJobCategoryId());
        profileRequest.setTitleCode(participantResponse.getHonorificPrefix());
        profileRequest.setSuffixCode(participantResponse.getHonorificSuffix());
        List<String> areaofInterestList = participantResponse
                .getAreasOfInterest();
        List<String> interestList = new ArrayList<String>();
        for (String areaofInterest : areaofInterestList) {
            interestList.add(areaofInterest);
        }
        profileRequest.setInterestList(interestList);

        profileRequest.setOrcid(participantResponse.getOrcidId());
        return profileRequest;
    }

    /**
     * Update user profile info.
     *
     * @param userId
     *            the user id
     * @param user
     *            the user
     * @return true, if successful
     */
    @Override
    public final boolean updateUserProfileInfo(final String userId,
            final User user) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateUserProfileInfo Method ");

        Participant participantResponse = participantService
                .searchParticipantByParticipantId(userId);

        final ProfileEntity profileEntity = new ProfileEntity();

        profileEntity.setEntityType(PROFILE);
        final EntityValue entityValue = new EntityValue();

        final ProfileRequest profileRequest = new ProfileRequest();
        profileRequest.setTitleCode(user.getTitle());
        profileRequest.setSuffixCode(user.getSuffix());
        profileRequest.setMiddleName(user.getMiddleName());
        profileRequest.setLastName(user.getLastName());
        profileRequest.setFirstName(user.getFirstName());
        profileRequest.setAlternativeName(user.getAlternateName());
        profileRequest.setIndustryCode(user.getIndustry());
        profileRequest.setJobCategoryCode(user.getJobCategory());
        profileRequest.setSendEmail(user.getSendEmailFlag());
        profileRequest.setPrimaryEmail(participantResponse.getEmail());
        profileRequest.setRecoveryEmail(participantResponse.getRecoveryEmail());
        profileRequest.setOldEmail("");
        profileRequest.setRegistrantFlag("");
        profileRequest.setAuthorFlag("");

        List<String> areaofInterestList = participantResponse
                .getAreasOfInterest();
        List<String> interestList = new ArrayList<String>();
        for (String areaofInterest : areaofInterestList) {
            interestList.add(areaofInterest);
        }
        profileRequest.setInterestList(interestList);

        profileRequest.setOrcid(user.getOrcidId());

        entityValue.setProfile(profileRequest);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem("AS");
        profileEntity.setEntityId(userId);

        return participantsInterfaceService.updateProfile(profileEntity);
    }

    /**
     * Update password.
     *
     * @param passwordDetails
     *            the password details
     * @return true, if successful
     */
    @Override
    public final boolean updatePassword(final PasswordDetails passwordDetails) {

        AuthorProfileServiceImpl.LOGGER.info("inside updatePassword Method ");
        final PasswordUpdate passwordUpdate = new PasswordUpdate();
        final PasswordRequest passwordRequest = new PasswordRequest();
        passwordRequest.setExistingEmail(passwordDetails.getEmailId());
        passwordRequest.setExistingPassword(passwordDetails.getOldPassword());
        passwordRequest.setNewPassword(passwordDetails.getNewPassword());
        passwordRequest.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        passwordUpdate.setUpdateUserSecurityAttributes(passwordRequest);
        final boolean status = userManagement.updatePassword(passwordRequest);
        if (status) {
            sendNotification.notifyByEmail(passwordDetails.getEmailId(),
                    passwordUpdatetemplateId);
        }

        return status;
    }

    /**
     * Update security details.
     *
     * @param securityDetailsHolder
     *            the security details holder
     * @return true, if successful
     */
    @Override
    public final boolean updateSecurityDetails(
            final SecurityDetailsHolder securityDetailsHolder) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateSecurityDetails Method ");
        final SecurityQuestionsUpdateRequest securityQuestionsUpdateRequest = new SecurityQuestionsUpdateRequest();
        final UserSecurityQuestions userSecurityQuestions = new UserSecurityQuestions();
        final UserSecurityQuestionsMap userSecurityQuestionsMap = new UserSecurityQuestionsMap();
        final List<UserSecurityQuestionsEntry> userSecurityQuestionsEntryList = new ArrayList<UserSecurityQuestionsEntry>();
        UserSecurityQuestionsEntry userSecurityQuestionsEntry = null;
        final List<SecurityDetails> securityDetailsList = securityDetailsHolder
                .getSecurityDetails();
        for (final SecurityDetails securityDetails : securityDetailsList) {

            userSecurityQuestionsEntry = new UserSecurityQuestionsEntry();
            userSecurityQuestionsEntry.setKey(securityDetails
                    .getSecurityQuestion());
            userSecurityQuestionsEntry.setText(securityDetails
                    .getSecurityAnswer());
            userSecurityQuestionsEntryList.add(userSecurityQuestionsEntry);
        }
        userSecurityQuestionsMap.setEntry(userSecurityQuestionsEntryList);
        userSecurityQuestions
                .setUserSecurityQuestionsMap(userSecurityQuestionsMap);
        securityQuestionsUpdateRequest.setEmail(securityDetailsHolder
                .getEmailId());
        securityQuestionsUpdateRequest.setPassword(securityDetailsHolder
                .getOldPassword());
        securityQuestionsUpdateRequest
                .setsSystem(AuthorServicesConstants.SOURCESYSTEM);
        securityQuestionsUpdateRequest
                .setUserSecurityQuestions(userSecurityQuestions);

        return userManagement
                .updateSecurityDetails(securityQuestionsUpdateRequest);
    }

    /**
     * Upload profile image.
     *
     * @param participantId
     *            the participant id
     * @param imageFile
     *            the image file
     * @return true, if successful
     */
    @Override
    public boolean uploadProfileImage(final String participantId,
            final byte[] imageFile) {
        AuthorProfileServiceImpl.LOGGER
                .info("ins ide uploadProfileImage Method ");
        boolean isUpdated = false;
        final ResponseEntity resposeEntity = participantsInterfaceService
                .uploadProfileImage(participantId, imageFile);
        final Integer code = resposeEntity.getStatusCode().value();
        if (code.equals(200)) {
            isUpdated = true;
        } else {
            isUpdated = false;
            final ParticipantErrorResponse participantError = (ParticipantErrorResponse) resposeEntity
                    .getBody();
            LOGGER.info("participant error " + participantError);
            throw new ASException();
        }
        return isUpdated;
    }

    /**
     * Gets the affiliation list.
     *
     * @param userId
     *            the user id
     * @return the affiliation list
     */
    @Override
    public List<Affiliation> getAffiliationList(final String userId) {
        AuthorProfileServiceImpl.LOGGER
                .info("inside getAffiliationList Method ");
        List<Affiliation> affiliations = new ArrayList<>();
        List<UserAffiliations> userAffiliations = authorProfileDao
                .getAffiliationList(userId);
        for (UserAffiliations userAffiliation : userAffiliations) {
            Affiliation affiliation = new Affiliation();
            Country country = new Country();
            country.setCountryCode(userAffiliation.getCountryCd());
            country.setCountryName(autocomplete.getNameByCode("countries",
                    userAffiliation.getCountryCd(), null));
            affiliation.setCountry(country);
            Long affiliationId = userAffiliation.getAffiliationId();
            if (!StringUtils.isEmpty(affiliationId)) {
                affiliation.setAffiliationId(affiliationId.toString());
            }
            affiliation.setInstitutionId(userAffiliation.getInstitutionCd());
            if (affiliation.getInstitutionName() == null
                    || affiliation.getInstitutionName().isEmpty()) {
                affiliation.setInstitutionName(autocomplete.getNameByCode(
                        "institutions", userAffiliation.getInstitutionCd(),
                        null));
            }

            if (affiliation.getDepartmentName() == null
                    || affiliation.getDepartmentName().isEmpty()) {
                affiliation.setDepartmentName(autocomplete.getNameByCode(
                        "departments", userAffiliation.getDepartmentCd(),
                        userAffiliation.getInstitutionCd()));
            }

            affiliation.setStateCode(userAffiliation.getStateOrProvinceName());
            affiliation.setCity(userAffiliation.getTownOrCityName());
            Date startDate = userAffiliation.getStartDt();
            Date endDate = userAffiliation.getEndDt();
            if (!StringUtils.isEmpty(startDate)) {
                affiliation.setStartDate(startDate.getTime() + "");
            }
            if (!StringUtils.isEmpty(endDate)) {
                affiliation.setEndDate(endDate.getTime() + "");
            }
            affiliations.add(affiliation);
        }
        return affiliations;

    }

    /**
     * This method will call externnal service look up profile to get research
     * funder.
     *
     * @param userId
     *            the user id
     * @return the research funders list
     */
    @Override
    public final List<ResearchFunder> getResearchFundersList(final String userId) {

        try {
            UUID participantUUID = UUID.fromString(userId);

            List<UserFunders> userFundersList = researchFunderDAO
                    .getResearchFunders(participantUUID);
            List<ResearchFunder> researchFundersList = new ArrayList<ResearchFunder>();
            ResearchFunder researchFunder = null;
            for (UserFunders userFunders : userFundersList) {
                researchFunder = new ResearchFunder();
                researchFunder.setSeqId(userFunders.getUserFunderId());
                researchFunder.setResearchFunderId(userFunders.getFunderDoi());
                researchFunder.setResearchFunderName(userFunders
                        .getFunderName());
                Set<UserFunderGrants> userFunderGrantsSet = userFunders
                        .getUserFunderGrantses();
                Set<String> grantsSet = new HashSet<String>();
                for (UserFunderGrants userFunderGrants : userFunderGrantsSet) {
                    grantsSet.add(userFunderGrants.getGrantNum());
                }
                researchFunder.setGrantNumber(grantsSet);
                researchFundersList.add(researchFunder);
            }
            return researchFundersList;
        } catch (Exception e) {
            throw new UserException(AuthorServicesConstants.NODATAFOUNDCODE,
                    AuthorServicesConstants.NODATAFOUNDMSG);
        }

    }

    /**
     * This method will call externnal service look up profile to get Societies.
     *
     * @param userId
     *            the user id
     * @return the societylist
     */

    @Override
    public final List<Society> getSocietylist(final String userId) {

        UUID participantId = UUID.fromString(userId);
        final List<Society> societiesList = new ArrayList<Society>();
        try {
            final List<UserSocietyDetails> userSocietyDetailsList = societyDao
                    .getSocietyDetails(participantId);
            if (userSocietyDetailsList.isEmpty()) {
                return null;
            }

            Society society = null;
            for (final UserSocietyDetails userSocietyDetails : userSocietyDetailsList) {
                society = new Society();
                society.setSeqId(userSocietyDetails.getUserSocietyId());
                society.setSocietyId(userSocietyDetails.getSocieties()
                        .getSocietyCd());
                society.setSocietyName(userSocietyDetails.getSocietyName());
                society.setMembershipNumber(userSocietyDetails
                        .getMembershipNo());
                society.setPromoCode(userSocietyDetails.getPromoCode());
                society.setStartDate(userSocietyDetails.getStartDt().getTime()
                        + "");
                society.setEndDate(userSocietyDetails.getEndDt().getTime() + "");
                societiesList.add(society);
            }
            return societiesList;
        } catch (Exception e) {
            throw new UserException(AuthorServicesConstants.NODATAFOUNDCODE,
                    AuthorServicesConstants.NODATAFOUNDMSG);
        }

    }

    /**
     * This method will call external service look up profile to get interests.
     *
     * @param userId
     *            the user id
     * @return the area of interests
     */
    @Override
    public final List<Interests> getAreaOfInterests(final String userId) {
        final List<String> areaOfInterest = participantsInterfaceService
                .searchParticipantByParticipantId(userId).getAreasOfInterest();
        List<Interests> listAreaOfInterests = new ArrayList<Interests>();
        String aoeName = null;
        for (String string : areaOfInterest) {
            Interests interests = new Interests();
            interests.setAoeId(string);
            aoeName = autocomplete.getNameByCode("areasOfInterests", string,
                    null);
            interests.setAoeName(aoeName);
            listAreaOfInterests.add(interests);

        }

        return listAreaOfInterests;
    }

    /**
     * Gets the alerts.
     *
     * @param participantId
     *            the participant id
     * @return the alerts
     * @throws Exception
     *             the exception
     */
    @Override
    public AlertsResponse getAlerts(final String participantId)
            throws ASException {
        AuthorProfileServiceImpl.LOGGER.info("inside getAlerts Method ");
        PreferenceValue preferenceValue = null;
        AlertsResponse alertResponse = new AlertsResponse();
        try {
            preferenceValue = participantsInterfaceService
                    .getAlerts(participantId);
            List<String> email = new ArrayList<>();
            email.add(preferenceValue.getPreferredEmailId());
            alertResponse.setEmailsList(email);
            List<PreferenceAlert> alerts = preferenceValue.getAlert();
            List<Alert> alertList = new ArrayList<>();
            List<Alerts> alertDao = alertsDao.getAlerts();
            for (Alerts alert : alertDao) {
                Alert tempAlert = new Alert();
                tempAlert.setAlertId(alert.getAlertCd());
                tempAlert.setAlertName(alert.getAlertName());
                tempAlert.setOnScreen(false);
                tempAlert.setEmail(false);
                alertList.add(tempAlert);
            }
            for (PreferenceAlert preferenceAlert : alerts) {
                for (Alert alert : alertList) {
                    if (preferenceAlert.getPreferenceKey().equals(
                            alert.getAlertId())) {
                        AlertType alertType = preferenceAlert.getAlertType();
                        if ("1".equals(alertType.getEmail())) {
                            alert.setEmail(true);
                        }
                        if ("1".equals(alertType.getOnScreen())) {
                            alert.setOnScreen(true);
                        }
                        break;
                    }
                }
            }
            alertResponse.setAlertsList(alertList);
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
        }
        return alertResponse;
    }

    /**
     * This method will call external service look up profile to get preferred
     * journals.
     *
     * @param userId
     *            the user id
     * @return the preffered journals
     */
    @Override
    public final List<PreferredJournals> getPrefferedJournals(
            final String participantId) {
        List<String> preferredJournalData = participantsInterfaceService
                .getPreferredJournals(participantId).getPreferenceValue();

        List<PreferredJournals> listdata = new ArrayList<PreferredJournals>();
        if (!preferredJournalData.isEmpty()) {

            for (String string : preferredJournalData) {
                PreferredJournals preferredJournals = new PreferredJournals();
                preferredJournals.setJournalId(string);
                PdhLookupJournalResponse pdhLookupJournalResponse = eSBInterfaceService
                        .getPdhLookupJournalResponse(string);
                if (pdhLookupJournalResponse != null) {
                    preferredJournals.setJournalImage(pdhLookupJournalResponse
                            .getBannerImage());
                    preferredJournals.setJournalTitle(pdhLookupJournalResponse
                            .getTitle());
                }

                listdata.add(preferredJournals);

            }
        }

        return listdata;

    }

    /**
     * This Method will Remove Orcid Id.
     *
     * @param userId
     *            the user id
     * @return true, if successful
     */
    @Override
    public final boolean removeOrcidId(final String userId) {

        return this.orcidIdDetails(userId, null);

    }

    /**
     * This Method will Update Orcid Id.
     *
     * @param userId
     *            the user id
     * @param orcidId
     *            the orcid id
     * @return true, if successful
     */

    @Override
    public final boolean updateOrcidId(final String userId, final String orcidId) {

        return this.orcidIdDetails(userId, orcidId);

    }

    /**
     * This Method will Update Orcid Id.
     *
     * @param userId
     *            the user id
     * @param orcidId
     *            the orcid id
     * @return true, if successful
     */
    private boolean orcidIdDetails(final String userId, final String orcidId) {

        return false;

    }

    /**
     * This method is for getting profile picture .....
     *
     * @param participantId
     *            the participant id
     * @return image in terms of Byte array
     * @throws IOException
     */
    @Override
    public File getProfileImage(final String participantId) throws IOException {
        AuthorProfileServiceImpl.LOGGER.info("inside getProfileImage Method ");
        File file = new File("Image.jpg");
        file.createNewFile();
        FileUtils.writeByteArrayToFile(file,
                participantsInterfaceService.getProfileImage(participantId));
        return file;
    }

    /**
     * this will call external service to delete society
     * 
     * @param userId
     * @param societyId
     *
     * */
    @Override
    public boolean deleteSociety(final Long id) {

        return societyDao.deleteSociety(id);
    }

    /**
     * Delete affiliations.
     *
     * @param userId
     *            the user id
     * @return true, if successful
     */
    @Override
    public boolean deleteAffiliations(final String userId,
            final String affiliationId) {
        AuthorProfileServiceImpl.LOGGER
                .info("inside deleteAffiliations Method ");
        return authorProfileDao.deleteAffiliations(userId, affiliationId);

    }

    /**
     * this will call external service to delete interests
     * 
     * @param userId
     * @param interestId
     *
     * */

    @Override
    public boolean deleteInterests(final String userId, final String interestId) {

        ProfileRequest profileRequest = settingProfileFields(userId);
        final ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityType(PROFILE);
        final EntityValue entityValue = new EntityValue();

        List<String> interestData = profileRequest.getInterestList();

        if (interestData.contains(interestId)) {
            interestData.remove(interestId);

        }

        profileRequest.setInterestList(interestData);
        entityValue.setProfile(profileRequest);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem("AS");
        profileEntity.setEntityId(userId);

        return participantsInterfaceService.updateProfile(profileEntity);
    }

    /**
     * this will call external service to delete interests
     * 
     * @param userId
     * @param journalId
     *
     * */
    @Override
    public boolean deletePreferredJournals(final String userId,
            final String journalId) {
        final boolean status = false;
        final ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityType("FAVJOURNAL");
        final JournalElement journalElement = new JournalElement();
        journalElement.setRelationshipId(journalId);
        final EntityValue entityValue = new EntityValue();
        entityValue.setJournal(journalElement);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        profileEntity.setEntityId(userId);
        participantsInterfaceService.deletePreferredJournal(profileEntity);
        return status;
    }

    @Override
    public boolean addInterests(final String userId,
            final AreaOfInterests areaOfInterests) {
        ProfileRequest profileRequest = settingProfileFields(userId);
        final ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityType(PROFILE);
        final EntityValue entityValue = new EntityValue();

        List<String> interestData = profileRequest.getInterestList();
        List<Interests> interestList = areaOfInterests.getInterests();

        for (Interests interests : interestList) {
            if (!interestData.contains(interests)) {
                interestData.add(interests.getId());
            }

        }
        profileRequest.setInterestList(interestData);
        entityValue.setProfile(profileRequest);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem("AS");
        profileEntity.setEntityId(userId);

        return participantsInterfaceService.updateProfile(profileEntity);

    }

    @Override
    public boolean addPreferredJournal(final String userId,
            final JournalDetails journalDetails) {
        final ProfileEntity profileEntity = new ProfileEntity();
        List<String> preferredJournalData = participantsInterfaceService
                .getPreferredJournals(userId).getPreferenceValue();
        profileEntity.setEntityType("FAVJOURNAL");
        final EntityValue entityValue = new EntityValue();
        final JournalElement journalElement = new JournalElement();
        journalElement.setJournalID(journalDetails.getJournalId());
        List<String> journalList = new ArrayList<>();
        if (!preferredJournalData.isEmpty()
                && !preferredJournalData
                        .contains(journalDetails.getJournalId())) {
            journalList.add(journalDetails.getJournalId());
            for (String string : preferredJournalData) {
                journalList.add(string);

            }

            entityValue.setJournalList(journalList);

        }

        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        profileEntity.setEntityId(userId);

        return participantsInterfaceService.updateProfile(profileEntity);

    }

    @Override
    public List<Preferences> getWOAaccounts(final String participantId) {
        return new ArrayList<Preferences>();
    }

    @Override
    public List<CoAuthor> getsCoAuthorsList(final String userId) {
        return new ArrayList<CoAuthor>();
    }

    @Override
    public boolean updateResearchFunders(final String participantId,
            final ResearchFunder researchFunder) {

        UUID participantUUID = UUID.fromString(participantId);
        if (0 == researchFunder.getSeqId()) {
            UserFunders userFunders = new UserFunders();
            userFunders.setParticipantId(participantUUID);
            userFunders.setFunderDoi(researchFunder.getResearchFunderId());
            userFunders.setFunderName(researchFunder.getResearchFunderName());

            Set<UserFunderGrants> userFunderGrantsSet = new HashSet<UserFunderGrants>();
            UserFunderGrants userFunderGrants = null;
            Set<String> grantSet = researchFunder.getGrantNumber();
            for (String grnat : grantSet) {
                userFunderGrants = new UserFunderGrants();
                userFunderGrants.setGrantNum(grnat);
                userFunderGrantsSet.add(userFunderGrants);
            }
            userFunders.setUserFunderGrantses(userFunderGrantsSet);
            userFunders.setCreatedBy(participantUUID);
            userFunders.setCreatedDate(new Date());
            return researchFunderDAO.addResearchFunder(userFunders);
        } else {
            return researchFunderDAO.updateResearchFunder(participantId,
                    researchFunder);
        }
    }

    @Override
    public boolean deleteResearchFunder(final Long participantSeqId) {

        return researchFunderDAO.deleteResearchFunder(participantSeqId);
    }

}
