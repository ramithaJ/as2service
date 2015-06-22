package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version1.0
 *
 */
public class WOAFundersData {

	private String articleId;
	private String title;
	private WOAFunders woaFunders;

	/**
	 * 
	 * @return The articleId
	 */
	public String getArticleId() {
		return articleId;
	}

	/**
	 * 
	 * @param articleId
	 *            The articleId
	 */
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	/**
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The WOAFunders
	 */
	public WOAFunders getWOAFunders() {
		return woaFunders;
	}

	/**
	 * 
	 * @param WOAFunders
	 *            The WOAFunders
	 */
	public void setWOAFunders(WOAFunders woaFunders) {
		this.woaFunders = woaFunders;
	}

}
