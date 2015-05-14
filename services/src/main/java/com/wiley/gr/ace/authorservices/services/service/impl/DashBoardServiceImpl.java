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

import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDAO;
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;

/**
 * @author Virtusa
 *
 */
public class DashBoardServiceImpl implements DashBoardService {
	/**
	 * 
	 */
	@Autowired(required = true)
	private DashBoardDAO dashBoardDAO;

	/**
	 * @param userId
	 * @return dashBoardProfileList
	 */
	public final List<Service> getProfileMeter(final int userId) {
		List<Service> dashBoardProfileList = new LinkedList<Service>();
		List<UserSecurityDetails> securityDetailsList = null;
		securityDetailsList = dashBoardDAO.getSecurityDetailsList(userId);
		if (null != securityDetailsList) {
			for (UserSecurityDetails secureDetails : securityDetailsList) {
				SecurityDetails security = new SecurityDetails();
				security.setSecurityQuestion(secureDetails
						.getSecurityQuestion());
				security.setSecurityAnswer(secureDetails.getSecurityAnswer());
				if (StringUtils.isEmpty(security.getSecurityQuestion())
						|| StringUtils.isEmpty(security.getSecurityAnswer())) {
					Service service = new Service();
					service.setStatus("Please Fill  Questions and Answers");
					dashBoardProfileList.add(service);
					break;
				}
			}
		}
		UserFunderGrants userFunderGrants = dashBoardDAO
				.getFundersDetails(userId);
		if (StringUtils.isEmpty(userFunderGrants)) {
			Service service = new Service();
			service.setStatus("Missed to Add Your Funder Details ");
			dashBoardProfileList.add(service);
		}
		return dashBoardProfileList;
	}
}
