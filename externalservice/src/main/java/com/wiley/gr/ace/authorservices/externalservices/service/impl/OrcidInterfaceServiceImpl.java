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
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.restlet.Context;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Reference;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.externalservices.service.OrcidInterfaceService;
import com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken;

/**
 * The Class OrcidInterfaceServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class OrcidInterfaceServiceImpl implements OrcidInterfaceService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger
			.getLogger(OrcidInterfaceServiceImpl.class);

	/** The orcid client id. */
	@Value("${orcid-clientid}")
	private String orcidClientId;

	/** The orcid client secret. */
	@Value("${orcid-clientsecret}")
	private String orcidClientSecret;

	/** The orcid grant type. */
	@Value("${orcid-granttype}")
	private String orcidGrantType;

	/** The orcid url. */
	@Value("${orcid-url}")
	private String orcidUrl;

	/** The orcid token url. */
	@Value("${orcid-tokenurl}")
	private String orcidTokenUrl;

	/** The Logger */
	private static final String HEADER_REQUEST_ATTRIBUTE_KEY = "org.restlet.http.headers";

	/**
	 * This method is for authorizing token.
	 *
	 * @param authorizationCode
	 *            the authorization code
	 * @return the access token
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public final OrcidAccessToken getAccessToken(final String authorizationCode)
			throws Exception {
		final Reference ref = new Reference(orcidTokenUrl);
		if (Context.getCurrent() == null) {
			Context.setCurrent(new Context());
		}
		final ClientResource client = new ClientResource(ref);
		LOGGER.info(" Fetching Orcid Details From Oricd Properties File");
		final Form form = new Form();
		form.add("client_id", orcidClientId);
		form.add("client_secret", orcidClientSecret);
		form.add("grant_type", orcidGrantType);
		form.add("code", authorizationCode);
		LOGGER.info("Need to change this to UI redirect URI ");
		client.getContext().getParameters().add("followRedirects", "true");
		final Representation rep = client
				.post(form, MediaType.APPLICATION_JSON);
		final String json = rep.getText();
		final ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, OrcidAccessToken.class);

	}

	/**
	 * This method is for getting bio details based on orcid token.
	 *
	 * @param token
	 *            the token
	 * @return the bio
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public final String getBio(final OrcidAccessToken token) throws Exception {

		final Reference ref = new Reference(orcidUrl.concat("/")
				.concat(token.getOrcid()).concat("/orcid-bio"));
		final ClientResource client = new ClientResource(ref);
		Map<String, Object> reqAttributes = client.getRequestAttributes();
		Form headers = (Form) reqAttributes.get(HEADER_REQUEST_ATTRIBUTE_KEY);
		if (headers == null) {
			headers = new Form();
			reqAttributes.put(HEADER_REQUEST_ATTRIBUTE_KEY, headers);
		}
		headers.add("Authorization", "Bearer " + token.getAccessToken());
		final Representation representation = client
				.get(MediaType.APPLICATION_JSON);
		return representation.getText();
	}

	/**
	 * this method os for gettin work details.
	 *
	 * @param token
	 *            the token
	 * @return the work
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public final String getWork(final OrcidAccessToken token) throws Exception {

		final Reference ref = new Reference(orcidUrl.concat("/")
				.concat(token.getOrcid()).concat("/orcid-works"));
		final ClientResource client = new ClientResource(ref);
		Map<String, Object> reqAttributes = client.getRequestAttributes();
		Form headers = (Form) reqAttributes.get(HEADER_REQUEST_ATTRIBUTE_KEY);
		if (headers == null) {
			headers = new Form();
			reqAttributes.put(HEADER_REQUEST_ATTRIBUTE_KEY, headers);
		}
		headers.add("Authorization", "Bearer " + token.getAccessToken());
		final Representation representation = client
				.get(MediaType.APPLICATION_JSON);
		return representation.getText();
	}
}
