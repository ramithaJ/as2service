/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ProductionStatus.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ProductionStatus {

    /** The production status. */
    private String productionStatus;

    /** The production status date. */
    private String productionStatusDate;

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
