/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.*;

import java.util.List;

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
    User fetchOrcidDetails(String orcid);

    /**
     * Update alm user.
     *
     * @param user
     *            the user
     * @return the string
     * @throws Exception
     *             the exception
     */
    String updateALMUser(User user);

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
     * Gets the article pdf response.
     *
     * @param articleDoi
     *            the article doi
     * @return the article pdf response
     * @throws Exception
     *             the exception
     */
    ArticlePdfResponse getArticlePdfResponse(String articleDoi);

    /**
     * Gets the pdh lookup journal response.
     *
     * @param journalId
     *            the journal id
     * @return the pdh lookup journal response
     * @throws Exception
     *             the exception
     */
    PdhLookupJournalResponse getPdhLookupJournalResponse(String journalId);

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
    Quote getQuote(QuoteRequest quoteRequest);

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
    TaxResponse getTaxInfo(TaxRequest taxRequest);

    /**
     * Gets the pdh lookup response.
     *
     * @param dhId
     *            the dh id
     * @return the object
     * @throws Exception
     *             the exception
     */
    Object getPdhLookupResponse(String dhId);

    /**
     * Checks if is ALM authenticated.
     *
     * @param almAuthRequest
     *            the alm auth request
     * @return true, if is ALM authenticated
     */
    boolean isALMAuthenticated(ALMAuthRequest almAuthRequest);
}
