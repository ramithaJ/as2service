/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CommunicationHistory.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class CommunicationHistory {

    /** The communication details. */
    private List<CommunicationDetails> communicationDetails;

    /**
     * Gets the communication details.
     *
     * @return the communication details
     */
    public final List<CommunicationDetails> getCommunicationDetails() {
        return communicationDetails;
    }

    /**
     * Sets the communication details.
     *
     * @param communicationDetails
     *            the new communication details
     */
    public final void setCommunicationDetails(
            final List<CommunicationDetails> communicationDetails) {
        this.communicationDetails = communicationDetails;
    }

}
