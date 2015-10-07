package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;

public class AddressValidationResponse {

    private ArrayList<AddressValidationMultiRes> addressValidationMultiResList;

    public final ArrayList<AddressValidationMultiRes> getAddressValidationMultiResList() {
        return addressValidationMultiResList;
    }

    public final void setAddressValidationMultiResList(
            final ArrayList<AddressValidationMultiRes> addressValidationMultiResList) {
        this.addressValidationMultiResList = addressValidationMultiResList;
    }

}
