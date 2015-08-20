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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.external.ArticlePdfResponse;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.OnlineOpen;
import com.wiley.gr.ace.authorservices.model.external.OpenAccess;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.ProductionData;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.model.external.SearchUserResult;
import com.wiley.gr.ace.authorservices.model.external.Status;
import com.wiley.gr.ace.authorservices.model.external.TaxRequest;
import com.wiley.gr.ace.authorservices.model.external.TaxResponse;

/**
 * The Class ESBInterfaceServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class ESBInterfaceServiceImpl implements ESBInterfaceService {

    /** The search user url. */
    @Value("${search-user.url}")
    private String searchUserUrl;

    /** The create user url. */
    @Value("${createuser.url}")
    private String createUserUrl;

    /** The fetch orcid details url. */
    @Value("${fetchorciddetails.url}")
    private String fetchOrcidDetailsUrl;

    /** The update alm user url. */
    @Value("${updatealmuser.url}")
    private String updateAlmUserUrl;

    /** The article info details url. */
    @Value("${articleInfoDetails.url}")
    private String articleInfoDetailsUrl;

    /** The article data url. */
    @Value("${articleData.url}")
    private String articleDataUrl;

    /** The license status url. */
    @Value("${articlePdfResponse.url}")
    private String articlePdfResponseUrl;

    /** The open access status url. */
    @Value("${openAccessStatus.url}")
    private String openAccessStatusUrl;

    /** The online open status url. */
    @Value("${onlineOpenStatus.url}")
    private String onlineOpenStatusUrl;

    /** The production status url. */
    @Value("${productionStatus.url}")
    private String productionStatusUrl;

    /** The view assigned article url. */
    @Value("${viewAssignedArticle.url}")
    private String viewAssignedArticleUrl;

    /** The pdh lookup jorunal response. */
    @Value("${pdhLookupJorunalResponse.url}")
    private String pdhLookupJorunalResponse;

    /**
     * This method is for fetching ordid details by calling external service
     * based on orcid.
     *
     * @param orcid
     *            the orcid
     * @return the user
     * @throws Exception
     *             the exception
     */
    @Override
    public final User fetchOrcidDetails(final String orcid) throws Exception {
        User user = null;
        final String url = fetchOrcidDetailsUrl;
        final URI uri = new URI(url);
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        final HttpEntity<User> requestEntity = new HttpEntity<User>(
                requestHeaders);

        final ResponseEntity<User> response = restTemplate.exchange(uri,
                HttpMethod.GET, requestEntity, User.class);
        user = response.getBody();
        return user;
    }

    /**
     * This for updating user data.
     *
     * @param updateUser
     *            the update user
     * @return the string
     * @throws Exception
     *             the exception
     */
    @Override
    public final String updateALMUser(final User updateUser) throws Exception {
        String status = "failure";
        final String url = updateAlmUserUrl;
        final URI uri = new URI(url);
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
        final HttpEntity<String> requestEntity = new HttpEntity<String>(
                requestHeaders);
        final ResponseEntity<String> response = restTemplate.exchange(uri,
                HttpMethod.GET, requestEntity, String.class);
        status = response.getBody();
        return status;
    }

    /**
     * This for checking if user exists or not.
     *
     * @param emailId
     *            the email id
     * @return the ESB user
     * @throws Exception
     *             the exception
     */
    @Override
    public final ESBUser checkEmailIdExists(final String emailId)
            throws Exception {
        ESBUser esbUser = null;
        final List<ESBUser> esbUserList = searchUser(emailId, "", "");
        if (!StringUtils.isEmpty(esbUserList)) {
            esbUser = esbUserList.get(0);
        }
        return esbUser;
    }

    /**
     * This method is for getting UsersFromFirstNameLastName.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the users from first name last name
     * @throws Exception
     *             the exception
     */
    @Override
    public final List<ESBUser> getUsersFromFirstNameLastName(
            final String firstName, final String lastName) throws Exception {
        List<ESBUser> esbUserList = null;

        esbUserList = searchUser("", firstName, lastName);

        return esbUserList;
    }

    /**
     * This method is for searching user.
     *
     * @param email
     *            the email
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @return the list
     * @throws Exception
     *             the exception
     */
    private final List<ESBUser> searchUser(final String email,
            final String firstName, final String lastName) throws Exception {
        ArrayList<ESBUser> esbUsersList = null;
        SearchUserResult searchUserResult = null;
        final String url = searchUserUrl + "?Email=" + email + "&FirstName="
                + firstName + "&LastName=" + lastName;
        final URI uri = new URI(url);
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        final HttpEntity<SearchUserResult> requestEntity = new HttpEntity<SearchUserResult>(
                requestHeaders);

        final ResponseEntity<SearchUserResult> response = restTemplate
                .exchange(uri, HttpMethod.GET, requestEntity,
                        SearchUserResult.class);
        if (null != response) {
            searchUserResult = new SearchUserResult();
            searchUserResult = response.getBody();
            esbUsersList = (ArrayList<ESBUser>) searchUserResult
                    .getSearchUserResponse().getUserList();
        }

        return esbUsersList;
    }

    /**
     * This method is for creating user.
     *
     * @param profileForCreation
     *            the profile for creation
     * @return the status
     * @throws Exception
     *             the exception
     */
    @Override
    public final Status creatUser(final ProfileInformation profileForCreation)
            throws Exception {
        final Status status = new Status();
        final String url = createUserUrl;
        final URI uri = new URI(url);
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
        final HttpEntity<ProfileInformation> requestEntity = new HttpEntity<ProfileInformation>(
                profileForCreation, requestHeaders);
        final ResponseEntity<Status> response = restTemplate.exchange(uri,
                HttpMethod.POST, requestEntity, Status.class);
        final HttpStatus httpStatus = response.getStatusCode();
        if (httpStatus.equals(HttpStatus.OK)) {
            status.setStatus("SUCCESS");
        } else {
            status.setStatus("FAILURE");
        }
        return status;
    }

    /**
     * This method is for getting article info based on emailId.
     *
     * @param emailId
     *            the email id
     * @return the article info
     */
    @Override
    public final ArticleInfoDetails getArticleInfo(final String emailId) {
        return (ArticleInfoDetails) StubInvokerUtil
                .invokeStub(articleInfoDetailsUrl, HttpMethod.GET,
                        ArticleInfoDetails.class);
    }

    /**
     * Gets the author article.
     *
     * @param articleId
     *            the article id
     * @return the author article
     * @throws Exception
     *             the exception
     */
    @Override
    public final ArticleData getAuthorArticle(final Integer articleId)
            throws Exception {
        return (ArticleData) StubInvokerUtil.invokeStub(articleDataUrl,
                HttpMethod.GET, ArticleData.class);
    }

    /**
     * Gets the article pdf response.
     *
     * @param journalDoi
     *            the journal doi
     * @return the article pdf response
     * @throws Exception
     *             the exception
     */
    @Override
    public final ArticlePdfResponse getArticlePdfResponse(
            final String articleDoi) throws Exception {
        return (ArticlePdfResponse) StubInvokerUtil.invokeStub(
                articlePdfResponseUrl+articleDoi, HttpMethod.GET, ArticlePdfResponse.class);
    }

    /**
     * Gets the open access status.
     *
     * @param articleId
     *            the article id
     * @return the open access status
     * @throws Exception
     *             the exception
     */
    @Override
    public final OpenAccess getOpenAccessStatus(final Integer articleId)
            throws Exception {
        return (OpenAccess) StubInvokerUtil.invokeStub(openAccessStatusUrl,
                HttpMethod.GET, OpenAccess.class);
    }

    /**
     * Gets the online open status.
     *
     * @param articleId
     *            the article id
     * @return the online open status
     * @throws Exception
     *             the exception
     */
    @Override
    public final OnlineOpen getOnlineOpenStatus(final Integer articleId)
            throws Exception {
        return (OnlineOpen) StubInvokerUtil.invokeStub(onlineOpenStatusUrl,
                HttpMethod.GET, OnlineOpen.class);
    }

    /**
     * Gets the production data.
     *
     * @param articleId
     *            the article id
     * @return the production data
     * @throws Exception
     *             the exception
     */
    @Override
    public final ProductionData getProductionData(final Integer articleId)
            throws Exception {
        return (ProductionData) StubInvokerUtil.invokeStub(productionStatusUrl,
                HttpMethod.GET, ProductionData.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService
     * #getQuote(com.wiley.gr.ace.authorservices.model.external.QuoteRequest)
     */
    @Override
    public Quote getQuote(final QuoteRequest quoteRequest) throws Exception {
        return (Quote) StubInvokerUtil.invokeJsonStub(
                "http://jsonstub.com/getQuote", HttpMethod.POST, Quote.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService
     * #getTaxInfo(com.wiley.gr.ace.authorservices.model.external.TaxRequest)
     */
    @Override
    public TaxResponse getTaxInfo(final TaxRequest taxRequest) throws Exception {
        return (TaxResponse) StubInvokerUtil.invokeJsonStub(
                "http://jsonstub.com/getTaxDetails", HttpMethod.POST,
                TaxResponse.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService
     * #pdhGetArticle(java.lang.String)
     */
    @Override
    public ArticleData pdhGetArticle(final String articleId) {
        return (ArticleData) StubInvokerUtil.invokeJsonStub(
                "http://google.com", HttpMethod.POST, ArticleData.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService
     * #pdhJournalLookUp(java.lang.String)
     */
    @Override
    public PdhJournalResponse pdhJournalLookUp(final String journalId) {
        return (PdhJournalResponse) StubInvokerUtil.invokeJsonStub(
                "http://jsonstub.com/pdh/lookupjournal", HttpMethod.POST,
                PdhJournalResponse.class);
    }

    /**
     * View assigned article.
     *
     * @param articleId
     *            the article id
     * @return the pdh lookup article response
     * @throws Exception
     *             the exception
     */
    @Override
    public final PdhLookupArticleResponse viewAssignedArticle(
            final String articleId) throws Exception {
        return (PdhLookupArticleResponse) StubInvokerUtil.invokeStub(
                viewAssignedArticleUrl, HttpMethod.GET,
                PdhLookupArticleResponse.class);
    }

    /**
     * Gets the pdh lookup journal response.
     *
     * @param journalId
     *            the journal id
     * @return the pdh lookup journal response
     * @throws Exception
     *             the exception
     */
    @Override
    public final PdhLookupJournalResponse getPdhLookupJournalResponse(
            final String journalId) throws Exception {
        return (PdhLookupJournalResponse) StubInvokerUtil.invokeStub(
                pdhLookupJorunalResponse, HttpMethod.GET,
                PdhLookupJournalResponse.class);
    }
}
