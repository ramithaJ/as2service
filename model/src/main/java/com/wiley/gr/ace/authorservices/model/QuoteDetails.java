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
    private List<AddressDetails> addressDetails;
    
    /**
     * This field holds the value of funderDetails
     */
    private List<FunderDetails> funderDetails;

    /**
     * @return the articleDetails
     */
    public final ArticleDetails getArticleDetails() {
        return articleDetails;
    }

    /**
     * @param articleDetails the articleDetails to set
     */
    public final void setArticleDetails(ArticleDetails articleDetails) {
        this.articleDetails = articleDetails;
    }

    /**
     * @return the quoteDetail
     */
    public final QuoteDetail getQuoteDetail() {
        return quoteDetail;
    }

    /**
     * @param quoteDetail the quoteDetail to set
     */
    public final void setQuoteDetail(QuoteDetail quoteDetail) {
        this.quoteDetail = quoteDetail;
    }

    /**
     * @return the journalDetails
     */
    public final JournalDetails getJournalDetails() {
        return journalDetails;
    }

    /**
     * @param journalDetails the journalDetails to set
     */
    public final void setJournalDetails(JournalDetails journalDetails) {
        this.journalDetails = journalDetails;
    }

    /**
     * @return the authorName
     */
    public final String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public final void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

	/**
	 * @return
	 */
	public List<AddressDetails> getAddressDetails() {
		return addressDetails;
	}

	/**
	 * @param addressDetails
	 */
	public void setAddressDetails(List<AddressDetails> addressDetails) {
		this.addressDetails = addressDetails;
	}

	/**
	 * @return
	 */
	public List<FunderDetails> getFunderDetails() {
		return funderDetails;
	}

	/**
	 * @param funderDetails
	 */
	public void setFunderDetails(List<FunderDetails> funderDetails) {
		this.funderDetails = funderDetails;
	}

    
}
