package com.wiley.gr.ace.authorservices.model;

import com.wiley.gr.ace.authorservices.model.external.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.external.JournalDetails;
import com.wiley.gr.ace.authorservices.model.external.QuoteDetails;

public class OpenAccessPaymentData {

	private ArticleDetails articleDetails;
	private JournalDetails journalDetails;
	private QuoteDetails quoteDetails;
	private Address billingAddressOnFile;
	private TaxDetails taxDetails;

	public final ArticleDetails getArticleDetails() {
		return articleDetails;
	}

	public final void setArticleDetails(final ArticleDetails articleDetails) {
		this.articleDetails = articleDetails;
	}

	public final JournalDetails getJournalDetails() {
		return journalDetails;
	}

	public final void setJournalDetails(final JournalDetails journalDetails) {
		this.journalDetails = journalDetails;
	}

	public final QuoteDetails getQuoteDetails() {
		return quoteDetails;
	}

	public final void setQuoteDetails(final QuoteDetails quoteDetails) {
		this.quoteDetails = quoteDetails;
	}

	public final Address getBillingAddressOnFile() {
		return billingAddressOnFile;
	}

	public final void setBillingAddressOnFile(final Address billingAddressOnFile) {
		this.billingAddressOnFile = billingAddressOnFile;
	}

	public final TaxDetails getTaxDetails() {
		return taxDetails;
	}

	public final void setTaxDetails(final TaxDetails taxDetails) {
		this.taxDetails = taxDetails;
	}
}
