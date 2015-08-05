/**
 * 
 */
package com.wiley.gr.ace.authorservices.autocomplete.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

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
import com.wiley.gr.ace.authorservices.model.Department;
import com.wiley.gr.ace.authorservices.model.Doc;
import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.Response;
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
public class AutocompleteCachingServiceImpl implements AutocompleteCachingService {
	
    /**
     * Logger Configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AutocompleteCachingServiceImpl.class);
	
    /** getting bean of userProfiles. */
    @Autowired(required=true)
    private UserProfiles userProfiles;

	@Value("${industries.key}")
	private String industrieskey;

	@Value("${jobCategories.key}")
	private String jobCategorieskey;

	@Value("${countries.key}")
	private String countrieskey;

	@Value("${institutions.key}")
	private String institutionskey;

	@Value("${departments.key}")
	private String departmentskey;

	@Value("${researchFunders.key}")
	private String researchFundersKey;
	
	@Value("${researchFundersurl.url}")
	private String researchFundersurl;
	
	@Value("${funderContentType}")
	private String funderContentType;

	
	/**
	 * This method returns the cached drop down data. If there is no cached
	 * data, the corresponding service is invoked and the list is set to the
	 * cache and returns the list.
	 * 
	 * @param dropDownKey
	 * @return dropDownList
	 */
	@Override
	@Cacheable(value = "dropDownList", key = "#dropDownKey")
	public List<String> getCachedData(String dropDownKey, String parentId) {
		List<String> dropDownList = null;
		List<CacheData> cacheDataList = null;

		if ((industrieskey + "cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::industrieskey::"+dropDownKey);
			cacheDataList = getIndustries();
		} else if ((jobCategorieskey + "cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::jobCategorieskey::"+dropDownKey);
			cacheDataList = getJobCategories();
		} else if ((countrieskey + "cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::countrieskey::"+dropDownKey);
			cacheDataList = getCountries();
		} else if ((institutionskey + "cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::institutionskey::"+dropDownKey);
			cacheDataList = getInstitutions();
		} else if ((departmentskey+"cached").equals(dropDownKey)) {
			LOGGER.info("getCachedData::departmentskey::"+dropDownKey);
			cacheDataList = getDepartments(parentId);
		} else if ((researchFundersKey+"cached").equals(dropDownKey)){
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
	 * This method returns ResearchFunders
	 * @return List<CacheData>
	 */
	private List<CacheData> getResearchFunders() {
		ResearchFundersResponse response = null;
		
		response = (ResearchFundersResponse) RestServiceInvokerUtil.invokeStub(researchFundersurl,
				HttpMethod.GET, ResearchFundersResponse.class);
		
		return getResearchFundersList(response);
	}

	/**
	 * THis method returns the research funders list
	 * @param response
	 * @return cacheList
	 */
	private List<CacheData> getResearchFundersList(
			ResearchFundersResponse response) {
		List<CacheData> cacheList = null;
		
		   List<Funder> funderList = response.getFunder();
		   Set<String> cacheStringSet = new HashSet<String>();
		   
		   if(funderList != null && !funderList.isEmpty()) {
			   
			   for (Funder funder : funderList) {
				   CacheData cacheData = new CacheData();
				   
				   cacheData.setName(funder.getName());
				   List<Id> idList = funder.getSecondaryIds().getId();
				   for (Id id : idList) {
					if(funderContentType.equals(id.getType())){
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
	 * This will call external service to get Industries data.
	 *
	 * @param count
	 *            the count
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
	 * @param count
	 *            the count
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
	 * @param count
	 *            the count
	 * @return the countries
	 */
	@SuppressWarnings("unchecked")
	private List<CacheData> getCountries() {

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
	 * This will call external service to get Institutions data.
	 *
	 * @return the institutions
	 */
	private List<CacheData> getInstitutions() {

		LOGGER.info("inside getInstitutions method ");

		Institution dropDown = userProfiles.getInstitutionsList();
		Response response = dropDown.getResponse();
		List<Doc> docList = response.getDocs();
		List<CacheData> institutionslist = new ArrayList<CacheData>();

		for (Doc institute : docList) {

			CacheData institution = new CacheData();
			institution.setCode(institute.getCGCUSTGRPID());
			institution.setName(institute.getCGCUSTGRPNAME());
			institutionslist.add(institution);

		}

		return institutionslist;
	}

	/**
	 * This will call external service to get Departments data.
	 *
	 * @return the departments
	 */
	private List<CacheData> getDepartments(String institutionId) {

		LOGGER.info("inside getDepartments method ");

		Department dropDown = userProfiles.getDepartmentsList(institutionId);
		Response response = dropDown.getResponse();
		List<Doc> docList = response.getDocs();
		List<CacheData> departmentlist = new ArrayList<CacheData>();
		for (Doc department : docList) {

			CacheData departments = new CacheData();
			departments.setCode(department.getCGCUSTGRPID());
			departments.setName(department.getCGCUSTGRPNAME());
			departmentlist.add(departments);

		}
		return departmentlist;
	}
	
	

	
	
	
	
	
	
	
	

}
