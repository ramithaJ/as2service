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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * @author SarmaKumarap
 *
 */
@JsonInclude(Include.NON_NULL)
public class UserProfile {
	
	private User profileInformation;
	
	//private User emailDetails;
	
	private List<Addresses> addressDetails;
	
	private List<Affiliation> affiliations;
	
	private List<ResearchFunder> researchFunders;
	
	private List<Society> societies;
	
	private List<Interests> interests;
	
	private List<CoAuthor> coAuthors;
	
	private List<PreferredJournals> preferredJournals;
	
	private List<Alert> alerts;
	
	private String emailForAlerts;

	
	public String getEmailForAlerts() {
		return emailForAlerts;
	}

	public void setEmailForAlerts(String emailForAlerts) {
		this.emailForAlerts = emailForAlerts;
	}

	public User getProfileInformation() {
		return profileInformation;
	}

	public void setProfileInformation(User profileInformation) {
		this.profileInformation = profileInformation;
	}

	public List<Addresses> getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(List<Addresses> addressDetails) {
		this.addressDetails = addressDetails;
	}

	public List<Affiliation> getAffiliations() {
		return affiliations;
	}

	public void setAffiliations(List<Affiliation> affiliations) {
		this.affiliations = affiliations;
	}

	public List<ResearchFunder> getResearchFunders() {
		return researchFunders;
	}

	public void setResearchFunders(List<ResearchFunder> researchFunders) {
		this.researchFunders = researchFunders;
	}

	public List<Society> getSocieties() {
		return societies;
	}

	public void setSocieties(List<Society> societies) {
		this.societies = societies;
	}

	public List<Interests> getInterests() {
		return interests;
	}

	public void setInterests(List<Interests> interests) {
		this.interests = interests;
	}

	public List<CoAuthor> getCoAuthors() {
		return coAuthors;
	}

	public void setCoAuthors(List<CoAuthor> coAuthors) {
		this.coAuthors = coAuthors;
	}

	public List<PreferredJournals> getPreferredJournals() {
		return preferredJournals;
	}

	public void setPreferredJournals(List<PreferredJournals> preferredJournals) {
		this.preferredJournals = preferredJournals;
	}

	public List<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}
	

	}
