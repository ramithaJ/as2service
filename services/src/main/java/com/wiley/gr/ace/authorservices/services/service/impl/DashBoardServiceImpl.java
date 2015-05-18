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

import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.DashBoard;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserFunder;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.model.external.LookUpProfile;
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;

/**
 * @author Virtusa
 *
 */
public class DashBoardServiceImpl implements DashBoardService {

	@Autowired(required = true)
	private CDMInterfaceService cdmIntefaceService;
	@Autowired(required = true)
	private ALMInterfaceService almIntefaceService;

	/**
	 * @param userId
	 *            to get the data from DashBoardDAO
	 * @return dashBoard
	 */
	public DashBoard getProfileMeter(String userId) throws Exception {
		DashBoard dashBoard = new DashBoard();
		if (!StringUtils.isEmpty(userId)) {
            SecurityDetailsHolder securityDetailsHolder=almIntefaceService.getSecurityDetails(userId);
            List<SecurityDetails> securityDetailsList=securityDetailsHolder.getSecurityDetails();
            if (null != securityDetailsList) {
				for (SecurityDetails securityDetails : securityDetailsList) {
					if (StringUtils
							.isEmpty(securityDetails.getSecurityQuestion())
							|| StringUtils.isEmpty(securityDetails
									.getSecurityAnswer())) {
						dashBoard.setSecurityDetails(securityDetails);
						break;
					}
				}
			}
			LookUpProfile lookUpProfile = cdmIntefaceService
					.lookUpProfile(userId);
			UserProfile userProfile = lookUpProfile.getUserProfile();
			User user = userProfile.getProfileInformation();
			if (StringUtils.isEmpty(user.getRecoveryEmailAddress())) {
				user.setRecoveryEmailAddress(user.getRecoveryEmailAddress());
				User userForSecEmailAddr = new User();
				userForSecEmailAddr.setRecoveryEmailAddress(user
						.getRecoveryEmailAddress());
				dashBoard.setUser(userForSecEmailAddr);
			}
			if (StringUtils.isEmpty(user.getOrcidID())) {
				User userForOrcidId = new User();
				userForOrcidId.setOrcidID(user.getOrcidID());
				dashBoard.setUser(userForOrcidId);
			}
			List<Interests> userInterestsList = userProfile.getInterests();
			if (userInterestsList.size() == 0) {
				Interests interests = new Interests();
				dashBoard.setInterests(interests);
			}
			List<Affiliation> userAffiliationsList = userProfile
					.getAffiliations();
			if (userAffiliationsList.size() == 0) {
				Affiliation affiliation = new Affiliation();
				dashBoard.setAffiliation(affiliation);
			}
			List<Society> societyList = userProfile.getSocieties();
			if (societyList.size() == 0) {
				Society societyDetails = new Society();
				dashBoard.setSociety(societyDetails);
			}
			List<ResearchFunder> researchFundersList = userProfile
					.getResearchFunders();
			if (researchFundersList.size() == 0) {
				UserFunder userFunders = new UserFunder();
				dashBoard.setUserFunders(userFunders);
			}
		} else {
			dashBoard = null;
		}
		return dashBoard;
	}
}