package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

/**
 * @author virtusa version1.0
 *
 */
public class WOAFunders {

	private List<WOAFunder> woaFunder = new ArrayList<WOAFunder>();

	/**
	 * 
	 * @return The WOAFunder
	 */
	public List<WOAFunder> getWOAFunder() {
		return woaFunder;
	}

	/**
	 * 
	 * @param WOAFunder
	 *            The WOAFunder
	 */
	public void setWOAFunder(List<WOAFunder> woaFunder) {
		this.woaFunder = woaFunder;
	}
}