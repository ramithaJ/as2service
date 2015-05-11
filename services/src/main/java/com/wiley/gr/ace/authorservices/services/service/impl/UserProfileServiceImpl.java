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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.PreferredJournals;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthCoauthDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAlerts;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorCoAuthorDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserAlertsDao;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

/**
 * @author SarmaKumarap
 *
 */
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired(required = true)
	UserAlertsDao userAlertsDao;

	@Autowired(required = true)
	AuthorCoAuthorDAO authorCoAuthorDAO;

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

		List<AuthCoauthDetails> authCoauthDetails = authorCoAuthorDAO
				.getCoAuthorsList(userId);
		ArrayList<CoAuthor> coAuthorList = new ArrayList<CoAuthor>();
		for (int i = 0; i < authCoauthDetails.size(); i++) {

			CoAuthor coAuthor = new CoAuthor();
			coAuthor.setUserId(authCoauthDetails.get(i).getAuthCoauthId());
			coAuthor.setTitle(authCoauthDetails.get(i).getCoauthTitle());
			coAuthor.setFirstName(authCoauthDetails.get(i).getCoauthFirstName());
			coAuthor.setLastName(authCoauthDetails.get(i).getCoauthLastName());
			coAuthor.setPhone(authCoauthDetails.get(i).getCoauthPhone());
			coAuthor.setEmailId(authCoauthDetails.get(i).getCoauthEmailAddr());
			coAuthor.setDepartmentName(authCoauthDetails.get(i).getCoauthDept());
			coAuthor.setInstitutionName(authCoauthDetails.get(i)
					.getCoauthInstitution());
			coAuthorList.add(coAuthor);
		}

		return (CoAuthor[]) coAuthorList.toArray(new CoAuthor[coAuthorList
				.size()]);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#
	 * getListOfAlerts(java.lang.String)
	 */
	@Override
	public Alert[] getListOfAlerts(String userId) {

		List<UserAlerts> userAlerts = userAlertsDao.getListOfAlerts(userId);
		ArrayList<Alert> alertsList = new ArrayList<Alert>();

		for (int i = 0; i < userAlerts.size(); i++) {
			Alert alert = new Alert();

			alert.setAlertId(userAlerts.get(i).getId().getAlertId() + "");
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

	@Override
	public boolean updateAlerts(String userId, List<Alert> alertsList) {

		List<UserAlerts> daoAlertsList = userAlertsDao.getListOfAlerts(userId);

		for (Alert alert : alertsList) {

			for (UserAlerts userAlerts : daoAlertsList) {
				UserAlerts daoAlert = userAlerts;
				if (daoAlert.getId().getAlertId() == Integer.parseInt(alert
						.getAlertId())) {

					if (alert.isEmail()) {
						daoAlert.setEmailFlg(new Character('Y'));
					} else {
						daoAlert.setEmailFlg(new Character('N'));
					}

					if (alert.isOnScreen()) {
						daoAlert.setOnScreenFlg(new Character('Y'));
					} else {
						daoAlert.setOnScreenFlg(new Character('N'));
					}
					break;
				}

			}

		}

		userAlertsDao.updateAlerts(daoAlertsList);

		return true;
	}

}
