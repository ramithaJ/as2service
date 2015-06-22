package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version1.0
 *
 */
public class WOAFunder {

	private String id;
	private String name;
	private WOAAccounts woaAccounts;

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
	 * @return The WOAAccounts
	 */
	public WOAAccounts getWOAAccounts() {
		return woaAccounts;
	}

	/**
	 * 
	 * @param WOAAccounts
	 *            The WOAAccounts
	 */
	public void setWOAAccounts(WOAAccounts woaAccounts) {
		this.woaAccounts = woaAccounts;
	}

}