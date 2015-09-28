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
 * The Class ProductRelationChild.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT_RELATION_CHILD")
public class ProductRelationChild {

    /** The dh par prod id child. */
    @XmlElement(name = "DH_PAR_PROD_ID")
    private String dhParProdIdChild;

    /** The dh rel type cd child. */
    @XmlElement(name = "DH_REL_TYPE_CD")
    private String dhRelTypeCdChild;

    /** The doc type child. */
    @XmlElement(name = "doc_type")
    private String docTypeChild;

    /** The dh reg id child. */
    @XmlElement(name = "DH_REG_ID")
    private String dhRegIdChild;

    /** The reg desc child. */
    @XmlElement(name = "REG_DESC")
    private String regDescChild;

    /** The id child. */
    @XmlElement(name = "id")
    private String idChild;

    /** The dh id child. */
    @XmlElement(name = "DH_ID")
    private String dhIdChild;

    /** The reg cd child. */
    @XmlElement(name = "REG_CD")
    private String regCdChild;

    /** The dh prod type cd child. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String dhProdTypeCdChild;

    /** The dh child prod id. */
    @XmlElement(name = "DH_CHILD_PROD_ID")
    private String dhChildProdId;

    /** The dh prod id child. */
    @XmlElement(name = "DH_PROD_ID")
    private String dhProdIdChild;

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
     * Gets the dh par prod id child.
     *
     * @return the dh par prod id child
     */
    public final String getDhParProdIdChild() {
        return dhParProdIdChild;
    }

    /**
     * Sets the dh par prod id child.
     *
     * @param dhParProdIdChild
     *            the new dh par prod id child
     */
    public final void setDhParProdIdChild(final String dhParProdIdChild) {
        this.dhParProdIdChild = dhParProdIdChild;
    }

    /**
     * Gets the dh rel type cd child.
     *
     * @return the dh rel type cd child
     */
    public final String getDhRelTypeCdChild() {
        return dhRelTypeCdChild;
    }

    /**
     * Sets the dh rel type cd child.
     *
     * @param dhRelTypeCdChild
     *            the new dh rel type cd child
     */
    public final void setDhRelTypeCdChild(final String dhRelTypeCdChild) {
        this.dhRelTypeCdChild = dhRelTypeCdChild;
    }

    /**
     * Gets the doc type child.
     *
     * @return the doc type child
     */
    public final String getDocTypeChild() {
        return docTypeChild;
    }

    /**
     * Sets the doc type child.
     *
     * @param docTypeChild
     *            the new doc type child
     */
    public final void setDocTypeChild(final String docTypeChild) {
        this.docTypeChild = docTypeChild;
    }

    /**
     * Gets the dh reg id child.
     *
     * @return the dh reg id child
     */
    public final String getDhRegIdChild() {
        return dhRegIdChild;
    }

    /**
     * Sets the dh reg id child.
     *
     * @param dhRegIdChild
     *            the new dh reg id child
     */
    public final void setDhRegIdChild(final String dhRegIdChild) {
        this.dhRegIdChild = dhRegIdChild;
    }

    /**
     * Gets the reg desc child.
     *
     * @return the reg desc child
     */
    public final String getRegDescChild() {
        return regDescChild;
    }

    /**
     * Sets the reg desc child.
     *
     * @param regDescChild
     *            the new reg desc child
     */
    public final void setRegDescChild(final String regDescChild) {
        this.regDescChild = regDescChild;
    }

    /**
     * Gets the id child.
     *
     * @return the id child
     */
    public final String getIdChild() {
        return idChild;
    }

    /**
     * Sets the id child.
     *
     * @param idChild
     *            the new id child
     */
    public final void setIdChild(final String idChild) {
        this.idChild = idChild;
    }

    /**
     * Gets the dh id child.
     *
     * @return the dh id child
     */
    public final String getDhIdChild() {
        return dhIdChild;
    }

    /**
     * Sets the dh id child.
     *
     * @param dhIdChild
     *            the new dh id child
     */
    public final void setDhIdChild(final String dhIdChild) {
        this.dhIdChild = dhIdChild;
    }

    /**
     * Gets the reg cd child.
     *
     * @return the reg cd child
     */
    public final String getRegCdChild() {
        return regCdChild;
    }

    /**
     * Sets the reg cd child.
     *
     * @param regCdChild
     *            the new reg cd child
     */
    public final void setRegCdChild(final String regCdChild) {
        this.regCdChild = regCdChild;
    }

    /**
     * Gets the dh prod type cd child.
     *
     * @return the dh prod type cd child
     */
    public final String getDhProdTypeCdChild() {
        return dhProdTypeCdChild;
    }

    /**
     * Sets the dh prod type cd child.
     *
     * @param dhProdTypeCdChild
     *            the new dh prod type cd child
     */
    public final void setDhProdTypeCdChild(final String dhProdTypeCdChild) {
        this.dhProdTypeCdChild = dhProdTypeCdChild;
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
     * Gets the dh prod id child.
     *
     * @return the dh prod id child
     */
    public final String getDhProdIdChild() {
        return dhProdIdChild;
    }

    /**
     * Sets the dh prod id child.
     *
     * @param dhProdIdChild
     *            the new dh prod id child
     */
    public final void setDhProdIdChild(final String dhProdIdChild) {
        this.dhProdIdChild = dhProdIdChild;
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
