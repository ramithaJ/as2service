package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.UserAlerts;

/**
 * @author RAVISINHA
 *
 */
public interface UserAlertsDao {
	
	/**
	 * @param userId
	 * @return
	 */
	public List<UserAlerts> getListOfAlerts(String userId);
	

}
