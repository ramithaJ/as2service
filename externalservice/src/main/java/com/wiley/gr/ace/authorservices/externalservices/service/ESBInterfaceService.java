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
package com.wiley.gr.ace.authorservices.externalservices.service;

import java.util.ArrayList;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ALMAuthRequest;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.external.DashboardView;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;

/**
 * The Interface ESBInterfaceService.
 *
 * @author virtusa version 1.0
 */
public interface ESBInterfaceService {

    /**
     * Fetch orcid details.
     *
     * @param orcid
     *            the orcid
     * @return the user
     * @throws Exception
     *             the exception
     */
    User fetchOrcidDetails(String orcid) throws Exception;

    /**
     * Update alm user.
     *
     * @param user
     *            the user
     * @return the string
     * @throws Exception
     *             the exception
     */
    String updateALMUser(User user) throws Exception;

    /**
     * Check email id exists.
     *
     * @param emailId
     *            the email id
     * @return the ESB user
     *
     */
    ESBUser checkEmailIdExists(String emailId);

    /**
     * Gets the users from first name last name.
     *
     * @param firstName the first name
     * @param lastName the last name
     * @return the users from first name last name
     */
    ArrayList<ESBUser> getUsersFromFirstNameLastName(String firstName,
            String lastName);

    /**
     * Creat user.
     *
     * @param profileForCreation the profile for creation
     * @return the string
     */
    String creatUser(ProfileInformation profileForCreation);

    /**
     * View dashboard.
     *
     * @param userId
     *            the user id
     * @return the dashboard view
     */
    DashboardView viewDashboard(int userId);

    /**
     * Gets the article info.
     *
     * @param emailId
     *            the email id
     * @return the article info
     */
    ArticleInfoDetails getArticleInfo(String emailId);

    /**
     * Confirm association.
     *
     * @return true, if successful
     */
    boolean confirmAssociation();

    /**
     * Checks if is ALM authenticated.
     *
     * @param almAuthRequest
     *            the alm auth request
     * @return true, if is ALM authenticated
     */
    boolean isALMAuthenticated(ALMAuthRequest almAuthRequest);
}
