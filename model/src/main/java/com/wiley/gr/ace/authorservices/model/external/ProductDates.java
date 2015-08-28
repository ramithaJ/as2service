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
 * The Class ProductDates.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT_DATES")
public class ProductDates {

    /** The prod dt dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String prodDtDhProdId;

    /** The prod dt dh id. */
    @XmlElement(name = "DH_ID")
    private String prodDtDhId;

    /** The prod dt reg cd. */
    @XmlElement(name = "REG_CD")
    private String prodDtRegCd;

    /** The dh date type cd. */
    @XmlElement(name = "DH_DATE_TYPE_CD")
    private String dhDateTypeCd;

    /** The prod dt dh prod reg id. */
    @XmlElement(name = "DH_PRODREG_ID")
    private String prodDtDhProdRegId;

    /** The prod dt dh prod type cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String prodDtDhProdTypeCd;

    /** The prod dt doc type. */
    @XmlElement(name = "doc_type")
    private String prodDtDocType;

    /** The prod dt dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String prodDtDhRegId;

    /** The prod dt reg desc. */
    @XmlElement(name = "REG_DESC")
    private String prodDtRegDesc;

    /** The prod dt id. */
    @XmlElement(name = "id")
    private String prodDtId;

    /** The prod dt date value. */
    @XmlElement(name = "DATE_VALUE")
    private String prodDtDateValue;

    /** The prod dt last update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String prodDtLastUpdateDate;

    /**
     * Gets the prod dt dh prod id.
     *
     * @return the prod dt dh prod id
     */
    public final String getProdDtDhProdId() {
        return prodDtDhProdId;
    }

    /**
     * Sets the prod dt dh prod id.
     *
     * @param prodDtDhProdId
     *            the new prod dt dh prod id
     */
    public final void setProdDtDhProdId(final String prodDtDhProdId) {
        this.prodDtDhProdId = prodDtDhProdId;
    }

    /**
     * Gets the prod dt dh id.
     *
     * @return the prod dt dh id
     */
    public final String getProdDtDhId() {
        return prodDtDhId;
    }

    /**
     * Sets the prod dt dh id.
     *
     * @param prodDtDhId
     *            the new prod dt dh id
     */
    public final void setProdDtDhId(final String prodDtDhId) {
        this.prodDtDhId = prodDtDhId;
    }

    /**
     * Gets the prod dt reg cd.
     *
     * @return the prod dt reg cd
     */
    public final String getProdDtRegCd() {
        return prodDtRegCd;
    }

    /**
     * Sets the prod dt reg cd.
     *
     * @param prodDtRegCd
     *            the new prod dt reg cd
     */
    public final void setProdDtRegCd(final String prodDtRegCd) {
        this.prodDtRegCd = prodDtRegCd;
    }

    /**
     * Gets the dh date type cd.
     *
     * @return the dh date type cd
     */
    public final String getDhDateTypeCd() {
        return dhDateTypeCd;
    }

    /**
     * Sets the dh date type cd.
     *
     * @param dhDateTypeCd
     *            the new dh date type cd
     */
    public final void setDhDateTypeCd(final String dhDateTypeCd) {
        this.dhDateTypeCd = dhDateTypeCd;
    }

    /**
     * Gets the prod dt dh prod reg id.
     *
     * @return the prod dt dh prod reg id
     */
    public final String getProdDtDhProdRegId() {
        return prodDtDhProdRegId;
    }

    /**
     * Sets the prod dt dh prod reg id.
     *
     * @param prodDtDhProdRegId
     *            the new prod dt dh prod reg id
     */
    public final void setProdDtDhProdRegId(final String prodDtDhProdRegId) {
        this.prodDtDhProdRegId = prodDtDhProdRegId;
    }

    /**
     * Gets the prod dt dh prod type cd.
     *
     * @return the prod dt dh prod type cd
     */
    public final String getProdDtDhProdTypeCd() {
        return prodDtDhProdTypeCd;
    }

    /**
     * Sets the prod dt dh prod type cd.
     *
     * @param prodDtDhProdTypeCd
     *            the new prod dt dh prod type cd
     */
    public final void setProdDtDhProdTypeCd(final String prodDtDhProdTypeCd) {
        this.prodDtDhProdTypeCd = prodDtDhProdTypeCd;
    }

    /**
     * Gets the prod dt doc type.
     *
     * @return the prod dt doc type
     */
    public final String getProdDtDocType() {
        return prodDtDocType;
    }

    /**
     * Sets the prod dt doc type.
     *
     * @param prodDtDocType
     *            the new prod dt doc type
     */
    public final void setProdDtDocType(final String prodDtDocType) {
        this.prodDtDocType = prodDtDocType;
    }

    /**
     * Gets the prod dt dh reg id.
     *
     * @return the prod dt dh reg id
     */
    public final String getProdDtDhRegId() {
        return prodDtDhRegId;
    }

    /**
     * Sets the prod dt dh reg id.
     *
     * @param prodDtDhRegId
     *            the new prod dt dh reg id
     */
    public final void setProdDtDhRegId(final String prodDtDhRegId) {
        this.prodDtDhRegId = prodDtDhRegId;
    }

    /**
     * Gets the prod dt reg desc.
     *
     * @return the prod dt reg desc
     */
    public final String getProdDtRegDesc() {
        return prodDtRegDesc;
    }

    /**
     * Sets the prod dt reg desc.
     *
     * @param prodDtRegDesc
     *            the new prod dt reg desc
     */
    public final void setProdDtRegDesc(final String prodDtRegDesc) {
        this.prodDtRegDesc = prodDtRegDesc;
    }

    /**
     * Gets the prod dt id.
     *
     * @return the prod dt id
     */
    public final String getProdDtId() {
        return prodDtId;
    }

    /**
     * Sets the prod dt id.
     *
     * @param prodDtId
     *            the new prod dt id
     */
    public final void setProdDtId(final String prodDtId) {
        this.prodDtId = prodDtId;
    }

    /**
     * Gets the prod dt date value.
     *
     * @return the prod dt date value
     */
    public final String getProdDtDateValue() {
        return prodDtDateValue;
    }

    /**
     * Sets the prod dt date value.
     *
     * @param prodDtDateValue
     *            the new prod dt date value
     */
    public final void setProdDtDateValue(final String prodDtDateValue) {
        this.prodDtDateValue = prodDtDateValue;
    }

    /**
     * Gets the prod dt last update date.
     *
     * @return the prod dt last update date
     */
    public final String getProdDtLastUpdateDate() {
        return prodDtLastUpdateDate;
    }

    /**
     * Sets the prod dt last update date.
     *
     * @param prodDtLastUpdateDate
     *            the new prod dt last update date
     */
    public final void setProdDtLastUpdateDate(final String prodDtLastUpdateDate) {
        this.prodDtLastUpdateDate = prodDtLastUpdateDate;
    }

}
