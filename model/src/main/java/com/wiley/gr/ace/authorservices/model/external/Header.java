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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class Header.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Header")
public class Header {

    /** The status. */
    @XmlElement(name = "status")
    private String status;

    /** The q time. */
    @XmlElement(name = "QTime")
    private String qTime;

    /** The entities found. */
    @XmlElement(name = "EntitiesFound")
    private String entitiesFound;

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
     *            the new status
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Gets the q time.
     *
     * @return the q time
     */
    public final String getqTime() {
        return qTime;
    }

    /**
     * Sets the q time.
     *
     * @param qTime
     *            the new q time
     */
    public final void setqTime(final String qTime) {
        this.qTime = qTime;
    }

    /**
     * Gets the entities found.
     *
     * @return the entities found
     */
    public final String getEntitiesFound() {
        return entitiesFound;
    }

    /**
     * Sets the entities found.
     *
     * @param entitiesFound
     *            the new entities found
     */
    public final void setEntitiesFound(final String entitiesFound) {
        this.entitiesFound = entitiesFound;
    }

}
