package com.wiley.gr.ace.authorservices.external.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;
import com.wiley.gr.ace.authorservices.model.external.WileyOpenAccessFunders;

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

            if (null == response) {
                return new SecurityResponse();
            }
            return response.getBody();
        } catch (URISyntaxException e) {

            throw new ASException("111", "extttttttttttttttt");

        }

    }

    /**
     * @param url
     * @param requestEntityClass
     * @param responseEntityClass
     * @return
     * @throws URISyntaxException
     * @throws RestClientException
     */
    public static <T> Object invokeJsonStub(final String url,
            final HttpMethod httpMethod, final Class<T> responseEntityClass) {

        HttpHeaders headers = new HttpHeaders();

        headers.set("JsonStub-User-Key", "a9e83397-57c3-4eab-a6de-642f9be1b0dc");
        headers.set("JsonStub-Project-Key",
                "349f8b22-1848-4017-af43-bbdb814db50a");
        try {
            HttpEntity<String> entity = new HttpEntity<String>("parameters",
                    headers);

            ResponseEntity<T> response = new RestTemplate().exchange(new URI(
                    url), httpMethod, entity, responseEntityClass);

            if (response != null) {
                return response.getBody();
            } else {
                return null;
            }
        } catch (URISyntaxException e) {

            throw new ASException("122", "unable to connect external service");

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
    public static <T> Object restGetServiceInvoker(final String url,
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

    public static void main(final String[] args) {
        WileyOpenAccessFunders wileyOpenAccessFunders = (WileyOpenAccessFunders) StubInvokerUtil
                .invokeJsonStub("http://jsonstub.com/woaFunders",
                        HttpMethod.POST, WileyOpenAccessFunders.class);
        System.out.println("wileyOpenAccessFunders obtained:::"
                + wileyOpenAccessFunders);
    }

}