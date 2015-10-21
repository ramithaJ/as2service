package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version 1.0
 *
 */
public class ParticipantPayload {

    /**
     * This field holds the value of userId
     */
    private String userId;

    /**
     * This field holds the value of ptpId
     */
    private String ptpId;

    /**
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * @return the ptpId
     */
    public final String getPtpId() {
        return ptpId;
    }

    /**
     * @param ptpId
     *            the ptpId to set
     */
    public final void setPtpId(final String ptpId) {
        this.ptpId = ptpId;
    }

}
