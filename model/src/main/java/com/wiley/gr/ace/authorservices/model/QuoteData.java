package com.wiley.gr.ace.authorservices.model;

public class QuoteData {

	private String articlePubCharge;
	private String paymentStatus;
	private String quoteStatus;
	private String currency;

	public final String getArticlePubCharge() {
		return articlePubCharge;
	}

	public final void setArticlePubCharge(String articlePubCharge) {
		this.articlePubCharge = articlePubCharge;
	}

	public final String getPaymentStatus() {
		return paymentStatus;
	}

	public final void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public final String getQuoteStatus() {
		return quoteStatus;
	}

	public final void setQuoteStatus(String quoteStatus) {
		this.quoteStatus = quoteStatus;
	}

	public final String getCurrency() {
		return currency;
	}

	public final void setCurrency(String currency) {
		this.currency = currency;
	}

}
