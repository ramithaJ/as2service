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
 * The Class ProductRegion.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT_REGION")
public class ProductRegion {

    /** The dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String dhProdId;

    /** The prod reg dh id. */
    @XmlElement(name = "DH_ID")
    private String prodRegDhId;

    /** The prod reg cd. */
    @XmlElement(name = "REG_CD")
    private String prodRegCd;

    /** The prod reg dh prod type cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String prodRegDhProdTypeCd;

    /** The prod reg doc type. */
    @XmlElement(name = "doc_type")
    private String prodRegDocType;

    /** The prod reg dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String prodRegDhRegId;

    /** The prod reg reg desc. */
    @XmlElement(name = "REG_DESC")
    private String prodRegRegDesc;

    /** The prod reg id. */
    @XmlElement(name = "id")
    private String prodRegId;

    /** The prod reglast update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String prodReglastUpdateDate;

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
     * Gets the prod reg dh id.
     *
     * @return the prod reg dh id
     */
    public final String getProdRegDhId() {
        return prodRegDhId;
    }

    /**
     * Sets the prod reg dh id.
     *
     * @param prodRegDhId
     *            the new prod reg dh id
     */
    public final void setProdRegDhId(final String prodRegDhId) {
        this.prodRegDhId = prodRegDhId;
    }

    /**
     * Gets the prod reg cd.
     *
     * @return the prod reg cd
     */
    public final String getProdRegCd() {
        return prodRegCd;
    }

    /**
     * Sets the prod reg cd.
     *
     * @param prodRegCd
     *            the new prod reg cd
     */
    public final void setProdRegCd(final String prodRegCd) {
        this.prodRegCd = prodRegCd;
    }

    /**
     * Gets the prod reg dh prod type cd.
     *
     * @return the prod reg dh prod type cd
     */
    public final String getProdRegDhProdTypeCd() {
        return prodRegDhProdTypeCd;
    }

    /**
     * Sets the prod reg dh prod type cd.
     *
     * @param prodRegDhProdTypeCd
     *            the new prod reg dh prod type cd
     */
    public final void setProdRegDhProdTypeCd(final String prodRegDhProdTypeCd) {
        this.prodRegDhProdTypeCd = prodRegDhProdTypeCd;
    }

    /**
     * Gets the prod reg doc type.
     *
     * @return the prod reg doc type
     */
    public final String getProdRegDocType() {
        return prodRegDocType;
    }

    /**
     * Sets the prod reg doc type.
     *
     * @param prodRegDocType
     *            the new prod reg doc type
     */
    public final void setProdRegDocType(final String prodRegDocType) {
        this.prodRegDocType = prodRegDocType;
    }

    /**
     * Gets the prod reg dh reg id.
     *
     * @return the prod reg dh reg id
     */
    public final String getProdRegDhRegId() {
        return prodRegDhRegId;
    }

    /**
     * Sets the prod reg dh reg id.
     *
     * @param prodRegDhRegId
     *            the new prod reg dh reg id
     */
    public final void setProdRegDhRegId(final String prodRegDhRegId) {
        this.prodRegDhRegId = prodRegDhRegId;
    }

    /**
     * Gets the prod reg reg desc.
     *
     * @return the prod reg reg desc
     */
    public final String getProdRegRegDesc() {
        return prodRegRegDesc;
    }

    /**
     * Sets the prod reg reg desc.
     *
     * @param prodRegRegDesc
     *            the new prod reg reg desc
     */
    public final void setProdRegRegDesc(final String prodRegRegDesc) {
        this.prodRegRegDesc = prodRegRegDesc;
    }

    /**
     * Gets the prod reg id.
     *
     * @return the prod reg id
     */
    public final String getProdRegId() {
        return prodRegId;
    }

    /**
     * Sets the prod reg id.
     *
     * @param prodRegId
     *            the new prod reg id
     */
    public final void setProdRegId(final String prodRegId) {
        this.prodRegId = prodRegId;
    }

    /**
     * Gets the prod reglast update date.
     *
     * @return the prod reglast update date
     */
    public final String getProdReglastUpdateDate() {
        return prodReglastUpdateDate;
    }

    /**
     * Sets the prod reglast update date.
     *
     * @param prodReglastUpdateDate
     *            the new prod reglast update date
     */
    public final void setProdReglastUpdateDate(
            final String prodReglastUpdateDate) {
        this.prodReglastUpdateDate = prodReglastUpdateDate;
    }

}
