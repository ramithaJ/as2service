package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;

public interface ValidationService {

	boolean validateAddress(AddressValidationRequest addressValidationRequest) throws Exception;
}
