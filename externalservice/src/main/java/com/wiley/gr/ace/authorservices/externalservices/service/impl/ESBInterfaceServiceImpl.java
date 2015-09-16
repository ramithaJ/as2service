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
import java.net.URISyntaxException;
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

import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.external.util.PdhLookupServiceUtil;
import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ALMAuthRequest;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.ArticlePdfResponse;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.model.external.ResponseStatus;
import com.wiley.gr.ace.authorservices.model.external.SearchUserResult;
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

    /** The alm authurl. */
    @Value("${almauthenticate.url}")
    private String almAuthurl;

    /** The license status url. */
    @Value("${articlePdfResponse.url}")
    private String articlePdfResponseUrl;

    /** The pdh lookup jorunal response. */
    @Value("${pdhLookupJorunalResponse.url}")
    private String pdhLookupJorunalResponse;

    @Value("${startPdhLookup.url}")
    private String startPdhLookupUrl;

    @Value("${endPdhLookup.url}")
    private String endPdhLookupUrl;

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
        final String url = fetchOrcidDetailsUrl;
        final URI uri = new URI(url);
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        final HttpEntity<User> requestEntity = new HttpEntity<User>(
                requestHeaders);

        final ResponseEntity<User> response = restTemplate.exchange(uri,
                HttpMethod.GET, requestEntity, User.class);
        return response.getBody();
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
        final String url = updateAlmUserUrl;
        final URI uri = new URI(url);
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders requestHeaders = new HttpHeaders();

        requestHeaders.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
        final HttpEntity<String> requestEntity = new HttpEntity<String>(
                requestHeaders);
        final ResponseEntity<String> response = restTemplate.exchange(uri,
                HttpMethod.GET, requestEntity, String.class);
        return response.getBody();
    }

    /**
     * This for checking if user exists or not.
     *
     * @param emailId
     *            the email id
     * @return the ESB user
     * 
     */
    @Override
    public final ESBUser checkEmailIdExists(final String emailId) {
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
     * 
     */
    @Override
    public final ArrayList<ESBUser> getUsersFromFirstNameLastName(
            final String firstName, final String lastName) {

        return searchUser("", firstName, lastName);
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
     * 
     */
    private ArrayList<ESBUser> searchUser(final String email,
            final String firstName, final String lastName) {
        ArrayList<ESBUser> esbUsersList = null;
        SearchUserResult searchUserResult = null;
        String searchJobUrl = searchUserUrl;
        if (!StringUtils.isEmpty(email)) {
            searchJobUrl = searchJobUrl + "?Email=" + email;
        }

        if (!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)) {
            searchJobUrl = searchJobUrl + "?FirstName=" + firstName
                    + "&LastName=" + lastName;
        }

        searchUserResult = (SearchUserResult) RestServiceInvokerUtil
                .getServiceData(searchJobUrl, SearchUserResult.class);

        if ("success".equalsIgnoreCase(searchUserResult.getStatus())) {
            esbUsersList = (ArrayList<ESBUser>) searchUserResult
                    .getSearchCustomerResponse();
        }

        return esbUsersList;
    }

    /**
     * This method is for creating user.
     *
     * @param profileForCreation
     *            the profile for creation
     * @return the status
     * 
     */
    @Override
    public final String creatUser(final ProfileInformation profileForCreation) {
        ResponseStatus responseStatus = (ResponseStatus) RestServiceInvokerUtil
                .restServiceInvoker(createUserUrl, profileForCreation,
                        ResponseStatus.class);
        return responseStatus.getStatus();

    }

    /**
     * Checks if is ALM authenticated.
     *
     * @param almAuthRequest
     *            the alm auth request
     * @return true, if is ALM authenticated
     */
    @Override
    public final boolean isALMAuthenticated(final ALMAuthRequest almAuthRequest) {

        boolean isALMAuth = false;
        try {
            ResponseEntity<String> responseEntity = new RestTemplate()
                    .postForEntity(new URI(almAuthurl), almAuthRequest,
                            String.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                isALMAuth = true;
            }
        } catch (URISyntaxException e) {
            throw new UserException("UNEXPECTED",
                    "Some Unexpected Error occured");
        }

        return isALMAuth;
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
                articlePdfResponseUrl + articleDoi, HttpMethod.GET,
                ArticlePdfResponse.class);
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

    /**
     * Gets the pdh lookup response.
     *
     * @param dhId
     *            the dh id
     * @return the object
     * @throws Exception
     *             the exception
     */
    @Override
    public Object getPdhLookupResponse(final String dhId) throws Exception {

        final String xml = (String) StubInvokerUtil.invokeStub(
                startPdhLookupUrl.concat(dhId).concat(endPdhLookupUrl),
                HttpMethod.GET, String.class);
        Object lookupObject = null;
        if (!StringUtils.isEmpty(xml))
            lookupObject = PdhLookupServiceUtil.lookup(xml);
        lookupObject = PdhLookupServiceUtil.invokePdhLookupData(lookupObject);
        return lookupObject;
    }

}
