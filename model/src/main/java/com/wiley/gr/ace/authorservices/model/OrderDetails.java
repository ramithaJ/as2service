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

/**
 * The Class ViewAllOrders.
 */
public class OrderDetails {

    /** The status. */
    private String status;

    /** The Article id. */
    private String ArticleId;

    /** The order date. */
    private String orderDate;

    /** The Article title. */
    private String ArticleTitle;

    /** The price. */
    private String price;

    /**
     * the orderId.
     */
    private String orderId;

    private String orderType;

    public final String getOrderType() {
        return orderType;
    }

    public final void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     *            the orderId to set
     */
    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public final String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status
     *            the new status
     */
    public final void setStatus(final String status) {
        this.status = status;
    }

    /**
     * Gets the article id.
     *
     * @return the article id
     */
    public final String getArticleId() {
        return ArticleId;
    }

    /**
     * Sets the article id.
     *
     * @param articleId
     *            the new article id
     */
    public final void setArticleId(final String articleId) {
        ArticleId = articleId;
    }

    /**
     * Gets the order date.
     *
     * @return the order date
     */
    public final String getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the order date.
     *
     * @param orderDate
     *            the new order date
     */
    public final void setOrderDate(final String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the article title.
     *
     * @return the article title
     */
    public final String getArticleTitle() {
        return ArticleTitle;
    }

    /**
     * Sets the article title.
     *
     * @param articleTitle
     *            the new article title
     */
    public final void setArticleTitle(final String articleTitle) {
        ArticleTitle = articleTitle;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public final String getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price
     *            the new price
     */
    public final void setPrice(final String price) {
        this.price = price;
    }

}
