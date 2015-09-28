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
 * The Class ProductStatus.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT_STATUS")
public class ProductStatus {

    /** The prod status dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String prodStatusDhProdId;

    /** The prod status doc type. */
    @XmlElement(name = "doc_type")
    private String prodStatusDocType;

    /** The prod status dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String prodStatusDhRegId;

    /** The prod status reg desc. */
    @XmlElement(name = "REG_DESC")
    private String prodStatusRegDesc;

    /** The prod status id. */
    @XmlElement(name = "id")
    private String prodStatusId;

    /** The dh id. */
    @XmlElement(name = "DH_ID")
    private String dhId;

    /** The prod status reg cd. */
    @XmlElement(name = "REG_CD")
    private String prodStatusRegCd;

    /** The dh prod reg id. */
    @XmlElement(name = "DH_PRODREG_ID")
    private String dhProdRegId;

    /** The status value. */
    @XmlElement(name = "STATUS_VALUE")
    private String statusValue;

    /** The dh prod type cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String dhProdTypeCd;

    /** The dh status id. */
    @XmlElement(name = "DH_STATUS_ID")
    private String dhStatusId;

    /** The dh stat type cd. */
    @XmlElement(name = "DH_STAT_TYPE_CD")
    private String dhStatTypeCd;

    /** The prod status last update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String prodStatusLastUpdateDate;

    /**
     * Gets the prod status dh prod id.
     *
     * @return the prod status dh prod id
     */
    public final String getProdStatusDhProdId() {
        return prodStatusDhProdId;
    }

    /**
     * Sets the prod status dh prod id.
     *
     * @param prodStatusDhProdId
     *            the new prod status dh prod id
     */
    public final void setProdStatusDhProdId(final String prodStatusDhProdId) {
        this.prodStatusDhProdId = prodStatusDhProdId;
    }

    /**
     * Gets the prod status doc type.
     *
     * @return the prod status doc type
     */
    public final String getProdStatusDocType() {
        return prodStatusDocType;
    }

    /**
     * Sets the prod status doc type.
     *
     * @param prodStatusDocType
     *            the new prod status doc type
     */
    public final void setProdStatusDocType(final String prodStatusDocType) {
        this.prodStatusDocType = prodStatusDocType;
    }

    /**
     * Gets the prod status dh reg id.
     *
     * @return the prod status dh reg id
     */
    public final String getProdStatusDhRegId() {
        return prodStatusDhRegId;
    }

    /**
     * Sets the prod status dh reg id.
     *
     * @param prodStatusDhRegId
     *            the new prod status dh reg id
     */
    public final void setProdStatusDhRegId(final String prodStatusDhRegId) {
        this.prodStatusDhRegId = prodStatusDhRegId;
    }

    /**
     * Gets the prod status reg desc.
     *
     * @return the prod status reg desc
     */
    public final String getProdStatusRegDesc() {
        return prodStatusRegDesc;
    }

    /**
     * Sets the prod status reg desc.
     *
     * @param prodStatusRegDesc
     *            the new prod status reg desc
     */
    public final void setProdStatusRegDesc(final String prodStatusRegDesc) {
        this.prodStatusRegDesc = prodStatusRegDesc;
    }

    /**
     * Gets the prod status id.
     *
     * @return the prod status id
     */
    public final String getProdStatusId() {
        return prodStatusId;
    }

    /**
     * Sets the prod status id.
     *
     * @param prodStatusId
     *            the new prod status id
     */
    public final void setProdStatusId(final String prodStatusId) {
        this.prodStatusId = prodStatusId;
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
     * Gets the prod status reg cd.
     *
     * @return the prod status reg cd
     */
    public final String getProdStatusRegCd() {
        return prodStatusRegCd;
    }

    /**
     * Sets the prod status reg cd.
     *
     * @param prodStatusRegCd
     *            the new prod status reg cd
     */
    public final void setProdStatusRegCd(final String prodStatusRegCd) {
        this.prodStatusRegCd = prodStatusRegCd;
    }

    /**
     * Gets the dh prod reg id.
     *
     * @return the dh prod reg id
     */
    public final String getDhProdRegId() {
        return dhProdRegId;
    }

    /**
     * Sets the dh prod reg id.
     *
     * @param dhProdRegId
     *            the new dh prod reg id
     */
    public final void setDhProdRegId(final String dhProdRegId) {
        this.dhProdRegId = dhProdRegId;
    }

    /**
     * Gets the status value.
     *
     * @return the status value
     */
    public final String getStatusValue() {
        return statusValue;
    }

    /**
     * Sets the status value.
     *
     * @param statusValue
     *            the new status value
     */
    public final void setStatusValue(final String statusValue) {
        this.statusValue = statusValue;
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
     * Gets the dh status id.
     *
     * @return the dh status id
     */
    public final String getDhStatusId() {
        return dhStatusId;
    }

    /**
     * Sets the dh status id.
     *
     * @param dhStatusId
     *            the new dh status id
     */
    public final void setDhStatusId(final String dhStatusId) {
        this.dhStatusId = dhStatusId;
    }

    /**
     * Gets the dh stat type cd.
     *
     * @return the dh stat type cd
     */
    public final String getDhStatTypeCd() {
        return dhStatTypeCd;
    }

    /**
     * Sets the dh stat type cd.
     *
     * @param dhStatTypeCd
     *            the new dh stat type cd
     */
    public final void setDhStatTypeCd(final String dhStatTypeCd) {
        this.dhStatTypeCd = dhStatTypeCd;
    }

    /**
     * Gets the prod status last update date.
     *
     * @return the prod status last update date
     */
    public final String getProdStatusLastUpdateDate() {
        return prodStatusLastUpdateDate;
    }

    /**
     * Sets the prod status last update date.
     *
     * @param prodStatusLastUpdateDate
     *            the new prod status last update date
     */
    public final void setProdStatusLastUpdateDate(
            final String prodStatusLastUpdateDate) {
        this.prodStatusLastUpdateDate = prodStatusLastUpdateDate;
    }

}
