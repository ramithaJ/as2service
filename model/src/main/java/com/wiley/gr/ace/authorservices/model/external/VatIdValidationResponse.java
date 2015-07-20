package com.wiley.gr.ace.authorservices.model.external;

public class VatIdValidationResponse {

	private String errorMessage;
	private String isValid;

	public final String getErrorMessage() {
		return errorMessage;
	}

	public final void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public final String getIsValid() {
		return isValid;
	}

	public final void setIsValid(String isValid) {
		this.isValid = isValid;
	}

}
