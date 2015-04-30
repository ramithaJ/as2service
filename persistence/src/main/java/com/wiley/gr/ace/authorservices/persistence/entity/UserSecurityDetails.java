package com.wiley.gr.ace.authorservices.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserSecurityDetails generated by hbm2java
 */
@Entity
@Table(name = "USER_SECURITY_DETAILS")
public class UserSecurityDetails implements java.io.Serializable {

	private Integer userSecurityId;
	private AuthorProfile authorProfile;
	private String securityQuestion;
	private String securityAnswer;

	public UserSecurityDetails() {
	}

	public UserSecurityDetails(Integer userSecurityId) {
		this.userSecurityId = userSecurityId;
	}

	public UserSecurityDetails(Integer userSecurityId,
			AuthorProfile authorProfile, String securityQuestion,
			String securityAnswer) {
		this.userSecurityId = userSecurityId;
		this.authorProfile = authorProfile;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	@Id
	@Column(name = "USER_SECURITY_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getUserSecurityId() {
		return this.userSecurityId;
	}

	public void setUserSecurityId(Integer userSecurityId) {
		this.userSecurityId = userSecurityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public AuthorProfile getAuthorProfile() {
		return this.authorProfile;
	}

	public void setAuthorProfile(AuthorProfile authorProfile) {
		this.authorProfile = authorProfile;
	}

	@Column(name = "SECURITY_QUESTION", length = 250)
	public String getSecurityQuestion() {
		return this.securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	@Column(name = "SECURITY_ANSWER", length = 250)
	public String getSecurityAnswer() {
		return this.securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

}
