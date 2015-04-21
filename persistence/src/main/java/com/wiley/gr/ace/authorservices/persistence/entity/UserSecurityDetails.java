package com.wiley.gr.ace.authorservices.persistence.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "USER_SECURITY_DETAILS")
public class UserSecurityDetails implements java.io.Serializable {

	private BigDecimal userSecurityId;
	private UserProfile userProfile;
	private String securityQuestion;
	private String securityAnswer;

	public UserSecurityDetails() {
	}

	public UserSecurityDetails(BigDecimal userSecurityId,
			UserProfile userProfile) {
		this.userSecurityId = userSecurityId;
		this.userProfile = userProfile;
	}

	public UserSecurityDetails(BigDecimal userSecurityId,
			UserProfile userProfile, String securityQuestion,
			String securityAnswer) {
		this.userSecurityId = userSecurityId;
		this.userProfile = userProfile;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}

	@Id
	@Column(name = "USER_SECURITY_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getUserSecurityId() {
		return this.userSecurityId;
	}

	public void setUserSecurityId(BigDecimal userSecurityId) {
		this.userSecurityId = userSecurityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
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
