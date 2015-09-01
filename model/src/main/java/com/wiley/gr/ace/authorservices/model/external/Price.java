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
 * The Class Price.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRICE")
public class Price {

    /** The price dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String priceDhProdId;

    /** The price amt. */
    @XmlElement(name = "PRICE_AMT")
    private String priceAmt;

    /** The dh cust type cd. */
    @XmlElement(name = "DH_CUST_TYPE_CD")
    private String dhCustTypeCd;

    /** The dh price type cd. */
    @XmlElement(name = "DH_PRICE_TYPE_CD")
    private String dhPriceTypeCd;

    /** The price doc type. */
    @XmlElement(name = "doc_type")
    private String priceDocType;

    /** The price dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String priceDhRegId;

    /** The price reg desc. */
    @XmlElement(name = "REG_DESC")
    private String priceRegDesc;

    /** The price id. */
    @XmlElement(name = "id")
    private String priceId;

    /** The dh currency cd. */
    @XmlElement(name = "DH_CURRENCY_CD")
    private String dhCurrencyCd;

    /** The dh subscr type cd. */
    @XmlElement(name = "DH_SUBSCR_TYPE_CD")
    private String dhSubscrTypeCd;

    /** The price dh id. */
    @XmlElement(name = "DH_ID")
    private String priceDhId;

    /** The price reg cd. */
    @XmlElement(name = "REG_CD")
    private String priceRegCd;

    /** The price dh prod reg id. */
    @XmlElement(name = "DH_PRODREG_ID")
    private String priceDhProdRegId;

    /** The price dh prod type cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String priceDhProdTypeCd;

    /** The price start date. */
    @XmlElement(name = "START_DATE")
    private String priceStartDate;

    /** The price last update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String priceLastUpdateDate;

    /**
     * Gets the price dh prod id.
     *
     * @return the price dh prod id
     */
    public final String getPriceDhProdId() {
        return priceDhProdId;
    }

    /**
     * Sets the price dh prod id.
     *
     * @param priceDhProdId
     *            the new price dh prod id
     */
    public final void setPriceDhProdId(final String priceDhProdId) {
        this.priceDhProdId = priceDhProdId;
    }

    /**
     * Gets the price amt.
     *
     * @return the price amt
     */
    public final String getPriceAmt() {
        return priceAmt;
    }

    /**
     * Sets the price amt.
     *
     * @param priceAmt
     *            the new price amt
     */
    public final void setPriceAmt(final String priceAmt) {
        this.priceAmt = priceAmt;
    }

    /**
     * Gets the dh cust type cd.
     *
     * @return the dh cust type cd
     */
    public final String getDhCustTypeCd() {
        return dhCustTypeCd;
    }

    /**
     * Sets the dh cust type cd.
     *
     * @param dhCustTypeCd
     *            the new dh cust type cd
     */
    public final void setDhCustTypeCd(final String dhCustTypeCd) {
        this.dhCustTypeCd = dhCustTypeCd;
    }

    /**
     * Gets the dh price type cd.
     *
     * @return the dh price type cd
     */
    public final String getDhPriceTypeCd() {
        return dhPriceTypeCd;
    }

    /**
     * Sets the dh price type cd.
     *
     * @param dhPriceTypeCd
     *            the new dh price type cd
     */
    public final void setDhPriceTypeCd(final String dhPriceTypeCd) {
        this.dhPriceTypeCd = dhPriceTypeCd;
    }

    /**
     * Gets the price doc type.
     *
     * @return the price doc type
     */
    public final String getPriceDocType() {
        return priceDocType;
    }

    /**
     * Sets the price doc type.
     *
     * @param priceDocType
     *            the new price doc type
     */
    public final void setPriceDocType(final String priceDocType) {
        this.priceDocType = priceDocType;
    }

    /**
     * Gets the price dh reg id.
     *
     * @return the price dh reg id
     */
    public final String getPriceDhRegId() {
        return priceDhRegId;
    }

    /**
     * Sets the price dh reg id.
     *
     * @param priceDhRegId
     *            the new price dh reg id
     */
    public final void setPriceDhRegId(final String priceDhRegId) {
        this.priceDhRegId = priceDhRegId;
    }

    /**
     * Gets the price reg desc.
     *
     * @return the price reg desc
     */
    public final String getPriceRegDesc() {
        return priceRegDesc;
    }

    /**
     * Sets the price reg desc.
     *
     * @param priceRegDesc
     *            the new price reg desc
     */
    public final void setPriceRegDesc(final String priceRegDesc) {
        this.priceRegDesc = priceRegDesc;
    }

    /**
     * Gets the price id.
     *
     * @return the price id
     */
    public final String getPriceId() {
        return priceId;
    }

    /**
     * Sets the price id.
     *
     * @param priceId
     *            the new price id
     */
    public final void setPriceId(final String priceId) {
        this.priceId = priceId;
    }

    /**
     * Gets the dh currency cd.
     *
     * @return the dh currency cd
     */
    public final String getDhCurrencyCd() {
        return dhCurrencyCd;
    }

    /**
     * Sets the dh currency cd.
     *
     * @param dhCurrencyCd
     *            the new dh currency cd
     */
    public final void setDhCurrencyCd(final String dhCurrencyCd) {
        this.dhCurrencyCd = dhCurrencyCd;
    }

    /**
     * Gets the dh subscr type cd.
     *
     * @return the dh subscr type cd
     */
    public final String getDhSubscrTypeCd() {
        return dhSubscrTypeCd;
    }

    /**
     * Sets the dh subscr type cd.
     *
     * @param dhSubscrTypeCd
     *            the new dh subscr type cd
     */
    public final void setDhSubscrTypeCd(final String dhSubscrTypeCd) {
        this.dhSubscrTypeCd = dhSubscrTypeCd;
    }

    /**
     * Gets the price dh id.
     *
     * @return the price dh id
     */
    public final String getPriceDhId() {
        return priceDhId;
    }

    /**
     * Sets the price dh id.
     *
     * @param priceDhId
     *            the new price dh id
     */
    public final void setPriceDhId(final String priceDhId) {
        this.priceDhId = priceDhId;
    }

    /**
     * Gets the price reg cd.
     *
     * @return the price reg cd
     */
    public final String getPriceRegCd() {
        return priceRegCd;
    }

    /**
     * Sets the price reg cd.
     *
     * @param priceRegCd
     *            the new price reg cd
     */
    public final void setPriceRegCd(final String priceRegCd) {
        this.priceRegCd = priceRegCd;
    }

    /**
     * Gets the price dh prod reg id.
     *
     * @return the price dh prod reg id
     */
    public final String getPriceDhProdRegId() {
        return priceDhProdRegId;
    }

    /**
     * Sets the price dh prod reg id.
     *
     * @param priceDhProdRegId
     *            the new price dh prod reg id
     */
    public final void setPriceDhProdRegId(final String priceDhProdRegId) {
        this.priceDhProdRegId = priceDhProdRegId;
    }

    /**
     * Gets the price dh prod type cd.
     *
     * @return the price dh prod type cd
     */
    public final String getPriceDhProdTypeCd() {
        return priceDhProdTypeCd;
    }

    /**
     * Sets the price dh prod type cd.
     *
     * @param priceDhProdTypeCd
     *            the new price dh prod type cd
     */
    public final void setPriceDhProdTypeCd(final String priceDhProdTypeCd) {
        this.priceDhProdTypeCd = priceDhProdTypeCd;
    }

    /**
     * Gets the price start date.
     *
     * @return the price start date
     */
    public final String getPriceStartDate() {
        return priceStartDate;
    }

    /**
     * Sets the price start date.
     *
     * @param priceStartDate
     *            the new price start date
     */
    public final void setPriceStartDate(final String priceStartDate) {
        this.priceStartDate = priceStartDate;
    }

    /**
     * Gets the price last update date.
     *
     * @return the price last update date
     */
    public final String getPriceLastUpdateDate() {
        return priceLastUpdateDate;
    }

    /**
     * Sets the price last update date.
     *
     * @param priceLastUpdateDate
     *            the new price last update date
     */
    public final void setPriceLastUpdateDate(final String priceLastUpdateDate) {
        this.priceLastUpdateDate = priceLastUpdateDate;
    }

}
