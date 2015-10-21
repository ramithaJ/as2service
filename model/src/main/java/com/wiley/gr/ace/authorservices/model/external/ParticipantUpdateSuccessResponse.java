package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version 1.0
 *
 */
public class ParticipantUpdateSuccessResponse extends
        ParticipantUpdateErrorResponse {

    /**
     * This field holds the value of status
     */
    private String status;

    /**
     * This field holds the value of payload
     */
    private ParticipantPayload payload;

    /**
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @return the payload
     */
    public final ParticipantPayload getPayload() {
        return payload;
    }

    /**
     * @param payload
     *            the payload to set
     */
    public final void setPayload(final ParticipantPayload payload) {
        this.payload = payload;
    }

}
