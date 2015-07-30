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
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.InviteRecords;
import com.wiley.gr.ace.authorservices.model.User;
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

    /**
     * This method is for creating user.
     *
     * @param user
     *            the user
     * @return the string
     * @throws Exception
     *             the exception
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

                customerDetails.setfName(user.getFirstName());
                customerDetails.setlName(user.getLastName());
                customerDetails.setPswd(user.getPassword());
                customerDetails.setSkipTargetSystem(user.getFoundIn());
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

                addressElement.setCountryCode(user.getCountry()
                        .getCountryCode());
                addressElement.setCountryName(user.getCountry()
                        .getCountryName());
                // addressElement.setCountrynamene(user.getCountryNameNE());
                addressElements.add(addressElement);
                cuAddressDetails.setAddress(addressElements);

                customerProfile.setCustomerDetails(customerDetails);
                customerProfile.setAddressDetails(cuAddressDetails);

                profileInformation.setCustomerprofile(customerProfile);

                status = esbInterFaceService.creatUser(profileInformation);
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
     * @throws Exception
     *             the exception
     */
    @Override
    public final List<User> getUserFromFirstNameLastName(
            final String firstName, final String lastName) {

        ArrayList<User> userList = null;
        List<ESBUser> esbUserList = null;
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            try {
                esbUserList = esbInterFaceService
                        .getUsersFromFirstNameLastName(firstName, lastName);

                if (!StringUtils.isEmpty(esbUserList)) {
                    for (final ESBUser esbUser : esbUserList) {
                        userList = new ArrayList<User>();
                        final User tempUser = new User();
                        final Country tempCountry = new Country();
                        tempCountry.setCountryName(esbUser.getCountry());
                        tempUser.setFirstName(esbUser.getFirstName());
                        tempUser.setLastName(esbUser.getLastName());
                        tempUser.setPrimaryEmailAddr(esbUser.getEmailId());
                        tempUser.setCountry(tempCountry);
                        userList.add(tempUser);
                    }
                }
            } catch (Exception e) {
                throw new UserException("Some Error",e.getMessage());
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
     * @throws Exception
     *             the exception
     */
    @Override
    public final User checkEmailIdExists(final String emailId) {
        User user = null;
        ESBUser esbUser = null;
        if (!StringUtils.isEmpty(emailId)) {
            try {
                esbUser = esbInterFaceService.checkEmailIdExists(emailId);

                if (null != esbUser) {
                    System.err.println(esbUser.getFirstName());
                    System.err.println(esbUser.getLastName());
                    System.err.println(esbUser.getCountry());
                    user = new User();
                    final Country countryDetails = new Country();
                    countryDetails.setCountryName(esbUser.getCountry());
                    user.setFirstName(esbUser.getFirstName());
                    user.setLastName(esbUser.getLastName());
                    user.setPrimaryEmailAddr(esbUser.getEmailId());
                    user.setCountry(countryDetails);
                    user.setFoundIn(esbUser.getFoundIn());
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
