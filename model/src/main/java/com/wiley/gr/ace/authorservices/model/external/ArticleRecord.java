/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * @author yugandhark
 *
 */
public class ArticleRecord {
	
	private List<ArticleCitationRecord> articleCitationRecord;

	private List<ArticleReadRecord> articleReadRecord;

	public List<ArticleCitationRecord> getArticleCitationRecord() {
		return articleCitationRecord;
	}

	public void setArticleCitationRecord(
			List<ArticleCitationRecord> articleCitationRecord) {
		this.articleCitationRecord = articleCitationRecord;
	}

	public List<ArticleReadRecord> getArticleReadRecord() {
		return articleReadRecord;
	}

	public void setArticleReadRecord(List<ArticleReadRecord> articleReadRecord) {
		this.articleReadRecord = articleReadRecord;
	}

}
