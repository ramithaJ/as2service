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
 * The Class Identifier.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT")
public class Product {

    /** The dh type cd. */
    @XmlElement(name = "DH_TYPE_CD")
    private String dhTypeCd;

    /** The doc type. */
    @XmlElement(name = "doc_type")
    private String docType;

    /** The id. */
    @XmlElement(name = "id")
    private String id;

    /** The dh id. */
    @XmlElement(name = "DH_ID")
    private String dhId;

    /** The dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String dhProdId;

    /** The last update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String lastUpdateDate;

    /**
     * Gets the dh type cd.
     *
     * @return the dh type cd
     */
    public final String getDhTypeCd() {
        return dhTypeCd;
    }

    /**
     * Sets the dh type cd.
     *
     * @param dhTypeCd
     *            the new dh type cd
     */
    public final void setDhTypeCd(final String dhTypeCd) {
        this.dhTypeCd = dhTypeCd;
    }

    /**
     * Gets the doc type.
     *
     * @return the doc type
     */
    public final String getDocType() {
        return docType;
    }

    /**
     * Sets the doc type.
     *
     * @param docType
     *            the new doc type
     */
    public final void setDocType(final String docType) {
        this.docType = docType;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the dh id.
     *
     * @return the dh id
     */
    public final String getDhId() {
        return dhId;
    }

    /**
     * Sets the dh id.
     *
     * @param dhId
     *            the new dh id
     */
    public final void setDhId(final String dhId) {
        this.dhId = dhId;
    }

    /**
     * Gets the dh prod id.
     *
     * @return the dh prod id
     */
    public final String getDhProdId() {
        return dhProdId;
    }

    /**
     * Sets the dh prod id.
     *
     * @param dhProdId
     *            the new dh prod id
     */
    public final void setDhProdId(final String dhProdId) {
        this.dhProdId = dhProdId;
    }

    /**
     * Gets the last update date.
     *
     * @return the last update date
     */
    public final String getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the last update date.
     *
     * @param lastUpdateDate
     *            the new last update date
     */
    public final void setLastUpdateDate(final String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

}
