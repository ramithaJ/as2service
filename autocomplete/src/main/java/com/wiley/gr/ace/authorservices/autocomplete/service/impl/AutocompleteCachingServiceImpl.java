/**
 * 
 */
package com.wiley.gr.ace.authorservices.autocomplete.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteCachingService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.CacheData;
import com.wiley.gr.ace.authorservices.model.Department;
import com.wiley.gr.ace.authorservices.model.DropDown;
import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;

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
	public List<String> getCachedData(String dropDownKey) {
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
			cacheDataList = getDepartments();
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
	private List<CacheData> getDepartments() {

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

	
	
	
	
	
	
	
	

}
