/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.Service;

/**
 * @author yugandhark
 *
 */
public interface DashBoardService {
	public List getAllAuthorArticles();
	public Service getProfileMeter(int userId);

}
