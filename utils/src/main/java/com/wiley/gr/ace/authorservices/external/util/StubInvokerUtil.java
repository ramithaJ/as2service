package com.wiley.gr.ace.authorservices.external.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.exception.ASException;

/**
 * @author SarmaKumarap
 */
public class StubInvokerUtil {
    
    /**
     * @param url
     * @param httpMethod
     * @param requestEntity
     * @param className
     * @return
     */
    
    public static Object invokeStub(String url, HttpMethod httpMethod,
            Class clazz) {
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders requestHeaders = new HttpHeaders();
            
            HttpEntity requestEntity = new HttpEntity(requestHeaders);
            ResponseEntity response = restTemplate.exchange(new URI(url),
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
    
}
