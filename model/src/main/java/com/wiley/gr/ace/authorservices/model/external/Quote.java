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
 * The Class Quote.
 *
 * @author virtusa version 1.0
 */
public class Quote {

    private String articlePubCharge;

    private String responseCode;

    private AddressOnFile addressOnFile;

    private String quoteType;

    private String responseDescription;

    private String paymentStatus;

    private String requestType;

    private String quoteStatus;

    private String articleID;

    private String currency;

    private Discount discount;

    /**
     * @return the articlePubCharge
     */
    public final String getArticlePubCharge() {
        return articlePubCharge;
    }

    /**
     * @param articlePubCharge the articlePubCharge to set
     */
    public final void setArticlePubCharge(String articlePubCharge) {
        this.articlePubCharge = articlePubCharge;
    }

    /**
     * @return the responseCode
     */
    public final String getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode the responseCode to set
     */
    public final void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return the addressOnFile
     */
    public final AddressOnFile getAddressOnFile() {
        return addressOnFile;
    }

    /**
     * @param addressOnFile the addressOnFile to set
     */
    public final void setAddressOnFile(AddressOnFile addressOnFile) {
        this.addressOnFile = addressOnFile;
    }

    /**
     * @return the quoteType
     */
    public final String getQuoteType() {
        return quoteType;
    }

    /**
     * @param quoteType the quoteType to set
     */
    public final void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }

    /**
     * @return the responseDescription
     */
    public final String getResponseDescription() {
        return responseDescription;
    }

    /**
     * @param responseDescription the responseDescription to set
     */
    public final void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    /**
     * @return the paymentStatus
     */
    public final String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * @param paymentStatus the paymentStatus to set
     */
    public final void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * @return the requestType
     */
    public final String getRequestType() {
        return requestType;
    }

    /**
     * @param requestType the requestType to set
     */
    public final void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * @return the quoteStatus
     */
    public final String getQuoteStatus() {
        return quoteStatus;
    }

    /**
     * @param quoteStatus the quoteStatus to set
     */
    public final void setQuoteStatus(String quoteStatus) {
        this.quoteStatus = quoteStatus;
    }

    /**
     * @return the articleID
     */
    public final String getArticleID() {
        return articleID;
    }

    /**
     * @param articleID the articleID to set
     */
    public final void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    /**
     * @return the currency
     */
    public final String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public final void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the discount
     */
    public final Discount getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public final void setDiscount(Discount discount) {
        this.discount = discount;
    }

    
}
