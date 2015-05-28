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
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.AccessReasons;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.Department;
import com.wiley.gr.ace.authorservices.model.Industry;
import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.Interests;
import com.wiley.gr.ace.authorservices.model.JobCategory;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Role;
import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.State;
import com.wiley.gr.ace.authorservices.model.Suffix;
import com.wiley.gr.ace.authorservices.model.Title;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
import com.wiley.gr.ace.authorservices.persistence.services.LookUpValuesDAO;
import com.wiley.gr.ace.authorservices.services.service.ASDataService;

/**
 * @author SarmaKumarap
 */
public class ASDataServiceImpl implements ASDataService {

	@Autowired(required = true)
	ASDataDAO aSDataDAO;
	@Autowired(required = true)
	LookUpValuesDAO lookupDAO;
	@Autowired
	CDMInterfaceService cdmservice;

	@Override
	public List<Title> getTitles() {

		List<LookupValues> lookupList = aSDataDAO.getDropDown("TITLE");
		List<Title> titleList = new ArrayList<Title>();
		Title title = null;
		for (LookupValues lookupValues : lookupList) {

			title = new Title();
			title.setTitleId(lookupValues.getLookupName());
			title.setTitleName(lookupValues.getLookupValue());
			titleList.add(title);
		}
		return titleList;
	}

	@Override
	public List<Suffix> getSuffixes() {

		List<LookupValues> lookupList = aSDataDAO.getDropDown("SUFFIX");
		List<Suffix> suffixList = new ArrayList<Suffix>();
		Suffix suffix = null;
		for (LookupValues lookupValues : lookupList) {

			suffix = new Suffix();
			suffix.setSuffixId(lookupValues.getLookupName());
			suffix.setSuffixName(lookupValues.getLookupValue());
			suffixList.add(suffix);
		}
		return suffixList;
	}

	@Override
	public List<Industry> getIndustries() {

		Industry industry = null;
		List<Industry> industryList = new ArrayList<Industry>();
		Industries industries = cdmservice.getIndustries();
		if (null == industries) {
			return new ArrayList<Industry>();
		}

		List<Object> industryDocs = industries.getResponse().getDocs();
		for (Object object : industryDocs) {

			LinkedHashMap<String, String> industryMap = (LinkedHashMap<String, String>) object;
			industry = new Industry();
			industry.setIndustryId(industryMap.get("NAICS_CODE"));
			industry.setIndustryName(industryMap.get("NAICS_TITLE"));
			industryList.add(industry);
		}

		return industryList;
	}

	@Override
	public List<JobCategory> getJobCategories() {

		JobCategories jobCategories = cdmservice.getJobCategories();
		JobCategory jobCategory = null;
		List<JobCategory> jobCategoryList = new ArrayList<JobCategory>();
		if (null == jobCategories) {
			return null;
		}

		List<Object> jobCategoryDocs = jobCategories.getResponse().getDocs();
		for (Object object : jobCategoryDocs) {

			LinkedHashMap<String, String> jobCategoryMap = (LinkedHashMap<String, String>) object;
			jobCategory = new JobCategory();
			jobCategory.setJobCategoryId(jobCategoryMap.get("JOBCODE"));
			jobCategory.setJobCategoryName(jobCategoryMap.get("JOBTITLE"));
			jobCategoryList.add(jobCategory);
		}
		return jobCategoryList;
	}

	@Override
	public List<Country> getCountries() {
		List<ESBResponse> countrieslist = cdmservice.getCountries();
		List<Country> countrylist = new ArrayList<Country>();
		for (int i = 0; i < countrieslist.size(); i++) {
			List<Object> externalCountrylist = countrieslist.get(i)
					.getResponse().getDocs();
			if (null == externalCountrylist) {
				return null;
			}
			for (Object object : externalCountrylist) {
				LinkedHashMap<String, String> countrymap = (LinkedHashMap<String, String>) object;
				Country country = new Country();

				String externalcountrymap = countrymap.get("id");
				String[] idsplit = externalcountrymap.split("_");
				country.setCountryCode(idsplit[1]);
				country.setCountryName(countrymap.get("COUNTRY_NAME"));

				countrylist.add(country);

			}
		}

		return countrylist;
	}

	@Override
	public List<State> getStates(String countrycode) {
		List<ESBResponse> statelistext = cdmservice.getStates();
		List<State> modelststelist = new ArrayList<State>();
		for (int i = 0; i < statelistext.size(); i++) {
			List<Object> externalstatelist = statelistext.get(i).getResponse()
					.getDocs();
			if (null == externalstatelist) {
				return null;

			}
			for (Object statelist : externalstatelist) {

				LinkedHashMap<String, String> statemap = (LinkedHashMap<String, String>) statelist;

				State state = new State();
				state.setStateCode(statemap.get("id"));
				state.setStateName(statemap.get("SUBDIVISION_NAME"));
				modelststelist.add(state);
			}

		}
		return modelststelist;
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

	// @Override
	// public List<Article> getArticles() {
	// // TODO Auto-generated method stub
	// return null;
	// }

	@Override
	public List<Society> getSocieties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Interests> getAreasOfInterests() {
		List<ESBResponse> areaOfInterests = cdmservice.getAreaOfInterests();
		List<Object> externalInterests = areaOfInterests.get(0).getResponse()
				.getDocs();
		if (null == externalInterests) {
			return null;
		}
		List<Interests> returnList = new ArrayList<Interests>();

		for (Object docs : externalInterests) {
			LinkedHashMap<String, String> interest = (LinkedHashMap<String, String>) docs;
			Interests interests = new Interests();
			interests.setAoeId(interest.get("SUBJECT_CODE"));
			interests.setAoeName(interest.get("SUBJECT_NAME"));
			returnList.add(interests);
		}
		return returnList;

	}

	@Override
	public List<SecurityDetails> getSecurityQuestions() {

		List<LookupValues> lookupList = aSDataDAO.getDropDown("SEQ");
		List<SecurityDetails> securityQuestionsList = new ArrayList<SecurityDetails>();
		SecurityDetails securityDetails = null;
		for (LookupValues lookupValues : lookupList) {

			securityDetails = new SecurityDetails();
			securityDetails.setSecurityQuestionId(lookupValues.getLookupName());
			securityDetails.setSecurityQuestion(lookupValues.getLookupValue());
			securityQuestionsList.add(securityDetails);
		}
		return securityQuestionsList;
	}

	@Override
	public List<Role> getAdminRoles(String roleType) {

		List<Roles> daoRolesList = aSDataDAO.getAdminRoles(roleType);
		List<Role> adminRoles = new ArrayList<Role>();
		Role adminRole = null;

		if (daoRolesList != null && daoRolesList.size() > 0) {

			for (Roles roles : daoRolesList) {
				adminRole = new Role();
				adminRole.setRoleId(roles.getRoleId() + "");
				adminRole.setRoleName(roles.getRoleName());
				adminRole.setRoleDescription(roles.getDescription());
				if (roles.getRoleType() != null
						&& roles.getRoleType().equals(
								AuthorServicesConstants.ROLE_TYPE_INTERNAL)) {
					adminRole.setAdminRole(true);
				}
				adminRoles.add(adminRole);
			}

		}
		return adminRoles;
	}

	@Override
	public List<AccessReasons> getAccessReasons() {

		List<LookupValues> daoList = lookupDAO
				.getLookUpData(AuthorServicesConstants.ADM_ACC_LOOKUP_KEY);
		List<AccessReasons> accessList = new ArrayList<AccessReasons>();
		AccessReasons accessReason = null;

		if (daoList != null) {

			for (LookupValues lookupValues : daoList) {
				accessReason = new AccessReasons();
				accessReason.setAccessId(lookupValues.getLookupName());
				accessReason.setAccessReason(lookupValues.getLookupValue());
				accessList.add(accessReason);
			}

		}
		return accessList;
	}

}
