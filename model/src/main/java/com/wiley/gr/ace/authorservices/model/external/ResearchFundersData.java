package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;


/**
 * @author virtusa version1.0
 *
 */
public class ResearchFundersData {

	private List<ResearchFunder> researchFunder = new ArrayList<ResearchFunder>();

	/**
	 * 
	 * @return The ResearchFunder
	 */
	public List<ResearchFunder> getResearchFunder() {
		return researchFunder;
	}

	/**
	 * 
	 * @param ResearchFunder
	 *            The ResearchFunder
	 */
	public void setResearchFunder(List<ResearchFunder> researchFunder) {
		this.researchFunder = researchFunder;
	}

}
