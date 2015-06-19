/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class Discount.
 *
 * @author virtusa version 1.0
 */
public class DiscountData {

    /** The institution id. */
    private String institutionId;

    /** The society id. */
    private String societyId;

    /** The other discounts. */
    private String otherDiscounts;

    /** The promo code. */
    private String promoCode;

    public final String getInstitutionId() {
        return institutionId;
    }

    public final void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public final String getSocietyId() {
        return societyId;
    }

    public final void setSocietyId(String societyId) {
        this.societyId = societyId;
    }

    public final String getOtherDiscounts() {
        return otherDiscounts;
    }

    public final void setOtherDiscounts(String otherDiscounts) {
        this.otherDiscounts = otherDiscounts;
    }

    public final String getPromoCode() {
        return promoCode;
    }

    public final void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

}
