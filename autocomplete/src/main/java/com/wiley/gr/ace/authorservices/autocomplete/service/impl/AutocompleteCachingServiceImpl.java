/**
 * 
 */
package com.wiley.gr.ace.authorservices.autocomplete.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteCachingService;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.CacheData;
import com.wiley.gr.ace.authorservices.model.SubFunder;
import com.wiley.gr.ace.authorservices.model.SubFunderDetails;
import com.wiley.gr.ace.authorservices.model.SubFunders;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.Funder;
import com.wiley.gr.ace.authorservices.model.external.Id;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.model.external.ResearchFundersResponse;

/**
 * AutocompleteCachingServiceImpl provides caching.
 *
 * @author virtusa
 * @version 1.0
 */
public class AutocompleteCachingServiceImpl implements
        AutocompleteCachingService {

    /**
     * Logger Configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AutocompleteCachingServiceImpl.class);

    /** getting bean of userProfiles. */
    @Autowired(required = true)
    private UserProfiles userProfiles;

    /** the industrieskey. */
    @Value("${industries.key}")
    private String industrieskey;

    /** the jobCategorieskey. */
    @Value("${jobCategories.key}")
    private String jobCategorieskey;

    /** the countrieskey. */
    @Value("${countries.key}")
    private String countrieskey;

    /** the institutionskey. */
    @Value("${institutions.key}")
    private String institutionskey;

    /** the departmentskey. */
    @Value("${departments.key}")
    private String departmentskey;

    /** the researchFundersKey. */
    @Value("${researchFunders.key}")
    private String researchFundersKey;

    /** the researchFundersurl. */
    @Value("${researchFundersurl.url}")
    private String researchFundersurl;

    /** the funderContentType. */
    @Value("${funderContentType}")
    private String funderContentType;

    /**
     * This method returns the cached drop down data. If there is no cached
     * data, the corresponding service is invoked and the list is set to the
     * cache and returns the list.
     * 
     * @param dropDownKey
     *            - the input value
     * @param parentId
     *            - the input value
     * @return dropDownList
     */
    @Cacheable(value = "dropDownList", key = "#dropDownKey")
    public final List<String> getCachedData(final String dropDownKey,
            final String parentId) {
        List<String> dropDownList = null;
        List<CacheData> cacheDataList = null;

        if ((industrieskey + "cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::industrieskey::" + dropDownKey);
            cacheDataList = getIndustries();
        } else if ((jobCategorieskey + "cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::jobCategorieskey::" + dropDownKey);
            cacheDataList = getJobCategories();
        } else if ((countrieskey + "cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::countrieskey::" + dropDownKey);
            cacheDataList = getCountries();
        } else if ((institutionskey + "cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::institutionskey::" + dropDownKey);
            cacheDataList = getInstitutions();
        } else if ((departmentskey + "cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::departmentskey::" + dropDownKey);
            cacheDataList = getDepartments(parentId);
        } else if ((researchFundersKey + "cached").equals(dropDownKey)) {
            cacheDataList = getResearchFunders();
        }

        if (cacheDataList != null && !cacheDataList.isEmpty()) {
            dropDownList = new ArrayList<String>();
            for (CacheData cacheData : cacheDataList) {
                dropDownList.add(cacheData.toString());
            }

        }

        return dropDownList;
    }

    /**
     * This method returns ResearchFunders.
     * 
     * @return cacheDataList.
     */
    private List<CacheData> getResearchFunders() {
        ResearchFundersResponse response = null;

        response = (ResearchFundersResponse) RestServiceInvokerUtil.invokeStub(
                researchFundersurl, HttpMethod.GET,
                ResearchFundersResponse.class);

        return getResearchFundersList(response);
    }

    /**
     * This method returns the research funders list.
     * 
     * @param response
     *            - the input value.
     * @return cacheList.
     */
    private List<CacheData> getResearchFundersList(
            final ResearchFundersResponse response) {
        List<CacheData> cacheList = null;

        List<Funder> funderList = response.getFunder();
        Set<String> cacheStringSet = new HashSet<String>();

        if (funderList != null && !funderList.isEmpty()) {

            for (Funder funder : funderList) {
                CacheData cacheData = new CacheData();

                cacheData.setName(funder.getName());
                List<Id> idList = funder.getSecondaryIds().getId();
                for (Id id : idList) {
                    if (funderContentType.equals(id.getType())) {
                        cacheData.setCode(id.getContent());
                        break;
                    }

                    cacheStringSet.add(cacheData.toString());
                }

            }

            cacheList = new ArrayList<CacheData>();
            for (String data : cacheStringSet) {
                try {
                    JSONObject json = (JSONObject) new JSONParser().parse(data);
                    CacheData cacheData = new CacheData();
                    cacheData.setName(json.get("name").toString());
                    cacheData.setCode(json.get("code").toString());
                    cacheList.add(cacheData);
                } catch (ParseException e) {
                    throw new ASException("500", e.getMessage());
                }
            }

        }

        return cacheList;
    }

    /**
     * This method returns ResearchFunders.
     * 
     * @param dropDownKey
     *            - the input value
     * @return cacheDataList.
     */
    @Cacheable(value = "subFunderDetails", key = "#dropDownKey")
    public final SubFunderDetails getCachedSubFunders(final String dropDownKey) {
        ResearchFundersResponse response = null;

        response = (ResearchFundersResponse) RestServiceInvokerUtil.invokeStub(
                researchFundersurl, HttpMethod.GET,
                ResearchFundersResponse.class);

        return getSubFundersList(response);
    }

    /**
     * This Method retrieves the SubFunderDetails.
     * 
     * @param response
     *            - the input value.
     * @return subFunderDetails.
     */
    private SubFunderDetails getSubFundersList(
            final ResearchFundersResponse response) {

        List<Funder> funderList = response.getFunder();
        SubFunderDetails subFunderDetails = null;

        SortedSet<String> doiSet = new TreeSet<String>();
        if (funderList != null && !funderList.isEmpty()) {

            for (Funder funder : funderList) {

                List<Id> idList = funder.getParent().getSecondaryIds().getId();
                for (Id id : idList) {
                    if (funderContentType.equals(id.getType())) {
                        doiSet.add(id.getContent());
                    }
                }
            }

            Map<String, SubFunders> subFundersMap = new HashMap<String, SubFunders>();

            for (String doi : doiSet) {
                SubFunder parentFunder = getParentFunderDetailsByDOI(
                        funderList, doi);
                List<SubFunder> subFunderList = getSubFunderDetailsByDOI(
                        parentFunder, funderList);
                SubFunders subFunders = new SubFunders();
                subFunders.setId(parentFunder.getId());
                subFunders.setName(parentFunder.getName());
                subFunders.setSubFunderList(subFunderList);
                subFundersMap.put(doi, subFunders);
            }
            subFunderDetails = new SubFunderDetails();
            subFunderDetails.setSubFundersMap(subFundersMap);
        }

        return subFunderDetails;
    }

    /**
     * This method returns parent funder details.
     * 
     * @param funderList
     *            - the input value
     * @param doi
     *            - the input value
     * @return parentFunder
     */
    private SubFunder getParentFunderDetailsByDOI(
            final List<Funder> funderList, final String doi) {
        SubFunder parentFunder = null;

        for (Funder funder : funderList) {
            String selectedDoi = funder.getSecondaryIds().getId().get(0)
                    .getContent();
            if (doi.equals(selectedDoi)) {
                parentFunder = new SubFunder();
                parentFunder.setDoi(selectedDoi);
                parentFunder.setId(funder.getId());
                parentFunder.setName(funder.getName());
                break;
            }
        }

        return parentFunder;
    }

    /**
     * This method returns the SubFunderList if available.
     * 
     * @param parentFunder
     *            - the input value.
     * @param funderList
     *            - the input value.
     * @return subFunderList.
     */
    private List<SubFunder> getSubFunderDetailsByDOI(
            final SubFunder parentFunder, final List<Funder> funderList) {
        List<SubFunder> subFunderList = new ArrayList<SubFunder>();

        for (Funder funder : funderList) {
            String selectedDoi = funder.getParent().getSecondaryIds().getId()
                    .get(0).getContent();
            if (parentFunder.getDoi().equals(selectedDoi)) {
                SubFunder subFunder = new SubFunder();
                subFunder.setDoi(funder.getSecondaryIds().getId().get(0)
                        .getContent());
                subFunder.setId(funder.getId());
                subFunder.setName(funder.getName());
                subFunderList.add(subFunder);
            }
        }

        return subFunderList;
    }

    /**
     * This will call external service to get Industries data.
     *
     * @return the industries
     */
    @SuppressWarnings("unchecked")
    private List<CacheData> getIndustries() {
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
     * @return the job categories
     */
    @SuppressWarnings("unchecked")
    private List<CacheData> getJobCategories() {

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
     * @return the countries
     */
    @SuppressWarnings("unchecked")
    private List<CacheData> getCountries() {

        LOGGER.info("inside getCountries method ");
        ESBResponse countrieslist = userProfiles.getCountries();
        List<CacheData> countrylist = new ArrayList<CacheData>();

        List<Object> externalCountrylist = countrieslist.getResponse()
                .getDocs();
        if (externalCountrylist == null) {
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
     * This will call external service to get Institutions data.
     *
     * @return the institutions
     */
    @SuppressWarnings("unchecked")
    private List<CacheData> getInstitutions() {

        LOGGER.info("inside getInstitutions method ");
        List<Object> externalInstitutionlist = null;
        List<CacheData> institutionslist = null;

        ESBResponse dropDown = userProfiles.getInstitutionsList();
        externalInstitutionlist = dropDown.getResponse().getDocs();

        if (externalInstitutionlist != null) {
            institutionslist = new ArrayList<CacheData>();
            for (Object object : externalInstitutionlist) {
                LinkedHashMap<String, String> institutionmap = (LinkedHashMap<String, String>) object;
                CacheData cacheData = new CacheData();
                cacheData.setName(institutionmap.get("CG_CUST_GRP_NAME"));
                cacheData.setCode(institutionmap.get("CG_CUST_GRP_ID").trim());
                institutionslist.add(cacheData);
            }
        }

        return institutionslist;
    }

    /**
     * This will call external service to get Departments data.
     *
     * @param institutionId
     *            - the input value
     * @return the departments
     */
    @SuppressWarnings("unchecked")
    private List<CacheData> getDepartments(final String institutionId) {

        LOGGER.info("inside getDepartments method ");

        LOGGER.info("inside getInstitutions method ");
        List<Object> externalDepartmentlist = null;
        List<CacheData> departmentlist = null;

        ESBResponse dropDown = userProfiles.getDepartmentsList(institutionId);
        externalDepartmentlist = dropDown.getResponse().getDocs();

        if (externalDepartmentlist != null) {
            departmentlist = new ArrayList<CacheData>();
            for (Object object : externalDepartmentlist) {
                LinkedHashMap<String, String> institutionmap = (LinkedHashMap<String, String>) object;
                CacheData cacheData = new CacheData();
                cacheData.setName(institutionmap.get("CG_CUST_GRP_NAME"));
                cacheData.setCode(institutionmap.get("CG_CUST_GRP_ID").trim());
                departmentlist.add(cacheData);
            }
        }

        return departmentlist;
    }

}
