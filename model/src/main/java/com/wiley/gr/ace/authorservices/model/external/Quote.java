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
 * @author virtusa
 * version 1.0
 */
public class Quote {
 
    private String articlePublicationCharge;
    
    private String societyDiscount;
    
    private String societyDiscountValue;
    
    private String tax;
    
    private String dueAmount;

    public String getArticlePublicationCharge() {
        return articlePublicationCharge;
    }

    public void setArticlePublicationCharge(String articlePublicationCharge) {
        this.articlePublicationCharge = articlePublicationCharge;
    }

    public String getSocietyDiscount() {
        return societyDiscount;
    }

    public void setSocietyDiscount(String societyDiscount) {
        this.societyDiscount = societyDiscount;
    }

    public String getSocietyDiscountValue() {
        return societyDiscountValue;
    }

    public void setSocietyDiscountValue(String societyDiscountValue) {
        this.societyDiscountValue = societyDiscountValue;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(String dueAmount) {
        this.dueAmount = dueAmount;
    }
    
    
}
