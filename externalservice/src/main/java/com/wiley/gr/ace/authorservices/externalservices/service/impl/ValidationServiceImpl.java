package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ValidationService;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationResponse;

public class ValidationServiceImpl implements ValidationService {

	@Value("$addressdoctor.url")
	String addressDoctorUrl;

	@Override
	public boolean validateAddress(
			AddressValidationRequest addressValidationRequest) throws Exception {
		boolean isValid = false;
		AddressValidationResponse addressValidationResponse = (AddressValidationResponse) StubInvokerUtil
				.restServiceInvoker(addressDoctorUrl, addressValidationRequest,
						AddressValidationResponse.class);

		if (StringUtils.isEmpty(addressValidationResponse)) {
			isValid = true;
		}
		return isValid;
	}

}
