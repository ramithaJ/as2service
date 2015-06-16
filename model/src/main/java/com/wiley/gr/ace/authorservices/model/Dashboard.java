package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Dashboard.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Dashboard {

    /** The profileMeterMessage. */
    private String profileMeterMessage;

    /** The dashBoardInfo. */
    private List<DashboardInfo> dashBoardInfo;

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
     * @param profileMeterMessage
     *            the new profile meter message
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
    public List<DashboardInfo> getDashBoardInfo() {
        return dashBoardInfo;
    }

    /**
     * Sets the DashBoardInfo List.
     *
     * @param dashBoardInfo
     *            the new dash board info
     */
    public void setDashBoardInfo(List<DashboardInfo> dashBoardInfo) {
        this.dashBoardInfo = dashBoardInfo;
    }
}
