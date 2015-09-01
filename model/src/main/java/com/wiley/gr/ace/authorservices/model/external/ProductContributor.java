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
 * The Class ProductContributor.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PRODUCT_CONTRIBUTOR")
public class ProductContributor {

    /** The dh role type id. */
    @XmlElement(name = "DH_ROLETYPE_ID")
    private String dhRoleTypeId;

    /** The dh prod type id. */
    @XmlElement(name = "DH_PRODTYPE_ID")
    private String dhProdTypeId;

    /** The dh prod id. */
    @XmlElement(name = "DH_PROD_ID")
    private String dhProdId;

    /** The email addr. */
    @XmlElement(name = "EMAIL_ADDR")
    private String emailAddr;

    /** The doc type. */
    @XmlElement(name = "doc_type")
    private String docType;

    /** The dh reg id. */
    @XmlElement(name = "DH_REG_ID")
    private String dhRegId;

    /** The last name. */
    @XmlElement(name = "LAST_NAME")
    private String lastName;

    /** The reg desc. */
    @XmlElement(name = "REG_DESC")
    private String regDesc;

    /** The id. */
    @XmlElement(name = "id")
    private String id;

    /** The dh contrib id. */
    @XmlElement(name = "DH_CONTRIB_ID")
    private String dhContribId;

    /** The first name. */
    @XmlElement(name = "FIRST_NAME")
    private String firstName;

    /** The dh id. */
    @XmlElement(name = "DH_ID")
    private String dhId;

    /** The reg cd. */
    @XmlElement(name = "REG_CD")
    private String regCd;

    /** The dh prod reg id. */
    @XmlElement(name = "DH_PRODREG_ID")
    private String dhProdRegId;

    /** The dh prod type cd. */
    @XmlElement(name = "DH_PRODTYPE_CD")
    private String dhProdTypeCd;

    /** The dh role type cd. */
    @XmlElement(name = "DH_ROLETYPE_CD")
    private String dhRoleTypeCd;

    /** The last updated date. */
    @XmlElement(name = "LAST_UPDATE_DATE")
    private String lastUpdatedDate;

    /**
     * Gets the dh role type id.
     *
     * @return the dh role type id
     */
    public final String getDhRoleTypeId() {
        return dhRoleTypeId;
    }

    /**
     * Sets the dh role type id.
     *
     * @param dhRoleTypeId
     *            the new dh role type id
     */
    public final void setDhRoleTypeId(final String dhRoleTypeId) {
        this.dhRoleTypeId = dhRoleTypeId;
    }

    /**
     * Gets the dh prod type id.
     *
     * @return the dh prod type id
     */
    public final String getDhProdTypeId() {
        return dhProdTypeId;
    }

    /**
     * Sets the dh prod type id.
     *
     * @param dhProdTypeId
     *            the new dh prod type id
     */
    public final void setDhProdTypeId(final String dhProdTypeId) {
        this.dhProdTypeId = dhProdTypeId;
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
     * Gets the email addr.
     *
     * @return the email addr
     */
    public final String getEmailAddr() {
        return emailAddr;
    }

    /**
     * Sets the email addr.
     *
     * @param emailAddr
     *            the new email addr
     */
    public final void setEmailAddr(final String emailAddr) {
        this.emailAddr = emailAddr;
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
     * Gets the last name.
     *
     * @return the last name
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the new last name
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
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
     * Gets the dh contrib id.
     *
     * @return the dh contrib id
     */
    public final String getDhContribId() {
        return dhContribId;
    }

    /**
     * Sets the dh contrib id.
     *
     * @param dhContribId
     *            the new dh contrib id
     */
    public final void setDhContribId(final String dhContribId) {
        this.dhContribId = dhContribId;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the new first name
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
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
     * Gets the dh role type cd.
     *
     * @return the dh role type cd
     */
    public final String getDhRoleTypeCd() {
        return dhRoleTypeCd;
    }

    /**
     * Sets the dh role type cd.
     *
     * @param dhRoleTypeCd
     *            the new dh role type cd
     */
    public final void setDhRoleTypeCd(final String dhRoleTypeCd) {
        this.dhRoleTypeCd = dhRoleTypeCd;
    }

    /**
     * Gets the last updated date.
     *
     * @return the last updated date
     */
    public final String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    /**
     * Sets the last updated date.
     *
     * @param lastUpdatedDate
     *            the new last updated date
     */
    public final void setLastUpdatedDate(final String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

}
