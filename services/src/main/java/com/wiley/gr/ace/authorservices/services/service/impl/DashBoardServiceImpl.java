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

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.Article;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserReferenceData;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDAO;
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;

public class DashBoardServiceImpl implements DashBoardService {
	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	DashBoardDAO dashBoardDAO=(DashBoardDAO)context.getBean("DashBoardDAO");
	@Override
	public List<Article> getAllAuthorArticles() {
		// TODO Auto-generated method stub
		return dashBoardDAO.getAllAuthorArticles();	 
	}
	@Override
	public List<LinkedList> getProfileMeter(int userId) {
		Security security=new Security();
		List dashBoardProfileList=new LinkedList();
		List profileMeterList=dashBoardDAO.getProfileMeter(userId);
		List<UserSecurityDetails> userSecureDetailsList=(List<UserSecurityDetails>) profileMeterList.get(0);
			security.setSecurityQuestion1(userSecureDetailsList.get(0).getSecurityQuestion());
			security.setSecurityAnswer1(userSecureDetailsList.get(0).getSecurityAnswer());
			security.setSecurityQuestion2(userSecureDetailsList.get(1).getSecurityQuestion());
			security.setSecurityAnswer2(userSecureDetailsList.get(1).getSecurityAnswer());
		    if(userSecureDetailsList!=null) {
		    	Service service = new Service();
		    	if(null==security.getSecurityQuestion1()||null==security.getSecurityAnswer1()) { 
		    	 if(null==security.getSecurityQuestion2()|| null==security.getSecurityAnswer2()) {
		    		service.setStatus("Please Fill All Questions and Answers");
		    		dashBoardProfileList.add(service);
		    	 }
		    	}
		    	else if(null==security.getSecurityQuestion1()&& null==security.getSecurityAnswer1()){
		    		service.setStatus("question1 and answer1 is missed");
		    		dashBoardProfileList.add(service);
		    	}else if(null==security.getSecurityQuestion2()&& null==security.getSecurityAnswer2()){
		    		service.setStatus("question2 and answer2 is missed");
		    		dashBoardProfileList.add(service);
		    	}else{
		    		service.setStatus("everything is fine ");
		    		dashBoardProfileList.add(service);
		    	}
	         }
	  List<UserProfile> userProfileList=(List<UserProfile>) profileMeterList.get(1);		  Service service = new Service();
	  	if(null==userProfileList.get(0)){
	  		service.setStatus("You!!! missed to add Secondary Email Address");
	  		dashBoardProfileList.add(service);
	  	}
	  List<UserReferenceData> userOrcIdList=(List<UserReferenceData>) profileMeterList.get(2);
	   	if(null==userOrcIdList.get(0)){
	   		Service serviceOrciId = new Service();
	    	serviceOrciId.setStatus("You!!! are Not Linked with OrcId..");
			dashBoardProfileList.add(serviceOrciId);
		}
	return dashBoardProfileList;
	}

}
