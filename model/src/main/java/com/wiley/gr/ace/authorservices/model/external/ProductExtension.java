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
 * The Class ProductExtension.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT_EXTENSION")
public class ProductExtension {

    /** The prod extn dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String prodExtnDhProdId;

    /** The ext value. */
    @XmlElement(name = "EXT_VALUE")
    private String extValue;

    /** The dh ext cd. */
    @XmlElement(name = "DH_EXT_CD")
    private String dhExtCd;

    /** The prod extn doc type. */
    @XmlElement(name = "doc_type")
    private String prodExtnDocType;

    /** The prod extn dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String prodExtnDhRegId;

    /** The prod extn reg desc. */
    @XmlElement(name = "REG_DESC")
    private String prodExtnRegDesc;

    /** The prod extn id. */
    @XmlElement(name = "id")
    private String prodExtnId;

    /** The prod extn dh id. */
    @XmlElement(name = "DH_ID")
    private String prodExtnDhId;

    /** The prod extn reg cd. */
    @XmlElement(name = "REG_CD")
    private String prodExtnRegCd;

    /** The prod extn dh prod reg cd. */
    @XmlElement(name = "DH_PRODREG_ID")
    private String prodExtnDhProdRegCd;

    /** The prod extn dh prod type cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String prodExtnDhProdTypeCd;

    /** The prod extn last update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String prodExtnLastUpdateDate;

    /**
     * Gets the prod extn dh prod id.
     *
     * @return the prod extn dh prod id
     */
    public final String getProdExtnDhProdId() {
        return prodExtnDhProdId;
    }

    /**
     * Sets the prod extn dh prod id.
     *
     * @param prodExtnDhProdId
     *            the new prod extn dh prod id
     */
    public final void setProdExtnDhProdId(final String prodExtnDhProdId) {
        this.prodExtnDhProdId = prodExtnDhProdId;
    }

    /**
     * Gets the ext value.
     *
     * @return the ext value
     */
    public final String getExtValue() {
        return extValue;
    }

    /**
     * Sets the ext value.
     *
     * @param extValue
     *            the new ext value
     */
    public final void setExtValue(final String extValue) {
        this.extValue = extValue;
    }

    /**
     * Gets the dh ext cd.
     *
     * @return the dh ext cd
     */
    public final String getDhExtCd() {
        return dhExtCd;
    }

    /**
     * Sets the dh ext cd.
     *
     * @param dhExtCd
     *            the new dh ext cd
     */
    public final void setDhExtCd(final String dhExtCd) {
        this.dhExtCd = dhExtCd;
    }

    /**
     * Gets the prod extn doc type.
     *
     * @return the prod extn doc type
     */
    public final String getProdExtnDocType() {
        return prodExtnDocType;
    }

    /**
     * Sets the prod extn doc type.
     *
     * @param prodExtnDocType
     *            the new prod extn doc type
     */
    public final void setProdExtnDocType(final String prodExtnDocType) {
        this.prodExtnDocType = prodExtnDocType;
    }

    /**
     * Gets the prod extn dh reg id.
     *
     * @return the prod extn dh reg id
     */
    public final String getProdExtnDhRegId() {
        return prodExtnDhRegId;
    }

    /**
     * Sets the prod extn dh reg id.
     *
     * @param prodExtnDhRegId
     *            the new prod extn dh reg id
     */
    public final void setProdExtnDhRegId(final String prodExtnDhRegId) {
        this.prodExtnDhRegId = prodExtnDhRegId;
    }

    /**
     * Gets the prod extn reg desc.
     *
     * @return the prod extn reg desc
     */
    public final String getProdExtnRegDesc() {
        return prodExtnRegDesc;
    }

    /**
     * Sets the prod extn reg desc.
     *
     * @param prodExtnRegDesc
     *            the new prod extn reg desc
     */
    public final void setProdExtnRegDesc(final String prodExtnRegDesc) {
        this.prodExtnRegDesc = prodExtnRegDesc;
    }

    /**
     * Gets the prod extn id.
     *
     * @return the prod extn id
     */
    public final String getProdExtnId() {
        return prodExtnId;
    }

    /**
     * Sets the prod extn id.
     *
     * @param prodExtnId
     *            the new prod extn id
     */
    public final void setProdExtnId(final String prodExtnId) {
        this.prodExtnId = prodExtnId;
    }

    /**
     * Gets the prod extn dh id.
     *
     * @return the prod extn dh id
     */
    public final String getProdExtnDhId() {
        return prodExtnDhId;
    }

    /**
     * Sets the prod extn dh id.
     *
     * @param prodExtnDhId
     *            the new prod extn dh id
     */
    public final void setProdExtnDhId(final String prodExtnDhId) {
        this.prodExtnDhId = prodExtnDhId;
    }

    /**
     * Gets the prod extn reg cd.
     *
     * @return the prod extn reg cd
     */
    public final String getProdExtnRegCd() {
        return prodExtnRegCd;
    }

    /**
     * Sets the prod extn reg cd.
     *
     * @param prodExtnRegCd
     *            the new prod extn reg cd
     */
    public final void setProdExtnRegCd(final String prodExtnRegCd) {
        this.prodExtnRegCd = prodExtnRegCd;
    }

    /**
     * Gets the prod extn dh prod reg cd.
     *
     * @return the prod extn dh prod reg cd
     */
    public final String getProdExtnDhProdRegCd() {
        return prodExtnDhProdRegCd;
    }

    /**
     * Sets the prod extn dh prod reg cd.
     *
     * @param prodExtnDhProdRegCd
     *            the new prod extn dh prod reg cd
     */
    public final void setProdExtnDhProdRegCd(final String prodExtnDhProdRegCd) {
        this.prodExtnDhProdRegCd = prodExtnDhProdRegCd;
    }

    /**
     * Gets the prod extn dh prod type cd.
     *
     * @return the prod extn dh prod type cd
     */
    public final String getProdExtnDhProdTypeCd() {
        return prodExtnDhProdTypeCd;
    }

    /**
     * Sets the prod extn dh prod type cd.
     *
     * @param prodExtnDhProdTypeCd
     *            the new prod extn dh prod type cd
     */
    public final void setProdExtnDhProdTypeCd(final String prodExtnDhProdTypeCd) {
        this.prodExtnDhProdTypeCd = prodExtnDhProdTypeCd;
    }

    /**
     * Gets the prod extn last update date.
     *
     * @return the prod extn last update date
     */
    public final String getProdExtnLastUpdateDate() {
        return prodExtnLastUpdateDate;
    }

    /**
     * Sets the prod extn last update date.
     *
     * @param prodExtnLastUpdateDate
     *            the new prod extn last update date
     */
    public final void setProdExtnLastUpdateDate(
            final String prodExtnLastUpdateDate) {
        this.prodExtnLastUpdateDate = prodExtnLastUpdateDate;
    }

}
