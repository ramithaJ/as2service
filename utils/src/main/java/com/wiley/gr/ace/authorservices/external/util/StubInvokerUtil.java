package com.wiley.gr.ace.authorservices.external.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.DropDown;

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
    
    public static void main(String[] args) {
        StubInvokerUtil.invokeStub("http://demo6003007.mockable.io/asdata/institutions", HttpMethod.GET, DropDown.class);
    }
    
}
