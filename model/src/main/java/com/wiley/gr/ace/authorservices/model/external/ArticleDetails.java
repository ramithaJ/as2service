/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * @author yugandhark
 *
 */
public class ArticleDetails {

	private Integer articleId;

	private String articleName;

	private String articleDoi;

	private String publicationDate;

	private String acceptanceDate;

	private String articleAcceptedInOO;

	private String articleAuthorName;

	private List<ArticleCoAuthors> articleCoAuthors;

	public final Integer getArticleId() {
		return articleId;
	}

	public final void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public final String getArticleName() {
		return articleName;
	}

	public final void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public final String getArticleDoi() {
		return articleDoi;
	}

	public final void setArticleDoi(String articleDoi) {
		this.articleDoi = articleDoi;
	}

	public final String getPublicationDate() {
		return publicationDate;
	}

	public final void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public final String getAcceptanceDate() {
		return acceptanceDate;
	}

	public final void setAcceptanceDate(String acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

	public final String getArticleAcceptedInOO() {
		return articleAcceptedInOO;
	}

	public final void setArticleAcceptedInOO(String articleAcceptedInOO) {
		this.articleAcceptedInOO = articleAcceptedInOO;
	}

	public final String getArticleAuthorName() {
		return articleAuthorName;
	}

	public final void setArticleAuthorName(String articleAuthorName) {
		this.articleAuthorName = articleAuthorName;
	}

	public final List<ArticleCoAuthors> getArticleCoAuthors() {
		return articleCoAuthors;
	}

	public final void setArticleCoAuthors(
			List<ArticleCoAuthors> articleCoAuthors) {
		this.articleCoAuthors = articleCoAuthors;
	}

}
