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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.InviteRecords;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ALMAuthRequest;
import com.wiley.gr.ace.authorservices.model.external.AddressDetails;
import com.wiley.gr.ace.authorservices.model.external.AddressElement;
import com.wiley.gr.ace.authorservices.model.external.CustomerDetails;
import com.wiley.gr.ace.authorservices.model.external.CustomerProfile;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

/**
 * The Class RegistrationServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class RegistrationServiceImpl implements RegistrationService {

    /** The esb inter face service. */
    @Autowired(required = true)
    private ESBInterfaceService esbInterFaceService;

    /** The registration service dao. */
    @Autowired(required = true)
    private RegistrationServiceDAO registrationServiceDAO;

    @Autowired(required = true)
    private AutocompleteService autoCompleteService;

    /**
     * This method is for creating user.
     *
     * @param user
     *            the user
     * @return the string
     */
    @Override
    public final String createUser(final User user) {

        String status = null;
        try {
            if (null != user) {
                ProfileInformation profileInformation = new ProfileInformation();
                CustomerProfile customerProfile = new CustomerProfile();
                CustomerDetails customerDetails = new CustomerDetails();
                AddressDetails cuAddressDetails = new AddressDetails();
                List<AddressElement> addressElements = new ArrayList<AddressElement>();
                AddressElement addressElement = new AddressElement();

                if ("ALM".equalsIgnoreCase(user.getFoundIn())) {
                    ALMAuthRequest almAuthRequest = new ALMAuthRequest();
                    almAuthRequest.setAppKey("DAAS"); // remove hardcode
                    almAuthRequest.setAuthenticationType("LDAP"); // remove
                    // hardcode
                    almAuthRequest.setPassword(user.getPassword());
                    almAuthRequest.setUserId(user.getPrimaryEmailAddr());

                    if (esbInterFaceService.isALMAuthenticated(almAuthRequest)) {
                        customerDetails.setSkipTargetSystem(user.getFoundIn());
                    }
                }
                customerDetails.setfName(user.getFirstName());
                customerDetails.setlName(user.getLastName());
                customerDetails.setPswd(user.getPassword());
                if (!StringUtils.isEmpty(user.getInvitationGuid())) {
                    final InviteResetpwdLog inviteResetpwdLog = registrationServiceDAO
                            .getInvitationRecords(user.getInvitationGuid());
                    if (inviteResetpwdLog.getEmailAddress().equalsIgnoreCase(
                            user.getPrimaryEmailAddr())) {
                        customerDetails.setSecondaryEmail(inviteResetpwdLog
                                .getEmailAddress());
                    }

                }
                customerDetails.setPrimaryEmail(user.getPrimaryEmailAddr());
                customerDetails.setTcFlag(user.getTermsOfUseFlg());
                customerDetails.setSourceSystem("AS"); // remove hardcode

                addressElement.setCountryCode(user.getCountryCode());
                String tempCountryName = autoCompleteService.getNameByCode(
                        "countries", user.getCountryCode(), null);
                addressElement.setCountryName(tempCountryName);
                addressElement.setAddressType("Primary"); // remove hardcode
                addressElement.setAddrTypeCD("Physical"); // remove hardcode
                addressElements.add(addressElement);
                cuAddressDetails.setAddress(addressElements);

                customerProfile.setCustomerDetails(customerDetails);
                customerProfile.setAddressDetails(cuAddressDetails);

                profileInformation.setCustomerprofile(customerProfile);

                status = esbInterFaceService.creatUser(profileInformation);
            }
        } catch (HttpClientErrorException httpEx) {
            if (httpEx.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                throw new UserException(
                        "REGISTRATION_ALM_AUTH_FAILURE_ERR_TEXT",
                        "Registration for ALM Authentication Failed. Please enter correct password.");
            } else if (httpEx.getStatusCode() == HttpStatus.LOCKED) {
                throw new UserException(
                        "REGISTRATION_ALM_ACCT_LOCKED_ERR_TEXT",
                        "Your account is locked out please try after sometime.");
            } else {
                throw new UserException("UNEXPECTED",
                        "Some Unexpected Error occured");
            }
        } catch (Exception e) {
            throw new UserException();
        }

        return status;
    }

    /**
     * This is for getting details by UserFromFirstNameLastName.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the user from first name last name
     */
    @Override
    public final ArrayList<User> getUserFromFirstNameLastName(
            final String firstName, final String lastName) {

        ArrayList<User> userList = new ArrayList<User>();
        ArrayList<ESBUser> esbUserList = null;
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            try {
                esbUserList = esbInterFaceService
                        .getUsersFromFirstNameLastName(firstName, lastName);

                if (!StringUtils.isEmpty(esbUserList)) {
                    for (ESBUser esbUser : esbUserList) {
                        User tempUser = new User();
                        Country tempCountry = new Country();
                        if (!StringUtils.isEmpty(esbUser.getAddresses())
                                && !StringUtils.isEmpty(esbUser.getAddresses()
                                        .get(0))) {
                            tempCountry.setCountryCode(esbUser.getAddresses()
                                    .get(0).getCountryCd());
                        }
                        tempUser.setFirstName(esbUser.getFirstName());
                        tempUser.setLastName(esbUser.getLastName());
                        tempUser.setPrimaryEmailAddr(esbUser
                                .getPrimaryEmailAddr());
                        tempUser.setInstituition(esbUser.getInstitution());
                        tempUser.setOrcidId(esbUser.getOrcidId());
                        tempUser.setCountry(tempCountry);
                        userList.add(tempUser);
                    }
                }
            } catch (Exception e) {
                throw new UserException("Some Error", e.getMessage());
            }
        }

        return userList;
    }

    /**
     * This is for checking user exists or not by taking emailId as input.
     *
     * @param emailId
     *            the email id
     * @return the user
     */
    @Override
    public final User checkEmailIdExists(final String emailId) {
        User user = null;
        ESBUser esbUser = null;
        if (!StringUtils.isEmpty(emailId)) {
            try {
                esbUser = esbInterFaceService.checkEmailIdExists(emailId);

                if (!StringUtils.isEmpty(esbUser)) {

                    user = new User();
                    final Country countryDetails = new Country();
                    if (!StringUtils.isEmpty(esbUser.getAddresses())
                            && !StringUtils.isEmpty(esbUser.getAddresses().get(
                                    0))) {
                        countryDetails.setCountryCode(esbUser.getAddresses()
                                .get(0).getCountryCd());
                    }
                    user.setFirstName(esbUser.getFirstName());
                    user.setLastName(esbUser.getLastName());
                    user.setPrimaryEmailAddr(esbUser.getPrimaryEmailAddr());
                    user.setCountry(countryDetails);
                    user.setFoundIn(esbUser.getFoundIN());
                }
            } catch (Exception e) {
                throw new UserException();
            }
        }
        return user;
    }

    /**
     * This is for checking user exists or not by taking orcidId as input.
     *
     * @param orcidId
     *            the orcid id
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean searchUserByOrcidId(final String orcidId)
            throws Exception {

        boolean isUserFound = false;
        if (!StringUtils.isEmpty(orcidId)
                && registrationServiceDAO.searchUserByOrcidId(orcidId)) {
            isUserFound = true;
        }

        return isUserFound;
    }

    /**
     * This is for searchInvitationRecord or not by taking guid as input.
     *
     * @param guid
     *            the guid
     * @return the invite records
     * @throws Exception
     *             the exception
     */
    @Override
    public final InviteRecords searchInvitationRecord(final String guid)
            throws Exception {
        final InviteRecords inviteRecord = new InviteRecords();
        InviteResetpwdLog inviteRecordFromDB = null;
        inviteRecordFromDB = registrationServiceDAO.getInvitationRecords(guid);
        inviteRecord.setEmailAddress(inviteRecordFromDB.getEmailAddress());
        inviteRecord.setFirstName(inviteRecordFromDB.getFirstName());
        inviteRecord.setGuid(inviteRecordFromDB.getGuid());
        inviteRecord.setLastName(inviteRecordFromDB.getLastName());
        inviteRecord.setStatus(inviteRecordFromDB.getStatus());
        inviteRecord.setUserType(inviteRecordFromDB.getUserType());
        return inviteRecord;
    }

    /**
     * This is for assignRoleToNewUser.
     *
     * @param emailId
     *            the email id
     */
    @Override
    public final void assignRoleToNewUser(final String emailId) {

        registrationServiceDAO.assignRoleToNewRegistration(emailId);
    }
}
