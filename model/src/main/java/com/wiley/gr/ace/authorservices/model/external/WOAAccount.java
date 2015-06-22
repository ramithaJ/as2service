package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version1.0
 *
 */
public class WOAAccount {

	private String id;
	private String code;
	private String name;
	private String dealType;
	private String currency;
	private ResearchFunders researchFunders;

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param code
	 *            The code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 
	 * @return The name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The dealType
	 */
	public String getDealType() {
		return dealType;
	}

	/**
	 * 
	 * @param dealType
	 *            The dealType
	 */
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	/**
	 * 
	 * @return The currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * 
	 * @param currency
	 *            The currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * 
	 * @return The ResearchFunders
	 */
	public ResearchFunders getResearchFunders() {
		return researchFunders;
	}

	/**
	 * 
	 * @param researchFunders
	 *            The ResearchFunders
	 */
	public void setResearchFunders(ResearchFunders researchFunders) {
		this.researchFunders = researchFunders;
	}

}