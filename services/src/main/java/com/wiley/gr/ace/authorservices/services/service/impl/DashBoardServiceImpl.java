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
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.DashBoard;
import com.wiley.gr.ace.authorservices.model.DashBoardInfo;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetailsHolder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.User;
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
	 * @return DashBoardInfo
	 */
	public DashBoard getProfileMeter(String userId) throws Exception {
		List<DashBoardInfo> dashBoardInfoList = new ArrayList<DashBoardInfo>();
		DashBoardInfo dashBoardInfo = null;
		DashBoard dashBoard = null;
		if (!StringUtils.isEmpty(userId)) {
			SecurityDetailsHolder securityDetailsHolder = almIntefaceService
					.getSecurityDetails(userId);
			List<SecurityDetails> securityDetailsList = securityDetailsHolder
					.getSecurityDetails();
			if (null != securityDetailsList) {
				for (SecurityDetails securityDetails : securityDetailsList) {
					if (StringUtils.isEmpty(securityDetails
							.getSecurityQuestion())
							|| StringUtils.isEmpty(securityDetails
									.getSecurityAnswer())) {
						dashBoardInfo = new DashBoardInfo();
						dashBoardInfo.setId("security");
						dashBoardInfo
								.setDashBoardInfoMessage("No Security Details");
						dashBoardInfoList.add(dashBoardInfo);
						break;
					}
				}
			}
			LookUpProfile lookUpProfile = cdmIntefaceService
					.lookUpProfile(userId);
			UserProfile userProfile = lookUpProfile.getUserProfile();
			User user = userProfile.getProfileInformation();
			if (StringUtils.isEmpty(user.getRecoveryEmailAddress())) {
				dashBoardInfo = new DashBoardInfo();
				dashBoardInfo.setId("secondaryEmailAddr");
				dashBoardInfo
						.setDashBoardInfoMessage("No Secondary Email(Recovery Email Addr)");
				dashBoardInfoList.add(dashBoardInfo);
			}
			if (StringUtils.isEmpty(user.getOrcidID())) {
				dashBoardInfo = new DashBoardInfo();
				dashBoardInfo.setId("OrcidId");
				dashBoardInfo.setDashBoardInfoMessage("No Orcid ID");
				dashBoardInfoList.add(dashBoardInfo);
			}
			List<Interests> userInterestsList = userProfile.getInterests();
			if (null != userInterestsList && userInterestsList.size() == 0) {
				dashBoardInfo = new DashBoardInfo();
				dashBoardInfo.setId("Interests");
				dashBoardInfo
						.setDashBoardInfoMessage("No Areas Of Expertizes(Interests) Details");
				dashBoardInfoList.add(dashBoardInfo);
			}
			List<Affiliation> userAffiliationsList = userProfile
					.getAffiliations();
			if (null != userAffiliationsList
					&& userAffiliationsList.size() == 0) {
				dashBoardInfo = new DashBoardInfo();
				dashBoardInfo.setId("Affiliation");
				dashBoardInfo.setDashBoardInfoMessage("No Affiliation Details");
				dashBoardInfoList.add(dashBoardInfo);
			}
			List<Society> societyList = userProfile.getSocieties();
			if (null != societyList && societyList.size() == 0) {
				dashBoardInfo = new DashBoardInfo();
				dashBoardInfo.setId("Society");
				dashBoardInfo.setDashBoardInfoMessage("No Society Details");
				dashBoardInfoList.add(dashBoardInfo);
			}
			List<ResearchFunder> researchFundersList = userProfile
					.getResearchFunders();
			if (null != researchFundersList && researchFundersList.size() == 0) {
				dashBoardInfo = new DashBoardInfo();
				dashBoardInfo.setId("ResearchFunder");
				dashBoardInfo
						.setDashBoardInfoMessage("No Research Funders Details");
				dashBoardInfoList.add(dashBoardInfo);
			}
			dashBoard = new DashBoard();
			if (null != dashBoardInfoList && dashBoardInfoList.size() == 0) {
				dashBoard.setDashBoardInfo(dashBoardInfoList);
				String profileMeterMesaage="Profile Completed";
				dashBoard.setProfileMeterMessage(profileMeterMesaage);
			} else {
				String profileMeterMesaage="";
				dashBoard.setProfileMeterMessage(profileMeterMesaage);
				dashBoard.setDashBoardInfo(dashBoardInfoList);
			}
		}
		return dashBoard;
	}
}