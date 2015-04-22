package com.wiley.gr.ace.authorservices.services.service.impl;

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.PreferredJournals;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

/**
 * @author SarmaKumarap
 *
 */
public class UserProfileServiceImpl implements UserProfileService {

	@Override
	public Affiliation[] getAffiliationsForUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAffiliations(String userId, Affiliation affiliation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAffiliation(String userId, Affiliation affiliation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAffiliation(String userId, String affiliationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResearchFunder[] getResearchFunders(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addResearchFunder(String userId,
			ResearchFunder researchFunder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateResearchFunder(String userId,
			ResearchFunder researchFunder) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteResearchFunder(String userId, String researchFunderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Society[] getSocietiesForUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Society getSocietyDetails(String userId, String societyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSocietyDetails(String userId, Society society) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSociety(String userId, String societyId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Interests getInterests(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addInterest(Interests interest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeInterest(String interestId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Interests[] searchInterests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoAuthor[] getCoAuthorsList(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editCoAuthor(CoAuthor coAuthor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCoAuthor(String coAuthorId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PreferredJournals[] getPreferredJournals(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePreferredJournals(String userId, String journalId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String searchJournals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alert[] getListOfAlerts(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAlerts(Alert[] alerts) {
		// TODO Auto-generated method stub
		return false;
	}

}
