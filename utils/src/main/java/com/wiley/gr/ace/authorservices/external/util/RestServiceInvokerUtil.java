package com.wiley.gr.ace.authorservices.external.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;

/**
 * The Class StubInvokerUtil.
 *
 * @author virtusa version 1.0
 */
public class RestServiceInvokerUtil {

    /**
     * Invoke stub.
     *
     * @param <T>
     *            the generic type
     * @param url
     *            the url
     * @param httpMethod
     *            the http method
     * @param clazz
     *            the clazz
     * @return Object
     */
    public static <T> Object invokeStub(final String url,
            final HttpMethod httpMethod, final Class<T> clazz) {

        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> requestEntity = new HttpEntity<T>(requestHeaders);
            ResponseEntity<T> response = new RestTemplate().exchange(new URI(
                    url), httpMethod, requestEntity, clazz);

            if (response != null) {
                return response.getBody();
            } else {
                return null;
            }
        } catch (URISyntaxException e) {

            throw new ASException();

        }

    }

    /**
     * Rest service invoker.
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
            return response.getBody();
        } catch (Exception e) {

            if (AuthorServicesConstants.UNAUTHORIZEDMSG.equalsIgnoreCase(e
                    .getMessage())) {
                throw new ASException(AuthorServicesConstants.UNAUTHORIZEDCODE,
                        e.getMessage());
            }
            if (AuthorServicesConstants.LOCKEDMSG.equalsIgnoreCase(e
                    .getMessage())) {
                throw new ASException(AuthorServicesConstants.LOCKEDCODE,
                        e.getMessage());
            }
            throw new ASException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);

        }

    }

    /**
     * Put service data.
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

        } catch (URISyntaxException e) {
            throw new ASException();
        }
    }

    /**
     * Delete service data.
     *
     * @param url
     *            the url
     */
    public static void deleteServiceData(final String url) {

        try {
            new RestTemplate().delete(new URI(url));

        } catch (URISyntaxException e) {
            throw new ASException();
        }
    }

    /**
     * Rest get service invoker.
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
            if (null == response) {
                return new SecurityResponse();
            }
            return response.getBody();
        } catch (URISyntaxException e) {
            throw new ASException();
        }
    }

    public static <T> Object pickListInvoker(final String url,
            final Class<T> responseEntityClass) {

        StringBuffer responseString = new StringBuffer();
        ESBResponse esbResponse = null;
        try {

            URL urls = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output;

            while ((output = br.readLine()) != null) {
                responseString.append(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        JSONObject responseJSON = new JSONObject(responseString.toString());
        ObjectMapper mapper = new ObjectMapper();
       
        try {
            esbResponse = mapper.readValue(responseJSON.toString(), ESBResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return esbResponse;

    }

}
