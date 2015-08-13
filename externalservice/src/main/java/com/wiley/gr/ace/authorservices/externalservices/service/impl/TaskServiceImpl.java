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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.bpm.authentication.WileyBPMAuthenticationUtils;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.model.external.TaskServiceRequest;

/**
 * The Class BPMInterfaceServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class TaskServiceImpl implements TaskService {

    /** The bpmserviceurl. */
    @Value("${bpmservice.url}")
    private String bpmserviceurl;

    /** The key. */
    @Value("${bpmservice.key}")
    private String key;

    /** The action. */
    @Value("${bpmservice.action}")
    private String action;

    /** The bp id. */
    @Value("${bpmservice.bpdId}")
    private String bpId;

    /** The process app id. */
    @Value("${bpmservice.processAppId}")
    private String processAppId;

    /** The parts. */
    @Value("${bpmservice.parts}")
    private String parts;

    /** The http header accept value. */
    @Value("${bpmservice.httpHeaderAcceptValue}")
    private String httpHeaderAcceptValue;

    /** The http header content type value. */
    @Value("${bpmservice.httpHeaderContentTypeValue}")
    private String httpHeaderContentTypeValue;

    /** The source app value. */
    @Value("${bpmservice.sourceAppValue}")
    private String sourceAppValue;

    /** the INTERNAL_SERVER_ERROR_CODE. */
    @Value("${internal.server.error.code}")
    private String INTERNAL_SERVER_ERROR_CODE;

    /**
     * Method invokes BPM service and returns the status.
     *
     * @param taskServiceRequest
     *            the task service request
     * @param userId
     *            the user id
     * @return status
     */
    @Override
    public final String invokeTaskService(
            final TaskServiceRequest taskServiceRequest, final String userId) {

        String saltString = null;
        String encodedParamString = null;
        Date currentDate = null;
        Long date = null;
        String generatedSignature = null;
        Integer statusCode = null;
        String status = null;
        String payLoadString = null;

        HttpClient client = null;
        HttpUriRequest request = null;
        HttpResponse response = null;

        try {
            String requestString = taskServiceRequest
                    .getJsonString(taskServiceRequest);
            encodedParamString = URLEncoder.encode(requestString, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            throw new ASException(INTERNAL_SERVER_ERROR_CODE, e.getMessage());
        }

        StringBuilder decodedParamString = new StringBuilder();

        decodedParamString.append("action=").append(action).append("&")
                .append("bpdId=").append(bpId).append("&")
                .append("processAppId=").append(processAppId).append("&")
                .append("params=").append(encodedParamString).append("&")
                .append("parts=").append(parts);

        payLoadString = decodedParamString.toString();

        String url = bpmserviceurl + "?" + payLoadString;

        saltString = WileyBPMAuthenticationUtils.getSalt();

        currentDate = new Date();
        date = currentDate.getTime();
        generatedSignature = WileyBPMAuthenticationUtils.generateSignature(key,
                saltString, "POST", payLoadString, userId, date);

        List<Header> headers = new ArrayList<Header>();
        headers.add(new BasicHeader(HttpHeaders.ACCEPT, httpHeaderAcceptValue));
        headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE,
                httpHeaderContentTypeValue));
        headers.add(new BasicHeader(AuthorServicesConstants.BPM_SOURCE_APP,
                sourceAppValue));
        headers.add(new BasicHeader(AuthorServicesConstants.BPM_LONG_DATE, date
                .toString()));
        headers.add(new BasicHeader(AuthorServicesConstants.BPM_USERID, userId));
        headers.add(new BasicHeader(AuthorServicesConstants.BPM_SIGNATURE,
                generatedSignature));
        headers.add(new BasicHeader(AuthorServicesConstants.BPM_SALT,
                saltString));

        client = HttpClients.custom().setDefaultHeaders(headers).build();
        request = RequestBuilder.post(url).build();

        try {
            response = client.execute(request);
        } catch (ClientProtocolException e) {
            throw new ASException(INTERNAL_SERVER_ERROR_CODE, e.getMessage());
        } catch (IOException e) {
            throw new ASException(INTERNAL_SERVER_ERROR_CODE, e.getMessage());
        }
        statusCode = response.getStatusLine().getStatusCode();

        if (statusCode == Integer.parseInt(AuthorServicesConstants.STATUS_CODE_OK)) {
            status = AuthorServicesConstants.BPM_CALL_SUCCESS_STATUS;
        } else {
            throw new ASException(statusCode.toString(), response
                    .getStatusLine().getReasonPhrase());
        }

        return status;
    }

    /**
     * for creating task of bpm.
     *
     * @return true, if successful
     */
    @Override
    public final boolean createTask() {
        return false;
    }

}
