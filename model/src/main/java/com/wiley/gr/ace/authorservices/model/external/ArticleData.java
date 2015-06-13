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

/**
 * @author yugandhark
 *
 */
public class ArticleData {

    private ArticleDetails articleDetails;

    private JournalDetails journalDetails;

    private String articleUserRole;

    private String licenseStatus;

    private OrderPaymentStatus orderPaymentStatus;

    private String productionStatus;

    public ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    public void setArticleDetails(ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    public JournalDetails getJournalDetails() {
        return journalDetails;
    }

    public void setJournalDetails(JournalDetails journalDetails) {
        this.journalDetails = journalDetails;
    }

    public String getArticleUserRole() {
        return articleUserRole;
    }

    public void setArticleUserRole(String articleUserRole) {
        this.articleUserRole = articleUserRole;
    }

    public String getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public OrderPaymentStatus getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(OrderPaymentStatus orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    public String getProductionStatus() {
        return productionStatus;
    }

    public void setProductionStatus(String productionStatus) {
        this.productionStatus = productionStatus;
    }
}
