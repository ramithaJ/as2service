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

import java.util.List;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.external.ArticleRecord;
import com.wiley.gr.ace.authorservices.model.external.CommunicationDetails;
import com.wiley.gr.ace.authorservices.model.external.DashboardView;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.License;
import com.wiley.gr.ace.authorservices.model.external.OnlineOpen;
import com.wiley.gr.ace.authorservices.model.external.OpenAccess;
import com.wiley.gr.ace.authorservices.model.external.Production;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;
import com.wiley.gr.ace.authorservices.model.external.Status;

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
     * @throws Exception
     *             the exception
     */
    ESBUser checkEmailIdExists(String emailId) throws Exception;

    /**
     * Gets the users from first name last name.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the users from first name last name
     * @throws Exception
     *             the exception
     */
    List<ESBUser> getUsersFromFirstNameLastName(String firstName,
            String lastName) throws Exception;

    /**
     * Creat user.
     *
     * @param profileForCreation
     *            the profile for creation
     * @return the status
     * @throws Exception
     *             the exception
     */
    Status creatUser(ProfileInformation profileForCreation) throws Exception;

    /**
     * View dashboard.
     *
     * @param userId
     *            the user id
     * @return the dashboard view
     */
    DashboardView viewDashboard(String userId);

	List<ArticleData> getAllAuthorArticles(String userId) throws Exception;

	License getLicenseStatus(Integer articleId) throws Exception;

	OpenAccess getOpenAccessStatus(Integer articleId) throws Exception;

	OnlineOpen getOnlineOpenStatus(Integer articleId) throws Exception;

	Production getProductionStatus(Integer articleId) throws Exception;

	List<CommunicationDetails> getCommunicationDetails(String emailId)
			throws Exception;

	ArticleRecord getArticleCitationReadRecords(String userId) throws Exception;

	ArticleInfoDetails getArticleInfo(String emailId) throws Exception;

    /**
     * Confirm association.
     *
     * @return true, if successful
     */
    boolean confirmAssociation();
}
