package com.wiley.gr.ace.authorservices.model.external;

public class AddressesData {
    AddressData correspondenceAddress;
    AddressData billingAddress;
    AddressData shippingAddress;
    public AddressData getCorrespondenceAddress() {
        return correspondenceAddress;
    }
    public void setCorrespondenceAddress(AddressData correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }
    public AddressData getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(AddressData billingAddress) {
        this.billingAddress = billingAddress;
    }
    public AddressData getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(AddressData shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
