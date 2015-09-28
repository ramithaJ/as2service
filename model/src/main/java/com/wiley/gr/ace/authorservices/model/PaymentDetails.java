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
package com.wiley.gr.ace.authorservices.model;

import java.util.Date;

public class PaymentDetails {

    /**
     * This field holds the value of operation
     */
    private String operation;

    /**
     * This field holds the value of returnCode
     */
    private Integer returnCode;

    /**
     * This field holds the value of returnMessage
     */
    private String returnMessage;

    /**
     * This field holds the value of vendorId
     */
    private Integer vendorId;

    /**
     * This field holds the value of transId
     */
    private Integer transId;

    /**
     * This field holds the value of merchantResponse
     */
    private String merchantResponse;

    /**
     * This field holds the value of merchantId
     */
    private Integer merchantId;

    /**
     * This field holds the value of cscResult
     */
    private Character cscResult;

    /**
     * This field holds the value of avsAddressResult
     */
    private Character avsAddressResult;

    /**
     * This field holds the value of avsPostResult
     */
    private Character avsPostResult;

    /**
     * This field holds the value of token
     */
    private String token;

    /**
     * This field holds the value of acquirerId
     */
    private Character acquirerId;

    /**
     * This field holds the value of acquirerBank
     */
    private String acquirerBank;

    /**
     * This field holds the value of bankId
     */
    private Character bankId;

    /**
     * This field holds the value of bankName
     */
    private String bankName;

    /**
     * This field holds the value of maskedCardNumber
     */
    private String maskedCardNumber;

    /**
     * This field holds the value of cardExpiry
     */
    private Integer cardExpiry;

    /**
     * This field holds the value of transTimeStamp
     */
    private Date transTimeStamp;

    /**
     * This field holds the value of security
     */
    private String security;

    /**
     * @return the operation
     */
    public final String getOperation() {
        return operation;
    }

    /**
     * @param operation
     *            the operation to set
     */
    public final void setOperation(final String operation) {
        this.operation = operation;
    }

    /**
     * @return the returnCode
     */
    public final Integer getReturnCode() {
        return returnCode;
    }

    /**
     * @param returnCode
     *            the returnCode to set
     */
    public final void setReturnCode(final Integer returnCode) {
        this.returnCode = returnCode;
    }

    /**
     * @return the returnMessage
     */
    public final String getReturnMessage() {
        return returnMessage;
    }

    /**
     * @param returnMessage
     *            the returnMessage to set
     */
    public final void setReturnMessage(final String returnMessage) {
        this.returnMessage = returnMessage;
    }

    /**
     * @return the vendorId
     */
    public final Integer getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId
     *            the vendorId to set
     */
    public final void setVendorId(final Integer vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * @return the transId
     */
    public final Integer getTransId() {
        return transId;
    }

    /**
     * @param transId
     *            the transId to set
     */
    public final void setTransId(final Integer transId) {
        this.transId = transId;
    }

    /**
     * @return the merchantResponse
     */
    public final String getMerchantResponse() {
        return merchantResponse;
    }

    /**
     * @param merchantResponse
     *            the merchantResponse to set
     */
    public final void setMerchantResponse(final String merchantResponse) {
        this.merchantResponse = merchantResponse;
    }

    /**
     * @return the merchantId
     */
    public final Integer getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId
     *            the merchantId to set
     */
    public final void setMerchantId(final Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return the cscResult
     */
    public final Character getCscResult() {
        return cscResult;
    }

    /**
     * @param cscResult
     *            the cscResult to set
     */
    public final void setCscResult(final Character cscResult) {
        this.cscResult = cscResult;
    }

    /**
     * @return the avsAddressResult
     */
    public final Character getAvsAddressResult() {
        return avsAddressResult;
    }

    /**
     * @param avsAddressResult
     *            the avsAddressResult to set
     */
    public final void setAvsAddressResult(final Character avsAddressResult) {
        this.avsAddressResult = avsAddressResult;
    }

    /**
     * @return the avsPostResult
     */
    public final Character getAvsPostResult() {
        return avsPostResult;
    }

    /**
     * @param avsPostResult
     *            the avsPostResult to set
     */
    public final void setAvsPostResult(final Character avsPostResult) {
        this.avsPostResult = avsPostResult;
    }

    /**
     * @return the token
     */
    public final String getToken() {
        return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public final void setToken(final String token) {
        this.token = token;
    }

    /**
     * @return the acquirerId
     */
    public final Character getAcquirerId() {
        return acquirerId;
    }

    /**
     * @param acquirerId
     *            the acquirerId to set
     */
    public final void setAcquirerId(final Character acquirerId) {
        this.acquirerId = acquirerId;
    }

    /**
     * @return the acquirerBank
     */
    public final String getAcquirerBank() {
        return acquirerBank;
    }

    /**
     * @param acquirerBank
     *            the acquirerBank to set
     */
    public final void setAcquirerBank(final String acquirerBank) {
        this.acquirerBank = acquirerBank;
    }

    /**
     * @return the bankId
     */
    public final Character getBankId() {
        return bankId;
    }

    /**
     * @param bankId
     *            the bankId to set
     */
    public final void setBankId(final Character bankId) {
        this.bankId = bankId;
    }

    /**
     * @return the bankName
     */
    public final String getBankName() {
        return bankName;
    }

    /**
     * @param bankName
     *            the bankName to set
     */
    public final void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return the maskedCardNumber
     */
    public final String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    /**
     * @param maskedCardNumber
     *            the maskedCardNumber to set
     */
    public final void setMaskedCardNumber(final String maskedCardNumber) {
        this.maskedCardNumber = maskedCardNumber;
    }

    /**
     * @return the cardExpiry
     */
    public final Integer getCardExpiry() {
        return cardExpiry;
    }

    /**
     * @param cardExpiry
     *            the cardExpiry to set
     */
    public final void setCardExpiry(final Integer cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    /**
     * @return the transTimeStamp
     */
    public final Date getTransTimeStamp() {
        return transTimeStamp;
    }

    /**
     * @param transTimeStamp
     *            the transTimeStamp to set
     */
    public final void setTransTimeStamp(final Date transTimeStamp) {
        this.transTimeStamp = transTimeStamp;
    }

    /**
     * @return the security
     */
    public final String getSecurity() {
        return security;
    }

    /**
     * @param security
     *            the security to set
     */
    public final void setSecurity(final String security) {
        this.security = security;
    }

}
