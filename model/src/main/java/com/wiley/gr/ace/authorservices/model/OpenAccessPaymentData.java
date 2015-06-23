package com.wiley.gr.ace.authorservices.model;

import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.TaxResponse;

public class OpenAccessPaymentData {

	private ArticleData articleData;
	private Quote quote;
	private TaxResponse taxResponse;

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

}
