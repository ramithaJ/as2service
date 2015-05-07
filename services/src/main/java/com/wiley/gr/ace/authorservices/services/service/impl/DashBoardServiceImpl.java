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

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserReferenceData;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;

import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDAO;
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;

public class DashBoardServiceImpl implements DashBoardService {

	@Autowired(required = true)
	DashBoardDAO dashBoardDAO;

	@Override
	public List<LinkedList> getProfileMeter(int userId) {
		Security security = new Security();
		List dashBoardProfileList = new LinkedList();
		List profileMeterList = dashBoardDAO.getProfileMeter(userId);
		List<UserSecurityDetails> userSecureDetailsList = (List<UserSecurityDetails>) profileMeterList.get(0);
		security.setSecurityQuestion1(userSecureDetailsList.get(0)
				.getSecurityQuestion());
		security.setSecurityAnswer1(userSecureDetailsList.get(0)
				.getSecurityAnswer());
		security.setSecurityQuestion2(userSecureDetailsList.get(1)
				.getSecurityQuestion());
		security.setSecurityAnswer2(userSecureDetailsList.get(1)
				.getSecurityAnswer());
		if (userSecureDetailsList != null) {
			Service service = new Service();
			if (null == security.getSecurityQuestion1()
					|| null == security.getSecurityAnswer1()) {
				if (null == security.getSecurityQuestion2()
						|| null == security.getSecurityAnswer2()) {
					service.setStatus("Set up your security questions, it will allow you to easily access your Wiley account if you ever forget your password");
					dashBoardProfileList.add(service);
				}
			} else if (null == security.getSecurityQuestion1()
					&& null == security.getSecurityAnswer1()) {
				service.setStatus("Set up your security question1 and answer1,it will allow you to easily access your Wiley account if you ever forget your password");
				dashBoardProfileList.add(service);
			} else if (null == security.getSecurityQuestion2()
					&& null == security.getSecurityAnswer2()) {
				service.setStatus("Set up your security question2 and answer2, it will allow you to easily access your Wiley account if you ever forget your password");
				dashBoardProfileList.add(service);
			} 
		}
		List<UserProfile> secondaryEmailList = (List<UserProfile>) profileMeterList
				.get(1);
		Service service = new Service();
		if (null == secondaryEmailList.get(0)) {
			service.setStatus("Set up a recovery email address, it will help you recover all your information if you ever change the current associated email");
			dashBoardProfileList.add(service);
		}
		List<UserReferenceData> userOrcIdList = (List<UserReferenceData>) profileMeterList.get(2);
		if (null == userOrcIdList.get(0)) {
			Service serviceOrciId = new Service();
			serviceOrciId.setStatus("Set up a OrcidId, it will help you recover all your information if you ever change the current Login Details");
			dashBoardProfileList.add(serviceOrciId);
		}
		List userSocietyList=(List)profileMeterList.get(3);
		if(null==userSocietyList.get(0)){
			Service serviceSocietyDetails=new Service();
			serviceSocietyDetails.setStatus("Add Info About Your Societies");
			dashBoardProfileList.add(serviceSocietyDetails);
		}
		List userAffliationsList=(List)profileMeterList.get(4);
		if(null==userAffliationsList.get(0)){
			Service serviceAffliationsDetails=new Service();
			serviceAffliationsDetails.setStatus("Add Info About Your Affliations");
			dashBoardProfileList.add(serviceAffliationsDetails);
		}
		List userFundersList=(List)profileMeterList.get(5);
		if(null==userFundersList.get(0)){
			Service serviceFundersDetails=new Service();
			serviceFundersDetails.setStatus("Add Info About Your Funders");
			dashBoardProfileList.add(serviceFundersDetails);
		}
		List areasOfExpertiseList=(List)profileMeterList.get(6);
		if(null==areasOfExpertiseList.get(0)){
			Service serviceareasOfExpertiseDetails=new Service();
			serviceareasOfExpertiseDetails.setStatus("Add Info About  Your Areas of Expertise");
			dashBoardProfileList.add(serviceareasOfExpertiseDetails);
		}
		List isAccountVerifiedList=(List)profileMeterList.get(7);
		if(null==isAccountVerifiedList.get(0)){
			Service serviceisAccountVerifiedDetails=new Service();
			serviceisAccountVerifiedDetails.setStatus("Your Account is Not Verified");
			dashBoardProfileList.add(serviceisAccountVerifiedDetails);
		}
		System.out.println(dashBoardProfileList.size()+"size of service list");
		return dashBoardProfileList;
	}

}
