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
 * The Class CreditCard.
 *
 * @author virtusa version 1.0
 */
public class CreditCard {

    /** The token for credit card. */
    private String tokenForCreditCard;

    /** The partial card number. */
    private String partialCardNumber;

    /** The card expiration date. */
    private String cardExpirationDate;

    /** The card type. */
    private String cardType;

    /** The card id. */
    private String cardId;

    /** The bank id. */
    private String bankId;

    /** The bank name. */
    private String bankName;

    /**
     * Gets the token for credit card.
     *
     * @return the token for credit card
     */
    public String getTokenForCreditCard() {
        return tokenForCreditCard;
    }

    /**
     * Sets the token for credit card.
     *
     * @param tokenForCreditCard
     *            the new token for credit card
     */
    public void setTokenForCreditCard(String tokenForCreditCard) {
        this.tokenForCreditCard = tokenForCreditCard;
    }

    /**
     * Gets the partial card number.
     *
     * @return the partial card number
     */
    public String getPartialCardNumber() {
        return partialCardNumber;
    }

    /**
     * Sets the partial card number.
     *
     * @param partialCardNumber
     *            the new partial card number
     */
    public void setPartialCardNumber(String partialCardNumber) {
        this.partialCardNumber = partialCardNumber;
    }

    /**
     * Gets the card expiration date.
     *
     * @return the card expiration date
     */
    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    /**
     * Sets the card expiration date.
     *
     * @param cardExpirationDate
     *            the new card expiration date
     */
    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    /**
     * Gets the card type.
     *
     * @return the card type
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * Sets the card type.
     *
     * @param cardType
     *            the new card type
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * Gets the card id.
     *
     * @return the card id
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * Sets the card id.
     *
     * @param cardId
     *            the new card id
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * Gets the bank id.
     *
     * @return the bank id
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * Sets the bank id.
     *
     * @param bankId
     *            the new bank id
     */
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    /**
     * Gets the bank name.
     *
     * @return the bank name
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the bank name.
     *
     * @param bankName
     *            the new bank name
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

}