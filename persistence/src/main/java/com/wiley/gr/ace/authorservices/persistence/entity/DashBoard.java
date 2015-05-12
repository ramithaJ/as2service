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

/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.entity;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yugandhark
 *
 */
public class DashBoard {

	private List<UserSecurityDetails> userSecurityDetails;
	private List<AuthorProfile> authorProfileList;
	private List<LinkedList> affiliation;
	private List<SocietyDetails> societyDetails;
	private List<ResearchFunders> researchFunder;
	private List<LinkedList> areaOfExpertise;
	
	public List<UserSecurityDetails> getUserSecurityDetails() {
		return userSecurityDetails;
	}

	public void setUserSecurityDetails(List<UserSecurityDetails> userSecurityDetails) {
		this.userSecurityDetails = userSecurityDetails;
	}
	public List<SocietyDetails> getSocietyDetails() {
		return societyDetails;
	}

	public void setSocietyDetails(List<SocietyDetails> societyDetails) {
		this.societyDetails = societyDetails;
	}

	
	
	public List<LinkedList> getAreaOfExpertise() {
		return areaOfExpertise;
	}

	public void setAreaOfExpertise(List<LinkedList> areaOfExpertise) {
		this.areaOfExpertise = areaOfExpertise;
	}

	

	public List<AuthorProfile> getAuthorProfileList() {
		return authorProfileList;
	}

	public void setAuthorProfileList(List<AuthorProfile> authorProfileList) {
		this.authorProfileList = authorProfileList;
	}

	

	

	public List<LinkedList> getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(List<LinkedList> affiliation) {
		this.affiliation = affiliation;
	}

	public List<ResearchFunders> getResearchFunder() {
		return researchFunder;
	}

	public void setResearchFunder(List<ResearchFunders> researchFunder) {
		this.researchFunder = researchFunder;
	}
	
}

