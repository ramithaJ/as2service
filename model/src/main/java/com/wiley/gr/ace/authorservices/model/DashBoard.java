package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Virtusa
 *
 */
@JsonInclude(Include.NON_NULL)
public class DashBoard {

	/** The profileMeterMessage. */
	private String profileMeterMessage;

	/** The dashBoardInfo. */
	private List<DashBoardInfo> dashBoardInfo;

	/**
	 * Gets the profileMeterMessage.
	 *
	 * @return the profileMeterMessage
	 * 
	 */
	public String getProfileMeterMessage() {
		return profileMeterMessage;
	}

	/**
	 * Sets the profileMeterMessage.
	 *
	 * @param the
	 *            profileMeterMessage
	 * 
	 */
	public void setProfileMeterMessage(String profileMeterMessage) {
		this.profileMeterMessage = profileMeterMessage;
	}

	/**
	 * Gets the DashBoardInfo List.
	 *
	 * @return the DashBoardInfo List
	 * 
	 */
	public List<DashBoardInfo> getDashBoardInfo() {
		return dashBoardInfo;
	}

	/**
	 * Sets the DashBoardInfo List.
	 *
	 * @param the
	 *            DashBoardInfo List
	 * 
	 */
	public void setDashBoardInfo(List<DashBoardInfo> dashBoardInfo) {
		this.dashBoardInfo = dashBoardInfo;
	}
}
