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

/**
 * @author SarmaKumarap
 *
 */
public class UserProfile {
	
	private Affiliation[] affiliations;
	
	private ResearchFunder[] researchFunders;
	
	private Society[] societies;
	
	private Interests[] interests;
	
	private CoAuthor[] coAuthors;
	
	private PreferredJournals[] preferredJournals;
	
	private Alert[] alerts;
	
	private String emailForAlerts;

	/**
	 * @return
	 */
	public Affiliation[] getAffiliations() {
		return affiliations;
	}

	/**
	 * @param affiliations
	 */
	public void setAffiliations(Affiliation[] affiliations) {
		this.affiliations = affiliations;
	}

	/**
	 * @return
	 */
	public ResearchFunder[] getResearchFunders() {
		return researchFunders;
	}

	/**
	 * @param researchFunders
	 */
	public void setResearchFunders(ResearchFunder[] researchFunders) {
		this.researchFunders = researchFunders;
	}

	/**
	 * @return
	 */
	public Society[] getSocieties() {
		return societies;
	}

	/**
	 * @param societies
	 */
	public void setSocieties(Society[] societies) {
		this.societies = societies;
	}

	/**
	 * @return
	 */
	public Interests[] getInterests() {
		return interests;
	}

	/**
	 * @param interests
	 */
	public void setInterests(Interests[] interests) {
		this.interests = interests;
	}

	/**
	 * @return
	 */
	public CoAuthor[] getCoAuthors() {
		return coAuthors;
	}

	/**
	 * @param coAuthors
	 */
	public void setCoAuthors(CoAuthor[] coAuthors) {
		this.coAuthors = coAuthors;
	}

	/**
	 * @return
	 */
	public PreferredJournals[] getPreferredJournals() {
		return preferredJournals;
	}

	/**
	 * @param preferredJournals
	 */
	public void setPreferredJournals(PreferredJournals[] preferredJournals) {
		this.preferredJournals = preferredJournals;
	}

	/**
	 * @return
	 */
	public Alert[] getAlerts() {
		return alerts;
	}

	/**
	 * @param alerts
	 */
	public void setAlerts(Alert[] alerts) {
		this.alerts = alerts;
	}

	/**
	 * @return
	 */
	public String getEmailForAlerts() {
		return emailForAlerts;
	}

	/**
	 * @param emailForAlerts
	 */
	public void setEmailForAlerts(String emailForAlerts) {
		this.emailForAlerts = emailForAlerts;
	}

}
