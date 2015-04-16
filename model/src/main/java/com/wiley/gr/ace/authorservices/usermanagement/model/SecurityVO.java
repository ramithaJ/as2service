package com.wiley.gr.ace.authorservices.usermanagement.model;

/**
 * @author kpshiva
 */
public class SecurityVO {

	/** The security question1. */
	private String securityQuestion1;

	/** The security question2. */
	private String securityQuestion2;

	/** The security answer1. */
	private String securityAnswer1;

	/** The security answer2. */
	private String securityAnswer2;

	/** The old password. */
	private String oldPassword;

	/** The new password. */
	private String newPassword;

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

	/**
	 * Gets the old password.
	 *
	 * @return the old password
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * Sets the old password.
	 *
	 * @param oldPassword
	 *            the new old password
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * Gets the new password.
	 *
	 * @return the new password
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * Sets the new password.
	 *
	 * @param newPassword
	 *            the new new password
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getSecurityQuestion2() {
		return securityQuestion2;
	}

	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}

}
