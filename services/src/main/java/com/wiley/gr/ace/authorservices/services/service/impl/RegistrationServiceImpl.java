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
import com.wiley.gr.ace.authorservices.model.external.Status;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.services.service.RegistrationService;

/**
 * @author virtusa version 1.0
 */
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired(required = true)
    ESBInterfaceService esbInterFaceService;

    @Autowired(required = true)
    RegistrationServiceDAO registrationServiceDAO;

    @Override
    public String createUser(User user) throws Exception {

        String status = null;
        Status statusObj = null;
        if (null != user) {
            ProfileInformation profileInformation = new ProfileInformation();
            CustomerProfile customerProfile = new CustomerProfile();
            CustomerDetails customerDetails = new CustomerDetails();
            AddressDetails cuAddressDetails = new AddressDetails();
            List<AddressElement> addressElements = new ArrayList<AddressElement>();
            AddressElement addressElement = new AddressElement();

            customerDetails.setFirstname(user.getFirstName());
            customerDetails.setLastname(user.getLastName());
            customerDetails.setPassword(user.getPassword());
            customerDetails.setPrimaryemail(user.getPrimaryEmailAddr());

            addressElement.setCountrycode(user.getCountry().getCountryCode());
            addressElement.setCountryname(user.getCountry().getCountryName());
            // addressElement.setCountrynamene(user.getCountryNameNE());
            addressElements.add(addressElement);
            cuAddressDetails.setAddress(addressElements);

            customerProfile.setCustomerdetails(customerDetails);
            customerProfile.setAddressdetails(cuAddressDetails);

            profileInformation.setCustomerprofile(customerProfile);

            statusObj = esbInterFaceService.creatUser(profileInformation);
        }
        if (null != statusObj) {
            if ("SUCCESS".equalsIgnoreCase(statusObj.getStatus())) {
                status = "SUCCESS";
            } else {
                status = "FAILURE";
            }
        } else {
            status = "FAILURE";
        }
        return status;
    }

    @Override
    public List<User> getUserFromFirstNameLastName(String firstName,
            String lastName) throws Exception {

        List<User> userList = new ArrayList<User>();
        List<ESBUser> esbUserList = null;
        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            esbUserList = esbInterFaceService.getUsersFromFirstNameLastName(
                    firstName, lastName);

            if (!StringUtils.isEmpty(esbUserList)) {
                for (ESBUser esbUser : esbUserList) {
                    User tempUser = new User();
                    Country tempCountry = new Country();
                    tempCountry.setCountryName(esbUser.getCountry());
                    tempUser.setFirstName(esbUser.getFirstName());
                    tempUser.setLastName(esbUser.getLastName());
                    tempUser.setPrimaryEmailAddr(esbUser.getEmailID());
                    tempUser.setCountry(tempCountry);
                    userList.add(tempUser);
                }
            } else {
                userList = null;
            }
        }

        return userList;
    }

    @Override
    public User checkEmailIdExists(String emailId) throws Exception {
        User user = new User();
        ESBUser esbUser = null;
        if (!StringUtils.isEmpty(emailId)) {
            esbUser = esbInterFaceService.checkEmailIdExists(emailId);
            if (null != esbUser) {
                Country countryDetails = new Country();
                countryDetails.setCountryName(esbUser.getCountry());
                user.setFirstName(esbUser.getFirstName());
                user.setLastName(esbUser.getLastName());
                user.setPrimaryEmailAddr(esbUser.getEmailID());
                user.setCountry(countryDetails);
            } else {
                user = null;
            }
        } else {
            user = null;
        }

        return user;
    }

    @Override
    public boolean searchUserByOrcidId(String orcidId) throws Exception {

        boolean isUserFound = false;
        if (!StringUtils.isEmpty(orcidId)
                && registrationServiceDAO.searchUserByOrcidId(orcidId)) {
            isUserFound = true;
        }

        return isUserFound;
    }

    @Override
    public InviteRecords searchInvitationRecord(String guid) throws Exception {
        InviteRecords inviteRecord = new InviteRecords();
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

	@Override
	public void assignRoleToNewUser(String emailId) {

		registrationServiceDAO.assignRoleToNewRegistration(emailId);
	}
}
