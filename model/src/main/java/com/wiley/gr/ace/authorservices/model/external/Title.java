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
 * The Class Title.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "TITLE")
public class Title {

    /** The title dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String titleDhProdId;

    /** The title doc type. */
    @XmlElement(name = "doc_type")
    private String titleDocType;

    /** The title dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String titleDhRegId;

    /** The title reg desc. */
    @XmlElement(name = "REG_DESC")
    private String titleRegDesc;

    /** The title text. */
    @XmlElement(name = "TITLE_TEXT")
    private String titleText;

    /** The title id. */
    @XmlElement(name = "id")
    private String titleId;

    /** The dh title type cd. */
    @XmlElement(name = "DH_TITLE_TYPE_CD")
    private String dhTitleTypeCd;

    /** The title dh id. */
    @XmlElement(name = "DH_ID")
    private String titleDhId;

    /** The title reg cd. */
    @XmlElement(name = "REG_CD")
    private String titleRegCd;

    /** The title dh prod reg id. */
    @XmlElement(name = "DH_PRODREG_ID")
    private String titleDhProdRegId;

    /** The title dh prod type cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String titleDhProdTypeCd;

    /** The title last update date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String titleLastUpdateDate;

    /** The primary ind. */
    @XmlElement(name = "PRIMARY_IND")
    private String primaryInd;

    /**
     * Gets the title dh prod id.
     *
     * @return the title dh prod id
     */
    public final String getTitleDhProdId() {
        return titleDhProdId;
    }

    /**
     * Sets the title dh prod id.
     *
     * @param titleDhProdId
     *            the new title dh prod id
     */
    public final void setTitleDhProdId(final String titleDhProdId) {
        this.titleDhProdId = titleDhProdId;
    }

    /**
     * Gets the title doc type.
     *
     * @return the title doc type
     */
    public final String getTitleDocType() {
        return titleDocType;
    }

    /**
     * Sets the title doc type.
     *
     * @param titleDocType
     *            the new title doc type
     */
    public final void setTitleDocType(final String titleDocType) {
        this.titleDocType = titleDocType;
    }

    /**
     * Gets the title dh reg id.
     *
     * @return the title dh reg id
     */
    public final String getTitleDhRegId() {
        return titleDhRegId;
    }

    /**
     * Sets the title dh reg id.
     *
     * @param titleDhRegId
     *            the new title dh reg id
     */
    public final void setTitleDhRegId(final String titleDhRegId) {
        this.titleDhRegId = titleDhRegId;
    }

    /**
     * Gets the title reg desc.
     *
     * @return the title reg desc
     */
    public final String getTitleRegDesc() {
        return titleRegDesc;
    }

    /**
     * Sets the title reg desc.
     *
     * @param titleRegDesc
     *            the new title reg desc
     */
    public final void setTitleRegDesc(final String titleRegDesc) {
        this.titleRegDesc = titleRegDesc;
    }

    /**
     * Gets the title text.
     *
     * @return the title text
     */
    public final String getTitleText() {
        return titleText;
    }

    /**
     * Sets the title text.
     *
     * @param titleText
     *            the new title text
     */
    public final void setTitleText(final String titleText) {
        this.titleText = titleText;
    }

    /**
     * Gets the title id.
     *
     * @return the title id
     */
    public final String getTitleId() {
        return titleId;
    }

    /**
     * Sets the title id.
     *
     * @param titleId
     *            the new title id
     */
    public final void setTitleId(final String titleId) {
        this.titleId = titleId;
    }

    /**
     * Gets the dh title type cd.
     *
     * @return the dh title type cd
     */
    public final String getDhTitleTypeCd() {
        return dhTitleTypeCd;
    }

    /**
     * Sets the dh title type cd.
     *
     * @param dhTitleTypeCd
     *            the new dh title type cd
     */
    public final void setDhTitleTypeCd(final String dhTitleTypeCd) {
        this.dhTitleTypeCd = dhTitleTypeCd;
    }

    /**
     * Gets the title dh id.
     *
     * @return the title dh id
     */
    public final String getTitleDhId() {
        return titleDhId;
    }

    /**
     * Sets the title dh id.
     *
     * @param titleDhId
     *            the new title dh id
     */
    public final void setTitleDhId(final String titleDhId) {
        this.titleDhId = titleDhId;
    }

    /**
     * Gets the title reg cd.
     *
     * @return the title reg cd
     */
    public final String getTitleRegCd() {
        return titleRegCd;
    }

    /**
     * Sets the title reg cd.
     *
     * @param titleRegCd
     *            the new title reg cd
     */
    public final void setTitleRegCd(final String titleRegCd) {
        this.titleRegCd = titleRegCd;
    }

    /**
     * Gets the title dh prod reg id.
     *
     * @return the title dh prod reg id
     */
    public final String getTitleDhProdRegId() {
        return titleDhProdRegId;
    }

    /**
     * Sets the title dh prod reg id.
     *
     * @param titleDhProdRegId
     *            the new title dh prod reg id
     */
    public final void setTitleDhProdRegId(final String titleDhProdRegId) {
        this.titleDhProdRegId = titleDhProdRegId;
    }

    /**
     * Gets the title dh prod type cd.
     *
     * @return the title dh prod type cd
     */
    public final String getTitleDhProdTypeCd() {
        return titleDhProdTypeCd;
    }

    /**
     * Sets the title dh prod type cd.
     *
     * @param titleDhProdTypeCd
     *            the new title dh prod type cd
     */
    public final void setTitleDhProdTypeCd(final String titleDhProdTypeCd) {
        this.titleDhProdTypeCd = titleDhProdTypeCd;
    }

    /**
     * Gets the title last update date.
     *
     * @return the title last update date
     */
    public final String getTitleLastUpdateDate() {
        return titleLastUpdateDate;
    }

    /**
     * Sets the title last update date.
     *
     * @param titleLastUpdateDate
     *            the new title last update date
     */
    public final void setTitleLastUpdateDate(final String titleLastUpdateDate) {
        this.titleLastUpdateDate = titleLastUpdateDate;
    }

    /**
     * Gets the primary ind.
     *
     * @return the primary ind
     */
    public final String getPrimaryInd() {
        return primaryInd;
    }

    /**
     * Sets the primary ind.
     *
     * @param primaryInd
     *            the new primary ind
     */
    public final void setPrimaryInd(final String primaryInd) {
        this.primaryInd = primaryInd;
    }

}
