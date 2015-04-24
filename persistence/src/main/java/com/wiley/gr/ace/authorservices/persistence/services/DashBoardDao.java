/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.Article;

/**
 * @author yugandhark
 *
 */
public interface DashBoardDao {
 List<Article> getAllAuthorArticles();
 List getProfileMeter(int userId);
}
