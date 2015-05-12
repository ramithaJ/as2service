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

import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.DashBoard;
import com.wiley.gr.ace.authorservices.persistence.entity.ResearchFunders;
import com.wiley.gr.ace.authorservices.persistence.entity.SocietyDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDAO;
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;

public class DashBoardServiceImpl implements DashBoardService {

	@Autowired(required = true)
	DashBoardDAO dashBoardDAO;

	@Override
	public List<Service> getProfileMeter(int userId)  {
		List<Service> dashBoardProfileList = new LinkedList<Service>();
	    DashBoard dashBoard=dashBoardDAO.getProfileMeter(userId);
	    if(dashBoard!=null){
	     List<UserSecurityDetails> userSecureDetails=dashBoard.getUserSecurityDetails();
		 if(userSecureDetails!=null) {
		     for(UserSecurityDetails secureDetails:userSecureDetails) {
			    SecurityDetails security = new SecurityDetails();
			    security.setSecurityQuestion(secureDetails.getSecurityQuestion());
			    security.setSecurityAnswer(secureDetails.getSecurityAnswer());
			     if (security != null) {
				    Service service = new Service();
		    		if (null == security.getSecurityQuestion() || null == security.getSecurityAnswer()) {
		    			   service.setStatus("Security Questions");
		    			     service.setPayload(security);
				    		dashBoardProfileList.add(service);
				    		break;
				    }
				}
		     }
		} 	
		 List<AuthorProfile> authorMissedProfieList=dashBoard.getAuthorProfileList();
		 if(authorMissedProfieList!=null){
			 AuthorProfile authorProfile=null;
			 Service service = new Service();
			 if(null==authorMissedProfieList.get(0)&&null==authorMissedProfieList.get(1)&&null==authorMissedProfieList.get(2))
				 service.setStatus("Set up your OrcidId , Secondary Email address ,Check is Your Accound Verified or Not");			    			
	    		service.setPayload(authorProfile);
	    		dashBoardProfileList.add(service);
		     }
		 
	    }
	    List<LinkedList> authorMissedAffiliationList=dashBoard.getAffiliation();
	    if(null!=authorMissedAffiliationList){
	    if(null==authorMissedAffiliationList.get(0)){
	    	Service service = new Service();
	    	service.setStatus("Add Affiliations");
	    	dashBoardProfileList.add(service);
	    }
	    }
	    List<LinkedList> areasOfExpertiseList=dashBoard.getAreaOfExpertise();
	    if(null!=areasOfExpertiseList){
	    if(null==areasOfExpertiseList.get(0)){
	    	Service service = new Service();
	    	service.setStatus("Add in which Area Of Expertise");
	    	dashBoardProfileList.add(service);
	    }
	    }
	    List<SocietyDetails> missedSocietyList=dashBoard.getSocietyDetails();
	    if(null!=missedSocietyList){
	    if(null==missedSocietyList.get(0)){
	    	Service service = new Service();
	    	service.setStatus("Add Society Details");
	    	dashBoardProfileList.add(service);
	    }
	    }
	    List<ResearchFunders> researchFundersList=dashBoard.getResearchFunder();
	    if(null!=researchFundersList){
	    if(null==researchFundersList.get(0)){
	    	Service service = new Service();
	    	service.setStatus("Add Funder Details ");
	    	dashBoardProfileList.add(service);
	    }
	    }
//	    List<ResearchFunders> userFunderList=dashBoard.getResearchFunder();
//	    if(userFunderList!=null){
//	    	for(UserFunderGrants userFunders:userFunderList){
//	    		if(null==userFunders.getAuthorProfile().getUserId()&&null==userFunders.getResearchFunders().getRfunderId()){
//	    			Service service = new Service();
//	    			service.setPayload(userFunders);
//		    		dashBoardProfileList.add(service);
//		    		break;
//	    		}
//	    	}
//	    }
	   
		return dashBoardProfileList;
	}

}
		
	
