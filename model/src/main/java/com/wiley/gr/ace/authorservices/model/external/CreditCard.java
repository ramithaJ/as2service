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
public class CreditCard {
    
    private String tokenForCreditCard;
    
    private String partialCardNumber;
    
    private String cardExpirationDate;
    
    private String cardType;
    
    private String cardId;
    
    private String bankId;
    
    private String bankName;

    public String getTokenForCreditCard() {
        return tokenForCreditCard;
    }

    public void setTokenForCreditCard(String tokenForCreditCard) {
        this.tokenForCreditCard = tokenForCreditCard;
    }

    public String getPartialCardNumber() {
        return partialCardNumber;
    }

    public void setPartialCardNumber(String partialCardNumber) {
        this.partialCardNumber = partialCardNumber;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    
    
}