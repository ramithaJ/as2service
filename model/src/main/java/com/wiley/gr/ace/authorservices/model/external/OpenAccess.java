/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class OpenAccess.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class OpenAccess {

    /** The open access status. */
    private String openAccessStatus;

    /**
     * Gets the open access status.
     *
     * @return the open access status
     */
    public String getOpenAccessStatus() {
        return openAccessStatus;
    }

    /**
     * Sets the open access status.
     *
     * @param openAccessStatus
     *            the new open access status
     */
    public void setOpenAccessStatus(String openAccessStatus) {
        this.openAccessStatus = openAccessStatus;
    }

}
