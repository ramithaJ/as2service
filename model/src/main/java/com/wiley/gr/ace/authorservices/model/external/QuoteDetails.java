package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

public class QuoteDetails {

	private String quoteType;
	private List<PriceObject> articlePublicationCharge;
	private String discount;
	private String tax;
	private List<PriceObject> finalAmount;

	public final String getQuoteType() {
		return quoteType;
	}

	public final void setQuoteType(final String quoteType) {
		this.quoteType = quoteType;
	}

	public final List<PriceObject> getArticlePublicationCharge() {
		return articlePublicationCharge;
	}

	public final void setArticlePublicationCharge(
			final List<PriceObject> articlePublicationCharge) {
		this.articlePublicationCharge = articlePublicationCharge;
	}

	public final String getDiscount() {
		return discount;
	}

	public final void setDiscount(final String discount) {
		this.discount = discount;
	}

	public final String getTax() {
		return tax;
	}

	public final void setTax(final String tax) {
		this.tax = tax;
	}

	public final List<PriceObject> getFinalAmount() {
		return finalAmount;
	}

	public final void setFinalAmount(final List<PriceObject> finalAmount) {
		this.finalAmount = finalAmount;
	}
}
