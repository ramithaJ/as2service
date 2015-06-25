package com.wiley.gr.ace.authorservices.model;

/**
 * The Class QuoteData.
 */
public class QuoteData {

	/** The article pub charge. */
	private String articlePubCharge;
	
	/** The payment status. */
	private String paymentStatus;
	
	/** The quote status. */
	private String quoteStatus;
	
	/** The currency. */
	private String currency;

	/**
	 * Gets the article pub charge.
	 *
	 * @return the article pub charge
	 */
	public final String getArticlePubCharge() {
		return articlePubCharge;
	}

	/**
	 * Sets the article pub charge.
	 *
	 * @param articlePubCharge the new article pub charge
	 */
	public final void setArticlePubCharge(String articlePubCharge) {
		this.articlePubCharge = articlePubCharge;
	}

	/**
	 * Gets the payment status.
	 *
	 * @return the payment status
	 */
	public final String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * Sets the payment status.
	 *
	 * @param paymentStatus the new payment status
	 */
	public final void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * Gets the quote status.
	 *
	 * @return the quote status
	 */
	public final String getQuoteStatus() {
		return quoteStatus;
	}

	/**
	 * Sets the quote status.
	 *
	 * @param quoteStatus the new quote status
	 */
	public final void setQuoteStatus(String quoteStatus) {
		this.quoteStatus = quoteStatus;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public final String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public final void setCurrency(String currency) {
		this.currency = currency;
	}

}
