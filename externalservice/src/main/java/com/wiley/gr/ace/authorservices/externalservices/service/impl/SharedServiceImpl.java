/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.AssociationConfirmation;

/**
 * @author yugandhark
 *
 */
public class SharedServiceImpl implements SharedService {

	@Override
	public boolean associationConfirmation(
			AssociationConfirmation associationConfirmation) throws Exception {
		final String url = "http://demo7930138.mockable.io/article/associationconfirmation";
		Service service = (Service) StubInvokerUtil.invokeStub(url,
				HttpMethod.PUT, Service.class);
		String status = service.getStatus();
		if (status != null && status.equalsIgnoreCase("SUCCESS")) {
			return true;
		}
		return false;
	}
}
