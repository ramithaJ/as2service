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

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ALMAuthRequest;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.external.DashboardView;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;
import com.wiley.gr.ace.authorservices.model.external.ResponseStatus;
import com.wiley.gr.ace.authorservices.model.external.SearchUserResult;

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

    /** The viewDashboardUrl */
    @Value("${viewDashboard.url}")
    private String viewDashboardUrl;

    /** The articleInfoUrl. */
    @Value("${articleInfo.url}")
    private String articleInfoUrl;

    /** The fetch orcid details url. */
    @Value("${fetchorciddetails.url}")
    private String fetchOrcidDetailsUrl;

    /** The update alm user url. */
    @Value("${updatealmuser.url}")
    private String updateAlmUserUrl;

    /** The alm authurl. */
    @Value("${almauthenticate.url}")
    private String almAuthurl;

    /** the INTERNAL_SERVER_ERROR_CODE. */
    @Value("${internal.server.error.code}")
    private String INTERNAL_SERVER_ERROR_CODE;

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
        final URI uri = new URI(fetchOrcidDetailsUrl);
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
        final URI uri = new URI(updateAlmUserUrl);
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
     * This method is for viewing dashboard.
     *
     * @param userId
     *            the user id
     * @return the dashboard view
     */
    @Override
    public final DashboardView viewDashboard(final int userId) {
        DashboardView dashboardView = null;
        try {
            final URI uri = new URI(viewDashboardUrl);
            final RestTemplate restTemplate = new RestTemplate();
            final HttpHeaders requestHeaders = new HttpHeaders();

            requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            final HttpEntity<DashboardView> requestEntity = new HttpEntity<DashboardView>(
                    requestHeaders);

            final ResponseEntity<DashboardView> response = restTemplate
                    .exchange(uri, HttpMethod.GET, requestEntity,
                            DashboardView.class);
            dashboardView = response.getBody();
        } catch (URISyntaxException e) {
            throw new ASException(INTERNAL_SERVER_ERROR_CODE, e.getMessage());
        }
        return dashboardView;

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
        ArticleInfoDetails articleInfoDetails = null;
        try {
            final URI uri = new URI(articleInfoUrl);
            final RestTemplate restTemplate = new RestTemplate();
            final HttpHeaders requestHeaders = new HttpHeaders();

            requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            final HttpEntity<ArticleInfoDetails> requestEntity = new HttpEntity<ArticleInfoDetails>(
                    requestHeaders);

            final ResponseEntity<ArticleInfoDetails> response = restTemplate
                    .exchange(uri, HttpMethod.GET, requestEntity,
                            ArticleInfoDetails.class);
            articleInfoDetails = response.getBody();
        } catch (URISyntaxException e) {
            throw new ASException(INTERNAL_SERVER_ERROR_CODE, e.getMessage());
        }
        return articleInfoDetails;
    }

    /**
     * This method is used to confirmAssociation.
     * 
     * @return the article info
     */
    @Override
    public final boolean confirmAssociation() {
        return false;
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

}
