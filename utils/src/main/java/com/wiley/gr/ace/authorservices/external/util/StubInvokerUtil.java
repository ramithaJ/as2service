package com.wiley.gr.ace.authorservices.external.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.external.SecurityResponse;

/**
 * @author virtusa
 *	version 1.0
 */
public class StubInvokerUtil {
    
    /**
     * @param url
     * @param httpMethod
     * @param clazz
     * @return Object
     */
    public static <T> Object invokeStub(String url, HttpMethod httpMethod,
            Class<T> clazz) {
        
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<T> requestEntity = new HttpEntity<T>(requestHeaders);
            ResponseEntity<T> response = new RestTemplate().exchange(new URI(url),
                    httpMethod, requestEntity, clazz);
            
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
     * @param url
     * @param requestEntityClass
     * @param responseEntityClass
     * @return Object
     */
    public static <T> Object restServiceInvoker(String url,
            Object requestEntityClass, Class<T> responseEntityClass) {
        
        try {
            HttpHeaders requestHeaders = new HttpHeaders();
            requestHeaders.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<T> response = new RestTemplate().postForEntity(new URI(url), requestEntityClass, responseEntityClass);
            
            if(null == response){
                return new SecurityResponse();
            }
            return response.getBody();
        } catch (URISyntaxException e) {
            
            throw new ASException();
            
        }
        
    }
    
}