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
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;

/**
 * The Class StubInvokerUtil.
 *
 * @author virtusa version 1.0
 */
public class RestServiceInvokerUtil {

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

        } catch (URISyntaxException e) {
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

        } catch (URISyntaxException e) {
            throw new UserException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);
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
            if (StringUtils.isEmpty(response)) {
                throw new UserException(
                        AuthorServicesConstants.NODATAFOUNDCODE,
                        AuthorServicesConstants.NODATAFOUNDMSG);
            }
            return response.getBody();
        } catch (URISyntaxException e) {
            throw new UserException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);
        }
    }

    /**
     * @param url
     *            the url
     * @param responseEntityClass
     *            the responseEntity class
     * @return object
     */
    public static <T> Object pickListInvoker(final String url,
            final Class<T> responseEntityClass) {

        StringBuffer responseString = null;
        ESBResponse esbResponse = null;
        try {

            URL urls = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urls.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            final Integer responseCode = 200;
            Integer code = conn.getResponseCode();
            if (code.intValue() != responseCode) {
                throw new RuntimeException("Failed : HTTP error code : " + code);
            }

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String output = null;

            while ((output = bufferedReader.readLine()) != null) {
                responseString = new StringBuffer();
                responseString.append(output);
            }
            bufferedReader.close();
            conn.disconnect();

        } catch (MalformedURLException e) {

            throw new UserException(
                    AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                    e.getMessage());

        } catch (IOException e) {

            throw new UserException(
                    AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                    e.getMessage());

        }
        JSONObject responseJSON = new JSONObject(responseString.toString());
        ObjectMapper mapper = new ObjectMapper();

        try {
            esbResponse = mapper.readValue(responseJSON.toString(),
                    ESBResponse.class);
        } catch (IOException e) {
            throw new UserException(
                    AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                    e.getMessage());
        }
        return esbResponse;

    }

}
