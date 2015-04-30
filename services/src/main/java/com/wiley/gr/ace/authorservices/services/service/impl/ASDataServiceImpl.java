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

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.Department;
import com.wiley.gr.ace.authorservices.model.Industry;
import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.JobCategory;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.State;
import com.wiley.gr.ace.authorservices.model.StaticData;
import com.wiley.gr.ace.authorservices.model.Suffix;
import com.wiley.gr.ace.authorservices.model.Title;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.ASDataDAOImpl;
import com.wiley.gr.ace.authorservices.services.service.ASDataService;

/**
 * @author SarmaKumarap
 *
 */
public class ASDataServiceImpl implements ASDataService {

	private static ApplicationContext daoContext = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	ASDataDAO aSDataDAO = (ASDataDAOImpl) daoContext.getBean("ASDataDAO");

	@Override
	public List<Title> getTitles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Suffix> getSuffixes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Industry> getIndustries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobCategory> getJobCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Institution> getInstitutions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResearchFunder> getResearchFunders() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Article> getArticles() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Society> getSocieties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Interests> getAreasOfInterests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StaticData[] getSecurityQuestions() {

		List<String> lookupList = aSDataDAO.getSecurityDetails();
		System.out
				.println("nanu" + lookupList.get(0) + " " + lookupList.get(1));
		ArrayList<StaticData> securityQuestionsList = new ArrayList<StaticData>();
		for (int i = 0; i <= 19; i++) {
			System.out.println("hello" + i);
			StaticData staticData = new StaticData();
			staticData.setId(lookupList.get(i));
			staticData.setDescription(lookupList.get(++i));
			System.out.println("hi" + i);
			securityQuestionsList.add(staticData);
		}
		System.out.println("nani" + securityQuestionsList.get(0) + " "
				+ securityQuestionsList.get(1) + " "
				+ securityQuestionsList.size());
		return (StaticData[]) securityQuestionsList
				.toArray(new StaticData[securityQuestionsList.size()]);
	}

}
