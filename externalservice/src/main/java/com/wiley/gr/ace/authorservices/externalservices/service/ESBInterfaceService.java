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
import com.wiley.gr.ace.authorservices.model.external.ALMAuthRequest;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.License;
import com.wiley.gr.ace.authorservices.model.external.OnlineOpen;
import com.wiley.gr.ace.authorservices.model.external.OpenAccess;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.ProductionData;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.model.external.Status;
import com.wiley.gr.ace.authorservices.model.external.TaxRequest;
import com.wiley.gr.ace.authorservices.model.external.TaxResponse;

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
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the users from first name last name
     */
    List<ESBUser> getUsersFromFirstNameLastName(String firstName,
            String lastName);

    /**
     * Creat user.
     *
     * @param profileForCreation
     *            the profile for creation
     * @return the string
     */
    String creatUser(ProfileInformation profileForCreation);

    /**
     * Gets the all author articles.
     *
     * @param articleId
     *            the article id
     * @return the all author articles
     * @throws Exception
     *             the exception
     */
    ArticleData getAuthorArticle(Integer articleId);

    /**
     * Gets the license status.
     *
     * @param articleId
     *            the article id
     * @return the license status
     * @throws Exception
     *             the exception
     */
    License getLicenseStatus(Integer articleId) throws Exception;

    /**
     * Gets the open access status.
     *
     * @param articleId
     *            the article id
     * @return the open access status
     * @throws Exception
     *             the exception
     */
    OpenAccess getOpenAccessStatus(Integer articleId) throws Exception;

    /**
     * Gets the online open status.
     *
     * @param articleId
     *            the article id
     * @return the online open status
     * @throws Exception
     *             the exception
     */
    OnlineOpen getOnlineOpenStatus(Integer articleId) throws Exception;

    /**
     * Gets the production data.
     *
     * @param articleId
     *            the article id
     * @return the production data
     * @throws Exception
     *             the exception
     */
    ProductionData getProductionData(Integer articleId) throws Exception;

    /**
     * View assigned article.
     *
     * @param articleId
     *            the article id
     * @return the pdh lookup article response
     * @throws Exception
     *             the exception
     */
    PdhLookupArticleResponse viewAssignedArticle(String articleId)
            throws Exception;

    /**
     * Gets the pdh lookup journal response.
     *
     * @param journalId
     *            the journal id
     * @return the pdh lookup journal response
     * @throws Exception
     *             the exception
     */
    PdhLookupJournalResponse getPdhLookupJournalResponse(String journalId)
            throws Exception;

    // WP2A

    /**
     * Gets the quote.
     *
     * @param quoteRequest
     *            the quote request
     * @return the quote
     * @throws Exception
     *             the exception
     */
    Quote getQuote(QuoteRequest quoteRequest) throws Exception;

    /**
     * Pdh get article.
     *
     * @param articleId
     *            the article id
     * @return the article data
     */
    ArticleData pdhGetArticle(String articleId);

    /**
     * Pdh journal look up.
     *
     * @param journalId
     *            the journal id
     * @return the pdh journal response
     */
    PdhJournalResponse pdhJournalLookUp(String journalId);

    /**
     * Gets the tax info.
     *
     * @param taxRequest
     *            the tax request
     * @return the tax info
     * @throws Exception
     *             the exception
     */
    TaxResponse getTaxInfo(TaxRequest taxRequest) throws Exception;

    /**
     * Gets the pdh lookup response.
     *
     * @param dhId
     *            the dh id
     * @return the object
     * @throws Exception
     *             the exception
     */
    Object getPdhLookupResponse(String dhId) throws Exception;

    /**
     * Checks if is ALM authenticated.
     *
     * @param almAuthRequest
     *            the alm auth request
     * @return true, if is ALM authenticated
     */
    boolean isALMAuthenticated(ALMAuthRequest almAuthRequest);
}
