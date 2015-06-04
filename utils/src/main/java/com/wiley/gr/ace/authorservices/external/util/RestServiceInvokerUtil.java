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

import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;

/**
 * @author virtusa
 *	version 1.0
 *
 */
public class RestServiceInvokerUtil {
    
    /**
     * @param url
     * @param httpMethod
     * @param className
     * @return
     */
    public static String invokeService(String url, HttpMethod httpMethod,
            String className, Object postObject) {

        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders requestHeaders = new HttpHeaders();
            ResponseEntity response = null;
            if (className.equals("Login")) {
                requestHeaders.setContentType(MediaType.APPLICATION_JSON);
                JSONObject jsonObject = new JSONObject();
                Login loginData = (Login)postObject;
                jsonObject.put("userId", loginData.getEmailId());
                jsonObject.put("password", loginData.getPassword());
                jsonObject.put("authenticationType", "AD");
                jsonObject.put("appKey", "AS");
                System.out.println("jsonObject:::"+jsonObject);
                //HttpEntity requestEntity = new HttpEntity<JSONObject>(requestHeaders);
                response = restTemplate.postForEntity(url, jsonObject, SecurityResponse.class);
                System.out.println("Response Header:::"+response.getHeaders().getFirst("X-AS2-AUTH-TOKEN"));

            }

            if (response != null) {
                return response.getHeaders().getFirst("X-AS2-AUTH-TOKEN");
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new ASException();

        }

    }
    
//    public static void main(String[] args) {
//        Login login = new Login();
//        login.setEmailId("ssaraf@wiley.com");
//        login.setPassword("Sripad1234");
//        RestServiceInvokerUtil.invokeService("http://10.201.64.81:8080/service/v1/auth/authenticate", HttpMethod.POST, "Login", login);
//    }

}
