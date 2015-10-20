package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class UserReferenceData.
 *
 * @author virtusa version 1.0
 */
public class UserReferenceData {

    /** The ecid. */
    private String ecid;

    /** The Status. */
    @JsonProperty("Status")
    private String status;

    /**
     * @return the ecid
     */
    public final String getEcid() {
        return ecid;
    }

    /**
     * @param ecid
     *            the ecid to set
     */
    public final void setEcid(final String ecid) {
        this.ecid = ecid;
    }

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
    public void setStatus(String status) {
        this.status = status;
    }

}
