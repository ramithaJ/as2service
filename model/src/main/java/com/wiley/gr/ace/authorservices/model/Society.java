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
package com.wiley.gr.ace.authorservices.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author virtusa
 *	version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Society {
    
    /** The user Id . */
    
    private String userId;
    @NotNull
    @NotBlank
    private String societyId;
    @NotNull
    @NotBlank
    private String societyName;
    @NotNull
    @NotBlank
    private String membershipNumber;
    @NotNull
    @NotBlank
    private String promoCode;
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
    
    /**
     * Gets the user Id.
     *
     * @return the user Id
     */
    public String getUserId() {
        return userId;
    }
    
    /**
     * Sets the user Id.
     *
     * @return the user Id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    /**
     * @return
     */
    public String getSocietyId() {
        return societyId;
    }
    
    /**
     * @param societyId
     */
    public void setSocietyId(String societyId) {
        this.societyId = societyId;
    }
    
    /**
     * @return
     */
    public String getSocietyName() {
        return societyName;
    }
    
    /**
     * @param societyName
     */
    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }
    
    /**
     * @return
     */
    public String getMembershipNumber() {
        return membershipNumber;
    }
    
    /**
     * @param membershipNumber
     */
    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;
    }
    
    /**
     * @return
     */
    public String getPromoCode() {
        return promoCode;
    }
    
    /**
     * @param promoCode
     */
    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }
    
    /**
     * @return
     */
    public Date getStartDate() {
        return startDate;
    }
    
    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    /**
     * @return
     */
    public Date getEndDate() {
        return endDate;
    }
    
    /**
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
}
