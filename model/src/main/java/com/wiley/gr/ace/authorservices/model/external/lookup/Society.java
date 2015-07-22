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
package com.wiley.gr.ace.authorservices.model.external.lookup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author yugandhark
 *
 */
public class Society {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("SocietyName")
    private String societyName;

    @JsonProperty("StartDate")
    private String startDate;

    @JsonProperty("EndDate")
    private String endDate;

    @JsonProperty("PromoCode")
    private String promoCode;

    @JsonProperty("MembershipNo")
    private String membershipNo;

    @JsonProperty("SocietyID")
    private String societyId;

    @JsonProperty("Status")
    private String status;

    public final String getId() {
        return id;
    }

    public final void setId(final String id) {
        this.id = id;
    }

    public final String getSocietyName() {
        return societyName;
    }

    public final void setSocietyName(final String societyName) {
        this.societyName = societyName;
    }

    public final String getStartDate() {
        return startDate;
    }

    public final void setStartDate(final String startDate) {
        this.startDate = startDate;
    }

    public final String getEndDate() {
        return endDate;
    }

    public final void setEndDate(final String endDate) {
        this.endDate = endDate;
    }

    public final String getPromoCode() {
        return promoCode;
    }

    public final void setPromoCode(final String promoCode) {
        this.promoCode = promoCode;
    }

    public final String getMembershipNo() {
        return membershipNo;
    }

    public final void setMembershipNo(final String membershipNo) {
        this.membershipNo = membershipNo;
    }

    public final String getSocietyId() {
        return societyId;
    }

    public final void setSocietyId(final String societyId) {
        this.societyId = societyId;
    }

    public final String getStatus() {
        return status;
    }

    public final void setStatus(final String status) {
        this.status = status;
    }

}
