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

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.external.ConfirmArticleData;
import com.wiley.gr.ace.authorservices.model.external.ESBUser;
import com.wiley.gr.ace.authorservices.model.external.License;
import com.wiley.gr.ace.authorservices.model.external.OnlineOpen;
import com.wiley.gr.ace.authorservices.model.external.OpenAccess;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
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
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		return articleInfoDetails;
	}

	/**
	 * Gets the author article.
	 *
	 * @param userId
	 *            the user id
	 * @return the author article
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public final ArticleData getAuthorArticle(final Integer articleId)
			throws Exception {
		ArticleData articleData = null;
		final String url = "http://demo7930138.mockable.io/getAllAuthorArticles/articleId";
		try {
			final URI uri = new URI(url);
			final RestTemplate restTemplate = new RestTemplate();
			final HttpHeaders requestHeaders = new HttpHeaders();

			requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			final HttpEntity<ArticleData> requestEntity = new HttpEntity<ArticleData>(
					requestHeaders);

			final ResponseEntity<ArticleData> response = restTemplate.exchange(
					uri, HttpMethod.GET, requestEntity, ArticleData.class);
			System.out.println("####  response #### "
					+ response.getStatusCode());
			System.out.println("####  response #### " + response.getBody());
			articleData = response.getBody();
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		return articleData;
	}

	/**
	 * Gets the license status.
	 *
	 * @param articleId
	 *            the article id
	 * @return the license status
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public final License getLicenseStatus(final Integer articleId)
			throws Exception {
		License license = null;
		final String url = "http://demo7930138.mockable.io/getLicenseStatus/articleId";
		try {
			final URI uri = new URI(url);
			final RestTemplate restTemplate = new RestTemplate();
			final HttpHeaders requestHeaders = new HttpHeaders();

			requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			final HttpEntity<License> requestEntity = new HttpEntity<License>(
					requestHeaders);

			final ResponseEntity<License> response = restTemplate.exchange(uri,
					HttpMethod.GET, requestEntity, License.class);
			System.out.println("####  response #### "
					+ response.getStatusCode());
			System.out.println("####  response #### " + response.getBody());

			license = response.getBody();
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		return license;
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
		OpenAccess openAccess = null;
		final String url = "http://demo8663420.mockable.io/getOpenAccessStatus/articleId";
		try {
			final URI uri = new URI(url);
			final RestTemplate restTemplate = new RestTemplate();
			final HttpHeaders requestHeaders = new HttpHeaders();

			requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			final HttpEntity<OpenAccess> requestEntity = new HttpEntity<OpenAccess>(
					requestHeaders);

			final ResponseEntity<OpenAccess> response = restTemplate.exchange(
					uri, HttpMethod.GET, requestEntity, OpenAccess.class);
			System.out.println("####  response #### "
					+ response.getStatusCode());
			System.out.println("####  response #### " + response.getBody());

			openAccess = response.getBody();
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		return openAccess;
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
		OnlineOpen onlineOpen = null;
		final String url = "http://demo8663420.mockable.io/getOnlineOpenStatus/articleId";
		try {
			final URI uri = new URI(url);
			final RestTemplate restTemplate = new RestTemplate();
			final HttpHeaders requestHeaders = new HttpHeaders();

			requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			final HttpEntity<OnlineOpen> requestEntity = new HttpEntity<OnlineOpen>(
					requestHeaders);

			final ResponseEntity<OnlineOpen> response = restTemplate.exchange(
					uri, HttpMethod.GET, requestEntity, OnlineOpen.class);
			System.out.println("####  response #### "
					+ response.getStatusCode());
			System.out.println("####  response #### " + response.getBody());

			onlineOpen = response.getBody();
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		return onlineOpen;
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
		ProductionData productionData = null;
		final String url = "http://demo8663420.mockable.io/getProductionStatus/artilceId";
		try {
			final URI uri = new URI(url);
			final RestTemplate restTemplate = new RestTemplate();
			final HttpHeaders requestHeaders = new HttpHeaders();

			requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			final HttpEntity<ProductionData> requestEntity = new HttpEntity<ProductionData>(
					requestHeaders);

			final ResponseEntity<ProductionData> response = restTemplate
					.exchange(uri, HttpMethod.GET, requestEntity,
							ProductionData.class);
			System.out.println("####  response #### "
					+ response.getStatusCode());
			System.out.println("####  response #### " + response.getBody());
			productionData = response.getBody();
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		return productionData;
	}

	@Override
	public Quote getQuote(final QuoteRequest quoteRequest) throws Exception {
		return (Quote) StubInvokerUtil.invokeJsonStub(
				"http://jsonstub.com/getQuote", HttpMethod.POST, Quote.class);
	}

	@Override
	public TaxResponse getTaxInfo(final TaxRequest taxRequest) throws Exception {
		return (TaxResponse) StubInvokerUtil.invokeJsonStub(
				"http://jsonstub.com/getTaxDetails", HttpMethod.POST,
				TaxResponse.class);
	}

	@Override
	public ArticleData pdhGetArticle(final String articleId) {
		return (ArticleData) StubInvokerUtil.invokeJsonStub(
				"http://google.com", HttpMethod.POST, ArticleData.class);
	}

	@Override
	public PdhJournalResponse pdhJournalLookUp(final String journalId) {
		return (PdhJournalResponse) StubInvokerUtil.invokeJsonStub(
				"http://jsonstub.com/pdh/lookupjournal", HttpMethod.POST,
				PdhJournalResponse.class);
	}

	/**
	 * Gets the article confirmation data.
	 *
	 * @param emailId
	 *            the email id
	 * @return the article confirmation data
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public final ConfirmArticleData getArticleConfirmationData(
			final String emailId) throws Exception {
		ConfirmArticleData confirmArticleData = null;
		final String url = "http://demo7930138.mockable.io/getArticleInfo/confirmation/emailId";
		try {
			final URI uri = new URI(url);
			final RestTemplate restTemplate = new RestTemplate();
			final HttpHeaders requestHeaders = new HttpHeaders();

			requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			final HttpEntity<ConfirmArticleData> requestEntity = new HttpEntity<ConfirmArticleData>(
					requestHeaders);

			final ResponseEntity<ConfirmArticleData> response = restTemplate
					.exchange(uri, HttpMethod.GET, requestEntity,
							ConfirmArticleData.class);
			confirmArticleData = response.getBody();
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		return confirmArticleData;
	}

	public final Service authorLookup(String firstName, String lastName,
			String email) throws Exception {

		return null;
	}

}
