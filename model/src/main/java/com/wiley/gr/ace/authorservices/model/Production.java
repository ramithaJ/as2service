/**
 * 
 */
package com.wiley.gr.ace.authorservices.model;

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

    /** The production status date. */
    private String productionStatusDate;

    /** The action. */
    private String action;

    /**
     * Gets the action.
     *
     * @return the action
     */
    public final String getAction() {
        return action;
    }

    /**
     * Sets the action.
     *
     * @param action
     *            the new action
     */
    public final void setAction(final String action) {
        this.action = action;
    }

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

    /**
     * Gets the production status date.
     *
     * @return the production status date
     */
    public final String getProductionStatusDate() {
        return productionStatusDate;
    }

    /**
     * Sets the production status date.
     *
     * @param productionStatusDate
     *            the new production status date
     */
    public final void setProductionStatusDate(final String productionStatusDate) {
        this.productionStatusDate = productionStatusDate;
    }

}
