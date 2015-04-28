package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author kpshiva
 */
@JsonInclude(Include.NON_NULL)
public class Security {

	/**
	 * 
	 */
	private String id1;
	
	/**
	 * 
	 */
	private String id2;
	
	/**
	 * @return
	 */
	/** The security question1. */
	private String securityQuestion1;

	/** The security question2. */
	private String securityQuestion2;

	/** The security answer1. */
	private String securityAnswer1;

	/** The security answer2. */
	private String securityAnswer2;

	
	public String getId1() {
		return id1;
	}

	/**
	 * @param id1
	 */
	public void setId1(String id1) {
		this.id1 = id1;
	}

	/**
	 * @return
	 */
	public String getId2() {
		return id2;
	}

	/**
	 * @param id2
	 */
	public void setId2(String id2) {
		this.id2 = id2;
	}
	/**
	 * Gets the security question1.
	 *
	 * @return the security question1
	 */
	public String getSecurityQuestion1() {
		return securityQuestion1;
	}

	/**
	 * Sets the security question1.
	 *
	 * @param securityQuestion1
	 *            the new security question1
	 */
	public void setSecurityQuestion1(String securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}

	public String getSecurityAnswer1() {
		return securityAnswer1;
	}

	/**
	 * Sets the security answer1.
	 *
	 * @param securityAnswer1
	 *            the new security answer1
	 */
	public void setSecurityAnswer1(String securityAnswer1) {
		this.securityAnswer1 = securityAnswer1;
	}

	/**
	 * Gets the security answer2.
	 *
	 * @return the security answer2
	 */
	public String getSecurityAnswer2() {
		return securityAnswer2;
	}

	/**
	 * Sets the security answer2.
	 *
	 * @param securityAnswer2
	 *            the new security answer2
	 */
	public void setSecurityAnswer2(String securityAnswer2) {
		this.securityAnswer2 = securityAnswer2;
	}

	public String getSecurityQuestion2() {
		return securityQuestion2;
	}

	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}

}
