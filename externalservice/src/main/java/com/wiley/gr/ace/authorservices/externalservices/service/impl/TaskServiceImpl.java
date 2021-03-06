/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import com.wiley.bpm.authentication.WileyBPMAuthenticationUtils;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.model.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.LicenseStatus;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.TaskServiceRequest;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Class BPMInterfaceServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class TaskServiceImpl implements TaskService {

    /**
     * The bpmserviceurl.
     */
    @Value("${bpmservice.url}")
    private String bpmserviceurl;

    /**
     * The key.
     */
    @Value("${bpmservice.key}")
    private String key;

    /**
     * The action.
     */
    @Value("${bpmservice.action}")
    private String action;

    /**
     * The bp id.
     */
    @Value("${bpmservice.bpdId}")
    private String bpId;

    /**
     * The process app id.
     */
    @Value("${bpmservice.processAppId}")
    private String processAppId;

    /**
     * The parts.
     */
    @Value("${bpmservice.parts}")
    private String parts;

    /**
     * The http header accept value.
     */
    @Value("${bpmservice.httpHeaderAcceptValue}")
    private String httpHeaderAcceptValue;

    /**
     * The http header content type value.
     */
    @Value("${bpmservice.httpHeaderContentTypeValue}")
    private String httpHeaderContentTypeValue;

    /**
     * The source app value.
     */
    @Value("${bpmservice.sourceAppValue}")
    private String sourceAppValue;

    /**
     * the INTERNAL_SERVER_ERROR_CODE.
     */
    @Value("${internal.server.error.code}")
    private String internalServerErrorCode;

    @Value("${bpmServiceLicense.url}")
    private String bpmServiceLicenseStatus;

    /**
     * Logger Configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(TaskServiceImpl.class);

    /**
     * Method invokes BPM service and returns the status.
     *
     * @param taskServiceRequest the task service request
     * @param userId             the user id
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
        String url = null;

        try {
            String requestString = taskServiceRequest
                    .getJsonString(taskServiceRequest);
            encodedParamString = URLEncoder.encode(requestString, "UTF-8");
            payLoadString = decodedParamString(encodedParamString);
            url = bpmserviceurl + "?" + payLoadString;
            saltString = WileyBPMAuthenticationUtils.getSalt();
        } catch (RuntimeException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException(internalServerErrorCode, e.getMessage());
        }
        currentDate = new Date();
        date = currentDate.getTime();
        generatedSignature = WileyBPMAuthenticationUtils.generateSignature(key,
                saltString, "POST", payLoadString, userId, date);

        List<Header> headers = new ArrayList<Header>();
        headers = prepareHeaders(headers, date, userId, generatedSignature, saltString);

        client = HttpClients.custom().setDefaultHeaders(headers).build();
        request = RequestBuilder.post(url).build();

        try {
            response = client.execute(request);
        } catch (ClientProtocolException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException(internalServerErrorCode, e.getMessage());
        } catch (IOException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException(internalServerErrorCode, e.getMessage());
        }
        statusCode = response.getStatusLine().getStatusCode();

        if (statusCode == 200) {
            status = AuthorServicesConstants.BPM_CALL_SUCCESS_STATUS;
        } else {
            throw new ASException(statusCode.toString(), response
                    .getStatusLine().getReasonPhrase());
        }

        return status;
    }

    /**
     * @param encodedParamString
     * @return
     */
    private String decodedParamString(String encodedParamString) {
        StringBuilder decodedParamString = new StringBuilder();

        decodedParamString.append("action=").append(action).append("&")
                .append("bpdId=").append(bpId).append("&")
                .append("processAppId=").append(processAppId).append("&")
                .append("params=").append(encodedParamString).append("&")
                .append("parts=").append(parts);
        return decodedParamString.toString();
    }

    /**
     * @param headers
     * @param date
     * @param userId
     * @param generatedSignature
     * @param saltString
     * @return
     */
    private List<Header> prepareHeaders(List<Header> headers, Long date, String userId, String generatedSignature, String saltString) {

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
        return headers;
    }

    /**
     * Finish task.
     *
     * @param associationConfirmation the association confirmation
     * @return true, if successful
     * @throws Exception the exception
     */
    @Override
    public final boolean finishTask(
            final AssociationConfirmation associationConfirmation) {
        boolean flag = false;
        final String url = "http://demo7930138.mockable.io/rest/bpm/wle/v1/task/"
                + associationConfirmation.getTaskId()
                + "55?action="
                + associationConfirmation.isAssociationConfirmed()
                + "&parts=all";
        final Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.PUT, Service.class);
        if (service != null
                && AuthorServicesConstants.BPM_CALL_SUCCESS_STATUS
                .equals(service.getStatus())) {
            flag = true;
        }

        return flag;
    }

    /**
     * Gets the license status.
     *
     * @param dhId   the dh id
     * @param userId the user id
     * @return the license status
     */
    @Override
    public LicenseStatus getLicenseStatus(String dhId, String userId) {
        return (LicenseStatus) StubInvokerUtil.invokeStub(
                bpmServiceLicenseStatus, HttpMethod.GET, LicenseStatus.class);
    }

}
