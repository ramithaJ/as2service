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
package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.CommunicationDetails;
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardView;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;

/**
 * This DashboardService is for providing service for viewing the Dashboard of
 * Corresponding Author and Co-Author.
 * 
 * @author virtusa version 1.0
 */
public interface DashboardService {

    /**
     * Gets the profile meter.
     *
     * @param userId
     *            to get the data from ESB ExternalService
     * @return Dashboard
     * @throws Exception
     *             the exception
     */
    Dashboard getProfileMeter(String userId) throws Exception;

    /**
     * View dashboard.
     *
     * @param userId
     *            to get the data from ESB ExternalService
     * @return DashboardView
     * @throws Exception
     *             the exception
     */
    DashboardView viewDashboard(String userId) throws Exception;

    /**
     * Gets the communication details.
     *
     * @param userId
     *            the user id
     * @return the communication details
     * @throws Exception
     *             the exception
     */
    List<CommunicationDetails> getCommunicationDetailsList(String userId)
            throws Exception;

    /**
     * Gets the article author data.
     *
     * @param userId
     *            the user id
     * @return the article author data
     * @throws Exception
     *             the exception
     */
    List<ArticleData> getArticleAuthorData(String userId) throws Exception;

    /**
     * Gets the production details.
     *
     * @param userId
     *            the user id
     * @return the production details
     * @throws Exception
     *             the exception
     */
    DashboardView getProductionDetails(String userId) throws Exception;

    /**
     * Gets the published article details.
     *
     * @param userId
     *            the user id
     * @return the published article details
     * @throws Exception
     *             the exception
     */
    DashboardView getPublishedArticleDetails(String userId) throws Exception;
}
