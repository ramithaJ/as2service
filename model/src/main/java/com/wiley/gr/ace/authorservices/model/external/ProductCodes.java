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
 * The Class ProductCodes.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT_CODES")
public class ProductCodes {

    /** The prod cd dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String prodCdDhProdId;

    /** The ordinal cod pos. */
    @XmlElement(name = "ORDINAL_CODE_POS")
    private String ordinalCodPos;

    /** The ref code cd. */
    @XmlElement(name = "REF_CODE_ID")
    private String refCodeCd;

    /** The prod cd dh type cd. */
    @XmlElement(name = "DH_TYPE_CD")
    private String prodCdDhTypeCd;

    /** The prod cd doc type. */
    @XmlElement(name = "doc_type")
    private String prodCdDocType;

    /** The prod cd dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String prodCdDhRegId;

    /** The prod cd reg desc. */
    @XmlElement(name = "REG_DESC")
    private String prodCdRegDesc;

    /** The prod cd id. */
    @XmlElement(name = "id")
    private String prodCdId;

    /** The prod cd ref code type. */
    @XmlElement(name = "REF_CODE_TYPE")
    private String prodCdRefCodeType;

    /** The code value. */
    @XmlElement(name = "CODE_VALUE")
    private String codeValue;

    /** The prod cd dh id. */
    @XmlElement(name = "DH_ID")
    private String prodCdDhId;

    /** The prod cd reg id. */
    @XmlElement(name = "REG_CD")
    private String prodCdRegId;

    /** The prod cd dh prod reg id. */
    @XmlElement(name = "DH_PRODREG_ID")
    private String prodCdDhProdRegId;

    /** The prod cd dh prod reg cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String prodCdDhProdRegCd;

    /** The prod cd last update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String prodCdLastUpdateDate;

    /**
     * Gets the prod cd dh prod id.
     *
     * @return the prod cd dh prod id
     */
    public final String getProdCdDhProdId() {
        return prodCdDhProdId;
    }

    /**
     * Sets the prod cd dh prod id.
     *
     * @param prodCdDhProdId
     *            the new prod cd dh prod id
     */
    public final void setProdCdDhProdId(final String prodCdDhProdId) {
        this.prodCdDhProdId = prodCdDhProdId;
    }

    /**
     * Gets the ordinal cod pos.
     *
     * @return the ordinal cod pos
     */
    public final String getOrdinalCodPos() {
        return ordinalCodPos;
    }

    /**
     * Sets the ordinal cod pos.
     *
     * @param ordinalCodPos
     *            the new ordinal cod pos
     */
    public final void setOrdinalCodPos(final String ordinalCodPos) {
        this.ordinalCodPos = ordinalCodPos;
    }

    /**
     * Gets the ref code cd.
     *
     * @return the ref code cd
     */
    public final String getRefCodeCd() {
        return refCodeCd;
    }

    /**
     * Sets the ref code cd.
     *
     * @param refCodeCd
     *            the new ref code cd
     */
    public final void setRefCodeCd(final String refCodeCd) {
        this.refCodeCd = refCodeCd;
    }

    /**
     * Gets the prod cd dh type cd.
     *
     * @return the prod cd dh type cd
     */
    public final String getProdCdDhTypeCd() {
        return prodCdDhTypeCd;
    }

    /**
     * Sets the prod cd dh type cd.
     *
     * @param prodCdDhTypeCd
     *            the new prod cd dh type cd
     */
    public final void setProdCdDhTypeCd(final String prodCdDhTypeCd) {
        this.prodCdDhTypeCd = prodCdDhTypeCd;
    }

    /**
     * Gets the prod cd doc type.
     *
     * @return the prod cd doc type
     */
    public final String getProdCdDocType() {
        return prodCdDocType;
    }

    /**
     * Sets the prod cd doc type.
     *
     * @param prodCdDocType
     *            the new prod cd doc type
     */
    public final void setProdCdDocType(final String prodCdDocType) {
        this.prodCdDocType = prodCdDocType;
    }

    /**
     * Gets the prod cd dh reg id.
     *
     * @return the prod cd dh reg id
     */
    public final String getProdCdDhRegId() {
        return prodCdDhRegId;
    }

    /**
     * Sets the prod cd dh reg id.
     *
     * @param prodCdDhRegId
     *            the new prod cd dh reg id
     */
    public final void setProdCdDhRegId(final String prodCdDhRegId) {
        this.prodCdDhRegId = prodCdDhRegId;
    }

    /**
     * Gets the prod cd reg desc.
     *
     * @return the prod cd reg desc
     */
    public final String getProdCdRegDesc() {
        return prodCdRegDesc;
    }

    /**
     * Sets the prod cd reg desc.
     *
     * @param prodCdRegDesc
     *            the new prod cd reg desc
     */
    public final void setProdCdRegDesc(final String prodCdRegDesc) {
        this.prodCdRegDesc = prodCdRegDesc;
    }

    /**
     * Gets the prod cd id.
     *
     * @return the prod cd id
     */
    public final String getProdCdId() {
        return prodCdId;
    }

    /**
     * Sets the prod cd id.
     *
     * @param prodCdId
     *            the new prod cd id
     */
    public final void setProdCdId(final String prodCdId) {
        this.prodCdId = prodCdId;
    }

    /**
     * Gets the prod cd ref code type.
     *
     * @return the prod cd ref code type
     */
    public final String getProdCdRefCodeType() {
        return prodCdRefCodeType;
    }

    /**
     * Sets the prod cd ref code type.
     *
     * @param prodCdRefCodeType
     *            the new prod cd ref code type
     */
    public final void setProdCdRefCodeType(final String prodCdRefCodeType) {
        this.prodCdRefCodeType = prodCdRefCodeType;
    }

    /**
     * Gets the code value.
     *
     * @return the code value
     */
    public final String getCodeValue() {
        return codeValue;
    }

    /**
     * Sets the code value.
     *
     * @param codeValue
     *            the new code value
     */
    public final void setCodeValue(final String codeValue) {
        this.codeValue = codeValue;
    }

    /**
     * Gets the prod cd dh id.
     *
     * @return the prod cd dh id
     */
    public final String getProdCdDhId() {
        return prodCdDhId;
    }

    /**
     * Sets the prod cd dh id.
     *
     * @param prodCdDhId
     *            the new prod cd dh id
     */
    public final void setProdCdDhId(final String prodCdDhId) {
        this.prodCdDhId = prodCdDhId;
    }

    /**
     * Gets the prod cd reg id.
     *
     * @return the prod cd reg id
     */
    public final String getProdCdRegId() {
        return prodCdRegId;
    }

    /**
     * Sets the prod cd reg id.
     *
     * @param prodCdRegId
     *            the new prod cd reg id
     */
    public final void setProdCdRegId(final String prodCdRegId) {
        this.prodCdRegId = prodCdRegId;
    }

    /**
     * Gets the prod cd dh prod reg id.
     *
     * @return the prod cd dh prod reg id
     */
    public final String getProdCdDhProdRegId() {
        return prodCdDhProdRegId;
    }

    /**
     * Sets the prod cd dh prod reg id.
     *
     * @param prodCdDhProdRegId
     *            the new prod cd dh prod reg id
     */
    public final void setProdCdDhProdRegId(final String prodCdDhProdRegId) {
        this.prodCdDhProdRegId = prodCdDhProdRegId;
    }

    /**
     * Gets the prod cd dh prod reg cd.
     *
     * @return the prod cd dh prod reg cd
     */
    public final String getProdCdDhProdRegCd() {
        return prodCdDhProdRegCd;
    }

    /**
     * Sets the prod cd dh prod reg cd.
     *
     * @param prodCdDhProdRegCd
     *            the new prod cd dh prod reg cd
     */
    public final void setProdCdDhProdRegCd(final String prodCdDhProdRegCd) {
        this.prodCdDhProdRegCd = prodCdDhProdRegCd;
    }

    /**
     * Gets the prod cd last update date.
     *
     * @return the prod cd last update date
     */
    public final String getProdCdLastUpdateDate() {
        return prodCdLastUpdateDate;
    }

    /**
     * Sets the prod cd last update date.
     *
     * @param prodCdLastUpdateDate
     *            the new prod cd last update date
     */
    public final void setProdCdLastUpdateDate(final String prodCdLastUpdateDate) {
        this.prodCdLastUpdateDate = prodCdLastUpdateDate;
    }

}
