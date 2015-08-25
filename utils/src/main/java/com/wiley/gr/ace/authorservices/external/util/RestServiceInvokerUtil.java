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

package com.wiley.gr.ace.authorservices.external.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.json.simple.JSONObject;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;

/**
 * The Class RestServiceInvokerUtil.
 *
 * @author virtusa version 1.0
 */
public class RestServiceInvokerUtil {

    /**
     * Invoke service.
     *
     * @param url
     *            the url
     * @param httpMethod
     *            the http method
     * @param className
     *            the class name
     * @param postObject
     *            the post object
     * @return the string
     * @throws URISyntaxException 
     * @throws RestClientException 
     */
    @SuppressWarnings("unchecked")
	public static String invokeService(final String url,
            final HttpMethod httpMethod, final String className,
            final Object postObject) throws ASException, RestClientException, URISyntaxException {

        
        RestTemplate restTemplate = new RestTemplate();
        
        ResponseEntity<SecurityResponse> response = null;
        if (className.equals("Login")) {               
            JSONObject jsonObject = new JSONObject();
            Login loginData = (Login) postObject;
            jsonObject.put("userId", loginData.getEmailId());
            jsonObject.put("password", loginData.getPassword());
            jsonObject.put("authenticationType", "AD");
            jsonObject.put("appKey", "AS");         
        
            response = restTemplate.postForEntity(new URI(url), jsonObject,
                    SecurityResponse.class);
            System.err.println(response.getBody().getStatus());
        }

        if (response != null) {
            if("FAILURE".equalsIgnoreCase(response.getBody().getStatus())){
                throw new ASException(AuthorServicesConstants.INVALIDEMAILCODE, AuthorServicesConstants.INVALIDEMAILMSG);
            }else{
                return response.getHeaders().getFirst("X-AS2-AUTH-TOKEN");
            }
            
        } else {
            return null;
        }

    }

    /**
     * Method to call external GET service calls.
     *
     * @param <T>
     *            the generic type
     * @param url
     *            the url
     * @param responseEntityClass
     *            the response entity class
     * @return the object
     */
    public static <T> Object getServiceData(final String url,
            final Class<T> responseEntityClass) {

        try {
            ResponseEntity<T> response = new RestTemplate().getForEntity(
                    new URI(url), responseEntityClass);
            return response.getBody();
        } catch (URISyntaxException e) {
            throw new UserException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);
        }
    }
    
    /**
     * Method to call external POST service calls.
     *
     * @param <T>
     *            the generic type
     * @param url
     *            the url
     * @param requestEntityClass
     *            the request entity class
     * @param responseEntityClass
     *            the response entity class
     * @return Object
     */
    public static <T> Object restServiceInvoker(final String url,
            final Object requestEntityClass, final Class<T> responseEntityClass) {

        try {
            ResponseEntity<T> response = new RestTemplate().postForEntity(
                    new URI(url), requestEntityClass, responseEntityClass);
            if (StringUtils.isEmpty(response)) {
                throw new UserException(
                        AuthorServicesConstants.NODATAFOUNDCODE,
                        AuthorServicesConstants.NODATAFOUNDMSG);
            }
            return response.getBody();

        } catch (Exception e) {
            final String message = e.getMessage();
            if (AuthorServicesConstants.UNAUTHORIZEDMSG
                    .equalsIgnoreCase(message)) {
                throw new UserException(
                        AuthorServicesConstants.UNAUTHORIZEDCODE, message);
            }
            if (AuthorServicesConstants.LOCKEDMSG.equalsIgnoreCase(e
                    .getMessage())) {
                throw new UserException(AuthorServicesConstants.LOCKEDCODE,
                        message);
            }
            throw new UserException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);

        }

    }

}
