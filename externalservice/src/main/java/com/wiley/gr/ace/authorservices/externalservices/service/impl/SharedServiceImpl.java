/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class SharedServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class SharedServiceImpl implements SharedService {

	@Value("${authenticateAdminUser.url}")
	private String authorLookupUrl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wiley.gr.ace.authorservices.externalservices.service.SharedService
	 * #authorLookup(java.lang.String, java.lang.String, java.lang.String)
	 */
	public final Service authorLookup(String firstName, String lastName,
			String email) throws Exception {
		return (Service) StubInvokerUtil.invokeStub(authorLookupUrl, HttpMethod.GET, Service.class);

	}

}
