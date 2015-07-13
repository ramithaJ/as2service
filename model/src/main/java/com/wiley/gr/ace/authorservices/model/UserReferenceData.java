package com.wiley.gr.ace.authorservices.model;

import java.io.Serializable;

/**
 * The Class UserReferenceData.
 *
 * @author virtusa version 1.0
 */
public class UserReferenceData implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The ecid. */
    private String ecId;

    /** The status. */
    private String status;

    /**
     * Gets the ec id.
     *
     * @return the ecId
     */
    public final String getEcId() {
        return ecId;
    }

    /**
     * Sets the ec id.
     *
     * @param ecId
     *            the ecId to set
     */
    public final void setEcId(final String ecId) {
        this.ecId = ecId;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the status to set
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

}
