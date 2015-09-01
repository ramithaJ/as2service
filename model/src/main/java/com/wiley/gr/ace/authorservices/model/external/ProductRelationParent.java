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
 * The Class ProductRelationParent.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT_RELATION_PARENT")
public class ProductRelationParent {

    /** The dh par prod id. */
    @XmlElement(name = "DH_PAR_PROD_ID")
    private String dhParProdId;

    /** The dh rel type cd. */
    @XmlElement(name = "DH_REL_TYPE_CD")
    private String dhRelTypeCd;

    /** The doc type. */
    @XmlElement(name = "doc_type")
    private String docType;

    /** The dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String dhRegId;

    /** The reg desc. */
    @XmlElement(name = "REG_DESC")
    private String regDesc;

    /** The id. */
    @XmlElement(name = "id")
    private String id;

    /** The dh id. */
    @XmlElement(name = "DH_ID")
    private String dhId;

    /** The reg cd. */
    @XmlElement(name = "REG_CD")
    private String regCd;

    /** The dh prod type cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String dhProdTypeCd;

    /** The dh child prod id. */
    @XmlElement(name = "DH_CHILD_PROD_ID")
    private String dhChildProdId;

    /** The dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String dhProdId;

    /** The dh child prod reg id. */
    @XmlElement(name = "DH_CHILD_PRODREG_ID")
    private String dhChildProdRegId;

    /** The dh par prod reg id. */
    @XmlElement(name = "DH_PAR_PRODREG_ID")
    private String dhParProdRegId;

    /** The last update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String lastUpdateDate;

    /**
     * Gets the dh par prod id.
     *
     * @return the dh par prod id
     */
    public final String getDhParProdId() {
        return dhParProdId;
    }

    /**
     * Sets the dh par prod id.
     *
     * @param dhParProdId
     *            the new dh par prod id
     */
    public final void setDhParProdId(final String dhParProdId) {
        this.dhParProdId = dhParProdId;
    }

    /**
     * Gets the dh rel type cd.
     *
     * @return the dh rel type cd
     */
    public final String getDhRelTypeCd() {
        return dhRelTypeCd;
    }

    /**
     * Sets the dh rel type cd.
     *
     * @param dhRelTypeCd
     *            the new dh rel type cd
     */
    public final void setDhRelTypeCd(final String dhRelTypeCd) {
        this.dhRelTypeCd = dhRelTypeCd;
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
     * Gets the dh reg id.
     *
     * @return the dh reg id
     */
    public final String getDhRegId() {
        return dhRegId;
    }

    /**
     * Sets the dh reg id.
     *
     * @param dhRegId
     *            the new dh reg id
     */
    public final void setDhRegId(final String dhRegId) {
        this.dhRegId = dhRegId;
    }

    /**
     * Gets the reg desc.
     *
     * @return the reg desc
     */
    public final String getRegDesc() {
        return regDesc;
    }

    /**
     * Sets the reg desc.
     *
     * @param regDesc
     *            the new reg desc
     */
    public final void setRegDesc(final String regDesc) {
        this.regDesc = regDesc;
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
     * Gets the reg cd.
     *
     * @return the reg cd
     */
    public final String getRegCd() {
        return regCd;
    }

    /**
     * Sets the reg cd.
     *
     * @param regCd
     *            the new reg cd
     */
    public final void setRegCd(final String regCd) {
        this.regCd = regCd;
    }

    /**
     * Gets the dh prod type cd.
     *
     * @return the dh prod type cd
     */
    public final String getDhProdTypeCd() {
        return dhProdTypeCd;
    }

    /**
     * Sets the dh prod type cd.
     *
     * @param dhProdTypeCd
     *            the new dh prod type cd
     */
    public final void setDhProdTypeCd(final String dhProdTypeCd) {
        this.dhProdTypeCd = dhProdTypeCd;
    }

    /**
     * Gets the dh child prod id.
     *
     * @return the dh child prod id
     */
    public final String getDhChildProdId() {
        return dhChildProdId;
    }

    /**
     * Sets the dh child prod id.
     *
     * @param dhChildProdId
     *            the new dh child prod id
     */
    public final void setDhChildProdId(final String dhChildProdId) {
        this.dhChildProdId = dhChildProdId;
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
     * Gets the dh child prod reg id.
     *
     * @return the dh child prod reg id
     */
    public final String getDhChildProdRegId() {
        return dhChildProdRegId;
    }

    /**
     * Sets the dh child prod reg id.
     *
     * @param dhChildProdRegId
     *            the new dh child prod reg id
     */
    public final void setDhChildProdRegId(final String dhChildProdRegId) {
        this.dhChildProdRegId = dhChildProdRegId;
    }

    /**
     * Gets the dh par prod reg id.
     *
     * @return the dh par prod reg id
     */
    public final String getDhParProdRegId() {
        return dhParProdRegId;
    }

    /**
     * Sets the dh par prod reg id.
     *
     * @param dhParProdRegId
     *            the new dh par prod reg id
     */
    public final void setDhParProdRegId(final String dhParProdRegId) {
        this.dhParProdRegId = dhParProdRegId;
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
