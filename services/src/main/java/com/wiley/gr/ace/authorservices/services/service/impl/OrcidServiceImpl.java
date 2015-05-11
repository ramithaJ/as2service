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
package com.wiley.gr.ace.authorservices.services.service.impl;

import org.restlet.Context;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Reference;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken;
import com.wiley.gr.ace.authorservices.services.service.OrcidService;

/**
 * @author vkumark
 *
 */
public class OrcidServiceImpl implements OrcidService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wiley.gr.ace.authorservices.services.service.OrcidService#getAccessToken
	 * (java.lang.String)
	 */
	@Override
	public OrcidAccessToken getAccessToken(String authorizationCode)
			throws Exception {

		OrcidAccessToken accessToken = null;
		Reference ref = new Reference("http://pub.orcid.org/oauth/token");
		if (Context.getCurrent() == null) {
			Context.setCurrent(new Context());
		}
		ClientResource client = new ClientResource(ref);
		/**
		 * TODO : Need to fetch this values from prop files depending on environment
		 */
		Form form = new Form();
		form.add("client_id", "APP-7E4BRADG8DTVCY64");
		form.add("client_secret", "3408b30c-bbdc-4f45-963d-294f7a7bc0b1");
		form.add("grant_type", "authorization_code");
		form.add("code", authorizationCode);
		form.add("redirect_uri", "http://www.vinay.com:8080/orcid/index.jsp");

		client.getContext().getParameters().add("followRedirects", "true");
		System.out.println("form.toString() ##### " + form.toString());
		System.out.println("client.toString() ##### " + client.toString());

		Representation rep = client.post(form, MediaType.APPLICATION_JSON);
		String json = rep.getText();
		System.out.println("json ##### " + json);
		ObjectMapper objectMapper = new ObjectMapper();
		accessToken = objectMapper.readValue(json, OrcidAccessToken.class);
		return accessToken;
	}

}
