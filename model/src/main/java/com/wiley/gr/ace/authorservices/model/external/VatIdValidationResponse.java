package com.wiley.gr.ace.authorservices.model.external;

/**
 * 
 * @author virtusa
 * @version 1.0
 */
public class VatIdValidationResponse {

    /** The error message. */
    private String errorMessage;

    /** The is valid. */
    private String isValid;

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage
     *            the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the isValid
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * @param isValid
     *            the isValid to set
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

}
