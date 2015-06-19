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

public class Discount {

    private String discountType;

    private String discountPercent;

    private String discountAmount;

    /**
     * @return the discountType
     */
    public final String getDiscountType() {
        return discountType;
    }

    /**
     * @param discountType the discountType to set
     */
    public final void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    /**
     * @return the discountPercent
     */
    public final String getDiscountPercent() {
        return discountPercent;
    }

    /**
     * @param discountPercent the discountPercent to set
     */
    public final void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    /**
     * @return the discountAmount
     */
    public final String getDiscountAmount() {
        return discountAmount;
    }

    /**
     * @param discountAmount the discountAmount to set
     */
    public final void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    
}
