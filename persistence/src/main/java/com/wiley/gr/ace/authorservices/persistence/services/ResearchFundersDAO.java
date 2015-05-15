package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;

/**
 * @author kpshiva
 *
 */
public interface ResearchFundersDAO {

	/**
	 * @param userId
	 * @return
	 */
	List<UserFunderGrants> getResearchFunders(String userId);

	/**
	 * @param userId
	 * @param researchFunder
	 * @return
	 */
	boolean updateResearchFunder(String userId, ResearchFunder researchFunder);
}
