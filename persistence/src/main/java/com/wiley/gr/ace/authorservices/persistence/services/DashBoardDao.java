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
 public List<Article> getAllAuthorArticles();
 public List getProfileMeter(int userId);
}
