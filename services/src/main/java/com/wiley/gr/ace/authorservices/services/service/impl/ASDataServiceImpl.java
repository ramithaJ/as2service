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
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
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

    /** getting bean of userProfiles. */
    @Autowired
    private UserProfiles userProfiles;

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
    @Override
    public final List<Industry> getIndustries(final Integer count) {
        LOGGER.info("inside getIndustries method ");

        Industry industry = null;
        List<Industry> industryList = new ArrayList<Industry>();
        Industries industries = userProfiles.getIndustries();
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

        return industryList.subList(0, count);
    }

    /**
     * This will call external service to get JobCategories data.
     *
     * @param count
     *            the count
     * @return the job categories
     */
    @Override
    public final List<JobCategory> getJobCategories(final Integer count) {

        LOGGER.info("inside getJobCategories method ");
        JobCategories jobCategories = userProfiles.getJobCategories();
        JobCategory jobCategory = null;
        List<JobCategory> jobCategoryList = new ArrayList<JobCategory>();
        if (null == jobCategories) {
            return jobCategoryList;
        }

        List<Object> jobCategoryDocs = jobCategories.getResponse().getDocs();
        for (Object object : jobCategoryDocs) {

            LinkedHashMap<String, String> jobCategoryMap = (LinkedHashMap<String, String>) object;
            jobCategory = new JobCategory();
            jobCategory.setJobCategoryId(jobCategoryMap.get("JOBCODE"));
            jobCategory.setJobCategoryName(jobCategoryMap.get("JOBTITLE"));
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
            LinkedHashMap<String, String> countrymap = (LinkedHashMap<String, String>) object;
            Country country = new Country();
            country.setCountryCode(countrymap.get("ISO_ALPHA_3"));
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
    @Override
    public final List<State> getStates(final String countrycode,
            final Integer count) {

        LOGGER.info("inside getStates method ");
        ESBResponse statelistext = userProfiles.getStates();
        List<State> modelststelist = new ArrayList<State>();

        List<Object> externalstatelist = statelistext.getResponse().getDocs();
        if (null == externalstatelist) {
            return modelststelist;
        }

        for (Object statelist : externalstatelist) {

            LinkedHashMap<String, String> statemap = (LinkedHashMap<String, String>) statelist;

            State state = new State();
            String externalcountrymap = statemap.get("id");
            String[] idsplit = externalcountrymap.split("_");
            state.setStateCode(idsplit[2]);
            state.setStateName(statemap.get("SUBDIVISION_NAME"));
            modelststelist.add(state);
        }

        return modelststelist.subList(0, count);
    }

    /**
     * This will call external service to get Institutions data.
     *
     * @return the institutions
     */
    @Override
    public final List<Institution> getInstitutions() {

        LOGGER.info("inside getInstitutions method ");

        DropDown dropDown = userProfiles.getInstitutionsList();
        List<Institution> listofinstitute = dropDown.getInstitutions();
        List<Institution> institutionslist = new ArrayList<Institution>();

        for (Institution institute : listofinstitute) {

            Institution institution = new Institution();
            institution.setInstitutionId(institute.getInstitutionId());
            institution.setInstitutionName(institute.getInstitutionName());
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
    public final List<Department> getDepartments() {

        LOGGER.info("inside getDepartments method ");

        DropDown dropDown = userProfiles.getDepartmentsList();
        List<Department> listofdepartment = dropDown.getDepartments();
        List<Department> departmentlist = new ArrayList<Department>();
        for (Department department : listofdepartment) {

            Department departments = new Department();
            departments.setDepartmentId(department.getDepartmentId());
            departments.setDepartmentName(department.getDepartmentName());
            departmentlist.add(department);

        }
        return departmentlist;
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
     * This will call external service to get Societies data.
     *
     * @return the societies
     */
    @Override
    public final List<Society> getSocieties() {

        LOGGER.info("inside getSocieties method ");
        DropDown dropDown = userProfiles.getSocietyList();
        List<Society> listofsociety = dropDown.getSociety();
        List<Society> societylist = new ArrayList<Society>();
        for (Society societys : listofsociety) {

            Society society = new Society();
            society.setSocietyId(societys.getSocietyId());

            society.setSocietyName(societys.getSocietyName());
            societylist.add(society);
        }
        return societylist;
    }

    /**
     * This will call external service to get AreasOfInterests data.
     *
     * @param count
     *            the count
     * @return the areas of interests
     */
    @Override
    public final List<Interests> getAreasOfInterests(final Integer count) {
        LOGGER.info("inside getAreasOfInterests method ");
        ESBResponse areaOfInterests = userProfiles.getAreaOfInterests();
        List<Object> externalInterests = areaOfInterests.getResponse()
                .getDocs();
        List<Interests> returnList = new ArrayList<Interests>();
        if (null == externalInterests) {
            return returnList;
        }

        for (Object docs : externalInterests) {
            LinkedHashMap<String, String> interest = (LinkedHashMap<String, String>) docs;
            Interests interests = new Interests();
            interests.setAoeId(interest.get("SUBJECT_CODE"));
            interests.setAoeName(interest.get("SUBJECT_NAME"));
            returnList.add(interests);
        }
        return returnList.subList(0, count);

    }

    /**
     * This will call external service to get SecurityQuestions data.
     *
     * @return the security questions
     */
    @Override
    public final List<SecurityDetails> getSecurityQuestions() {

        LOGGER.info("inside getSecurityQuestions method ");

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
