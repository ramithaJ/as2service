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

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ParticipantError;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.AlertsList;
import com.wiley.gr.ace.authorservices.model.AreaOfInterests;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.AlertRequest;
import com.wiley.gr.ace.authorservices.model.external.AlertType;
import com.wiley.gr.ace.authorservices.model.external.EntityValue;
import com.wiley.gr.ace.authorservices.model.external.InterestList;
import com.wiley.gr.ace.authorservices.model.external.JournalElement;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.external.PasswordRequest;
import com.wiley.gr.ace.authorservices.model.external.PasswordUpdate;
import com.wiley.gr.ace.authorservices.model.external.PreferenceAlert;
import com.wiley.gr.ace.authorservices.model.external.PreferenceValue;
import com.wiley.gr.ace.authorservices.model.external.Preferences;
import com.wiley.gr.ace.authorservices.model.external.ProfileEntity;
import com.wiley.gr.ace.authorservices.model.external.ProfileRequest;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestionsUpdateRequest;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsEntry;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsMap;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSocietyDetails;
import com.wiley.gr.ace.authorservices.persistence.services.AlertsDao;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorProfileDao;
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

    /** The user profiles. */
    @Autowired
    private UserProfiles userProfiles;

    /** The user management. */
    @Autowired
    private UserManagement userManagement;

    /** The author profile dao. */
    @Autowired
    private AuthorProfileDao authorProfileDao;

    /**
     * Injecting SendNotification bean.
     */
    @Autowired(required = true)
    private SendNotification sendNotification;

    /** The alerts Dao. */
    @Autowired(required = true)
    private AlertsDao alertsDao;

    @Autowired(required = true)
    private AutocompleteService autocomplete;

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
        return societyDao.updateSociety(userId, society);

    }

    /**
     * Update affiliation.
     *
     * @param userId
     *            the user id
     * @param affiliation
     *            the affiliation
     * @return true, if successful
     */
    @Override
    public final boolean updateAffiliation(final int userId,
            final Affiliation affiliation, final String affiliationId) {
        AuthorProfileServiceImpl.LOGGER
                .info("inside updateAffiliation Method ");
        /*
         * final CustomerDetails customerDetails = getCustomeProfile(String
         * .valueOf(userId)); final LookupCustomerProfileResponse
         * lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
         * final CustomerProfile customerProfile = new CustomerProfile();
         * customerProfile.setCustomerDetails(customerDetails); final
         * AffiliationsData affiliationsData = new AffiliationsData(); final
         * List<AffiliationData> affDataList = new ArrayList<AffiliationData>();
         * final AffiliationData affData = new AffiliationData();
         * affData.setStartDate(ASDateFormatUtil.convertDate(Long
         * .parseLong(affiliation.getStartDate())));
         * affData.setEndDate(ASDateFormatUtil.convertDate(Long
         * .parseLong(affiliation.getEndDate())));
         * affData.setCity(affiliation.getCity());
         * affData.setState(affiliation.getState());
         * affData.setCountryCd(affiliation.getCountryCode()); final String
         * institutionId = affiliation.getInstitutionId();
         * affData.setInstitutionCd(institutionId); final String name =
         * autocomplete.getNameByCode("institutions", institutionId, null);
         * affData.setInstitutionName(name);
         * affData.setDepartmentCd(affiliation.getDepartmentId());
         * affData.setDepartmentName(affiliation.getDepartmentName());
         * affDataList.add(affData);
         * affiliationsData.setAffiliation(affDataList);
         * customerProfile.setAffiliations(affiliationsData);
         * lookupCustomerProfileResponse.setCustomerProfile(customerProfile); if
         * ("0".equals(affiliationId)) { affData.setStatus("add"); } else {
         * affData.setId(affiliationId); affData.setStatus("edit"); }
         */

        return false;

    }

    /**
     * Update research funder.
     *
     * @param userId
     *            the user id
     * @param researchFunder
     *            the research funder
     * @return true, if successful
     */
    /*
     * @Override public final boolean updateResearchFunder(final int userId,
     * final ResearchFunder researchFunder) {
     * 
     * AuthorProfileServiceImpl.LOGGER
     * .info("inside updateResearchFunder Method ");
     * 
     * final List<ResearchFunder> list = new ArrayList<ResearchFunder>();
     * list.add(researchFunder); userProfile.setResearchFunders(list);
     * lookUpProfile.setCustomerProfile(userProfile); return null !=
     * userProfiles.updateProfile(userId, lookUpProfile); }
     */

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
            final AlertsList alertList) throws Exception {
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
                alertType.setOnscreen("1");
            } else {
                alertType.setOnscreen("0");
            }
            preferenceAlert.setAlertType(alertType);
            preferList.add(preferenceAlert);
        }
        alertRequest.setAlertList(preferList);
        final ResponseEntity resposeEntity = participantsInterfaceService
                .updateAlerts(participantId, alertRequest);
        code = resposeEntity.getStatusCode().value();
        if (!code.equals(200)) {
            isUpdated = false;
            final ParticipantError participantError = (ParticipantError) resposeEntity
                    .getBody();
            throw new Exception(participantError.getMessage());
        }

        if (code.equals(200)) {
            isUpdated = true;
        }
        return isUpdated;
    }

    /**
     * Update email details.
     *
     * @param userId
     *            the user id
     * @param emailDetails
     *            the email details
     * @return true, if successful
     */
    @Override
    public final boolean updateEmailDetails(final String userId,
            final User emailDetails) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateEmailDetails Method ");

        final ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityType("EMAIL");

        final EntityValue entityValue = new EntityValue();

        final ProfileRequest profileRequest = new ProfileRequest();
        final Participant participantResponse = participantsInterfaceService
                .searchParticipantByParticipantId(userId);
        profileRequest.setAlternativeName(""); // TODO
        profileRequest.setFirstName(participantResponse.getGivenName());
        profileRequest.setMiddleName(participantResponse.getAdditionalName()); // TODO
        profileRequest.setLastName(participantResponse.getFamilyName());
        profileRequest.setPrimaryEmail(participantResponse.getEmail());
        profileRequest.setRecoveryEmail(participantResponse.getRecoveryEmail());
        profileRequest.setOldEmail(""); // TODO
        profileRequest.setIndustryCode(participantResponse.getIndustryId());
        profileRequest.setJobCategoryCode(participantResponse
                .getJobCategoryId());
        profileRequest.setTitleCode(participantResponse.getHonorificPrefix());
        profileRequest.setSuffixCode(participantResponse.getHonorificSuffix());

        final List<InterestList> interestList = new ArrayList<InterestList>();
        final InterestList interest = new InterestList();
        interest.setInterestCode(""); // interest code TODO
        profileRequest.setInterestList(interestList);

        profileRequest.setOrcid(participantResponse.getOrcidId()); // orcid id

        entityValue.setProfile(profileRequest);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem("AS2.0");
        profileEntity.setEntityId(userId);

        participantsInterfaceService.updateProfile(profileEntity);

        final boolean status = false;
        if (status) {
            sendNotification.updateSecEmailNotification(
                    emailDetails.getPrimaryEmailAddr(),
                    secEmailUpdateTemplateId);
        }

        return status;
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
        final ProfileEntity profileEntity = new ProfileEntity();

        profileEntity.setEntityType("PROFILE");
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
        profileRequest.setPrimaryEmail(""); // primary email Address

        final List<InterestList> interestList = new ArrayList<InterestList>();
        final InterestList interest = new InterestList();
        interest.setInterestCode(""); // interest code
        profileRequest.setInterestList(interestList);

        profileRequest.setOrcid(""); // orcid id

        entityValue.setProfile(profileRequest);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem("AS2.0");
        profileEntity.setEntityId(userId);

        participantsInterfaceService.updateProfile(profileEntity);

        return false;
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

    @Override
    public boolean uploadProfileImage(final String participantId,
            final Byte[] imageFile) throws Exception {
        boolean isUpdated = false;
        final ResponseEntity resposeEntity = participantsInterfaceService
                .uploadProfileImage(participantId, imageFile);
        final Integer code = resposeEntity.getStatusCode().value();
        if (code.equals(200)) {
            isUpdated = true;
        } else {
            isUpdated = false;
            final ParticipantError participantError = (ParticipantError) resposeEntity
                    .getBody();
            throw new Exception(participantError.getMessage());
        }
        return isUpdated;
    }

    /**
     * This method will call externnal service look up profile to get
     * affiliation.
     *
     * @param userId
     *            the user id
     * @return the affiliations list
     */
    @Override
    public final List<Affiliation> getAffiliationsList(final String userId) {

        return null;

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

        return null;
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

        final List<UserSocietyDetails> userSocietyDetailsList = societyDao
                .getSocietyDetails(userId);
        if (userSocietyDetailsList.isEmpty()) {
            return null;
        }
        final List<Society> societiesList = new ArrayList<Society>();
        Society society = null;
        for (final UserSocietyDetails userSocietyDetails : userSocietyDetailsList) {
            society = new Society();
            society.setId(userSocietyDetails.getUserSocietyId());
            society.setSocietyId(userSocietyDetails.getSocieties()
                    .getSocietyCd());
            society.setSocietyName(userSocietyDetails.getSocietyName());
            society.setMembershipNumber(userSocietyDetails.getMembershipNo());
            society.setPromoCode(userSocietyDetails.getPromoCode());
            society.setStartDate(null); // need to convert date to string
                                        // userSocietyDetails.getStartDt()
            society.setEndDate(null); // need to convert date to string
                                      // userSocietyDetails.getEndDt()
            societiesList.add(society);
        }
        return societiesList;
    }

    /**
     * This method will call external service look up profile to get interests.
     *
     * @param userId
     *            the user id
     * @return the area of interests
     */
    @Override
    public final List<String> getAreaOfInterests(final String userId) {
        final List<String> areaOfInterest = participantsInterfaceService
                .searchParticipantByParticipantId(userId).getAreasOfInterest();

        return areaOfInterest;
    }

    @Override
    public PreferenceValue getAlerts(final String participantId)
            throws Exception {
        return participantsInterfaceService.getAlerts(participantId);
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
    public final String getPrefferedJournals(final String participantId) {

        final String value = participantsInterfaceService.getPreferredJournals(
                participantId).getPreferenceValue();

        return value;

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
     * @param userId
     *            the user id
     * @return image in terms of Byte array
     */
    @Override
    public Byte[] getProfileImage(final String participantId) throws Exception {
        return participantsInterfaceService.getProfileImage(participantId);
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
     * this will call external service to delete affiliations
     * 
     * @param userId
     * @param affiliationId
     *
     * */
    @Override
    public boolean deleteAffiliations(final String userId,
            final String affiliationId) {
        /*
         * final CustomerDetails customerDetails = getCustomeProfile(String
         * .valueOf(userId)); final LookupCustomerProfileResponse
         * lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
         * final CustomerProfile customerProfile = new CustomerProfile();
         * customerProfile.setCustomerDetails(customerDetails); final
         * AffiliationsData affsData = new AffiliationsData(); final
         * List<AffiliationData> affDataList = new ArrayList<AffiliationData>();
         * final AffiliationData affData = new AffiliationData();
         * affData.setId(affiliationId);
         * affData.setStartDate("1999-05-31T13:20:00-05:00");
         * affDataList.add(affData); affsData.setAffiliation(affDataList);
         * customerProfile.setAffiliations(affsData);
         * lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
         * affData.setStatus("delete");
         */
        return false;

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

        final Participant participant = participantsInterfaceService
                .searchParticipantByUserId(userId);

        final ProfileEntity profileEntity = new ProfileEntity();

        profileEntity.setEntityType("PROFILE");
        final EntityValue entityValue = new EntityValue();

        final ProfileRequest profileRequest = new ProfileRequest();
        profileRequest.setTitleCode(participant.getJobTitle());
        profileRequest.setSuffixCode(participant.getHonorificSuffix());
        profileRequest.setMiddleName("");
        profileRequest.setLastName(participant.getFamilyName());
        profileRequest.setFirstName(participant.getName());
        profileRequest.setAlternativeName("");
        profileRequest.setIndustryCode(participant.getIndustryId());
        profileRequest.setJobCategoryCode(participant.getJobCategoryId());
        profileRequest.setSendEmail(participant.getEmail());
        profileRequest.setPrimaryEmail(""); // primary email Address

        final List<InterestList> interestList = new ArrayList<InterestList>();
        final InterestList interest = new InterestList();
        interest.setInterestCode(""); // interest code
        profileRequest.setInterestList(interestList);

        profileRequest.setOrcid(""); // orcid id

        entityValue.setProfile(profileRequest);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        profileEntity.setEntityId(userId);

        participantsInterfaceService.updateProfile(profileEntity);
        return false;

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

        /*
         * final Participant participant = participantsInterfaceService
         * .searchParticipantByUserId(userId);
         * 
         * final ProfileEntity profileEntity = new ProfileEntity();
         * 
         * profileEntity.setEntityType("PROFILE"); final EntityValue entityValue
         * = new EntityValue();
         * 
         * final ProfileRequest profileRequest = new ProfileRequest();
         * profileRequest.setTitleCode(participant.getJobTitle());
         * profileRequest.setSuffixCode(participant.getHonorificSuffix());
         * profileRequest.setMiddleName("");
         * profileRequest.setLastName(participant.getFamilyName());
         * profileRequest.setFirstName(participant.getName());
         * profileRequest.setAlternativeName("");
         * profileRequest.setIndustryCode(participant.getIndustryId());
         * profileRequest.setJobCategoryCode(participant.getJobCategoryId());
         * profileRequest.setSendEmail(participant.getEmail());
         * profileRequest.setPrimaryEmail(""); // primary email Address
         * 
         * final List<InterestList> interestList = new
         * ArrayList<InterestList>(); final InterestList interest = new
         * InterestList(); interest.setInterestCode(""); // interest code
         * profileRequest.setInterestList(interestList);
         * 
         * profileRequest.setOrcid(""); // orcid id
         * 
         * entityValue.setProfile(profileRequest);
         * profileEntity.setEntityValue(entityValue);
         * profileEntity.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
         * profileEntity.setEntityId(userId);
         * 
         * participantsInterfaceService.updateProfile(profileEntity);
         */
        return false;

    }

    @Override
    public boolean addPreferredJournal(final String userId,
            final JournalDetails journalDetails) {
        final ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setEntityType("FAVJOURNAL");
        final EntityValue entityValue = new EntityValue();
        final JournalElement journalElement = new JournalElement();
        journalElement.setRelationshipId("");
        journalElement.setJournalID(journalDetails.getJournalId());
        // TODO pdh look up for getting journal title
        entityValue.setJournal(journalElement);
        profileEntity.setEntityValue(entityValue);
        profileEntity.setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        profileEntity.setEntityId(userId);

        participantsInterfaceService.addPreferredJournals(profileEntity);

        return false;

    }

    @Override
    public List<Preferences> getWOAaccounts(final String participantId) {

        /*
         * final Preferences preference = participantsInterfaceService
         * .getPreferredJournals(participantId);
         */
        return null;
    }

    @Override
    public List<CoAuthor> getsCoAuthorsList(final String userId) {
        // TODO Auto-generated method stub
        return null;
    }

}
