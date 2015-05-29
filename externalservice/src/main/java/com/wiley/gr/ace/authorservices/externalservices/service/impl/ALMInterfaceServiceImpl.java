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

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.model.PasswordDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.SecuirtyQuestionDetails;

/**
 * @author RAVISINHA
 */
public class ALMInterfaceServiceImpl implements ALMInterfaceService {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.services.admin.external.ALMInterfaceService
     * #authenticateUser(java.lang.String, java.lang.String)
     */
    @Override
    public boolean authenticateAdminUser(String emailId) {

        // TODO: Authenticate with LDAP
        final String url = "http://demo6003007.mockable.io/admin/login";
        Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.POST, "Service");
        String status = service.getStatus();

        if (status != null && status.equalsIgnoreCase("success")) {

            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService
     * #authenticateUserALM(java.lang.String, java.lang.String)
     */
    @Override
    public boolean authenticateUserALM(String emailId, String password) {

        /*
         * final String url = "http://demo6003007.mockable.io/user/login";
         * Service service = (Service) StubInvokerUtil.invokeStub(url,
         * HttpMethod.POST, "Service"); String status = service.getStatus(); if
         * (status != null && status.equalsIgnoreCase("success")) { return true;
         * } return false;
         */

        if (password.equalsIgnoreCase("Password")) {
            return true;
        } else {
            return false;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService
     * #resetPassword(java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public boolean resetPassword(SecurityDetailsHolder securityDetailsHolder) {

        final String url = "http://demo6003007.mockable.io/user/resetPassword";
        Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.POST, "Service");
        String status = service.getStatus();

        if (status != null && status.equalsIgnoreCase("success")) {

            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService
     * #updateUserId(java.lang.String, java.lang.String)
     */
    @Override
    public boolean updateUserId(String oldEmailId, String newEmailId) {

        final String url = "http://demo6374909.mockable.io/user/updateUserId";
        Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.POST, "Service");
        String status = service.getStatus();

        if (status != null && status.equalsIgnoreCase("success")) {

            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService
     * #forceFulReset(java.lang.String, java.lang.String)
     */
    @Override
    public boolean forceFulReset(String emailId, String newPassword) {

        final String url = "http://demo6374909.mockable.io/user/forceFulReset";
        Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.POST, "Service");
        String status = service.getStatus();

        if (status != null && status.equalsIgnoreCase("success")) {

            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService
     * #lockUser(java.lang.String)
     */
    @Override
    public boolean lockUser(String emailId) {

        final String url = "http://vmesbdev.wiley.com:15200/ALMService/LockUser";
        Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.POST, "Service");
        String status = service.getStatus();

        if (status != null && status.equalsIgnoreCase("success")) {

            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService
     * #unLockUser(java.lang.String)
     */
    @Override
    public boolean unLockUser(String emailId) {

        final String url = "http://demo6374909.mockable.io/user/unLockUser";
        Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.POST, "Service");
        String status = service.getStatus();

        if (status != null && status.equalsIgnoreCase("success")) {

            return true;
        }
        return false;
    }

    @Override
    public SecurityDetailsHolder getSecurityDetails(String emailId) {

        final String url = "http://demo7930138.mockable.io/user/getSecurityDetails";
        URI uri = null;
        try {

            uri = new URI(url);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders requestHeaders = new HttpHeaders();
            HttpEntity<SecurityDetailsHolder> requestEntity = new HttpEntity<SecurityDetailsHolder>(
                    requestHeaders);
            ResponseEntity<SecurityDetailsHolder> response = restTemplate
                    .exchange(uri, HttpMethod.GET, requestEntity,
                            SecurityDetailsHolder.class);
            return response.getBody();

        } catch (URISyntaxException e) {

            throw new ASException();
        }
    }

    @Override
    public SecurityDetailsHolder getSecurityQuestions(String emailId) {

        final String url = "http://demo6374909.mockable.io/user/securityQuestions";
        URI uri = null;
        try {

            uri = new URI(url);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders requestHeaders = new HttpHeaders();
            HttpEntity<SecurityDetailsHolder> requestEntity = new HttpEntity<SecurityDetailsHolder>(
                    requestHeaders);
            ResponseEntity<SecurityDetailsHolder> response = restTemplate
                    .exchange(uri, HttpMethod.GET, requestEntity,
                            SecurityDetailsHolder.class);
            return response.getBody();

        } catch (URISyntaxException e) {

            throw new ASException();
        }
    }

    @Override
    public boolean updatePassword(PasswordDetails passwordDetails) {

        final String url = "http://demo6374909.mockable.io/user/updatePassword";
        Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.POST, "Service");
        String status = service.getStatus();

        if (status != null && status.equalsIgnoreCase("success")) {

            return true;
        }
        return false;
    }

    @Override
    public boolean updateSecurityDetails(SecurityDetailsHolder securityDetails) {

        final String url = "http://demo6374909.mockable.io/user/updateSecurityDetails";
        Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.POST, "Service");
        String status = service.getStatus();

        if (status != null && status.equalsIgnoreCase("success")) {

            return true;
        }
        return false;
    }

    @Override
    public SecuirtyQuestionDetails getSecurityQuestionDetails(String emailId) {
        final String url = "http://demo7930138.mockable.io/ALMService/RetrieveSecQuestions?Email=email";
        URI uri = null;
        try {

            uri = new URI(url);
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders requestHeaders = new HttpHeaders();
            HttpEntity<SecuirtyQuestionDetails> requestEntity = new HttpEntity<SecuirtyQuestionDetails>(
                    requestHeaders);
            ResponseEntity<SecuirtyQuestionDetails> response = restTemplate
                    .exchange(uri, HttpMethod.GET, requestEntity,
                            SecuirtyQuestionDetails.class);
            return response.getBody();
        } catch (URISyntaxException e) {

            throw new ASException();
        }
    }
}