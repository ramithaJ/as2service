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
package com.wiley.gr.ace.authorservices.persistence.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserPreferredJournals generated by hbm2java
 */
@Entity
@Table(name = "USER_PREFERRED_JOURNALS")
public class UserPreferredJournals implements java.io.Serializable {

	private UserPreferredJournalsId id;
	private UserProfile userProfile;
	private String jouImpactFactor;

	public UserPreferredJournals() {
	}

	public UserPreferredJournals(UserPreferredJournalsId id,
			UserProfile userProfile) {
		this.id = id;
		this.userProfile = userProfile;
	}

	public UserPreferredJournals(UserPreferredJournalsId id,
			UserProfile userProfile, String jouImpactFactor) {
		this.id = id;
		this.userProfile = userProfile;
		this.jouImpactFactor = jouImpactFactor;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)),
			@AttributeOverride(name = "journalId", column = @Column(name = "JOURNAL_ID", nullable = false, precision = 22, scale = 0)) })
	public UserPreferredJournalsId getId() {
		return this.id;
	}

	public void setId(UserPreferredJournalsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
	public UserProfile getUserProfile() {
		return this.userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	@Column(name = "JOU_IMPACT_FACTOR", length = 100)
	public String getJouImpactFactor() {
		return this.jouImpactFactor;
	}

	public void setJouImpactFactor(String jouImpactFactor) {
		this.jouImpactFactor = jouImpactFactor;
	}

}
