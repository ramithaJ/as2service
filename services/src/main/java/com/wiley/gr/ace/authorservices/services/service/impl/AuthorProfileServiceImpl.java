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
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Email;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.PreferredJournals;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.external.AffiliationData;
import com.wiley.gr.ace.authorservices.model.external.AffiliationsData;
import com.wiley.gr.ace.authorservices.model.external.AlertData;
import com.wiley.gr.ace.authorservices.model.external.AlertType;
import com.wiley.gr.ace.authorservices.model.external.AlertsData;
import com.wiley.gr.ace.authorservices.model.external.CoAuthorData;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.CustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.InterestData;
import com.wiley.gr.ace.authorservices.model.external.Journal;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.LookupCustomerProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.PasswordRequest;
import com.wiley.gr.ace.authorservices.model.external.PasswordUpdate;
import com.wiley.gr.ace.authorservices.model.external.ResearchFunderData;
import com.wiley.gr.ace.authorservices.model.external.SecurityQuestionsUpdateRequest;
import com.wiley.gr.ace.authorservices.model.external.SocietyData;
import com.wiley.gr.ace.authorservices.model.external.SocietyList;
import com.wiley.gr.ace.authorservices.model.external.UserEmailDetails;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityAttributes;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestions;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsEntry;
import com.wiley.gr.ace.authorservices.model.external.UserSecurityQuestionsMap;
import com.wiley.gr.ace.authorservices.persistence.entity.Alerts;
import com.wiley.gr.ace.authorservices.persistence.services.AlertsDao;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorProfileDao;
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

    @Value("${templateId.password.reset}")
    private String templateId;
    /** The user profile. */
    private final UserProfile userProfile = new UserProfile();

    /** The look up profile. */
    private final UserProfileResponse lookUpProfile = new UserProfileResponse();

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
    public final boolean updateSocietyDetails(final int userId,
            final Society society) {
        AuthorProfileServiceImpl.LOGGER
                .info("ins ide updateSocietyDetails Method ");
        CustomerDetails customerDetails = getCustomeProfile(String
                .valueOf(userId));
        LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        SocietyList societyList = new SocietyList();
        SocietyData societyData = new SocietyData();
        societyData.setId(society.getId());
        societyData.setSocietyName(society.getSocietyName());
        societyData.setStartDate(society.getStartDate());
        societyData.setEndDate(society.getEndDate());
        societyData.setPromoCode(society.getPromoCode());
        societyData.setMembershipNo(society.getMembershipNumber());
        societyData.setSocietyId(society.getSocietyId());
        if (society.getId().equals("0")) {
            societyData.setStatus("add");
        } else {
            societyData.setStatus("edit");
        }
        societyList.setSociety(new ArrayList<SocietyData>());
        societyList.getSociety().add(societyData);
        customerProfile.setCustomerDetails(customerDetails);
        customerProfile.setSocietyList(societyList);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);

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
            final Affiliation affiliation) {
        AuthorProfileServiceImpl.LOGGER
                .info("inside updateAffiliation Method ");
        CustomerDetails customerDetails = getCustomeProfile(String
                .valueOf(userId));
        LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        AffiliationsData affsData = new AffiliationsData();
        List<AffiliationData> affDataList = new ArrayList<AffiliationData>();
        AffiliationData affData = new AffiliationData();
        affData.setId(affiliation.getId());
        affData.setStartDate(affiliation.getStartDate());
        affData.setEndDate(affiliation.getEndDate());
        affData.setCity(affiliation.getCity());
        affData.setState(affiliation.getState());
        affData.setCountryCd(affiliation.getCountryCode());
        affData.setInstitutionCd(affiliation.getInstitutionId());
        affData.setInstitutionName(affiliation.getInstitutionName());
        affData.setDepartmentCd(affiliation.getDepartmentId());
        affData.setDepartmentName(affiliation.getDepartmentName());
        affDataList.add(affData);
        affsData.setAffiliation(affDataList);
        customerProfile.setAffiliations(affsData);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        if (affiliation.getId().equals("0")) {
            affData.setStatus("add");
        } else {
            affData.setStatus("edit");
        }
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);

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
    @Override
    public final boolean updateResearchFunder(final int userId,
            final ResearchFunder researchFunder) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateResearchFunder Method ");

        final List<ResearchFunder> list = new ArrayList<ResearchFunder>();
        list.add(researchFunder);
        userProfile.setResearchFunders(list);
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);
    }

    /**
     * Update alerts.
     *
     * @param userId
     *            the user id
     * @param userProfileAlerts
     *            the user profile alerts
     * @return true, if successful
     */
    @Override
    public final boolean updateAlerts(final String userId,
            final List<Alert> listOfalert) {
        AuthorProfileServiceImpl.LOGGER.info("inside updateAlerts Method ");
        CustomerDetails customerDetails = getCustomeProfile(userId);
        LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        AlertsData alertsData = new AlertsData();
        List<AlertData> alertList = new ArrayList<AlertData>();
        for (Alert alert : listOfalert) {
            AlertData alertData = new AlertData();
            AlertType alertType = new AlertType();
            alertData.setAlertID(alert.getAlertId());
            alertData.setStatus(alert.getStatus());
            if (alert.isEmail()) {
                alertType.setEmail("0");
            } else {
                alertType.setEmail("1");
            }
            if (alert.isOnScreen()) {
                alertType.setOnscreen("0");
            } else {
                alertType.setOnscreen("1");
            }
            alertData.setType(alertType);
            alertData.setStatus("edit");
            alertList.add(alertData);
        }
        alertsData.setAlert(alertList);
        customerProfile.setAlerts(alertsData);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);
    }

    /**
     * Update Coauthor.
     *
     * @param userId
     *            the user id
     * @param coAuthor
     *            the co author
     * @return true, if successful
     */
    @Override
    public final boolean updatecoAuthor(final int userId,
            final CoAuthor coAuthor) {

        AuthorProfileServiceImpl.LOGGER.info("inside updatecoAuthor Method ");

        final List<CoAuthor> list = new ArrayList<CoAuthor>();
        list.add(coAuthor);
        userProfile.setCoAuthors(list);
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);

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
        LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        CustomerProfile customerProfile = new CustomerProfile();

        CustomerDetails customerDetails = getCustomeProfile(userId);
        customerDetails.setPrimaryEmail(emailDetails.getPrimaryEmailAddr());
        customerDetails.setSecondaryEmail(emailDetails
                .getRecoveryEmailAddress());
        customerProfile.setCustomerDetails(customerDetails);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);
    }

    /**
     * Update user address.
     *
     * @param userId
     *            the user id
     * @param addresses
     *            the addresses
     * @return true, if successful
     */
    @Override
    public final boolean updateUserAddress(final int userId,
            final UserProfile addresses) {

        AuthorProfileServiceImpl.LOGGER
                .info("inside updateUserAddress Method ");
        userProfile.setAddressDetails(addresses.getAddressDetails());
        lookUpProfile.setCustomerProfile(userProfile);
        return null != userProfiles.updateProfile(userId, lookUpProfile);
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
        LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        CustomerProfile customerProfile = new CustomerProfile();

        CustomerDetails customerDetails = getCustomeProfile(userId);

        customerDetails.setTitle(user.getTitle());
        customerDetails.setfName(user.getFirstName());
        customerDetails.setlName(user.getLastName());
        customerDetails.setmName(user.getMiddleName());
        customerDetails.setUserSuffix(user.getSuffix());
        customerDetails.setAlternativeName(user.getAlternateName());
        customerDetails.setIndustryCode(user.getIndustryCode());
        customerDetails.setJobCategoryCode(user.getJobCategoryCode());
        customerDetails.setOrcId(user.getOrcidId());
        customerDetails.setOptInFlag(user.getTermsOfUseFlg());
        customerProfile.setCustomerDetails(customerDetails);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);
    }

    /**
     * Update user id.
     *
     * @param email
     *            the email
     * @return true, if successful
     */
    @Override
    public final boolean updateUserId(final Email email) {

        AuthorProfileServiceImpl.LOGGER.info("inside updateUserId Method ");

        final UserEmailDetails userEmailDetails = new UserEmailDetails();
        final UserSecurityAttributes userSecurityAttributes = new UserSecurityAttributes();
        userSecurityAttributes.setExistingEmail(email.getOldEmailId());
        userSecurityAttributes.setNewEmail(email.getNewEmailId());
        userSecurityAttributes
                .setSourceSystem(AuthorServicesConstants.SOURCESYSTEM);
        userEmailDetails
                .setUpdateUserSecurityAttributes(userSecurityAttributes);

        return userManagement.updateUserId(userEmailDetails);
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
                    templateId);
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
                .getPassword());
        securityQuestionsUpdateRequest
                .setsSystem(AuthorServicesConstants.SOURCESYSTEM);
        securityQuestionsUpdateRequest
                .setUserSecurityQuestions(userSecurityQuestions);

        return userManagement
                .updateSecurityDetails(securityQuestionsUpdateRequest);
    }

    /**
     * Gets the user profile response.
     *
     * @param userId
     *            the user id
     * @return the user profile response
     */
    @Override
    public final UserProfileResponse getuserProfileResponse(final int userId) {
        AuthorProfileServiceImpl.LOGGER.info("in UserProfileResponse Method");
        return userProfiles.getUserProfileResponse(userId);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.services.service.AuthorProfileService
     * #uploadImage(java.io.File, java.lang.String)
     */
    @Override
    public void uploadImage(final File image, final String userId) {

        final byte[] imageData = new byte[(int) image.length()];
        try {
            final FileInputStream fileInputStream = new FileInputStream(image);
            fileInputStream.read(imageData);
            fileInputStream.close();
            authorProfileDao.saveProfilePicture(imageData, userId);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Getting LookUp Profile by calling external service.
     *
     * @param userId
     *            the user id
     * @return the lookup customer profile
     */
    @Override
    public LookupCustomerProfile getLookupCustomerProfile(final String userId) {

        return userProfiles.getLookupCustomerProfile(userId);
    }

    /**
     * This method will call externnal service look up profile to get
     * affiliation
     * 
     * @param userId
     */
    @Override
    public List<Affiliation> getAffiliationsList(final String userId) {

        List<AffiliationData> listofAffiliations = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAffiliations().getAffiliation();

        List<Affiliation> listAffiliations = new ArrayList<Affiliation>();
        for (AffiliationData affiliationData : listofAffiliations) {
            Affiliation affiliation = new Affiliation();
            affiliation.setAffiliationId(affiliationData.getId());
            affiliation.setCity(affiliationData.getCity());
            affiliation.setCountryCode(affiliationData.getCountryCd());
            affiliation.setInstitutionId(affiliationData.getInstitutionCd());
            affiliation.setDepartmentId(affiliationData.getDepartmentCd());
            affiliation
                    .setInstitutionName(affiliationData.getInstitutionName());
            affiliation.setDepartmentName(affiliationData.getDepartmentName());
            affiliation.setStartDate(affiliationData.getStartDate());
            affiliation.setEndDate(affiliationData.getEndDate());
            affiliation.setStateCode(affiliationData.getState());
            affiliation.setId(affiliationData.getId());
            listAffiliations.add(affiliation);
        }
        return listAffiliations;
    }

    /**
     * This method will call externnal service look up profile to get research
     * funder
     * 
     * @param userId
     */
    @Override
    public List<ResearchFunder> getResearchFundersList(final String userId) {
        List<ResearchFunderData> listOfResearchFunder = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getResearchFunders().getResearchFunder();
        List<ResearchFunder> researchFunderList = new ArrayList<ResearchFunder>();
        for (ResearchFunderData researchFunderData1 : listOfResearchFunder) {
            ResearchFunder researchFunder = new ResearchFunder();
            researchFunder.setResearchFunderId(researchFunderData1
                    .getFunderID());
            researchFunder.setResearchFunderName(researchFunderData1
                    .getFunderName());
            researchFunderList.add(researchFunder);
        }
        return researchFunderList;
    }

    /**
     * This method will call externnal service look up profile to get Societies
     * 
     * 
     * @param userId
     */

    @Override
    public List<Society> getSocietylist(final String userId) {
        List<SocietyData> listSocietyData = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getSocietyList().getSociety();
        List<Society> societyList = new ArrayList<Society>();
        for (SocietyData societyData : listSocietyData) {
            Society society = new Society();
            society.setSocietyName(societyData.getSocietyName());
            society.setMembershipNumber(societyData.getMembershipNo());
            society.setStartDate(societyData.getStartDate());
            society.setEndDate(societyData.getEndDate());
            society.setPromoCode(societyData.getPromoCode());
            society.setId(societyData.getId());
            societyList.add(society);

        }
        return societyList;
    }

    /**
     * This method will call external service look up profile to get co authors
     * 
     * 
     * @param userId
     */
    @Override
    public List<CoAuthor> getsCoAuthorsList(final String userId) {

        List<CoAuthorData> listOfCoauthors = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getCoAuthors().getCoAuthor();
        List<CoAuthor> coAuthorList = new ArrayList<CoAuthor>();
        for (CoAuthorData coAuthorData : listOfCoauthors) {
            CoAuthor coAuthor = new CoAuthor();
            coAuthor.setCoAuthorId(coAuthorData.getId());
            coAuthor.setEmailId(coAuthorData.getEmailId());
            coAuthor.setFirstName(coAuthorData.getFirstName());
            coAuthor.setLastName(coAuthorData.getLastName());
            coAuthor.setPhone(coAuthorData.getPhoneNo());
            coAuthor.setInstitutionName(coAuthorData.getInstName());
            coAuthor.setDepartmentName(coAuthorData.getDeptName());
            coAuthorList.add(coAuthor);

        }
        return coAuthorList;
    }

    /**
     * This method will call external service look up profile to get interests
     * 
     * 
     * @param userId
     */
    @Override
    public List<Interests> getAreaOfInterests(final String userId) {
        List<InterestData> listOfArea = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAreaOfInterest().getInterest();
        List<Interests> areaList = new ArrayList<Interests>();
        for (InterestData interestData : listOfArea) {
            Interests interests = new Interests();
            interests.setAoeId(interestData.getInterestcode());
            areaList.add(interests);
        }

        return areaList;
    }

    /**
     * This method will call external service look up profile to get alerts
     * 
     * 
     * @param userId
     */
    @Override
    public List<Alert> getListOfAlerts(final String userId) {

        List<AlertData> listOfAlert = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getAlerts().getAlert();
        List<Alerts> daoAlert = alertsDao.getAlerts();
        List<Alert> alertList = new ArrayList<Alert>();

        for (Alerts alerts : daoAlert) {
            Alert alert = null;
            for (AlertData alertData : listOfAlert) {
                alert = new Alert();
                if (alerts.getAlertCd().equals(alertData.getAlertID())) {
                    alert.setAlertId(alertData.getAlertID());
                    alert.setAlertName(alerts.getAlertName());
                    if (alertData.getType().getEmail().equalsIgnoreCase("0")) {
                        alert.setEmail(true);
                    } else {
                        alert.setEmail(false);
                    }
                    if (alertData.getType().getOnscreen().equalsIgnoreCase("0")) {
                        alert.setOnScreen(true);
                    } else {
                        alert.setOnScreen(false);
                    }

                    break;
                }
                alert.setAlertId(alerts.getAlertCd());
                alert.setAlertName(alerts.getAlertName());
            }
            alertList.add(alert);
        }

        return alertList;
    }

    /**
     * This method will call external service look up profile to get preferred
     * journals
     * 
     * 
     * @param userId
     */
    @Override
    public List<PreferredJournals> getPrefferedJournals(final String userId) {

        List<Journal> journalList = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getFavoriteJournals().getJournal();
        List<PreferredJournals> prefferedList = new ArrayList<PreferredJournals>();
        for (Journal journal : journalList) {
            PreferredJournals preferredJournals = new PreferredJournals();
            preferredJournals.setJournalId(journal.getId());
            preferredJournals.setJournalTitle(journal.getJournalTitle());
            prefferedList.add(preferredJournals);

        }
        return prefferedList;
    }

    @Override
    public CustomerDetails getCustomeProfile(final String userId) {

        CustomerDetails customerDetails = userProfiles
                .getLookupCustomerProfile(userId)
                .getLookupCustomerProfileResponse().getCustomerProfile()
                .getCustomerDetails();
        customerDetails.setPswd("");
        customerDetails.setAsid(userId);
        customerDetails.setUserRole("");
        customerDetails.setNickName(customerDetails.getAlternativeName());
        customerDetails.setCustomerType("User");
        customerDetails.setUserStatus("Active");
        customerDetails.setTcFlag("Y");
        customerDetails.setSendEmail("Yes");

        return customerDetails;
    }

    @Override
    public boolean removeOrcidId(final String userId) {

        return this.orcidIdDetails(userId, null);

    }

    @Override
    public boolean updateOrcidId(final String userId, final String orcidId) {

        return this.orcidIdDetails(userId, orcidId);

    }

    private boolean orcidIdDetails(final String userId, final String orcidId) {

        CustomerDetails customerDetails = getCustomeProfile(userId);
        customerDetails.setOrcId(orcidId);
        LookupCustomerProfileResponse lookupCustomerProfileResponse = new LookupCustomerProfileResponse();
        CustomerProfile customerProfile = new CustomerProfile();
        customerProfile.setCustomerDetails(customerDetails);
        lookupCustomerProfileResponse.setCustomerProfile(customerProfile);
        return userProfiles
                .customerProfileUpdate(lookupCustomerProfileResponse);

    }

}
