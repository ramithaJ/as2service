/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class OnlineOpen.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class OnlineOpen {

    /** The online open status. */
    private String onlineOpenStatus;

    /**
     * Gets the online open status.
     *
     * @return the online open status
     */
    public final String getOnlineOpenStatus() {
        return onlineOpenStatus;
    }

    /**
     * Sets the online open status.
     *
     * @param onlineOpenStatus
     *            the new online open status
     */
    public final void setOnlineOpenStatus(final String onlineOpenStatus) {
        this.onlineOpenStatus = onlineOpenStatus;
    }

}
