package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.PreferredJournals;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAlerts;
import com.wiley.gr.ace.authorservices.persistence.services.UserAlertsDao;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserAlertsDaoImpl;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

/**
 * @author SarmaKumarap
 *
 */
public class UserProfileServiceImpl implements UserProfileService {
	private static ApplicationContext daoContext = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#
	 * getListOfAlerts(java.lang.String)
	 */
	@Override
	public Alert[] getListOfAlerts(String userId) {

		UserAlertsDao userAlertsDao = (UserAlertsDaoImpl) daoContext
				.getBean("UserAlertsDao");
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
	public boolean updateAlerts(Alert[] alerts) {
		// TODO Auto-generated method stub
		return false;
	}

}
