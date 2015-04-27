/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.LinkedList;
import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.Article;

/**
 * @author yugandhark
 *
 */
public interface DashBoardDAO {
 List<Article> getAllAuthorArticles();
 List<LinkedList> getProfileMeter(int userId);
}
