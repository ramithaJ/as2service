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
	public List<Title> getTitles();
	
	/**
	 * @return
	 */
	public List<Suffix> getSuffixes();
	
	/**
	 * @return
	 */
	public List<Industry> getIndustries();
	
	/**
	 * @return
	 */
	public List<JobCategory> getJobCategories();
	
	/**
	 * @return
	 */
	public List<Country> getCountries();
	
	/**
	 * @return
	 */
	public List<State> getStates();
	
	/**
	 * @return
	 */
	public List<Institution> getInstitutions();
	
	/**
	 * @return
	 */
	public List<Department> getDepartments();
	
	/**
	 * @return
	 */
	public List<ResearchFunder> getResearchFunders();
	
	/**
	 * @return
	 */
	public List<Article> getArticles();
	
	/**
	 * @return
	 */
	public List<Society> getSocieties();
	
	/**
	 * @return
	 */
	public List<Interests> getAreasOfInterests();
	

}
