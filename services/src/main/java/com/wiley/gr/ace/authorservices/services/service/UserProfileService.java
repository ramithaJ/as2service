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
	public Affiliation[] getAffiliationsForUser(String userId);
	
	/**
	 * @param userId
	 * @param affiliation
	 * @return
	 */
	public boolean addAffiliations(String userId, Affiliation affiliation);
	
	/**
	 * @param userId
	 * @param affiliation
	 * @return
	 */
	public boolean updateAffiliation(String userId, Affiliation affiliation);
	
	/**
	 * @param userId
	 * @param affiliationId
	 * @return
	 */
	public boolean deleteAffiliation(String userId, String affiliationId);
	
	/**
	 * @param userId
	 * @return
	 */
	public ResearchFunder[] getResearchFunders(String userId);
	
	/**
	 * @param userId
	 * @param researchFunder
	 * @return
	 */
	public boolean addResearchFunder(String userId, ResearchFunder researchFunder);
	
	/**
	 * @param userId
	 * @param researchFunder
	 * @return
	 */
	public boolean updateResearchFunder(String userId, ResearchFunder researchFunder);
	
	/**
	 * @param userId
	 * @param researchFunderId
	 * @return
	 */
	public boolean deleteResearchFunder(String userId, String researchFunderId);
	
	/**
	 * @param userId
	 * @return
	 */
	public Society[]  getSocietiesForUser(String userId);
	
	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	public Society getSocietyDetails(String userId, String societyId);
	
	/**
	 * @param userId
	 * @param society
	 * @return
	 */
	public boolean updateSocietyDetails(String userId, Society society);
	
	/**
	 * @param userId
	 * @param societyId
	 * @return
	 */
	public boolean deleteSociety(String userId, String societyId);
	
	
	/**
	 * @param userId
	 * @return
	 */
	public Interests getInterests(String userId);
	
	/**
	 * @param userId
	 * @return
	 */
	public boolean addInterest(Interests interest);
	
	/**
	 * @param userId
	 * @return
	 */
	public boolean removeInterest(String interestId);
	
	
	/**
	 * @return
	 */
	public Interests[] searchInterests();
	
	/**
	 * @param userId
	 * @return
	 */
	public CoAuthor[] getCoAuthorsList(String userId);
	
	/**
	 * @param coAuthor
	 * @return
	 */
	public boolean editCoAuthor(CoAuthor coAuthor);
	
	/**
	 * @param coAuthorId
	 * @return
	 */
	public boolean deleteCoAuthor(String coAuthorId);
	
	/**
	 * @param userId
	 * @return
	 */
	public PreferredJournals[] getPreferredJournals(String userId);
	
	/**
	 * @param userId
	 * @param journalId
	 * @return
	 */
	public boolean deletePreferredJournals(String userId, String journalId);
	
	/**
	 * @return
	 */
	public String searchJournals();
	
	/**
	 * @param userId
	 * @return
	 */
	public Alert[] getListOfAlerts(String userId);
	
	/**
	 * @param alerts
	 * @return
	 */
	public boolean updateAlerts(String userId,List<Alert> alerts );
	
	

}
