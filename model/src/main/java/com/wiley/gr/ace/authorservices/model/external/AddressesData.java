package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author virtusa version 1.0
 *
 */
@JsonInclude(Include.NON_NULL)
public class AddressesData {

    /**
     * This field holds the value of correspondenceAddress
     */
    AddressData correspondenceAddress;
    /**
     * This field holds the value of billingAddress
     */
    AddressData billingAddress;
    /**
     * This field holds the value of shippingAddress
     */
    AddressData shippingAddress;

    /**
     * @return the correspondenceAddress
     */
    public final AddressData getCorrespondenceAddress() {
        return correspondenceAddress;
    }

    /**
     * @param correspondenceAddress
     *            the correspondenceAddress to set
     */
    public final void setCorrespondenceAddress(
            final AddressData correspondenceAddress) {
        this.correspondenceAddress = correspondenceAddress;
    }

    /**
     * @return the billingAddress
     */
    public final AddressData getBillingAddress() {
        return billingAddress;
    }

    /**
     * @param billingAddress
     *            the billingAddress to set
     */
    public final void setBillingAddress(final AddressData billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * @return the shippingAddress
     */
    public final AddressData getShippingAddress() {
        return shippingAddress;
    }

    /**
     * @param shippingAddress
     *            the shippingAddress to set
     */
    public final void setShippingAddress(final AddressData shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

}
