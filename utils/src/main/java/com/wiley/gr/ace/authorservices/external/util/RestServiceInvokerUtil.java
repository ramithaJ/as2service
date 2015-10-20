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

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;

/**
 * The Class RestServiceInvokerUtil.
 *
 * @author virtusa version 1.0
 */
public class RestServiceInvokerUtil {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(RestServiceInvokerUtil.class);

    private RestServiceInvokerUtil() {

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

        LOGGER.info("Calling service:::");
        try {
            final ResponseEntity<T> response = new RestTemplate().getForEntity(
                    new URI(url), responseEntityClass);
            return response.getBody();
        } catch (final URISyntaxException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
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
            final ResponseEntity<T> response = new RestTemplate()
                    .postForEntity(new URI(url), requestEntityClass,
                            responseEntityClass);
            if (StringUtils.isEmpty(response)) {
                throw new UserException(
                        AuthorServicesConstants.NODATAFOUNDCODE,
                        AuthorServicesConstants.NODATAFOUNDMSG);
            }
            return response.getBody();

        } catch (final Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
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

    /**
     * Method to call external PUT service calls.
     *
     * @param url
     *            the url
     * @param requestEntity
     *            the request entity
     */
    public static void putServiceData(final String url,
            final Object requestEntity) {

        try {
            new RestTemplate().put(new URI(url), requestEntity);

        } catch (final URISyntaxException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);
        }
    }

    /**
     * Method to call external DELETE service calls.
     *
     * @param url
     *            the url
     */
    public static void deleteServiceData(final String url) {

        try {
            new RestTemplate().delete(new URI(url));

        } catch (final URISyntaxException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);
        }
    }

    /**
     * @param url
     *            the request value.
     * @param responseEntityClass
     *            the request value.
     * @return object
     */
    public static <T> Object pickListInvoker(final String url,
            final Class<T> responseEntityClass) {

        StringBuilder responseString = null;
        ESBResponse esbResponse = null;
        try {

            final URL urls = new URL(url);
            final HttpURLConnection conn = (HttpURLConnection) urls
                    .openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            final Integer responseCode = 200;
            final Integer code = conn.getResponseCode();
            if (code.intValue() != responseCode) {
                throw new UserException("Failed : HTTP error code : ",
                        String.valueOf(code));
            }

            final BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String output = null;

            while ((output = bufferedReader.readLine()) != null) {
                responseString = new StringBuilder();
                responseString.append(output);
            }
            bufferedReader.close();
            conn.disconnect();

        } catch (final MalformedURLException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(
                    AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                    e.getMessage());

        } catch (final IOException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(
                    AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                    e.getMessage());

        }
        final JSONObject responseJSON = new JSONObject(
                responseString.toString());
        final ObjectMapper mapper = new ObjectMapper();

        try {
            esbResponse = mapper.readValue(responseJSON.toString(),
                    ESBResponse.class);
        } catch (final IOException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException(
                    AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                    e.getMessage());
        }
        return esbResponse;

    }

    /**
     * Deleteparticipant service data.
     *
     * @param url
     *            the url
     * @param requestEntityClass
     *            the request entity class
     */
    public static void deleteparticipantServiceData(final String url,
            final Object requestEntityClass) {
        final ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("c:\\ravi\\user.json"),
                    requestEntityClass);

        } catch (final Exception e) {

            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
        }

        new RestTemplate().delete(url, requestEntityClass);
    }
}