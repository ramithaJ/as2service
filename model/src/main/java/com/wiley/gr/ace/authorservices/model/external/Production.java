/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Production.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Production {

    /** The production status. */
    private String productionStatus;

    /**
     * Gets the production status.
     *
     * @return the production status
     */
    public final String getProductionStatus() {
        return productionStatus;
    }

    /**
     * Sets the production status.
     *
     * @param productionStatus
     *            the new production status
     */
    public final void setProductionStatus(final String productionStatus) {
        this.productionStatus = productionStatus;
    }

}
