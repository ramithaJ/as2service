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

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.external.DashboardView;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.ProfileInformation;
import com.wiley.gr.ace.authorservices.model.external.SearchUserResult;
import com.wiley.gr.ace.authorservices.model.external.Status;

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
    public User fetchOrcidDetails(final String orcid) throws Exception {
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
    public String updateALMUser(final User updateUser) throws Exception {
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
    public ESBUser checkEmailIdExists(final String emailId) throws Exception {
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
    public List<ESBUser> getUsersFromFirstNameLastName(final String firstName,
            final String lastName) throws Exception {
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
    private List<ESBUser> searchUser(final String email,
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
    public Status creatUser(final ProfileInformation profileForCreation)
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
     * This method is for viewing dashboard.
     *
     * @param userId
     *            the user id
     * @return the dashboard view
     */
    @Override
    public DashboardView viewDashboard(final int userId) {
        DashboardView dashboardView = null;
        final String url = "http://demo7930138.mockable.io/dashboard/view/1000";
        try {
            final URI uri = new URI(url);
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
            e.printStackTrace();
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
    public ArticleInfoDetails getArticleInfo(final String emailId) {
        ArticleInfoDetails articleInfoDetails = null;
        final String url = "http://demo7930138.mockable.io/article/getArticleInfo/emailId";
        try {
            final URI uri = new URI(url);
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
            e.printStackTrace();
        }
        return articleInfoDetails;
    }

    /**
     * This method is used to confirmAssociation.
     * 
     * @return the article info
     */
    @Override
    public boolean confirmAssociation() {
        return false;
    }

}
