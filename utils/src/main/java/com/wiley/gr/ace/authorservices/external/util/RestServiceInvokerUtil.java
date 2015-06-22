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
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;

/**
 * The Class RestServiceInvokerUtil.
 *
 * @author virtusa 
 * version 1.0
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

    // public static void main(String[] args) {
    // Login login = new Login();
    // login.setEmailId("ssaraf@wiley.com");
    // login.setPassword("Sripad1234");
    // RestServiceInvokerUtil.invokeService("http://10.201.64.81:8080/service/v1/auth/authenticate",
    // HttpMethod.POST, "Login", login);
    // }

}
