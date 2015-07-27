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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.AccessReasons;
import com.wiley.gr.ace.authorservices.model.CacheData;
import com.wiley.gr.ace.authorservices.model.Department;
import com.wiley.gr.ace.authorservices.model.DropDown;
import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Role;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.model.external.RetrieveSecurityQuestions;
import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;
import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
import com.wiley.gr.ace.authorservices.persistence.services.LookUpValuesDAO;
import com.wiley.gr.ace.authorservices.persistence.services.SocietyDao;
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

    /** getting bean of userProfiles. */
    @Autowired
    private UserProfiles userProfiles;

    /** getting bean of societyDao. */
    @Autowired(required = true)
    private SocietyDao societyDao;

    /** The user management. */
    @Autowired(required = true)
    private UserManagement userManagement;

    /**
     * This will call external service to get titles data.
     *
     * @return the titles
     */
    @Override
    public final List<CacheData> getTitles() {
        LOGGER.info("inside getTitles method ");

        List<LookupValues> lookupList = aSDataDAO.getDropDown("TITLE");
        List<CacheData> titleList = new ArrayList<CacheData>();
        for (LookupValues lookupValues : lookupList) {
            CacheData title = new CacheData();
            title.setCode(lookupValues.getLookupName());
            title.setName(lookupValues.getLookupValue());
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
    public final List<CacheData> getSuffixes() {
        LOGGER.info("inside getSuffixes method ");

        List<LookupValues> lookupList = aSDataDAO.getDropDown("SUFFIX");
        List<CacheData> suffixList = new ArrayList<CacheData>();
        for (LookupValues lookupValues : lookupList) {
            CacheData suffix = new CacheData();
            suffix.setCode(lookupValues.getLookupName());
            suffix.setName(lookupValues.getLookupValue());
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
    @Override
    public final List<CacheData> getIndustries() {
        LOGGER.info("inside getIndustries method ");

        List<CacheData> industryList = new ArrayList<CacheData>();
        Industries industries = userProfiles.getIndustries();
        if (null == industries) {
            return industryList;
        }

        List<Object> industryDocs = industries.getResponse().getDocs();
        for (Object object : industryDocs) {

            LinkedHashMap<String, String> industryMap = (LinkedHashMap<String, String>) object;
            CacheData industry = new CacheData();
            industry.setCode(industryMap.get("NAICS_CODE"));
            industry.setName(industryMap.get("NAICS_TITLE"));
            industryList.add(industry);
        }

        return industryList;
    }

    /**
     * This will call external service to get JobCategories data.
     *
     * @param count
     *            the count
     * @return the job categories
     */
    @Override
    public final List<CacheData> getJobCategories() {

        LOGGER.info("inside getJobCategories method ");
        JobCategories jobCategories = userProfiles.getJobCategories();
        List<CacheData> jobCategoryList = new ArrayList<CacheData>();
        if (null == jobCategories) {
            return jobCategoryList;
        }

        List<Object> jobCategoryDocs = jobCategories.getResponse().getDocs();
        for (Object object : jobCategoryDocs) {

            LinkedHashMap<String, String> jobCategoryMap = (LinkedHashMap<String, String>) object;
            CacheData jobCategory = new CacheData();
            jobCategory.setCode(jobCategoryMap.get("JOBCODE"));
            jobCategory.setName(jobCategoryMap.get("JOBTITLE"));
            jobCategoryList.add(jobCategory);
        }

        return jobCategoryList;
    }

    /**
     * This will call external service to get Countries data.
     *
     * @param count
     *            the count
     * @return the countries
     */
    @Override
    public final List<CacheData> getCountries() {

        LOGGER.info("inside getCountries method ");
        ESBResponse countrieslist = userProfiles.getCountries();
        List<CacheData> countrylist = new ArrayList<CacheData>();

        List<Object> externalCountrylist = countrieslist.getResponse()
                .getDocs();
        if (null == externalCountrylist) {
            return countrylist;
        }
        for (Object object : externalCountrylist) {
            LinkedHashMap<String, String> countrymap = (LinkedHashMap<String, String>) object;
            CacheData cacheData = new CacheData();
            cacheData.setName(countrymap.get("COUNTRY_NAME"));
            cacheData.setCode(countrymap.get("ISO_ALPHA_3"));
            countrylist.add(cacheData);
        }

        return countrylist;
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
    @Override
    public final List<CacheData> getStates(final String countrycode) {

        LOGGER.info("inside getStates method ");
        ESBResponse statelistext = userProfiles.getStates();
        List<CacheData> modelststelist = new ArrayList<CacheData>();

        List<Object> externalstatelist = statelistext.getResponse().getDocs();
        if (null == externalstatelist) {
            return modelststelist;
        }

        for (Object statelist : externalstatelist) {

            LinkedHashMap<String, String> statemap = (LinkedHashMap<String, String>) statelist;

            CacheData state = new CacheData();
            String externalcountrymap = statemap.get("id");
            String[] idsplit = externalcountrymap.split("_");
            state.setCode(idsplit[2]);
            state.setName(statemap.get("SUBDIVISION_NAME"));
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
    public final List<CacheData> getInstitutions() {

        LOGGER.info("inside getInstitutions method ");

        DropDown dropDown = userProfiles.getInstitutionsList();
        List<Institution> listofinstitute = dropDown.getInstitutions();
        List<CacheData> institutionslist = new ArrayList<CacheData>();

        for (Institution institute : listofinstitute) {

            CacheData institution = new CacheData();
            institution.setCode(institute.getInstitutionId());
            institution.setName(institute.getInstitutionName());
            institutionslist.add(institution);

        }

        return institutionslist;
    }

    /**
     * This will call external service to get Departments data.
     *
     * @return the departments
     */
    @Override
    public final List<CacheData> getDepartments() {

        LOGGER.info("inside getDepartments method ");

        DropDown dropDown = userProfiles.getDepartmentsList();
        List<Department> listofdepartment = dropDown.getDepartments();
        List<CacheData> departmentlist = new ArrayList<CacheData>();
        for (Department department : listofdepartment) {

            CacheData departments = new CacheData();
            departments.setCode(department.getDepartmentId());
            departments.setName(department.getDepartmentName());
            departmentlist.add(departments);

        }
        return departmentlist;
    }

    /**
     * This will call external service to get ResearchFunders data.
     *
     * @return the research funders
     */
    @Override
    public final List<CacheData> getResearchFunders() {
        LOGGER.info("inside getResearchFunders method ");

        DropDown dropDown = userProfiles.getReasearchFunder();
        List<ResearchFunder> researchFunder = dropDown.getResearchFunders();
        List<CacheData> researchfunderlist = new ArrayList<CacheData>();

        for (ResearchFunder researchFunders : researchFunder) {

            CacheData resFunder = new CacheData();
            resFunder.setCode(researchFunders.getResearchFunderId().toString());
            resFunder.setName(researchFunders.getResearchFunderName());
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
    public final List<CacheData> getSocieties() {
        List<Societies> SocietyListDao = societyDao.getSociety();
        List<CacheData> societyList = new ArrayList<CacheData>();

        for (Societies societies : SocietyListDao) {
            CacheData society = new CacheData();
            society.setCode(societies.getSocietyName());
            society.setName(societies.getSocietyCd());
            societyList.add(society);
        }
        return societyList;

    }

    /**
     * This will call external service to get AreasOfInterests data.
     *
     * @param count
     *            the count
     * @return the areas of interests
     */
    @Override
    public final List<CacheData> getAreasOfInterests() {
        LOGGER.info("inside getAreasOfInterests method ");
        ESBResponse areaOfInterests = userProfiles.getAreaOfInterests();
        List<Object> externalInterests = areaOfInterests.getResponse()
                .getDocs();
        List<CacheData> returnList = new ArrayList<CacheData>();
        if (null == externalInterests) {
            return returnList;
        }

        for (Object docs : externalInterests) {
            LinkedHashMap<String, String> interest = (LinkedHashMap<String, String>) docs;
            CacheData interests = new CacheData();
            interests.setCode(interest.get("SUBJECT_CODE"));
            interests.setName(interest.get("SUBJECT_NAME"));
            returnList.add(interests);
        }
        return returnList;

    }

    /**
     * This will call external service to get SecurityQuestions data.
     *
     * @return the security questions
     */
    @Override
    public final RetrieveSecurityQuestions getSecurityQuestions() {

        LOGGER.info("inside getSecurityQuestions method ");
        return userManagement.lookupSecutityQuestions();
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

        List<Roles> daoRolesList = aSDataDAO.getAdminRoles(roleType);
        List<Role> adminRoles = new ArrayList<Role>();
        Role adminRole = null;

        if (daoRolesList != null && !daoRolesList.isEmpty()) {

            for (Roles roles : daoRolesList) {
                adminRole = new Role();
                adminRole.setRoleId(roles.getRoleId() + "");
                adminRole.setRoleName(roles.getRoleName());
                adminRole.setRoleDescription(roles.getDescription());
                if (roles.getRoleType() != null
                        && AuthorServicesConstants.ROLE_TYPE_INTERNAL
                                .equals(roles.getRoleType())) {
                    adminRole.setAdminRole(true);
                }
                adminRole.setNoOfPermissions(String.valueOf(aSDataDAO
                        .getCount(roles.getRoleId())));
                adminRoles.add(adminRole);
            }

        }
        return adminRoles;
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

}
