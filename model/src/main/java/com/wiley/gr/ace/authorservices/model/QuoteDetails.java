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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author virtusa version1.0
 *
 */
@JsonInclude(Include.NON_NULL)
public class QuoteDetails {

    /**
     * This field holds the value of articleDetails
     */
    private ArticleDetails articleDetails;

    /**
     * This field holds the value of quoteDetail
     */
    private QuoteDetail quoteDetail;

    /**
     * This field holds the value of journalDetails
     */
    private JournalDetails journalDetails;

    /**
     * This field holds the value of authorName
     */
    private String authorName;

    /**
     * This field holds the value of addressDetails
     */
    private AddressDetails addressDetails;

    /**
     * This field holds the value of funderDetails
     */
    private List<FunderDetails> funderDetails;

    /**
     * This field holds the value of discountsAllowed
     */
    private String discountsAllowed;

    /**
     * This field holds the value of additionalDiscountAllowed
     */
    private String additionalDiscountAllowed;

    /**
     * @return the articleDetails
     */
    public final ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    /**
     * @param articleDetails
     *            the articleDetails to set
     */
    public final void setArticleDetails(final ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * @return the quoteDetail
     */
    public final QuoteDetail getQuoteDetail() {
        return quoteDetail;
    }

    /**
     * @param quoteDetail
     *            the quoteDetail to set
     */
    public final void setQuoteDetail(final QuoteDetail quoteDetail) {
        this.quoteDetail = quoteDetail;
    }

    /**
     * @return the journalDetails
     */
    public final JournalDetails getJournalDetails() {
        return journalDetails;
    }

    /**
     * @param journalDetails
     *            the journalDetails to set
     */
    public final void setJournalDetails(final JournalDetails journalDetails) {
        this.journalDetails = journalDetails;
    }

    /**
     * @return the authorName
     */
    public final String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName
     *            the authorName to set
     */
    public final void setAuthorName(final String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return the addressDetails
     */
    public final AddressDetails getAddressDetails() {
        return addressDetails;
    }

    /**
     * @param addressDetails
     *            the addressDetails to set
     */
    public final void setAddressDetails(final AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    /**
     * @return the funderDetails
     */
    public final List<FunderDetails> getFunderDetails() {
        return funderDetails;
    }

    /**
     * @param funderDetails
     *            the funderDetails to set
     */
    public final void setFunderDetails(final List<FunderDetails> funderDetails) {
        this.funderDetails = funderDetails;
    }

    /**
     * @return the discountsAllowed
     */
    public final String getDiscountsAllowed() {
        return discountsAllowed;
    }

    /**
     * @param discountsAllowed
     *            the discountsAllowed to set
     */
    public final void setDiscountsAllowed(final String discountsAllowed) {
        this.discountsAllowed = discountsAllowed;
    }

    /**
     * @return the additionalDiscountAllowed
     */
    public final String getAdditionalDiscountAllowed() {
        return additionalDiscountAllowed;
    }

    /**
     * @param additionalDiscountAllowed
     *            the additionalDiscountAllowed to set
     */
    public final void setAdditionalDiscountAllowed(
            final String additionalDiscountAllowed) {
        this.additionalDiscountAllowed = additionalDiscountAllowed;
    }

}
