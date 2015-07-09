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
     * Gets the profile meter message.
     *
     * @return the profileMeterMessage
     */
    public final String getProfileMeterMessage() {
        return profileMeterMessage;
    }

    /**
     * Sets the profile meter message.
     *
     * @param profileMeterMessage
     *            the profileMeterMessage to set
     */
    public final void setProfileMeterMessage(final String profileMeterMessage) {
        this.profileMeterMessage = profileMeterMessage;
    }

    /**
     * Gets the dash board info.
     *
     * @return the dashBoardInfo
     */
    public final List<DashboardInfo> getDashBoardInfo() {
        return dashBoardInfo;
    }

    /**
     * Sets the dash board info.
     *
     * @param dashBoardInfo
     *            the dashBoardInfo to set
     */
    public final void setDashBoardInfo(final List<DashboardInfo> dashBoardInfo) {
        this.dashBoardInfo = dashBoardInfo;
    }

}
