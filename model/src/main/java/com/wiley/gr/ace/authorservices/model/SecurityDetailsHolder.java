package com.wiley.gr.ace.authorservices.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kpshiva
 *
 */
public class SecurityDetailsHolder implements Serializable {

	private List<SecurityDetails> securityDetails = new ArrayList<SecurityDetails>();

	/**
	 * @return
	 */
	public List<SecurityDetails> getSecurityDetails() {
		return securityDetails;
	}

	/**
	 * @param securityDetails
	 */
	public void setSecurityDetails(List<SecurityDetails> securityDetails) {
		this.securityDetails = securityDetails;
	}

}
