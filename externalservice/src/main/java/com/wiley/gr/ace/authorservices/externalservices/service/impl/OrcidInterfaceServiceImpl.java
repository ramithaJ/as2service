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

import org.restlet.Context;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Reference;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.externalservices.service.OrcidInterfaceService;
import com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken;

/**
 * @author vkumark
 */
public class OrcidInterfaceServiceImpl implements OrcidInterfaceService {
    
    /*
     * (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * OrcidInterfaceService#getAccessToken(java.lang.String)
     */
    @Override
    public OrcidAccessToken getAccessToken(String authorizationCode)
            throws Exception {
        OrcidAccessToken accessToken = null;
        Reference ref = new Reference(
                "http://api.sandbox.orcid.org/oauth/token");
        if (Context.getCurrent() == null) {
            Context.setCurrent(new Context());
        }
        ClientResource client = new ClientResource(ref);
        /**
         * TODO : Need to fetch this values from prop files depending on
         * environment
         */
        Form form = new Form();
        form.add("client_id", "APP-EU26CF7K2HTG34SV");
        form.add("client_secret", "6cb4c4d8-0e0b-41a3-a086-f3b3029d5d89");
        form.add("grant_type", "authorization_code");
        form.add("code", authorizationCode);
        /**
         * Need to change this to UI redirect URI
         */
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
    
    /*
     * (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.externalservices.service.
     * OrcidInterfaceService
     * #getBio(com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken)
     */
    @Override
    public String getBio(OrcidAccessToken token) throws Exception {
        
        Reference ref = new Reference("http://sandbox.orcid.org" + "/"
                + token.getOrcid() + "/orcid-bio");
        ClientResource client = new ClientResource(ref);
        Form headers = (Form) client.getRequestAttributes().get(
                "org.restlet.http.headers");
        if (headers == null) {
            headers = new Form();
            client.getRequestAttributes().put("org.restlet.http.headers",
                    headers);
        }
        headers.add("Authorization", "Bearer " + token.getAccess_token());
        Representation representation = client.get(MediaType.APPLICATION_JSON);
        String orcidMessageJSON = representation.getText();
        System.out.println("json ##### " + orcidMessageJSON);
        return orcidMessageJSON;
    }
    
}
