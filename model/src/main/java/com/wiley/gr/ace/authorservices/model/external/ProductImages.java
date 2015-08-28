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
 * The Class ProductImages.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT_IMAGES")
public class ProductImages {

    /** The prod img dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String prodImgDhProdId;

    /** The prod img dh type cd. */
    @XmlElement(name = "DH_TYPE_CD")
    private String prodImgDhTypeCd;

    /** The prod img doc type. */
    @XmlElement(name = "doc_type")
    private String prodImgDocType;

    /** The prod img dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String prodImgDhRegId;

    /** The prod img reg desc. */
    @XmlElement(name = "REG_DESC")
    private String prodImgRegDesc;

    /** The prod img id. */
    @XmlElement(name = "id")
    private String prodImgId;

    /** The image link. */
    @XmlElement(name = "IMAGE_LINK")
    private String imageLink;

    /** The prod img dh id. */
    @XmlElement(name = "DH_ID")
    private String prodImgDhId;

    /** The prod img reg cd. */
    @XmlElement(name = "REG_CD")
    private String prodImgRegCd;

    /** The prod img dh prod reg id. */
    @XmlElement(name = "DH_PRODREG_ID")
    private String prodImgDhProdRegId;

    /** The prod img dh prod type cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String prodImgDhProdTypeCd;

    /** The prod img last update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String prodImgLastUpdateDate;

    /**
     * Gets the prod img dh prod id.
     *
     * @return the prod img dh prod id
     */
    public final String getProdImgDhProdId() {
        return prodImgDhProdId;
    }

    /**
     * Sets the prod img dh prod id.
     *
     * @param prodImgDhProdId
     *            the new prod img dh prod id
     */
    public final void setProdImgDhProdId(final String prodImgDhProdId) {
        this.prodImgDhProdId = prodImgDhProdId;
    }

    /**
     * Gets the prod img dh type cd.
     *
     * @return the prod img dh type cd
     */
    public final String getProdImgDhTypeCd() {
        return prodImgDhTypeCd;
    }

    /**
     * Sets the prod img dh type cd.
     *
     * @param prodImgDhTypeCd
     *            the new prod img dh type cd
     */
    public final void setProdImgDhTypeCd(final String prodImgDhTypeCd) {
        this.prodImgDhTypeCd = prodImgDhTypeCd;
    }

    /**
     * Gets the prod img doc type.
     *
     * @return the prod img doc type
     */
    public final String getProdImgDocType() {
        return prodImgDocType;
    }

    /**
     * Sets the prod img doc type.
     *
     * @param prodImgDocType
     *            the new prod img doc type
     */
    public final void setProdImgDocType(final String prodImgDocType) {
        this.prodImgDocType = prodImgDocType;
    }

    /**
     * Gets the prod img dh reg id.
     *
     * @return the prod img dh reg id
     */
    public final String getProdImgDhRegId() {
        return prodImgDhRegId;
    }

    /**
     * Sets the prod img dh reg id.
     *
     * @param prodImgDhRegId
     *            the new prod img dh reg id
     */
    public final void setProdImgDhRegId(final String prodImgDhRegId) {
        this.prodImgDhRegId = prodImgDhRegId;
    }

    /**
     * Gets the prod img reg desc.
     *
     * @return the prod img reg desc
     */
    public final String getProdImgRegDesc() {
        return prodImgRegDesc;
    }

    /**
     * Sets the prod img reg desc.
     *
     * @param prodImgRegDesc
     *            the new prod img reg desc
     */
    public final void setProdImgRegDesc(final String prodImgRegDesc) {
        this.prodImgRegDesc = prodImgRegDesc;
    }

    /**
     * Gets the prod img id.
     *
     * @return the prod img id
     */
    public final String getProdImgId() {
        return prodImgId;
    }

    /**
     * Sets the prod img id.
     *
     * @param prodImgId
     *            the new prod img id
     */
    public final void setProdImgId(final String prodImgId) {
        this.prodImgId = prodImgId;
    }

    /**
     * Gets the image link.
     *
     * @return the image link
     */
    public final String getImageLink() {
        return imageLink;
    }

    /**
     * Sets the image link.
     *
     * @param imageLink
     *            the new image link
     */
    public final void setImageLink(final String imageLink) {
        this.imageLink = imageLink;
    }

    /**
     * Gets the prod img dh id.
     *
     * @return the prod img dh id
     */
    public final String getProdImgDhId() {
        return prodImgDhId;
    }

    /**
     * Sets the prod img dh id.
     *
     * @param prodImgDhId
     *            the new prod img dh id
     */
    public final void setProdImgDhId(final String prodImgDhId) {
        this.prodImgDhId = prodImgDhId;
    }

    /**
     * Gets the prod img reg cd.
     *
     * @return the prod img reg cd
     */
    public final String getProdImgRegCd() {
        return prodImgRegCd;
    }

    /**
     * Sets the prod img reg cd.
     *
     * @param prodImgRegCd
     *            the new prod img reg cd
     */
    public final void setProdImgRegCd(final String prodImgRegCd) {
        this.prodImgRegCd = prodImgRegCd;
    }

    /**
     * Gets the prod img dh prod reg id.
     *
     * @return the prod img dh prod reg id
     */
    public final String getProdImgDhProdRegId() {
        return prodImgDhProdRegId;
    }

    /**
     * Sets the prod img dh prod reg id.
     *
     * @param prodImgDhProdRegId
     *            the new prod img dh prod reg id
     */
    public final void setProdImgDhProdRegId(final String prodImgDhProdRegId) {
        this.prodImgDhProdRegId = prodImgDhProdRegId;
    }

    /**
     * Gets the prod img dh prod type cd.
     *
     * @return the prod img dh prod type cd
     */
    public final String getProdImgDhProdTypeCd() {
        return prodImgDhProdTypeCd;
    }

    /**
     * Sets the prod img dh prod type cd.
     *
     * @param prodImgDhProdTypeCd
     *            the new prod img dh prod type cd
     */
    public final void setProdImgDhProdTypeCd(final String prodImgDhProdTypeCd) {
        this.prodImgDhProdTypeCd = prodImgDhProdTypeCd;
    }

    /**
     * Gets the prod img last update date.
     *
     * @return the prod img last update date
     */
    public final String getProdImgLastUpdateDate() {
        return prodImgLastUpdateDate;
    }

    /**
     * Sets the prod img last update date.
     *
     * @param prodImgLastUpdateDate
     *            the new prod img last update date
     */
    public final void setProdImgLastUpdateDate(
            final String prodImgLastUpdateDate) {
        this.prodImgLastUpdateDate = prodImgLastUpdateDate;
    }

}
