package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

/**
 * @author virtusa version1.0
 *
 */
public class WOAAccounts {

	private List<WOAAccount> woaAccount = new ArrayList<WOAAccount>();

	/**
	 * 
	 * @return The WOAAccount
	 */
	public List<WOAAccount> getWOAAccount() {
		return woaAccount;
	}

	/**
	 * 
	 * @param WOAAccount
	 *            The WOAAccount
	 */
	public void setWOAAccount(List<WOAAccount> woaAccount) {
		this.woaAccount = woaAccount;
	}

}