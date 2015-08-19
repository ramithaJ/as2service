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

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteCachingService;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
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
import com.wiley.gr.ace.authorservices.model.external.ResearchFundersResponse;
import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;

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

    /** the societieskey. */
    @Value("${societies.key}")
    private String societieskey;

    /** the researchFundersurl. */
    @Value("${researchFundersurl.url}")
    private String researchFundersurl;

    /** the funderContentType. */
    @Value("${funderContentType}")
    private String funderContentType;

    /** the cacheDataName. */
    @Value("${cacheData.name}")
    private String cacheDataName;

    /** the cacheDataCode. */
    @Value("${cacheData.code}")
    private String cacheDataCode;

    /** the industryCode. */
    @Value("${industry.code}")
    private String industryCode;

    /** the industryName. */
    @Value("${industry.name}")
    private String industryName;

    /** the jobCategoriesCode. */
    @Value("${jobCategories.code}")
    private String jobCategoriesCode;

    /** the jobCategoriesName. */
    @Value("${jobCategories.name}")
    private String jobCategoriesName;

    /** the countryCode. */
    @Value("${country.code}")
    private String countryCode;

    /** the countryName. */
    @Value("${country.name}")
    private String countryName;

    /** the institutionCode. */
    @Value("${institution.code}")
    private String institutionCode;

    /** the institutionName. */
    @Value("${institution.name}")
    private String institutionName;

    /** the departmentCode. */
    @Value("${department.code}")
    private String departmentCode;

    /** the departmentName. */
    @Value("${department.name}")
    private String departmentName;

    /** getting bean of asdata dao. */
    @Autowired(required = true)
    private ASDataDAO aSDataDAO;

    /**
     * This method returns the cached drop down data in the form of Map. If
     * there is no cached data, the corresponding service is invoked and the
     * data is stored in a HashMap and set it to the cache and returns the same.
     * 
     * @param dropDownKey
     *            - the input value
     * @param parentId
     *            - the input value
     * @return dropDownMap
     */
    @Override
    @Cacheable(value = "dropDownMap", key = "#dropDownKey")
    public final Map<String, CacheData> getCachedData(final String dropDownKey,
            final String parentId) {
        Map<String, CacheData> dropDownMap = null;
        List<CacheData> cacheDataList = null;

        if ((industrieskey + "_cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::industrieskey::" + dropDownKey);
            cacheDataList = getIndustries();
        } else if ((jobCategorieskey + "_cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::jobCategorieskey::" + dropDownKey);
            cacheDataList = getJobCategories();
        } else if ((countrieskey + "_cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::countrieskey::" + dropDownKey);
            cacheDataList = getCountries();
        } else if ((institutionskey + "_cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::institutionskey::" + dropDownKey);
            cacheDataList = getInstitutions();
        } else if ((departmentskey + "_" + parentId + "_cached")
                .equals(dropDownKey)) {
            LOGGER.info("getCachedData::departmentskey::" + dropDownKey);
            cacheDataList = getDepartments(parentId);
        } else if ((researchFundersKey + "_cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::researchFundersKey::" + dropDownKey);
            cacheDataList = getResearchFunders();
        } else if ((societieskey + "_cached").equals(dropDownKey)) {
            LOGGER.info("getCachedData::societieskey::" + dropDownKey);
            cacheDataList = getSocieties();
        }

        if (cacheDataList != null && !cacheDataList.isEmpty()) {
            dropDownMap = new HashMap<String, CacheData>();
            for (CacheData cacheData : cacheDataList) {
                dropDownMap.put(cacheData.getCode(), cacheData);
            }

        } else {
            throw new ASException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);
        }

        return dropDownMap;
    }

    /**
     * This method returns ResearchFunders.
     * 
     * @return cacheDataList.
     */
    private List<CacheData> getResearchFunders() {
        ResearchFundersResponse response = null;

        response = (ResearchFundersResponse) RestServiceInvokerUtil
                .getServiceData(researchFundersurl,
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
                    cacheData.setName(json.get(cacheDataName).toString());
                    cacheData.setCode(json.get(cacheDataCode).toString());
                    cacheList.add(cacheData);
                } catch (ParseException e) {
                    throw new ASException(
                            AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                            e.getMessage());
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
    @Override
    @Cacheable(value = "subFunderDetails", key = "#dropDownKey")
    public final SubFunderDetails getCachedSubFunders(final String dropDownKey) {
        ResearchFundersResponse response = null;
        SubFunderDetails details = null;

        response = (ResearchFundersResponse) RestServiceInvokerUtil
                .getServiceData(researchFundersurl,
                        ResearchFundersResponse.class);

        if (response != null) {
            details = getSubFundersList(response);
        } else {
            throw new ASException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);
        }

        return details;
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
            
        } else {
            throw new ASException(AuthorServicesConstants.SERVERERRORCODE,
                    AuthorServicesConstants.SERVERERRORMESSAGE);
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

        List<CacheData> industryList = null;
        ESBResponse industries = userProfiles.getIndustries();
        if (industries != null) {

            List<Object> industryDocs = industries.getResponse().getDocs();
            industryList = new ArrayList<CacheData>();
            for (Object object : industryDocs) {

                LinkedHashMap<String, String> industryMap = (LinkedHashMap<String, String>) object;
                CacheData industry = new CacheData();
                industry.setCode(industryMap.get(industryCode));
                industry.setName(industryMap.get(industryName));
                industryList.add(industry);
            }
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
        List<CacheData> jobCategoryList = null;

        LOGGER.info("inside getJobCategories method ");
        ESBResponse jobCategories = userProfiles.getJobCategories();

        if (jobCategories != null) {
            jobCategoryList = new ArrayList<CacheData>();

            List<Object> jobCategoryDocs = jobCategories.getResponse()
                    .getDocs();
            for (Object object : jobCategoryDocs) {

                LinkedHashMap<String, String> jobCategoryMap = (LinkedHashMap<String, String>) object;
                CacheData jobCategory = new CacheData();
                jobCategory.setCode(jobCategoryMap.get(jobCategoriesCode));
                jobCategory.setName(jobCategoryMap.get(jobCategoriesName));
                jobCategoryList.add(jobCategory);
            }
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
        List<CacheData> countrylist = null;

        LOGGER.info("inside getCountries method ");
        ESBResponse countrieslist = userProfiles.getCountries();

        List<Object> externalCountrylist = countrieslist.getResponse()
                .getDocs();
        if (externalCountrylist != null) {
            countrylist = new ArrayList<CacheData>();
            for (Object object : externalCountrylist) {
                LinkedHashMap<String, String> countrymap = (LinkedHashMap<String, String>) object;
                CacheData cacheData = new CacheData();
                cacheData.setCode(countrymap.get(countryCode));
                cacheData.setName(countrymap.get(countryName));
                countrylist.add(cacheData);
            }
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
                cacheData.setCode(institutionmap.get(institutionCode).trim());
                cacheData.setName(institutionmap.get(institutionName));
                institutionslist.add(cacheData);
            }
        }

        return institutionslist;
    }

    /**
     * This method will call external service to get Departments data.
     *
     * @param institutionId
     *            - the input value
     * @return the departments
     */
    @SuppressWarnings("unchecked")
    private List<CacheData> getDepartments(final String institutionId) {

        LOGGER.info("inside getDepartments method ");

        List<Object> externalDepartmentlist = null;
        List<CacheData> departmentlist = null;

        ESBResponse dropDown = userProfiles.getDepartmentsList(institutionId);
        externalDepartmentlist = dropDown.getResponse().getDocs();

        if (externalDepartmentlist != null) {
            departmentlist = new ArrayList<CacheData>();
            for (Object object : externalDepartmentlist) {
                LinkedHashMap<String, String> departmentmap = (LinkedHashMap<String, String>) object;
                CacheData cacheData = new CacheData();
                cacheData.setCode(departmentmap.get(departmentCode));
                cacheData.setName(departmentmap.get(departmentName));
                departmentlist.add(cacheData);
            }
        }

        return departmentlist;
    }

    /**
     * This will call Dao service to get Societies data.
     *
     * @return societies
     */
    private List<CacheData> getSocieties() {
        List<CacheData> societyList = null;
        List<Societies> societyListDao = null;

        LOGGER.info("inside getSocieties method ");

        societyListDao = aSDataDAO.getSociety();

        if (societyListDao != null) {
            societyList = new ArrayList<CacheData>();
            for (Societies societies : societyListDao) {
                CacheData cacheData = new CacheData();
                cacheData.setCode(societies.getSocietyCd());
                cacheData.setName(societies.getSocietyName());
                societyList.add(cacheData);
            }
        }

        return societyList;

    }

}
