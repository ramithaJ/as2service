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
import com.wiley.gr.ace.authorservices.model.external.WOAFunder;
import com.wiley.gr.ace.authorservices.model.external.WileyOpenAccessFunders;
import com.wiley.gr.ace.authorservices.persistence.entity.AreaOfInterest;
import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
import com.wiley.gr.ace.authorservices.persistence.services.AreaOfInterterestDao;

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

    /** the areasOfInterestsKey. */
    @Value("${areasOfInterests.key}")
    private String areasOfInterestsKey;

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

    /** The area of interest dao . */
    @Autowired(required = true)
    private AreaOfInterterestDao areaOfInterest;

    /** The woa funders. */
    @Value("${woaFunders.key}")
    private String woaFundersKey;

    /** The woa accounts url. */
    @Value("${woaAccounts.url}")
    private String woaAccountsurl;

    /**
     * This field holds the value of CACHED
     */
    private static final String CACHED = "_cached";

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

        String industryKey = industrieskey + CACHED;
        String jobCategoryKey = jobCategorieskey + CACHED;
        String countryKey = countrieskey + CACHED;
        String institutionKey = institutionskey + CACHED;
        String departmentKey = departmentskey
                + AuthorServicesConstants.UNDERSCORE + parentId + CACHED;
        String researchFunderKey = researchFundersKey + CACHED;
        String societyKey = societieskey + CACHED;
        String areaOfIntrestKey = areasOfInterestsKey + CACHED;
        String woaFunderKey = woaFundersKey + CACHED;

        if (industryKey.equals(dropDownKey)) {
            LOGGER.info("getCachedData::industrieskey::" + dropDownKey);
            cacheDataList = getIndustries();
        } else if (jobCategoryKey.equals(dropDownKey)) {
            LOGGER.info("getCachedData::jobCategorieskey::" + dropDownKey);
            cacheDataList = getJobCategories();
        } else if (countryKey.equals(dropDownKey)) {
            LOGGER.info("getCachedData::countrieskey::" + dropDownKey);
            cacheDataList = getCountries();
        } else if (institutionKey.equals(dropDownKey)) {
            LOGGER.info("getCachedData::institutionskey::" + dropDownKey);
            cacheDataList = getInstitutions();
        } else if (departmentKey.equals(dropDownKey)) {
            LOGGER.info("getCachedData::departmentskey::" + dropDownKey);
            cacheDataList = getDepartments(parentId);
        } else if (researchFunderKey.equals(dropDownKey)) {
            LOGGER.info("getCachedData::researchFundersKey::" + dropDownKey);
            cacheDataList = getResearchFunders();
        } else if (societyKey.equals(dropDownKey)) {
            LOGGER.info("getCachedData::societieskey::" + dropDownKey);
            cacheDataList = getSocieties();
        } else if (areaOfIntrestKey.equals(dropDownKey)) {
            LOGGER.info("getCachedData::areasOfInterestsKey::" + dropDownKey);
            cacheDataList = getAreasOfInterests();
        } else if (woaFunderKey.equals(dropDownKey)) {
            LOGGER.info("getCachedData::woaFundersKey::" + dropDownKey);
            cacheDataList = getWoaFundersKey();
        }

        if (cacheDataList != null && !cacheDataList.isEmpty()) {
            dropDownMap = new HashMap<String, CacheData>();
            for (CacheData cacheData : cacheDataList) {
                dropDownMap.put(cacheData.getCode(), cacheData);
            }

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

        List<Funder> funderList = response.getFunders().getFunder();

        Set<String> cacheStringSet = new HashSet<String>();

        if (funderList != null && !funderList.isEmpty()) {

            for (Funder funder : funderList) {
                CacheData cacheData = new CacheData();

                String funderName = funder.getName();
                if (funderName.contains("\"")) {
                    funderName = funderName.replaceAll("\"", "&quot;");
                }

                cacheData.setName(funderName);
                List<Id> idList = funder.getSecondaryIds().getId();
                for (Id id : idList) {
                    if (funderContentType.equals(id.getType())) {
                        cacheData.setCode(id.getContent());
                        cacheStringSet.add(cacheData.toString());
                        break;
                    }

                }

            }

            cacheList = new ArrayList<CacheData>();
            for (String data : cacheStringSet) {
                try {
                    JSONObject json = (JSONObject) new JSONParser().parse(data);
                    CacheData cacheData = new CacheData();
                    cacheData.setName(json.get(cacheDataName).toString()
                            .toUpperCase());
                    cacheData.setCode(json.get(cacheDataCode).toString());
                    cacheData
                            .setDisplayName(json.get(cacheDataName).toString());
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

        List<Funder> funderList = response.getFunders().getFunder();
        SubFunderDetails subFunderDetails = null;

        SortedSet<String> doiSet = new TreeSet<String>();
        if (funderList != null && !funderList.isEmpty()) {

            for (Funder funder : funderList) {

                if (funder.getParent() != null) {
                    List<Id> idList = funder.getParent().getSecondaryIds()
                            .getId();
                    for (Id id : idList) {
                        if (funderContentType.equals(id.getType())) {
                            doiSet.add(id.getContent());
                        }
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
            if (funder.getParent() != null) {
                String selectedDoi = funder.getParent().getSecondaryIds()
                        .getId().get(0).getContent();
                if (parentFunder.getDoi().equals(selectedDoi)) {
                    SubFunder subFunder = new SubFunder();
                    subFunder.setDoi(funder.getSecondaryIds().getId().get(0)
                            .getContent());
                    subFunder.setId(funder.getId());
                    subFunder.setName(funder.getName());
                    subFunderList.add(subFunder);
                }
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

                Map<String, String> industryMap = (LinkedHashMap<String, String>) object;
                CacheData industry = new CacheData();
                industry.setCode(industryMap.get(industryCode));
                industry.setName(industryMap.get(industryName).toUpperCase());
                LOGGER.info("Industry Name : " + industry.getName());
                industry.setDisplayName(industryMap.get(industryName));
                LOGGER.info("Industry Display Name : "
                        + industry.getDisplayName());
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

                Map<String, String> jobCategoryMap = (LinkedHashMap<String, String>) object;
                CacheData jobCategory = new CacheData();
                jobCategory.setCode(jobCategoryMap.get(jobCategoriesCode));
                jobCategory.setName(jobCategoryMap.get(jobCategoriesName)
                        .toUpperCase());
                jobCategory.setDisplayName(jobCategoryMap
                        .get(jobCategoriesName));
                LOGGER.info("Job Category Name : " + jobCategory.getName());
                LOGGER.info("Job Category Display Name : "
                        + jobCategory.getDisplayName());
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
                Map<String, String> countryMap = (LinkedHashMap<String, String>) object;
                CacheData cacheData = new CacheData();
                cacheData.setCode(countryMap.get(countryCode));
                cacheData.setName(countryMap.get(countryName).toUpperCase());
                cacheData.setDisplayName(countryMap.get(countryName));
                LOGGER.info("Country Name : " + cacheData.getName());
                LOGGER.info("Country Display Name : "
                        + cacheData.getDisplayName());
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
                Map<String, String> institutionMap = (LinkedHashMap<String, String>) object;
                CacheData cacheData = new CacheData();
                cacheData.setCode(institutionMap.get(institutionCode).trim());
                cacheData.setName(institutionMap.get(institutionName)
                        .toUpperCase());
                cacheData.setDisplayName(institutionMap.get(institutionName));

                LOGGER.info("Institution Name : " + cacheData.getName());
                LOGGER.info("Institution Display Name : "
                        + cacheData.getDisplayName());
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
                Map<String, String> departmentMap = (LinkedHashMap<String, String>) object;
                CacheData cacheData = new CacheData();
                cacheData.setCode(departmentMap.get(departmentCode).trim());
                cacheData.setName(departmentMap.get(departmentName)
                        .toUpperCase());
                cacheData.setDisplayName(departmentMap.get(departmentName));

                LOGGER.info("Department Name : " + cacheData.getName());
                LOGGER.info("Department Display Name : "
                        + cacheData.getDisplayName());
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
                cacheData.setName(societies.getSocietyName().toUpperCase());
                cacheData.setDisplayName(societies.getSocietyName());

                LOGGER.info("Society Name : " + cacheData.getName());
                LOGGER.info("Society Display Name : "
                        + cacheData.getDisplayName());
                societyList.add(cacheData);
            }
        }

        return societyList;

    }

    /**
     * This will call external service to get AreasOfInterests data.
     *
     * @return the areas of interests
     */
    private List<CacheData> getAreasOfInterests() {
        List<CacheData> areasOfIntrestList = null;
        List<AreaOfInterest> areaOfInterestDao = null;

        LOGGER.info("inside getAreasOfInterests method ");

        areaOfInterestDao = areaOfInterest.getAreaOfInterest();

        if (areaOfInterestDao != null) {
            areasOfIntrestList = new ArrayList<CacheData>();
            for (AreaOfInterest areaOfInterest : areaOfInterestDao) {
                CacheData interests = new CacheData();
                interests.setCode(areaOfInterest.getAreaOfInterestCd());
                interests.setName(areaOfInterest.getInterestName()
                        .toUpperCase());
                interests.setDisplayName(areaOfInterest.getInterestName());

                LOGGER.info("Area of interests Name : " + interests.getName());
                LOGGER.info("Area of interests Display Name : "
                        + interests.getDisplayName());
                areasOfIntrestList.add(interests);
            }
        }

        return areasOfIntrestList;
    }

    /**
     * This method returns the woaFundersList.
     * 
     * @return cachedata
     */
    private List<CacheData> getWoaFundersKey() {

        List<CacheData> woaFunderList = null;

        WileyOpenAccessFunders wileyOpenAccessFunders = (WileyOpenAccessFunders) RestServiceInvokerUtil
                .getServiceData(woaAccountsurl, WileyOpenAccessFunders.class);

        if (wileyOpenAccessFunders != null) {
            List<WOAFunder> woaFundersList = wileyOpenAccessFunders
                    .getWoaFunders().getWOAFunder();

            if (woaFundersList != null && !woaFundersList.isEmpty()) {
                woaFunderList = new ArrayList<CacheData>();

                for (WOAFunder woaFunder : woaFundersList) {
                    CacheData cacheData = new CacheData();
                    cacheData.setCode(woaFunder.getId());
                    cacheData.setName(woaFunder.getName().toUpperCase());
                    cacheData.setDisplayName(woaFunder.getName());
                    woaFunderList.add(cacheData);
                }
            }

        }
        return woaFunderList;
    }

}
