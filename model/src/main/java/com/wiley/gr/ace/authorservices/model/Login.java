package com.wiley.gr.ace.authorservices.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author SarmaKumarap
 *
 */
public class Login {
	
	@NotNull @NotBlank  @Email
	private String emailId;
	
	@NotNull @NotBlank
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
