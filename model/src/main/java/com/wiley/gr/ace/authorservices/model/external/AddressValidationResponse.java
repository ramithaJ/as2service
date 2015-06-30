package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

public class AddressValidationResponse {

	private List<AddressValidationMultiRes> addressValidationMultiResList;

	public final List<AddressValidationMultiRes> getAddressValidationMultiResList() {
		return addressValidationMultiResList;
	}

	public final void setAddressValidationMultiResList(
			final List<AddressValidationMultiRes> addressValidationMultiResList) {
		this.addressValidationMultiResList = addressValidationMultiResList;
	}

}
