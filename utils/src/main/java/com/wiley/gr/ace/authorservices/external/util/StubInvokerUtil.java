package com.wiley.gr.ace.authorservices.external.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.CDMAffiliation;

/**
 * @author SarmaKumarap
 *
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
			String className) {

		URI uri = null;
		try {
			uri = new URI(url);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpEntity requestEntity = null;
			ResponseEntity response = null;
			if (className.equals("Service")) {

				requestEntity = new HttpEntity<Service>(requestHeaders);
				response = restTemplate.exchange(uri, httpMethod,
						requestEntity, Service.class);

			} else if (className.equals("CDMAffiliation")) {
				requestEntity = new HttpEntity<CDMAffiliation>(requestHeaders);
				response = restTemplate.exchange(uri, httpMethod,
						requestEntity, CDMAffiliation.class);

			}
			
			if(response != null) {
				
				return response.getBody();
			} else {
				return null;
			}

		} catch (URISyntaxException e) {

			throw new ASException();

		}

	}

}
