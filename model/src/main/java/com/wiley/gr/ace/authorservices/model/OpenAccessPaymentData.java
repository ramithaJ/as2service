package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.TaxResponse;

@JsonInclude(Include.NON_NULL)
public class OpenAccessPaymentData {

	private ArticleData articleData;
	private Quote quote;
	private TaxResponse taxResponse;
	private Amount amountPayable;

	public final ArticleData getArticleData() {
		return articleData;
	}

	public final void setArticleData(final ArticleData articleData) {
		this.articleData = articleData;
	}

	public final Quote getQuote() {
		return quote;
	}

	public final void setQuote(final Quote quote) {
		this.quote = quote;
	}

	public final TaxResponse getTaxResponse() {
		return taxResponse;
	}

	public final void setTaxResponse(final TaxResponse taxResponse) {
		this.taxResponse = taxResponse;
	}

	public final Amount getAmountPayable() {
		return amountPayable;
	}

	public final void setAmountPayable(final Amount amountPayable) {
		this.amountPayable = amountPayable;
	}

}
