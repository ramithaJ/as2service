package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

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
import com.wiley.gr.ace.authorservices.persistence.entity.Article;

/**
 * @author SarmaKumarap
 *
 */
public interface ASDataService {
	
	/**
	 * @return
	 */
	List<Title> getTitles();
	
	/**
	 * @return
	 */
	List<Suffix> getSuffixes();
	
	/**
	 * @return
	 */
	List<Industry> getIndustries();
	
	/**
	 * @return
	 */
	List<JobCategory> getJobCategories();
	
	/**
	 * @return
	 */
	List<Country> getCountries();
	
	/**
	 * @return
	 */
	List<State> getStates();
	
	/**
	 * @return
	 */
	List<Institution> getInstitutions();
	
	/**
	 * @return
	 */
	List<Department> getDepartments();
	
	/**
	 * @return
	 */
	List<ResearchFunder> getResearchFunders();
	
	/**
	 * @return
	 */
	List<Article> getArticles();
	
	/**
	 * @return
	 */
	List<Society> getSocieties();
	
	/**
	 * @return
	 */
	List<Interests> getAreasOfInterests();
	
	/**
	 * @return
	 */
	StaticData[] getSecurityQuestions();
	
}
