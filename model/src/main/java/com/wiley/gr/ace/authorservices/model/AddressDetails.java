/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class AddressDetails.
 */
@JsonInclude(Include.NON_NULL)
public class AddressDetails {

	/**
	 * This field holds the value of billingAddress
	 */
	private Address billingAddress;

	/**
	 * This field holds the value of contactAddress
	 */
	private Address contactAddress;

	/**
	 * @return the billingAddress
	 */
	public final Address getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress
	 *            the billingAddress to set
	 */
	public final void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the contactAddress
	 */
	public Address getContactAddress() {
		return contactAddress;
	}

	/**
	 * @param contactAddress
	 *            the contactAddress to set
	 */
	public void setContactAddress(Address contactAddress) {
		this.contactAddress = contactAddress;
	}

}
