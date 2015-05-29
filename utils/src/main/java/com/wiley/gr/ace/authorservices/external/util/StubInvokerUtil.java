package com.wiley.gr.ace.authorservices.external.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Department;
import com.wiley.gr.ace.authorservices.model.DropDown;
import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.CDMAffiliation;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.model.external.LookUpProfile;

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

			} else if (className.equals("LookUpProfile")) {
				requestEntity = new HttpEntity<LookUpProfile>(requestHeaders);
				response = restTemplate.exchange(uri, httpMethod,
						requestEntity, LookUpProfile.class);

			} else if (className.equals("AreaOfInterests")) {
				requestEntity = new HttpEntity<ESBResponse>(requestHeaders);
				response = restTemplate.exchange(uri, httpMethod,
						requestEntity, ESBResponse.class);
			} else if (className.equals("JobCategory")) {
                requestEntity = new HttpEntity<JobCategories>(requestHeaders);
                response = restTemplate.exchange(uri, httpMethod,
                        requestEntity, JobCategories.class);
            }  else if (className.equals("Industry")) {
                requestEntity = new HttpEntity<Industries>(requestHeaders);
                response = restTemplate.exchange(uri, httpMethod,
                        requestEntity, Industries.class);
            }else if (className.equals("ESBResponse")) {
				requestEntity = new HttpEntity<ESBResponse>(requestHeaders);
				response = restTemplate.exchange(uri, httpMethod,
						requestEntity, ESBResponse.class);
            }
            else if (className.equals("DropDown")) {
				requestEntity = new HttpEntity<DropDown>(requestHeaders);
				response = restTemplate.exchange(uri, httpMethod,
						requestEntity, DropDown.class);
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
