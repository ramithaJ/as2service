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
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.AccessReasons;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.Department;
import com.wiley.gr.ace.authorservices.model.DropDown;
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
import com.wiley.gr.ace.authorservices.model.external.RetrieveSecurityQuestions;
import com.wiley.gr.ace.authorservices.persistence.entity.AreaOfInterest;
import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
import com.wiley.gr.ace.authorservices.persistence.services.AreaOfInterterestDao;
import com.wiley.gr.ace.authorservices.persistence.services.LookUpValuesDAO;
import com.wiley.gr.ace.authorservices.services.service.ASDataService;

/**
 * The Class ASDataServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class ASDataServiceImpl implements ASDataService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ASDataServiceImpl.class);

    /** getting bean of asdata dao. */
    @Autowired(required = true)
    private ASDataDAO aSDataDAO;

    /** getting bean of lookupDAO. */
    @Autowired(required = true)
    private LookUpValuesDAO lookupDAO;

    /** The area of interest dao . */
    @Autowired(required = true)
    private AreaOfInterterestDao areaOfInterest;

    /** getting bean of userProfiles. */
    @Autowired
    private UserProfiles userProfiles;

    /** The industry code. */
    @Value("${industry.code}")
    private String industryCode;

    /** The industry name. */
    @Value("${industry.name}")
    private String industryName;

    /** The job category code. */
    @Value("${jobCategories.code}")
    private String jobCategoryCode;

    /** The job category name. */
    @Value("${jobCategories.name}")
    private String jobCategoryName;

    /**
     * This field holds the value of stateCode.
     */
    @Value("${state.code}")
    private String stateCode;

    /** The state name. */
    @Value("${state.Name}")
    private String stateName;

    /** The user management. */
    @Autowired(required = true)
    private UserManagement userManagement;

    /**
     * This will call external service to get titles data.
     *
     * @return the titles
     */
    @Override
    public final List<Title> getTitles() {
        LOGGER.info("inside getTitles method ");

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

    /**
     * This will call external service to get Suffixes data.
     *
     * @return the suffixes
     */
    @Override
    public final List<Suffix> getSuffixes() {
        LOGGER.info("inside getSuffixes method ");

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

    /**
     * This will call external service to get Industries data.
     *
     * @param count
     *            the count
     * @return the industries
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<Industry> getIndustries(final Integer count) {
        LOGGER.info("inside getIndustries method ");

        Industry industry = null;
        List<Industry> industryList = new ArrayList<Industry>();
        ESBResponse industries = userProfiles.getIndustries();
        if (null == industries) {
            return new ArrayList<Industry>();
        }

        List<Object> industryDocs = industries.getResponse().getDocs();
        for (Object object : industryDocs) {

            Map<String, String> industryMap = (LinkedHashMap<String, String>) object;
            industry = new Industry();
            industry.setIndustryId(industryMap.get(industryCode));
            industry.setIndustryName(industryMap.get(industryName));
            industryList.add(industry);
        }

        return industryList.subList(0, count);
    }

    /**
     * This will call external service to get JobCategories data.
     *
     * @param count
     *            the count
     * @return the job categories
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<JobCategory> getJobCategories(final Integer count) {

        LOGGER.info("inside getJobCategories method ");
        ESBResponse jobCategories = userProfiles.getJobCategories();
        JobCategory jobCategory = null;
        List<JobCategory> jobCategoryList = new ArrayList<JobCategory>();
        if (null == jobCategories) {
            return jobCategoryList;
        }

        List<Object> jobCategoryDocs = jobCategories.getResponse().getDocs();
        for (Object object : jobCategoryDocs) {

            Map<String, String> jobCategoryMap = (LinkedHashMap<String, String>) object;
            jobCategory = new JobCategory();
            jobCategory.setJobCategoryId(jobCategoryMap.get(jobCategoryCode));
            jobCategory.setJobCategoryName(jobCategoryMap.get(jobCategoryName));
            jobCategoryList.add(jobCategory);
        }

        return jobCategoryList.subList(0, count);
    }

    /**
     * This will call external service to get Countries data.
     *
     * @param count
     *            the count
     * @return the countries
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<Country> getCountries(final Integer count) {

        LOGGER.info("inside getCountries method ");
        ESBResponse countrieslist = userProfiles.getCountries();
        List<Country> countrylist = new ArrayList<Country>();

        List<Object> externalCountrylist = countrieslist.getResponse()
                .getDocs();
        if (null == externalCountrylist) {
            return countrylist;
        }
        for (Object object : externalCountrylist) {
            Map<String, String> countrymap = (LinkedHashMap<String, String>) object;
            Country country = new Country();

            String externalcountrymap = countrymap.get("id");
            String[] idsplit = externalcountrymap.split("_");
            country.setCountryCode(idsplit[1]);
            country.setCountryName(countrymap.get("COUNTRY_NAME"));
            countrylist.add(country);
        }

        return countrylist.subList(0, count);
    }

    /**
     * This will call external service to get States data.
     *
     * @param countrycode
     *            the countrycode
     * @param count
     *            the count
     * @return the states
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<State> getStates(final String countrycode) {

        LOGGER.info("inside getStates method ");
        ESBResponse statelistext = userProfiles.getStates(countrycode);
        List<State> modelststelist = new ArrayList<State>();

        List<Object> externalstatelist = statelistext.getResponse().getDocs();
        if (null == externalstatelist) {
            return modelststelist;
        }

        for (Object statelist : externalstatelist) {

            Map<String, String> statemap = (LinkedHashMap<String, String>) statelist;

            State state = new State();
            state.setStateCode(statemap.get(stateCode));
            state.setStateName(statemap.get(stateName));
            modelststelist.add(state);
        }

        return modelststelist;
    }

    /**
     * This will call external service to get Institutions data.
     *
     * @return the institutions
     */
    @Override
    public final List<Institution> getInstitutions() {

        LOGGER.info("inside getInstitutions method ");

        return new ArrayList<Institution>();
    }

    /**
     * This will call external service to get Departments data.
     *
     * @return the departments
     */
    @Override
    public final List<Department> getDepartments() {

        LOGGER.info("inside getDepartments method ");

        return new ArrayList<Department>();
    }

    /**
     * This will call external service to get ResearchFunders data.
     *
     * @return the research funders
     */
    @Override
    public final List<ResearchFunder> getResearchFunders() {
        LOGGER.info("inside getResearchFunders method ");

        DropDown dropDown = userProfiles.getReasearchFunder();
        List<ResearchFunder> researchFunder = dropDown.getResearchFunders();
        List<ResearchFunder> researchfunderlist = new ArrayList<ResearchFunder>();

        for (ResearchFunder researchFunders : researchFunder) {

            ResearchFunder resFunder = new ResearchFunder();
            resFunder
                    .setResearchFunderId(researchFunders.getResearchFunderId());
            resFunder.setResearchFunderName(researchFunders
                    .getResearchFunderName());
            researchfunderlist.add(resFunder);
        }

        return researchfunderlist;
    }

    /**
     * This will call Dao service to get Societies data.
     *
     * @return the societies
     */
    @Override
    public final List<Society> getSocieties() {
        List<Societies> societyListDao = aSDataDAO.getSociety();
        List<Society> societyList = new ArrayList<Society>();

        for (Societies societies : societyListDao) {
            Society society = new Society();
            society.setSocietyName(societies.getSocietyName());
            society.setSocietyId(societies.getSocietyCd());
            societyList.add(society);
        }
        return societyList;

    }

    /**
     * This will call external service to get AreasOfInterests data.
     *
     * @return the areas of interests
     */
    @Override
    public final List<Interests> getAreasOfInterests() {
        LOGGER.info("inside getAreasOfInterests method ");

        List<AreaOfInterest> areaOfInterestDao = areaOfInterest
                .getAreaOfInterest();
        List<Interests> interestList = new ArrayList<Interests>();
        for (AreaOfInterest areaOfInterest : areaOfInterestDao) {
            Interests interests = new Interests();
            interests.setAoeId(areaOfInterest.getAreaOfInterestCd());
            interests.setAoeName(areaOfInterest.getInterestName());
            interestList.add(interests);
        }
        return interestList;

    }

    /**
     * This will call external service to get SecurityQuestions data.
     *
     * @return the security questions
     */
    @Override
    public final List<SecurityDetails> getSecurityQuestions() {

        LOGGER.info("inside getSecurityQuestions method ");
        List<SecurityDetails> securityDetailsList = new ArrayList<SecurityDetails>();
        SecurityDetails securityDetails = null;
        int i = 0;
        RetrieveSecurityQuestions retrieveSecurityQuestions = userManagement
                .lookupSecutityQuestions();
        List<String> retrieveSecurityQuestionsList = retrieveSecurityQuestions
                .getSystemSecurityQuestions().getSecurityQuestionList();
        for (String list : retrieveSecurityQuestionsList) {

            securityDetails = new SecurityDetails();
            securityDetails.setSecurityQuestionId("SecurityQuestion" + (++i));
            securityDetails.setSecurityQuestion(list);
            securityDetailsList.add(securityDetails);
        }
        return securityDetailsList;
    }

    /**
     * This will call dao service to get AdminRoles data.
     *
     * @param roleType
     *            the role type
     * @return the admin roles
     */
    @Override
    public final List<Role> getAdminRoles(final String roleType) {

        LOGGER.info("inside getAdminRoles method ");

        return new ArrayList<Role>();
    }

    /**
     * This will call dao service to get AccessReasons data.
     *
     * @return the access reasons
     */
    @Override
    public final List<AccessReasons> getAccessReasons() {

        LOGGER.info("inside getAccessReasons method ");

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

    @Override
    public String getStateByCode(final String stateCode,
            final String countryCode) {

        String code = null;
        List<State> statesList = getStates(countryCode);
        for (State state : statesList) {
            if (stateCode.equalsIgnoreCase(state.getStateCode())) {
                code = state.getStateName();
            }
        }
        return code;
    }
}
