package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.ValidationService;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationResponse;
import com.wiley.gr.ace.authorservices.model.external.VatIdValidationResponse;

public class ValidationServiceImpl implements ValidationService {

	@Value("$addressdoctor.url")
	String addressDoctorUrl;

	@Override
	public boolean validateAddress(
			AddressValidationRequest addressValidationRequest) {
		boolean isValid = false;
		ObjectWriter ow = new ObjectMapper().writer()
				.withDefaultPrettyPrinter();
		try {
			String addressRequestJson = ow
					.writeValueAsString(addressValidationRequest);
			String addressValidationUrl = addressDoctorUrl + addressRequestJson;
			AddressValidationResponse addressValidationResponse = (AddressValidationResponse) StubInvokerUtil
					.restGetServiceInvoker(addressValidationUrl,
							AddressValidationResponse.class);

			if (StringUtils.isEmpty(addressValidationResponse)) {
				isValid = true;
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return isValid;
	}

	@Override
	public boolean vatValidation(String countriCode, String taxVatRegNum) {
		boolean isValid = false;
		String vatUrl = "http://vmesbdev.wiley.com:8091/VATIDVALIDATION?"
				+ "countryCode=" + countriCode + "&taxRegistrationNumber="
				+ taxVatRegNum;

		VatIdValidationResponse vatIdValidationResponse = (VatIdValidationResponse) StubInvokerUtil
				.restGetServiceInvoker(vatUrl, VatIdValidationResponse.class);
		if ("true".equalsIgnoreCase(vatIdValidationResponse.getIsValid())) {
			isValid = false;
		}
		return isValid;
	}
}
