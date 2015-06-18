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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ArticleDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ArticleDetails {

	/** The article id. */
	private Integer articleId;

	/** The article name. */
	private String articleName;

	/** The article doi. */
	private String articleDoi;

	/** The publication date. */
	private String publicationDate;

	/** The acceptance date. */
	private String acceptanceDate;

	/** The article accepted in oo. */
	private String articleAcceptedInOO;

	/** The article authors. */
	private String articleAuthorName;

	/** The article co authors. */
	private List<String> articleCoAuthors;

	/**
	 * Gets the article id.
	 *
	 * @return the articleId
	 */
	public final Integer getArticleId() {
		return articleId;
	}

	/**
	 * Sets the article id.
	 *
	 * @param articleId
	 *            the articleId to set
	 */
	public final void setArticleId(final Integer articleId) {
		this.articleId = articleId;
	}

	/**
	 * Gets the article name.
	 *
	 * @return the articleName
	 */
	public final String getArticleName() {
		return articleName;
	}

	/**
	 * Sets the article name.
	 *
	 * @param articleName
	 *            the articleName to set
	 */
	public final void setArticleName(final String articleName) {
		this.articleName = articleName;
	}

	/**
	 * Gets the article doi.
	 *
	 * @return the articleDoi
	 */
	public final String getArticleDoi() {
		return articleDoi;
	}

	/**
	 * Sets the article doi.
	 *
	 * @param articleDoi
	 *            the articleDoi to set
	 */
	public final void setArticleDoi(final String articleDoi) {
		this.articleDoi = articleDoi;
	}

	/**
	 * Gets the publication date.
	 *
	 * @return the publicationDate
	 */
	public final String getPublicationDate() {
		return publicationDate;
	}

	/**
	 * Sets the publication date.
	 *
	 * @param publicationDate
	 *            the publicationDate to set
	 */
	public final void setPublicationDate(final String publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * Gets the acceptance date.
	 *
	 * @return the acceptanceDate
	 */
	public final String getAcceptanceDate() {
		return acceptanceDate;
	}

	/**
	 * Sets the acceptance date.
	 *
	 * @param acceptanceDate
	 *            the acceptanceDate to set
	 */
	public final void setAcceptanceDate(final String acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}

	/**
	 * Gets the article accepted in oo.
	 *
	 * @return the articleAcceptedInOO
	 */
	public final String getArticleAcceptedInOO() {
		return articleAcceptedInOO;
	}

	/**
	 * Sets the article accepted in oo.
	 *
	 * @param articleAcceptedInOO
	 *            the articleAcceptedInOO to set
	 */
	public final void setArticleAcceptedInOO(final String articleAcceptedInOO) {
		this.articleAcceptedInOO = articleAcceptedInOO;
	}

	/**
	 * Gets the article author name.
	 *
	 * @return the article author name
	 */
	public final String getArticleAuthorName() {
		return articleAuthorName;
	}

	/**
	 * Sets the article author name.
	 *
	 * @param articleAuthorName
	 *            the new article author name
	 */
	public final void setArticleAuthorName(final String articleAuthorName) {
		this.articleAuthorName = articleAuthorName;
	}

	/**
	 * Gets the article co authors.
	 *
	 * @return the articleCoAuthors
	 */
	public final List<String> getArticleCoAuthors() {
		return articleCoAuthors;
	}

	/**
	 * Sets the article co authors.
	 *
	 * @param articleCoAuthors
	 *            the articleCoAuthors to set
	 */
	public final void setArticleCoAuthors(final List<String> articleCoAuthors) {
		this.articleCoAuthors = articleCoAuthors;
	}

}
