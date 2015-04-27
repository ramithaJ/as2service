/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service;

import java.util.LinkedList;
import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.Article;




/**
 * @author yugandhark
 *
 */
public interface DashBoardService {
	List<Article> getAllAuthorArticles();
	List<LinkedList> getProfileMeter(int userId);

}
