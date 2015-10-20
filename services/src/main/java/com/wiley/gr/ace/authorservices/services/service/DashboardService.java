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

import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.model.Dashboard;
import com.wiley.gr.ace.authorservices.model.DashboardView;
import com.wiley.gr.ace.authorservices.model.EmailCommunicationHistory;

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
     * @throws UserException
     *             the user exception
     */
    Dashboard getProfileMeter(String userId) throws UserException;

    /**
     * Gets the all author articles.
     *
     * @param userId
     *            the user id
     * @return the all author articles
     * @throws UserException
     *             the user exception
     */
    DashboardView getAllAuthorArticles(String userId) throws UserException;

    /**
     * Action required.
     *
     * @param userId
     *            the user id
     * @return the dashboard view
     * @throws UserException
     *             the user exception
     */
    DashboardView actionRequired(String userId) throws UserException;

    /**
     * Gets the email communication history.
     *
     * @param userId
     *            the user id
     * @return the email communication history
     * @throws UserException
     *             the user exception
     */
    EmailCommunicationHistory getEmailCommunicationHistory(String userId)
            throws UserException;

    /**
     * Gets the production details.
     *
     * @param userId
     *            the user id
     * @return the production details
     * @throws UserException
     *             the user exception
     */
    DashboardView getProductionDetails(String userId) throws UserException;

    /**
     * Gets the published article details.
     *
     * @param userId
     *            the user id
     * @return the published article details
     * @throws UserException
     *             the user exception
     */
    DashboardView getPublishedArticleDetails(String userId) throws UserException;
}
