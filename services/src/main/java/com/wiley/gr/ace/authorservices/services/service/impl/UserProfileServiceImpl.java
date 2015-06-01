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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.external.LookUpProfile;
import com.wiley.gr.ace.authorservices.model.PreferredJournals;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthCoauthDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAlerts;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserPreferredJournals;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSocietyDetails;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorCoAuthorDAO;
import com.wiley.gr.ace.authorservices.persistence.services.ResearchFundersDAO;
import com.wiley.gr.ace.authorservices.persistence.services.SocietyDetailsDao;
import com.wiley.gr.ace.authorservices.persistence.services.UserAlertsDao;
import com.wiley.gr.ace.authorservices.persistence.services.UserPreferredJournalsDAO;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

/**
 * @author SarmaKumarap
 */
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired(required = true)
	UserAlertsDao userAlertsDao;

	@Autowired(required = true)
	AuthorCoAuthorDAO authorCoAuthorDAO;

	@Autowired(required = true)
	ResearchFundersDAO researchFundersDAO;

	@Autowired(required = true)
	SocietyDetailsDao societyDetailsDao;

	@Autowired(required = true)
	CDMInterfaceService cdmservices;

	@Override
	public Affiliation[] getAffiliationsForUser(String userId) {
		// TODO Auto-generated method stub
		return new Affiliation[0];
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
	public List<ResearchFunder> getResearchFunders(String userId) {

		List<UserFunderGrants> userFunderGrants = researchFundersDAO
				.getResearchFunders(userId);
		List<ResearchFunder> researchList = new ArrayList<ResearchFunder>();
		Set<Integer> checkSet = new HashSet<>();
		Set<String> grantNumbers = null;
		ResearchFunder researchFunder = null;
		Set<UserFunderGrants> grantset = null;
		for (UserFunderGrants funderDAO : userFunderGrants) {

			grantNumbers = new TreeSet<String>();
			if (!checkSet.contains(funderDAO.getResearchFunders()
					.getResfunderid())) {

				researchFunder = new ResearchFunder();
				researchFunder.setResearchFunderId(funderDAO
						.getResearchFunders().getResfunderid());
				checkSet.add(funderDAO.getResearchFunders().getResfunderid());
				researchFunder.setResearchFunderName(funderDAO
						.getResearchFunders().getFunderName());
				funderDAO.getResearchFunders().getUserFunderGrantses();
				grantset = funderDAO.getResearchFunders()
						.getUserFunderGrantses();
				for (UserFunderGrants funderSet : grantset) {
					grantNumbers.add(funderSet.getGrantNum());
				}
				researchFunder.setGrantNumber(grantNumbers);
				researchList.add(researchFunder);
			}
		}
		return researchList;
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

		researchFundersDAO.updateResearchFunder(userId, researchFunder);
		return true;
	}

	@Override
	public boolean deleteResearchFunder(String userId, String researchFunderId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Society> getSocietiesForUser(String userId) {

		List<UserSocietyDetails> listOfUserSocietyDetails = societyDetailsDao
				.getSocietiesForUser(userId);
		List<Society> societylist = new ArrayList<Society>();

		for (int i = 0; i < listOfUserSocietyDetails.size(); i++) {
			Society society = new Society();
			society.setSocietyId(listOfUserSocietyDetails.get(i).getSocietyId()
					.toString());
			society.setSocietyName(listOfUserSocietyDetails.get(i)
					.getSocietyName());
			society.setMembershipNumber(listOfUserSocietyDetails.get(i)
					.getMembershipNo());
			society.setPromoCode(listOfUserSocietyDetails.get(i).getPromoCode());
			society.setStartDate(listOfUserSocietyDetails.get(i).getStartDt());
			society.setEndDate(listOfUserSocietyDetails.get(i).getEndDt());
			societylist.add(society);

		}

		return societylist;
	}

	@Override
	public Society getSocietyDetails(String userId, String societyId) {
		// TODO Auto-generated method stub
		return new Society();
	}

	@Override
	public boolean updateSocietyDetails(Society society) {
		UserSocietyDetails userSocietyDetails = new UserSocietyDetails();
		AuthorProfile authorProfile = new AuthorProfile();
		authorProfile.setUserId(Integer.parseInt(society.getUserId()));
		userSocietyDetails.setAuthorProfile(authorProfile);
		userSocietyDetails
				.setSocietyId(Integer.parseInt(society.getSocietyId()));
		userSocietyDetails.setSocietyName(society.getSocietyName());
		userSocietyDetails.setMembershipNo(society.getMembershipNumber());
		userSocietyDetails.setPromoCode(society.getPromoCode());
		userSocietyDetails.setStartDt(society.getStartDate());
		userSocietyDetails.setEndDt(society.getEndDate());
		societyDetailsDao.updateSociety(userSocietyDetails);

		return true;
	}

	@Override
	public boolean deleteSociety(String userId, String societyId) {
		societyDetailsDao.deleteSociety(userId, societyId);
		return true;
	}

	@Override
	public Interests getInterests(String userId) {
		// TODO Auto-generated method stub
		return new Interests();
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
		return new Interests[0];
	}

	/**
	 * This method will call the dao to get the list of co-author based on
	 * author id. and will return the co-authors list to service.
	 */
	@Override
	public CoAuthor[] getCoAuthorsList(String userId) {

		List<AuthCoauthDetails> authCoauthDetails = authorCoAuthorDAO
				.getCoAuthorsList(userId);
		List<CoAuthor> coAuthorList = new ArrayList<CoAuthor>();
		for (int i = 0; i < authCoauthDetails.size(); i++) {

			CoAuthor coAuthor = new CoAuthor();
			coAuthor.setUserId(authCoauthDetails.get(i).getAuthCoauthId());
			coAuthor.setTitle(authCoauthDetails.get(i).getCoauthTitle());
			coAuthor.setFirstName(authCoauthDetails.get(i).getCoauthFirstName());
			coAuthor.setLastName(authCoauthDetails.get(i).getCoauthLastName());
			coAuthor.setPhone(authCoauthDetails.get(i).getCoauthPhone());
			coAuthor.setEmailId(authCoauthDetails.get(i).getCoauthEmailAddr());
			coAuthor.setDepartmentName(authCoauthDetails.get(i)
					.getCoauthDeptName());
			coAuthor.setInstitutionName(authCoauthDetails.get(i)
					.getCoauthInstitutionName());
			coAuthorList.add(coAuthor);
		}

		return (CoAuthor[]) coAuthorList.toArray(new CoAuthor[coAuthorList
				.size()]);
	}

	/**
	 * This method will call the DB and update the co-author details based on
	 * author id and co-author id.
	 */
	@Override
	public boolean editCoAuthor(String userId, CoAuthor coAuthorJson) {

		authorCoAuthorDAO.editCoAuthor(userId, coAuthorJson);
		return true;
	}

	/**
	 * This method will call the DB and delete the co-author details based on
	 * author id and co-author id.
	 */
	@Override
	public boolean deleteCoAuthor(String userId, String coAuthorId) {

		authorCoAuthorDAO.deleteCoAuthor(userId, coAuthorId);
		return false;
	}

	@Autowired
	UserPreferredJournalsDAO userPreferredJournalsDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#
	 * getPreferredJournals(java.lang.String)
	 */
	@Override
	public List<PreferredJournals> getPreferredJournals(String userId) {

		List<UserPreferredJournals> listOfPrefferedJournals = userPreferredJournalsDAO
				.getPreferredJournals(userId);

		List<PreferredJournals> preferredJournalslist = new ArrayList<PreferredJournals>();

		for (int i = 0; i < listOfPrefferedJournals.size(); i++) {
			PreferredJournals preferredJournals = new PreferredJournals();

			preferredJournals.setJournalId(listOfPrefferedJournals.get(i)
					.getJournals().getJournalId().toString());
			preferredJournals.setJournalTitle(listOfPrefferedJournals.get(i)
					.getJournals().getJouTitle());

			preferredJournalslist.add(preferredJournals);
		}

		return preferredJournalslist;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#
	 * deletePreferredJournals(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean deletePreferredJournals(String userId, String journalId) {

		return userPreferredJournalsDAO.deletePreferredJournals(userId,
				journalId);
	}

	@Override
	public String searchJournals() {
		// TODO Auto-generated method stub
		return new String();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#
	 * getListOfAlerts(java.lang.String)
	 */
	@Override
	public Alert[] getListOfAlerts(String userId) {

		List<UserAlerts> userAlerts = userAlertsDao.getListOfAlerts(userId);
		List<Alert> alertsList = new ArrayList<Alert>();

		for (int i = 0; i < userAlerts.size(); i++) {
			Alert alert = new Alert();

			alert.setAlertId(userAlerts.get(i).getId().getAlertCd() + "");
			alert.setAlertName(userAlerts.get(i).getAlerts().getAlertName());

			if (userAlerts.get(i).getEmailFlg().equals("Y")) {
				alert.setEmail(true);
			} else {
				alert.setEmail(false);
			}

			if (userAlerts.get(i).getOnScreenFlg().equals("Y")) {
				alert.setOnScreen(true);
			} else {
				alert.setOnScreen(false);
			}
			alertsList.add(alert);

		}
		return (Alert[]) alertsList.toArray(new Alert[alertsList.size()]);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#
	 * updateAlerts(java.lang.String, java.util.List)
	 */
	@Override
	public boolean updateAlerts(String userId, List<Alert> alertsList) {

		List<UserAlerts> daoAlertsList = userAlertsDao.getListOfAlerts(userId);

		for (Alert alert : alertsList) {

			for (UserAlerts userAlerts : daoAlertsList) {
				UserAlerts daoAlert = userAlerts;
				if (daoAlert.getId().getAlertCd() == alert.getAlertId()) {

					if (alert.isEmail()) {
						daoAlert.setEmailFlg(new Character('y'));
					} else {
						daoAlert.setEmailFlg(new Character('n'));
					}

					if (alert.isOnScreen()) {
						daoAlert.setOnScreenFlg(new Character('y'));
					} else {
						daoAlert.setOnScreenFlg(new Character('n'));
					}
					break;
				}

			}

		}

		userAlertsDao.updateAlerts(daoAlertsList);

		return true;
	}

	@Override
	public LookUpProfile lookUpProfile(String userId) {

		return cdmservices.lookUpProfile(userId);
	}
}
