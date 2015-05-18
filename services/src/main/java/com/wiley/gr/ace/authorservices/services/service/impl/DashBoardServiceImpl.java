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
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.UserFunder;
import com.wiley.gr.ace.authorservices.model.UserMgmt;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAffiliations;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAreaOfInterest;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSocietyDetails;
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
		DashBoard dashBoard = new DashBoard();
		if (userId > 0) {
			List<UserFunderGrants> userFunderGrantsList = dashBoardDAO
					.getFundersDetailsList(userId);
			if (userFunderGrantsList.size() == 0) {
				UserFunder userFunders = new UserFunder();
				dashBoard.setUserFunders(userFunders);
			}
			List<AuthorProfile> authorMissedProfileList = dashBoardDAO
					.getMissedUserProfileList(userId);
			for (AuthorProfile authorMissedProfile : authorMissedProfileList) {
				Character isAccountVerified = authorMissedProfile
						.getIsAccountVerified();
				UserMgmt userMgmt = new UserMgmt();
				if (StringUtils.isEmpty(authorMissedProfile.getOrcidId())) {
					userMgmt.setOrcidID(authorMissedProfile.getOrcidId());
				}
				if (StringUtils.isEmpty(authorMissedProfile
						.getSecondaryEmailAddr())) {
					userMgmt.setSecondaryEmailAddress(authorMissedProfile
							.getSecondaryEmailAddr());
				}
				if (isAccountVerified.equals('N')) {
					userMgmt.setIsAccountVerified(isAccountVerified);
				}
				dashBoard.setUserMgmt(userMgmt);
			}
			List<UserSocietyDetails> userSocietyDetailsList = dashBoardDAO
					.getSocietyDetailsList(userId);
			if (userSocietyDetailsList.size() == 0) {
				Society societyDetails = new Society();
				dashBoard.setSociety(societyDetails);
			}
			List<UserAffiliations> userAffiliationsList = dashBoardDAO
					.getUserAffiliationsList(userId);
			if (userAffiliationsList.size() == 0) {
				Affiliation affiliation = new Affiliation();
				dashBoard.setAffiliation(affiliation);
			}
			List<UserAreaOfInterest> userAreaOfInterestList = dashBoardDAO
					.getUserAreaOfInterestsList(userId);
			if (userAreaOfInterestList.size() == 0) {
				Interests interests = new Interests();
				dashBoard.setInterests(interests);
			}
		} else {
			dashBoard = null;
		}
		return dashBoard;
	}
}
