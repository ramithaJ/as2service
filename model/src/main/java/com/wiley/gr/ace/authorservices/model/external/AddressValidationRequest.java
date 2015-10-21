package com.wiley.gr.ace.authorservices.model.external;

/**
 * 
 * @author virtusa
 * @version 1.0
 */
public class AddressValidationRequest {

    /** The address validation multi req. */
    private AddressValidationMultiReq addressValidationMultiReq;

    /**
     * @return the addressValidationMultiReq
     */
    public AddressValidationMultiReq getAddressValidationMultiReq() {
        return addressValidationMultiReq;
    }

    /**
     * @param addressValidationMultiReq
     *            the addressValidationMultiReq to set
     */
    public void setAddressValidationMultiReq(
            AddressValidationMultiReq addressValidationMultiReq) {
        this.addressValidationMultiReq = addressValidationMultiReq;
    }

}
