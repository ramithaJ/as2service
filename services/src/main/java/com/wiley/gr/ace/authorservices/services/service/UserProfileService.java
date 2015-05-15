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
package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.PreferredJournals;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;

/**
 * @author SarmaKumarap
 *
 */
public interface UserProfileService {

	/**
	 * @param userId
	 * @return
	 */
	Affiliation[] getAffiliationsForUser(String userId);

	/**
	 * @param userId
	 * @param affiliation
	 * @return
	 */
	boolean addAffiliations(String userId, Affiliation affiliation);

	/**
	 * @param userId
	 * @param affiliation
	 * @return
	 */
	boolean updateAffiliation(String userId, Affiliation affiliation);

	/**
	 * @param userId
	 * @param affiliationId
	 * @return
	 */
	boolean deleteAffiliation(String userId, String affiliationId);

	/**
	 * @param userId
	 * @return
	 */
	List<ResearchFunder> getResearchFunders(String userId);

	/**
	 * @param userId
	 * @param researchFunder
	 * @return
	 */
	boolean addResearchFunder(String userId, ResearchFunder researchFunder);

	/**
	 * @param userId
	 * @param researchFunder
	 * @return
	 */
	boolean updateResearchFunder(String userId, ResearchFunder researchFunder);

	/**
	 * @param userId
	 * @param researchFunderId
	 * @return
	 */
	boolean deleteResearchFunder(String userId, String researchFunderId);

	/**
	 * @param userId
	 * @return
	 */
	Society[] getSocietiesForUser(String userId);

	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	Society getSocietyDetails(String userId, String societyId);

	/**
	 * @param userId
	 * @param society
	 * @return
	 */
	boolean updateSocietyDetails(String userId, Society society);

	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	boolean deleteSociety(String userId, String societyId);

	/**
	 * @param userId
	 * @return
	 */
	Interests getInterests(String userId);

	/**
	 * @param userId
	 * @return
	 */
	boolean addInterest(Interests interest);

	/**
	 * @param userId
	 * @return
	 */
	boolean removeInterest(String interestId);

	/**
	 * @return
	 */
	Interests[] searchInterests();

	/**
	 * @param userId
	 * @return
	 */
	CoAuthor[] getCoAuthorsList(String userId);

	/**
	 * @param coAuthor
	 * @return
	 */
	boolean editCoAuthor(String userId, CoAuthor coAuthorJson);

	/**
	 * @param coAuthorId
	 * @return
	 */
	boolean deleteCoAuthor(String userId, String coAuthorId);

	/**
	 * @param userId
	 * @return
	 */
	List<PreferredJournals> getPreferredJournals(String userId);

	/**
	 * @param userId
	 * @param journalId
	 * @return
	 */
	boolean deletePreferredJournals(String userId, String journalId);

	/**
	 * @return
	 */
	String searchJournals();

	/**
	 * @param userId
	 * @return
	 */
	Alert[] getListOfAlerts(String userId);

	/**
	 * @param alerts
	 * @return
	 */
	boolean updateAlerts(String userId, List<Alert> alertsList);

}
