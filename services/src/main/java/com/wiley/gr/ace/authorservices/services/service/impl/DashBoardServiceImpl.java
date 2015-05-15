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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.DashBoard;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDAO;
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;

/**
 * @author Virtusa
 *
 */
public class DashBoardServiceImpl implements DashBoardService {

	/** The Auto Wired for DashBoardDAO . */
	@Autowired(required = true)
	private DashBoardDAO dashBoardDAO;

	/**
	 * @param userId
	 *            to get the data from DashBoardDAO
	 * @return dashBoard
	 */
	public DashBoard getProfileMeter(int userId) throws Exception {
		List<UserSecurityDetails> securityDetailsList = null;
		DashBoard dashBoard = new DashBoard();
		if (userId > 0) {
			securityDetailsList = dashBoardDAO.getSecurityDetailsList(userId);
			if (null != securityDetailsList) {
				for (UserSecurityDetails secureDetails : securityDetailsList) {
					if (StringUtils
							.isEmpty(secureDetails.getSecurityQuestion())
							|| StringUtils.isEmpty(secureDetails
									.getSecurityAnswer())) {
						SecurityDetails securityDetails = new SecurityDetails();
						securityDetails.setSecurityQuestion(secureDetails
								.getSecurityQuestion());
						securityDetails.setSecurityAnswer(secureDetails
								.getSecurityAnswer());
						dashBoard.setSecurityDetails(securityDetails);
						break;
					}
				}
			}
			UserFunderGrants userFunderGrants = dashBoardDAO
					.getFundersDetails(userId);
			if (StringUtils.isEmpty(userFunderGrants)) {
				Service service = new Service();
				service.setStatus("Missed to Add Your Funder Details ");
				dashBoard.setServiceFunders(service);
			}
			AuthorProfile authorMissedProfile = dashBoardDAO
					.getMissedUserProfile(userId);
			Character isAccountVerified = authorMissedProfile
					.getIsAccountVerified();
			if (isAccountVerified.equals('N')) {
				UserMgmt userMgmt = new UserMgmt();
				userMgmt.setIsAccountVerified(isAccountVerified);
				userMgmt.setOrcidID("OrcidId");
				userMgmt.setSecondaryEmailAddress("secondaryEmailAddr");
				dashBoard.setUserMgmt(userMgmt);
			}
			Society society = new Society();
			society.setSocietyId("false");
			dashBoard.setSociety(society);
			Affiliation affiliation = new Affiliation();
			dashBoard.setAffiliation(affiliation);
			Interests interests = new Interests();
			dashBoard.setInterests(interests);
		} else {
			dashBoard = null;
		}
		return dashBoard;
	}
}
