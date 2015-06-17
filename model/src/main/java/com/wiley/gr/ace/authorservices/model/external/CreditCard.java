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

    /**
     * @return the tokenForCreditCard
     */
    public final String getTokenForCreditCard() {
        return tokenForCreditCard;
    }

    /**
     * @param tokenForCreditCard
     *            the tokenForCreditCard to set
     */
    public final void setTokenForCreditCard(final String tokenForCreditCard) {
        this.tokenForCreditCard = tokenForCreditCard;
    }

    /**
     * @return the partialCardNumber
     */
    public final String getPartialCardNumber() {
        return partialCardNumber;
    }

    /**
     * @param partialCardNumber
     *            the partialCardNumber to set
     */
    public final void setPartialCardNumber(final String partialCardNumber) {
        this.partialCardNumber = partialCardNumber;
    }

    /**
     * @return the cardExpirationDate
     */
    public final String getCardExpirationDate() {
        return cardExpirationDate;
    }

    /**
     * @param cardExpirationDate
     *            the cardExpirationDate to set
     */
    public final void setCardExpirationDate(final String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    /**
     * @return the cardType
     */
    public final String getCardType() {
        return cardType;
    }

    /**
     * @param cardType
     *            the cardType to set
     */
    public final void setCardType(final String cardType) {
        this.cardType = cardType;
    }

    /**
     * @return the cardId
     */
    public final String getCardId() {
        return cardId;
    }

    /**
     * @param cardId
     *            the cardId to set
     */
    public final void setCardId(final String cardId) {
        this.cardId = cardId;
    }

    /**
     * @return the bankId
     */
    public final String getBankId() {
        return bankId;
    }

    /**
     * @param bankId
     *            the bankId to set
     */
    public final void setBankId(final String bankId) {
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

    /** The bank name. */
    private String bankName;

}
