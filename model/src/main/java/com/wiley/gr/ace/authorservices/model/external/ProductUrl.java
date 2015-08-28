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
package com.wiley.gr.ace.authorservices.model.external;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class ProductUrl.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT_URL")
public class ProductUrl {

    /** The prod url dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String prodUrlDhProdId;

    /** The prod url dh type cd. */
    @XmlElement(name = "DH_TYPE_CD")
    private String prodUrlDhTypeCd;

    /** The prod url doc type. */
    @XmlElement(name = "doc_type")
    private String prodUrlDocType;

    /** The prod url dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String prodUrlDhRegId;

    /** The prod url reg desc. */
    @XmlElement(name = "REG_DESC")
    private String prodUrlRegDesc;

    /** The prod url id. */
    @XmlElement(name = "id")
    private String prodUrlId;

    /** The url. */
    @XmlElement(name = "URL")
    private String url;

    /** The prod url dh id. */
    @XmlElement(name = "DH_ID")
    private String prodUrlDhId;

    /** The prod url reg cd. */
    @XmlElement(name = "REG_CD")
    private String prodUrlRegCd;

    /** The prod url dh prod reg id. */
    @XmlElement(name = "DH_PRODREG_ID")
    private String prodUrlDhProdRegId;

    /** The prod url dh prod type cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String prodUrlDhProdTypeCd;

    /** The prod url last update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String prodUrlLastUpdateDate;

    /**
     * Gets the prod url dh prod id.
     *
     * @return the prod url dh prod id
     */
    public final String getProdUrlDhProdId() {
        return prodUrlDhProdId;
    }

    /**
     * Sets the prod url dh prod id.
     *
     * @param prodUrlDhProdId
     *            the new prod url dh prod id
     */
    public final void setProdUrlDhProdId(final String prodUrlDhProdId) {
        this.prodUrlDhProdId = prodUrlDhProdId;
    }

    /**
     * Gets the prod url dh type cd.
     *
     * @return the prod url dh type cd
     */
    public final String getProdUrlDhTypeCd() {
        return prodUrlDhTypeCd;
    }

    /**
     * Sets the prod url dh type cd.
     *
     * @param prodUrlDhTypeCd
     *            the new prod url dh type cd
     */
    public final void setProdUrlDhTypeCd(final String prodUrlDhTypeCd) {
        this.prodUrlDhTypeCd = prodUrlDhTypeCd;
    }

    /**
     * Gets the prod url doc type.
     *
     * @return the prod url doc type
     */
    public final String getProdUrlDocType() {
        return prodUrlDocType;
    }

    /**
     * Sets the prod url doc type.
     *
     * @param prodUrlDocType
     *            the new prod url doc type
     */
    public final void setProdUrlDocType(final String prodUrlDocType) {
        this.prodUrlDocType = prodUrlDocType;
    }

    /**
     * Gets the prod url dh reg id.
     *
     * @return the prod url dh reg id
     */
    public final String getProdUrlDhRegId() {
        return prodUrlDhRegId;
    }

    /**
     * Sets the prod url dh reg id.
     *
     * @param prodUrlDhRegId
     *            the new prod url dh reg id
     */
    public final void setProdUrlDhRegId(final String prodUrlDhRegId) {
        this.prodUrlDhRegId = prodUrlDhRegId;
    }

    /**
     * Gets the prod url reg desc.
     *
     * @return the prod url reg desc
     */
    public final String getProdUrlRegDesc() {
        return prodUrlRegDesc;
    }

    /**
     * Sets the prod url reg desc.
     *
     * @param prodUrlRegDesc
     *            the new prod url reg desc
     */
    public final void setProdUrlRegDesc(final String prodUrlRegDesc) {
        this.prodUrlRegDesc = prodUrlRegDesc;
    }

    /**
     * Gets the prod url id.
     *
     * @return the prod url id
     */
    public final String getProdUrlId() {
        return prodUrlId;
    }

    /**
     * Sets the prod url id.
     *
     * @param prodUrlId
     *            the new prod url id
     */
    public final void setProdUrlId(final String prodUrlId) {
        this.prodUrlId = prodUrlId;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public final String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url
     *            the new url
     */
    public final void setUrl(final String url) {
        this.url = url;
    }

    /**
     * Gets the prod url dh id.
     *
     * @return the prod url dh id
     */
    public final String getProdUrlDhId() {
        return prodUrlDhId;
    }

    /**
     * Sets the prod url dh id.
     *
     * @param prodUrlDhId
     *            the new prod url dh id
     */
    public final void setProdUrlDhId(final String prodUrlDhId) {
        this.prodUrlDhId = prodUrlDhId;
    }

    /**
     * Gets the prod url reg cd.
     *
     * @return the prod url reg cd
     */
    public final String getProdUrlRegCd() {
        return prodUrlRegCd;
    }

    /**
     * Sets the prod url reg cd.
     *
     * @param prodUrlRegCd
     *            the new prod url reg cd
     */
    public final void setProdUrlRegCd(final String prodUrlRegCd) {
        this.prodUrlRegCd = prodUrlRegCd;
    }

    /**
     * Gets the prod url dh prod reg id.
     *
     * @return the prod url dh prod reg id
     */
    public final String getProdUrlDhProdRegId() {
        return prodUrlDhProdRegId;
    }

    /**
     * Sets the prod url dh prod reg id.
     *
     * @param prodUrlDhProdRegId
     *            the new prod url dh prod reg id
     */
    public final void setProdUrlDhProdRegId(final String prodUrlDhProdRegId) {
        this.prodUrlDhProdRegId = prodUrlDhProdRegId;
    }

    /**
     * Gets the prod url dh prod type cd.
     *
     * @return the prod url dh prod type cd
     */
    public final String getProdUrlDhProdTypeCd() {
        return prodUrlDhProdTypeCd;
    }

    /**
     * Sets the prod url dh prod type cd.
     *
     * @param prodUrlDhProdTypeCd
     *            the new prod url dh prod type cd
     */
    public final void setProdUrlDhProdTypeCd(final String prodUrlDhProdTypeCd) {
        this.prodUrlDhProdTypeCd = prodUrlDhProdTypeCd;
    }

    /**
     * Gets the prod url last update date.
     *
     * @return the prod url last update date
     */
    public final String getProdUrlLastUpdateDate() {
        return prodUrlLastUpdateDate;
    }

    /**
     * Sets the prod url last update date.
     *
     * @param prodUrlLastUpdateDate
     *            the new prod url last update date
     */
    public final void setProdUrlLastUpdateDate(
            final String prodUrlLastUpdateDate) {
        this.prodUrlLastUpdateDate = prodUrlLastUpdateDate;
    }

}
