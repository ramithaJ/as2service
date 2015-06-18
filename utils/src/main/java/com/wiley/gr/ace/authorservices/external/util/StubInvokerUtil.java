package com.wiley.gr.ace.authorservices.external.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;

/**
 * The Class StubInvokerUtil.
 *
 * @author virtusa version 1.0
 */
public class StubInvokerUtil {

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
            final HttpMethod httpMethod, Class<T> clazz) {
        
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
            Object requestEntityClass, Class<T> responseEntityClass) {

        try {     
            ResponseEntity<T> response = new RestTemplate().postForEntity(
                    new URI(url), requestEntityClass, responseEntityClass);

            if (null == response) {
                throw new ASException(AuthorServicesConstants.SERVERERRORCODE, AuthorServicesConstants.SERVERERRORMESSAGE);
            }
            return response.getBody();
        } catch (Exception e) {

            throw new ASException(AuthorServicesConstants.SERVERERRORCODE, AuthorServicesConstants.SERVERERRORMESSAGE);

        }

    }

}