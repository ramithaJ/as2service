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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.services.service.DashBoardService;

/**
 * @author yugandhark
 *
 */
@RestController
@RequestMapping("/dashboard")
public class DashBoardController {
	
	
//	@RequestMapping(value = "/viewAllAuthorArticles", method = RequestMethod.GET, produces = "application/json")
//	public List<Article> getAllAuthorArticles(){
//		DashBoardService dashBoardService=(DashBoardServiceImpl)context.getBean("DashBoardService");
//		return dashBoardService.getAllAuthorArticles();
//	}
	
	@Autowired(required=true)
	DashBoardService  dashBoardService;
	@RequestMapping(value="/getProfileMeter/{userId}",method=RequestMethod.GET,produces="application/json")
	public List<LinkedList> getProfileMeter(@PathVariable("userId") String userId) {
	
		return dashBoardService.getProfileMeter(Integer.parseInt(userId));
  		 
	}
	
}
